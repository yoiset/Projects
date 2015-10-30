package es.gob.cnjuego.ws.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="JUG_OPERADOR_JUEGO")
@SequenceGenerator(name="sq_operador",sequenceName="SEQ_OPERADORES", allocationSize=1,initialValue=1)
public class OperadorEntity {

	@Id
	@Column(name = "ID_OPERADOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sq_operador")
	private long idOperador;
	
//	@Column(name = "EMAIL" )
//	private String email;
	
	@Column(name = "URL" )
	private String url;
	
	@Column(name = "CIF" )
	private String cif;
	
	@Column(name = "RAZON_SOCIAL" )
	private String razonSocial;
	
	@Column(name = "CERTIFICADO" )
	private String certificado;
	
	@Column(name = "HASH_CERTIFICADO" )
	private String hashCertificado;
	
	@Column(name = "FECHA_INSCRIPCION" )
	private Date fechaInscripcion;
	
	@Column(name = "MODE_ENABLED" )
	private int modeEnabled;
	
	/**
	 * Retorna una instancia que representa al operador cuando �ste
	 * no est� disponible. Esto simplifica el tratamiento de los siguientes casos:
	 * - El mensaje no incluye las cabeceras con el certificado.
	 * - El operador no est� registrado en la BD.
	 */
	public static OperadorEntity NullOperador() {
		OperadorEntity operador = new OperadorEntity();
		operador.setIdOperador(-1);
		return operador;
	}
	
	public boolean isNullOperador() {
		return this.getIdOperador() == -1;
	}
	
    public long getIdOperador() {
		return idOperador;
	}

	public void setIdOperador(long idOperador) {
		this.idOperador = idOperador;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCertificado() {
		return certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	public String getHashCertificado() {
		return hashCertificado;
	}

	public void setHashCertificado(String hashCertificado) {
		this.hashCertificado = hashCertificado;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public int getModeEnabled() {
		return modeEnabled;
	}

	public void setModeEnabled(int modeEnabled) {
		this.modeEnabled = modeEnabled;
	}
	
}