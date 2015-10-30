package es.dgoj.rgiaj.business.beans;

import java.io.Serializable;


import es.dgoj.rgiaj.business.model.Situacion;
import es.dgoj.rgiaj.business.util.ConstantesBusiness;


/**
 * Clase de negocio para la pantalla de Tipo de Juego.
 * @author connectis
 */
public final class SituacionBean implements Serializable {
	
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
	 *  Devuelve el valor del campo tipoSituacion. 
	 *  
	 * @return tipoSituacion
	 */
	public String getTipoSituacion() {
		return tipoSituacion;
	}

	/**
	 * Establece el valor del campo tipoSituacion.
	 * 
	 * @param tipoSituacion
	 */
	public void setTipoSituacion(String tipoSituacion) {
		this.tipoSituacion = tipoSituacion;
	}

	/**
	 *  Devuelve el valor del campo situacionMaq. 
	 *  
	 * @return situacionMaq
	 */
	public String getSituacionMaq() {
		return situacionMaq;
	}

	/**
	 * Establece el valor del campo situacionMaq.
	 * 
	 * @param situacionMaq
	 */
	public void setSituacionMaq(String situacionMaq) {
		this.situacionMaq = situacionMaq;
	}

	/**
	 * Devuelve el valor del campo situacionEmp. 
	 *  
	 * @return situacionEmp
	 */
	public String getSituacionEmp() {
		return situacionEmp;
	}

	/**
	 * Establece el valor del campo situacionEmp.
	 * 
	 * @param situacionEmp
	 */
	public void setSituacionEmp(String situacionEmp) {
		this.situacionEmp = situacionEmp;
	}

	/**
	 * Devuelve el valor del campo situacionLocal. 
	 *  
	 * @return situacionLocal
	 */
	public String getSituacionLocal() {
		return situacionLocal;
	}

	/**
	 * Establece el valor del campo situacionLocal.
	 * 
	 * @param situacionLocal
	 */
	public void setSituacionLocal(String situacionLocal) {
		this.situacionLocal = situacionLocal;
	}

	/**
	 * Devuelve el valor del campo situacionPersona. 
	 *  
	 * @return situacionPersona
	 */
	public String getSituacionPersona() {
		return situacionPersona;
	}

	/**
	 * Establece el valor del campo situacionPersona
	 * 
	 * @param situacionPersona
	 */
	public void setSituacionPersona(String situacionPersona) {
		this.situacionPersona = situacionPersona;
	}

	/**
	 * Devuelve el valor del campo  situacionModelo.
	 *  
	 * @return situacionModelo
	 */
	public String getSituacionModelo() {
		return situacionModelo;
	}

	/**
	 * Establece el valor del campo situacionModelo.
	 * 
	 * @param situacionModelo
	 */
	public void setSituacionModelo(String situacionModelo) {
		this.situacionModelo = situacionModelo;
	}

	/**
	 * Instancia un objeto de la clase SituacionBean.
	 *
	 * @param situacion
	 */
	public SituacionBean(Situacion situacion) {
		this.id = situacion.getId();
		this.codigo = situacion.getCodigo();
		this.descripcion = situacion.getDescripcion();
		if (situacion.getActivo()==1){
			this.activo=true;
		} else {
			this.activo=false;
		}
		this.setTipoSituacion(situacion.getTipoSituacion());
		this.setSituacionMaq(situacion.getSituacionMaq());
		this.setSituacionEmp(situacion.getSituacionEmp());
		this.setSituacionLocal(situacion.getSituacionLocal());
		this.setSituacionPersona(situacion.getSituacionPersona());
		this.setSituacionModelo(situacion.getSituacionModelo());
	}

	/**
	 * Instancia un objeto de la clase SituacionBean.
	 */
	public SituacionBean() {
	}

	/**
	 * Obtener la Entity a partir del bean.
	 * @return Situacion
	 */
	public Situacion getEntity() {
		Situacion situacion = new Situacion();

		if (this.getId()!=null){
			situacion.setId(this.getId());	
		}
		situacion.setCodigo(this.getCodigo());
		situacion.setDescripcion(this.getDescripcion());
		if (this.getActivo()){
			situacion.setActivo(ConstantesBusiness.BOOLEANTRUE);
		} else {
			situacion.setActivo(ConstantesBusiness.BOOLEANFALSE);
		}
		situacion.setTipoSituacion(this.getTipoSituacion());
		situacion.setSituacionMaq(this.getSituacionMaq());
		situacion.setSituacionEmp(this.getSituacionEmp());
		situacion.setSituacionLocal(this.getSituacionLocal());
		situacion.setSituacionPersona(this.getSituacionPersona());
		situacion.setSituacionModelo(this.getSituacionModelo());

		return situacion;
	}
	
}