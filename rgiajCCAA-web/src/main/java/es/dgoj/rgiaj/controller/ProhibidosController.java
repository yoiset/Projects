package es.dgoj.rgiaj.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dgoj.core.common.util.DateUtil;
import com.dgoj.core.security.sso.access.SecurityAccess;
import com.dgoj.sprmvc.web.util.RequestUtil;
import com.jeveris.core.exception.impl.CoreException;
import com.jeveris.web.core.utils.WebCoreUtils;

import es.dgoj.rgiaj.business.beans.ComunidadBean;
import es.dgoj.rgiaj.business.beans.JugProhibicionBean;
import es.dgoj.rgiaj.business.beans.JugProhibicionQueryBean;
import es.dgoj.rgiaj.business.beans.type.TipoDescargaProhibidos;
import es.dgoj.rgiaj.business.exceptions.JuegoExternoException;
import es.dgoj.rgiaj.business.service.IComunidadServ;
import es.dgoj.rgiaj.business.service.IJugProhibicionServ;
import es.dgoj.rgiaj.form.JugProhibidosForm;

@Controller
@RequestMapping(value="/prohibidos/*")
public class ProhibidosController extends SessionController   {

private static final Logger log = LoggerFactory.getLogger(ProhibidosController.class);
	
	/**
	 * Servicio de acceso al contenedor de mensajes de spring.
	 */
	@Resource
	private MessageSource messageSource;
	
	@Resource IJugProhibicionServ jugProhibicionService;
	
	@Autowired
	private IComunidadServ comunidadService;
	
	/**
	 * Peticiones para administrar las tablas maestras de la aplicacion.
	 * @param map Contenedor de informacion para la vista
	 * @param request Peticion
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/prohibidos/start")
	public String irInicio(Map<String, Object> map, HttpServletRequest request) {
		
		init(request);	
		
		Locale locale = WebCoreUtils.getLocale();
		// Informacion para el renderizado de la pagina
		map.put("firstOptionText",  this.messageSource.getMessage("page.common.option.select", null, locale));
		map.put("userLang", locale.getLanguage());
		map.put("sensitiveRangeMax", DateUtil.format(new Date(), "dd/MM/yyyy"));

		return "tiles/inicio";
	}
	
	
	/**
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/prohibidos/download")
	public String download(Map<String, Object> map, HttpServletRequest request, JugProhibidosForm jugProhibidosForm) {
				
		map.put("modelAttribute", "jugProhibidosForm");
		
		JugProhibicionQueryBean query= new JugProhibicionQueryBean(getCodeComunidad(request));
		query.setMaxResults(10);
		boolean hasPending= jugProhibicionService.hasPending(query); // se chequea se hay pendiente de confirmar
		map.put("showPending", hasPending);
		jugProhibidosForm.fillUltimasDescargas(getUltimasDescargasConfirmadas(query));
		map.put("listUltimasDescargas",jugProhibidosForm.getListUltimasDescargas());		
				
	    return "tiles/prohibidos";
	}


	
	
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/prohibidos/startDonwload")
	public String startDonwload(HttpServletRequest request, HttpServletResponse response, JugProhibidosForm jugProhibidosForm, Map<String, Object> map ) {
		
		map.put("modelAttribute", "jugProhibidosForm");
		 // agergar aqui la forma de capturar la comunidad asignada						
		try {
			JugProhibicionQueryBean query= new JugProhibicionQueryBean(getCodeComunidad(request),jugProhibidosForm.getFormatoDescarga(),jugProhibidosForm.getTipoDescarga(),
					jugProhibidosForm.getDesde(), jugProhibidosForm.getLast());
			
			byte[] flow=jugProhibicionService.getProhibidosList(query);
			request.getSession().setAttribute("queryBean", query);
			addFile(response, flow);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Error intentando generando el fichero de Prohibidos", e);
			return "app/errorPage";
		}
//	    return "tiles/prohibidos";
		return null;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/prohibidos/updateHistorico")
	public String updateHistorico(HttpServletRequest request, Map<String, Object> map,  JugProhibidosForm jugProhibidosForm){
		
		map.put("modelAttribute", "jugProhibidosForm");
		JugProhibicionQueryBean queryBean= (JugProhibicionQueryBean) request.getSession().getAttribute("queryBean");
		if(TipoDescargaProhibidos.Completa.toString().equals(jugProhibidosForm.getDownloadType()))
			map.put("showCheck", "hidden");
		
		try {
			jugProhibicionService.confirmHistoricoDescargas(queryBean);
		} catch (JuegoExternoException e) {
			// TODO Auto-generated catch block
			log.error("Error intentando actulizar el historico de descargas", e);
			return "app/errorPage";
		}
		
		return "tiles/prohibidos";
	}
	
	
	@RequestMapping(value = "/prohibidos/updatePendiente")
	public String updateHistoricoPendiente(HttpServletRequest request, HttpServletResponse response, JugProhibidosForm jugProhibidosForm, Map<String, Object> map){
		map.put("modelAttribute", "jugProhibidosForm");
		JugProhibicionQueryBean query= new JugProhibicionQueryBean(getCodeComunidad(request));
		try {
			jugProhibicionService.confirmHistoricoDescargasPendiente(query);
		} catch (JuegoExternoException e) {
			// TODO Auto-generated catch block
			log.error("Error intentando actulizar el historico de descargas", e);
			return "app/errorPage";
		}
		
		return "tiles/prohibidos";
	}
	
	

	@RequestMapping(value = "/prohibidos/changeCountHistorico")
	public String changeCountHistorico(HttpServletRequest request, HttpServletResponse response, JugProhibidosForm jugProhibidosForm, Map<String, Object> map){
		map.put("modelAttribute", "jugProhibidosForm");
		
		JugProhibicionQueryBean query= new JugProhibicionQueryBean(getCodeComunidad(request));
		query.setMaxResults(jugProhibidosForm.getCountReg());
		
		jugProhibidosForm.fillUltimasDescargas(getUltimasDescargasConfirmadas(query));
		map.put("listUltimasDescargas",jugProhibidosForm.getListUltimasDescargas());
		
		map.put("stylePuntualSelect","style='display: block'");
		
		return "tiles/prohibidos";
	}
	
	
	
	
	/**
	 * @param response
	 * @param flow
	 * @throws IOException
	 */
	private void addFile(HttpServletResponse response,byte[]flow) throws IOException  
    {  
	   Locale locale = WebCoreUtils.getLocale();
	   response.reset();
       response.setContentType("application/zip");  
       response.setContentLength(flow.length);  
       response.setHeader("Content-Disposition","attachment;filename=\"" + messageSource.getMessage("page.prohibidos.descargas.file.name",null,locale) + "\"");  
       response.addHeader("Pragma", "no cache");
	   response.addHeader("Cache-control", "private, must-revalidate");
       ServletOutputStream op = response.getOutputStream();  
       op.write(flow);  
       op.flush(); 
       op.close();
         
    } 
	
	
	
	/**
	 * @param query
	 * @return
	 */
	private List<JugProhibicionBean> getUltimasDescargasConfirmadas(JugProhibicionQueryBean query) {
		try {
			return jugProhibicionService.getUltimasDescargasConfirmadas(query);
		} catch (JuegoExternoException e) {
			// TODO Auto-generated catch block
			log.error("Error obteniendo ultimas descargas confirmadas", e);
		}
		return null;
	}
	
	
	
	@RequestMapping(value = "/prohibidos/report")
	public String prohibidosReport(HttpServletRequest request, HttpServletResponse response, JugProhibidosForm jugProhibidosForm, Map<String, Object> map){
       
		map.put("modelAttribute", "jugProhibidosForm");
		Locale locale = WebCoreUtils.getLocale();
		// Informacion para el renderizado de la pagina
		map.put("firstOptionText",  this.messageSource.getMessage("page.common.option.select", null, locale));
		map.put("userLang", locale.getLanguage());
		map.put("sensitiveRangeMax", DateUtil.format(new Date(), "dd/MM/yyyy"));
		
		initReport(request, map);
		
		return "tiles/prohibidosReport";
	}
	
	
	@RequestMapping(value = "/prohibidos/export")
	public String exportHistorico(HttpServletRequest request, HttpServletResponse response){
		JugProhibicionQueryBean query= new JugProhibicionQueryBean();
		JugProhibicionBean bean= getSessionBean(request);
		if(bean.isNac())
			query.setCodComunidad(RequestUtil.getStringParameter(request, "codComunidad", null));
		else query.setCodComunidad(bean.getCodComunidad());
		
		
		   String username = (String) SecurityAccess.getUserInformation().getUsername();
		   String reportName = "prohibidosProvincias";
		   String reportTitle = this.messageSource.getMessage("page.breadcrumb.historico", null, WebCoreUtils.getLocale());
		   String reportType = RequestUtil.getStringParameter(request, "exportType", null);
		   String fullReportName = null;
		   String contentType = null;
		   
		   try {
				if ( reportType != null ) {
					if (!reportType.equalsIgnoreCase("Exportar")) {
						if (reportType.equalsIgnoreCase("XLS")) {
							fullReportName = "prohibidosPorProvincia.xls";
						    contentType = "application/xls";
						} else if (reportType.equalsIgnoreCase("PDF")){
							fullReportName = "prohibidosPorProvincia.pdf";
						    contentType = "application/pdf";
						} else if (reportType.equalsIgnoreCase("DOCX")){
						    fullReportName = "prohibidosPorProvincia.doc";
						    contentType = "application/doc";
						} else {
						    throw new CoreException("error.export");
						}
		
						byte[] byteArray = this.jugProhibicionService.exportProhibidosComunidadProvincia(username, query, reportType, reportName, reportTitle);
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
	
	
	
	private void initReport(HttpServletRequest request, Map<String, Object> map) {
		JugProhibicionBean bean= (JugProhibicionBean) request.getSession().getAttribute("beanSession");
		if(bean==null){
			init(request);
			bean= (JugProhibicionBean) request.getSession().getAttribute("beanSession");
		}
		List<ComunidadBean> list= comunidadService.getComunidadListWithOutNAC();
		if(bean.isNac()){
			list.add(0, new ComunidadBean(null, null, "< Todas >"));
			map.put("listComunidad", list);	
		}else{
			List<ComunidadBean> listSimple= new ArrayList<ComunidadBean>();
			for (ComunidadBean comunidadBean : list) {
				if(comunidadBean.getCodigo().equalsIgnoreCase(bean.getCodComunidad()))
					listSimple.add(comunidadBean);
			}
			map.put("listComunidad", listSimple);	
		} 
		
		
		
	}
	
	/**
	 * @param request
	 * @return
	 */
	private String getCodeComunidad(HttpServletRequest request){
		JugProhibicionBean bean= (JugProhibicionBean) request.getSession().getAttribute("beanSession"); 
		if(bean==null){
			init(request);
			bean= (JugProhibicionBean) request.getSession().getAttribute("beanSession"); 
		}
		return bean.getCodComunidad();
	}
	
	
	/**
	 * @param request
	 * @return
	 */
	private JugProhibicionBean getSessionBean(HttpServletRequest request){
		JugProhibicionBean bean= (JugProhibicionBean) request.getSession().getAttribute("beanSession");
		if(bean==null){
			init(request);
			bean= (JugProhibicionBean) request.getSession().getAttribute("beanSession");
		} 
		return bean;
			
		
	}


	public IJugProhibicionServ getJugProhibicionService() {
		return jugProhibicionService;
	}


	public void setJugProhibicionService(IJugProhibicionServ jugProhibicionService) {
		this.jugProhibicionService = jugProhibicionService;
	}
	

	
}
