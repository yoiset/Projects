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

import es.dgoj.rgiaj.business.beans.FirmaBean;
import es.dgoj.rgiaj.business.beans.FirmaQueryBean;
import es.dgoj.rgiaj.business.beans.FirmaSearchResult;
import es.dgoj.rgiaj.business.model.Firma;
import es.dgoj.rgiaj.business.repository.FirmaRepository;
import es.dgoj.rgiaj.business.service.FirmaService;
import es.dgoj.rgiaj.business.util.ConstantesBusiness;


/**
 * Implementacion del servicio de mantenimiento de firmas.
 * @author connectis
 */

@Service("firmaService")
public class FirmaServiceImpl implements FirmaService {

	/** Campo firma repository. */
	@Autowired
	private FirmaRepository<Firma,Long> firmaRepository;
	
	/** Constante LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(FirmaServiceImpl.class);

	/**
	 * Interfaz de catalogo de Servicios de reporting.
	 */
	@Autowired
	private ReportFactoryBean reportListDatasourceRunner;	

	/**
	 * Devuelve los tipos de prohibicion buscados.
	 * @param firmaQueryBean parametros de busqueda del firma
	 * @return FirmaSearchResult resultados
	 */
	@Override
	public FirmaSearchResult getFirmas(FirmaQueryBean firmaQueryBean){
	
		FirmaSearchResult resultado = new FirmaSearchResult();

		SearchResults<Firma> lista = firmaRepository.getFirmas(firmaQueryBean);
	
		ArrayList<FirmaBean> listaResultados = new ArrayList<FirmaBean>();
		
		for (Firma tipo : lista.getResults()){
			FirmaBean nuevoJugadorBean = new FirmaBean(tipo);
			listaResultados.add(nuevoJugadorBean);
		}
		
		resultado.setResults(listaResultados);
		resultado.setNumResults(Long.valueOf(lista.getTotal()));
		
				
		return resultado;
	}
	
	@Override
	public List<ParamBean> getListaFirmas(){
	
		FirmaQueryBean firmaQueryBean = new FirmaQueryBean();
		firmaQueryBean.setFirstResult(0);
		firmaQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);

		SearchResults<Firma> lista = firmaRepository.getFirmas(firmaQueryBean);
	
		ArrayList<ParamBean> listaResultados = new ArrayList<ParamBean>();
		
		for (Firma firma : lista.getResults()){
			ParamBean nuevoBean = new ParamBean(firma.getId().toString(), firma.getDescripcion());
			listaResultados.add(nuevoBean);
		}
				
		return listaResultados;
	}

}
