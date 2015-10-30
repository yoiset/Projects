package es.dgoj.rgiaj.business.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the JUG_COMUNIDAD_CERTIFICADO database table.
 * 
 */
@Entity
@Table(name="JUG_COMUNIDAD_CERTIFICADO")
public class JugComunidadCertificado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JugComunidadCertificadoPK id;

	@Lob
	@Column(name="CERTIFICADO")
	private String certificado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_CARGA")
	private Date fechaCarga;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_HASTA")
	private Date fechaHasta;

	@Column(name="FINGER_SHA1")
	private String fingerSha1;

	@Column(name="HASH_CERTIFICADO")
	private String hashCertificado;

	@Column(name="IND_ACTIVO")
	private int indActivo;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_COMUNIDAD", nullable=false, insertable=false,updatable=false)
	private JugComunidad jugComunidad;
	

	public JugComunidadCertificado() {
	}
	
	

	public JugComunidadCertificado(JugComunidadCertificadoPK id) {
		super();
		this.id = id;
	}



	public JugComunidadCertificadoPK getId() {
		return this.id;
	}

	public void setId(JugComunidadCertificadoPK id) {
		this.id = id;
	}

	public String getCertificado() {
		return this.certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	public Date getFechaCarga() {
		return this.fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public Date getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public String getFingerSha1() {
		return this.fingerSha1;
	}

	public void setFingerSha1(String fingerSha1) {
		this.fingerSha1 = fingerSha1;
	}

	public String getHashCertificado() {
		return this.hashCertificado;
	}

	public void setHashCertificado(String hashCertificado) {
		this.hashCertificado = hashCertificado;
	}

	public int getIndActivo() {
		return this.indActivo;
	}

	public void setIndActivo(int indActivo) {
		this.indActivo = indActivo;
	}

	public JugComunidad getJugComunidad() {
		return jugComunidad;
	}

	public void setJugComunidad(JugComunidad jugComunidad) {
		this.jugComunidad = jugComunidad;
	}

}