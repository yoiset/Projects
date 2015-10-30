package es.dgoj.rgiaj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dgoj.core.common.bean.ParamBean;
import com.dgoj.core.security.sso.access.SecurityAccess;
import com.dgoj.sprmvc.web.util.RequestUtil;
import com.jeveris.core.exception.impl.CoreException;
import com.jeveris.web.core.utils.WebCoreUtils;
import com.sun.mail.iap.ByteArray;

import es.dgoj.rgiaj.business.beans.PersonaBean;
import es.dgoj.rgiaj.business.beans.PersonaQueryBean;
import es.dgoj.rgiaj.business.beans.ProhibicionBean;
import es.dgoj.rgiaj.business.service.CausaProhibicionService;
import es.dgoj.rgiaj.business.service.ComunidadAutonomaService;
import es.dgoj.rgiaj.business.service.OperadorService;
import es.dgoj.rgiaj.business.service.PersonaService;
import es.dgoj.rgiaj.business.service.ProvinciaService;
import es.dgoj.rgiaj.business.service.SituacionService;
import es.dgoj.rgiaj.business.service.TipoDocIdentidadService;
import es.dgoj.rgiaj.business.service.TipoProhibicionService;
import es.dgoj.rgiaj.encrypt.TimestampEncrypter;
import es.dgoj.rgiaj.form.PersonaForm;
import es.dgoj.rgiaj.form.ProhibicionForm;
import es.dgoj.rgiaj.form.ProvinciaForm;
import es.dgoj.rgiaj.form.SearchPersonaForm;
import es.dgoj.rgiaj.form.TipoDocIdentidadForm;
import es.dgoj.rgiaj.util.Constantes;
import es.dgoj.rgiaj.util.Utilidades;

/**
 * Clase que gestiona todas las peticiones sincronas realizadas desde la vista de personas.
 * @author connectis
 */
@Controller
@RequestMapping(value = "/persona/*")
public class PersonaController {
	
	/**
	 * Servicio de mantenimiento de Personas
	 */
	@Resource
	private PersonaService personaService;
	
	/**
	 *  Log de la clase.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonaController.class);
	
	/**
	 * Servicio de acceso al contenedor de mensajes de spring.
	 */
	@Resource
	private MessageSource messageSource;
	
	/**
	 * Servicio de mantenimiento de tipos de documento de identidad
	 */
	@Resource
	private TipoDocIdentidadService tipoDocIdentidadService;

	/**
	 * Servicio de mantenimiento de comunidades autonomas
	 */
	@Resource
	private ComunidadAutonomaService comunidadAutonomaService;
	
	/**
	 * Servicio de mantenimiento de provincias
	 */
	@Resource
	private ProvinciaService provinciaService;

	/**
	 * Servicio de mantenimiento de tipos de prohibicion
	 */
	@Resource
	private TipoProhibicionService tipoProhibicionService;
	
	/**
	 * Servicio de mantenimiento de causas de prohibicion
	 */
	@Resource
	private CausaProhibicionService causaProhibicionService;
	
	/**
	 * Servicio de mantenimiento de situaciones
	 */
	@Resource
	private SituacionService situacionService;
	
	/**
	 * Servicio de mantenimiento de operadores de juego
	 */
	@Resource
	private OperadorService operadorService;	
	
	/**
	 * Tiempo de sesion de la vista
	 */
	@Resource(name="viewTimeout")
	private Long viewTimeout;
	
	/**
	 * Peticiones para cargar la vista.
	 * @param map Contenedor de informacion para la vista
	 * @param request Peticion
	 * @param searchPersonaForm Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/persona/startPersona")
	public String startPersona(Map<String, Object> map, HttpServletRequest request,  SearchPersonaForm searchPersonaForm) {
		
		try {
			PersonaQueryBean personaQueryBean = (PersonaQueryBean) request.getSession().getAttribute("personaQueryBean");
			if (personaQueryBean != null){
				toSearchForm(searchPersonaForm, personaQueryBean);	
			}
						
			/* listas para los combos desplegables */
			map.put("tiposDocList", tipoDocIdentidadService.getListaTiposDocIdentidad());
			map.put("comunidadesList", comunidadAutonomaService.getListaComunidadesAutonomas());
			map.put("provinciasList", provinciaService.getListaProvincias());
			map.put("tiposProhibicionList", tipoProhibicionService.getListaTiposProhibicion() );
			map.put("causasProhibicionList", causaProhibicionService.getListaCausasProhibicion());
			map.put("situacionesList", situacionService.getListaSituaciones());			
			map.put("operadoresList", operadorService.getListaOperadores());
			map.put("sexosList", getListaSexos());
			
			fillInitialMap(map, "searchPersonaForm");
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}
		
		return "tiles/persona";
	}
	
	/**
	 * @return List<ParamBean>
	 */
	private List<ParamBean> getListaSexos() {
		ArrayList<ParamBean> listaSexos = new ArrayList<ParamBean>();
		listaSexos.add(new ParamBean("H", "Hombre"));
		listaSexos.add(new ParamBean("M", "Mujer"));
		return listaSexos;
	}

	/**
	 * Peticion para exportar el pdf de Personas
	 * 
	 * @param request
	 *            Peticion
	 * @param response
	 *            Respuesta
	 * @return Componente tile al que se redirige (si es correcta la generación del pdf se devuelve null)
	 */
	@RequestMapping(value="/persona/exportPersonas")
	public String exportPersonas(HttpServletRequest request, HttpServletResponse response) {
		
		// Generar el informe en formato Excel
		PersonaQueryBean personaQueryBean = (PersonaQueryBean) request.getSession().getAttribute("personaQueryBean");
		
		String username = (String) SecurityAccess.getUserInformation().getUsername();

		String reportName = "personasReport";
		String reportTitle = this.messageSource.getMessage("page.breadcrumb.persona", null, WebCoreUtils.getLocale());
		String reportType = RequestUtil.getStringParameter(request, "exportType", null);
		String fullReportName = null;
		String contentType = null;
		
		try {
			if ( reportType != null ) {
				if (!reportType.equalsIgnoreCase("Exportar")) {
					if (reportType.equalsIgnoreCase("XLS")) {
						fullReportName = "personasReport.xls";
					    contentType = "application/xls";
					} else if (reportType.equalsIgnoreCase("PDF")){
						fullReportName = "personasReport.pdf";
					    contentType = "application/pdf";
					} else if (reportType.equalsIgnoreCase("DOCX")){
					    fullReportName = "personasReport.doc";
					    contentType = "application/doc";
					} else {
					    throw new CoreException("error.export");
					}
			
					byte[] byteArray = this.personaService.exportPersonas(username, personaQueryBean, reportType, reportName, reportTitle);
					
					response.reset();
					response.setContentType(contentType);
					response.setHeader("Content-disposition", "attachment" + ";filename=\"" + fullReportName + "\"");
					response.addHeader("Pragma", "no cache");
					response.addHeader("Cache-control", "private, must-revalidate");
					
					ServletOutputStream outstream = response.getOutputStream();
					outstream.write(byteArray);
					outstream.flush();
					outstream.close();
				} else {
					LOGGER.error ("Error en el formato de tipo de exportacion; "+reportType);
					return Constantes.ERRORPAGE;
				}
			} else {
				throw new CoreException("error.request.export");
			}
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}
		
		return null;
	}
	
	/**
	 * Peticion para exportar el pdf de detalle de una persona
	 * 
	 * @param request
	 *            Peticion
	 * @param response
	 *            Respuesta
	 * @return Componente tile al que se redirige (si es correcta la generación del pdf se devuelve null)
	 */
	@RequestMapping(value="/persona/exportPersona")
	public String exportPersona(HttpServletRequest request, HttpServletResponse response) {
		
		// Generar el informe en formato Excel
		PersonaQueryBean personaQueryBean = new PersonaQueryBean();
		String idPersona = (String) RequestUtil.getStringParameter(request, "idPersona");
		personaQueryBean.setIdPersona(Long.valueOf(idPersona));

		String username = (String) SecurityAccess.getUserInformation().getUsername();
		String reportName = "personaDetalleReport";
		String reportTitle = this.messageSource.getMessage("page.breadcrumb.persona", null, WebCoreUtils.getLocale());
		String reportType = RequestUtil.getStringParameter(request, "exportType", null);
		String fullReportName = null;
		String contentType = null;
				
		try {
			if ( reportType != null ) {
				if (!reportType.equalsIgnoreCase("Exportar")) {
					if (reportType.equalsIgnoreCase("XLS")) {
						fullReportName = "personaDetalleReport.xls";
					    contentType = "application/xls";
					} else if (reportType.equalsIgnoreCase("PDF")){
						fullReportName = "personaDetalleReport.pdf";
					    contentType = "application/pdf";
					} else if (reportType.equalsIgnoreCase("DOCX")){
					    fullReportName = "personaDetalleReport.doc";
					    contentType = "application/doc";
					} else {
					    throw new CoreException("error.export");
					}
			
					byte[] byteArray = this.personaService.exportPersona(username, personaQueryBean, reportType, reportName, reportTitle);
					
					response.reset();
					response.setContentType(contentType);
					response.setHeader("Content-disposition", "attachment" + ";filename=\"" + fullReportName + "\"");
					response.addHeader("Pragma", "no cache");
					response.addHeader("Cache-control", "private, must-revalidate");
					
					ServletOutputStream outstream = response.getOutputStream();
					outstream.write(byteArray);
					outstream.flush();
					outstream.close();
				} else {
					LOGGER.error ("Error en el formato de tipo de exportacion; "+reportType);
					return Constantes.ERRORPAGE;
				}
			} else {
				throw new CoreException("error.request.export");
			}
			
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}
		
		return null;
	}
	
	/**
	 * Peticion para exportar las etiquetas pendientes de generar
	 * 
	 * @param request
	 *            Peticion
	 * @param response
	 *            Respuesta
	 * @return Componente tile al que se redirige (si es correcta la generación del pdf se devuelve null)
	 */
	@RequestMapping(value="/persona/etiquetasPendientes")
	public String etiquetasPendientes(HttpServletRequest request, HttpServletResponse response) {
		
		// Generar el informe en formato Excel
		PersonaQueryBean personaQueryBean = (PersonaQueryBean) request.getSession().getAttribute("personaQueryBean");
		
		String username = (String) SecurityAccess.getUserInformation().getUsername();

		String reportName = "etiquetasPersonasReport";
		String reportTitle = this.messageSource.getMessage("page.breadcrumb.persona", null, WebCoreUtils.getLocale());
		String reportType = "PDF";
		String fullReportName = null;
		String contentType = null;
		
		Boolean vacio = false;
		
		try {
			fullReportName = "etiquetasPendientesReport.pdf";
			contentType = "application/pdf";
			
			byte[] byteArray = this.personaService.etiquetasPersonas(username, personaQueryBean, reportType, reportName, reportTitle);
			if (byteArray == null){
				vacio = true;
			} else {
				response.reset();
				response.setContentType(contentType);
				response.setHeader("Content-disposition", "attachment" + ";filename=\"" + fullReportName + "\"");
				response.addHeader("Pragma", "no cache");
				response.addHeader("Cache-control", "private, must-revalidate");
						
				ServletOutputStream outstream = response.getOutputStream();
				outstream.write(byteArray);
				outstream.flush();
				outstream.close();
			}
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			return "app/errorEtiquetas";
		} 
		
		if (vacio){
			LOGGER.info("No hay registros");
			return "app/sinEtiquetas";
		}
		
		return null;
	}
	
	/**
	 * Peticion para exportar la etiqueta de una persona
	 * 
	 * @param request
	 *            Peticion
	 * @param response
	 *            Respuesta
	 * @return Componente tile al que se redirige (si es correcta la generación del pdf se devuelve null)
	 */
	@RequestMapping(value="/persona/etiquetaPersona")
	public String etiquetaPersona(HttpServletRequest request, HttpServletResponse response) {
		
		// Generar el informe en formato Excel
		PersonaQueryBean personaQueryBean = new PersonaQueryBean();
		String idPersona = (String) RequestUtil.getStringParameter(request, "idPersona");
		personaQueryBean.setIdPersona(Long.valueOf(idPersona));

		String username = (String) SecurityAccess.getUserInformation().getUsername();
		String reportName = "etiquetasPersonasReport";
		String reportTitle = this.messageSource.getMessage("page.breadcrumb.persona", null, WebCoreUtils.getLocale());
		String reportType = "PDF";
		String fullReportName = null;
		String contentType = null;
				
		try {
			
			fullReportName = "etiquetaPersonaReport.pdf";
			contentType = "application/pdf";
			
			byte[] byteArray = this.personaService.etiquetaPersona(username, personaQueryBean, reportType, reportName, reportTitle);
					
			response.reset();
			response.setContentType(contentType);
			response.setHeader("Content-disposition", "attachment" + ";filename=\"" + fullReportName + "\"");
			response.addHeader("Pragma", "no cache");
			response.addHeader("Cache-control", "private, must-revalidate");
			
			ServletOutputStream outstream = response.getOutputStream();
			outstream.write(byteArray);
			outstream.flush();
			outstream.close();
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}
		
		return null;
	}
	
	/**
	 * Método que limpia la caché de parámetros de búsqueda. 
	 * @return null
	 */
	@RequestMapping(value="/persona/limpiarBusqueda")
	public String limpiarBusqueda(HttpServletRequest request, HttpServletResponse response) {
		// Almaceno los criterios de búsqueda en sesión de usuario
		request.getSession().setAttribute("personaQueryBean", null);
		request.getSession().setAttribute("buscarPersona", 0);
		
		return null;
	}
	
	/**
	 * Metodo privado que rellena el Formulario de busqueda con los datos provenientes del bean de consulta a la base de datos
	 * @param searchPersonaForm, Formulario vacío
	 * @param personaQueryBean, Objeto con los datos provenientes de base de datos
	 */
	private void toSearchForm(SearchPersonaForm searchPersonaForm, PersonaQueryBean personaQueryBean){
		searchPersonaForm.setApellido1(personaQueryBean.getApellido1());
		searchPersonaForm.setApellido2(personaQueryBean.getApellido2());
		searchPersonaForm.setCodPostal(Utilidades.stringOrNull(personaQueryBean.getCodPostal()));
		searchPersonaForm.setDomicilio(personaQueryBean.getDomicilio());
		searchPersonaForm.setEmail(personaQueryBean.getEmail());
		searchPersonaForm.setEstadoCarta(personaQueryBean.getEstadoCarta());
		searchPersonaForm.setEstadoEtiqueta(personaQueryBean.getEstadoEtiqueta());
		searchPersonaForm.setExpedProhibicion(personaQueryBean.getExpedProhibicion());
		searchPersonaForm.setFechaNacimientoDesde(Utilidades.fromDateOrNull(personaQueryBean.getFechaNacimientoDesde()));
		searchPersonaForm.setFechaNacimientoHasta(Utilidades.fromDateOrNull(personaQueryBean.getFechaNacimientoHasta()));
		searchPersonaForm.setIdMunicipio(Utilidades.stringOrNull(personaQueryBean.getIdMunicipio()));
		searchPersonaForm.setIdPais(Utilidades.stringOrNull(personaQueryBean.getIdPais()));
		searchPersonaForm.setIdPersona(Utilidades.stringOrNull(personaQueryBean.getIdPersona()));
		searchPersonaForm.setNombre(personaQueryBean.getNombre());
		searchPersonaForm.setNumDocIdent(personaQueryBean.getNumDocIdent());
		searchPersonaForm.setObservaciones(personaQueryBean.getObservaciones());
		searchPersonaForm.setSexo(personaQueryBean.getSexo());
		searchPersonaForm.setTelefono(personaQueryBean.getTelefono());
		
		if (personaQueryBean.getDuracion()!=null){
			if (personaQueryBean.getDuracion().length()==2){
				searchPersonaForm.setDurAnos(personaQueryBean.getDuracion());	
			} else if (personaQueryBean.getDuracion().length()==4){
				searchPersonaForm.setDurAnos(personaQueryBean.getDuracion().substring(0, 2));
				searchPersonaForm.setDurMeses(personaQueryBean.getDuracion().substring(2, 4));
			}
		}
		searchPersonaForm.setIdTipoProhibicion(Utilidades.stringOrNull(personaQueryBean.getIdTipoProhibicion()));
		searchPersonaForm.setIdSituacion(Utilidades.stringOrNull(personaQueryBean.getIdSituacion()));
		searchPersonaForm.setIdCausaProhibicion(Utilidades.stringOrNull(personaQueryBean.getIdCausaProhibicion()));
		searchPersonaForm.setFechaProhibicionDesde(Utilidades.fromDateOrNull(personaQueryBean.getFechaProhibicionDesde()));
		searchPersonaForm.setFechaProhibicionHasta(Utilidades.fromDateOrNull(personaQueryBean.getFechaProhibicionHasta()));
		searchPersonaForm.setFechaSituacionDesde(Utilidades.fromDateOrNull(personaQueryBean.getFechaSituacionDesde()));
		searchPersonaForm.setFechaSituacionHasta(Utilidades.fromDateOrNull(personaQueryBean.getFechaSituacionHasta()));
		searchPersonaForm.setObsProhibicion(personaQueryBean.getObsProhibicion());
	}
	
	/**
	 * Peticiones para cargar la visualizacion de un registro.
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param personaForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/persona/startViewPersona")
	public String startViewOperadorJuego(Map<String, Object> map, HttpServletRequest request, PersonaForm personaForm) {

		LOGGER.debug("startViewPersona");
		
		try {
			request.getSession().setAttribute("buscarPersona", 1);
			String id = RequestUtil.getStringParameter(request, "idPersona");
			id = id.replace(' ', '+');
			String decId = new TimestampEncrypter().decryptAndValidate(id, 1000 * viewTimeout );
			
			PersonaQueryBean personaQueryBean = new PersonaQueryBean();
			personaQueryBean.setIdPersona(Long.valueOf(decId));
			
			PersonaBean personaBean = personaService.getPersonaById(Long.valueOf(decId));
			
			if (personaBean == null){
				
				return "redirect:/app/persona/startPersona";
			}
			
			personaBeanToPersonaForm(personaForm, personaBean);

			request.getSession().setAttribute("persona", personaForm);
			
			if ((personaForm.getListaProhibiciones() !=null) && (personaForm.getListaProhibiciones().size()>0)){
				request.getSession().setAttribute("listaProhibiciones", personaForm.getListaProhibiciones());
			} else {
				request.getSession().setAttribute("listaProhibiciones", null);
			}
			
			personaForm.setDetalleProhibiciones(Utilidades.processProhibicionesList(personaForm));

	
			// Rellenando el map de la vista
			fillInitialMap(map, "personaForm");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return Constantes.ERRORPAGE;
		}

		return "tiles/showPersona";
	}

	/**
	 * Peticiones para volver de la visualización de un registro
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param personaForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/persona/endViewPersona")
	public String endViewPersona(Map<String, Object> map, HttpServletRequest request, PersonaForm personaForm, BindingResult result) {
		
		return "redirect:/app/persona/startPersona";
				
	}
	
	
	/**
	 * Metodo privado que rellena el Formulario con los datos provenientes de la base de datos que hay en el bean.
	 * @param PersonaForm, Formulario vacío
	 * @param PersonaBean, Objeto con los datos provenientes de base de datos
	 */
	private void personaBeanToPersonaForm(PersonaForm personaForm, PersonaBean personaBean) {
		personaForm.setIdPersona(personaBean.getIdPersona().toString());
		personaForm.setExpedProhibicion(personaBean.getExpedProhibicion());
		if (personaBean.getTipoDocIdent() != null){
			personaForm.setTipoDocIdent(new TipoDocIdentidadForm(personaBean.getTipoDocIdent()));
			for (ParamBean tipoDocIdentAux : tipoDocIdentidadService.getListaTiposDocIdentidad()){
				if (tipoDocIdentAux.getCode().equalsIgnoreCase(personaBean.getTipoDocIdent().getId().toString())){
					personaForm.setDesTipoDocIdent(tipoDocIdentAux.getDescription());
					break;
				}
			}
		}
		personaForm.setNumDocIdent(personaBean.getNumDocIdent());
		personaForm.setNombre(personaBean.getNombre());
		personaForm.setApellido1(personaBean.getApellido1());
		personaForm.setApellido2(personaBean.getApellido2());
		if(personaBean.getCodPostal() != null){
			personaForm.setCodPostal(personaBean.getCodPostal().toString());
		}
		personaForm.setDomicilio(personaBean.getDomicilio());
		if (personaBean.getSexo() != null){
			personaForm.setSexo(personaBean.getSexo().equalsIgnoreCase("H")?"Hombre":"Mujer");	
		}
		personaForm.setTelefono(personaBean.getTelefono());
		personaForm.setEmail(personaBean.getEmail());
		personaForm.setEstadoCarta(personaBean.getEstadoCarta());
		personaForm.setEstadoEtiqueta(personaBean.getEstadoEtiqueta());
		if(personaBean.getFechaNacimiento() != null){
			
			personaForm.setFechaNacimiento(Utilidades.fromDateOrNull(personaBean.getFechaNacimiento()));
		}
		if(personaBean.getIdMunicipio() != null){
			personaForm.setIdMunicipio(personaBean.getIdMunicipio().toString());
		}
		if(personaBean.getIdPais() != null){
			personaForm.setIdPais(personaBean.getIdPais().toString());
		}
		personaForm.setObservaciones(personaBean.getObservaciones());
		if(personaBean.getLastUpdate() != null){
			personaForm.setLastUpdate(personaBean.getLastUpdate().toString());	
		}
		personaForm.setModifiedBy(personaBean.getModifiedBy());
		if(personaBean.getPendienteCompletar() != null){
			personaForm.setPendienteCompletar(personaBean.getPendienteCompletar().toString());
		}
		if(personaBean.getProvincia() != null){
			personaForm.setProvincia(new ProvinciaForm(personaBean.getProvincia()));	
			for (ParamBean provinciaAux : provinciaService.getListaProvincias()){
				if (provinciaAux.getCode().equalsIgnoreCase(personaBean.getProvincia().getId().toString())){
					personaForm.setDesProvincia(provinciaAux.getDescription());
					break;
				}
			}
			for (ParamBean comunidadAux : comunidadAutonomaService.getListaComunidadesAutonomas()){
				if (comunidadAux.getCode().equalsIgnoreCase(personaBean.getProvincia().getComunidad().getId().toString())){
					personaForm.setDesComunidad(comunidadAux.getDescription());
					break;
				}
			}
		}	
		
		/* Lista de prohibiciones asociadas a la persona */
		personaForm.setListaProhibiciones(new ArrayList<ProhibicionForm>());
		for (ProhibicionBean prohibicion: personaBean.getProhibiciones()){
			if (prohibicion.getTipoProhibicion().getId().compareTo(Long.valueOf(4))!=0){
				personaForm.getListaProhibiciones().add(new ProhibicionForm(prohibicion));	
			}
			
		}
		
		
	}
	
	/**
	 * Metodo privado que rellena el map usado para cargar los contenidos generales de las vistas.
	 * @param map, Mapa vacío
	 * @param tipoForm, nombre del bean del formulario que maneja la vista
	 */
	private void fillInitialMap (Map<String, Object> map, String tipoForm) {
		// Se inserta el nombre del formulario que presenta la vista
		map.put("modelAttribute", tipoForm);
		// Informacion para el renderizado de la pagina
		map.put("firstOptionText", this.messageSource.getMessage("page.common.option.select", null, WebCoreUtils.getLocale()));
		map.put("userLang", WebCoreUtils.getLocale().getLanguage());
	}
}
