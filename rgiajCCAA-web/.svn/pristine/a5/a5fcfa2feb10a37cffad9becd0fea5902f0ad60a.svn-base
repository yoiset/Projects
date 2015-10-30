package es.dgoj.rgiaj.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Clase que gestiona la seguridad en la aplicacion.
 * @author dbeltran
 * @version 1.0
 */
@Controller
@RequestMapping(value="/security/*")
public class SecurityController {
	
	/**
	 * Log de la clase.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityController.class);

	/** 
	 * Peticion de entrada a la aplicacion.
	 * @param map Contenedor de informacion para la vista
	 * @param request Peticion
	 * @return success Redirecciona al home de la aplicacion
	 * 			denied Redirecciona al sso de la DGOJ
	 */
	@RequestMapping(value="/security/start")
	public String start(Map<String, Object> map, HttpServletRequest request) {
		LOGGER.info("Entrada en la aplicacion");
		return "redirect:/app/inicio/inicio";
	}

}
