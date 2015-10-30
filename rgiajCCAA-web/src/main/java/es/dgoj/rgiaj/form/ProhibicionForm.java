package es.dgoj.rgiaj.form;

import java.io.Serializable;


import es.dgoj.rgiaj.business.beans.ProhibicionBean;
import es.dgoj.rgiaj.util.Utilidades;


/**
 * The bean class for the JUG_PROHIBICION database table.
 * 
 */
public class ProhibicionForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private String idProhibicion;

	private String duracion;

	private String envioCarta;

	private String fechaCarencia;

	private String fechaProhibicion;

	private String fechaRegistro;

	private String fechaSentencia;

	private String fechaSituacion;

	private String idOperador;
	private String desOperador;

	private String idProhibicionEnvio;

	private String idSentencia;

	private String lastUpdate;

	private String modifiedBy;

	private String observaciones;

	private String organoJudicial;

	private String persVincula;

	private TipoInscripcionForm tipoInscripcion;

	private String tipoVinculacion;

	private String vinculacion;

	private ComunidadAutonomaForm comunidad;

	private CausaProhibicionForm causaProhibicion;

	private TipoProhibicionForm tipoProhibicion;
	
	private SituacionForm situacion;

	public ProhibicionForm() {
	}

	/**
	 * @param prohibicion 
	 */
	public ProhibicionForm(ProhibicionBean prohibicion) {
		if (prohibicion.getCausaProhibicion()!=null){
			this.setCausaProhibicion(new CausaProhibicionForm(prohibicion.getCausaProhibicion()));
		}
		if (prohibicion.getComunidad() !=null){
			this.setComunidad(new ComunidadAutonomaForm (prohibicion.getComunidad()));
		}
		this.setDuracion(prohibicion.getDuracion());
		if (prohibicion.getEnvioCarta()!=null){
			this.setEnvioCarta(prohibicion.getEnvioCarta().toString());
		}
		if (prohibicion.getFechaCarencia()!=null){
			this.setFechaCarencia(Utilidades.fromDateOrNull(prohibicion.getFechaCarencia()));
		}
		if (prohibicion.getFechaProhibicion()!=null){
			this.setFechaProhibicion(Utilidades.fromDateOrNull(prohibicion.getFechaProhibicion()));
		}
		if (prohibicion.getFechaRegistro()!=null){
			this.setFechaRegistro(Utilidades.fromDateOrNull(prohibicion.getFechaRegistro()));
		}
		if (prohibicion.getFechaSentencia()!=null){
			this.setFechaSentencia(Utilidades.fromDateOrNull(prohibicion.getFechaSentencia()));
		}
		if (prohibicion.getFechaSituacion()!=null){
			this.setFechaSituacion(Utilidades.fromDateOrNull(prohibicion.getFechaSituacion()));
		}
		if (prohibicion.getIdOperador()!=null){
			this.setIdOperador(prohibicion.getIdOperador().toString());
		}
		if (prohibicion.getIdProhibicion()!=null){
			this.setIdProhibicion(prohibicion.getIdProhibicion().toString());
		}
		this.setIdSentencia(prohibicion.getIdSentencia());
		if (prohibicion.getLastUpdate()!=null){
			this.setLastUpdate(Utilidades.fromDateTimeOrNull(prohibicion.getLastUpdate()));
		}
		this.setModifiedBy(prohibicion.getModifiedBy());
		this.setObservaciones(prohibicion.getObservaciones());
		this.setOrganoJudicial(prohibicion.getOrganoJudicial());
		this.setPersVincula(prohibicion.getPersVincula());
		this.setSituacion(new SituacionForm(prohibicion.getSituacion()));
		if (prohibicion.getTipoInscripcion()!=null){
			this.setTipoInscripcion(new TipoInscripcionForm(prohibicion.getTipoInscripcion()));
		}
		this.setTipoProhibicion(new TipoProhibicionForm(prohibicion.getTipoProhibicion()));
		if (prohibicion.getTipoVinculacion()!=null){
			this.setTipoVinculacion(prohibicion.getTipoVinculacion().toString());
		}
		this.setVinculacion(prohibicion.getVinculacion() );
	}

	/**
	 * @return the idProhibicion
	 */
	public String getIdProhibicion() {
		return idProhibicion;
	}

	/**
	 * @param idProhibicion the idProhibicion to set
	 */
	public void setIdProhibicion(String idProhibicion) {
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
	public String getEnvioCarta() {
		return envioCarta;
	}

	/**
	 * @param envioCarta the envioCarta to set
	 */
	public void setEnvioCarta(String envioCarta) {
		this.envioCarta = envioCarta;
	}

	/**
	 * @return the fechaCarencia
	 */
	public String getFechaCarencia() {
		return fechaCarencia;
	}

	/**
	 * @param fechaCarencia the fechaCarencia to set
	 */
	public void setFechaCarencia(String fechaCarencia) {
		this.fechaCarencia = fechaCarencia;
	}

	/**
	 * @return the fechaProhibicion
	 */
	public String getFechaProhibicion() {
		return fechaProhibicion;
	}

	/**
	 * @param fechaProhibicion the fechaProhibicion to set
	 */
	public void setFechaProhibicion(String fechaProhibicion) {
		this.fechaProhibicion = fechaProhibicion;
	}

	/**
	 * @return the fechaRegistro
	 */
	public String getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaSentencia
	 */
	public String getFechaSentencia() {
		return fechaSentencia;
	}

	/**
	 * @param fechaSentencia the fechaSentencia to set
	 */
	public void setFechaSentencia(String fechaSentencia) {
		this.fechaSentencia = fechaSentencia;
	}

	/**
	 * @return the fechaSituacion
	 */
	public String getFechaSituacion() {
		return fechaSituacion;
	}

	/**
	 * @param fechaSituacion the fechaSituacion to set
	 */
	public void setFechaSituacion(String fechaSituacion) {
		this.fechaSituacion = fechaSituacion;
	}

	/**
	 * @return the idOperador
	 */
	public String getIdOperador() {
		return idOperador;
	}

	/**
	 * @param idOperador the idOperador to set
	 */
	public void setIdOperador(String idOperador) {
		this.idOperador = idOperador;
	}

	/**
	 * @return the desOperador
	 */
	public String getDesOperador() {
		return desOperador;
	}

	/**
	 * @param desOperador the desOperador to set
	 */
	public void setDesOperador(String desOperador) {
		this.desOperador = desOperador;
	}

	/**
	 * @return the idProhibicionEnvio
	 */
	public String getIdProhibicionEnvio() {
		return idProhibicionEnvio;
	}

	/**
	 * @param idProhibicionEnvio the idProhibicionEnvio to set
	 */
	public void setIdProhibicionEnvio(String idProhibicionEnvio) {
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
	public String getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(String lastUpdate) {
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
	public TipoInscripcionForm getTipoInscripcion() {
		return tipoInscripcion;
	}

	/**
	 * @param tipoInscripcion the tipoInscripcion to set
	 */
	public void setTipoInscripcion(TipoInscripcionForm tipoInscripcion) {
		this.tipoInscripcion = tipoInscripcion;
	}

	/**
	 * @return the tipoVinculacion
	 */
	public String getTipoVinculacion() {
		return tipoVinculacion;
	}

	/**
	 * @param tipoVinculacion the tipoVinculacion to set
	 */
	public void setTipoVinculacion(String tipoVinculacion) {
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
	public ComunidadAutonomaForm getComunidad() {
		return comunidad;
	}

	/**
	 * @param comunidad the comunidad to set
	 */
	public void setComunidad(ComunidadAutonomaForm comunidad) {
		this.comunidad = comunidad;
	}

	/**
	 * @return the causaProhibicion
	 */
	public CausaProhibicionForm getCausaProhibicion() {
		return causaProhibicion;
	}

	/**
	 * @param causaProhibicion the causaProhibicion to set
	 */
	public void setCausaProhibicion(CausaProhibicionForm causaProhibicion) {
		this.causaProhibicion = causaProhibicion;
	}

	/**
	 * @return the tipoProhibicion
	 */
	public TipoProhibicionForm getTipoProhibicion() {
		return tipoProhibicion;
	}

	/**
	 * @param tipoProhibicion the tipoProhibicion to set
	 */
	public void setTipoProhibicion(TipoProhibicionForm tipoProhibicion) {
		this.tipoProhibicion = tipoProhibicion;
	}

	/**
	 * @return the situacion
	 */
	public SituacionForm getSituacion() {
		return situacion;
	}

	/**
	 * @param situacion the situacion to set
	 */
	public void setSituacion(SituacionForm situacion) {
		this.situacion = situacion;
	}

	/**
	 * @return duracion en meses
	 */
	public String getDurMeses() {
		if (duracion.length()==4){
			return duracion.substring(2);
		} else {
			return "";
		}
	}
	
	/**
	 * @return duracion en años 
	 */
	public String getDurAnos() {
		if (duracion.length()==4){
			return duracion.substring(0, 2);
		} else {
			return duracion;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.tipoProhibicion.getDescripcion() + "; " + 
			   ((this.tipoInscripcion!=null)?this.tipoInscripcion.getDescripcion():"")  + "; " + 
			   ((this.fechaProhibicion!=null)?this.fechaProhibicion:"") + "; " + 
			   ((this.situacion!=null)?this.situacion.getDescripcion():"") + "; " + 
			   ((this.fechaSituacion!=null)?this.fechaSituacion:"") + "; " + 
			   ((this.lastUpdate!=null)?this.lastUpdate:"") + "; " + 
			   ((this.modifiedBy!=null)?this.modifiedBy:"")+ "; " + 
			   ((this.causaProhibicion!=null)?this.causaProhibicion.getDescripcion():"")  + "; " +
			   ((this.fechaCarencia!=null)?this.fechaCarencia:"") + "; " + 
			   this.fechaRegistro+ "; " + 
			   ((this.getDuracion()!=null)?this.getDurAnos():"")+ "; " +
			   ((this.getDuracion()!=null)?this.getDurMeses():"")+ "; " +
			   ((this.getObservaciones()!=null)?this.getObservaciones():"")+ "; " +
			   ((this.idSentencia!=null)?this.idSentencia:"")+ "; " +
			   ((this.organoJudicial!=null)?this.organoJudicial:"")+ "; " +
			   ((this.fechaSentencia!=null)?this.fechaSentencia:"");
/*
				 idProhibicionEnvio="
				+ idProhibicionEnvio + ", idSentencia=" + idSentencia
				+ ", lastUpdate=" + lastUpdate + ", modifiedBy=" + modifiedBy
				+ ", observaciones=" + observaciones + ", organoJudicial="
				+ organoJudicial + ", persVincula=" + persVincula
				+ ", tipoInscripcion=" + tipoInscripcion + ", tipoVinculacion="
				+ tipoVinculacion + ", vinculacion=" + vinculacion
				+ ", comunidad=" + comunidad + ", causaProhibicion="
				+ causaProhibicion + ", tipoProhibicion=" + tipoProhibicion
				+ ", situacion=" + situacion + "]";*/
	}

	
	
	
}