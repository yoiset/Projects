package es.dgoj.rgiaj.form;

import java.util.List;

/**
 * The form class for the JUG_PERSONA database table.
 * 
 */
public class PersonaForm {
	
	private String idPersona;

	private String apellido1;

	private String apellido2;

	private String codPostal;

	private String domicilio;

	private String email;

	private String estadoCarta;

	private String estadoEtiqueta;

	private String expedProhibicion;

	private String fechaNacimiento;

	private String idMunicipio;

	private String idPais;

	private String lastUpdate;

	private String modifiedBy;

	private String nombre;

	private String numDocIdent;

	private String observaciones;

	private String pendienteCompletar; 

	private String sexo;

	private String telefono;
	
	private TipoDocIdentidadForm tipoDocIdent;
	private String desTipoDocIdent;

	private ProvinciaForm provincia;
	private String desProvincia;
	private String desComunidad;
	
	private List<ProhibicionForm> listaProhibiciones;
	private String detalleProhibiciones;

	/** Campo error. */
	private String error;
	
	/**
	 * @return the idPersona
	 */
	public String getIdPersona() {
		return idPersona;
	}

	/**
	 * @param idPersona the idPersona to set
	 */
	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	/**
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * @param apellido1 the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * @param apellido2 the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * @return the codPostal
	 */
	public String getCodPostal() {
		return codPostal;
	}

	/**
	 * @param codPostal the codPostal to set
	 */
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	/**
	 * @return the domicilio
	 */
	public String getDomicilio() {
		return domicilio;
	}

	/**
	 * @param domicilio the domicilio to set
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the estadoCarta
	 */
	public String getEstadoCarta() {
		return estadoCarta;
	}

	/**
	 * @param estadoCarta the estadoCarta to set
	 */
	public void setEstadoCarta(String estadoCarta) {
		this.estadoCarta = estadoCarta;
	}

	/**
	 * @return the estadoEtiqueta
	 */
	public String getEstadoEtiqueta() {
		return estadoEtiqueta;
	}

	/**
	 * @param estadoEtiqueta the estadoEtiqueta to set
	 */
	public void setEstadoEtiqueta(String estadoEtiqueta) {
		this.estadoEtiqueta = estadoEtiqueta;
	}

	/**
	 * @return the expedProhibicion
	 */
	public String getExpedProhibicion() {
		return expedProhibicion;
	}

	/**
	 * @param expedProhibicion the expedProhibicion to set
	 */
	public void setExpedProhibicion(String expedProhibicion) {
		this.expedProhibicion = expedProhibicion;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the idMunicipio
	 */
	public String getIdMunicipio() {
		return idMunicipio;
	}

	/**
	 * @param idMunicipio the idMunicipio to set
	 */
	public void setIdMunicipio(String idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	/**
	 * @return the idPais
	 */
	public String getIdPais() {
		return idPais;
	}

	/**
	 * @param idPais the idPais to set
	 */
	public void setIdPais(String idPais) {
		this.idPais = idPais;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the numDocIdent
	 */
	public String getNumDocIdent() {
		return numDocIdent;
	}

	/**
	 * @param numDocIdent the numDocIdent to set
	 */
	public void setNumDocIdent(String numDocIdent) {
		this.numDocIdent = numDocIdent;
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
	 * @return the pendienteCompletar
	 */
	public String getPendienteCompletar() {
		return pendienteCompletar;
	}

	/**
	 * @param pendienteCompletar the pendienteCompletar to set
	 */
	public void setPendienteCompletar(String pendienteCompletar) {
		this.pendienteCompletar = pendienteCompletar;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return the tipoDocIdent
	 */
	public TipoDocIdentidadForm getTipoDocIdent() {
		return tipoDocIdent;
	}

	/**
	 * @param tipoDocIdent the tipoDocIdent to set
	 */
	public void setTipoDocIdent(TipoDocIdentidadForm tipoDocIdent) {
		this.tipoDocIdent = tipoDocIdent;
	}

	/**
	 * @return the provincia
	 */
	public ProvinciaForm getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(ProvinciaForm provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return the listaProhibiciones
	 */
	public List<ProhibicionForm> getListaProhibiciones() {
		return listaProhibiciones;
	}

	/**
	 * @param listaProhibiciones the listaProhibiciones to set
	 */
	public void setListaProhibiciones(List<ProhibicionForm> listaProhibiciones) {
		this.listaProhibiciones = listaProhibiciones;
	}

	/**
	 * @return the desProvincia
	 */
	public String getDesProvincia() {
		return desProvincia;
	}

	/**
	 * @param desProvincia the desProvincia to set
	 */
	public void setDesProvincia(String desProvincia) {
		this.desProvincia = desProvincia;
	}

	/**
	 * @return the desComunidad
	 */
	public String getDesComunidad() {
		return desComunidad;
	}

	/**
	 * @param desComunidad the desComunidad to set
	 */
	public void setDesComunidad(String desComunidad) {
		this.desComunidad = desComunidad;
	}

	/**
	 * @return the desTipoDocIdent
	 */
	public String getDesTipoDocIdent() {
		return desTipoDocIdent;
	}

	/**
	 * @param desTipoDocIdent the desTipoDocIdent to set
	 */
	public void setDesTipoDocIdent(String desTipoDocIdent) {
		this.desTipoDocIdent = desTipoDocIdent;
	}

	/**
	 * @return the detalleProhibiciones
	 */
	public String getDetalleProhibiciones() {
		return detalleProhibiciones;
	}

	/**
	 * @param detalleProhibiciones the detalleProhibiciones to set
	 */
	public void setDetalleProhibiciones(String detalleProhibiciones) {
		this.detalleProhibiciones = detalleProhibiciones;
	}

}