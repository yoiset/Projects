package es.dgoj.rgiaj.business.bean;

import java.io.Serializable;


import es.dgoj.rgiaj.UsuarioComunidadBeanWS;
import es.dgoj.rgiaj.business.model.JugUsuariocomunidad;

public class UsuarioComunidadBean extends ComunidadBean implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  
    private Long id;	
	private String usuario;	
	private String descripcion;	
	private Integer activo;
	

	public UsuarioComunidadBean(Long idComunidad, String codigo, String descripcion) {
		super(idComunidad,codigo, descripcion);
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getActivo() {
		return activo;
	}
	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
	public static UsuarioComunidadBean getBean(JugUsuariocomunidad entity){
		UsuarioComunidadBean result=new UsuarioComunidadBean(entity.getJugComunidad().getId(),entity.getJugComunidad().getCodigo(), entity.getJugComunidad().getDescripcion());
		result.setId(entity.getId());
	    result.setUsuario(entity.getUsuario());
	    result.setDescripcion(entity.getDescripcion());
	    result.setActivo(entity.getActivo());
		
		return result;
	}

	public static UsuarioComunidadBeanWS toResponse(UsuarioComunidadBean bean) {
		UsuarioComunidadBeanWS result=new UsuarioComunidadBeanWS();
	    if(bean!=null){
	    	result.setCodigo(bean.getCodigo());
	    	result.setDescripcion(bean.getDescripcion());
	    	
	    	if(bean.getIdComunidad()!=null)
	    	 result.setIdComunidad(bean.getIdComunidad());
	    	
	    	result.setUsuario(bean.getUsuario());
	    	
	    	if(bean.getActivo()!=null)
	    	 result.setActivo(bean.getActivo());
	    	
	    	if(bean.getId()!=null)
	    	 result.setId(bean.getId());
	    	
	    }
		return result;
	}


}
