package es.dgoj.rgiaj.business.model;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;


/**
 * @author ylopezconnectis
 *
 */
@Entity
@Table(name = "JUG_PROHIBICION")
public class JugProhibicion implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_PROHIBICION", nullable = false, unique = true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HIBERNATE_SEQUENCE")
    @SequenceGenerator(name="HIBERNATE_SEQUENCE", sequenceName="HIBERNATE_SEQUENCE", allocationSize=100)
	private Long idProhibicion;
	
	@Column(name = "ID_PROHIBICION_ENVIO", insertable=false, updatable=false)
	@Generated(GenerationTime.ALWAYS)
	private Long idProhibicionEnvio;
	
	@Column(name = "DURACION")
	private String duracion;
	
	@Column(name = "OBSERVACIONES")
	private String observaciones;
	
	@Column(name = "ENVIO_CARTA")
	private Integer envioCarta;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_PROHIBICION")
	private Date fechaProhibicion;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_SITUACION")
	private Date fechaSituacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_CARENCIA")
	private Date fechaCarencia;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_REGISTRO")
	private Date fechaRegistro;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_SITUACION")
	private JugSituacion jugSituacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_COMUNIDAD")
	private JugComunidad jugComunidad;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "ID_CAUSA", nullable = false)
//	private JugCausaProhibicion jugCausaProhibicion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TIPO_PROHIBICION", nullable = false)
	private JugTipoProhibicion jugTipoProhibicion;
	
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "TIPO_INSCRIPCION", nullable = true)
//	private JugTipoInscripcion jugTipoInscripcion;
	
	@Column(name = "ID_SENTENCIA")
	private String idSentencia;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_SENTENCIA")
	private Date fechaSentencia;
	
	@Column(name = "ORGANO_JUDICIAL")
	private String organoJudicial;
	

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "TIPO_VINCULACION", nullable = true)
//	private JugTipoVinculacion jugTipoVinculacion;
	
	@Column(name = "VINCULACION")
	private String vinculacion;
	
	@Column(name = "PERS_VINCULA")
	private String personaVinculacion;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_PERSONA", nullable = false)
	private JugPersona jugPersona;
	
	
	@Transient
	private DecimalFormat decimalFormat;

	
	public JugProhibicion() {
	}

	public JugProhibicion(Long idProhibicion,
			JugTipoProhibicion jugTipoProhibicion) {
		this.idProhibicion = idProhibicion;
//		this.jugCausaProhibicion = jugCausaProhibicion;
		this.jugTipoProhibicion = jugTipoProhibicion;
//		this.jugPersona = jugPersona;
	}

	public JugProhibicion(Long idProhibicion, Long idProhibicionEnvio,
			String duracion, String observaciones, Integer envioCarta,
			Date fechaProhibicion, Date fechaCarencia, Date fechaRegistro,
			Date fechaSituacion, Date lastUpdate,
			String modifiedBy, JugSituacion jugSituacion,
//			JugComunidad jugComunidad, JugCausaProhibicion jugCausaProhibicion,
//			JugTipoProhibicion jugTipoProhibicion, JugPersona jugPersona,
//			JugTipoInscripcion jugTipoInscripcion,
			String idSentencia, Date fechaSentencia,String organoJudicial,
//			JugTipoVinculacion jugTipoVinculacion,
			String vinculacion, String personaVinculacion) {
		this.idProhibicion = idProhibicion;
		this.idProhibicionEnvio = idProhibicionEnvio;
		this.duracion = duracion;
		this.observaciones = observaciones;
		this.envioCarta = envioCarta;
		this.fechaProhibicion = fechaProhibicion;
		this.fechaCarencia = fechaCarencia;
		this.fechaRegistro = fechaRegistro;
		this.fechaSituacion = fechaSituacion;
		this.lastUpdate = lastUpdate;
		this.modifiedBy = modifiedBy;
		this.jugSituacion = jugSituacion;
		this.jugComunidad = jugComunidad;
//		this.jugCausaProhibicion = jugCausaProhibicion;
		this.jugTipoProhibicion = jugTipoProhibicion;
//		this.jugPersona = jugPersona;
//		this.jugTipoInscripcion = jugTipoInscripcion;
		this.idSentencia=idSentencia;
		this.fechaSentencia=fechaSentencia;
		this.organoJudicial=organoJudicial;
//		this.jugOperadorJuego = jugOperadorJuego;
//		this.jugTipoVinculacion = jugTipoVinculacion;
		this.vinculacion=vinculacion;
		this.personaVinculacion=personaVinculacion;
	}

	
	public Long getIdProhibicion() {
		return this.idProhibicion;
	}

	public void setIdProhibicion(Long idProhibicion) {
		this.idProhibicion = idProhibicion;
	}

//	
//	public JugPersona getJugPersona() {
//		return this.jugPersona;
//	}
//
//	public void setJugPersona(JugPersona jugPersona) {
//		this.jugPersona = jugPersona;
//	}

	
	public Long getIdProhibicionEnvio() {
		return this.idProhibicionEnvio;
	}

	public void setIdProhibicionEnvio(Long idProhibicionEnvio) {
		this.idProhibicionEnvio = idProhibicionEnvio;
	}

	
	public JugTipoProhibicion getJugTipoProhibicion() {
		return this.jugTipoProhibicion;
	}

	public void setJugTipoProhibicion(JugTipoProhibicion jugTipoProhibicion) {
		this.jugTipoProhibicion = jugTipoProhibicion;
	}

	public Date getFechaProhibicion() {
		return this.fechaProhibicion;
	}

	public void setFechaProhibicion(Date fechaProhibicion) {
		this.fechaProhibicion = fechaProhibicion;
	}

	
	public JugSituacion getJugSituacion() {
		return this.jugSituacion;
	}

	public void setJugSituacion(JugSituacion jugSituacion) {
		this.jugSituacion = jugSituacion;
	}

	
	public Date getFechaSituacion() {
		return this.fechaSituacion;
	}

	public void setFechaSituacion(Date fechaSituacion) {
		this.fechaSituacion = fechaSituacion;
	}


//	public JugCausaProhibicion getJugCausaProhibicion() {
//		return this.jugCausaProhibicion;
//	}
//
//	public void setJugCausaProhibicion(JugCausaProhibicion jugCausaProhibicion) {
//		this.jugCausaProhibicion = jugCausaProhibicion;
//	}


	public String getDuracion() {
		return this.duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	@Transient
	public Integer getDuracionMeses() {
		if (this.duracion != null && this.duracion.length() > 2) {
			return Integer.parseInt(this.duracion.substring(2));
		}
		return 0;
	}

	public void setDuracionMeses(Integer meses) {
		updateDuracion(meses, getDuracionAnyos());
	}

	@Transient
	public Integer getDuracionAnyos() {
		if (this.duracion != null) {
			return Integer.parseInt(this.duracion.substring(0, 2));
		}
		return 0;
	}

	public void setDuracionAnyos(Integer anyos) {
		updateDuracion(getDuracionMeses(), anyos);
	}

	private void updateDuracion(Integer meses, Integer anyos) {
		setDuracion(getDecimalFormat().format(anyos)
				+ getDecimalFormat().format(meses));
	}

	
	public JugComunidad getJugComunidad() {
		return this.jugComunidad;
	}

	public void setJugComunidad(JugComunidad jugComunidad) {
		this.jugComunidad = jugComunidad;
	}

	
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	
	public Integer getEnvioCarta() {
		return this.envioCarta;
	}

	public void setEnvioCarta(Integer envioCarta) {
		this.envioCarta = envioCarta;
	}

	
//	public JugTipoInscripcion getJugTipoInscripcion() {
//		return this.jugTipoInscripcion;
//	}
//
//	public void setJugTipoInscripcion(JugTipoInscripcion jugTipoInscripcion) {
//		this.jugTipoInscripcion = jugTipoInscripcion;
//	}

	
	public String getIdSentencia() {
		return this.idSentencia;
	}

	public void setIdSentencia(String idSentencia) {
		this.idSentencia = idSentencia;
	}
	
	
	public Date getFechaSentencia() {
		return this.fechaSentencia;
	}

	public void setFechaSentencia(Date fechaSentencia) {
		this.fechaSentencia = fechaSentencia;
	}

	public String getOrganoJudicial() {
		return this.organoJudicial;
	}

	public void setOrganoJudicial(String organoJudicial) {
		this.organoJudicial = organoJudicial;
	}

//	public JugOperadorJuego getJugOperadorJuego() {
//		return this.jugOperadorJuego;
//	}
//
//	public void setJugOperadorJuego(JugOperadorJuego jugOperadorJuego) {
//		this.jugOperadorJuego = jugOperadorJuego;
//	}

//	public JugTipoVinculacion getJugTipoVinculacion() {
//		return this.jugTipoVinculacion;
//	}
//
//	public void setJugTipoVinculacion(JugTipoVinculacion jugTipoVinculacion) {
//		this.jugTipoVinculacion = jugTipoVinculacion;
//	}

	
	public String getVinculacion() {
		return this.vinculacion;
	}

	public void setVinculacion(String vinculacion) {
		this.vinculacion = vinculacion;
	}

	
	public String getPersonaVinculacion() {
		return this.personaVinculacion;
	}

	public void setPersonaVinculacion(String personaVinculacion) {
		this.personaVinculacion = personaVinculacion;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getFechaCarencia() {
		return fechaCarencia;
	}

	public void setFechaCarencia(Date fechaCarencia) {
		this.fechaCarencia = fechaCarencia;
	}


	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	
	private DecimalFormat getDecimalFormat() {
		if (this.decimalFormat == null) {
			this.decimalFormat = new DecimalFormat("00");
		}
		return decimalFormat;
	}

	
	
	public void setFechaCarenciaCalendar(GregorianCalendar carencia) {
		if(carencia!=null)
		  this.fechaCarencia = carencia.getGregorianChange();
	}

	public JugPersona getJugPersona() {
		return jugPersona;
	}

	public void setJugPersona(JugPersona jugPersona) {
		this.jugPersona = jugPersona;
	}

}
