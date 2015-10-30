package es.dgoj.rgiaj.form;


/**
 * The search form class for the JUG_PERSONA database table.
 * 
 */
public class SearchPersonaForm {
	
	private String idPersona;

	private String nombre;

	private String apellido1;

	private String apellido2;

	private String codPostal;

	private String domicilio;

	private String email;

	private String estadoCarta;

	private String estadoEtiqueta;

	private String expedProhibicion;

	private String fechaNacimientoDesde;
	
	private String fechaNacimientoHasta;

	private String idMunicipio;

	private String idPais;
	
	private String idProvincia;
	
	private String idComunidad;

	private String numDocIdent;

	private String observaciones;

	private String sexo;

	private String telefono;
	
	private TipoDocIdentidadForm tipoDocIdent;

	private ProvinciaForm provincia;
	
	/* Campos de prohibicion */
	
	private String idTipoProhibicion;
	private String fechaProhibicionDesde;
	private String fechaProhibicionHasta;
	private String idSituacion;
	private String fechaSituacionDesde;
	private String fechaSituacionHasta;
	private String idCausaProhibicion;
	private String durMeses;
	private String durAnos;
	private String obsProhibicion;
	
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
	 * @return the fechaNacimientoDesde
	 */
	public String getFechaNacimientoDesde() {
		return fechaNacimientoDesde;
	}

	/**
	 * @param fechaNacimientoDesde the fechaNacimientoDesde to set
	 */
	public void setFechaNacimientoDesde(String fechaNacimientoDesde) {
		this.fechaNacimientoDesde = fechaNacimientoDesde;
	}

	/**
	 * @return the fechaNacimientoHasta
	 */
	public String getFechaNacimientoHasta() {
		return fechaNacimientoHasta;
	}

	/**
	 * @param fechaNacimientoHasta the fechaNacimientoHasta to set
	 */
	public void setFechaNacimientoHasta(String fechaNacimientoHasta) {
		this.fechaNacimientoHasta = fechaNacimientoHasta;
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
	 * @return the idProvincia
	 */
	public String getIdProvincia() {
		return idProvincia;
	}

	/**
	 * @param idProvincia the idProvincia to set
	 */
	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}

	/**
	 * @return the idComunidad
	 */
	public String getIdComunidad() {
		return idComunidad;
	}

	/**
	 * @param idComunidad the idComunidad to set
	 */
	public void setIdComunidad(String idComunidad) {
		this.idComunidad = idComunidad;
	}

	/**
	 * @return the idTipoProhibicion
	 */
	public String getIdTipoProhibicion() {
		return idTipoProhibicion;
	}

	/**
	 * @param idTipoProhibicion the idTipoProhibicion to set
	 */
	public void setIdTipoProhibicion(String idTipoProhibicion) {
		this.idTipoProhibicion = idTipoProhibicion;
	}

	/**
	 * @return the fechaProhibicionDesde
	 */
	public String getFechaProhibicionDesde() {
		return fechaProhibicionDesde;
	}

	/**
	 * @param fechaProhibicionDesde the fechaProhibicionDesde to set
	 */
	public void setFechaProhibicionDesde(String fechaProhibicionDesde) {
		this.fechaProhibicionDesde = fechaProhibicionDesde;
	}

	/**
	 * @return the fechaProhibicionHasta
	 */
	public String getFechaProhibicionHasta() {
		return fechaProhibicionHasta;
	}

	/**
	 * @param fechaProhibicionHasta the fechaProhibicionHasta to set
	 */
	public void setFechaProhibicionHasta(String fechaProhibicionHasta) {
		this.fechaProhibicionHasta = fechaProhibicionHasta;
	}

	/**
	 * @return the idSituacion
	 */
	public String getIdSituacion() {
		return idSituacion;
	}

	/**
	 * @param idSituacion the idSituacion to set
	 */
	public void setIdSituacion(String idSituacion) {
		this.idSituacion = idSituacion;
	}

	/**
	 * @return the fechaSituacionDesde
	 */
	public String getFechaSituacionDesde() {
		return fechaSituacionDesde;
	}

	/**
	 * @param fechaSituacionDesde the fechaSituacionDesde to set
	 */
	public void setFechaSituacionDesde(String fechaSituacionDesde) {
		this.fechaSituacionDesde = fechaSituacionDesde;
	}

	/**
	 * @return the fechaSituacionHasta
	 */
	public String getFechaSituacionHasta() {
		return fechaSituacionHasta;
	}

	/**
	 * @param fechaSituacionHasta the fechaSituacionHasta to set
	 */
	public void setFechaSituacionHasta(String fechaSituacionHasta) {
		this.fechaSituacionHasta = fechaSituacionHasta;
	}

	/**
	 * @return the durMeses
	 */
	public String getDurMeses() {
		return durMeses;
	}

	/**
	 * @param durMeses the durMeses to set
	 */
	public void setDurMeses(String durMeses) {
		this.durMeses = durMeses;
	}

	/**
	 * @return the durAnos
	 */
	public String getDurAnos() {
		return durAnos;
	}

	/**
	 * @param durAnos the durAnos to set
	 */
	public void setDurAnos(String durAnos) {
		this.durAnos = durAnos;
	}

	/**
	 * @return the obsProhibicion
	 */
	public String getObsProhibicion() {
		return obsProhibicion;
	}

	/**
	 * @param obsProhibicion the obsProhibicion to set
	 */
	public void setObsProhibicion(String obsProhibicion) {
		this.obsProhibicion = obsProhibicion;
	}

	/**
	 * @return the idCausaProhibicion
	 */
	public String getIdCausaProhibicion() {
		return idCausaProhibicion;
	}

	/**
	 * @param idCausaProhibicion the idCausaProhibicion to set
	 */
	public void setIdCausaProhibicion(String idCausaProhibicion) {
		this.idCausaProhibicion = idCausaProhibicion;
	}

	
}