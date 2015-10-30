package es.dgoj.rgiaj.form;

import org.springframework.beans.factory.annotation.Configurable;

/**
 * Formulario de busqueda de jugadores de prueba.
 *
 * @author connectis
 */
@Configurable
public class SearchSituacionForm {

	/** Campo id. */
	private String id;
	
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
	public String getId() {
		return id;
	}
	
	/**
	 * Establece el valor del campo id.
	 *
	 * @param id the id
	 */
	public void setId(String id) {
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
	 *
	 * @return Activo
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

	
	
}
