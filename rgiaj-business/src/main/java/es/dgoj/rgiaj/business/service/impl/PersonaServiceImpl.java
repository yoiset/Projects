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

import es.dgoj.rgiaj.business.beans.PersonaBean;
import es.dgoj.rgiaj.business.beans.PersonaQueryBean;
import es.dgoj.rgiaj.business.beans.PersonaSearchResult;
import es.dgoj.rgiaj.business.model.ConfiguracionEntity;
import es.dgoj.rgiaj.business.model.Persona;
import es.dgoj.rgiaj.business.repository.IConfigurationRepository;
import es.dgoj.rgiaj.business.repository.PersonaRepository;
import es.dgoj.rgiaj.business.service.PersonaService;
import es.dgoj.rgiaj.business.util.ConstantesBusiness;
import es.dgoj.rgiaj.business.util.UtilBusiness;

/**
 * Implementacion del servicio de consulta de personas.
 * @author connectis
 */

@Service("personaService")
public class PersonaServiceImpl implements PersonaService {

	/** Campo persona repository. */
	@Autowired
	private PersonaRepository<Persona,Long> personaRepository;
	
	/** Campo configuracion repository. */
	@Autowired
	private IConfigurationRepository<ConfiguracionEntity,Integer> configuracionRepository;
	
	/** Constante LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonaServiceImpl.class);

	/**
	 * Interfaz de catalogo de Servicios de reporting.
	 */
	@Autowired
	private ReportFactoryBean reportListDatasourceRunner;	

	/**
	 * Devuelve las personas buscadas.
	 * @param personaQueryBean parametros de busqueda de personas
	 * @return PersonaSearchResult resultados
	 */
	@Override
	@Transactional
	public PersonaSearchResult getPersonas(PersonaQueryBean personaQueryBean){
	
		PersonaSearchResult resultado = new PersonaSearchResult();

		SearchResults<Persona> lista = personaRepository.getPersonas(personaQueryBean);
	
		ArrayList<PersonaBean> listaResultados = new ArrayList<PersonaBean>();
		
		for (Object objeto : lista.getResults()){
			Persona persona = (Persona) objeto;
			PersonaBean nuevoJugadorBean = new PersonaBean(persona);
			listaResultados.add(nuevoJugadorBean);
		}
		
		resultado.setResults(listaResultados);
		resultado.setNumResults(Long.valueOf(lista.getTotal()));
		
				
		return resultado;
	}

	/**
	 * Devuelve la persona por su Id.
	 *
	 * @param id 
	 * @return PersonaBean bean de la persona
	 */
	@Override
	@Transactional
	public PersonaBean getPersonaById(Long id){
	
		LOGGER.debug("Buscando la persona "+id);
		Persona persona = personaRepository.getPersonaById(id);

		if (persona == null){
			return null;
		} else {
			return new PersonaBean(persona);
		} 
	
	}
	
	
	
	/**
	 * Exporta los datos de la consulta de personas.
	 *
	 * @param username
	 * @param personaQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	@Override
	@Transactional
	public byte[] exportPersonas(String username, PersonaQueryBean personaQueryBean, String reportType, String reportName, String reportTitle){
		
		// Consultamos la informacion a exportar
		personaQueryBean.setFirstResult(0);
		personaQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);
		PersonaSearchResult personaSearchResult = this.getPersonas(personaQueryBean);
		
		JRDatasourceReportFillManagerHelper.setCurrentDataSource(new JRBeanCollectionDataSource(personaSearchResult.getResults()));
		byte[] reportBytes =  UtilBusiness.preparaInformePDF(reportListDatasourceRunner, reportType, reportName, reportTitle);

		return reportBytes;
	}
	
	/**
	 * Exporta los datos de una persona.
	 *
	 * @param username
	 * @param personaQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */	
	@Override
	@Transactional
	public byte[] exportPersona(String username, PersonaQueryBean personaQueryBean, String reportType, String reportName, String reportTitle){
		
		Long idPersona = personaQueryBean.getIdPersona();
		// Consultamos la informacion a exportar
		PersonaBean persona = this.getPersonaById(idPersona);
		ArrayList<PersonaBean> listaPersona = new ArrayList<PersonaBean>();
		listaPersona.add(persona);
					
		JRDatasourceReportFillManagerHelper.setCurrentDataSource(new JRBeanCollectionDataSource(listaPersona));
		byte[] reportBytes =  UtilBusiness.preparaInformePDF(reportListDatasourceRunner, reportType, reportName, reportTitle);

		return reportBytes;
	}
	
	/**
	 * Exporta la etiqueta de una persona.
	 *
	 * @param username
	 * @param personaQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */	
	@Override
	@Transactional
	public byte[] etiquetaPersona(String username, PersonaQueryBean personaQueryBean, String reportType, String reportName, String reportTitle){
		
		Long idPersona = personaQueryBean.getIdPersona();
		// Consultamos la informacion a exportar
		PersonaBean persona = this.getPersonaById(idPersona);
		ArrayList<PersonaBean> listaPersona = new ArrayList<PersonaBean>();
		listaPersona.add(persona);
					
		JRDatasourceReportFillManagerHelper.setCurrentDataSource(new JRBeanCollectionDataSource(listaPersona));
		byte[] reportBytes =  UtilBusiness.preparaInformePDF(reportListDatasourceRunner, reportType, reportName, reportTitle);

		return reportBytes;
	}
	
	/**
	 * Exporta las etiquetas pendientes de personas.
	 *
	 * @param username
	 * @param personaQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	@Override
	@Transactional
	public byte[] etiquetasPersonas(String username, PersonaQueryBean personaQueryBean, String reportType, String reportName, String reportTitle){
		
		// Consultamos la informacion a exportar
		PersonaQueryBean query = new PersonaQueryBean();
		query.setFirstResult(0);
		query.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);
		query.setEtiquetasPendientes(true);
		PersonaSearchResult personaSearchResult = this.getPersonas(query);
		if (personaSearchResult.getNumResults() == 0){
			return null;
		}
		
		this.actualizaEtiquetas(personaSearchResult.getResults());
		
		JRDatasourceReportFillManagerHelper.setCurrentDataSource(new JRBeanCollectionDataSource(personaSearchResult.getResults()));
		byte[] reportBytes =  UtilBusiness.preparaInformePDF(reportListDatasourceRunner, reportType, reportName, reportTitle);

		return reportBytes;
	}
	
	/**
	 * @param results
	 */
	private void actualizaEtiquetas(List<PersonaBean> lista) {
		for (PersonaBean personaBean: lista){
			Persona persona = personaRepository.getPersonaById(personaBean.getIdPersona());
			persona.setEstadoEtiqueta("IMPRESA");
			personaRepository.update(persona);
		}
	}

	@Override
	public String getEndPointSVDI() {

		String resultado = configuracionRepository.getEndPoint(ConstantesBusiness.ENDPOINTSVDI);
				
		return resultado;
	}
}
