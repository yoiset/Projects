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
 * Estos objetos se utilizan en la configuraci�n de la aplicaci�n para definir las firmas. 
 * N�tese que realmente la clasificaci�n de las firmas no cambia frecuentemente.
 */
@Entity
@Table(name ="JUG_FIRMA")
public class Firma implements Serializable {

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

	/** Campo activo. */
	@Column(name = "DEFECTO" )
	private Integer defecto;
	
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
	 * Devuelve el valor del campo defecto.
	 * 
	 * @return the defecto
	 */
	public Integer getDefecto() {
		return defecto;
	}

	/**
	 * Establece el valor del campo defecto.
	 * 
	 * @param defecto the defecto to set
	 */
	public void setDefecto(Integer defecto) {
		this.defecto = defecto;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cargo [id=");
		builder.append(id);
		builder.append(", codigo=");
		builder.append(codigo);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", defecto=");
		builder.append(defecto);
		builder.append(", activo=");
		builder.append(activo);
		builder.append("]");
		return builder.toString();
	}
	
}