package es.dgoj.rgiaj.business.beans;

import java.io.Serializable;

import es.dgoj.rgiaj.business.model.Provincia;



/**
 * The bean class for the JUG_PROVINCIA database table.
 * 
 */
public class ProvinciaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Integer activo;

	private String codigo;

	private String descripcion;

	private String matricula;

	private ComunidadAutonomaBean comunidad;

	public ProvinciaBean() {
	}

	/**
	 * @param provincia
	 */
	public ProvinciaBean(Provincia provincia) {
		this.setCodigo(provincia.getCodigo());
		this.setId(provincia.getId());
		this.setComunidad(new ComunidadAutonomaBean(provincia.getComunidadAutonoma()));
		this.setDescripcion(provincia.getDescripcion());
		this.setMatricula(provincia.getMatricula());
		this.setActivo(provincia.getActivo());
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the activo
	 */
	public Integer getActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the comunidad
	 */
	public ComunidadAutonomaBean getComunidad() {
		return comunidad;
	}

	/**
	 * @param comunidad the comunidad to set
	 */
	public void setComunidad(ComunidadAutonomaBean comunidad) {
		this.comunidad = comunidad;
	}	
	
}