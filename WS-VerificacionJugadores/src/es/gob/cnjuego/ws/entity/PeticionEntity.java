package es.gob.cnjuego.ws.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import es.gob.cnjuego.ws.Version;

@Entity
@Table(name = "PETICION_WS")
@SequenceGenerator(name = "sq_peticion_ws", sequenceName = "SEQ_PETICION_WS", allocationSize = 1, initialValue = 1)
public class PeticionEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_peticion_ws")
	private int idPeticion;

	@Column(name = "ID_OPERADOR")
	private Long idOperador;

	@Column(name = "COD_PETICION")
	private String codPeticion;

	@Column(name = "PETICION")
	private String peticion;

	@Column(name = "RESPUESTA")
	private String respuesta;

	@Column(name = "FAULT")
	private String fault;

	@Column(name = "FECHA_PETICION")
	private Date fechaPeticion;

	@Column(name = "FECHA_RESPUESTA")
	private Date fechaRespuesta;
	
	@Column(name = "VERSION")
	private String version;
	
	
	public PeticionEntity() {
		super();
		this.version=Version.id();
		// TODO Auto-generated constructor stub
	}

	public int getIdPeticion() {
		return idPeticion;
	}

	public void setIdPeticion(int idPeticion) {
		this.idPeticion = idPeticion;
	}

	public String getCodPeticion() {
		return codPeticion;
	}

	public void setCodPeticion(String codPeticion) {
		this.codPeticion = codPeticion;
	}

	public String getPeticion() {
		return peticion;
	}

	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getFault() {
		return fault;
	}

	public void setFault(String fault) {
		this.fault = fault;
	}

	public Date getFechaPeticion() {
		return fechaPeticion;
	}

	public void setFechaPeticion(Date fechaPeticion) {
		this.fechaPeticion = fechaPeticion;
	}

	public Date getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	public Long getIdOperador() {
		return idOperador;
	}

	public void setIdOperador(Long idOperador) {
		this.idOperador = idOperador;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}