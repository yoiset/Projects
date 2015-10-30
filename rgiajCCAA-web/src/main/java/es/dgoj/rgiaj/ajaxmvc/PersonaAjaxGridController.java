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
import com.dgoj.sprmvc.ajax.AbstractPaginatedGridAjaxController;
import com.dgoj.sprmvc.web.util.RequestUtil;

import es.dgoj.rgiaj.business.beans.ComunidadAutonomaBean;
import es.dgoj.rgiaj.business.beans.PersonaBean;
import es.dgoj.rgiaj.business.beans.PersonaQueryBean;
import es.dgoj.rgiaj.business.beans.PersonaSearchResult;
import es.dgoj.rgiaj.business.beans.ProvinciaBean;
import es.dgoj.rgiaj.business.beans.TipoDocIdentidadBean;
import es.dgoj.rgiaj.business.service.PersonaService;
import es.dgoj.rgiaj.encrypt.TimestampEncrypter;

/**
 * Clase que gestiona las peticiones asincronas realizadas 
 * para buscar las personas segun la informacion rellenada en el formulario de busqueda.
 * @author connectis
 */
@Controller
@RequestMapping(value="/persona/*")
public class PersonaAjaxGridController extends AbstractPaginatedGridAjaxController<PersonaBean, PersonaQueryBean> {

	/**
	 * Servicio de busqueda de Personas
	 */
	@Resource
	private PersonaService personaService;
	
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
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonaAjaxGridController.class);
	
	/**
	 * Peticiones asincronas para la busqueda de personas a partir del formulario de busqueda.
	 * @param request peticion
	 * @param response respuesta
	 * @return Json con la respuesta a la peticion
	 */
	@ResponseBody
	@RequestMapping(value="/persona/searchPersona")
	public String searchPersona(HttpServletRequest request, HttpServletResponse response) {		
		return super.process(request, response);
	}
	
	/**
	 * Metodo sobreescrito encargado de generar el objeto de busqueda a partir de la informacion de la request.
	 * @return Objeto de busqueda en base de datos
	 */
	@Override
	protected PersonaQueryBean toQuery() {
		String dateFormat = this.messageSource.getMessage("common.dateFormat", null, this.getLocale());
		
		PersonaQueryBean personaQueryBean = new PersonaQueryBean();
		
		personaQueryBean.setApellido1(RequestUtil.getStringParameter(this.getRequest(), "apellido1", null));
		personaQueryBean.setApellido2(RequestUtil.getStringParameter(this.getRequest(), "apellido2", null));
		personaQueryBean.setCodPostal(RequestUtil.getIntegerParameter(this.getRequest(), "codPostal", null));
		personaQueryBean.setDomicilio(RequestUtil.getStringParameter(this.getRequest(), "domicilio", null));
		personaQueryBean.setEmail(RequestUtil.getStringParameter(this.getRequest(), "email", null));
		personaQueryBean.setEstadoCarta(RequestUtil.getStringParameter(this.getRequest(), "estadoCarta", null));
		personaQueryBean.setEstadoEtiqueta(RequestUtil.getStringParameter(this.getRequest(), "estadoEtiqueta", null));
		personaQueryBean.setExpedProhibicion(RequestUtil.getStringParameter(this.getRequest(), "expedProhibicion", null));
		personaQueryBean.setFechaNacimientoDesde(RequestUtil.getDateParameter(this.getRequest(), "fechaNacimientoDesde", dateFormat));
		personaQueryBean.setFechaNacimientoHasta(RequestUtil.getDateParameter(this.getRequest(), "fechaNacimientoHasta", dateFormat));
		personaQueryBean.setIdMunicipio(RequestUtil.getLongParameter(this.getRequest(), "idMunicipio", null));
		personaQueryBean.setIdPais(RequestUtil.getLongParameter(this.getRequest(), "idPais", null));
		personaQueryBean.setIdPersona(RequestUtil.getLongParameter(this.getRequest(), "idPersona", null));
		personaQueryBean.setNombre(RequestUtil.getStringParameter(this.getRequest(), "nombre", null));
		personaQueryBean.setNumDocIdent(RequestUtil.getStringParameter(this.getRequest(), "numDocIdent", null));
		
		Long idTipoDocIdent = RequestUtil.getLongParameter(this.getRequest(), "tipoDocIdent", null);
		if (idTipoDocIdent!=null ){
			personaQueryBean.setTipoDocIdent(new TipoDocIdentidadBean());
			personaQueryBean.getTipoDocIdent().setId(idTipoDocIdent);
		}
		
		personaQueryBean.setObservaciones(RequestUtil.getStringParameter(this.getRequest(), "observaciones", null));
		personaQueryBean.setSexo(RequestUtil.getStringParameter(this.getRequest(), "sexo", null));
		personaQueryBean.setTelefono(RequestUtil.getStringParameter(this.getRequest(), "telefono", null));
		
		Long idProvincia = RequestUtil.getLongParameter(this.getRequest(), "idProvincia", null);
		Long idComunidad = RequestUtil.getLongParameter(this.getRequest(), "idComunidad", null);
		if ( idProvincia != null || idComunidad != null){
			personaQueryBean.setProvincia(new ProvinciaBean());
			if (idProvincia != null ){
				personaQueryBean.getProvincia().setId(idProvincia);
			}
			if (idComunidad != null ){
				personaQueryBean.getProvincia().setComunidad(new ComunidadAutonomaBean());
				personaQueryBean.getProvincia().getComunidad().setId(idComunidad);
			}
		}
		
		personaQueryBean.setIdTipoProhibicion(RequestUtil.getLongParameter(this.getRequest(), "idTipoProhibicion", null));
		personaQueryBean.setFechaProhibicionDesde(RequestUtil.getDateParameter(this.getRequest(), "fechaProhibicionDesde", dateFormat));
		personaQueryBean.setFechaProhibicionHasta(RequestUtil.getDateParameter(this.getRequest(), "fechaProhibicionHasta", dateFormat));
		personaQueryBean.setIdSituacion(RequestUtil.getLongParameter(this.getRequest(), "idSituacion", null));
		personaQueryBean.setFechaSituacionDesde(RequestUtil.getDateParameter(this.getRequest(), "fechaSituacionDesde", dateFormat));
		personaQueryBean.setFechaSituacionHasta(RequestUtil.getDateParameter(this.getRequest(), "fechaSituacionHasta", dateFormat));
		personaQueryBean.setIdCausaProhibicion(RequestUtil.getLongParameter(this.getRequest(), "idCausaProhibicion", null));
		personaQueryBean.setObsProhibicion(RequestUtil.getStringParameter(this.getRequest(), "obsProhibicion", null));

		String durAnos = RequestUtil.getStringParameter(this.getRequest(), "durAnos", null);
		String durMeses = RequestUtil.getStringParameter(this.getRequest(), "durMeses", null);
		if (durAnos != null){
			String duracion = durAnos;
			if (durMeses != null){
				duracion += durMeses;
			}
			personaQueryBean.setDuracion(duracion);
		}
		
		

		
		return personaQueryBean;
	}
	
	/**
	 * Metodo sobreescrito que implementa la busqueda especifica de este caso de uso.
	 * Busca en base de datos las incidencias que coincidan con los criterios especificados.
	 * @param personaQueryBean Objeto con los parametros de buscado obtenidos previamente de la request
	 * @return Objeto de resultado con la informacion de las incidencias.
	 */
	@Override
	protected SearchResult<PersonaBean> doSearch(PersonaQueryBean personaQueryBean) {
		// Almaceno los criterios de búsqueda en sesión de usuario
		this.getRequest().getSession().setAttribute("personaQueryBean", personaQueryBean);
		this.getRequest().getSession().setAttribute("buscarPersona", 0);

		PersonaSearchResult personaResults = this.personaService.getPersonas(personaQueryBean);
		
		SearchResult<PersonaBean> result = new SearchResult<PersonaBean>(personaResults.getResults());
		result.setNumResults(personaResults.getNumResults());
		
		LOGGER.info("Encontrados "+result.getNumResults()+" registros de Personas");
		
		return result;
	}
	
	/**
	 * Obtiene el identificador de la fila, y lo devuelve encriptado para securizar el acceso a dicha incidencia.
	 * @param bean objeto con la informacion de un tipo de prohibicion
	 * @return Identificador encriptado del tipo de prohibicion
	 */
	@Override
	protected String beanId(PersonaBean bean) {
		return new TimestampEncrypter().encrypt(String.valueOf(bean.getIdPersona()));
	}

	/**
	 * Convierte entre un objeto de base de datos y uno de capa de presentacion.
	 * @param bean objeto con la informacion de la base de datos
	 * @return objeto de capa de presentacion
	 */
	@Override
	protected String[] beanToStrings(PersonaBean bean) {
		String[] retorno = new String[] {
				WriteUtil.formatValue(bean.getExpedProhibicion()),
				WriteUtil.formatValue(bean.getTipoDocIdent().getDescripcion()),
				WriteUtil.formatValue(bean.getNumDocIdent()),
				WriteUtil.formatValue(bean.getNombre()),
				WriteUtil.formatValue(bean.getApellido1()),
				WriteUtil.formatValue(bean.getApellido2())
			};
		return retorno;
	}

}
