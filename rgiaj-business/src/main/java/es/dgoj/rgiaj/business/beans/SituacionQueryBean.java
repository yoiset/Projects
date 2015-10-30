package es.dgoj.rgiaj.business.beans;

import com.dgoj.core.common.entity.AbstractQueryEntity;

/**
 * Criterios de busqueda de Situaciones.
 * @author dgonzalez
 */
public class SituacionQueryBean extends AbstractQueryEntity {

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
	
	/** Campo tipoSituacion. */
	private String tipoSituacion;
	
	/** Campo situacionMaq. */
	private String situacionMaq;
	
	/** Campo situacionEmp. */
	private String situacionEmp;
	
	/** Campo situacionLocal. */
	private String situacionLocal;
	
	/** Campo situacionPersona. */
	private String situacionPersona;
	
	/** Campo situacionModelo. */
	private String situacionModelo;

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

	public String getTipoSituacion() {
		return tipoSituacion;
	}

	public void setTipoSituacion(String tipoSituacion) {
		this.tipoSituacion = tipoSituacion;
	}

	public String getSituacionMaq() {
		return situacionMaq;
	}

	public void setSituacionMaq(String situacionMaq) {
		this.situacionMaq = situacionMaq;
	}

	public String getSituacionEmp() {
		return situacionEmp;
	}

	public void setSituacionEmp(String situacionEmp) {
		this.situacionEmp = situacionEmp;
	}

	public String getSituacionLocal() {
		return situacionLocal;
	}

	public void setSituacionLocal(String situacionLocal) {
		this.situacionLocal = situacionLocal;
	}

	public String getSituacionPersona() {
		return situacionPersona;
	}

	public void setSituacionPersona(String situacionPersona) {
		this.situacionPersona = situacionPersona;
	}

	public String getSituacionModelo() {
		return situacionModelo;
	}

	public void setSituacionModelo(String situacionModelo) {
		this.situacionModelo = situacionModelo;
	}

	
	
}
