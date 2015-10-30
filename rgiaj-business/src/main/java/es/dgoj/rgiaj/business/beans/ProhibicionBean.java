package es.dgoj.rgiaj.business.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import es.dgoj.rgiaj.business.model.Prohibicion;



/**
 * The bean class for the JUG_PROHIBICION database table.
 * 
 */
public class ProhibicionBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idProhibicion;

	private String duracion;

	private Integer envioCarta;

	private Date fechaCarencia;

	private Date fechaProhibicion;

	private Date fechaRegistro;

	private Date fechaSentencia;

	private Date fechaSituacion;

	private Long idOperador;

	private Long idProhibicionEnvio;

	private String idSentencia;

	private Timestamp lastUpdate;

	private String modifiedBy;

	private String observaciones;

	private String organoJudicial;

	private String persVincula;

	private TipoInscripcionBean tipoInscripcion;

	private Long tipoVinculacion;

	private String vinculacion;

	private ComunidadAutonomaBean comunidad;

	private CausaProhibicionBean causaProhibicion;

	private TipoProhibicionBean tipoProhibicion;

	private PersonaBean persona;

	private SituacionBean situacion;

	public ProhibicionBean() {
	}

	/**
	 * @param prohibicion 
	 */
	public ProhibicionBean(Prohibicion prohibicion) {
		if(prohibicion.getCausaProhibicion()!=null){
			this.setCausaProhibicion(new CausaProhibicionBean(prohibicion.getCausaProhibicion()));
		}
		this.setComunidad(new ComunidadAutonomaBean (prohibicion.getComunidad()));
		this.setDuracion(prohibicion.getDuracion());
		this.setEnvioCarta(prohibicion.getEnvioCarta());
		this.setFechaCarencia(prohibicion.getFechaCarencia());
		this.setFechaProhibicion(prohibicion.getFechaProhibicion());
		this.setFechaRegistro(prohibicion.getFechaRegistro());
		this.setFechaSentencia(prohibicion.getFechaSentencia());
		this.setFechaSituacion(prohibicion.getFechaSituacion());
		this.setIdOperador(prohibicion.getIdOperador());
		this.setIdProhibicion(prohibicion.getIdProhibicion());
		this.setIdSentencia(prohibicion.getIdSentencia());
		this.setLastUpdate(prohibicion.getLastUpdate());
		this.setModifiedBy(prohibicion.getModifiedBy());
		this.setObservaciones(prohibicion.getObservaciones());
		this.setOrganoJudicial(prohibicion.getOrganoJudicial());
		this.setPersona(new PersonaBean(prohibicion.getPersona(), true));
		this.setPersVincula(prohibicion.getPersVincula());
		this.setSituacion(new SituacionBean(prohibicion.getSituacion()));
		if (prohibicion.getTipoInscripcion()!= null){
			this.setTipoInscripcion(new TipoInscripcionBean(prohibicion.getTipoInscripcion()));
		}
		this.setTipoProhibicion(new TipoProhibicionBean(prohibicion.getTipoProhibicion()));
		this.setTipoVinculacion(prohibicion.getTipoVinculacion());
		this.setVinculacion(prohibicion.getVinculacion() );
	}

	/**
	 * @return the idProhibicion
	 */
	public Long getIdProhibicion() {
		return idProhibicion;
	}

	/**
	 * @param idProhibicion the idProhibicion to set
	 */
	public void setIdProhibicion(Long idProhibicion) {
		this.idProhibicion = idProhibicion;
	}

	/**
	 * @return the duracion
	 */
	public String getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	/**
	 * @return the envioCarta
	 */
	public Integer getEnvioCarta() {
		return envioCarta;
	}

	/**
	 * @param envioCarta the envioCarta to set
	 */
	public void setEnvioCarta(Integer envioCarta) {
		this.envioCarta = envioCarta;
	}

	/**
	 * @return the fechaCarencia
	 */
	public Date getFechaCarencia() {
		return fechaCarencia;
	}

	/**
	 * @param fechaCarencia the fechaCarencia to set
	 */
	public void setFechaCarencia(Date fechaCarencia) {
		this.fechaCarencia = fechaCarencia;
	}

	/**
	 * @return the fechaProhibicion
	 */
	public Date getFechaProhibicion() {
		return fechaProhibicion;
	}

	/**
	 * @param fechaProhibicion the fechaProhibicion to set
	 */
	public void setFechaProhibicion(Date fechaProhibicion) {
		this.fechaProhibicion = fechaProhibicion;
	}

	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaSentencia
	 */
	public Date getFechaSentencia() {
		return fechaSentencia;
	}

	/**
	 * @param fechaSentencia the fechaSentencia to set
	 */
	public void setFechaSentencia(Date fechaSentencia) {
		this.fechaSentencia = fechaSentencia;
	}

	/**
	 * @return the fechaSituacion
	 */
	public Date getFechaSituacion() {
		return fechaSituacion;
	}

	/**
	 * @param fechaSituacion the fechaSituacion to set
	 */
	public void setFechaSituacion(Date fechaSituacion) {
		this.fechaSituacion = fechaSituacion;
	}

	/**
	 * @return the idOperador
	 */
	public Long getIdOperador() {
		return idOperador;
	}

	/**
	 * @param idOperador the idOperador to set
	 */
	public void setIdOperador(Long idOperador) {
		this.idOperador = idOperador;
	}

	/**
	 * @return the idProhibicionEnvio
	 */
	public Long getIdProhibicionEnvio() {
		return idProhibicionEnvio;
	}

	/**
	 * @param idProhibicionEnvio the idProhibicionEnvio to set
	 */
	public void setIdProhibicionEnvio(Long idProhibicionEnvio) {
		this.idProhibicionEnvio = idProhibicionEnvio;
	}

	/**
	 * @return the idSentencia
	 */
	public String getIdSentencia() {
		return idSentencia;
	}

	/**
	 * @param idSentencia the idSentencia to set
	 */
	public void setIdSentencia(String idSentencia) {
		this.idSentencia = idSentencia;
	}

	/**
	 * @return the lastUpdate
	 */
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * @return the organoJudicial
	 */
	public String getOrganoJudicial() {
		return organoJudicial;
	}

	/**
	 * @param organoJudicial the organoJudicial to set
	 */
	public void setOrganoJudicial(String organoJudicial) {
		this.organoJudicial = organoJudicial;
	}

	/**
	 * @return the persVincula
	 */
	public String getPersVincula() {
		return persVincula;
	}

	/**
	 * @param persVincula the persVincula to set
	 */
	public void setPersVincula(String persVincula) {
		this.persVincula = persVincula;
	}

	/**
	 * @return the tipoInscripcion
	 */
	public TipoInscripcionBean getTipoInscripcion() {
		return tipoInscripcion;
	}

	/**
	 * @param tipoInscripcion the tipoInscripcion to set
	 */
	public void setTipoInscripcion(TipoInscripcionBean tipoInscripcion) {
		this.tipoInscripcion = tipoInscripcion;
	}

	/**
	 * @return the tipoVinculacion
	 */
	public Long getTipoVinculacion() {
		return tipoVinculacion;
	}

	/**
	 * @param tipoVinculacion the tipoVinculacion to set
	 */
	public void setTipoVinculacion(Long tipoVinculacion) {
		this.tipoVinculacion = tipoVinculacion;
	}

	/**
	 * @return the vinculacion
	 */
	public String getVinculacion() {
		return vinculacion;
	}

	/**
	 * @param vinculacion the vinculacion to set
	 */
	public void setVinculacion(String vinculacion) {
		this.vinculacion = vinculacion;
	}

	/**
	 * @return the comunidad
	 */
	public ComunidadAutonomaBean getComunidad() {
		return comunidad;
	}

	/**
	 * @param comunidad the comunidad to set
	 */
	public void setComunidad(ComunidadAutonomaBean comunidad) {
		this.comunidad = comunidad;
	}

	/**
	 * @return the causaProhibicion
	 */
	public CausaProhibicionBean getCausaProhibicion() {
		return causaProhibicion;
	}

	/**
	 * @param causaProhibicion the causaProhibicion to set
	 */
	public void setCausaProhibicion(CausaProhibicionBean causaProhibicion) {
		this.causaProhibicion = causaProhibicion;
	}

	/**
	 * @return the tipoProhibicion
	 */
	public TipoProhibicionBean getTipoProhibicion() {
		return tipoProhibicion;
	}

	/**
	 * @param tipoProhibicion the tipoProhibicion to set
	 */
	public void setTipoProhibicion(TipoProhibicionBean tipoProhibicion) {
		this.tipoProhibicion = tipoProhibicion;
	}

	/**
	 * @return the persona
	 */
	public PersonaBean getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(PersonaBean persona) {
		this.persona = persona;
	}

	/**
	 * @return the situacion
	 */
	public SituacionBean getSituacion() {
		return situacion;
	}

	/**
	 * @param situacion the situacion to set
	 */
	public void setSituacion(SituacionBean situacion) {
		this.situacion = situacion;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}