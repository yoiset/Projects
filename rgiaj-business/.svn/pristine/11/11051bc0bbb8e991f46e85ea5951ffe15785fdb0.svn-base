package es.dgoj.rgiaj.business.beans;

import java.io.Serializable;


import es.dgoj.rgiaj.business.model.Firma;
import es.dgoj.rgiaj.business.util.ConstantesBusiness;


/**
 * Clase de negocio para la pantalla de Firmas.
 * @author connectis
 */
public final class FirmaBean implements Serializable {
	
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

	/** Campo defecto. */
	private Boolean defecto;

	
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
	 * Devuelve el valor del campo defecto.
	 * @return defecto
	 */
	public Boolean getDefecto() {
		return defecto;
	}

	/**
	 * Establece el valor del campo defecto.
	 *
	 * @param defecto 
	 */
	public void setDefecto(Boolean defecto) {
		this.defecto = defecto;
	}
	
	/**
	 * Instancia un objeto de la clase FirmaBean.
	 *
	 * @param prohibicion
	 */
	public FirmaBean(Firma firma) {
		this.id = firma.getId();
		this.codigo = firma.getCodigo();
		this.descripcion = firma.getDescripcion();
		if (firma.getActivo()==1){
			this.activo=true;
		} else {
			this.activo=false;
		}
		if (firma.getDefecto()==1){
			this.defecto =true;
		} else {
			this.defecto=false;
		}
	}

	/**
	 * Instancia un objeto de la clase FirmaBean.
	 */
	public FirmaBean() {
	}

	/**
	 * Obtener la Entity a partir del bean.
	 * @return Firma
	 */
	public Firma getEntity() {
		Firma firma = new Firma();

		if (this.getId()!=null){
			firma.setId(this.getId());	
		}
		firma.setCodigo(this.getCodigo());
		firma.setDescripcion(this.getDescripcion());
		if (this.getActivo()){
			firma.setActivo(ConstantesBusiness.BOOLEANTRUE);
		} else {
			firma.setActivo(ConstantesBusiness.BOOLEANFALSE);
		}
		if (this.getDefecto()!=null && this.getDefecto()){
			firma.setDefecto(ConstantesBusiness.BOOLEANTRUE);
		} else {
			firma.setDefecto(ConstantesBusiness.BOOLEANFALSE);
		}
		return firma;
	}
	
}