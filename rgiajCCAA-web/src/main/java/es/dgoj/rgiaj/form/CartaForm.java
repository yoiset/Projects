package es.dgoj.rgiaj.form;

import org.springframework.beans.factory.annotation.Configurable;

/**
 * Formulario de carta.
 * @author connectis
 */
@Configurable
public class CartaForm {

	/** Campo id. */
	private String id;

	/** Campo descripcion. */
	private String descripcion;
	
	/** Campo texto. */
	private String texto;

	/** Campo pie. */
	private String pie;
	
	/** Campo cargo (refencia al id de su tabla). */
	private String cargo;
	
	/** Campo responsable (refencia al id de su tabla). */
	private String responsable;
	
	/** Campo error. */
	private String error;
	
	/**
	 * Devuelve el valor del campo id.
	 *
	 * @return Id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el valor del campo id.
	 *
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	
	/**
	 * Devuelve el valor del campo descripcion.
	 * 
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 *  Establece el valor del campo descripcion.
	 *  
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve el valor del campo texto.
	 * 
	 * @return texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * Establece el valor del campo texto.
	 *  
	 * @param texto 
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * Devuelve el valor del campo pie.
	 * 
	 * @return pie
	 */
	public String getPie() {
		return pie;
	}

	/**
	 * Establece el valor del campo pie.
	 * 
	 * @param pie
	 */
	public void setPie(String pie) {
		this.pie = pie;
	}

	/**
	 * Devuelve el valor del campo cargo.
	 * 
	 * @return cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * Establece el valor del campo cargo.
	 * 
	 * @param cargo
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * Devuelve el valor del campo responsable.
	 * 
	 * @return responsable
	 */
	public String getResponsable() {
		return responsable;
	}

	/**
	 * Establece el valor del campo responable.
	 * 
	 * @param responsable
	 */
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
	/**
	 * Devuelve el valor del campo error.
	 *
	 * @return Error
	 */
	public String getError() {
		return error;
	}

	/**
	 * Establece el valor del campo error.
	 *
	 * @param error
	 */
	public void setError(String error) {
		this.error = error;
	}


	
}
