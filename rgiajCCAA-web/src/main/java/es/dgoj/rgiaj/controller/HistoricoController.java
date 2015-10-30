package es.dgoj.rgiaj.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dgoj.core.security.sso.access.SecurityAccess;
import com.dgoj.sprmvc.web.util.RequestUtil;
import com.jeveris.core.exception.impl.CoreException;
import com.jeveris.web.core.utils.WebCoreUtils;

import es.dgoj.rgiaj.business.beans.ComunidadBean;
import es.dgoj.rgiaj.business.beans.JugHistoricoQueryBean;
import es.dgoj.rgiaj.business.beans.JugProhibicionBean;
import es.dgoj.rgiaj.business.service.IComunidadServ;
import es.dgoj.rgiaj.business.service.IJugHistoricoDescargaServ;
import es.dgoj.rgiaj.business.service.IJugProhibicionServ;


@Controller
@RequestMapping(value="/historico/*")
public class HistoricoController  extends SessionController{
	
	
	/**
	 * Servicio de acceso al contenedor de mensajes de spring.
	 */
	@Resource
	private MessageSource messageSource;
	
//	@Autowired 
//	private IJugHistoricoDescargaService jugHistoricoDescargaService;
	
	@Autowired
	private IComunidadServ comunidadService;
	
	@Resource 
	private IJugHistoricoDescargaServ jugHistoricoDescargaServ;
	
	@Resource IJugProhibicionServ jugProhibicionService;
	
	private static final Logger log = LoggerFactory.getLogger(HistoricoController.class);  
	
	
	@RequestMapping(value = "/historico/start")
	public String start(HttpServletRequest request, HttpServletResponse response,  Map<String, Object> map) {
		
		Locale locale = WebCoreUtils.getLocale();
		map.put("userLang", locale.getLanguage());
		// Informacion para el renderizado de la pagina
		initHistorico(request,map);
		
		return "tiles/historico";
	}


	
	/**
	 * 
	 */
	private void initHistorico(HttpServletRequest request, Map<String, Object> map) {
		JugProhibicionBean bean= (JugProhibicionBean) request.getSession().getAttribute("beanSession");
		if(bean==null){
			init(request);
			bean= (JugProhibicionBean) request.getSession().getAttribute("beanSession");
		}
		if(bean.isNac()){
			List<ComunidadBean> list= comunidadService.getComunidadList()	;
			map.put("listComunidad", list);	
		}
		
		
	}
	
	@RequestMapping(value = "/historico/export")
	public String exportHistorico(HttpServletRequest request, HttpServletResponse response){
		 JugHistoricoQueryBean query=  (JugHistoricoQueryBean) request.getSession().getAttribute(es.dgoj.rgiaj.util.Constantes.historicodQueryBean);
		 
		   String username = (String) SecurityAccess.getUserInformation().getUsername();
		   String reportName = "historicosList";
		   String reportTitle = this.messageSource.getMessage("page.breadcrumb.historico", null, WebCoreUtils.getLocale());
		   String reportType = RequestUtil.getStringParameter(request, "exportType", null);
		   String fullReportName = null;
		   String contentType = null;
		   
		   try {
				if ( reportType != null ) {
					if (!reportType.equalsIgnoreCase("Exportar")) {
						if (reportType.equalsIgnoreCase("XLS")) {
							fullReportName = "historicoReport.xls";
						    contentType = "application/xls";
						} else if (reportType.equalsIgnoreCase("PDF")){
							fullReportName = "historicoReport.pdf";
						    contentType = "application/pdf";
						} else if (reportType.equalsIgnoreCase("DOCX")){
						    fullReportName = "historicoReport.doc";
						    contentType = "application/doc";
						} else {
						    throw new CoreException("error.export");
						}
		
						byte[] byteArray = this.jugHistoricoDescargaServ.exportHistorico(username, query, reportType, reportName, reportTitle);
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
