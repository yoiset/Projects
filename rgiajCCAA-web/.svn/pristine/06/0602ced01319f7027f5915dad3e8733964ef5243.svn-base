/**
 * Paqueteria que contiene todos los controladores sincronos
 * @author dbeltran
 *
 */
package es.dgoj.rgiaj.controller;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dgoj.core.common.util.DateUtil;
import com.dgoj.core.security.sso.access.SecurityAccess;
import com.jeveris.web.core.utils.WebCoreUtils;

/**
 * Clase que gestiona todas las peticiones sincronas realizadas desde la vista admin.jsp.
 * @author dbeltran
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/inicio/*")
public class AdminController {
	
	/**
	 *  Log de la clase.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	
	/**
	 * Servicio de acceso al contenedor de mensajes de spring.
	 */
	@Resource
	private MessageSource messageSource;
	
	/**
	 * Peticiones para administrar las tablas maestras de la aplicacion.
	 * @param map Contenedor de informacion para la vista
	 * @param request Peticion
	 * @return Componente tile al que se redirige
	 */
	@RequestMapping(value = "/inicio/inicio")
	public String irInicio(Map<String, Object> map, HttpServletRequest request) {
		
		Locale locale = WebCoreUtils.getLocale();
		String usuario = SecurityAccess.getUserInformation().getUsername();
		String[] permisos = SecurityAccess.getAllAuthorities();
		
		StringBuffer mensajeBuffer = new StringBuffer();
		mensajeBuffer.append("Permisos del usuario: ");
		if (permisos!=null){
			for (String permiso: permisos){
				mensajeBuffer.append(permiso);
				mensajeBuffer.append(", ");
			}
		}
		String mensaje= mensajeBuffer.toString();
		
		LOGGER.info(usuario+"->"+mensaje);
		
		// Informacion para el renderizado de la pagina
		map.put("firstOptionText",  this.messageSource.getMessage("page.common.option.select", null, locale));
		map.put("userLang", locale.getLanguage());
		map.put("sensitiveRangeMax", DateUtil.format(new Date(), "dd/MM/yyyy"));

		return "tiles/inicio";
	}
}
