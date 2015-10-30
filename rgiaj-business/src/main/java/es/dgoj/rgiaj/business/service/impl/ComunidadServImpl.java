package es.dgoj.rgiaj.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeveris.core.reporting.ReportFactoryBean;
import com.jeveris.reporting.jasper.JRDatasourceReportFillManagerHelper;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.CertificadoReport;
import es.dgoj.rgiaj.business.beans.ComunidadBean;
import es.dgoj.rgiaj.business.beans.ComunidadBeanReport;
import es.dgoj.rgiaj.business.beans.ComunidadCertificadoBean;
import es.dgoj.rgiaj.business.beans.ComunidadQueryBean;
import es.dgoj.rgiaj.business.beans.ComunidadSearchResult;
import es.dgoj.rgiaj.business.beans.UsuarioComunidadBean;
import es.dgoj.rgiaj.business.beans.UsuarioReport;
import es.dgoj.rgiaj.business.exceptions.JuegoExternoException;
import es.dgoj.rgiaj.business.model.JugComunidad;
import es.dgoj.rgiaj.business.model.JugComunidadCertificado;
import es.dgoj.rgiaj.business.model.JugComunidadCertificadoPK;
import es.dgoj.rgiaj.business.model.JugUsuariocomunidad;
import es.dgoj.rgiaj.business.repository.IComunidadRepository;
import es.dgoj.rgiaj.business.repository.IUsuarioComunidadRepository;
import es.dgoj.rgiaj.business.service.IComunidadServ;
import es.dgoj.rgiaj.business.util.UtilBusiness;
import es.dgoj.rgiaj.business.util.UtilidadCertificados;

/**
 * @author ylopezconnectis
 *
 */
@Service("comunidadService")
public class ComunidadServImpl  implements IComunidadServ {

	
	@Autowired
	private IComunidadRepository<JugComunidadCertificado, JugComunidadCertificadoPK> comunidadRepository;
	
	@Autowired
	private IUsuarioComunidadRepository<JugUsuariocomunidad, Long> usuarioComunidadRepository;
	
	/**
	 * Interfaz de catalogo de Servicios de reporting.
	 */
	@Autowired
	private ReportFactoryBean reportListDatasourceRunner;
	
	private static final Logger log = LoggerFactory.getLogger(ComunidadServImpl.class);  
	
	/** (non-Javadoc)
	 * @see es.dgoj.rgiaj.business.service.IComunidadService#getCertificadoComunidad(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
	 */
	@Override
	public ComunidadSearchResult getCertificadoComunidad(ComunidadQueryBean query) {
		// TODO Auto-generated method stub
		SearchResults<JugComunidadCertificado> search = comunidadRepository.getListComunidadCertificado(query);
		
		ComunidadSearchResult result= new ComunidadSearchResult();
		
		List<JugComunidadCertificado> list= search.getResults();
		List<ComunidadBean> listResult=new ArrayList<ComunidadBean>();
		if(list!=null)
			for (JugComunidadCertificado entity : list) 
				listResult.add( ComunidadCertificadoBean.getBean(entity));
			
		result.setNumResults(search.getTotal());	
		result.setResults(listResult);
			
		return result;
	}
	
	
	/* (non-Javadoc)
	 * @see es.dgoj.rgiaj.business.service.IComunidadService#addCertificadoComunidad(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
	 */
	@Transactional
	public void addCertificadoComunidad(ComunidadQueryBean query) throws JuegoExternoException{
		
		if(query.getCertificado()!=null){
			try {
				 query.setHashCertificado(UtilidadCertificados.calcularHashCertificado(query.getCertificado())) ;
				 query.setFingerSha1(UtilidadCertificados.getFingerPrint(query.getCertificado()));
				 query.setFechaDesde(UtilidadCertificados.getFechaInicialValidez(query.getCertificado()));
				 query.setFechaHasta(UtilidadCertificados.getFechaFinalValidez(query.getCertificado()));
			} catch (Exception e) {
				log.error("Error intentando extraer informacion del certificado" + e);
				throw new JuegoExternoException(e);
			}
			
			 
			 if(query.getIndActivo()!=null && query.getIndActivo().equals(1))
					validateAndChange(query);	
			 
			 log.debug("Guardando certificado con Hash " + query.getHashCertificado());
			 comunidadRepository.addComunidadCertificado(query);
		  }
		}
		
		/** Edita el certificado asociado a la comunidad. Si viene como activo se pone como activo el mismo y se quita como activo el otro que estaba.
		 * @see es.dgoj.rgiaj.business.service.IComunidadService#updateCertificadoComunidad(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
		 */
		@Transactional
		public void updateCertificadoComunidad(ComunidadQueryBean query){ 
			if(query.getHashCertificado()!=null){
				 if(query.getIndActivo()!=null && query.getIndActivo().equals(1))
					validateAndChange(query);				
		    
		    log.debug("Guardando certificado con Hash " + query.getHashCertificado());	  
			comunidadRepository.updateComunidadCertificado(query);
				   
		    }
		
		}


		/** Busca si el certificado que se intenta poner como activo es el mismo. Sino es el mismo de la query lo quita como activo
		 * @param query
		 */
		private void validateAndChange(ComunidadQueryBean query) {
			JugComunidadCertificado certActivo=getCertificadoActivo(query);
			  if(certActivo!=null){
				  if(!certActivo.getHashCertificado().equals(query.getHashCertificado())){
					  certActivo.setIndActivo(new Integer(0));
					  comunidadRepository.update(certActivo);
				  }					
			  }
		}
		
		
		/** Elimina un certificado asociado a una comunidad sino se encuentra activo
		 * @see es.dgoj.rgiaj.business.service.IComunidadService#removeCertificadoComunidad(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
		 */
		@Transactional
		public void removeCertificadoComunidad(ComunidadQueryBean query){ 
			if(query.getHashCertificado()!=null && query.getIdComunidad()!=null){
				  if(!isCertificadoActivo(query)){
					  JugComunidadCertificado entity= getCertificadobyHash(query);
					  comunidadRepository.remove(entity);  
				  }
				   
		    }
		
		}



	/** Devuelve el certificado activo por la comunidad
	 * @see es.dgoj.rgiaj.business.service.IComunidadService#existCertificadoActivoComunidad(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
	 */
	public ComunidadCertificadoBean getCertificadoActivoComunidad(ComunidadQueryBean query) {
		if(query.getIdComunidad()!=null){
			JugComunidadCertificado entity= comunidadRepository.getCertificadoActivoComunidad(query);
     		if(entity!=null) 
     			return ComunidadCertificadoBean.getBean(entity); 
		}
			return null;
		}

	
	
	/** Devuelve si un certificado esta activo en en la Comunidad
	 * @see es.dgoj.rgiaj.business.service.IComunidadService#isCertificadoActivo(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
	 */
	public boolean isCertificadoActivo(ComunidadQueryBean query){
		if(query.getHashCertificado()!=null){
			JugComunidadCertificado entity= comunidadRepository.getCertificadoByHashComunidad(query);
			if(entity.getIndActivo()==1) 
				return true;
		}
		return false;
	}
	
	
	
	/** Devuelve el certificado activo de la comunidad
	 * @see es.dgoj.rgiaj.business.service.IComunidadService#existCertificadoActivoComunidad(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
	 */
	private JugComunidadCertificado getCertificadoActivo(ComunidadQueryBean query) {
		if(query.getIdComunidad()!=null)
			return comunidadRepository.getCertificadoActivoComunidad(query);
		return null;
		}

	
	
	/**
	 * @param query
	 * @return
	 */
	private JugComunidadCertificado getCertificadobyHash(ComunidadQueryBean query){
		if(query.getHashCertificado()!=null){
			JugComunidadCertificado entity= comunidadRepository.getCertificadoByHashComunidad(query);
			return entity;
		}
		return null;
	}


	
	
	@Override
	public List<ComunidadBean> getComunidadList() {
		// TODO Auto-generated method stub
		List<ComunidadBean> result=new ArrayList<ComunidadBean>();
		
		List<JugComunidad> list= comunidadRepository.getComunidadList();
		for (JugComunidad entiry : list) 
             		result.add(new ComunidadBean(entiry.getId(), entiry.getCodigo(), entiry.getDescripcion()));	
		
		return result;
	}
	
	
	@Override
	public List<ComunidadBean> getComunidadListWithOutNAC() {
		// TODO Auto-generated method stub
		List<ComunidadBean> result=new ArrayList<ComunidadBean>();
		
		List<JugComunidad> list= comunidadRepository.getComunidadList();
		for (JugComunidad entiry : list) 
			      if(!entiry.getCodigo().equalsIgnoreCase("NAC"))
             		 result.add(new ComunidadBean(entiry.getId(), entiry.getCodigo(), entiry.getDescripcion()));	
		
		return result;
	}
	
	/** Calcula si existe otro certificado activo en la comunidad distinto del que se le pasa
	 * @param query
	 * @return
	 */
	public boolean existOtrotCertificadoActivoComunidad(ComunidadQueryBean query){
         	if(query.getIndActivo()!=null && query.getIndActivo().equals(1)){
         		String hash=null;
         		if(query.getHashCertificado()!=null)
         			hash=query.getHashCertificado();
         		else hash=UtilidadCertificados.calcularHashCertificado(query.getCertificado()) ;
         		
         		JugComunidadCertificado entity= comunidadRepository.getCertificadoActivoComunidad(query);
         		if(entity!=null && !entity.getHashCertificado().equals(hash)) return true; 
         	}
         	return false;
         		
	}
	
	/** Calcula si existe el certificado
	 * @see es.dgoj.rgiaj.business.service.IComunidadService#existCertificadoComunidad(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
	 */
	public boolean existCertificadoComunidad(ComunidadQueryBean query){
     		String hash=null;
     		if(query.getHashCertificado()!=null)
     			hash=query.getHashCertificado();
     		else hash=UtilidadCertificados.calcularHashCertificado(query.getCertificado()) ;
     		query.setHashCertificado(hash);
     		
     		JugComunidadCertificado entity= comunidadRepository.getCertificadoByHashComunidad(query);
     		if(entity!=null) return true; 
     	return false;
     		
}
	
	/** Calcula si existe el certificado activo en otra comunidad
	 * @param query
	 * @return
	 */
	public boolean existCertificadoActivoOtraComunidad(ComunidadQueryBean query){
         	if(query.getIndActivo()!=null && query.getIndActivo().equals(1)){
         		String hash=null;
         		if(query.getHashCertificado()!=null)
         			hash=query.getHashCertificado();
         		else hash=UtilidadCertificados.calcularHashCertificado(query.getCertificado()) ;
         		
         		query.setHashCertificado(hash);
         		JugComunidadCertificado entity= comunidadRepository.getCertificadoActivoOtraComunidad(query);
         		if(entity!=null) return true; 
         	}
         	return false;
         		
	}
	
	@Transactional
	@Override
	public byte[] exportComunidad(String username, ComunidadQueryBean query, String reportType, String reportName, String reportTitle) {
	
		ComunidadSearchResult resultCert=  getCertificadoComunidad(query);
		SearchResults<JugUsuariocomunidad> resultUser= usuarioComunidadRepository.getListaUsuarios(query);
		JugComunidad comunidad=comunidadRepository.getComunidad(query.getIdComunidad());
		List<ComunidadBeanReport> listReport= getBeanReportList(comunidad,resultCert, resultUser);
		
		JRDatasourceReportFillManagerHelper.setCurrentDataSource(new JRBeanCollectionDataSource(listReport));
		byte[] reportBytes =  UtilBusiness.preparaInformePDF(reportListDatasourceRunner, reportType, reportName, reportTitle);

		return reportBytes;
	}
	
	
	/** Devuelve la lista de Bean Report obtenido en las Consultas.
	 * @param resultCert
	 * @param resultUser
	 * @return
	 */
	private List<ComunidadBeanReport> getBeanReportList(JugComunidad comunidad,ComunidadSearchResult resultCert, SearchResults<JugUsuariocomunidad> resultUser){
		ComunidadBeanReport beanReport= new ComunidadBeanReport();
		beanReport.setId(comunidad.getId());
		beanReport.setDescripcion(comunidad.getDescripcion());
		
		if(comunidad.getActivo()==null || comunidad.getActivo()==0)
	      beanReport.setIndActivo(false);
		else beanReport.setIndActivo(true);
		
		List<ComunidadBeanReport> listResult= new ArrayList<ComunidadBeanReport>();
		
		if(resultCert!=null){
			List<ComunidadBean> list= resultCert.getResults();
			for (ComunidadBean comunidadBean : list) {
				ComunidadCertificadoBean cert= ((ComunidadCertificadoBean)comunidadBean);
				CertificadoReport report= new CertificadoReport();
				
				report.setCertificado(cert.getCertificado());
				report.setFechaCarga(cert.getFechaCarga());
				report.setFechaDesde(cert.getFechaDesde());
				report.setFechaHasta(cert.getFechaHasta());
				report.setFingerSha1(cert.getFingerSha1());
				report.setHashCertificado(cert.getHashCertificado());
				if(cert.getIndActivo()==null || cert.getIndActivo()==0)
				  report.setIndActivo(false);
				else report.setIndActivo(true);
				
				beanReport.getListCertificado().add(report);
			}
		}
		
		if(resultUser!=null){
			 List<JugUsuariocomunidad> list= resultUser.getResults();
			 for (JugUsuariocomunidad user : list) {
				 
				 UsuarioReport report= new UsuarioReport();
				 report.setId(user.getId());
				 report.setDescripcion(user.getDescripcion());
				 report.setUsuario(user.getUsuario());
				 if(user.getActivo()==null || user.getActivo()==0)
					 report.setIndActivo(false);
				 else report.setIndActivo(true);
				 
				 beanReport.getListUsuario().add(report);
			}
		}
		
		listResult.add(beanReport);
		return listResult;
	}


	


	

}
