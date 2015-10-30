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

import es.dgoj.rgiaj.business.beans.TipoDocIdentidadBean;
import es.dgoj.rgiaj.business.beans.TipoDocIdentidadQueryBean;
import es.dgoj.rgiaj.business.service.TipoDocIdentidadService;
import es.dgoj.rgiaj.encrypt.TimestampEncrypter;
import es.dgoj.rgiaj.form.SearchTipoDocIdentidadForm;
import es.dgoj.rgiaj.form.TipoDocIdentidadForm;
import es.dgoj.rgiaj.util.Utilidades;

/**
 * Clase que gestiona todas las peticiones sincronas realizadas desde la vista de tipos de documento de identidad.
 * @author connectis
 */
@Controller
@RequestMapping(value = "/tipoDocIdentidad/*")
public class TipoDocIdentidadController {
	
	/**
	 * Servicio de mantenimiento de tipos de documento de identidad
	 */
	@Resource
	private TipoDocIdentidadService tipoDocIdentidadService;
	
	/**
	 *  Log de la clase.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(TipoDocIdentidadController.class);
	
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
	 * @param searchTipoDocIdentidadForm Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/tipoDocIdentidad/startTipoDocIdentidad")
	public String startTipoDocIdentidad(Map<String, Object> map, HttpServletRequest request,  SearchTipoDocIdentidadForm searchTipoDocIdentidadForm) {
		
		try {
			TipoDocIdentidadQueryBean tipoDocIdentidadQueryBean = (TipoDocIdentidadQueryBean) request.getSession().getAttribute("tipoDocIdentidadQueryBean");
			if (tipoDocIdentidadQueryBean != null){
				toSearchForm(searchTipoDocIdentidadForm, tipoDocIdentidadQueryBean);	
			}
			
			fillInitialMap(map, "searchTipoDocIdentidadForm");
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}
		
		return "tiles/tipoDocIdentidad";
	}
	
	/**
	 * Peticion para exportar el pdf de tipos de documento de identidad
	 * 
	 * @param request
	 *            Peticion
	 * @param response
	 *            Respuesta
	 * @return Componente tile al que se redirige (si es correcta la generación del pdf se devuelve null)
	 */
	@RequestMapping(value="/tipoDocIdentidad/exportTipoDocIdentidad")
	public String exportTipoDocIdentidad(HttpServletRequest request, HttpServletResponse response) {
		
		// Generar el informe en formato Excel
		TipoDocIdentidadQueryBean tipoDocIdentidadQueryBean = (TipoDocIdentidadQueryBean) request.getSession().getAttribute("tipoDocIdentidadQueryBean");
		
		String username = (String) SecurityAccess.getUserInformation().getUsername();

		String reportType = "PDF";
		String reportName = "tipoDocIdentidadReport";
		String reportTitle = this.messageSource.getMessage("page.breadcrumb.tipoDocIdentidad", null, WebCoreUtils.getLocale());
		
		try {
			byte[] byteArray = this.tipoDocIdentidadService.exportTipoDocIdentidad(username, tipoDocIdentidadQueryBean, reportType, reportName, reportTitle);
			
			response.reset();
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "attachment" + ";filename=\"" + "tipoDocIdentidadReport.pdf" + "\"");
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
	 * Peticiones para cargar la vista de Nuevo tipo de documento de identidad
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param tipoDocIdentidadForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/tipoDocIdentidad/startNewTipoDocIdentidad")
	public String startNewTipoDocIdentidad(Map<String, Object> map, HttpServletRequest request, TipoDocIdentidadForm tipoDocIdentidadForm) {
		LOGGER.debug("startNewTipoDocIdentidad");
				
		try {
			// Rellenando el map de la vista
			fillInitialMap(map, "tipoDocIdentidadForm");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}

		return "tiles/startNewTipoDocIdentidad";
	}
	
	/**
	 * Peticiones para almacenar el Nuevo Registro.
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param tipoDocIdentidadForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/tipoDocIdentidad/saveNewTipoDocIdentidad")
	public String saveNewTipoDocIdentidad(Map<String, Object> map, HttpServletRequest request, @Valid TipoDocIdentidadForm tipoDocIdentidadForm, BindingResult result) {
		LOGGER.debug("saveNewTipoDocIdentidad");
		
		// Comprobacion de campos del formulario
		if (result.hasErrors()) {
			LOGGER.error("Hay errores en el formulario");
			return retornoErrorTipoDocIdentidad("New", "Hay errores en el formulario", map, tipoDocIdentidadForm);
		} else { // Todos los campos del formulario completos no hay errores
			try{				
				/* Comprueba si no existe ya el tipo de documento de identidad */
				if (tipoDocIdentidadService.getTipoDocIdentidadByCodigo(tipoDocIdentidadForm.getCodigo())!=null){
					LOGGER.error("Ya existe un tipo de documento de identidad: "+tipoDocIdentidadForm.getCodigo());
					return retornoErrorTipoDocIdentidad("New", "Ya existe un tipo de documento de identidad con el codigo: "+tipoDocIdentidadForm.getCodigo(), map, tipoDocIdentidadForm);
				}
				
				TipoDocIdentidadBean tipoDocIdentidadBean = new TipoDocIdentidadBean();
				tipoDocIdentidadFormToTipoDocIdentidadBean (tipoDocIdentidadForm, tipoDocIdentidadBean);
			
				tipoDocIdentidadService.altaTipoDocIdentidad(tipoDocIdentidadBean, SecurityAccess.getUserInformation());
					
			} catch (PersistenceException e){
				LOGGER.error("Error en el alta: "+e.getMessage());
				return retornoErrorTipoDocIdentidad("New", "Error al guardar el tipo de documento de identidad", map, tipoDocIdentidadForm);
			} catch (ParseException e) {
				LOGGER.error("Error en el alta: "+e.getMessage());
				return retornoErrorTipoDocIdentidad("New", "Error al guardar el tipo de documento de identidad", map, tipoDocIdentidadForm);
			} 
			
			return "redirect:/app/tipoDocIdentidad/startTipoDocIdentidad";
		}
		
	}
	
	/**
	 * Peticiones para cargar la vista de editar un jugador de prueba a partir de la 
	 * pantalla de consulta de tipos de documento de identidad.
	 * @param map Contenedor de informacion para la vista
	 * @param request Peticion
	 * @param tipoDocIdentidadForm Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/tipoDocIdentidad/startEditTipoDocIdentidad")
	public String startEditTipoDocIdentidad(Map<String, Object> map, HttpServletRequest request, TipoDocIdentidadForm tipoDocIdentidadForm) {

		LOGGER.debug("startEditTipoDocIdentidad");
		String id = RequestUtil.getStringParameter(request, "id");
		id = id.replace(' ', '+');
		String decId = new TimestampEncrypter().decryptAndValidate(id, 1000 * viewTimeout );
		
		TipoDocIdentidadBean tipoDocIdentidadBean = tipoDocIdentidadService.getTipoDocIdentidadById(Long.valueOf(decId));
		
		tipoDocIdentidadBeanToTipoDocIdentidadForm(tipoDocIdentidadBean, tipoDocIdentidadForm);
				
		try {
			// Rellenando el map de la vista
			fillInitialMap(map, "tipoDocIdentidadForm");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}

		return "tiles/startEditTipoDocIdentidad";
	}
	
	/**
	 * Peticiones para almacenar el Nuevo Registro
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param tipoDocIdentidadForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/tipoDocIdentidad/saveEditTipoDocIdentidad")
	public String saveEditTipoDocIdentidad(Map<String, Object> map, HttpServletRequest request, @Valid TipoDocIdentidadForm tipoDocIdentidadForm, BindingResult result) {
		LOGGER.debug("saveEditTipoDocIdentidad");
		
		// Comprobacion de campos del formulario
		if (result.hasErrors()) {
			LOGGER.error("Hay errores en el formulario");
			return retornoErrorTipoDocIdentidad("Edit", "Hay errores en el formulario", map, tipoDocIdentidadForm);
			
		} else { // Todos los campos del formulario completos no hay errores
			try{				
				if (tipoDocIdentidadService.getTipoDocIdentidadByCodigoNoID(Long.valueOf(tipoDocIdentidadForm.getId()), tipoDocIdentidadForm.getCodigo())!=null){
					LOGGER.error("Ya existe un tipo de documento de identidad con el codigo: "+tipoDocIdentidadForm.getCodigo());
					return retornoErrorTipoDocIdentidad("Edit", "Ya existe un tipo de documento de identidad con el codigo: "+tipoDocIdentidadForm.getCodigo(), map, tipoDocIdentidadForm);
				}

				TipoDocIdentidadBean tipoDocIdentidadBean = new TipoDocIdentidadBean();
				tipoDocIdentidadFormToTipoDocIdentidadBean (tipoDocIdentidadForm, tipoDocIdentidadBean);
			
				tipoDocIdentidadService.editarTipoDocIdentidad(tipoDocIdentidadBean, SecurityAccess.getUserInformation());
					
			} catch (PersistenceException e){
				LOGGER.error("Error en la edicion: "+e.getMessage());
				return retornoErrorTipoDocIdentidad("Edit", "Error al guardar el tipo de documento de identidad", map, tipoDocIdentidadForm);
			} catch (ParseException e) {
				LOGGER.error("Error en la edicion: "+e.getMessage());
				return retornoErrorTipoDocIdentidad("Edit", "Error al guardar el tipo de documento de identidad", map, tipoDocIdentidadForm);
			} 

			return "redirect:/app/tipoDocIdentidad/startTipoDocIdentidad";
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
	 * @param tipoDocIdentidadForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	private String retornoErrorTipoDocIdentidad(String tipo, String mensaje, Map<String, Object> map, TipoDocIdentidadForm tipoDocIdentidadForm){
		
		tipoDocIdentidadForm.setError(mensaje);
		
		// Rellenando el map de la vista
		fillInitialMap(map, "tipoDocIdentidadForm");
		
		if (tipo.equalsIgnoreCase("Edit")){
			return "tiles/startEditTipoDocIdentidad";
		} else if (tipo.equalsIgnoreCase("New")){
			return "tiles/startNewTipoDocIdentidad";
		} else {
			return "app/errorPage";
		}
	}
	
	/**
	 * Método que limpia la caché de parámetros de búsqueda. 
	 * @return null
	 */
	@RequestMapping(value="/tipoDocIdentidad/limpiarBusqueda")
	public String limpiarBusqueda(HttpServletRequest request, HttpServletResponse response) {
		// Almaceno los criterios de búsqueda en sesión de usuario
		request.getSession().setAttribute("tipoDocIdentidadQueryBean", null);
		request.getSession().setAttribute("buscar", 0);
		
		return null;
	}
	
	/**
	 * Metodo privado que rellena el Formulario de busqueda con los datos provenientes del bean de consulta a la base de datos
	 * @param searchTipoDocIdentidadForm, Formulario vacío
	 * @param tipoDocIdentidadQueryBean, Objeto con los datos provenientes de base de datos
	 */
	private void toSearchForm(SearchTipoDocIdentidadForm searchTipoDocIdentidadForm, TipoDocIdentidadQueryBean tipoDocIdentidadQueryBean){
		searchTipoDocIdentidadForm.setId(Utilidades.stringOrNull(tipoDocIdentidadQueryBean.getId()));
		searchTipoDocIdentidadForm.setCodigo(tipoDocIdentidadQueryBean.getCodigo());
		searchTipoDocIdentidadForm.setDescripcion(tipoDocIdentidadQueryBean.getDescripcion());
		searchTipoDocIdentidadForm.setActivo(tipoDocIdentidadQueryBean.getActivo());
	}
	
	/**
	 * Metodo privado que rellena el Formulario con los datos provenientes de la base de datos que hay en el bean.
	 * @param tipoDocIdentidadForm, Formulario vacío
	 * @param tipoDocIdentidadBean, Objeto con los datos provenientes de base de datos
	 */
	private void tipoDocIdentidadBeanToTipoDocIdentidadForm(TipoDocIdentidadBean tipoDocIdentidadBean, TipoDocIdentidadForm tipoDocIdentidadForm) {
		tipoDocIdentidadForm.setId(tipoDocIdentidadBean.getId().toString());
		tipoDocIdentidadForm.setCodigo(tipoDocIdentidadBean.getCodigo());
		tipoDocIdentidadForm.setDescripcion(tipoDocIdentidadBean.getDescripcion());
		tipoDocIdentidadForm.setActivo(tipoDocIdentidadBean.getActivo());
	}
	
	/**
	 * Metodo privado que rellena el Bean con los datos provenientes del formulario.
	 * @param tipoDocIdentidadForm, Formulario relleno de la pantalla
	 * @param tipoDocIdentidadBean, Objeto vacio
	 * @throws ParseException 
	 */
	private void tipoDocIdentidadFormToTipoDocIdentidadBean(TipoDocIdentidadForm tipoDocIdentidadForm, TipoDocIdentidadBean tipoDocIdentidadBean) throws ParseException {
		if (tipoDocIdentidadForm.getId()!=null){
			tipoDocIdentidadBean.setId(Long.valueOf(tipoDocIdentidadForm.getId()));
		}
		tipoDocIdentidadBean.setCodigo(tipoDocIdentidadForm.getCodigo());
		tipoDocIdentidadBean.setDescripcion(tipoDocIdentidadForm.getDescripcion());
		tipoDocIdentidadBean.setActivo(tipoDocIdentidadForm.getActivo());
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
