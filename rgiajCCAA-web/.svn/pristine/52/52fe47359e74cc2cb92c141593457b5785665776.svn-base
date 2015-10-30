/**
 * Paqueteria que contiene los controladores sincronos de monitorizacion
 * @author dbeltran
 */
package es.dgoj.rgiaj.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeveris.core.monitoring.jmx.aspect.IMonitoringAspectStatus;
import com.jeveris.core.monitoring.jmx.aspect.StringAspectResult;
import com.jeveris.monitoring.nagios.jmx.resource.BackendStatusResource;

import es.dgoj.rgiaj.bean.MonitorBean;

/**
 * Clase que muestra el estado de los backend de la aplicacion desde la vista monitor.jsp.
 * @author dbeltran
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/monitor/*")
public class MonitorController {
	
	/**
	 *  Log de la clase.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(MonitorController.class);
	
	/**
	 * Servicio para recuperar el estado de los recursos.
	 */
	@Autowired
	private BackendStatusResource backendStatusResource;

	/**
	 * Nombre de la aplicacion.
	 */
	@Resource(name="application.name")
	private String applicationName;
	
	/**
	 * Tiempo optimo de respuesta de la aplicacion.
	 */
	@Resource(name="application.responseTime")
	private String responseTime;
	
	/**
	 * Version de la aplicacion.
	 */
	@Resource(name="application.version")
	private String applicationVersion;
	
	/** The Constant STATUS_OK. */
	protected static final String STATUS_OK		= "RUNNING";
	
	/** The Constant STATUS_ERROR. */
	protected static final String STATUS_ERROR	= "ERROR";
	
	/** The Constant STATUS_WARNING. */
	protected static final String STATUS_WARNING= "WARNING";
	
	/** The Constant RESULT_PERFDATA_SEP. */
	protected static final String RESULT_PERFDATA_SEP = "=";
	
	/** The Constant RESULT_PERFDATA_SEP_REGEXPR. */
	protected static final String RESULT_PERFDATA_SEP_REGEXPR = ";";
	
	/**
	 * Peticiones para cargar la vista del monitor.
	 * @param map Contenedor de informacion para la vista
	 * @param request Peticion
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/monitor/start")
	public String monitorStart(Map<String, Object> map, HttpServletRequest request) {
		
		List<MonitorBean> listMonitor = new ArrayList<MonitorBean>();
		StringAspectResult aspectResult = null;
		
		List<IMonitoringAspectStatus> aspects = backendStatusResource.getAspects();
		
		if (aspects != null) {			
			for( IMonitoringAspectStatus aspect : aspects) {
				try {
					aspectResult = aspect.executeAspectStatus();
					
					MonitorBean monitor = new MonitorBean();
					if ( aspectResult != null ) {
						String time = aspectResult.getAspectResult().substring(aspectResult.getAspectResult().indexOf(RESULT_PERFDATA_SEP)+1, aspectResult.getAspectResult().indexOf(RESULT_PERFDATA_SEP_REGEXPR));
					
						// check ok
						if (aspectResult.getAspectResult().startsWith(STATUS_OK)) {
							monitor.setStatus(STATUS_OK);
							
							Long lgTime =  Long.valueOf(time.substring(0, time.length()-2));
							
							if (lgTime > Long.valueOf(responseTime)) {
								monitor.setStatus(STATUS_WARNING);
							}
							
						} // check warning
						else if (aspectResult.getAspectResult().startsWith(STATUS_WARNING)) {
							monitor.setStatus(STATUS_WARNING);
						}// check ko
						else {
							monitor.setStatus(STATUS_ERROR);
						}
					
						monitor.setName(aspectResult.getAspectName());
						monitor.setTime(time);
						listMonitor.add(monitor);
					}
					
				} catch (Exception e) {
					LOGGER.error("[SumAndAspect.executeAspectStatus] Error checking attribute " + aspect.getAspectName(), e);
				}
			}
		}
		
		map.put("applicationName", applicationName);
		map.put("applicationVersion", applicationVersion);
		map.put("responseTime", responseTime);
		
		// Informacion para el renderizado de la pagina
		map.put("listMonitor", listMonitor);

		return "tiles/monitor";
	}
	
	/**
	 * Peticiones para validar que la aplicacion esta levantada.
	 * @param map Contenedor de informacion para la vista
	 * @param request Peticion
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/monitor/status")
	public String monitorStatus(Map<String, Object> map, HttpServletRequest request) {
		return "tiles/blank";
	}
	
	@PostConstruct
	public void init() {
		// Inicializando
	}
}
