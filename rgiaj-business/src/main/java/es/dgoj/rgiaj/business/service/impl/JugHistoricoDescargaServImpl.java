package es.dgoj.rgiaj.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeveris.core.reporting.ReportFactoryBean;
import com.jeveris.reporting.jasper.JRDatasourceReportFillManagerHelper;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.ComunidadBean;
import es.dgoj.rgiaj.business.beans.ComunidadBeanReport;
import es.dgoj.rgiaj.business.beans.JugHistoricoBean;
import es.dgoj.rgiaj.business.beans.JugHistoricoQueryBean;
import es.dgoj.rgiaj.business.beans.JugHistoricoSearchResult;
import es.dgoj.rgiaj.business.beans.type.TipoDescargaProhibidos;
import es.dgoj.rgiaj.business.model.JugHistoricodescargasproh;
import es.dgoj.rgiaj.business.repository.IJugHistoricoDescargasprohRep;
import es.dgoj.rgiaj.business.service.IJugHistoricoDescargaServ;
import es.dgoj.rgiaj.business.util.UtilBusiness;

@Service("jugHistoricoDescargaServ")
public class JugHistoricoDescargaServImpl  implements IJugHistoricoDescargaServ {

	
	@Autowired
	private IJugHistoricoDescargasprohRep<Long, JugHistoricodescargasproh> jugHistoricodescargasprohRepository;
	
	/**
	 * Interfaz de catalogo de Servicios de reporting.
	 */
	@Autowired
	private ReportFactoryBean reportListDatasourceRunner;

	
	/** (non-Javadoc)
	 * @see es.dgoj.rgiaj.business.service.IJugHistoricoDescargaService#getHistorico(es.dgoj.rgiaj.business.bean.JugHistoricoQueryBean)
	 */
	@Override
	public JugHistoricoSearchResult getHistorico(JugHistoricoQueryBean query) {
		List<JugHistoricoBean> list= new ArrayList<JugHistoricoBean>();
		JugHistoricoSearchResult result=new JugHistoricoSearchResult();
		// TODO Auto-generated method stub
		if(query!=null){
		 SearchResults<JugHistoricodescargasproh> search=jugHistoricodescargasprohRepository.getHistorico(query);
		   if(search!=null && search.getResults()!=null){
			   for (JugHistoricodescargasproh entity : search.getResults()) {
				   JugHistoricoBean element= new JugHistoricoBean();
				   fillHistoricoBean(entity, element);
				   list.add(element);
			   }
			   result.setResults(list);
			   result.setNumResults(new Long(search.getTotal()));
		   }			  
		}
			
		return result;
	}

	/** Se rellena el bean a partir de la entidad
	 * @param entity
	 * @param element
	 */
	private void fillHistoricoBean(JugHistoricodescargasproh entity, JugHistoricoBean element) {
		element.setIdHistoricoDescarga(entity.getId());
		if(entity.getJugComunidad()!=null)
		  element.setComunidad(new ComunidadBean(entity.getJugComunidad().getId(), entity.getJugComunidad().getCodigo(), entity.getJugComunidad().getDescripcion()));
		else  element.setComunidad(new ComunidadBean(new Long(0) , "--", "--"));
		element.setFechaDescarga(entity.getFechaDescarga());
		element.setUltimo(entity.getUltimo());
		
		element.setConfirmada("NO");
		if(entity.getConfirmada()!=null )
			if(entity.getConfirmada().equals(1))
				element.setConfirmada("SI");
		
		if(entity.getCompleta()!=null)
			if(entity.getCompleta().equals(0))
			  element.setTipo(TipoDescargaProhibidos.Incremental.toString());
			else  element.setTipo(TipoDescargaProhibidos.Completa.toString());
		
		if(entity.getProcedencia()!=null){
			element.setProcedencia(entity.getProcedencia());
		} else element.setProcedencia("APP");
		
	}

	@Override
	public byte[] exportHistorico(String username, JugHistoricoQueryBean query,	String reportType, String reportName, String reportTitle) {
		// TODO Auto-generated method stub
//		List<ComunidadBeanReport> listReport= new ArrayList<ComunidadBeanReport>();
		query.setMaxResults(null);
		JugHistoricoSearchResult result=  getHistorico(query);
//		fillReport(listReport, result);
		
		JRDatasourceReportFillManagerHelper.setCurrentDataSource(new JRBeanCollectionDataSource(result.getResults()));
		byte[] reportBytes =  UtilBusiness.preparaInformePDF(reportListDatasourceRunner, reportType, reportName, reportTitle);

		return reportBytes;
		
		
	}
	
	
	private void fillReport(List<ComunidadBeanReport> listReport, JugHistoricoSearchResult result){
		if(result!=null && result.getNumResults()>0){
			List<JugHistoricoBean> list= result.getResults();
			for (JugHistoricoBean bean : list) {
				ComunidadBeanReport report= new ComunidadBeanReport();
				report.setId(bean.getComunidad().getIdComunidad());
				if(!listReport.contains(report)){
					report.setDescripcion(bean.getComunidad().getDescripcion());
					report.getListHistorico().add(bean);
					listReport.add(report);
				}
				else listReport.get(listReport.indexOf(report) ).getListHistorico().add(bean); 
			}
		}
	}
	
	

}
