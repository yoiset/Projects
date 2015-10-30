package es.dgoj.rgiaj.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeveris.core.reporting.ReportFactoryBean;
import com.jeveris.reporting.jasper.JRDatasourceReportFillManagerHelper;

import es.dgoj.rgiaj.Fault;
import es.dgoj.rgiaj.JuegoRGIAJ;
import es.dgoj.rgiaj.ProhibidosResponse;
import es.dgoj.rgiaj.business.beans.ComunidadBean;
import es.dgoj.rgiaj.business.beans.ComunidadProviciaReport;
import es.dgoj.rgiaj.business.beans.ComunidadReport;
import es.dgoj.rgiaj.business.beans.JugHistoricoQueryBean;
import es.dgoj.rgiaj.business.beans.JugHistoricoSearchResult;
import es.dgoj.rgiaj.business.beans.JugProhibicionBean;
import es.dgoj.rgiaj.business.beans.JugProhibicionQueryBean;
import es.dgoj.rgiaj.business.exceptions.JuegoExternoException;
import es.dgoj.rgiaj.business.model.JugComunidad;
import es.dgoj.rgiaj.business.model.JugHistoricodescargasproh;
import es.dgoj.rgiaj.business.model.JugProhibicion;
import es.dgoj.rgiaj.business.repository.IConfigurationRepository;
import es.dgoj.rgiaj.business.repository.IJugHistoricoDescargasprohRep;
import es.dgoj.rgiaj.business.repository.IJugProhibicionRepository;
import es.dgoj.rgiaj.business.service.IJugProhibicionServ;
import es.dgoj.rgiaj.business.util.UtilBusiness;

/**
 * @author ylopezconnectis
 *
 */
@Service("JugProhibicionService")
public class JugProhibicionServImpl extends SpringServiceToWS implements  IJugProhibicionServ {
	
	
	
	@Autowired
	private JuegoRGIAJ JuegoRGIAJServiceStub; 
	
	private Logger log= Logger.getLogger(IJugProhibicionServ.class);

	
	@Autowired
	private IConfigurationRepository configurationRepository;
	
	@Autowired
	private IJugProhibicionRepository<JugProhibicion, Long> jugProhibicionRepository;
	
	@Autowired
	private IJugHistoricoDescargasprohRep<JugHistoricodescargasproh, Long> jugHistoricodescargasprohRepository;
	
	@Autowired
	private ReportFactoryBean reportListDatasourceRunner;
	
	
	
	
	@PostConstruct
	protected void init(){
		super.init();
		
	}
	
	

	/* (non-Javadoc)
	 * @see es.dgoj.rgiaj.business.service.IJugProhibicionService#getProhibidosList(es.dgoj.rgiaj.business.bean.JugProhibicionQueryBean)
	 */
	@Override
	public byte[] getProhibidosList(JugProhibicionQueryBean queryBean) throws JuegoExternoException {
		// TODO Auto-generated method stub
		try {
			 ProhibidosResponse response=  JuegoRGIAJServiceStub.prohibidosList(queryBean.toRequest());
			 return response.getResultado();
		} catch (Fault e) {
			log.error("Error intentando comunicar con el Servicio: " + e);
			throw new JuegoExternoException(e);
		}
		
	}
	
	
	
	
	/** Confirma el historial de Descargas de Prohibidos
	 * @see es.dgoj.rgiaj.business.service.IJugProhibicionService#confirmHistoricoDescargas(es.dgoj.rgiaj.business.bean.JugProhibicionQueryBean)
	 */
	@Transactional
	public void confirmHistoricoDescargas(JugProhibicionQueryBean queryBean) throws JuegoExternoException {
		JugHistoricodescargasproh entity=jugProhibicionRepository.getLast(queryBean.getCodComunidad());
		entity.setConfirmada(1);
		jugHistoricodescargasprohRepository.updateHistoricoDescargas(entity);
	}
	

	/** Retorna si la ultima descarga esta por confirmar
	 * @see es.dgoj.rgiaj.business.service.IJugProhibicionService#hasPending(es.dgoj.rgiaj.business.bean.JugProhibicionQueryBean)
	 */
	@Override
	public boolean hasPending(JugProhibicionQueryBean queryBean) {
		JugHistoricodescargasproh entity=jugProhibicionRepository.getLast(queryBean.getCodComunidad());
		if(entity==null) return false;
		if(entity.getConfirmada()!=null && entity.getConfirmada().equals(1)) return false;
		return true;
	}
	
	/** Confirma el historial de Descargas de Prohibidos Pendiente
	 * @param queryBean
	 * @throws JuegoExternoException 
	 */
	@Transactional
	public void confirmHistoricoDescargasPendiente(JugProhibicionQueryBean queryBean) throws JuegoExternoException{
		JugHistoricodescargasproh entity=jugProhibicionRepository.getLast(queryBean.getCodComunidad());
		entity.setConfirmada(1);
		jugHistoricodescargasprohRepository.updateHistoricoDescargas(entity);
	}
	
	
	
	
	/** Devuelve el Bean con la comunidad y el codigo
	 * @see es.dgoj.rgiaj.business.service.IJugProhibicionServ#getComunidad(java.lang.String)
	 */
	public JugProhibicionBean getComunidad(String user){
		JugComunidad entity=jugProhibicionRepository.getComunidad(user);
		JugProhibicionBean bean=new JugProhibicionBean();
		 if(entity!=null){
			 bean.setIdComunidad(entity.getId());
			 bean.setCodComunidad(entity.getCodigo());			 
			 bean.setDescripcionComunidad(entity.getDescripcion());
		 }
		 return bean;
	}
	
	
	/** Devuelve el Bean con las ultimas descargas confirmadas por una comunidad
	 * @see es.dgoj.rgiaj.business.service.IJugProhibicionServ#getUltimasDescargasConfirmadas(es.dgoj.rgiaj.business.beans.JugProhibicionQueryBean)
	 */
	public List<JugProhibicionBean> getUltimasDescargasConfirmadas(JugProhibicionQueryBean queryBean)throws JuegoExternoException{
		List<JugHistoricodescargasproh> list=jugHistoricodescargasprohRepository.getUltimasDescargasConfirmadas(queryBean);
		List<JugProhibicionBean> result=new ArrayList<JugProhibicionBean>();
		
		if(list!=null)
		for (JugHistoricodescargasproh entity : list) 
			result.add(new JugProhibicionBean(entity.getFechaDescarga(), entity.getUltimo()));
		
		return result;
	}
	
	@Override
	public List<ComunidadBean> getComunidadList() {
		// TODO Auto-generated method stub
		List<ComunidadBean> result=new ArrayList<ComunidadBean>();
		
		List<JugComunidad> list=jugProhibicionRepository.getComunidadList();
		for (JugComunidad entiry : list) 
             		result.add(new ComunidadBean(entiry.getId(), entiry.getCodigo(), entiry.getDescripcion()));	
		
		return result;
	}
	
	
	 public ComunidadProviciaReport getAllProhibidosComunidadProvinciaList(JugProhibicionQueryBean queryBean){
		  ComunidadProviciaReport report= new ComunidadProviciaReport();
		  
		  List<JugProhibicion> list=  jugProhibicionRepository.getAllProhibidosComunidadProvinciaList(queryBean);
		  for (JugProhibicion jug : list) 
			report.addComunidadReport(jug);
		  
		 report.setOrderComunidadAsc();
		  
		  return report;
	 }
	 



		@Override
		public byte[] exportProhibidosComunidadProvincia(String username, JugProhibicionQueryBean query,	String reportType, String reportName, String reportTitle) {
			// TODO Auto-generated method stub
		    ComunidadProviciaReport result=  getAllProhibidosComunidadProvinciaList(query);
			List<ComunidadProviciaReport> list= new ArrayList<ComunidadProviciaReport>();
			list.add(result);
			
			JRDatasourceReportFillManagerHelper.setCurrentDataSource(new JRBeanCollectionDataSource(list));
			byte[] reportBytes =  UtilBusiness.preparaInformePDF(reportListDatasourceRunner, reportType, reportName, reportTitle);

			return reportBytes;
			
			
		}
		
	 
	 
	 
	



	public IConfigurationRepository getConfigurationRepository() {
		return configurationRepository;
	}



	public void setConfigurationRepository(
			IConfigurationRepository configurationRepository) {
		this.configurationRepository = configurationRepository;
	}



	public JuegoRGIAJ getJuegoRGIAJServiceStub() {
		return JuegoRGIAJServiceStub;
	}
	
	

	
}
