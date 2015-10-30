package es.dgoj.rgiaj.business.beans;

import java.io.Serializable;


import es.dgoj.rgiaj.business.model.ComunidadAutonoma;
import es.dgoj.rgiaj.business.util.ConstantesBusiness;


/**
 * Clase de negocio para la pantalla de Comunidades Autonomas.
 * @author connectis
 */
public final class ComunidadAutonomaBean implements Serializable {
	
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
	 * Instancia un objeto de la clase ComunidadAutonomaBean.
	 *
	 * @param prohibicion
	 */
	public ComunidadAutonomaBean(ComunidadAutonoma comunidad) {
		this.id = comunidad.getId();
		this.codigo = comunidad.getCodigo();
		this.descripcion = comunidad.getDescripcion();
		if (comunidad.getActivo()==1){
			this.activo=true;
		} else {
			this.activo=false;
		}
	}

	/**
	 * Instancia un objeto de la clase ComunidadAutonomaBean.
	 */
	public ComunidadAutonomaBean() {
	}

	/**
	 * Obtener la Entity a partir del bean.
	 * @return ComunidadAutonoma
	 */
	public ComunidadAutonoma getEntity() {
		ComunidadAutonoma comunidad = new ComunidadAutonoma();

		if (this.getId()!=null){
			comunidad.setId(this.getId());	
		}
		comunidad.setCodigo(this.getCodigo());
		comunidad.setDescripcion(this.getDescripcion());
		if (this.getActivo()){
			comunidad.setActivo(ConstantesBusiness.BOOLEANTRUE);
		} else {
			comunidad.setActivo(ConstantesBusiness.BOOLEANFALSE);
		}

		return comunidad;
	}
	
}