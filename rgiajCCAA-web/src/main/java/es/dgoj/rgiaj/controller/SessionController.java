package es.dgoj.rgiaj.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.dgoj.core.common.bean.UserBean;
import com.dgoj.core.security.sso.access.SecurityAccess;

import es.dgoj.rgiaj.business.beans.JugProhibicionBean;
import es.dgoj.rgiaj.business.service.IJugProhibicionServ;

public abstract class SessionController {
	
	private static final Logger log = LoggerFactory.getLogger(SessionController.class);
	
	
	/** Recupera el usuario Authenticado y la comunidad asignada. Ademas adiciona en session la comunidad
	 * @param request
	 */
	protected void init(HttpServletRequest request){ 
		SecurityContext securityContext=SecurityContextHolder.getContext();
		setLoggerPermisos(SecurityAccess.getAllAuthorities());
		UserBean user =null;
		if(securityContext.getAuthentication()!=null && securityContext.getAuthentication().isAuthenticated()){
			user = (UserBean) securityContext.getAuthentication().getPrincipal();
			JugProhibicionBean bean= getJugProhibicionService().getComunidad(user.getUsername());
			request.getSession().setAttribute("beanSession",  bean);
		}
		
	}
	
	
	private void setLoggerPermisos( String[] roles){
		if(roles!=null){
			log.info("Permisos Asignados:----> ");
			for (String string : roles) {
				log.info(string);
			}
		}
	}
	
	
	/**
	 * @return
	 */
	public abstract IJugProhibicionServ getJugProhibicionService();

}
