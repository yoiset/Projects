package es.dgoj.rgiaj.ajaxmvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.util.Log;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgoj.core.common.entity.SearchResult;
import com.dgoj.core.common.util.WriteUtil;
import com.dgoj.sprmvc.ajax.AbstractPaginatedGridAjaxController;
import com.dgoj.sprmvc.web.util.RequestUtil;
import com.jeveris.web.core.utils.WebCoreUtils;

import es.dgoj.rgiaj.business.beans.JugHistoricoBean;
import es.dgoj.rgiaj.business.beans.JugHistoricoQueryBean;
import es.dgoj.rgiaj.business.beans.JugHistoricoSearchResult;
import es.dgoj.rgiaj.business.beans.JugProhibicionBean;
import es.dgoj.rgiaj.business.service.IJugHistoricoDescargaServ;
import es.dgoj.rgiaj.encrypt.TimestampEncrypter;


@Controller
@RequestMapping(value="/historicoAjax/*")
public class HistoricoAjaxController extends AbstractPaginatedGridAjaxController<JugHistoricoBean, JugHistoricoQueryBean> {
	
	
	/**
	 * Servicio de acceso al contenedor de mensajes de spring.
	 */
	@Resource
	private MessageSource messageSource;
	
	@Resource 
	private IJugHistoricoDescargaServ jugHistoricoDescargaServ;
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/historicoAjax/start")
	public String start(HttpServletRequest request, HttpServletResponse response) {
		
//		init(request);	
		
		Locale locale = WebCoreUtils.getLocale();
		// Informacion para el renderizado de la pagina
					
		return super.process(request, response);
		
//		return "tiles/historico";
	}
	
	
	


	/** Realizar el search a partir del query recibido
	 * @see com.dgoj.sprmvc.ajax.AbstractPaginatedGridAjaxController#doSearch(com.dgoj.core.common.entity.AbstractQueryEntity)
	 */
	@Override
	protected SearchResult<JugHistoricoBean> doSearch(JugHistoricoQueryBean query) {
		// TODO Auto-generated method stub
	   this.getSession().setAttribute("historicoQuery", query);
	   JugHistoricoSearchResult historicoResult= jugHistoricoDescargaServ.getHistorico(query);
	   
	   SearchResult<JugHistoricoBean> result=new SearchResult<JugHistoricoBean>(historicoResult.getResults());
	   result.setNumResults(historicoResult.getNumResults());
		
		return result;
	}


	/** Construye el query bean a partir de los datos enviados en el Request
	 * @see com.dgoj.sprmvc.ajax.AbstractGridAjaxController#toQuery()
	 */
	@Override
	protected JugHistoricoQueryBean toQuery() {
		// TODO Auto-generated method stub
		JugHistoricoQueryBean query = new JugHistoricoQueryBean();
		JugProhibicionBean beanSession=getBeanSession();
		
		String queryComunidad=getComunidadCode();
		
		if(beanSession.isNac())   // Aqui se controla que en Query se pueda enviar una comunidad distinta a NAC si usuario que esta logado pertenece a la misma 
			query.setCodComunidad(queryComunidad);
		else query.setCodComunidad(beanSession.getCodComunidad());
		
		Date fechaDesde=getFechaDesde();
		Date fechaHasta=getFechaHasta();
		if(fechaDesde!=null)
			query.setFechaDesde(fechaDesde);
		if(fechaHasta!=null)
			query.setFechaHasta(fechaHasta);
		
		query.setConfirmada(getConfirmada());
		query.setProcedencia(getProcedencia());
		
		getRequest().getSession().setAttribute(es.dgoj.rgiaj.util.Constantes.historicodQueryBean, query);
		return query;
	}


	/** Asigna un Id
	 * @see com.dgoj.sprmvc.ajax.AbstractGridAjaxController#beanId(java.io.Serializable)
	 */
	@Override
	protected String beanId(JugHistoricoBean bean) {
		// TODO Auto-generated method stub
		return new TimestampEncrypter().encrypt(String.valueOf(bean.getIdHistoricoDescarga()));
	}


	/** Convierte el Bean a formato String Array para ser cargado en la Pagina
	 * @see com.dgoj.sprmvc.ajax.AbstractGridAjaxController#beanToStrings(java.io.Serializable)
	 */
	@Override
	protected String[] beanToStrings(JugHistoricoBean bean) {
		// TODO Auto-generated method stub
		String[] retorno = new String[] {
				WriteUtil.formatValue(bean.getComunidad().getDescripcion()),
				WriteUtil.formatValue(bean.getFechaDescarga(),this.messageSource.getMessage("common.dateTimeFormat", null, this.getLocale())),
				WriteUtil.formatValue(bean.getTipo()),
				WriteUtil.formatValue(bean.getConfirmada()),
				WriteUtil.formatValue(bean.getUltimo()),
				WriteUtil.formatValue(bean.getProcedencia())
				
				
			};
		return retorno;
	}
	
	/**
	 * @return
	 */
	private JugProhibicionBean getBeanSession(){
		return (JugProhibicionBean) getSession().getAttribute("beanSession");
	}
	
	
	/**
	 * @return
	 */
	private String getComunidadCode(){
		String value=RequestUtil.getStringParameter(getRequest(), "codComunidad");
		return value;
	}
	
	private Date getFechaDesde(){
		String value=RequestUtil.getStringParameter(getRequest(), "fechaDesde");
		if(value==null || value.isEmpty()) return null;
		SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
		try {
			return format.parse(value);
		} catch (ParseException e) {
			Log.error("Error intentando Parsear fecha desde la Pagina de Historico " + e);
		}
		
		return null;
	}
	
	private Date getFechaHasta(){
		String value=RequestUtil.getStringParameter(getRequest(), "fechaHasta");
		SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
		if(value==null || value.isEmpty()) return null;
		try {
			return format.parse(value);
		} catch (ParseException e) {
			Log.error("Error intentando Parsear fecha desde la Pagina de Historico " + e);
		}
		
		return null;
	}
	
	private Boolean getConfirmada(){
		
		String value=RequestUtil.getStringParameter(getRequest(), "confirmada");
		if(value==null) return null;
		if(value.equalsIgnoreCase("true")) return true;
		if(value.equalsIgnoreCase("false")) return false;
		
		return null;
	}
	
	private String getProcedencia(){
		return RequestUtil.getStringParameter(getRequest(), "procedencia");
	}
	


	
}
