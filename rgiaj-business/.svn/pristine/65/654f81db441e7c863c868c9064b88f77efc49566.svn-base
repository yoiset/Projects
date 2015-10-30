package es.dgoj.rgiaj.business.beans;

import java.io.Serializable;
import java.util.Date;

import es.dgoj.rgiaj.business.model.Operador;


/**
 * Clase con el objeto de negocio de operadores.
 *
 * @author dgonzalez
 */
public final class OperadorBean implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Campo id operador. */
	private Long idOperador;
	
	/** Campo url. */
	private String url;
	
	/** Campo cif. */
	private String cif;
	
	/** Campo razon social. */
	private String razonSocial;
	
	/** Campo fecha inscripcion. */
	private Date fechaInscripcion;
	
	/** Campo mode enabled. */
	private Integer modeEnabled;

	/** Campo nombre corto. */
	private String nombreCorto;
	
	/** Campo flag cairest. */
	private Integer flagCairest;
	
	/** Campo id operador web. */
	private Long idOperadorWeb;
	
	/** Campo certificado. */
	private String certificado;
	
	/** Campo hash certificado. */
	private String hashCertificado;
			
	/**
	 * Devuelve el valor del campo id operador.
	 *
	 * @return IdOperador
	 */
	public Long getIdOperador() {
		return idOperador;
	}

	/**
	 * Establece el valor del campo id operador.
	 *
	 * @param idOperador the id operador
	 */
	public void setIdOperador(Long idOperador) {
		this.idOperador = idOperador;
	}

	/**
	 * Devuelve el valor del campo url.
	 *
	 * @return Url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Establece el valor del campo url.
	 *
	 * @param url the url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Devuelve el valor del campo cif.
	 *
	 * @return Cif
	 */
	public String getCif() {
		return cif;
	}

	/**
	 * Establece el valor del campo cif.
	 *
	 * @param cif the cif
	 */
	public void setCif(String cif) {
		this.cif = cif;
	}

	/**
	 * Devuelve el valor del campo razon social.
	 *
	 * @return RazonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}

	/**
	 * Establece el valor del campo razon social.
	 *
	 * @param razonSocial the razon social
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	/**
	 * Devuelve el valor del campo certificado.
	 *
	 * @return Certificado
	 */
	public String getCertificado() {
		return certificado;
	}

	/**
	 * Establece el valor del campo certificado.
	 *
	 * @param certificado the certificado
	 */
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	/**
	 * Devuelve el valor del campo hash certificado.
	 *
	 * @return HashCertificado
	 */
	public String getHashCertificado() {
		return hashCertificado;
	}

	/**
	 * Establece el valor del campo hash certificado.
	 *
	 * @param hashCertificado the hash certificado
	 */
	public void setHashCertificado(String hashCertificado) {
		this.hashCertificado = hashCertificado;
	}

	/**
	 * Devuelve el valor del campo fecha inscripcion.
	 *
	 * @return FechaInscripcion
	 */
	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	/**
	 * Establece el valor del campo fecha inscripcion.
	 *
	 * @param fechaInscripcion the fecha inscripcion
	 */
	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	/**
	 * Devuelve el valor del campo mode enabled.
	 *
	 * @return ModeEnabled
	 */
	public Integer getModeEnabled() {
		return modeEnabled;
	}

	/**
	 * Establece el valor del campo mode enabled.
	 *
	 * @param modeEnabled the mode enabled
	 */
	public void setModeEnabled(Integer modeEnabled) {
		this.modeEnabled = modeEnabled;
	}
	
	/**
	 * Devuelve el valor del campo nombre corto.
	 *
	 * @return NombreCorto
	 */
	public String getNombreCorto() {
		return nombreCorto;
	}

	/**
	 * Establece el valor del campo nombre corto.
	 *
	 * @param nombreCorto the nombre corto
	 */
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	/**
	 * Devuelve el valor del campo flag cairest.
	 *
	 * @return FlagCairest
	 */
	public Integer getFlagCairest() {
		return flagCairest;
	}

	/**
	 * Establece el valor del campo flag cairest.
	 *
	 * @param flagCairest the flag cairest
	 */
	public void setFlagCairest(Integer flagCairest) {
		this.flagCairest = flagCairest;
	}

	/**
	 * Devuelve el valor del campo id operador web.
	 *
	 * @return IdOperadorWeb
	 */
	public Long getIdOperadorWeb() {
		return idOperadorWeb;
	}

	/**
	 * Establece el valor del campo id operador web.
	 *
	 * @param idOperadorWeb the id operador web
	 */
	public void setIdOperadorWeb(Long idOperadorWeb) {
		this.idOperadorWeb = idOperadorWeb;
	}

	/*
	 * Constructor del bean a partir de su Entity
	 */
	/**
	 * Instancia un objeto de la clase OperadorBean.
	 *
	 * @param operador the operador
	 */
	public OperadorBean(Operador operador) {

		this.setIdOperador(operador.getIdOperador());
		this.setUrl(operador.getUrl());
		this.setCif(operador.getCif());
		this.setRazonSocial(operador.getRazonSocial());
		this.setFechaInscripcion(operador.getFechaInscripcion());
		this.setModeEnabled(operador.getModeEnabled());
		this.setNombreCorto(operador.getNombreCorto());
		this.setFlagCairest(operador.getFlagCairest());
		this.setIdOperadorWeb(operador.getIdOperadorWeb());
		this.setCertificado(operador.getCertificado());
		this.setHashCertificado(operador.getHashCertificado());
	}

	/**
	 * Instancia un objeto de la clase OperadorBean.
	 */
	public OperadorBean() {
	}

	/*
	 * Obtener la Entity a partir del bean
	 */
	/**
	 * Devuelve el valor del campo entity.
	 *
	 * @return Entity
	 */
	public Operador getEntity() {
		Operador operador = new Operador();

		operador.setIdOperador(this.getIdOperador());
		operador.setUrl(this.getUrl());
		operador.setCif(this.getCif());
		operador.setRazonSocial(this.getRazonSocial());
		operador.setFechaInscripcion(this.getFechaInscripcion());
		operador.setModeEnabled(this.getModeEnabled());
		operador.setNombreCorto(this.getNombreCorto());
		operador.setFlagCairest(this.getFlagCairest());
		operador.setIdOperadorWeb(this.getIdOperadorWeb());
		operador.setCertificado(this.getCertificado());
		operador.setHashCertificado(this.getHashCertificado());
		
		return operador;
	}
	
	
}