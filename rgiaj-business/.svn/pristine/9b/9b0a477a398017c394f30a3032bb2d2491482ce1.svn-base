package es.dgoj.rgiaj.business.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.dgoj.rgiaj.business.model.Persona;
import es.dgoj.rgiaj.business.model.Prohibicion;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



/**
 * The bean class for the JUG_PERSONA database table.
 * 
 */
public class PersonaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idPersona;

	private String apellido1;

	private String apellido2;

	private Integer codPostal;

	private String domicilio;

	private String email;

	private String estadoCarta;

	private String estadoEtiqueta;

	private String expedProhibicion;

	private Date fechaNacimiento;

	private Long idMunicipio;

	private Long idPais;

	private Timestamp lastUpdate;

	private String modifiedBy;

	private String nombre;

	private String numDocIdent;

	private String observaciones;

	private Integer pendienteCompletar; 

	private String sexo;

	private String telefono;

	private TipoDocIdentidadBean tipoDocIdent;

	private ProvinciaBean provincia;

	private List<ProhibicionBean> prohibiciones;

	/** 
	 * Constructor del bean a partir de su entity.
	 * @param persona
	 */
	public PersonaBean(Persona persona) {

		this.setExpedProhibicion(persona.getExpedProhibicion());

		this.setIdPersona(persona.getIdPersona());
		
		this.setTipoDocIdent(new TipoDocIdentidadBean(persona.getTipoDocIdent()));
		this.setNumDocIdent(persona.getNumDocIdent());
		
		this.setNombre(persona.getNombre());
		this.setApellido1(persona.getApellido1());
		this.setApellido2(persona.getApellido2());
		this.setCodPostal(persona.getCodPostal());
		this.setDomicilio(persona.getDomicilio());
		this.setSexo(persona.getSexo());
		this.setTelefono(persona.getTelefono());
		this.setEmail(persona.getEmail());
		this.setEstadoCarta(persona.getEmail() );
		this.setEstadoEtiqueta(persona.getEstadoEtiqueta());
		this.setFechaNacimiento(persona.getFechaNacimiento());
		this.setIdMunicipio(persona.getIdMunicipio());
		this.setIdPais(persona.getIdPais());
		this.setObservaciones(persona.getObservaciones());

		this.setLastUpdate(persona.getLastUpdate());
		this.setModifiedBy(persona.getModifiedBy());

		this.setPendienteCompletar(persona.getPendienteCompletar());
		
		this.setProhibiciones(new ArrayList<ProhibicionBean>());

		if(persona.getProhibiciones()!= null){
			for (Prohibicion prohibicion: persona.getProhibiciones()){
				this.getProhibiciones().add(new ProhibicionBean(prohibicion));
			}
		}
		
		if(persona.getProvincia() != null){
			this.setProvincia(new ProvinciaBean(persona.getProvincia()));	
		}		
	}
	
	/**
	 * Constructor del bean a partir de su entity pero sin copiar prohibiciones
	 * @param persona
	 */
	public PersonaBean(Persona persona, Boolean sinProhibiciones) {

		this.setExpedProhibicion(persona.getExpedProhibicion());

		this.setIdPersona(persona.getIdPersona());
		
		this.setTipoDocIdent(new TipoDocIdentidadBean(persona.getTipoDocIdent()));
		this.setNumDocIdent(persona.getNumDocIdent());
		
		this.setNombre(persona.getNombre());
		this.setApellido1(persona.getApellido1());
		this.setApellido2(persona.getApellido2());
		this.setCodPostal(persona.getCodPostal());
		this.setDomicilio(persona.getDomicilio());
		this.setSexo(persona.getSexo());
		this.setTelefono(persona.getTelefono());
		this.setEmail(persona.getEmail());
		this.setEstadoCarta(persona.getEmail() );
		this.setEstadoEtiqueta(persona.getEstadoEtiqueta());
		this.setFechaNacimiento(persona.getFechaNacimiento());
		this.setIdMunicipio(persona.getIdMunicipio());
		this.setIdPais(persona.getIdPais());
		this.setObservaciones(persona.getObservaciones());

		this.setLastUpdate(persona.getLastUpdate());
		this.setModifiedBy(persona.getModifiedBy());

		this.setPendienteCompletar(persona.getPendienteCompletar());
		
		if (!sinProhibiciones){
			this.setProhibiciones(new ArrayList<ProhibicionBean>());
			for (Prohibicion prohibicion: persona.getProhibiciones()){
				this.getProhibiciones().add(new ProhibicionBean(prohibicion));
			}
		}

		if(persona.getProvincia() != null){
			this.setProvincia(new ProvinciaBean(persona.getProvincia()));	
		}
	}

	/**
	 * @return the idPersona
	 */
	public Long getIdPersona() {
		return idPersona;
	}

	/**
	 * @param idPersona the idPersona to set
	 */
	public void setIdPersona(Long idPersona) {
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
	public Integer getCodPostal() {
		return codPostal;
	}

	/**
	 * @param codPostal the codPostal to set
	 */
	public void setCodPostal(Integer codPostal) {
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
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the idMunicipio
	 */
	public Long getIdMunicipio() {
		return idMunicipio;
	}

	/**
	 * @param idMunicipio the idMunicipio to set
	 */
	public void setIdMunicipio(Long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	/**
	 * @return the idPais
	 */
	public Long getIdPais() {
		return idPais;
	}

	/**
	 * @param idPais the idPais to set
	 */
	public void setIdPais(Long idPais) {
		this.idPais = idPais;
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
	public Integer getPendienteCompletar() {
		return pendienteCompletar;
	}

	/**
	 * @param pendienteCompletar the pendienteCompletar to set
	 */
	public void setPendienteCompletar(Integer pendienteCompletar) {
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
	 * @return the tipoDocIdent
	 */
	public TipoDocIdentidadBean getTipoDocIdent() {
		return tipoDocIdent;
	}

	/**
	 * @param tipoDocIdent the tipoDocIdent to set
	 */
	public void setTipoDocIdent(TipoDocIdentidadBean tipoDocIdent) {
		this.tipoDocIdent = tipoDocIdent;
	}

	/**
	 * @return the provincia
	 */
	public ProvinciaBean getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(ProvinciaBean provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return the prohibiciones
	 */
	public List<ProhibicionBean> getProhibiciones() {
		return prohibiciones;
	}

	/**
	 * @param prohibiciones the prohibiciones to set
	 */
	public void setProhibiciones(List<ProhibicionBean> prohibiciones) {
		this.prohibiciones = prohibiciones;
	}
	
	/**
	 * Devuelve el valor del campo prohibiciones ds.
	 *
	 * @return JRDataSource
	 */
	public JRDataSource getProhibicionesDS(){       
		
	    return new JRBeanCollectionDataSource(this.getProhibiciones());   
	}
}