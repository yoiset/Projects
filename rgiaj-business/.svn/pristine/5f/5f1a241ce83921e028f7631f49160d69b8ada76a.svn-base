package es.dgoj.rgiaj.business.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the JUG_PROVINCIA database table.
 * 
 */
@Entity
@Table(name="JUG_PROVINCIA")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private Integer activo;

	private String codigo;

	private String descripcion;

	private String matricula;

	//bi-directional many-to-one association to JugComunidad
	@ManyToOne
	@JoinColumn(name="ID_COMUNIDAD")
	private ComunidadAutonoma comunidadAutonoma;

	public Provincia() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getActivo() {
		return this.activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public ComunidadAutonoma getComunidadAutonoma() {
		return this.comunidadAutonoma;
	}

	public void setComunidadAutonoma(ComunidadAutonoma comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}

	
}