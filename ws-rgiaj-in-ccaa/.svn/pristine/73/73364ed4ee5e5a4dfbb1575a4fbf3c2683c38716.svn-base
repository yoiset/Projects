package es.dgoj.rgiaj.business.service.impl;
//package es.dgoj.rgiaj.business.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import es.dgoj.rgiaj.business.bean.ComunidadBean;
//import es.dgoj.rgiaj.business.bean.JugHistoricoBean;
//import es.dgoj.rgiaj.business.bean.JugHistoricoQueryBean;
//import es.dgoj.rgiaj.business.bean.JugHistoricoSearchResult;
//import es.dgoj.rgiaj.business.bean.type.TipoDescargaProhibidos;
//import es.dgoj.rgiaj.business.model.JugHistoricodescargasproh;
//import es.dgoj.rgiaj.business.repository.IJugHistoricoDescargasprohRepository;
//import es.dgoj.rgiaj.business.service.IJugHistoricoDescargaService;
//import com.mysema.query.SearchResults;
//
//@Service("jugHistoricoDescargaService")
//public class JugHistoricoDescargaServiceImpl implements IJugHistoricoDescargaService {
//
//	
//	@Autowired
//	private IJugHistoricoDescargasprohRepository<Long, JugHistoricodescargasproh> jugHistoricodescargasprohRepository;
//	
//	
//
//	
//	/** (non-Javadoc)
//	 * @see es.dgoj.rgiaj.business.service.IJugHistoricoDescargaService#getHistorico(es.dgoj.rgiaj.business.bean.JugHistoricoQueryBean)
//	 */
//	@Override
//	public JugHistoricoSearchResult getHistorico(JugHistoricoQueryBean query) {
//		List<JugHistoricoBean> list= new ArrayList<JugHistoricoBean>();
//		JugHistoricoSearchResult result=new JugHistoricoSearchResult();
//		// TODO Auto-generated method stub
//		if(query!=null){
//		 SearchResults<JugHistoricodescargasproh> search=jugHistoricodescargasprohRepository.getHistorico(query);
//		   if(search!=null && search.getResults()!=null){
//			   for (JugHistoricodescargasproh entity : search.getResults()) {
//				   JugHistoricoBean element= new JugHistoricoBean();
//				   fillHistoricoBean(entity, element);
//				   list.add(element);
//			   }
//			   result.setResults(list);
//			   result.setNumResults(new Long(search.getTotal()));
//		   }			  
//		}
//			
//		return result;
//	}
//
//	/** Se rellena el bean a partir de la entidad
//	 * @param entity
//	 * @param element
//	 */
//	private void fillHistoricoBean(JugHistoricodescargasproh entity, JugHistoricoBean element) {
//		element.setIdHistoricoDescarga(entity.getId());
//		if(entity.getJugComunidad()!=null)
//		  element.setComunidad(new ComunidadBean(entity.getJugComunidad().getId(), entity.getJugComunidad().getCodigo(), entity.getJugComunidad().getDescripcion()));
//		else  element.setComunidad(new ComunidadBean(new Long(0) , "--", "--"));
//		element.setFechaDescarga(entity.getFechaDescarga());
//		element.setUltimo(entity.getUltimo());
//		
//		element.setConfirmada("NO");
//		if(entity.getConfirmada()!=null )
//			if(entity.getConfirmada().equals(1))
//				element.setConfirmada("SI");
//		
//		if(entity.getCompleta()!=null)
//			if(entity.getCompleta().equals(0))
//			  element.setTipo(TipoDescargaProhibidos.Incremental.toString());
//			else  element.setTipo(TipoDescargaProhibidos.Completa.toString());
//		
//	}
//	
//	
//
//}
