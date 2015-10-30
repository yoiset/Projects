package es.dgoj.rgiaj.form;

import org.springframework.beans.factory.annotation.Configurable;

import es.dgoj.rgiaj.business.beans.ComunidadAutonomaBean;

/**
 * Formulario de comunidad autonoma.
 * @author connectis
 */
@Configurable
public class ComunidadAutonomaForm {

	/** Campo id. */
	private String id;

	/** Campo codigo. */
	private String codigo;

	/** Campo descripcion. */
	private String descripcion;

	/** Campo activo. */
	private Boolean activo;

	/** Campo error. */
	private String error;
	
	/**
	 * @param comunidad
	 */
	public ComunidadAutonomaForm(ComunidadAutonomaBean comunidad) {
		this.setId(comunidad.getId().toString());
		this.setCodigo(comunidad.getCodigo());
		this.setDescripcion(comunidad.getDescripcion());
		this.setActivo(comunidad.getActivo());
	}
	
	

	public ComunidadAutonomaForm() {
	}



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
	 * Devuelve el valor del campo codigo.
	 *
	 * @return Codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Establece el valor del campo codigo.
	 *
	 * @param codigo the codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Devuelve el valor del campo descripcion.
	 *
	 * @return Descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece el valor del campo descripcion.
	 *
	 * @param descripcion 
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve el valor del campo activo.
	 *
	 * @return Activo
	 */
	public Boolean getActivo() {
		return activo;
	}

	/**
	 * Establece el valor del campo activo.
	 *
	 * @param activo 
	 */
	public void setActivo(Boolean activo) {
		this.activo = activo;
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
