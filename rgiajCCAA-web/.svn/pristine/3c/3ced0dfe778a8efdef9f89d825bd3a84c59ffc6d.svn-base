package es.dgoj.rgiaj.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dgoj.core.security.sso.access.SecurityAccess;
import com.dgoj.sprmvc.web.util.RequestUtil;
import com.jeveris.core.persistence.exception.PersistenceException;
import com.jeveris.web.core.utils.WebCoreUtils;

import es.dgoj.rgiaj.business.beans.ComunidadAutonomaBean;
import es.dgoj.rgiaj.business.beans.ComunidadAutonomaQueryBean;
import es.dgoj.rgiaj.business.service.ComunidadAutonomaService;
import es.dgoj.rgiaj.encrypt.TimestampEncrypter;
import es.dgoj.rgiaj.form.ComunidadAutonomaForm;
import es.dgoj.rgiaj.form.SearchComunidadAutonomaForm;
import es.dgoj.rgiaj.util.Utilidades;

/**
 * Clase que gestiona todas las peticiones sincronas realizadas desde la vista de comunidades autonomas.
 * @author connectis
 */
@Controller
@RequestMapping(value = "/comunidadAutonoma/*")
public class ComunidadAutonomaController {
	
	/**
	 * Servicio de mantenimiento de Comunidades Autonomas.
	 */
	@Resource
	private ComunidadAutonomaService comunidadAutonomaService;
	
	/**
	 *  Log de la clase.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ComunidadAutonomaController.class);
	
	/**
	 * Servicio de acceso al contenedor de mensajes de spring.
	 */
	@Resource
	private MessageSource messageSource;

	/**
	 * Tiempo de sesion de la vista
	 */
	@Resource(name="viewTimeout")
	private Long viewTimeout;
	
	/**
	 * Peticiones para cargar la vista.
	 * @param map Contenedor de informacion para la vista
	 * @param request Peticion
	 * @param searchComunidadAutonomaForm Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/comunidadAutonoma/startComunidadAutonoma")
	public String startComunidadAutonoma(Map<String, Object> map, HttpServletRequest request,  SearchComunidadAutonomaForm searchComunidadAutonomaForm) {
		
		try {
			ComunidadAutonomaQueryBean comunidadAutonomaQueryBean = (ComunidadAutonomaQueryBean) request.getSession().getAttribute("comunidadAutonomaQueryBean");
			if (comunidadAutonomaQueryBean != null){
				toSearchForm(searchComunidadAutonomaForm, comunidadAutonomaQueryBean);	
			}
			
			fillInitialMap(map, "searchComunidadAutonomaForm");
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}
		
		return "tiles/comunidadAutonoma";
	}
	
	/**
	 * Peticion para exportar el pdf de Comunidades Autonomas.
	 * 
	 * @param request
	 *            Peticion
	 * @param response
	 *            Respuesta
	 * @return Componente tile al que se redirige (si es correcta la generación del pdf se devuelve null)
	 */
	@RequestMapping(value="/comunidadAutonoma/exportComunidadAutonoma")
	public String exportComunidadAutonoma(HttpServletRequest request, HttpServletResponse response) {
		
		// Generar el informe en formato Excel
		ComunidadAutonomaQueryBean comunidadAutonomaQueryBean = (ComunidadAutonomaQueryBean) request.getSession().getAttribute("comunidadAutonomaQueryBean");
		
		String username = (String) SecurityAccess.getUserInformation().getUsername();

		String reportType = "PDF";
		String reportName = "comunidadAutonomaReport";
		String reportTitle = this.messageSource.getMessage("page.breadcrumb.comunidadAutonoma", null, WebCoreUtils.getLocale());
		
		try {
			byte[] byteArray = this.comunidadAutonomaService.exportComunidadAutonoma(username, comunidadAutonomaQueryBean, reportType, reportName, reportTitle);
			
			response.reset();
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "attachment" + ";filename=\"" + "comunidadAutonomaReport.pdf" + "\"");
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
	 * Peticiones para cargar la vista de Nueva Comunidad Autonoma.
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param comunidadAutonomaForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/comunidadAutonoma/startNewComunidadAutonoma")
	public String startNewComunidadAutonoma(Map<String, Object> map, HttpServletRequest request, ComunidadAutonomaForm comunidadAutonomaForm) {
		LOGGER.debug("startNewComunidadAutonoma");
				
		try {
			// Rellenando el map de la vista
			fillInitialMap(map, "comunidadAutonomaForm");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}

		return "tiles/startNewComunidadAutonoma";
	}
	
	/**
	 * Peticiones para almacenar el Nuevo Registro.
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param comunidadAutonomaForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/comunidadAutonoma/saveNewComunidadAutonoma")
	public String saveNewComunidadAutonoma(Map<String, Object> map, HttpServletRequest request, @Valid ComunidadAutonomaForm comunidadAutonomaForm, BindingResult result) {
		LOGGER.debug("saveNewComunidadAutonoma");
		
		// Comprobacion de campos del formulario
		if (result.hasErrors()) {
			LOGGER.error("Hay errores en el formulario");
			return retornoErrorComunidadAutonoma("New", "Hay errores en el formulario", map, comunidadAutonomaForm);
		} else { // Todos los campos del formulario completos no hay errores
			try{				
				/* Comprueba si no existe ya el tipo de prohibicion */
				if (comunidadAutonomaService.getComunidadAutonomaByCodigo(comunidadAutonomaForm.getCodigo())!=null){
					LOGGER.error("Ya existe un tipo de prohibicion con el codigo: "+comunidadAutonomaForm.getCodigo());
					return retornoErrorComunidadAutonoma("New", "Ya existe un tipo de prohibicion con el codigo: "+comunidadAutonomaForm.getCodigo(), map, comunidadAutonomaForm);
				}
				
				ComunidadAutonomaBean comunidadAutonomaBean = new ComunidadAutonomaBean();
				comunidadAutonomaFormToComunidadAutonomaBean (comunidadAutonomaForm, comunidadAutonomaBean);
			
				comunidadAutonomaService.altaComunidadAutonoma(comunidadAutonomaBean, SecurityAccess.getUserInformation());
					
			} catch (PersistenceException e){
				LOGGER.error("Error en el alta: "+e.getMessage());
				return retornoErrorComunidadAutonoma("New", "Error al guardar el Tipo de Prohibicion", map, comunidadAutonomaForm);
			} catch (ParseException e) {
				LOGGER.error("Error en el alta: "+e.getMessage());
				return retornoErrorComunidadAutonoma("New", "Error al guardar el Tipo de Prohibicion", map, comunidadAutonomaForm);
			} 
			
			return "redirect:/app/comunidadAutonoma/startComunidadAutonoma";
		}
		
	}
	
	/**
	 * Peticiones para cargar la vista de editar una comunidad autonoma a partir de la 
	 * pantalla de consulta de comunidades autonomas.
	 * @param map Contenedor de informacion para la vista
	 * @param request Peticion
	 * @param comunidadAutonomaForm Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/comunidadAutonoma/startEditComunidadAutonoma")
	public String startEditComunidadAutonoma(Map<String, Object> map, HttpServletRequest request, ComunidadAutonomaForm comunidadAutonomaForm) {

		LOGGER.debug("startEditComunidadAutonoma");
		String id = RequestUtil.getStringParameter(request, "id");
		id = id.replace(' ', '+');
		String decId = new TimestampEncrypter().decryptAndValidate(id, 1000 * viewTimeout );
		
		ComunidadAutonomaBean comunidadAutonomaBean = comunidadAutonomaService.getComunidadAutonomaById(Long.valueOf(decId));
		
		comunidadAutonomaBeanToComunidadAutonomaForm(comunidadAutonomaBean, comunidadAutonomaForm);
				
		try {
			// Rellenando el map de la vista
			fillInitialMap(map, "comunidadAutonomaForm");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}

		return "tiles/startEditComunidadAutonoma";
	}
	
	/**
	 * Peticiones para almacenar el Nuevo Registro
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param comunidadAutonomaForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/comunidadAutonoma/saveEditComunidadAutonoma")
	public String saveEditComunidadAutonoma(Map<String, Object> map, HttpServletRequest request, @Valid ComunidadAutonomaForm comunidadAutonomaForm, BindingResult result) {
		LOGGER.debug("saveEditComunidadAutonoma");
		
		// Comprobacion de campos del formulario
		if (result.hasErrors()) {
			LOGGER.error("Hay errores en el formulario");
			return retornoErrorComunidadAutonoma("Edit", "Hay errores en el formulario", map, comunidadAutonomaForm);
			
		} else { // Todos los campos del formulario completos no hay errores
			try{				
				if (comunidadAutonomaService.getComunidadAutonomaByCodigoNoID(Long.valueOf(comunidadAutonomaForm.getId()), comunidadAutonomaForm.getCodigo())!=null){
					LOGGER.error("Ya existe un jugador de prueba con el codigo: "+comunidadAutonomaForm.getCodigo());
					return retornoErrorComunidadAutonoma("Edit", "Ya existe un tipo de prohibicion con el codigo: "+comunidadAutonomaForm.getCodigo(), map, comunidadAutonomaForm);
				}

				ComunidadAutonomaBean comunidadAutonomaBean = new ComunidadAutonomaBean();
				comunidadAutonomaFormToComunidadAutonomaBean (comunidadAutonomaForm, comunidadAutonomaBean);
			
				comunidadAutonomaService.editarComunidadAutonoma(comunidadAutonomaBean, SecurityAccess.getUserInformation());
					
			} catch (PersistenceException e){
				LOGGER.error("Error en la edicion: "+e.getMessage());
				return retornoErrorComunidadAutonoma("Edit", "Error al guardar el tipo de prohibicion", map, comunidadAutonomaForm);
			} catch (ParseException e) {
				LOGGER.error("Error en la edicion: "+e.getMessage());
				return retornoErrorComunidadAutonoma("Edit", "Error al guardar el tipo de prohibicion", map, comunidadAutonomaForm);
			} 

			return "redirect:/app/comunidadAutonoma/startComunidadAutonoma";
		}
		
	}
	
	/**
	 * Genera un mensaje de error por pantalla y rellena los datos necesarios para volver a la pantalla indicada
	 * 
	 * @param tipo
	 *            Tendrá valores "Edit" o "New" dependiendo a la pantalla que se deba volver
	 * @param mensaje
	 *            Mensaje de error que se mostrará al usuario
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param comunidadAutonomaForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	private String retornoErrorComunidadAutonoma(String tipo, String mensaje, Map<String, Object> map, ComunidadAutonomaForm comunidadAutonomaForm){
		
		comunidadAutonomaForm.setError(mensaje);
		
		// Rellenando el map de la vista
		fillInitialMap(map, "comunidadAutonomaForm");
		
		if (tipo.equalsIgnoreCase("Edit")){
			return "tiles/startEditComunidadAutonoma";
		} else if (tipo.equalsIgnoreCase("New")){
			return "tiles/startNewComunidadAutonoma";
		} else {
			return "app/errorPage";
		}
	}
	
	/**
	 * Método que limpia la caché de parámetros de búsqueda. 
	 * @return null
	 */
	@RequestMapping(value="/comunidadAutonoma/limpiarBusqueda")
	public String limpiarBusqueda(HttpServletRequest request, HttpServletResponse response) {
		// Almaceno los criterios de búsqueda en sesión de usuario
		request.getSession().setAttribute("comunidadAutonomaQueryBean", null);
		request.getSession().setAttribute("buscar", 0);
		
		return null;
	}
	
	/**
	 * Metodo privado que rellena el Formulario de busqueda con los datos provenientes del bean de consulta a la base de datos
	 * @param searchComunidadAutonomaForm, Formulario vacío
	 * @param comunidadAutonomaQueryBean, Objeto con los datos provenientes de base de datos
	 */
	private void toSearchForm(SearchComunidadAutonomaForm searchComunidadAutonomaForm, ComunidadAutonomaQueryBean comunidadAutonomaQueryBean){
		searchComunidadAutonomaForm.setId(Utilidades.stringOrNull(comunidadAutonomaQueryBean.getId()));
		searchComunidadAutonomaForm.setCodigo(comunidadAutonomaQueryBean.getCodigo());
		searchComunidadAutonomaForm.setDescripcion(comunidadAutonomaQueryBean.getDescripcion());
		searchComunidadAutonomaForm.setActivo(comunidadAutonomaQueryBean.getActivo());
	}
	
	/**
	 * Metodo privado que rellena el Formulario con los datos provenientes de la base de datos que hay en el bean.
	 * @param comunidadAutonomaForm, Formulario vacío
	 * @param comunidadAutonomaBean, Objeto con los datos provenientes de base de datos
	 */
	private void comunidadAutonomaBeanToComunidadAutonomaForm(ComunidadAutonomaBean comunidadAutonomaBean, ComunidadAutonomaForm comunidadAutonomaForm) {
		comunidadAutonomaForm.setId(comunidadAutonomaBean.getId().toString());
		comunidadAutonomaForm.setCodigo(comunidadAutonomaBean.getCodigo());
		comunidadAutonomaForm.setDescripcion(comunidadAutonomaBean.getDescripcion());
		comunidadAutonomaForm.setActivo(comunidadAutonomaBean.getActivo());
	}
	
	/**
	 * Metodo privado que rellena el Bean con los datos provenientes del formulario.
	 * @param comunidadAutonomaForm, Formulario relleno de la pantalla
	 * @param comunidadAutonomaBean, Objeto vacio
	 * @throws ParseException 
	 */
	private void comunidadAutonomaFormToComunidadAutonomaBean(ComunidadAutonomaForm comunidadAutonomaForm, ComunidadAutonomaBean comunidadAutonomaBean) throws ParseException {
		if (comunidadAutonomaForm.getId()!=null){
			comunidadAutonomaBean.setId(Long.valueOf(comunidadAutonomaForm.getId()));
		}
		comunidadAutonomaBean.setCodigo(comunidadAutonomaForm.getCodigo());
		comunidadAutonomaBean.setDescripcion(comunidadAutonomaForm.getDescripcion());
		comunidadAutonomaBean.setActivo(comunidadAutonomaForm.getActivo());
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
