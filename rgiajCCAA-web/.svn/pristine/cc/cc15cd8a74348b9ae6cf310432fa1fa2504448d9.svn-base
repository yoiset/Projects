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

import es.dgoj.rgiaj.business.beans.CausaProhibicionBean;
import es.dgoj.rgiaj.business.beans.CausaProhibicionQueryBean;
import es.dgoj.rgiaj.business.service.CausaProhibicionService;
import es.dgoj.rgiaj.encrypt.TimestampEncrypter;
import es.dgoj.rgiaj.form.CausaProhibicionForm;
import es.dgoj.rgiaj.form.SearchCausaProhibicionForm;
import es.dgoj.rgiaj.util.Utilidades;

/**
 * Clase que gestiona todas las peticiones sincronas realizadas desde la vista de causas de prohibicion.
 * @author connectis
 */
@Controller
@RequestMapping(value = "/causaProhibicion/*")
public class CausaProhibicionController {
	
	/**
	 * Servicio de mantenimiento de Causas de prohibicion
	 */
	@Resource
	private CausaProhibicionService causaProhibicionService;
	
	/**
	 *  Log de la clase.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CausaProhibicionController.class);
	
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
	 * @param searchCausaProhibicionForm Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/causaProhibicion/startCausaProhibicion")
	public String startCausaProhibicion(Map<String, Object> map, HttpServletRequest request,  SearchCausaProhibicionForm searchCausaProhibicionForm) {
		
		try {
			CausaProhibicionQueryBean causaProhibicionQueryBean = (CausaProhibicionQueryBean) request.getSession().getAttribute("causaProhibicionQueryBean");
			if (causaProhibicionQueryBean != null){
				toSearchForm(searchCausaProhibicionForm, causaProhibicionQueryBean);	
			}
			
			fillInitialMap(map, "searchCausaProhibicionForm");
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}
		
		return "tiles/causaProhibicion";
	}
	
	/**
	 * Peticion para exportar el pdf de Causas de prohibicion
	 * 
	 * @param request
	 *            Peticion
	 * @param response
	 *            Respuesta
	 * @return Componente tile al que se redirige (si es correcta la generación del pdf se devuelve null)
	 */
	@RequestMapping(value="/causaProhibicion/exportCausaProhibicion")
	public String exportCausaProhibicion(HttpServletRequest request, HttpServletResponse response) {
		
		// Generar el informe en formato Excel
		CausaProhibicionQueryBean causaProhibicionQueryBean = (CausaProhibicionQueryBean) request.getSession().getAttribute("causaProhibicionQueryBean");
		
		String username = (String) SecurityAccess.getUserInformation().getUsername();

		String reportType = "PDF";
		String reportName = "causaProhibicionReport";
		String reportTitle = this.messageSource.getMessage("page.breadcrumb.causaProhibicion", null, WebCoreUtils.getLocale());
		
		try {
			byte[] byteArray = this.causaProhibicionService.exportCausaProhibicion(username, causaProhibicionQueryBean, reportType, reportName, reportTitle);
			
			response.reset();
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "attachment" + ";filename=\"" + "causaProhibicionReport.pdf" + "\"");
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
	 * Peticiones para cargar la vista de Nueva Causa de prohibicion
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param causaProhibicionForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/causaProhibicion/startNewCausaProhibicion")
	public String startNewCausaProhibicion(Map<String, Object> map, HttpServletRequest request, CausaProhibicionForm causaProhibicionForm) {
		LOGGER.debug("startNewCausaProhibicion");
				
		try {
			// Rellenando el map de la vista
			fillInitialMap(map, "causaProhibicionForm");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}

		return "tiles/startNewCausaProhibicion";
	}
	
	/**
	 * Peticiones para almacenar el Nuevo Registro.
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param causaProhibicionForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/causaProhibicion/saveNewCausaProhibicion")
	public String saveNewCausaProhibicion(Map<String, Object> map, HttpServletRequest request, @Valid CausaProhibicionForm causaProhibicionForm, BindingResult result) {
		LOGGER.debug("saveNewCausaProhibicion");
		
		// Comprobacion de campos del formulario
		if (result.hasErrors()) {
			LOGGER.error("Hay errores en el formulario");
			return retornoErrorCausaProhibicion("New", "Hay errores en el formulario", map, causaProhibicionForm);
		} else { // Todos los campos del formulario completos no hay errores
			try{				
				/* Comprueba si no existe ya el tipo de prohibicion */
				if (causaProhibicionService.getCausaProhibicionByCodigo(causaProhibicionForm.getCodigo())!=null){
					LOGGER.error("Ya existe un tipo de prohibicion con el codigo: "+causaProhibicionForm.getCodigo());
					return retornoErrorCausaProhibicion("New", "Ya existe un tipo de prohibicion con el codigo: "+causaProhibicionForm.getCodigo(), map, causaProhibicionForm);
				}
				
				CausaProhibicionBean causaProhibicionBean = new CausaProhibicionBean();
				causaProhibicionFormToCausaProhibicionBean (causaProhibicionForm, causaProhibicionBean);
			
				causaProhibicionService.altaCausaProhibicion(causaProhibicionBean, SecurityAccess.getUserInformation());
					
			} catch (PersistenceException e){
				LOGGER.error("Error en el alta: "+e.getMessage());
				return retornoErrorCausaProhibicion("New", "Error al guardar el Causa de prohibicion", map, causaProhibicionForm);
			} catch (ParseException e) {
				LOGGER.error("Error en el alta: "+e.getMessage());
				return retornoErrorCausaProhibicion("New", "Error al guardar el Causa de prohibicion", map, causaProhibicionForm);
			} 
			
			return "redirect:/app/causaProhibicion/startCausaProhibicion";
		}
		
	}
	
	/**
	 * Peticiones para cargar la vista de editar una Causa de Prohibicion a partir de la 
	 * pantalla de consulta de causas de prohibicion.
	 * @param map Contenedor de informacion para la vista
	 * @param request Peticion
	 * @param causaProhibicionForm Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/causaProhibicion/startEditCausaProhibicion")
	public String startEditCausaProhibicion(Map<String, Object> map, HttpServletRequest request, CausaProhibicionForm causaProhibicionForm) {

		LOGGER.debug("startEditCausaProhibicion");
		String id = RequestUtil.getStringParameter(request, "id");
		id = id.replace(' ', '+');
		String decId = new TimestampEncrypter().decryptAndValidate(id, 1000 * viewTimeout );
		
		CausaProhibicionBean causaProhibicionBean = causaProhibicionService.getCausaProhibicionById(Long.valueOf(decId));
		
		causaProhibicionBeanToCausaProhibicionForm(causaProhibicionBean, causaProhibicionForm);
				
		try {
			// Rellenando el map de la vista
			fillInitialMap(map, "causaProhibicionForm");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}

		return "tiles/startEditCausaProhibicion";
	}
	
	/**
	 * Peticiones para almacenar el Nuevo Registro
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param causaProhibicionForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/causaProhibicion/saveEditCausaProhibicion")
	public String saveEditCausaProhibicion(Map<String, Object> map, HttpServletRequest request, @Valid CausaProhibicionForm causaProhibicionForm, BindingResult result) {
		LOGGER.debug("saveEditCausaProhibicion");
		
		// Comprobacion de campos del formulario
		if (result.hasErrors()) {
			LOGGER.error("Hay errores en el formulario");
			return retornoErrorCausaProhibicion("Edit", "Hay errores en el formulario", map, causaProhibicionForm);
			
		} else { // Todos los campos del formulario completos no hay errores
			try{				
				if (causaProhibicionService.getCausaProhibicionByCodigoNoID(Long.valueOf(causaProhibicionForm.getId()), causaProhibicionForm.getCodigo())!=null){
					LOGGER.error("Ya existe un jugador de prueba con el codigo: "+causaProhibicionForm.getCodigo());
					return retornoErrorCausaProhibicion("Edit", "Ya existe un tipo de prohibicion con el codigo: "+causaProhibicionForm.getCodigo(), map, causaProhibicionForm);
				}

				CausaProhibicionBean causaProhibicionBean = new CausaProhibicionBean();
				causaProhibicionFormToCausaProhibicionBean (causaProhibicionForm, causaProhibicionBean);
			
				causaProhibicionService.editarCausaProhibicion(causaProhibicionBean, SecurityAccess.getUserInformation());
					
			} catch (PersistenceException e){
				LOGGER.error("Error en la edicion: "+e.getMessage());
				return retornoErrorCausaProhibicion("Edit", "Error al guardar el tipo de prohibicion", map, causaProhibicionForm);
			} catch (ParseException e) {
				LOGGER.error("Error en la edicion: "+e.getMessage());
				return retornoErrorCausaProhibicion("Edit", "Error al guardar el tipo de prohibicion", map, causaProhibicionForm);
			} 

			return "redirect:/app/causaProhibicion/startCausaProhibicion";
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
	 * @param causaProhibicionForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	private String retornoErrorCausaProhibicion(String tipo, String mensaje, Map<String, Object> map, CausaProhibicionForm causaProhibicionForm){
		
		causaProhibicionForm.setError(mensaje);
		
		// Rellenando el map de la vista
		fillInitialMap(map, "causaProhibicionForm");
		
		if (tipo.equalsIgnoreCase("Edit")){
			return "tiles/startEditCausaProhibicion";
		} else if (tipo.equalsIgnoreCase("New")){
			return "tiles/startNewCausaProhibicion";
		} else {
			return "app/errorPage";
		}
	}
	
	/**
	 * Método que limpia la caché de parámetros de búsqueda. 
	 * @return null
	 */
	@RequestMapping(value="/causaProhibicion/limpiarBusqueda")
	public String limpiarBusqueda(HttpServletRequest request, HttpServletResponse response) {
		// Almaceno los criterios de búsqueda en sesión de usuario
		request.getSession().setAttribute("causaProhibicionQueryBean", null);
		request.getSession().setAttribute("buscar", 0);
		
		return null;
	}
	
	/**
	 * Metodo privado que rellena el Formulario de busqueda con los datos provenientes del bean de consulta a la base de datos
	 * @param searchCausaProhibicionForm, Formulario vacío
	 * @param causaProhibicionQueryBean, Objeto con los datos provenientes de base de datos
	 */
	private void toSearchForm(SearchCausaProhibicionForm searchCausaProhibicionForm, CausaProhibicionQueryBean causaProhibicionQueryBean){
		searchCausaProhibicionForm.setId(Utilidades.stringOrNull(causaProhibicionQueryBean.getId()));
		searchCausaProhibicionForm.setCodigo(causaProhibicionQueryBean.getCodigo());
		searchCausaProhibicionForm.setDescripcion(causaProhibicionQueryBean.getDescripcion());
		searchCausaProhibicionForm.setActivo(causaProhibicionQueryBean.getActivo());
	}
	
	/**
	 * Metodo privado que rellena el Formulario con los datos provenientes de la base de datos que hay en el bean.
	 * @param causaProhibicionForm, Formulario vacío
	 * @param causaProhibicionBean, Objeto con los datos provenientes de base de datos
	 */
	private void causaProhibicionBeanToCausaProhibicionForm(CausaProhibicionBean causaProhibicionBean, CausaProhibicionForm causaProhibicionForm) {
		causaProhibicionForm.setId(causaProhibicionBean.getId().toString());
		causaProhibicionForm.setCodigo(causaProhibicionBean.getCodigo());
		causaProhibicionForm.setDescripcion(causaProhibicionBean.getDescripcion());
		causaProhibicionForm.setActivo(causaProhibicionBean.getActivo());
	}
	
	/**
	 * Metodo privado que rellena el Bean con los datos provenientes del formulario.
	 * @param causaProhibicionForm, Formulario relleno de la pantalla
	 * @param causaProhibicionBean, Objeto vacio
	 * @throws ParseException 
	 */
	private void causaProhibicionFormToCausaProhibicionBean(CausaProhibicionForm causaProhibicionForm, CausaProhibicionBean causaProhibicionBean) throws ParseException {
		if (causaProhibicionForm.getId()!=null){
			causaProhibicionBean.setId(Long.valueOf(causaProhibicionForm.getId()));
		}
		causaProhibicionBean.setCodigo(causaProhibicionForm.getCodigo());
		causaProhibicionBean.setDescripcion(causaProhibicionForm.getDescripcion());
		causaProhibicionBean.setActivo(causaProhibicionForm.getActivo());
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
