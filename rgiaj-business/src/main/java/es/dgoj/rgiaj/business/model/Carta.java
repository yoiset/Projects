package es.dgoj.rgiaj.business.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Estos objetos se utilizan en la configuración de la aplicación para definir las cartas disponibles. 
 */
@Entity
@Table(name ="JUG_CARTAS_AUX")
public class Carta implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

    /** Campo id. */
    @Id
	@Column(name = "ID" )
	private Long id;
	
	/** Campo descripcion. */
	@Column(name = "DESCRIPCION" )
	private String descripcion;
	
	/** Campo texto. */
	@Column(name = "TEXTO" )
	private String texto;

	/** Campo pie. */
	@Column(name = "PIE" )
	private String pie;
	
	@Column(name = "CARGO" )
	private Long cargo;
	
	@Column(name = "RESPONSABLE" )
	private Long responsable;
	
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece el valor del campo 
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * @return the pie
	 */
	public String getPie() {
		return pie;
	}

	/**
	 * @param pie the pie to set
	 */
	public void setPie(String pie) {
		this.pie = pie;
	}

	/**
	 * @return the cargo
	 */
	public Long getCargo() {
		return cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(Long cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the responsable
	 */
	public Long getResponsable() {
		return responsable;
	}

	/**
	 * @param responsable the responsable to set
	 */
	public void setResponsable(Long responsable) {
		this.responsable = responsable;
	}

	
	
}
