package es.dgoj.rgiaj.business.service.impl;
//package es.dgoj.rgiaj.business.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import es.dgoj.rgiaj.business.bean.ComunidadBean;
//import es.dgoj.rgiaj.business.bean.ComunidadCertificadoBean;
//import es.dgoj.rgiaj.business.bean.ComunidadQueryBean;
//import es.dgoj.rgiaj.business.bean.ComunidadSearchResult;
//import es.dgoj.rgiaj.business.exceptions.JuegoExternoException;
//import es.dgoj.rgiaj.business.model.JugComunidad;
//import es.dgoj.rgiaj.business.model.JugComunidadCertificado;
//import es.dgoj.rgiaj.business.model.JugComunidadCertificadoPK;
//import es.dgoj.rgiaj.business.model.JugUsuariocomunidad;
//import es.dgoj.rgiaj.business.repository.IComunidadRepository;
//import es.dgoj.rgiaj.business.repository.IUsuarioComunidadRepository;
//import es.dgoj.rgiaj.business.service.IComunidadService;
//import es.dgoj.rgiaj.business.util.UtilidadCertificados;
//import com.mysema.query.SearchResults;
//
///**
// * @author ylopezconnectis
// *
// */
//@Service("comunidadService")
//public class ComunidadServiceImpl implements IComunidadService {
//
//	
//	@Autowired
//	private IComunidadRepository<JugComunidadCertificado, JugComunidadCertificadoPK> comunidadRepository;
//	
//	@Autowired
//	private IUsuarioComunidadRepository<JugUsuariocomunidad, Long> usuarioComunidadRepository;
//	
//	private static final Logger log = LoggerFactory.getLogger(ComunidadServiceImpl.class);  
//	
//	/** (non-Javadoc)
//	 * @see es.dgoj.rgiaj.business.service.IComunidadService#getCertificadoComunidad(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
//	 */
//	@Override
//	public ComunidadSearchResult getCertificadoComunidad(ComunidadQueryBean query) {
//		// TODO Auto-generated method stub
//		SearchResults<JugComunidadCertificado> search = comunidadRepository.getListComunidadCertificado(query);
//		
//		ComunidadSearchResult result= new ComunidadSearchResult();
//		
//		List<JugComunidadCertificado> list= search.getResults();
//		List<ComunidadBean> listResult=new ArrayList<ComunidadBean>();
//		if(list!=null)
//			for (JugComunidadCertificado entity : list) 
//				listResult.add( ComunidadCertificadoBean.getBean(entity));
//			
//		result.setNumResults(search.getTotal());	
//		result.setResults(listResult);
//			
//		return result;
//	}
//	
//	
//	/* (non-Javadoc)
//	 * @see es.dgoj.rgiaj.business.service.IComunidadService#addCertificadoComunidad(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
//	 */
//	@Transactional
//	public void addCertificadoComunidad(ComunidadQueryBean query) throws JuegoExternoException{
//		
//		if(query.getCertificado()!=null){
//			try {
//				 query.setHashCertificado(UtilidadCertificados.calcularHashCertificado(query.getCertificado())) ;
//				 query.setFingerSha1(UtilidadCertificados.getFingerPrint(query.getCertificado()));
//				 query.setFechaDesde(UtilidadCertificados.getFechaInicialValidez(query.getCertificado()));
//				 query.setFechaHasta(UtilidadCertificados.getFechaFinalValidez(query.getCertificado()));
//			} catch (Exception e) {
//				log.error("Error intentando extraer informacion del certificado" + e);
//				throw new JuegoExternoException(e);
//			}
//			
//			 
//			 if(query.getIndActivo()!=null && query.getIndActivo().equals(1))
//					validateAndChange(query);	
//			 
//			 log.debug("Guardando certificado con Hash " + query.getHashCertificado());
//			 comunidadRepository.addComunidadCertificado(query);
//		  }
//		}
//		
//		/** Edita el certificado asociado a la comunidad. Si viene como activo se pone como activo el mismo y se quita como activo el otro que estaba.
//		 * @see es.dgoj.rgiaj.business.service.IComunidadService#updateCertificadoComunidad(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
//		 */
//		@Transactional
//		public void updateCertificadoComunidad(ComunidadQueryBean query){ 
//			if(query.getHashCertificado()!=null){
//				 if(query.getIndActivo()!=null && query.getIndActivo().equals(1))
//					validateAndChange(query);				
//		    
//		    log.debug("Guardando certificado con Hash " + query.getHashCertificado());	  
//			comunidadRepository.updateComunidadCertificado(query);
//				   
//		    }
//		
//		}
//
//
//		/** Busca si el certificado que se intenta poner como activo es el mismo. Sino es el mismo de la query lo quita como activo
//		 * @param query
//		 */
//		private void validateAndChange(ComunidadQueryBean query) {
//			JugComunidadCertificado certActivo=getCertificadoActivo(query);
//			  if(certActivo!=null){
//				  if(!certActivo.getHashCertificado().equals(query.getHashCertificado())){
//					  certActivo.setIndActivo(new Integer(0));
//					  comunidadRepository.update(certActivo);
//				  }					
//			  }
//		}
//		
//		
//		/** Elimina un certificado asociado a una comunidad sino se encuentra activo
//		 * @see es.dgoj.rgiaj.business.service.IComunidadService#removeCertificadoComunidad(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
//		 */
//		@Transactional
//		public void removeCertificadoComunidad(ComunidadQueryBean query){ 
//			if(query.getHashCertificado()!=null && query.getIdComunidad()!=null){
//				  if(!isCertificadoActivo(query)){
//					  JugComunidadCertificado entity= getCertificadobyHash(query);
//					  comunidadRepository.remove(entity);  
//				  }
//				   
//		    }
//		
//		}
//
//
//
//	/** Devuelve el certificado activo por la comunidad
//	 * @see es.dgoj.rgiaj.business.service.IComunidadService#existCertificadoActivoComunidad(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
//	 */
//	public ComunidadCertificadoBean getCertificadoActivoComunidad(ComunidadQueryBean query) {
//		if(query.getIdComunidad()!=null){
//			JugComunidadCertificado entity= comunidadRepository.getCertificadoActivoComunidad(query);
//     		if(entity!=null) 
//     			return ComunidadCertificadoBean.getBean(entity); 
//		}
//			return null;
//		}
//
//	
//	
//	/** Devuelve si un certificado esta activo en en la Comunidad
//	 * @see es.dgoj.rgiaj.business.service.IComunidadService#isCertificadoActivo(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
//	 */
//	public boolean isCertificadoActivo(ComunidadQueryBean query){
//		if(query.getHashCertificado()!=null){
//			JugComunidadCertificado entity= comunidadRepository.getCertificadoByHashComunidad(query);
//			if(entity.getIndActivo()==1) 
//				return true;
//		}
//		return false;
//	}
//	
//	
//	
//	/** Devuelve el certificado activo de la comunidad
//	 * @see es.dgoj.rgiaj.business.service.IComunidadService#existCertificadoActivoComunidad(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
//	 */
//	private JugComunidadCertificado getCertificadoActivo(ComunidadQueryBean query) {
//		if(query.getIdComunidad()!=null)
//			return comunidadRepository.getCertificadoActivoComunidad(query);
//		return null;
//		}
//
//	
//	
//	/**
//	 * @param query
//	 * @return
//	 */
//	private JugComunidadCertificado getCertificadobyHash(ComunidadQueryBean query){
//		if(query.getHashCertificado()!=null){
//			JugComunidadCertificado entity= comunidadRepository.getCertificadoByHashComunidad(query);
//			return entity;
//		}
//		return null;
//	}
//
//
//	
//	
//	@Override
//	public List<ComunidadBean> getComunidadList() {
//		// TODO Auto-generated method stub
//		List<ComunidadBean> result=new ArrayList<ComunidadBean>();
//		
//		List<JugComunidad> list= comunidadRepository.getComunidadList();
//		for (JugComunidad entiry : list) 
//             		result.add(new ComunidadBean(entiry.getId(), entiry.getCodigo(), entiry.getDescripcion()));	
//		
//		return result;
//	}
//	
//	/** Calcula si existe otro certificado activo en la comunidad distinto del que se le pasa
//	 * @param query
//	 * @return
//	 */
//	public boolean existOtrotCertificadoActivoComunidad(ComunidadQueryBean query){
//         	if(query.getIndActivo()!=null && query.getIndActivo().equals(1)){
//         		String hash=null;
//         		if(query.getHashCertificado()!=null)
//         			hash=query.getHashCertificado();
//         		else hash=UtilidadCertificados.calcularHashCertificado(query.getCertificado()) ;
//         		
//         		JugComunidadCertificado entity= comunidadRepository.getCertificadoActivoComunidad(query);
//         		if(entity!=null && !entity.getHashCertificado().equals(hash)) return true; 
//         	}
//         	return false;
//         		
//	}
//	
//	/** Calcula si existe el certificado
//	 * @see es.dgoj.rgiaj.business.service.IComunidadService#existCertificadoComunidad(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
//	 */
//	public boolean existCertificadoComunidad(ComunidadQueryBean query){
//     		String hash=null;
//     		if(query.getHashCertificado()!=null)
//     			hash=query.getHashCertificado();
//     		else hash=UtilidadCertificados.calcularHashCertificado(query.getCertificado()) ;
//     		query.setHashCertificado(hash);
//     		
//     		JugComunidadCertificado entity= comunidadRepository.getCertificadoByHashComunidad(query);
//     		if(entity!=null) return true; 
//     	return false;
//     		
//}
//	
//	/** Calcula si existe el certificado activo en otra comunidad
//	 * @param query
//	 * @return
//	 */
//	public boolean existCertificadoActivoOtraComunidad(ComunidadQueryBean query){
//         	if(query.getIndActivo()!=null && query.getIndActivo().equals(1)){
//         		String hash=null;
//         		if(query.getHashCertificado()!=null)
//         			hash=query.getHashCertificado();
//         		else hash=UtilidadCertificados.calcularHashCertificado(query.getCertificado()) ;
//         		
//         		query.setHashCertificado(hash);
//         		JugComunidadCertificado entity= comunidadRepository.getCertificadoActivoOtraComunidad(query);
//         		if(entity!=null) return true; 
//         	}
//         	return false;
//         		
//	}	
//	
//	
//
//
//	
//
//}
