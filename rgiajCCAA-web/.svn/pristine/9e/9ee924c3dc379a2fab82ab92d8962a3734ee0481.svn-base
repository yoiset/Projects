package es.dgoj.rgiaj.ajaxmvc;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgoj.core.common.entity.SearchResult;
import com.dgoj.core.common.util.WriteUtil;
import com.dgoj.core.security.sso.access.SecurityAccess;
import com.dgoj.sprmvc.ajax.AbstractPaginatedGridAjaxController;
import com.dgoj.sprmvc.web.util.RequestUtil;
import com.jeveris.core.exception.impl.CoreException;
import com.jeveris.web.core.utils.WebCoreUtils;

import es.dgoj.rgiaj.business.beans.ComunidadAutonomaBean;
import es.dgoj.rgiaj.business.beans.ComunidadAutonomaQueryBean;
import es.dgoj.rgiaj.business.beans.ComunidadAutonomaSearchResult;
import es.dgoj.rgiaj.business.service.ComunidadAutonomaService;
import es.dgoj.rgiaj.encrypt.TimestampEncrypter;

/**
 * Clase que gestiona las peticiones asincronas realizadas 
 * para buscar las comunidades autonomas segun la informacion rellenada en el formulario de busqueda.
 * @author connectis
 */
@Controller
@RequestMapping(value="/comunidadAutonoma/*")
public class ComunidadAutonomaAjaxGridController extends AbstractPaginatedGridAjaxController<ComunidadAutonomaBean, ComunidadAutonomaQueryBean> {

	/**
	 * Servicio de busqueda de Comunidades Autonomas
	 */
	@Resource
	private ComunidadAutonomaService comunidadAutonomaService;
	
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
	private static final Logger LOGGER = LoggerFactory.getLogger(ComunidadAutonomaAjaxGridController.class);
	
	/**
	 * Peticiones asincronas para la busqueda de comunidades autonomas a partir del formulario de busqueda.
	 * @param request peticion
	 * @param response respuesta
	 * @return Json con la respuesta a la peticion
	 */
	@ResponseBody
	@RequestMapping(value="/comunidadAutonoma/searchComunidadAutonoma")
	public String searchComunidadAutonoma(HttpServletRequest request, HttpServletResponse response) {		
		return super.process(request, response);
	}
	
	
	/**
	 * Peticiones asincronas para borrar una comunidad autonoma
	 * @param request peticion
	 * @param response respuesta
	 * @return Json con la respuesta a la peticion
	 */
	@ResponseBody
	@RequestMapping(value="/comunidadAutonoma/deleteComunidadAutonoma")
	public String deleteComunidadAutonoma(HttpServletRequest request, HttpServletResponse response) {
		String result = null;
		try{
			String id = RequestUtil.getStringParameter(request, "id");
	    	id = id.replace(' ', '+');
			String decId = new TimestampEncrypter().decryptAndValidate(id, 1000 * viewTimeout );
					
			comunidadAutonomaService.bajaComunidadAutonoma(Long.valueOf(decId), SecurityAccess.getUserInformation());
			
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
	protected ComunidadAutonomaQueryBean toQuery() {
		
		ComunidadAutonomaQueryBean comunidadAutonomaQueryBean = new ComunidadAutonomaQueryBean();
		
		comunidadAutonomaQueryBean.setId(RequestUtil.getLongParameter(this.getRequest(), "id", null));
		comunidadAutonomaQueryBean.setCodigo(RequestUtil.getStringParameter(this.getRequest(), "codigo", null));
		comunidadAutonomaQueryBean.setDescripcion(RequestUtil.getStringParameter(this.getRequest(), "descripcion", null));
		comunidadAutonomaQueryBean.setActivo(RequestUtil.getBooleanParameter(this.getRequest(), "activo", null));
		return comunidadAutonomaQueryBean;
	}
	
	/**
	 * Metodo sobreescrito que implementa la busqueda especifica de este caso de uso.
	 * Busca en base de datos las incidencias que coincidan con los criterios especificados.
	 * @param comunidadAutonomaQueryBean Objeto con los parametros de buscado obtenidos previamente de la request
	 * @return Objeto de resultado con la informacion de las incidencias.
	 */
	@Override
	protected SearchResult<ComunidadAutonomaBean> doSearch(ComunidadAutonomaQueryBean comunidadAutonomaQueryBean) {
		// Almaceno los criterios de búsqueda en sesión de usuario
		this.getRequest().getSession().setAttribute("comunidadAutonomaQueryBean", comunidadAutonomaQueryBean);
		
		ComunidadAutonomaSearchResult comunidadAutonomaResults = this.comunidadAutonomaService.getComunidadesAutonomas(comunidadAutonomaQueryBean);
		
		SearchResult<ComunidadAutonomaBean> result = new SearchResult<ComunidadAutonomaBean>(comunidadAutonomaResults.getResults());
		result.setNumResults(comunidadAutonomaResults.getNumResults());
		
		LOGGER.info("Encontrados "+result.getNumResults()+" registros de Tipos de Prohibicion");
		
		return result;
	}
	
	/**
	 * Obtiene el identificador de la fila, y lo devuelve encriptado para securizar el acceso a dicha incidencia.
	 * @param bean objeto con la informacion de una comunidad autonoma
	 * @return Identificador encriptado de la comunidad autonoma
	 */
	@Override
	protected String beanId(ComunidadAutonomaBean bean) {
		return new TimestampEncrypter().encrypt(String.valueOf(bean.getId()));
	}

	/**
	 * Convierte entre un objeto de base de datos y uno de capa de presentacion.
	 * @param bean objeto con la informacion de la base de datos
	 * @return objeto de capa de presentacion
	 */
	@Override
	protected String[] beanToStrings(ComunidadAutonomaBean bean) {
		String[] retorno = new String[] {
				WriteUtil.formatValue(bean.getCodigo()),
				WriteUtil.formatValue(bean.getDescripcion()),
				WriteUtil.formatValue(bean.getActivo()?this.messageSource.getMessage("common.si", null, WebCoreUtils.getLocale()):this.messageSource.getMessage("common.no", null, WebCoreUtils.getLocale()))
			};
		return retorno;
	}



	
	
}
