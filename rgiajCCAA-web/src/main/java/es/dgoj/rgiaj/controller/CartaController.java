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

import es.dgoj.rgiaj.business.beans.CartaBean;
import es.dgoj.rgiaj.business.beans.CartaQueryBean;
import es.dgoj.rgiaj.business.service.CargoService;
import es.dgoj.rgiaj.business.service.CartaService;
import es.dgoj.rgiaj.business.service.FirmaService;
import es.dgoj.rgiaj.encrypt.TimestampEncrypter;
import es.dgoj.rgiaj.form.CartaForm;
import es.dgoj.rgiaj.form.SearchCartaForm;

/**
 * Clase que gestiona todas las peticiones sincronas realizadas desde la vista de cartas.
 * @author connectis
 */
@Controller
@RequestMapping(value = "/carta/*")
public class CartaController {
	
	/**
	 * Servicio de mantenimiento de Cartas
	 */
	@Resource
	private CartaService cartaService;
	
	/**
	 * Servicio de busqueda de Cargos
	 */
	@Resource
	private CargoService cargoService;

	/**
	 * Servicio de busqueda de Firmas
	 */
	@Resource
	private FirmaService firmaService;
	
	/**
	 *  Log de la clase.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CartaController.class);
	
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
	@RequestMapping(value = "/carta/startCarta")
	public String startCarta(Map<String, Object> map, HttpServletRequest request,  SearchCartaForm searchCartaForm) {
		
		try {
			CartaQueryBean cartaQueryBean = (CartaQueryBean) request.getSession().getAttribute("cartaQueryBean");
			if (cartaQueryBean != null){
				toSearchForm(searchCartaForm, cartaQueryBean);	
			}
			
			fillInitialMap(map, "searchCartaForm");
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}
		
		return "tiles/carta";
	}
	
	/**
	 * Peticion para exportar el pdf de Cartas
	 * 
	 * @param request
	 *            Peticion
	 * @param response
	 *            Respuesta
	 * @return Componente tile al que se redirige (si es correcta la generación del pdf se devuelve null)
	 */
	@RequestMapping(value="/carta/exportCarta")
	public String exportCarta(HttpServletRequest request, HttpServletResponse response) {
		
		// Generar el informe en formato Excel
		CartaQueryBean cartaQueryBean = (CartaQueryBean) request.getSession().getAttribute("cartaQueryBean");
		
		String username = (String) SecurityAccess.getUserInformation().getUsername();

		String reportType = "PDF";
		String reportName = "cartaReport";
		String reportTitle = this.messageSource.getMessage("page.breadcrumb.carta", null, WebCoreUtils.getLocale());
		
		try {
			byte[] byteArray = this.cartaService.exportCarta(username, cartaQueryBean, reportType, reportName, reportTitle);
			
			response.reset();
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "attachment" + ";filename=\"" + "cartaReport.pdf" + "\"");
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
	 * Peticiones para cargar la vista de Nueva Carta
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param CartaForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/carta/startNewCarta")
	public String startNewCarta(Map<String, Object> map, HttpServletRequest request, CartaForm cartaForm) {
		LOGGER.debug("startNewCarta");
				
		try {
			// Rellenando el map de la vista
			map.put("cargosList", cargoService.getListaCargos());
			map.put("firmasList", firmaService.getListaFirmas());
			
			fillInitialMap(map, "cartaForm");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}

		return "tiles/startNewCarta";
	}
	
	/**
	 * Peticiones para almacenar el Nuevo Registro.
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param CartaForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/carta/saveNewCarta")
	public String saveNewCarta(Map<String, Object> map, HttpServletRequest request, @Valid CartaForm cartaForm, BindingResult result) {
		LOGGER.debug("saveNewCarta");
		
		// Comprobacion de campos del formulario
		if (result.hasErrors()) {
			LOGGER.error("Hay errores en el formulario");
			return retornoErrorCarta("New", "Hay errores en el formulario", map, cartaForm);
		} else { // Todos los campos del formulario completos no hay errores
			try{				
				/* Comprueba si no existe ya la Carta */
				if (cartaService.getCartaById(Long.valueOf(cartaForm.getId()))!=null){
					LOGGER.error("Ya existe un carta con el codigo: "+cartaForm.getId());
					return retornoErrorCarta("New", "Ya existe un carta con el codigo: "+cartaForm.getId(), map, cartaForm);
				}
				
				CartaBean cartaBean = new CartaBean();
				CartaFormToCartaBean (cartaForm, cartaBean);
			
				cartaService.altaCarta(cartaBean, SecurityAccess.getUserInformation());
					
			} catch (PersistenceException e){
				LOGGER.error("Error en el alta: "+e.getMessage());
				return retornoErrorCarta("New", "Error al guardar el carta", map, cartaForm);
			} catch (ParseException e) {
				LOGGER.error("Error en el alta: "+e.getMessage());
				return retornoErrorCarta("New", "Error al guardar el carta", map, cartaForm);
			} 
			
			return "redirect:/app/carta/startCarta";
		}
		
	}
	
	/**
	 * Peticiones para cargar la vista de editar cartas a partir de la 
	 * pantalla de consulta de Cartas.
	 * @param map Contenedor de informacion para la vista
	 * @param request Peticion
	 * @param CartaForm Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/carta/startEditCarta")
	public String startEditCarta(Map<String, Object> map, HttpServletRequest request, CartaForm cartaForm) {

		LOGGER.debug("startEditCarta");
		String id = RequestUtil.getStringParameter(request, "id");
		id = id.replace(' ', '+');
		String decId = new TimestampEncrypter().decryptAndValidate(id, 1000 * viewTimeout );
		
		CartaBean cartaBean = cartaService.getCartaById(Long.valueOf(decId));
		
		CartaBeanToCartaForm(cartaBean, cartaForm);
				
		try {
			// Rellenando el map de la vista
			map.put("cargosList", cargoService.getListaCargos());
			map.put("firmasList", firmaService.getListaFirmas());
			
			fillInitialMap(map, "cartaForm");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}

		return "tiles/startEditCarta";
	}
	
	/**
	 * Peticiones para almacenar el Nuevo Registro
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param CartaForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/carta/saveEditCarta")
	public String saveEditCarta(Map<String, Object> map, HttpServletRequest request, @Valid CartaForm cartaForm, BindingResult result) {
		LOGGER.debug("saveEditCarta");
		
		// Comprobacion de campos del formulario
		if (result.hasErrors()) {
			LOGGER.error("Hay errores en el formulario");
			return retornoErrorCarta("Edit", "Hay errores en el formulario", map, cartaForm);
			
		} else { // Todos los campos del formulario completos no hay errores
			try{				
				CartaBean cartaBean = new CartaBean();
				CartaFormToCartaBean (cartaForm, cartaBean);
			
				cartaService.editarCarta(cartaBean, SecurityAccess.getUserInformation());
					
			} catch (PersistenceException e){
				LOGGER.error("Error en la edicion: "+e.getMessage());
				return retornoErrorCarta("Edit", "Error al guardar el carta", map, cartaForm);
			} catch (ParseException e) {
				LOGGER.error("Error en la edicion: "+e.getMessage());
				return retornoErrorCarta("Edit", "Error al guardar el carta", map, cartaForm);
			} 

			return "redirect:/app/carta/startCarta";
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
	 * @param CartaForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	private String retornoErrorCarta(String tipo, String mensaje, Map<String, Object> map, CartaForm cartaForm){
		
		cartaForm.setError(mensaje);
		
		// Rellenando el map de la vista
		fillInitialMap(map, "cartaForm");
		
		if (tipo.equalsIgnoreCase("Edit")){
			return "tiles/startEditCarta";
		} else if (tipo.equalsIgnoreCase("New")){
			return "tiles/startNewCarta";
		} else {
			return "app/errorPage";
		}
	}
	
	/**
	 * Método que limpia la caché de parámetros de búsqueda. 
	 * @return null
	 */
	@RequestMapping(value="/carta/limpiarBusqueda")
	public String limpiarBusqueda(HttpServletRequest request, HttpServletResponse response) {
		// Almaceno los criterios de búsqueda en sesión de usuario
		request.getSession().setAttribute("cartaQueryBean", null);
		request.getSession().setAttribute("buscar", 0);
		
		return null;
	}
	
	/**
	 * Metodo privado que rellena el Formulario de busqueda con los datos provenientes del bean de consulta a la base de datos
	 * @param searchCartaForm, Formulario vacío
	 * @param cartaQueryBean, Objeto con los datos provenientes de base de datos
	 */
	private void toSearchForm(SearchCartaForm searchCartaForm, CartaQueryBean cartaQueryBean){
		//searchCartaForm.setId(Utilidades.stringOrNull(cartaQueryBean.getId()));
		searchCartaForm.setDescripcion(cartaQueryBean.getDescripcion());
		//searchCartaForm.setCargo(cartaQueryBean.getCargo().toString());
		//searchCartaForm.setResponsable(cartaQueryBean.getResponsable().toString());

	}
	
	/**
	 * Metodo privado que rellena el Formulario con los datos provenientes de la base de datos que hay en el bean.
	 * @param CartaForm, Formulario vacío
	 * @param CartaBean, Objeto con los datos provenientes de base de datos
	 */
	private void CartaBeanToCartaForm(CartaBean cartaBean, CartaForm cartaForm) {
		cartaForm.setId(cartaBean.getId().toString());
		cartaForm.setDescripcion(cartaBean.getDescripcion());
		cartaForm.setTexto(cartaBean.getTexto());
		cartaForm.setPie(cartaBean.getPie());
		cartaForm.setCargo(cartaBean.getCargo().toString());
		cartaForm.setResponsable(cartaBean.getResponsable().toString());
	}
	
	/**
	 * Metodo privado que rellena el Bean con los datos provenientes del formulario.
	 * @param CartaForm, Formulario relleno de la pantalla
	 * @param CartaBean, Objeto vacio
	 * @throws ParseException 
	 */
	private void CartaFormToCartaBean(CartaForm cartaForm, CartaBean cartaBean) throws ParseException {
		if (cartaForm.getId()!=null){
			cartaBean.setId(Long.valueOf(cartaForm.getId()));
		}
		cartaBean.setTexto(cartaForm.getTexto());
		cartaBean.setDescripcion(cartaForm.getDescripcion());
		cartaBean.setPie(cartaForm.getPie());
		cartaBean.setCargo(Long.valueOf(cartaForm.getCargo()));
		cartaBean.setResponsable(Long.valueOf(cartaForm.getResponsable()));
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
