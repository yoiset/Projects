package es.dgoj.rgiaj.business.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The primary key class for the JUG_COMUNIDAD_CERTIFICADO database table.
 * 
 */
@Embeddable
public class JugComunidadCertificadoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_COMUNIDAD",insertable=false, updatable=false)
	private long idComunidad;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_DESDE")
	private java.util.Date fechaDesde;

	public JugComunidadCertificadoPK() {
	}
	
		
	public JugComunidadCertificadoPK(long idComunidad, Date fechaDesde) {
		super();
		this.idComunidad = idComunidad;
		this.fechaDesde = fechaDesde;
	}

	public long getIdComunidad() {
		return this.idComunidad;
	}
	public void setIdComunidad(long idComunidad) {
		this.idComunidad = idComunidad;
	}
	public java.util.Date getFechaDesde() {
		return this.fechaDesde;
	}
	public void setFechaDesde(java.util.Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}	

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JugComunidadCertificadoPK)) {
			return false;
		}
		JugComunidadCertificadoPK castOther = (JugComunidadCertificadoPK)other;
		return 
			(this.idComunidad == castOther.idComunidad)
			&& this.fechaDesde.equals(castOther.fechaDesde);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idComunidad ^ (this.idComunidad >>> 32)));
		hash = hash * prime + this.fechaDesde.hashCode();
		
		return hash;
	}
}