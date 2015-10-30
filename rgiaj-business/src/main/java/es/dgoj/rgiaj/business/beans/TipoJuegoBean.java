package es.dgoj.rgiaj.business.beans;

import java.io.Serializable;


import es.dgoj.rgiaj.business.model.TipoJuego;
import es.dgoj.rgiaj.business.util.ConstantesBusiness;


/**
 * Clase de negocio para la pantalla de Tipo de Juego.
 * @author connectis
 */
public final class TipoJuegoBean implements Serializable {
	
	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Campo id. */
	private Long id;

    /** Campo codigo. */
	private String codigo;
	
	/** Campo descripcion. */
	private String descripcion;
	
	/** Campo activo. */
	private Boolean activo;

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
	 * @return activo
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
	 * Instancia un objeto de la clase TipoJuegoBean.
	 *
	 * @param prohibicion
	 */
	public TipoJuegoBean(TipoJuego prohibicion) {
		this.id = prohibicion.getId();
		this.codigo = prohibicion.getCodigo();
		this.descripcion = prohibicion.getDescripcion();
		if (prohibicion.getActivo()==1){
			this.activo=true;
		} else {
			this.activo=false;
		}
	}

	/**
	 * Instancia un objeto de la clase TipoJuegoBean.
	 */
	public TipoJuegoBean() {
	}

	/**
	 * Obtener la Entity a partir del bean.
	 * @return TipoProhibicion
	 */
	public TipoJuego getEntity() {
		TipoJuego tipojuego = new TipoJuego();

		if (this.getId()!=null){
			tipojuego.setId(this.getId());	
		}
		tipojuego.setCodigo(this.getCodigo());
		tipojuego.setDescripcion(this.getDescripcion());
		if (this.getActivo()){
			tipojuego.setActivo(ConstantesBusiness.BOOLEANTRUE);
		} else {
			tipojuego.setActivo(ConstantesBusiness.BOOLEANFALSE);
		}

		return tipojuego;
	}
	
}