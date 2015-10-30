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

import es.dgoj.rgiaj.business.beans.SituacionBean;
import es.dgoj.rgiaj.business.beans.SituacionQueryBean;
import es.dgoj.rgiaj.business.beans.SituacionSearchResult;
import es.dgoj.rgiaj.business.service.SituacionService;
import es.dgoj.rgiaj.encrypt.TimestampEncrypter;

/**
 * Clase que gestiona las peticiones asincronas realizadas 
 * para buscar las situaciones segun la informacion rellenada en el formulario de busqueda.
 * @author connectis
 */
@Controller
@RequestMapping(value="/situacion/*")
public class SituacionAjaxGridController extends AbstractPaginatedGridAjaxController<SituacionBean, SituacionQueryBean> {

	/**
	 * Servicio de busqueda de situaciones
	 */
	@Resource
	private SituacionService situacionService;
	
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
	private static final Logger LOGGER = LoggerFactory.getLogger(SituacionAjaxGridController.class);
	
	/**
	 * Peticiones asincronas para la busqueda de situaciones a partir del formulario de busqueda.
	 * @param request peticion
	 * @param response respuesta
	 * @return Json con la respuesta a la peticion
	 */
	@ResponseBody
	@RequestMapping(value="/situacion/searchSituacion")
	public String searchSituacion(HttpServletRequest request, HttpServletResponse response) {		
		return super.process(request, response);
	}
	
	
	/**
	 * Peticiones asincronas para borrar una situacion.
	 * @param request peticion
	 * @param response respuesta
	 * @return Json con la respuesta a la peticion
	 */
	@ResponseBody
	@RequestMapping(value="/situacion/deleteSituacion")
	public String deleteSituacion(HttpServletRequest request, HttpServletResponse response) {
		String result = null;
		try{
			String id = RequestUtil.getStringParameter(request, "id");
	    	id = id.replace(' ', '+');
			String decId = new TimestampEncrypter().decryptAndValidate(id, 1000 * viewTimeout );
					
			situacionService.bajaSituacion(Long.valueOf(decId), SecurityAccess.getUserInformation());
			
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
	protected SituacionQueryBean toQuery() {
		
		SituacionQueryBean situacionQueryBean = new SituacionQueryBean();
		
		situacionQueryBean.setId(RequestUtil.getLongParameter(this.getRequest(), "id", null));
		situacionQueryBean.setCodigo(RequestUtil.getStringParameter(this.getRequest(), "codigo", null));
		situacionQueryBean.setDescripcion(RequestUtil.getStringParameter(this.getRequest(), "descripcion", null));
		situacionQueryBean.setActivo(RequestUtil.getBooleanParameter(this.getRequest(), "activo", null));
		return situacionQueryBean;
	}
	
	/**
	 * Metodo sobreescrito que implementa la busqueda especifica de este caso de uso.
	 * Busca en base de datos las incidencias que coincidan con los criterios especificados.
	 * @param situacionQueryBean Objeto con los parametros de buscado obtenidos previamente de la request
	 * @return Objeto de resultado con la informacion de las incidencias.
	 */
	@Override
	protected SearchResult<SituacionBean> doSearch(SituacionQueryBean situacionQueryBean) {
		// Almaceno los criterios de búsqueda en sesión de usuario
		this.getRequest().getSession().setAttribute("situacionQueryBean", situacionQueryBean);
		
		SituacionSearchResult situacionResults = this.situacionService.getSituaciones(situacionQueryBean);
		
		SearchResult<SituacionBean> result = new SearchResult<SituacionBean>(situacionResults.getResults());
		result.setNumResults(situacionResults.getNumResults());
		
		LOGGER.info("Encontrados "+result.getNumResults()+" registros de Situaciones");
		
		return result;
	}
	
	/**
	 * Obtiene el identificador de la fila, y lo devuelve encriptado para securizar el acceso a dicha incidencia.
	 * @param bean objeto con la informacion de una situacion
	 * @return Identificador encriptado de la situacion
	 */
	@Override
	protected String beanId(SituacionBean bean) {
		return new TimestampEncrypter().encrypt(String.valueOf(bean.getId()));
	}

	/**
	 * Convierte entre un objeto de base de datos y uno de capa de presentacion.
	 * @param bean objeto con la informacion de la base de datos
	 * @return objeto de capa de presentacion
	 */
	@Override
	protected String[] beanToStrings(SituacionBean bean) {
		String[] retorno = new String[] {
				WriteUtil.formatValue(bean.getCodigo()),
				WriteUtil.formatValue(bean.getDescripcion()),
				WriteUtil.formatValue(bean.getActivo()?this.messageSource.getMessage("common.si", null, WebCoreUtils.getLocale()):this.messageSource.getMessage("common.no", null, WebCoreUtils.getLocale())),
				WriteUtil.formatValue(bean.getTipoSituacion()==null?"":bean.getTipoSituacion()),
				WriteUtil.formatValue(bean.getTipoSituacion()==null?"":bean.getSituacionMaq()),
				WriteUtil.formatValue(bean.getTipoSituacion()==null?"":bean.getSituacionEmp()),
				WriteUtil.formatValue(bean.getTipoSituacion()==null?"":bean.getSituacionLocal()),
				WriteUtil.formatValue(bean.getTipoSituacion()==null?"":bean.getSituacionPersona()),
				WriteUtil.formatValue(bean.getTipoSituacion()==null?"":bean.getSituacionModelo())
			};
		return retorno;
	}

}
