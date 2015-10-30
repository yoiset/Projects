package es.dgoj.rgiaj.business.bean;

import java.io.Serializable;

import es.dgoj.rgiaj.ComunidadBeanWS;

/**
 * @author ylopezconnectis
 *
 */
public class ComunidadBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idComunidad;
	
	private String codigo;
	
	private String descripcion;
	

	
	
	public ComunidadBean(Long idComunidad,String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.idComunidad=idComunidad;
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Long getIdComunidad() {
		return idComunidad;
	}


	public void setIdComunidad(Long idComunidad) {
		this.idComunidad = idComunidad;
	}
	
	public ComunidadBeanWS toResponse(){
		ComunidadBeanWS response= new ComunidadBeanWS();
		response.setCodigo(this.getCodigo());
		response.setDescripcion(this.getDescripcion());
		response.setIdComunidad(this.getIdComunidad());
		
		return response;
	}



}
