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

import es.dgoj.rgiaj.business.beans.TipoFirmaBean;
import es.dgoj.rgiaj.business.beans.TipoFirmaQueryBean;
import es.dgoj.rgiaj.business.service.TipoFirmaService;
import es.dgoj.rgiaj.encrypt.TimestampEncrypter;
import es.dgoj.rgiaj.form.SearchTipoFirmaForm;
import es.dgoj.rgiaj.form.TipoFirmaForm;
import es.dgoj.rgiaj.util.Utilidades;

/**
 * Clase que gestiona todas las peticiones sincronas realizadas desde la vista de tipos de firma.
 * @author connectis
 */
@Controller
@RequestMapping(value = "/tipoFirma/*")
public class TipoFirmaController {
	
	/**
	 * Servicio de mantenimiento de Tipos de firma
	 */
	@Resource
	private TipoFirmaService tipoFirmaService;
	
	/**
	 *  Log de la clase.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(TipoFirmaController.class);
	
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
	 * @param searchTipoFirmaForm Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/tipoFirma/startTipoFirma")
	public String startTipoFirma(Map<String, Object> map, HttpServletRequest request,  SearchTipoFirmaForm searchTipoFirmaForm) {
		
		try {
			TipoFirmaQueryBean tipoFirmaQueryBean = (TipoFirmaQueryBean) request.getSession().getAttribute("tipoFirmaQueryBean");
			if (tipoFirmaQueryBean != null){
				toSearchForm(searchTipoFirmaForm, tipoFirmaQueryBean);	
			}
			
			fillInitialMap(map, "searchTipoFirmaForm");
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}
		
		return "tiles/tipoFirma";
	}
	
	/**
	 * Peticion para exportar el pdf de Tipos de firma
	 * 
	 * @param request
	 *            Peticion
	 * @param response
	 *            Respuesta
	 * @return Componente tile al que se redirige (si es correcta la generación del pdf se devuelve null)
	 */
	@RequestMapping(value="/tipoFirma/exportTipoFirma")
	public String exportTipoFirma(HttpServletRequest request, HttpServletResponse response) {
		
		// Generar el informe en formato Excel
		TipoFirmaQueryBean tipoFirmaQueryBean = (TipoFirmaQueryBean) request.getSession().getAttribute("tipoFirmaQueryBean");
		
		String username = (String) SecurityAccess.getUserInformation().getUsername();

		String reportType = "PDF";
		String reportName = "tipoFirmaReport";
		String reportTitle = this.messageSource.getMessage("page.breadcrumb.tipoFirma", null, WebCoreUtils.getLocale());
		
		try {
			byte[] byteArray = this.tipoFirmaService.exportTipoFirma(username, tipoFirmaQueryBean, reportType, reportName, reportTitle);
			
			response.reset();
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "attachment" + ";filename=\"" + "tipoFirmaReport.pdf" + "\"");
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
	 * Peticiones para cargar la vista de Nuevo Tipo de firma
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param tipoFirmaForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/tipoFirma/startNewTipoFirma")
	public String startNewTipoFirma(Map<String, Object> map, HttpServletRequest request, TipoFirmaForm tipoFirmaForm) {
		LOGGER.debug("startNewTipoFirma");
				
		try {
			// Rellenando el map de la vista
			fillInitialMap(map, "tipoFirmaForm");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}

		return "tiles/startNewTipoFirma";
	}
	
	/**
	 * Peticiones para almacenar el Nuevo Registro.
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param tipoFirmaForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/tipoFirma/saveNewTipoFirma")
	public String saveNewTipoFirma(Map<String, Object> map, HttpServletRequest request, @Valid TipoFirmaForm tipoFirmaForm, BindingResult result) {
		LOGGER.debug("saveNewTipoFirma");
		
		// Comprobacion de campos del formulario
		if (result.hasErrors()) {
			LOGGER.error("Hay errores en el formulario");
			return retornoErrorTipoFirma("New", "Hay errores en el formulario", map, tipoFirmaForm);
		} else { // Todos los campos del formulario completos no hay errores
			try{				
				/* Comprueba si no existe ya el tipo de firma */
				if (tipoFirmaService.getTipoFirmaByCodigo(tipoFirmaForm.getCodigo())!=null){
					LOGGER.error("Ya existe un tipo de firma con el codigo: "+tipoFirmaForm.getCodigo());
					return retornoErrorTipoFirma("New", "Ya existe un tipo de firma con el codigo: "+tipoFirmaForm.getCodigo(), map, tipoFirmaForm);
				}
				
				TipoFirmaBean tipoFirmaBean = new TipoFirmaBean();
				tipoFirmaFormToTipoFirmaBean (tipoFirmaForm, tipoFirmaBean);
			
				tipoFirmaService.altaTipoFirma(tipoFirmaBean, SecurityAccess.getUserInformation());
					
			} catch (PersistenceException e){
				LOGGER.error("Error en el alta: "+e.getMessage());
				return retornoErrorTipoFirma("New", "Error al guardar el Tipo de firma", map, tipoFirmaForm);
			} catch (ParseException e) {
				LOGGER.error("Error en el alta: "+e.getMessage());
				return retornoErrorTipoFirma("New", "Error al guardar el Tipo de firma", map, tipoFirmaForm);
			} 
			
			return "redirect:/app/tipoFirma/startTipoFirma";
		}
		
	}
	
	/**
	 * Peticiones para cargar la vista de editar un jugador de prueba a partir de la 
	 * pantalla de consulta de tipos de firma.
	 * @param map Contenedor de informacion para la vista
	 * @param request Peticion
	 * @param tipoFirmaForm Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/tipoFirma/startEditTipoFirma")
	public String startEditTipoFirma(Map<String, Object> map, HttpServletRequest request, TipoFirmaForm tipoFirmaForm) {

		LOGGER.debug("startEditTipoFirma");
		String id = RequestUtil.getStringParameter(request, "id");
		id = id.replace(' ', '+');
		String decId = new TimestampEncrypter().decryptAndValidate(id, 1000 * viewTimeout );
		
		TipoFirmaBean tipoFirmaBean = tipoFirmaService.getTipoFirmaById(Long.valueOf(decId));
		
		tipoFirmaBeanToTipoFirmaForm(tipoFirmaBean, tipoFirmaForm);
				
		try {
			// Rellenando el map de la vista
			fillInitialMap(map, "tipoFirmaForm");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}

		return "tiles/startEditTipoFirma";
	}
	
	/**
	 * Peticiones para almacenar el Nuevo Registro
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param tipoFirmaForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/tipoFirma/saveEditTipoFirma")
	public String saveEditTipoFirma(Map<String, Object> map, HttpServletRequest request, @Valid TipoFirmaForm tipoFirmaForm, BindingResult result) {
		LOGGER.debug("saveEditTipoFirma");
		
		// Comprobacion de campos del formulario
		if (result.hasErrors()) {
			LOGGER.error("Hay errores en el formulario");
			return retornoErrorTipoFirma("Edit", "Hay errores en el formulario", map, tipoFirmaForm);
			
		} else { // Todos los campos del formulario completos no hay errores
			try{				
				if (tipoFirmaService.getTipoFirmaByCodigoNoID(Long.valueOf(tipoFirmaForm.getId()), tipoFirmaForm.getCodigo())!=null){
					LOGGER.error("Ya existe un tipo de firma con el codigo: "+tipoFirmaForm.getCodigo());
					return retornoErrorTipoFirma("Edit", "Ya existe un tipo de firma con el codigo: "+tipoFirmaForm.getCodigo(), map, tipoFirmaForm);
				}

				TipoFirmaBean tipoFirmaBean = new TipoFirmaBean();
				tipoFirmaFormToTipoFirmaBean (tipoFirmaForm, tipoFirmaBean);
			
				tipoFirmaService.editarTipoFirma(tipoFirmaBean, SecurityAccess.getUserInformation());
					
			} catch (PersistenceException e){
				LOGGER.error("Error en la edicion: "+e.getMessage());
				return retornoErrorTipoFirma("Edit", "Error al guardar el tipo de firma", map, tipoFirmaForm);
			} catch (ParseException e) {
				LOGGER.error("Error en la edicion: "+e.getMessage());
				return retornoErrorTipoFirma("Edit", "Error al guardar el tipo de firma", map, tipoFirmaForm);
			} 

			return "redirect:/app/tipoFirma/startTipoFirma";
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
	 * @param tipoFirmaForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	private String retornoErrorTipoFirma(String tipo, String mensaje, Map<String, Object> map, TipoFirmaForm tipoFirmaForm){
		
		tipoFirmaForm.setError(mensaje);
		
		// Rellenando el map de la vista
		fillInitialMap(map, "tipoFirmaForm");
		
		if (tipo.equalsIgnoreCase("Edit")){
			return "tiles/startEditTipoFirma";
		} else if (tipo.equalsIgnoreCase("New")){
			return "tiles/startNewTipoFirma";
		} else {
			return "app/errorPage";
		}
	}
	
	/**
	 * Método que limpia la caché de parámetros de búsqueda. 
	 * @return null
	 */
	@RequestMapping(value="/tipoFirma/limpiarBusqueda")
	public String limpiarBusqueda(HttpServletRequest request, HttpServletResponse response) {
		// Almaceno los criterios de búsqueda en sesión de usuario
		request.getSession().setAttribute("tipoFirmaQueryBean", null);
		request.getSession().setAttribute("buscar", 0);
		
		return null;
	}
	
	/**
	 * Metodo privado que rellena el Formulario de busqueda con los datos provenientes del bean de consulta a la base de datos
	 * @param tipoFirmaForm, Formulario vacío
	 * @param tipoFirmaBean, Objeto con los datos provenientes de base de datos
	 */
	private void toSearchForm(SearchTipoFirmaForm searchTipoFirmaForm, TipoFirmaQueryBean tipoFirmaQueryBean){
		searchTipoFirmaForm.setId(Utilidades.stringOrNull(tipoFirmaQueryBean.getId()));
		searchTipoFirmaForm.setCodigo(tipoFirmaQueryBean.getCodigo());
		searchTipoFirmaForm.setDescripcion(tipoFirmaQueryBean.getDescripcion());
		searchTipoFirmaForm.setActivo(tipoFirmaQueryBean.getActivo());
		searchTipoFirmaForm.setDefecto(tipoFirmaQueryBean.getDefecto());
	}
	
	/**
	 * Metodo privado que rellena el Formulario con los datos provenientes de la base de datos que hay en el bean.
	 * @param tipoFirmaForm, Formulario vacío
	 * @param tipoFirmaBean, Objeto con los datos provenientes de base de datos
	 */
	private void tipoFirmaBeanToTipoFirmaForm(TipoFirmaBean tipoFirmaBean, TipoFirmaForm tipoFirmaForm) {
		tipoFirmaForm.setId(tipoFirmaBean.getId().toString());
		tipoFirmaForm.setCodigo(tipoFirmaBean.getCodigo());
		tipoFirmaForm.setDescripcion(tipoFirmaBean.getDescripcion());
		tipoFirmaForm.setActivo(tipoFirmaBean.getActivo());
		tipoFirmaForm.setDefecto(tipoFirmaBean.getDefecto());
	}
	
	/**
	 * Metodo privado que rellena el Bean con los datos provenientes del formulario.
	 * @param tipoFirmaForm, Formulario relleno de la pantalla
	 * @param tipoFirmaBean, Objeto vacio
	 * @throws ParseException 
	 */
	private void tipoFirmaFormToTipoFirmaBean(TipoFirmaForm tipoFirmaForm, TipoFirmaBean tipoFirmaBean) throws ParseException {
		if (tipoFirmaForm.getId()!=null){
			tipoFirmaBean.setId(Long.valueOf(tipoFirmaForm.getId()));
		}
		tipoFirmaBean.setCodigo(tipoFirmaForm.getCodigo());
		tipoFirmaBean.setDescripcion(tipoFirmaForm.getDescripcion());
		tipoFirmaBean.setActivo(tipoFirmaForm.getActivo());
		tipoFirmaBean.setDefecto(tipoFirmaForm.getDefecto());
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
