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

import es.dgoj.rgiaj.business.beans.TipoFirmaBean;
import es.dgoj.rgiaj.business.beans.TipoFirmaQueryBean;
import es.dgoj.rgiaj.business.beans.TipoFirmaSearchResult;
import es.dgoj.rgiaj.business.service.TipoFirmaService;
import es.dgoj.rgiaj.encrypt.TimestampEncrypter;

/**
 * Clase que gestiona las peticiones asincronas realizadas 
 * para buscar los tipos de firma segun la informacion rellenada en el formulario de busqueda.
 * @author connectis
 */
@Controller
@RequestMapping(value="/tipoFirma/*")
public class TipoFirmaAjaxGridController extends AbstractPaginatedGridAjaxController<TipoFirmaBean, TipoFirmaQueryBean> {

	/**
	 * Servicio de busqueda de Tipos de firma
	 */
	@Resource
	private TipoFirmaService tipoFirmaService;
	
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
	private static final Logger LOGGER = LoggerFactory.getLogger(TipoFirmaAjaxGridController.class);
	
	/**
	 * Peticiones asincronas para la busqueda de tipos de firma a partir del formulario de busqueda.
	 * @param request peticion
	 * @param response respuesta
	 * @return Json con la respuesta a la peticion
	 */
	@ResponseBody
	@RequestMapping(value="/tipoFirma/searchTipoFirma")
	public String searchTipoFirma(HttpServletRequest request, HttpServletResponse response) {		
		return super.process(request, response);
	}
	
	
	/**
	 * Peticiones asincronas para borrar un tipo de firma
	 * @param request peticion
	 * @param response respuesta
	 * @return Json con la respuesta a la peticion
	 */
	@ResponseBody
	@RequestMapping(value="/tipoFirma/deleteTipoFirma")
	public String deleteTipoFirma(HttpServletRequest request, HttpServletResponse response) {
		String result = null;
		try{
			String id = RequestUtil.getStringParameter(request, "id");
	    	id = id.replace(' ', '+');
			String decId = new TimestampEncrypter().decryptAndValidate(id, 1000 * viewTimeout );
					
			tipoFirmaService.bajaTipoFirma(Long.valueOf(decId), SecurityAccess.getUserInformation());
			
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
	protected TipoFirmaQueryBean toQuery() {
		
		TipoFirmaQueryBean tipoFirmaQueryBean = new TipoFirmaQueryBean();
		
		tipoFirmaQueryBean.setId(RequestUtil.getLongParameter(this.getRequest(), "id", null));
		tipoFirmaQueryBean.setCodigo(RequestUtil.getStringParameter(this.getRequest(), "codigo", null));
		tipoFirmaQueryBean.setDescripcion(RequestUtil.getStringParameter(this.getRequest(), "descripcion", null));
		tipoFirmaQueryBean.setActivo(RequestUtil.getBooleanParameter(this.getRequest(), "activo", null));
		tipoFirmaQueryBean.setDefecto(RequestUtil.getBooleanParameter(this.getRequest(), "defecto", null));
		return tipoFirmaQueryBean;
	}
	
	/**
	 * Metodo sobreescrito que implementa la busqueda especifica de este caso de uso.
	 * Busca en base de datos las incidencias que coincidan con los criterios especificados.
	 * @param tipoFirmaQueryBean Objeto con los parametros de buscado obtenidos previamente de la request
	 * @return Objeto de resultado con la informacion de las incidencias.
	 */
	@Override
	protected SearchResult<TipoFirmaBean> doSearch(TipoFirmaQueryBean tipoFirmaQueryBean) {
		// Almaceno los criterios de búsqueda en sesión de usuario
		this.getRequest().getSession().setAttribute("tipoFirmaQueryBean", tipoFirmaQueryBean);
		
		TipoFirmaSearchResult tipoFirmaResults = this.tipoFirmaService.getTiposFirma(tipoFirmaQueryBean);
		
		SearchResult<TipoFirmaBean> result = new SearchResult<TipoFirmaBean>(tipoFirmaResults.getResults());
		result.setNumResults(tipoFirmaResults.getNumResults());
		
		LOGGER.info("Encontrados "+result.getNumResults()+" registros de Tipos de firma");
		
		return result;
	}
	
	/**
	 * Obtiene el identificador de la fila, y lo devuelve encriptado para securizar el acceso a dicha incidencia.
	 * @param bean objeto con la informacion de un tipo de firma
	 * @return Identificador encriptado del tipo de firma
	 */
	@Override
	protected String beanId(TipoFirmaBean bean) {
		return new TimestampEncrypter().encrypt(String.valueOf(bean.getId()));
	}

	/**
	 * Convierte entre un objeto de base de datos y uno de capa de presentacion.
	 * @param bean objeto con la informacion de la base de datos
	 * @return objeto de capa de presentacion
	 */
	@Override
	protected String[] beanToStrings(TipoFirmaBean bean) {
		String[] retorno = new String[] {
				WriteUtil.formatValue(bean.getCodigo()),
				WriteUtil.formatValue(bean.getDescripcion()),
				WriteUtil.formatValue(bean.getActivo()?this.messageSource.getMessage("common.si", null, WebCoreUtils.getLocale()):this.messageSource.getMessage("common.no", null, WebCoreUtils.getLocale())),
				WriteUtil.formatValue(bean.getDefecto()?this.messageSource.getMessage("common.si", null, WebCoreUtils.getLocale()):this.messageSource.getMessage("common.no", null, WebCoreUtils.getLocale()))
			};
		return retorno;
	}



	
	
}
