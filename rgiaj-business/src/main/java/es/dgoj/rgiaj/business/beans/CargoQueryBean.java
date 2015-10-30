package es.dgoj.rgiaj.business.beans;

import com.dgoj.core.common.entity.AbstractQueryEntity;

/**
 * Criterios de busqueda de cargos.
 * @author dgonzalez
 */
public class CargoQueryBean extends AbstractQueryEntity {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/** Campo id. */
	private Long id;

    /** Campo codigo. */
	private String codigo;
	
	/** Campo descripcion. */
	private String descripcion;
	
	/** Campo activo. */
	private Boolean activo;

	/** Campo defecto. */
	private Boolean defecto;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Boolean getDefecto() {
		return defecto;
	}

	public void setDefecto(Boolean defecto) {
		this.defecto = defecto;
	}

	
}
