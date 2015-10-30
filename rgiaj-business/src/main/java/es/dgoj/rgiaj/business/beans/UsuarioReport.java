package es.dgoj.rgiaj.business.beans;

import java.io.Serializable;

public class UsuarioReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String usuario;
	private String descripcion;
	private boolean indActivo;
	
	
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
	public boolean isIndActivo() {
		return indActivo;
	}
	public void setIndActivo(boolean indActivo) {
		this.indActivo = indActivo;
	}
	

}
