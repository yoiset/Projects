package es.dgoj.rgiaj.business.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the JUG_PROHIBICION database table.
 * 
 */
@Entity
@Table(name="JUG_PROHIBICION")
public class Prohibicion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PROHIBICION")
	private Long idProhibicion;

	private String duracion;

	@Column(name="ENVIO_CARTA")
	private Integer envioCarta;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CARENCIA")
	private Date fechaCarencia;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_PROHIBICION")
	private Date fechaProhibicion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_REGISTRO")
	private Date fechaRegistro;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_SENTENCIA")
	private Date fechaSentencia;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_SITUACION")
	private Date fechaSituacion;

	@Column(name="ID_OPERADOR")
	private Long idOperador;

	@Column(name="ID_PROHIBICION_ENVIO")
	private Long idProhibicionEnvio;

	@Column(name="ID_SENTENCIA")
	private String idSentencia;

	@Column(name="LAST_UPDATE")
	private Timestamp lastUpdate;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	private String observaciones;

	@Column(name="ORGANO_JUDICIAL")
	private String organoJudicial;

	@Column(name="PERS_VINCULA")
	private String persVincula;

	//bi-directional many-to-one association to TipoInscripcion
	@ManyToOne
	@JoinColumn(name="TIPO_INSCRIPCION")
	private TipoInscripcion tipoInscripcion;	

	@Column(name="TIPO_VINCULACION")
	private Long tipoVinculacion;

	private String vinculacion;

	//bi-directional many-to-one association to ComunidadAutonoma
	@ManyToOne
	@JoinColumn(name="ID_COMUNIDAD")
	private ComunidadAutonoma comunidad;

	//bi-directional many-to-one association to CausaProhibicion
	@ManyToOne
	@JoinColumn(name="ID_CAUSA")
	private CausaProhibicion causaProhibicion;

	//bi-directional many-to-one association to TipoProhibicion
	@ManyToOne
	@JoinColumn(name="ID_TIPO_PROHIBICION")
	private TipoProhibicion tipoProhibicion;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_PERSONA")
	private Persona persona;

	//bi-directional many-to-one association to Situacion
	@ManyToOne
	@JoinColumn(name="ID_SITUACION")
	private Situacion situacion;

	public Prohibicion() {
	}

	public Long getIdProhibicion() {
		return this.idProhibicion;
	}

	public void setIdProhibicion(Long idProhibicion) {
		this.idProhibicion = idProhibicion;
	}

	public String getDuracion() {
		return this.duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public Integer getEnvioCarta() {
		return this.envioCarta;
	}

	public void setEnvioCarta(Integer envioCarta) {
		this.envioCarta = envioCarta;
	}

	public Date getFechaCarencia() {
		return this.fechaCarencia;
	}

	public void setFechaCarencia(Date fechaCarencia) {
		this.fechaCarencia = fechaCarencia;
	}

	public Date getFechaProhibicion() {
		return this.fechaProhibicion;
	}

	public void setFechaProhibicion(Date fechaProhibicion) {
		this.fechaProhibicion = fechaProhibicion;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaSentencia() {
		return this.fechaSentencia;
	}

	public void setFechaSentencia(Date fechaSentencia) {
		this.fechaSentencia = fechaSentencia;
	}

	public Date getFechaSituacion() {
		return this.fechaSituacion;
	}

	public void setFechaSituacion(Date fechaSituacion) {
		this.fechaSituacion = fechaSituacion;
	}

	public Long getIdOperador() {
		return this.idOperador;
	}

	public void setIdOperador(Long idOperador) {
		this.idOperador = idOperador;
	}

	public Long getIdProhibicionEnvio() {
		return this.idProhibicionEnvio;
	}

	public void setIdProhibicionEnvio(Long idProhibicionEnvio) {
		this.idProhibicionEnvio = idProhibicionEnvio;
	}

	public String getIdSentencia() {
		return this.idSentencia;
	}

	public void setIdSentencia(String idSentencia) {
		this.idSentencia = idSentencia;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getOrganoJudicial() {
		return this.organoJudicial;
	}

	public void setOrganoJudicial(String organoJudicial) {
		this.organoJudicial = organoJudicial;
	}

	public String getPersVincula() {
		return this.persVincula;
	}

	public void setPersVincula(String persVincula) {
		this.persVincula = persVincula;
	}

	public TipoInscripcion getTipoInscripcion() {
		return this.tipoInscripcion;
	}

	public void setTipoInscripcion(TipoInscripcion tipoInscripcion) {
		this.tipoInscripcion = tipoInscripcion;
	}

	public Long getTipoVinculacion() {
		return this.tipoVinculacion;
	}

	public void setTipoVinculacion(Long tipoVinculacion) {
		this.tipoVinculacion = tipoVinculacion;
	}

	public String getVinculacion() {
		return this.vinculacion;
	}

	public void setVinculacion(String vinculacion) {
		this.vinculacion = vinculacion;
	}

	public ComunidadAutonoma getComunidad() {
		return this.comunidad;
	}

	public void setComunidad(ComunidadAutonoma jugComunidad) {
		this.comunidad = jugComunidad;
	}

	
	public CausaProhibicion getCausaProhibicion() {
		return this.causaProhibicion;
	}

	public void setCausaProhibicion(CausaProhibicion jugCausaProhibicion) {
		this.causaProhibicion = jugCausaProhibicion;
	}

	
	public TipoProhibicion getTipoProhibicion() {
		return this.tipoProhibicion;
	}

	public void setTipoProhibicion(TipoProhibicion jugTipoProhibicion) {
		this.tipoProhibicion = jugTipoProhibicion;
	}

	
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona jugPersona) {
		this.persona = jugPersona;
	}

	
	public Situacion getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Situacion jugSituacion) {
		this.situacion = jugSituacion;
	}

	
}