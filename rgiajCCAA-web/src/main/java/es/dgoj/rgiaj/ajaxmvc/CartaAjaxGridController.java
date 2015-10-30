package es.dgoj.rgiaj.ajaxmvc;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgoj.core.common.bean.ParamBean;
import com.dgoj.core.common.entity.SearchResult;
import com.dgoj.core.common.util.WriteUtil;
import com.dgoj.core.security.sso.access.SecurityAccess;
import com.dgoj.sprmvc.ajax.AbstractPaginatedGridAjaxController;
import com.dgoj.sprmvc.web.util.RequestUtil;
import com.jeveris.core.exception.impl.CoreException;

import es.dgoj.rgiaj.business.beans.CartaBean;
import es.dgoj.rgiaj.business.beans.CartaQueryBean;
import es.dgoj.rgiaj.business.beans.CartaSearchResult;
import es.dgoj.rgiaj.business.service.CargoService;
import es.dgoj.rgiaj.business.service.CartaService;
import es.dgoj.rgiaj.business.service.FirmaService;
import es.dgoj.rgiaj.encrypt.TimestampEncrypter;

/**
 * Clase que gestiona las peticiones asincronas realizadas 
 * para buscar los cartas segun la informacion rellenada en el formulario de busqueda.
 * @author connectis
 */
@Controller
@RequestMapping(value="/carta/*")
public class CartaAjaxGridController extends AbstractPaginatedGridAjaxController<CartaBean, CartaQueryBean> {

	/**
	 * Servicio de busqueda de Cartas
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
	 * Log de la clase.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CartaAjaxGridController.class);
	
	/**
	 * Peticiones asincronas para la busqueda de cartas a partir del formulario de busqueda.
	 * @param request peticion
	 * @param response respuesta
	 * @return Json con la respuesta a la peticion
	 */
	@ResponseBody
	@RequestMapping(value="/carta/searchCarta")
	public String searchCarta(HttpServletRequest request, HttpServletResponse response) {		
		return super.process(request, response);
	}
	
	
	/**
	 * Peticiones asincronas para borrar un tipo de prohibicion
	 * @param request peticion
	 * @param response respuesta
	 * @return Json con la respuesta a la peticion
	 */
	@ResponseBody
	@RequestMapping(value="/carta/deleteCarta")
	public String deleteCarta(HttpServletRequest request, HttpServletResponse response) {
		String result = null;
		try{
			String id = RequestUtil.getStringParameter(request, "id");
	    	id = id.replace(' ', '+');
			String decId = new TimestampEncrypter().decryptAndValidate(id, 1000 * viewTimeout );
					
			cartaService.bajaCarta(Long.valueOf(decId), SecurityAccess.getUserInformation());
			
		} catch (CoreException e) {
			//Cuando se produce una excepción técnica, se presenta
	        //al usuario un mensaje de error genérico, y el error
	        //se registra en un log
	        LOGGER.error("Error en la aplicacion", e);
	        result = "ERROR " + e.getMessage();
	    } catch (Exception e) {
	        LOGGER.error("Error generico", e);
	        if (e.getMessage()!=null){
	        	result = "ERROR " + e.getMessage();
	        }else{
	         	result = "ERROR Error generico de la aplicación";
	        }
	    }	
		return result;
	}
	
	/**
	 * Metodo sobreescrito encargado de generar el objeto de busqueda a partir de la informacion de la request.
	 * @return Objeto de busqueda en base de datos
	 */
	@Override
	protected CartaQueryBean toQuery() {
		
		CartaQueryBean cartaQueryBean = new CartaQueryBean();
		
		cartaQueryBean.setId(RequestUtil.getLongParameter(this.getRequest(), "id", null));
		cartaQueryBean.setDescripcion(RequestUtil.getStringParameter(this.getRequest(), "descripcion", null));
		cartaQueryBean.setCargo(RequestUtil.getLongParameter(this.getRequest(), "cargo", null));
		cartaQueryBean.setResponsable(RequestUtil.getLongParameter(this.getRequest(), "responsable", null));

		return cartaQueryBean;
	}
	
	/**
	 * Metodo sobreescrito que implementa la busqueda especifica de este caso de uso.
	 * Busca en base de datos las incidencias que coincidan con los criterios especificados.
	 * @param cartaQueryBean Objeto con los parametros de buscado obtenidos previamente de la request
	 * @return Objeto de resultado con la informacion de las incidencias.
	 */
	@Override
	protected SearchResult<CartaBean> doSearch(CartaQueryBean cartaQueryBean) {
		// Almaceno los criterios de búsqueda en sesión de usuario
		this.getRequest().getSession().setAttribute("cartaQueryBean", cartaQueryBean);
				
		CartaSearchResult cartaResults = this.cartaService.getCartas(cartaQueryBean);
				
		SearchResult<CartaBean> result = new SearchResult<CartaBean>(cartaResults.getResults());
		result.setNumResults(cartaResults.getNumResults());
		
		LOGGER.info("Encontrados "+result.getNumResults()+" registros de Cartas");
		
		return result;
	}
	
	private String buscaEnLista(Long id, List<ParamBean> lista){
		for (ParamBean bean: lista){
			if (bean.getCode().equalsIgnoreCase(id.toString())){
				return bean.getDescription();
			}
		}
		return "";
	}
	
	/**
	 * Obtiene el identificador de la fila, y lo devuelve encriptado para securizar el acceso a dicha incidencia.
	 * @param bean objeto con la informacion de un tipo de prohibicion
	 * @return Identificador encriptado del tipo de prohibicion
	 */
	@Override
	protected String beanId(CartaBean bean) {
		return new TimestampEncrypter().encrypt(String.valueOf(bean.getId()));
	}

	/**
	 * Convierte entre un objeto de base de datos y uno de capa de presentacion.
	 * @param bean objeto con la informacion de la base de datos
	 * @return objeto de capa de presentacion
	 */
	@Override
	protected String[] beanToStrings(CartaBean bean) {
		List<ParamBean> listCargos = cargoService.getListaCargos();
		List<ParamBean> listFirmas = firmaService.getListaFirmas();
		
		String[] retorno = new String[] {
				WriteUtil.formatValue(bean.getId()),
				WriteUtil.formatValue(bean.getDescripcion()),
				WriteUtil.formatValue(buscaEnLista(bean.getCargo(), listCargos)),
				WriteUtil.formatValue(buscaEnLista(bean.getResponsable(), listFirmas))
				//WriteUtil.formatValue(bean.getDefecto()?this.messageSource.getMessage("common.si", null, WebCoreUtils.getLocale()):this.messageSource.getMessage("common.no", null, WebCoreUtils.getLocale())),
				//WriteUtil.formatValue(bean.getActivo()?this.messageSource.getMessage("common.si", null, WebCoreUtils.getLocale()):this.messageSource.getMessage("common.no", null, WebCoreUtils.getLocale()))
			};
		return retorno;
	}

}
