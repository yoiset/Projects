package es.dgoj.rgiaj.business.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Estos objetos se utilizan en la configuración de la aplicación para definir las situaciones. 
 * Nótese que realmente la clasificación de las situaciones no cambia frecuentemente.
 */
@Entity
@Table(name ="JUG_SITUACION")
public class Situacion implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

    /** Campo id. */
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "HIBERNATE_SEQUENCE")
	@SequenceGenerator(name = "HIBERNATE_SEQUENCE", sequenceName = "HIBERNATE_SEQUENCE")
	@Column(name = "ID" )
	private Long id;

    /** Campo codigo. */
    @Column(name = "CODIGO" )
	private String codigo;
	
	/** Campo descripcion. */
	@Column(name = "DESCRIPCION" )
	private String descripcion;
	
	/** Campo activo. */
	@Column(name = "ACTIVO" )
	private Integer activo;

	/** Campo tipoSituacion. */
	@Column(name = "TIPO_SITUACION" )
	private String tipoSituacion;
	
	/** Campo situacionMaq. */
	@Column(name = "SITUACION_MAQ" )
	private String situacionMaq;
	
	/** Campo situacionEmp. */
	@Column(name = "SITUACION_EMP" )
	private String situacionEmp;
	
	/** Campo situacionLocal. */
	@Column(name = "SITUACION_LOCAL" )
	private String situacionLocal;
	
	/** Campo situacionPersona. */
	@Column(name = "SITUACION_PERSONA" )
	private String situacionPersona;
	
	/** Campo situacionModelo. */
	@Column(name = "SITUACION_MODELO" )
	private String situacionModelo;
	
	
	/**
	 * Devuelve el valor del campo id.
	 *
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Establece el valor del campo id.
	 *
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Devuelve el valor del campo codigo.
	 *
	 * @return codigo
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
	 * @return the descripcion
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
	 * @return activo
	 */
	public Integer getActivo() {
		return activo;
	}

	/**
	 * Establece el valor del campo activo.
	 *
	 * @param activo
	 */
	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	/**
	 * @return tipoSituacion
	 */
	public String getTipoSituacion() {
		return tipoSituacion;
	}

	/**
	 * @param tipoSituacion
	 */
	public void setTipoSituacion(String tipoSituacion) {
		this.tipoSituacion = tipoSituacion;
	}

	/**
	 * @return situacionMaq
	 */
	public String getSituacionMaq() {
		return situacionMaq;
	}

	/**
	 * @param situacionMaq 
	 */
	public void setSituacionMaq(String situacionMaq) {
		this.situacionMaq = situacionMaq;
	}

	/**
	 * @return situacionEmp
	 */
	public String getSituacionEmp() {
		return situacionEmp;
	}

	/**
	 * @param situacionEmp
	 */
	public void setSituacionEmp(String situacionEmp) {
		this.situacionEmp = situacionEmp;
	}

	/**
	 * @return situacionLocal
	 */
	public String getSituacionLocal() {
		return situacionLocal;
	}

	/**
	 * @param situacionLocal 
	 */
	public void setSituacionLocal(String situacionLocal) {
		this.situacionLocal = situacionLocal;
	}

	/**
	 * @return  situacionPersona
	 */
	public String getSituacionPersona() {
		return situacionPersona;
	}

	/**
	 * @param situacionPersona
	 */
	public void setSituacionPersona(String situacionPersona) {
		this.situacionPersona = situacionPersona;
	}

	/**
	 * @return  situacionModelo
	 */
	public String getSituacionModelo() {
		return situacionModelo;
	}

	/**
	 * @param situacionModelo 
	 */
	public void setSituacionModelo(String situacionModelo) {
		this.situacionModelo = situacionModelo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Situacion [id=");
		builder.append(id);
		builder.append(", codigo=");
		builder.append(codigo);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", activo=");
		builder.append(activo);
		builder.append("]");
		return builder.toString();
	}
	
}
