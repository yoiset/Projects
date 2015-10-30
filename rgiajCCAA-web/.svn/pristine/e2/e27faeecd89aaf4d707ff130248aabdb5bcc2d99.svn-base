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

import es.dgoj.rgiaj.business.beans.CargoBean;
import es.dgoj.rgiaj.business.beans.CargoQueryBean;
import es.dgoj.rgiaj.business.service.CargoService;
import es.dgoj.rgiaj.encrypt.TimestampEncrypter;
import es.dgoj.rgiaj.form.CargoForm;
import es.dgoj.rgiaj.form.SearchCargoForm;
import es.dgoj.rgiaj.util.Utilidades;

/**
 * Clase que gestiona todas las peticiones sincronas realizadas desde la vista de cargos.
 * @author connectis
 */
@Controller
@RequestMapping(value = "/cargo/*")
public class CargoController {
	
	/**
	 * Servicio de mantenimiento de Cargos
	 */
	@Resource
	private CargoService cargoService;
	
	/**
	 *  Log de la clase.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CargoController.class);
	
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
	 * @param searchCargoForm Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/cargo/startCargo")
	public String startCargo(Map<String, Object> map, HttpServletRequest request,  SearchCargoForm searchCargoForm) {
		
		try {
			CargoQueryBean cargoQueryBean = (CargoQueryBean) request.getSession().getAttribute("cargoQueryBean");
			if (cargoQueryBean != null){
				toSearchForm(searchCargoForm, cargoQueryBean);	
			}
			
			fillInitialMap(map, "searchCargoForm");
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}
		
		return "tiles/cargo";
	}
	
	/**
	 * Peticion para exportar el pdf de Cargos
	 * 
	 * @param request
	 *            Peticion
	 * @param response
	 *            Respuesta
	 * @return Componente tile al que se redirige (si es correcta la generación del pdf se devuelve null)
	 */
	@RequestMapping(value="/cargo/exportCargo")
	public String exportCargo(HttpServletRequest request, HttpServletResponse response) {
		
		// Generar el informe en formato Excel
		CargoQueryBean cargoQueryBean = (CargoQueryBean) request.getSession().getAttribute("cargoQueryBean");
		
		String username = (String) SecurityAccess.getUserInformation().getUsername();

		String reportType = "PDF";
		String reportName = "cargoReport";
		String reportTitle = this.messageSource.getMessage("page.breadcrumb.cargo", null, WebCoreUtils.getLocale());
		
		try {
			byte[] byteArray = this.cargoService.exportCargo(username, cargoQueryBean, reportType, reportName, reportTitle);
			
			response.reset();
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "attachment" + ";filename=\"" + "cargoReport.pdf" + "\"");
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
	 * Peticiones para cargar la vista de Nuevo Cargo
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param CargoForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/cargo/startNewCargo")
	public String startNewCargo(Map<String, Object> map, HttpServletRequest request, CargoForm cargoForm) {
		LOGGER.debug("startNewCargo");
				
		try {
			// Rellenando el map de la vista
			fillInitialMap(map, "cargoForm");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}

		return "tiles/startNewCargo";
	}
	
	/**
	 * Peticiones para almacenar el Nuevo Registro.
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param CargoForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/cargo/saveNewCargo")
	public String saveNewCargo(Map<String, Object> map, HttpServletRequest request, @Valid CargoForm cargoForm, BindingResult result) {
		LOGGER.debug("saveNewCargo");
		
		// Comprobacion de campos del formulario
		if (result.hasErrors()) {
			LOGGER.error("Hay errores en el formulario");
			return retornoErrorCargo("New", "Hay errores en el formulario", map, cargoForm);
		} else { // Todos los campos del formulario completos no hay errores
			try{				
				/* Comprueba si no existe ya el Cargo */
				if (cargoService.getCargoByCodigo(cargoForm.getCodigo())!=null){
					LOGGER.error("Ya existe un cargo con el codigo: "+cargoForm.getCodigo());
					return retornoErrorCargo("New", "Ya existe un cargo con el codigo: "+cargoForm.getCodigo(), map, cargoForm);
				}
				
				CargoBean cargoBean = new CargoBean();
				CargoFormToCargoBean (cargoForm, cargoBean);
			
				cargoService.altaCargo(cargoBean, SecurityAccess.getUserInformation());
					
			} catch (PersistenceException e){
				LOGGER.error("Error en el alta: "+e.getMessage());
				return retornoErrorCargo("New", "Error al guardar el cargo", map, cargoForm);
			} catch (ParseException e) {
				LOGGER.error("Error en el alta: "+e.getMessage());
				return retornoErrorCargo("New", "Error al guardar el cargo", map, cargoForm);
			} 
			
			return "redirect:/app/cargo/startCargo";
		}
		
	}
	
	/**
	 * Peticiones para cargar la vista de editar un jugador de prueba a partir de la 
	 * pantalla de consulta de Cargos.
	 * @param map Contenedor de informacion para la vista
	 * @param request Peticion
	 * @param CargoForm Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/cargo/startEditCargo")
	public String startEditCargo(Map<String, Object> map, HttpServletRequest request, CargoForm cargoForm) {

		LOGGER.debug("startEditCargo");
		String id = RequestUtil.getStringParameter(request, "id");
		id = id.replace(' ', '+');
		String decId = new TimestampEncrypter().decryptAndValidate(id, 1000 * viewTimeout );
		
		CargoBean cargoBean = cargoService.getCargoById(Long.valueOf(decId));
		
		CargoBeanToCargoForm(cargoBean, cargoForm);
				
		try {
			// Rellenando el map de la vista
			fillInitialMap(map, "cargoForm");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "app/errorPage";
		}

		return "tiles/startEditCargo";
	}
	
	/**
	 * Peticiones para almacenar el Nuevo Registro
	 * 
	 * @param map
	 *            Contenedor de informacion para la vista
	 * @param request
	 *            Peticion
	 * @param CargoForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/cargo/saveEditCargo")
	public String saveEditCargo(Map<String, Object> map, HttpServletRequest request, @Valid CargoForm cargoForm, BindingResult result) {
		LOGGER.debug("saveEditCargo");
		
		// Comprobacion de campos del formulario
		if (result.hasErrors()) {
			LOGGER.error("Hay errores en el formulario");
			return retornoErrorCargo("Edit", "Hay errores en el formulario", map, cargoForm);
			
		} else { // Todos los campos del formulario completos no hay errores
			try{				
				if (cargoService.getCargoByCodigoNoID(Long.valueOf(cargoForm.getId()), cargoForm.getCodigo())!=null){
					LOGGER.error("Ya existe un cargo con el codigo: "+ cargoForm.getCodigo());
					return retornoErrorCargo("Edit", "Ya existe un cargo con el codigo: "+ cargoForm.getCodigo(), map, cargoForm);
				}

				CargoBean cargoBean = new CargoBean();
				CargoFormToCargoBean (cargoForm, cargoBean);
			
				cargoService.editarCargo(cargoBean, SecurityAccess.getUserInformation());
					
			} catch (PersistenceException e){
				LOGGER.error("Error en la edicion: "+e.getMessage());
				return retornoErrorCargo("Edit", "Error al guardar el cargo", map, cargoForm);
			} catch (ParseException e) {
				LOGGER.error("Error en la edicion: "+e.getMessage());
				return retornoErrorCargo("Edit", "Error al guardar el cargo", map, cargoForm);
			} 

			return "redirect:/app/cargo/startCargo";
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
	 * @param CargoForm
	 *            Formulario con los datos de la vista
	 * @return Componente tile al que se redirige
	 */
	private String retornoErrorCargo(String tipo, String mensaje, Map<String, Object> map, CargoForm cargoForm){
		
		cargoForm.setError(mensaje);
		
		// Rellenando el map de la vista
		fillInitialMap(map, "cargoForm");
		
		if (tipo.equalsIgnoreCase("Edit")){
			return "tiles/startEditCargo";
		} else if (tipo.equalsIgnoreCase("New")){
			return "tiles/startNewCargo";
		} else {
			return "app/errorPage";
		}
	}
	
	/**
	 * Método que limpia la caché de parámetros de búsqueda. 
	 * @return null
	 */
	@RequestMapping(value="/cargo/limpiarBusqueda")
	public String limpiarBusqueda(HttpServletRequest request, HttpServletResponse response) {
		// Almaceno los criterios de búsqueda en sesión de usuario
		request.getSession().setAttribute("cargoQueryBean", null);
		request.getSession().setAttribute("buscar", 0);
		
		return null;
	}
	
	/**
	 * Metodo privado que rellena el Formulario de busqueda con los datos provenientes del bean de consulta a la base de datos
	 * @param searchCargoForm, Formulario vacío
	 * @param cargoQueryBean, Objeto con los datos provenientes de base de datos
	 */
	private void toSearchForm(SearchCargoForm searchCargoForm, CargoQueryBean cargoQueryBean){
		searchCargoForm.setId(Utilidades.stringOrNull(cargoQueryBean.getId()));
		searchCargoForm.setCodigo(cargoQueryBean.getCodigo());
		searchCargoForm.setDescripcion(cargoQueryBean.getDescripcion());
		searchCargoForm.setActivo(cargoQueryBean.getActivo());
		searchCargoForm.setDefecto(cargoQueryBean.getDefecto());
	}
	
	/**
	 * Metodo privado que rellena el Formulario con los datos provenientes de la base de datos que hay en el bean.
	 * @param CargoForm, Formulario vacío
	 * @param CargoBean, Objeto con los datos provenientes de base de datos
	 */
	private void CargoBeanToCargoForm(CargoBean cargoBean, CargoForm cargoForm) {
		cargoForm.setId(cargoBean.getId().toString());
		cargoForm.setCodigo(cargoBean.getCodigo());
		cargoForm.setDescripcion(cargoBean.getDescripcion());
		cargoForm.setActivo(cargoBean.getActivo());
		cargoForm.setDefecto(cargoBean.getDefecto());
	}
	
	/**
	 * Metodo privado que rellena el Bean con los datos provenientes del formulario.
	 * @param CargoForm, Formulario relleno de la pantalla
	 * @param CargoBean, Objeto vacio
	 * @throws ParseException 
	 */
	private void CargoFormToCargoBean(CargoForm cargoForm, CargoBean cargoBean) throws ParseException {
		if (cargoForm.getId()!=null){
			cargoBean.setId(Long.valueOf(cargoForm.getId()));
		}
		cargoBean.setCodigo(cargoForm.getCodigo());
		cargoBean.setDescripcion(cargoForm.getDescripcion());
		cargoBean.setActivo(cargoForm.getActivo());
		cargoBean.setDefecto(cargoForm.getDefecto());
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
