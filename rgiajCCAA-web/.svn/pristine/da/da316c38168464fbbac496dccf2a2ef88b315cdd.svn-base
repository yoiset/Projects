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

import es.dgoj.rgiaj.business.beans.TipoProhibicionBean;
import es.dgoj.rgiaj.business.beans.TipoProhibicionQueryBean;
import es.dgoj.rgiaj.business.service.TipoProhibicionService;
import es.dgoj.rgiaj.encrypt.TimestampEncrypter;
import es.dgoj.rgiaj.form.SearchTipoProhibicionForm;
import es.dgoj.rgiaj.form.TipoProhibicionForm;
import es.dgoj.rgiaj.util.Utilidades;

/**
 * Clase que gestiona todas las peticiones sincronas realizadas desde la vista de tipos de prohibicion.
 * @author connectis
 */
@Controller
@RequestMapping(value = "/tipoProhibicion/*")
public class TipoProhibicionController {
	
	/**
	 * Servicio de mantenimiento de Tipos de Prohibicion
	 */
	@Resource
	private TipoProhibicionService tipoProhibicionService;
	
	/**
	 *  Log de la clase.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(TipoProhibicionController.class);
	
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
	 * @param searchTipoProhibicionForm Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/tipoProhibicion/startTipoProhibicion")
	public String startTipoProhibicion(Map<String, Object> map, HttpServletRequest request,  SearchTipoProhibicionForm searchTipoProhibicionForm) {
		
		try {
			TipoProhibicionQueryBean tipoProhibicionQueryBean = (TipoProhibicionQueryBean) request.getSession().getAttribute("tipoProhibicionQueryBean");
			if (tipoProhibicionQueryBean != null){
				toSearchForm(searchTipoProhibicionForm, tipoProhibicionQueryBean);	
			}
			
			fillInitialMap(map, "searchTipoProhibicionForm");
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}
		
		return "tiles/tipoProhibicion";
	}
	
	/**
	 * Peticion para exportar el pdf de Tipos de Prohibicion
	 * 
	 * @param request
	 *            Peticion
	 * @param response
	 *            Respuesta
	 * @return Componente tile al que se redirige (si es correcta la generación del pdf se devuelve null)
	 */
	@RequestMapping(value="/tipoProhibicion/exportTipoProhibicion")
	public String exportTipoProhibicion(HttpServletRequest request, HttpServletResponse response) {
		
		// Generar el informe en formato Excel
		TipoProhibicionQueryBean tipoProhibicionQueryBean = (TipoProhibicionQueryBean) request.getSession().getAttribute("tipoProhibicionQueryBean");
		
		String username = (String) SecurityAccess.getUserInformation().getUsername();

		String reportType = "PDF";
		String reportName = "tipoProhibicionReport";
		String reportTitle = this.messageSource.getMessage("page.breadcrumb.tipoProhibicion", null, WebCoreUtils.getLocale());
		
		try {
			byte[] byteArray = this.tipoProhibicionService.exportTipoProhibicion(username, tipoProhibicionQueryBean, reportType, reportName, reportTitle);
			
			response.reset();
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "attachment" + ";filename=\"" + "tipoProhibicionReport.pdf" + "\"");
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
	 * Peticiones para cargar la vista de Nuevo Tipo de Prohibicion
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param tipoProhibicionForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/tipoProhibicion/startNewTipoProhibicion")
	public String startNewTipoProhibicion(Map<String, Object> map, HttpServletRequest request, TipoProhibicionForm tipoProhibicionForm) {
		LOGGER.debug("startNewTipoProhibicion");
				
		try {
			// Rellenando el map de la vista
			fillInitialMap(map, "tipoProhibicionForm");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}

		return "tiles/startNewTipoProhibicion";
	}
	
	/**
	 * Peticiones para almacenar el Nuevo Registro.
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param tipoProhibicionForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/tipoProhibicion/saveNewTipoProhibicion")
	public String saveNewTipoProhibicion(Map<String, Object> map, HttpServletRequest request, @Valid TipoProhibicionForm tipoProhibicionForm, BindingResult result) {
		LOGGER.debug("saveNewTipoProhibicion");
		
		// Comprobacion de campos del formulario
		if (result.hasErrors()) {
			LOGGER.error("Hay errores en el formulario");
			return retornoErrorTipoProhibicion("New", "Hay errores en el formulario", map, tipoProhibicionForm);
		} else { // Todos los campos del formulario completos no hay errores
			try{				
				/* Comprueba si no existe ya el tipo de prohibicion */
				if (tipoProhibicionService.getTipoProhibicionByCodigo(tipoProhibicionForm.getCodigo())!=null){
					LOGGER.error("Ya existe un tipo de prohibicion con el codigo: "+tipoProhibicionForm.getCodigo());
					return retornoErrorTipoProhibicion("New", "Ya existe un tipo de prohibicion con el codigo: "+tipoProhibicionForm.getCodigo(), map, tipoProhibicionForm);
				}
				
				TipoProhibicionBean tipoProhibicionBean = new TipoProhibicionBean();
				tipoProhibicionFormToTipoProhibicionBean (tipoProhibicionForm, tipoProhibicionBean);
			
				tipoProhibicionService.altaTipoProhibicion(tipoProhibicionBean, SecurityAccess.getUserInformation());
					
			} catch (PersistenceException e){
				LOGGER.error("Error en el alta: "+e.getMessage());
				return retornoErrorTipoProhibicion("New", "Error al guardar el Tipo de Prohibicion", map, tipoProhibicionForm);
			} catch (ParseException e) {
				LOGGER.error("Error en el alta: "+e.getMessage());
				return retornoErrorTipoProhibicion("New", "Error al guardar el Tipo de Prohibicion", map, tipoProhibicionForm);
			} 
			
			return "redirect:/app/tipoProhibicion/startTipoProhibicion";
		}
		
	}
	
	/**
	 * Peticiones para cargar la vista de editar un tipo de prohibicion a partir de la 
	 * pantalla de consulta de tipos de prohibicion.
	 * @param map Contenedor de informacion para la vista
	 * @param request Peticion
	 * @param tipoProhibicionForm Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/tipoProhibicion/startEditTipoProhibicion")
	public String startEditTipoProhibicion(Map<String, Object> map, HttpServletRequest request, TipoProhibicionForm tipoProhibicionForm) {

		LOGGER.debug("startEditTipoProhibicion");
		String id = RequestUtil.getStringParameter(request, "id");
		id = id.replace(' ', '+');
		String decId = new TimestampEncrypter().decryptAndValidate(id, 1000 * viewTimeout );
		
		TipoProhibicionBean tipoProhibicionBean = tipoProhibicionService.getTipoProhibicionById(Long.valueOf(decId));
		
		tipoProhibicionBeanToTipoProhibicionForm(tipoProhibicionBean, tipoProhibicionForm);
				
		try {
			// Rellenando el map de la vista
			fillInitialMap(map, "tipoProhibicionForm");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}

		return "tiles/startEditTipoProhibicion";
	}
	
	/**
	 * Peticiones para almacenar el Nuevo Registro
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param tipoProhibicionForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/tipoProhibicion/saveEditTipoProhibicion")
	public String saveEditTipoProhibicion(Map<String, Object> map, HttpServletRequest request, @Valid TipoProhibicionForm tipoProhibicionForm, BindingResult result) {
		LOGGER.debug("saveEditTipoProhibicion");
		
		// Comprobacion de campos del formulario
		if (result.hasErrors()) {
			LOGGER.error("Hay errores en el formulario");
			return retornoErrorTipoProhibicion("Edit", "Hay errores en el formulario", map, tipoProhibicionForm);
			
		} else { // Todos los campos del formulario completos no hay errores
			try{				
				if (tipoProhibicionService.getTipoProhibicionByCodigoNoID(Long.valueOf(tipoProhibicionForm.getId()), tipoProhibicionForm.getCodigo())!=null){
					LOGGER.error("Ya existe un tipo de prohibicion con el codigo: "+tipoProhibicionForm.getCodigo());
					return retornoErrorTipoProhibicion("Edit", "Ya existe un tipo de prohibicion con el codigo: "+tipoProhibicionForm.getCodigo(), map, tipoProhibicionForm);
				}

				TipoProhibicionBean tipoProhibicionBean = new TipoProhibicionBean();
				tipoProhibicionFormToTipoProhibicionBean (tipoProhibicionForm, tipoProhibicionBean);
			
				tipoProhibicionService.editarTipoProhibicion(tipoProhibicionBean, SecurityAccess.getUserInformation());
					
			} catch (PersistenceException e){
				LOGGER.error("Error en la edicion: "+e.getMessage());
				return retornoErrorTipoProhibicion("Edit", "Error al guardar el tipo de prohibicion", map, tipoProhibicionForm);
			} catch (ParseException e) {
				LOGGER.error("Error en la edicion: "+e.getMessage());
				return retornoErrorTipoProhibicion("Edit", "Error al guardar el tipo de prohibicion", map, tipoProhibicionForm);
			} 

			return "redirect:/app/tipoProhibicion/startTipoProhibicion";
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
	 * @param tipoProhibicionForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	private String retornoErrorTipoProhibicion(String tipo, String mensaje, Map<String, Object> map, TipoProhibicionForm tipoProhibicionForm){
		
		tipoProhibicionForm.setError(mensaje);
		
		// Rellenando el map de la vista
		fillInitialMap(map, "tipoProhibicionForm");
		
		if (tipo.equalsIgnoreCase("Edit")){
			return "tiles/startEditTipoProhibicion";
		} else if (tipo.equalsIgnoreCase("New")){
			return "tiles/startNewTipoProhibicion";
		} else {
			return "app/errorPage";
		}
	}
	
	/**
	 * Método que limpia la caché de parámetros de búsqueda. 
	 * @return null
	 */
	@RequestMapping(value="/tipoProhibicion/limpiarBusqueda")
	public String limpiarBusqueda(HttpServletRequest request, HttpServletResponse response) {
		// Almaceno los criterios de búsqueda en sesión de usuario
		request.getSession().setAttribute("tipoProhibicionQueryBean", null);
		request.getSession().setAttribute("buscar", 0);
		
		return null;
	}
	
	/**
	 * Metodo privado que rellena el Formulario de busqueda con los datos provenientes del bean de consulta a la base de datos
	 * @param tipoProhibicionForm, Formulario vacío
	 * @param tipoProhibicionBean, Objeto con los datos provenientes de base de datos
	 */
	private void toSearchForm(SearchTipoProhibicionForm searchTipoProhibicionForm, TipoProhibicionQueryBean tipoProhibicionQueryBean){
		searchTipoProhibicionForm.setId(Utilidades.stringOrNull(tipoProhibicionQueryBean.getId()));
		searchTipoProhibicionForm.setCodigo(tipoProhibicionQueryBean.getCodigo());
		searchTipoProhibicionForm.setDescripcion(tipoProhibicionQueryBean.getDescripcion());
		searchTipoProhibicionForm.setActivo(tipoProhibicionQueryBean.getActivo());
	}
	
	/**
	 * Metodo privado que rellena el Formulario con los datos provenientes de la base de datos que hay en el bean.
	 * @param tipoProhibicionForm, Formulario vacío
	 * @param tipoProhibicionBean, Objeto con los datos provenientes de base de datos
	 */
	private void tipoProhibicionBeanToTipoProhibicionForm(TipoProhibicionBean tipoProhibicionBean, TipoProhibicionForm tipoProhibicionForm) {
		tipoProhibicionForm.setId(tipoProhibicionBean.getId().toString());
		tipoProhibicionForm.setCodigo(tipoProhibicionBean.getCodigo());
		tipoProhibicionForm.setDescripcion(tipoProhibicionBean.getDescripcion());
		tipoProhibicionForm.setActivo(tipoProhibicionBean.getActivo());
	}
	
	/**
	 * Metodo privado que rellena el Bean con los datos provenientes del formulario.
	 * @param tipoProhibicionForm, Formulario relleno de la pantalla
	 * @param tipoProhibicionBean, Objeto vacio
	 * @throws ParseException 
	 */
	private void tipoProhibicionFormToTipoProhibicionBean(TipoProhibicionForm tipoProhibicionForm, TipoProhibicionBean tipoProhibicionBean) throws ParseException {
		if (tipoProhibicionForm.getId()!=null){
			tipoProhibicionBean.setId(Long.valueOf(tipoProhibicionForm.getId()));
		}
		tipoProhibicionBean.setCodigo(tipoProhibicionForm.getCodigo());
		tipoProhibicionBean.setDescripcion(tipoProhibicionForm.getDescripcion());
		tipoProhibicionBean.setActivo(tipoProhibicionForm.getActivo());
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
