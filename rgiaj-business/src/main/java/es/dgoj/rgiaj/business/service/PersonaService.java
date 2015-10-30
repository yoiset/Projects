package es.dgoj.rgiaj.business.service;

import es.dgoj.rgiaj.business.beans.PersonaBean;
import es.dgoj.rgiaj.business.beans.PersonaQueryBean;
import es.dgoj.rgiaj.business.beans.PersonaSearchResult;

/**
 * Interfaz para la consulta de personas.
 * @author dgonzalez
 */
public interface PersonaService {

	/**
	 * Devuelve las personas buscadas.
	 * @param personaQueryBean
	 * @return PersonaSearchResult
	 */
	PersonaSearchResult getPersonas(PersonaQueryBean personaQueryBean);

	/**
	 * Devuelve la persona por Id
	 *
	 * @param id
	 * @return PersonaBean
	 */
	PersonaBean getPersonaById(Long id);
	
	/**
	 * Exporta los datos de personas
	 *
	 * @param username
	 * @param personaQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	byte[] exportPersonas(String username, PersonaQueryBean personaQueryBean, String reportType, String reportName, String reportTitle);

	/**
	 * Exporta los datos de una persona
	 *
	 * @param username
	 * @param personaQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	byte[] exportPersona(String username, PersonaQueryBean personaQueryBean, String reportType, String reportName, String reportTitle);

	/**
	 * @return
	 */
	String getEndPointSVDI();

	/**
	 * Genera la etiqueta de una persona
	 *
	 * @param username
	 * @param personaQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	byte[] etiquetaPersona(String username, PersonaQueryBean personaQueryBean, String reportType, String reportName, String reportTitle);

	/**
	 * Genera las etiquetas pendientes
	 *
	 * @param username
	 * @param personaQueryBean
	 * @param reportType
	 * @param reportName
	 * @param reportTitle
	 * @return
	 */ 
	byte[] etiquetasPersonas(String username, PersonaQueryBean personaQueryBean, String reportType,	String reportName, String reportTitle);
	
}
