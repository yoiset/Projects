package es.dgoj.rgiaj.controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dgoj.core.common.util.DateUtil;
import com.dgoj.core.security.sso.access.SecurityAccess;
import com.dgoj.sprmvc.web.util.RequestUtil;
import com.jeveris.core.exception.impl.CoreException;
import com.jeveris.web.core.utils.WebCoreUtils;

import es.dgoj.rgiaj.business.beans.ComunidadBean;
import es.dgoj.rgiaj.business.beans.ComunidadQueryBean;
import es.dgoj.rgiaj.business.beans.JugProhibicionBean;
import es.dgoj.rgiaj.business.service.IComunidadServ;
import es.dgoj.rgiaj.business.service.IJugProhibicionServ;
import es.dgoj.rgiaj.form.ComunidadForm;


@Controller
@RequestMapping(value = "/comunidad/*")
public class ComunidadController extends SessionController {

	/**
	 * Servicio de acceso al contenedor de mensajes de spring.
	 */
	@Resource
	private MessageSource messageSource;
	
	@Resource IJugProhibicionServ jugProhibicionService;
	
	@Resource  IComunidadServ comunidadService;
	
	
	private static final Logger log = LoggerFactory.getLogger(ComunidadController.class);  
	/**
	 * Peticiones para administrar las tablas maestras de la aplicacion.
	 * @param map Contenedor de informacion para la vista
	 * @param request Peticion
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/comunidad/start")
	public String start(Map<String, Object> map, HttpServletRequest request, ComunidadForm comunidadForm ) {
		
		map.put("modelAttribute", "comunidadForm");
		initComunidad(request,map);	
		
		Locale locale = WebCoreUtils.getLocale();
		// Informacion para el renderizado de la pagina
		map.put("firstOptionText",  this.messageSource.getMessage("page.common.option.select", null, locale));
		map.put("userLang", locale.getLanguage());
		map.put("sensitiveRangeMax", DateUtil.format(new Date(), "dd/MM/yyyy HH:mm"));

		return "tiles/editComunidad";
	}
	
	
	private void initComunidad(HttpServletRequest request, Map<String, Object> map) {
		JugProhibicionBean bean= (JugProhibicionBean) request.getSession().getAttribute("beanSession");
		if(bean==null){
			init(request);
			bean= (JugProhibicionBean) request.getSession().getAttribute("beanSession");
		}
		
		if(bean.isNac()){
			List<ComunidadBean> list= comunidadService.getComunidadList()	;
			map.put("listComunidad", list);	
		} else {
			map.put("idComunidad", bean.getIdComunidad());	
		}
		
		
	}
	
	
	/**
	 * Peticiones para generar el informe de Comunidad
	 * 
	 * @param request
	 *            Peticion
	 * @param response
	 *            Respuesta
	 * @return void
	 */
	@RequestMapping(value="/comunidad/exportComunidad")
	public String exportComunidad(HttpServletRequest request, HttpServletResponse response) {
		
		// Generar el informe en formato Excel
		ComunidadQueryBean query = (ComunidadQueryBean) request.getSession().getAttribute(es.dgoj.rgiaj.util.Constantes.comunidadQueryBean);
		
		String username = (String) SecurityAccess.getUserInformation().getUsername();
		String reportName = "comunidadJuegoReport";
		String reportTitle = this.messageSource.getMessage("page.breadcrumb.comunidadJuego", null, WebCoreUtils.getLocale());
		String reportType = RequestUtil.getStringParameter(request, "exportType", null);
		String fullReportName = null;
		String contentType = null;

		try {
			if ( reportType != null ) {
				if (!reportType.equalsIgnoreCase("Exportar")) {
					if (reportType.equalsIgnoreCase("XLS")) {
						fullReportName = "comunidadReport.xls";
					    contentType = "application/xls";
					} else if (reportType.equalsIgnoreCase("PDF")){
						fullReportName = "comunidadReport.pdf";
					    contentType = "application/pdf";
					} else if (reportType.equalsIgnoreCase("DOCX")){
					    fullReportName = "comunidadReport.doc";
					    contentType = "application/doc";
					} else {
					    throw new CoreException("error.export");
					}
	
					byte[] byteArray = this.comunidadService.exportComunidad(username, query, reportType, reportName, reportTitle);
					response.reset();
					response.setContentType(contentType);
					response.setHeader("Content-disposition", "attachment" + ";filename=\"" + fullReportName + "\"");
					response.addHeader("Pragma", "no cache");
					response.addHeader("Cache-control", "private, must-revalidate");
					
					ServletOutputStream outstream = response.getOutputStream();
					outstream.write(byteArray);
					outstream.flush();
					outstream.close();
				} else {
					return es.dgoj.rgiaj.util.Constantes.ERRORPAGE; 
				}
			} else {
				throw new CoreException("error.request.export");
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
			return es.dgoj.rgiaj.util.Constantes.ERRORPAGE;
		}
		
		return null;
	}


	public IJugProhibicionServ getJugProhibicionService() {
		return jugProhibicionService;
	}


	public void setJugProhibicionService(IJugProhibicionServ jugProhibicionService) {
		this.jugProhibicionService = jugProhibicionService;
	}
	
	
	
	
	
}
