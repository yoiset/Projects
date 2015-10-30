package es.dgoj.rgiaj.business.beans;

import java.io.Serializable;

import es.dgoj.rgiaj.business.model.Carta;


/**
 * Clase de negocio para la pantalla de Cartas.
 * @author connectis
 */
public final class CartaBean implements Serializable {
	
	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Campo id. */
	private Long id;

	/** Campo descripcion. */
	private String descripcion;
	
	/** Campo texto. */
	private String texto;

	/** Campo pie. */
	private String pie;
	
	/** Campo cargo (refencia al id de su tabla. */
	private Long cargo;
	
	/** Campo responsable (refencia al id de su tabla. */
	private Long responsable;

	
	/**
	 * Devuelve el valor del campo id.
	 *
	 * @return Id
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
	public Long getCargo() {
		return cargo;
	}

	/**
	 * Establece el valor del campo cargo.
	 * 
	 * @param cargo
	 */
	public void setCargo(Long cargo) {
		this.cargo = cargo;
	}

	/**
	 * Devuelve el valor del campo responsable.
	 * 
	 * @return responsable
	 */
	public Long getResponsable() {
		return responsable;
	}

	/**
	 * Establece el valor del campo responable.
	 * 
	 * @param responsable
	 */
	public void setResponsable(Long responsable) {
		this.responsable = responsable;
	}

	/**
	 * Instancia un objeto de la clase CargoBean.
	 *
	 * @param prohibicion
	 */
	public CartaBean(Carta carta) {
		this.id = carta.getId();
		this.texto = carta.getTexto();
		this.descripcion = carta.getDescripcion();
		this.pie = carta.getPie();
		this.cargo = carta.getCargo();
		this.responsable = carta.getResponsable();
	}

	/**
	 * Instancia un objeto de la clase CargoBean.
	 */
	public CartaBean() {
	}

	/**
	 * Obtener la Entity a partir del bean.
	 * @return Carta
	 */
	public Carta getEntity() {
		Carta carta = new Carta();

		if (this.getId()!=null){
			carta.setId(this.getId());	
		}
		carta.setTexto(this.getTexto());
		carta.setDescripcion(this.getDescripcion());
		carta.setPie(this.getPie());
		carta.setCargo(this.getCargo());
		carta.setResponsable(this.getResponsable());
		
		return carta;
	}
	
}