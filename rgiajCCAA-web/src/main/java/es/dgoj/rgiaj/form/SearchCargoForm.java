package es.dgoj.rgiaj.form;

import org.springframework.beans.factory.annotation.Configurable;

/**
 * Formulario de busqueda de cargos.
 *
 * @author connectis
 */
@Configurable
public class SearchCargoForm {

	/** Campo id. */
	private String id;
	
	/** Campo codigo. */
	private String codigo;
	
	/** Campo descripcion. */
	private String descripcion;
	
	/** Campo activo. */
	private Boolean activo;
	
	/** Campo defecto. */
	private Boolean defecto;
	
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
	 * @param id the id
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
	 * @param codigo
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
	 * Devuelve el valor del campo defecto.
	 *
	 * @return Defecto
	 */
	public Boolean getDefecto() {
		return defecto;
	}

	/**
	 * Establece el valor del campo defecto.
	 *
	 * @param defecto 
	 */
	public void setDefecto(Boolean defecto) {
		this.defecto = defecto;
	}
	
}
