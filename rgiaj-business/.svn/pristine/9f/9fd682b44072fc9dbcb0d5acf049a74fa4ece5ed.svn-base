package es.dgoj.rgiaj.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgoj.core.common.bean.ParamBean;
import com.jeveris.core.reporting.ReportFactoryBean;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.ProvinciaBean;
import es.dgoj.rgiaj.business.beans.ProvinciaQueryBean;
import es.dgoj.rgiaj.business.beans.ProvinciaSearchResult;
import es.dgoj.rgiaj.business.model.Provincia;
import es.dgoj.rgiaj.business.repository.ProvinciaRepository;
import es.dgoj.rgiaj.business.service.ProvinciaService;
import es.dgoj.rgiaj.business.util.ConstantesBusiness;


/**
 * Implementacion del servicio de mantenimiento de provincias.
 * @author connectis
 */

@Service("provinciaService")
public class ProvinciaServiceImpl implements ProvinciaService {

	/** Campo comunidad autonoma repository. */
	@Autowired
	private ProvinciaRepository<Provincia,Long> provinciaRepository;
	
	/** Constante LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProvinciaServiceImpl.class);

	/**
	 * Interfaz de catalogo de Servicios de reporting.
	 */
	@Autowired
	private ReportFactoryBean reportListDatasourceRunner;	

	/**
	 * Devuelve las comunidades autonomas buscadas.
	 * @param provinciaQueryBean parametros de busqueda de comunidades autónomas
	 * @return ProvinciaSearchResult resultados
	 */
	@Override
	public ProvinciaSearchResult getProvincias(ProvinciaQueryBean provinciaQueryBean){
	
		ProvinciaSearchResult resultado = new ProvinciaSearchResult();

		SearchResults<Provincia> lista = provinciaRepository.getProvincias(provinciaQueryBean);
	
		ArrayList<ProvinciaBean> listaResultados = new ArrayList<ProvinciaBean>();
		
		for (Provincia pro : lista.getResults()){
			ProvinciaBean nuevoJugadorBean = new ProvinciaBean(pro);
			listaResultados.add(nuevoJugadorBean);
		}
		
		resultado.setResults(listaResultados);
		resultado.setNumResults(Long.valueOf(lista.getTotal()));
		
				
		return resultado;
	}

	/**
	 * Devuelve las provincias buscadas.
	 * @param provinciaQueryBean parametros de busqueda de provincias
	 * @return ProvinciaSearchResult resultados
	 */
	@Override
	public List<ParamBean> getListaProvincias(){
	
		ProvinciaQueryBean provinciaQueryBean = new ProvinciaQueryBean();
		provinciaQueryBean.setFirstResult(0);
		provinciaQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);

		SearchResults<Provincia> lista = provinciaRepository.getProvincias(provinciaQueryBean);
	
		ArrayList<ParamBean> listaResultados = new ArrayList<ParamBean>();
		
		for (Provincia pro : lista.getResults()){
			ParamBean nuevoJugadorBean = new ParamBean(pro.getId().toString(), pro.getDescripcion());
			listaResultados.add(nuevoJugadorBean);
		}
				
		return listaResultados;
	}	
	

}
