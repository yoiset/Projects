package es.dgoj.rgiaj.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeveris.web.core.utils.WebCoreUtils;

import es.dgoj.rgiaj.business.beans.ConsultaSVDIQueryBean;
import es.dgoj.rgiaj.form.SearchConsultaSVDIForm;

/**
 * Clase que gestiona todas las peticiones sincronas realizadas desde la vista de consultaSVDI.
 * @author connectis
 */
@Controller
@RequestMapping(value = "/consultaSVDI/*")
public class ConsultaSVDIController {
	
	/**
	 *  Log de la clase.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultaSVDIController.class);
	
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
	 * @param searchCartaForm Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/consultaSVDI/startConsultaSVDI")
	public String startCarta(Map<String, Object> map, HttpServletRequest request,  SearchConsultaSVDIForm searchConsultaSVDIForm) {
		
		try {
			ConsultaSVDIQueryBean consultaSVDIQueryBean = (ConsultaSVDIQueryBean) request.getSession().getAttribute("consultaSVDIQueryBean");
			if (consultaSVDIQueryBean != null){
				toSearchForm(searchConsultaSVDIForm, consultaSVDIQueryBean);	
			}
			
			fillInitialMap(map, "searchConsultaSVDIForm");
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}
		
		return "tiles/consultaSVDI";
	}
	
	
	/**
	 * Método que limpia la caché de parámetros de búsqueda. 
	 * @return null
	 */
	@RequestMapping(value="/consultaSVDI/limpiarBusqueda")
	public String limpiarBusqueda(HttpServletRequest request, HttpServletResponse response) {
		// Almaceno los criterios de búsqueda en sesión de usuario
		request.getSession().setAttribute("consultaSVDIQueryBean", null);
		request.getSession().setAttribute("buscar", 0);
		
		return null;
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
	 * Metodo privado que rellena el Formulario de busqueda con los datos provenientes del bean de consulta a la base de datos
	 * @param searchConsultaSVDIForm, Formulario vacío
	 * @param consultaSVDIQueryBean, Objeto con los datos provenientes de base de datos
	 */
	private void toSearchForm(SearchConsultaSVDIForm searchConsultaSVDIForm, ConsultaSVDIQueryBean consultaSVDIQueryBean){
		searchConsultaSVDIForm.setDni(consultaSVDIQueryBean.getDni());
	}
}
