package es.dgoj.rgiaj.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

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

import com.dgoj.core.common.bean.ParamBean;
import com.dgoj.core.security.sso.access.SecurityAccess;
import com.dgoj.sprmvc.web.util.RequestUtil;
import com.jeveris.core.persistence.exception.PersistenceException;
import com.jeveris.web.core.utils.WebCoreUtils;

import es.dgoj.rgiaj.business.beans.SituacionBean;
import es.dgoj.rgiaj.business.beans.SituacionQueryBean;
import es.dgoj.rgiaj.business.service.SituacionService;
import es.dgoj.rgiaj.encrypt.TimestampEncrypter;
import es.dgoj.rgiaj.form.SearchSituacionForm;
import es.dgoj.rgiaj.form.SituacionForm;
import es.dgoj.rgiaj.util.Utilidades;

/**
 * Clase que gestiona todas las peticiones sincronas realizadas desde la vista de tipos de prohibicion.
 * @author connectis
 */
@Controller
@RequestMapping(value = "/situacion/*")
public class SituacionController {
	
	/**
	 * Servicio de mantenimiento de Situaciones
	 */
	@Resource
	private SituacionService situacionService;
	
	/**
	 *  Log de la clase.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SituacionController.class);
	
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
	
	@Resource(name="situacionTipos")
	private String situacionTipos;
	
	@Resource(name="situacionValores")
	private String situacionValores;

	/**
	 * Peticiones para cargar la vista.
	 * @param map Contenedor de informacion para la vista
	 * @param request Peticion
	 * @param searchSituacionForm Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/situacion/startSituacion")
	public String startSituacion(Map<String, Object> map, HttpServletRequest request,  SearchSituacionForm searchSituacionForm) {
		
		try {
			SituacionQueryBean situacionQueryBean = (SituacionQueryBean) request.getSession().getAttribute("situacionQueryBean");
			if (situacionQueryBean != null){
				toSearchForm(searchSituacionForm, situacionQueryBean);	
			}
			
			fillInitialMap(map, "searchSituacionForm");
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}
		
		return "tiles/situacion";
	}
	
	/**
	 * Peticion para exportar el pdf de situaciones
	 * 
	 * @param request
	 *            Peticion
	 * @param response
	 *            Respuesta
	 * @return Componente tile al que se redirige (si es correcta la generación del pdf se devuelve null)
	 */
	@RequestMapping(value="/situacion/exportSituacion")
	public String exportSituacion(HttpServletRequest request, HttpServletResponse response) {
		
		// Generar el informe en formato Excel
		SituacionQueryBean situacionQueryBean = (SituacionQueryBean) request.getSession().getAttribute("situacionQueryBean");
		
		String username = (String) SecurityAccess.getUserInformation().getUsername();

		String reportType = "PDF";
		String reportName = "situacionReport";
		String reportTitle = this.messageSource.getMessage("page.breadcrumb.situacion", null, WebCoreUtils.getLocale());
		
		try {
			byte[] byteArray = this.situacionService.exportSituacion(username, situacionQueryBean, reportType, reportName, reportTitle);
			
			response.reset();
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "attachment" + ";filename=\"" + "situacionReport.pdf" + "\"");
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
	 * Peticiones para cargar la vista de Nueva Situacion
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param situacionForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/situacion/startNewSituacion")
	public String startNewSituacion(Map<String, Object> map, HttpServletRequest request, SituacionForm situacionForm) {
		LOGGER.debug("startNewSituacion");
		
		map.put("tiposSituacionList", getListaTiposSituacion());
		map.put("situacionValoresList", getListaSituacionValores());

		try {
			// Rellenando el map de la vista
			fillInitialMap(map, "situacionForm");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}

		return "tiles/startNewSituacion";
	}
	
	/**
	 * Peticiones para almacenar el Nuevo Registro.
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param situacionForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/situacion/saveNewSituacion")
	public String saveNewSituacion(Map<String, Object> map, HttpServletRequest request, @Valid SituacionForm situacionForm, BindingResult result) {
		LOGGER.debug("saveNewSituacion");
		
		// Comprobacion de campos del formulario
		if (result.hasErrors()) {
			LOGGER.error("Hay errores en el formulario");
			return retornoErrorSituacion("New", "Hay errores en el formulario", map, situacionForm);
		} else { // Todos los campos del formulario completos no hay errores
			try{				
				/* Comprueba si no existe ya la situacion */
				if (situacionService.getSituacionByCodigo(situacionForm.getCodigo())!=null){
					LOGGER.error("Ya existe una situacion con el codigo: "+situacionForm.getCodigo());
					return retornoErrorSituacion("New", "Ya existe una situacion con el codigo: "+situacionForm.getCodigo(), map, situacionForm);
				}
				
				SituacionBean situacionBean = new SituacionBean();
				situacionFormToSituacionBean (situacionForm, situacionBean);
			
				situacionService.altaSituacion(situacionBean, SecurityAccess.getUserInformation());
					
			} catch (PersistenceException e){
				LOGGER.error("Error en el alta: "+e.getMessage());
				return retornoErrorSituacion("New", "Error al guardar el Tipo de Prohibicion", map, situacionForm);
			} catch (ParseException e) {
				LOGGER.error("Error en el alta: "+e.getMessage());
				return retornoErrorSituacion("New", "Error al guardar el Tipo de Prohibicion", map, situacionForm);
			} 
			
			return "redirect:/app/situacion/startSituacion";
		}
		
	}
	
	/**
	 * Peticiones para cargar la vista de editar una situacion a partir de la 
	 * pantalla de consulta de situaciones.
	 * @param map Contenedor de informacion para la vista
	 * @param request Peticion
	 * @param situacionForm Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/situacion/startEditSituacion")
	public String startEditSituacion(Map<String, Object> map, HttpServletRequest request, SituacionForm situacionForm) {

		LOGGER.debug("startEditSituacion");
		
		String id = RequestUtil.getStringParameter(request, "id");
		id = id.replace(' ', '+');
		String decId = new TimestampEncrypter().decryptAndValidate(id, 1000 * viewTimeout );
		
		SituacionBean situacionBean = situacionService.getSituacionById(Long.valueOf(decId));
		
		situacionBeanToSituacionForm(situacionBean, situacionForm);
				
		try {
			// Rellenando el map de la vista
			map.put("tiposSituacionList", getListaTiposSituacion());
			map.put("situacionValoresList", getListaSituacionValores());
			
			fillInitialMap(map, "situacionForm");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}

		return "tiles/startEditSituacion";
	}
	
	/**
	 * Peticiones para almacenar el Nuevo Registro
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param situacionForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/situacion/saveEditSituacion")
	public String saveEditSituacion(Map<String, Object> map, HttpServletRequest request, @Valid SituacionForm situacionForm, BindingResult result) {
		LOGGER.debug("saveEditSituacion");
		
		// Comprobacion de campos del formulario
		if (result.hasErrors()) {
			LOGGER.error("Hay errores en el formulario");
			return retornoErrorSituacion("Edit", "Hay errores en el formulario", map, situacionForm);
			
		} else { // Todos los campos del formulario completos no hay errores
			try{				
				if (situacionService.getSituacionByCodigoNoID(Long.valueOf(situacionForm.getId()), situacionForm.getCodigo())!=null){
					LOGGER.error("Ya existe un jugador de prueba con el codigo: "+situacionForm.getCodigo());
					return retornoErrorSituacion("Edit", "Ya existe una situacion con el codigo: "+situacionForm.getCodigo(), map, situacionForm);
				}

				SituacionBean situacionBean = new SituacionBean();
				situacionFormToSituacionBean (situacionForm, situacionBean);
			
				situacionService.editarSituacion(situacionBean, SecurityAccess.getUserInformation());
					
			} catch (PersistenceException e){
				LOGGER.error("Error en la edicion: "+e.getMessage());
				return retornoErrorSituacion("Edit", "Error al guardar la situacion", map, situacionForm);
			} catch (ParseException e) {
				LOGGER.error("Error en la edicion: "+e.getMessage());
				return retornoErrorSituacion("Edit", "Error al guardar la situacion", map, situacionForm);
			} 

			return "redirect:/app/situacion/startSituacion";
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
	 * @param situacionForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	private String retornoErrorSituacion(String tipo, String mensaje, Map<String, Object> map, SituacionForm situacionForm){
		
		situacionForm.setError(mensaje);
		
		// Rellenando el map de la vista
		fillInitialMap(map, "situacionForm");
		
		if (tipo.equalsIgnoreCase("Edit")){
			return "tiles/startEditSituacion";
		} else if (tipo.equalsIgnoreCase("New")){
			return "tiles/startNewSituacion";
		} else {
			return "app/errorPage";
		}
	}
	
	/**
	 * Método que limpia la caché de parámetros de búsqueda. 
	 * @return null
	 */
	@RequestMapping(value="/situacion/limpiarBusqueda")
	public String limpiarBusqueda(HttpServletRequest request, HttpServletResponse response) {
		// Almaceno los criterios de búsqueda en sesión de usuario
		request.getSession().setAttribute("situacionQueryBean", null);
		request.getSession().setAttribute("buscar", 0);
		
		return null;
	}
	
	/**
	 * Metodo privado que rellena el Formulario de busqueda con los datos provenientes del bean de consulta a la base de datos
	 * @param searchSituacionForm, Formulario vacío
	 * @param situacionQueryBean, Objeto con los datos provenientes de base de datos
	 */
	private void toSearchForm(SearchSituacionForm searchSituacionForm, SituacionQueryBean situacionQueryBean){
		searchSituacionForm.setId(Utilidades.stringOrNull(situacionQueryBean.getId()));
		searchSituacionForm.setCodigo(situacionQueryBean.getCodigo());
		searchSituacionForm.setDescripcion(situacionQueryBean.getDescripcion());
		searchSituacionForm.setActivo(situacionQueryBean.getActivo());
		searchSituacionForm.setTipoSituacion(situacionQueryBean.getTipoSituacion());
		searchSituacionForm.setSituacionMaq(situacionQueryBean.getSituacionMaq());
		searchSituacionForm.setSituacionEmp(situacionQueryBean.getSituacionEmp());
		searchSituacionForm.setSituacionLocal(situacionQueryBean.getSituacionLocal());
		searchSituacionForm.setSituacionPersona(situacionQueryBean.getSituacionPersona());
		searchSituacionForm.setSituacionModelo(situacionQueryBean.getSituacionModelo());
		
	}
	
	/**
	 * Metodo privado que rellena el Formulario con los datos provenientes de la base de datos que hay en el bean.
	 * @param situacionForm, Formulario vacío
	 * @param situacionBean, Objeto con los datos provenientes de base de datos
	 */
	private void situacionBeanToSituacionForm(SituacionBean situacionBean, SituacionForm situacionForm) {
		situacionForm.setId(situacionBean.getId().toString());
		situacionForm.setCodigo(situacionBean.getCodigo());
		situacionForm.setDescripcion(situacionBean.getDescripcion());
		situacionForm.setActivo(situacionBean.getActivo());
		situacionForm.setTipoSituacion(situacionBean.getTipoSituacion());
		situacionForm.setSituacionMaq(situacionBean.getSituacionMaq());
		situacionForm.setSituacionEmp(situacionBean.getSituacionEmp());
		situacionForm.setSituacionLocal(situacionBean.getSituacionLocal());
		situacionForm.setSituacionPersona(situacionBean.getSituacionPersona());
		situacionForm.setSituacionModelo(situacionBean.getSituacionModelo());		
	}
	
	/**
	 * Metodo privado que rellena el Bean con los datos provenientes del formulario.
	 * @param situacionForm, Formulario relleno de la pantalla
	 * @param situacionBean, Objeto vacio
	 * @throws ParseException 
	 */
	private void situacionFormToSituacionBean(SituacionForm situacionForm, SituacionBean situacionBean) throws ParseException {
		if (situacionForm.getId()!=null){
			situacionBean.setId(Long.valueOf(situacionForm.getId()));
		}
		situacionBean.setCodigo(situacionForm.getCodigo());
		situacionBean.setDescripcion(situacionForm.getDescripcion());
		situacionBean.setActivo(situacionForm.getActivo());
		situacionBean.setTipoSituacion(situacionForm.getTipoSituacion());
		situacionBean.setSituacionMaq(situacionForm.getSituacionMaq());
		situacionBean.setSituacionEmp(situacionForm.getSituacionEmp());
		situacionBean.setSituacionLocal(situacionForm.getSituacionLocal());
		situacionBean.setSituacionPersona(situacionForm.getSituacionPersona());
		situacionBean.setSituacionModelo(situacionForm.getSituacionModelo());			
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
	
	/**
	 * Método privado para cargar los posibles valores de Tipo de Situacion
	 * 
	 * @return List<ParamBean>
	 */
	private List<ParamBean> getListaTiposSituacion(){
		 ArrayList<ParamBean> resultadosList = new ArrayList<ParamBean>();
		
	     StringTokenizer st = new StringTokenizer(situacionTipos, ",");
	     while (st.hasMoreTokens()) {
	    	 String tipo = st.nextToken();
	    	 resultadosList.add(new ParamBean(tipo, tipo));
	     }
		
		 return resultadosList;
	}
	
	/**
	 * Método privado para cargar los posibles valores de Situacion
	 * 
	 * @return List<ParamBean>
	 */
	private List<ParamBean> getListaSituacionValores(){
		 ArrayList<ParamBean> resultadosList = new ArrayList<ParamBean>();
		
	     StringTokenizer st = new StringTokenizer(situacionValores, ",");
	     while (st.hasMoreTokens()) {
	    	 String valor = st.nextToken();
	    	 resultadosList.add(new ParamBean(valor, valor));
	     }
		
		 return resultadosList;
	}
}
