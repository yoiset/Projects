package es.dgoj.rgiaj.business.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the JUG_PERSONA database table.
 * 
 */
@Entity
@Table(name = "JUG_PERSONA")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Redefinimos este método para poder filtrar duplicados.
	 */
	public boolean equals(Object otraPersona) {
		if (this == otraPersona) {
			return true;
		}
		if (!(otraPersona instanceof Persona)) {
			return false;
		}
		Persona persona2 = (Persona) otraPersona;
		return persona2.getIdPersona().equals(this.getIdPersona());
	}

	@Id
	@Column(name = "ID_PERSONA")
	private Long idPersona;

	private String apellido1;

	private String apellido2;

	@Column(name = "COD_POSTAL")
	private Integer codPostal;

	private String domicilio;

	private String email;

	@Column(name = "ESTADO_CARTA")
	private String estadoCarta;

	@Column(name = "ESTADO_ETIQUETA")
	private String estadoEtiqueta;

	@Column(name = "EXPED_PROHIBICION")
	private String expedProhibicion;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	@Column(name = "ID_MUNICIPIO")
	private Long idMunicipio;

	@Column(name = "ID_PAIS")
	private Long idPais;

	@Column(name = "LAST_UPDATE")
	private Timestamp lastUpdate;

	@Column(name = "MODIFIED_BY")
	private String modifiedBy;

	private String nombre;

	@Column(name = "NUM_DOC_IDENT")
	private String numDocIdent;

	private String observaciones;

	@Column(name = "PENDIENTE_COMPLETAR")
	private Integer pendienteCompletar;

	private String sexo;

	private String telefono;

	// bi-directional many-to-one association to JugTipoDocIdent
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_DOC_IDENT")
	private TipoDocIdentidad tipoDocIdent;

	// bi-directional many-to-one association to JugProvincia
	@ManyToOne
	@JoinColumn(name = "ID_PROVINCIA")
	private Provincia provincia;

	// bi-directional many-to-one association to JugProhibicion
	@OneToMany(mappedBy = "persona")
	private List<Prohibicion> prohibiciones;

	public Persona() {
	}

	public Long getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Integer getCodPostal() {
		return this.codPostal;
	}

	public void setCodPostal(Integer codPostal) {
		this.codPostal = codPostal;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstadoCarta() {
		return this.estadoCarta;
	}

	public void setEstadoCarta(String estadoCarta) {
		this.estadoCarta = estadoCarta;
	}

	public String getEstadoEtiqueta() {
		return this.estadoEtiqueta;
	}

	public void setEstadoEtiqueta(String estadoEtiqueta) {
		this.estadoEtiqueta = estadoEtiqueta;
	}

	public String getExpedProhibicion() {
		return this.expedProhibicion;
	}

	public void setExpedProhibicion(String expedProhibicion) {
		this.expedProhibicion = expedProhibicion;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(Long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public Long getIdPais() {
		return this.idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumDocIdent() {
		return this.numDocIdent;
	}

	public void setNumDocIdent(String numDocIdent) {
		this.numDocIdent = numDocIdent;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getPendienteCompletar() {
		return this.pendienteCompletar;
	}

	public void setPendienteCompletar(Integer pendienteCompletar) {
		this.pendienteCompletar = pendienteCompletar;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public TipoDocIdentidad getTipoDocIdent() {
		return this.tipoDocIdent;
	}

	public void setTipoDocIdent(TipoDocIdentidad jugTipoDocIdent) {
		this.tipoDocIdent = jugTipoDocIdent;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia jugProvincia) {
		this.provincia = jugProvincia;
	}

	public List<Prohibicion> getProhibiciones() {
		return this.prohibiciones;
	}

	public void setProhibiciones(List<Prohibicion> jugProhibiciones) {
		this.prohibiciones = jugProhibiciones;
	}

	public Prohibicion addProhibicion(Prohibicion jugProhibicion) {
		getProhibiciones().add(jugProhibicion);
		jugProhibicion.setPersona(this);

		return jugProhibicion;
	}

	public Prohibicion removeProhibicion(Prohibicion jugProhibicion) {
		getProhibiciones().remove(jugProhibicion);
		jugProhibicion.setPersona(null);

		return jugProhibicion;
	}
}