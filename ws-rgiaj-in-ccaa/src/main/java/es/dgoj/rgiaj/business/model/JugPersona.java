package es.dgoj.rgiaj.business.model;

// Generated by Expand 2.2.0 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

import es.dgoj.rgiaj.business.util.ProhibicionesComparator;


/**
 * @author ylopezconnectis
 *
 */
@Entity
@Table(name = "JUG_PERSONA")
public class JugPersona implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_PERSONA", nullable = false, unique = true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HIBERNATE_SEQUENCE")
    @SequenceGenerator(name="HIBERNATE_SEQUENCE", sequenceName="HIBERNATE_SEQUENCE", allocationSize=100)
	private Long idPersona;
	
	@Column(name = "NUM_DOC_IDENT", nullable = false)
	private String numDocIdent;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APELLIDO1")
	private String apellido1;
	
	@Column(name = "APELLIDO2")
	private String apellido2;
	
	@Column(name = "DOMICILIO")
	private String domicilio;
	
	@Column(name = "COD_POSTAL")
	private Integer codPostal;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_NACIMIENTO")
	private Date fechaNacimiento;
	
	@Column(name = "TELEFONO")
	private String telefono;
	
	@Column(name = "EXPED_PROHIBICION")
	private String expedProhibicion;
	
	@Column(name = "OBSERVACIONES")
	private String observaciones;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "PENDIENTE_COMPLETAR")
	private Integer pendienteCompletar;
	
	@Column(name = "ESTADO_ETIQUETA")
	private String estadoEtiqueta;
	
	@Column(name = "ESTADO_CARTA")
	private String estadoCarta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PROVINCIA")
	private JugProvincia jugProvincia;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_MUNICIPIO")
	private JugMunicipio jugMunicipio;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TIPO_DOC_IDENT", nullable = false)
	private JugTipoDocIdent jugTipoDocIdent;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "ID_PAIS")
//	private JugPais jugPais;
	
	@Column(name="SEXO", length=1)
	private String sexo;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jugPersona", cascade = CascadeType.PERSIST)
	private List<JugProhibicion> jugProhibicionList = new ArrayList<JugProhibicion>(0);

	//	private List<JugAdjuntoPersona> jugAdjuntoPersonaList = new ArrayList<JugAdjuntoPersona>(0);
	
	@Formula("NVL(last_update,TO_DATE('01/01/1900','dd/mm/yyyy'))")
	private Date orderLastUpdate;
	
	@Formula("NVL(apellido2,'')")
	private String orderApellido2;

	public JugPersona() {
	}

	public JugPersona(Long idPersona, String numDocIdent,
			JugTipoDocIdent jugTipoDocIdent) {
		this.idPersona = idPersona;
		this.numDocIdent = numDocIdent;
		this.jugTipoDocIdent = jugTipoDocIdent;
	}

	public JugPersona(Long idPersona, String numDocIdent, String nombre,
			String apellido1, String apellido2, String domicilio,
			Integer codPostal, Date fechaNacimiento, String telefono,
			String expedProhibicion, String observaciones, Date lastUpdate,
			String modifiedBy, Integer pendienteCompletar,
			String estadoEtiqueta, String estadoCarta,
			JugProvincia jugProvincia, JugMunicipio jugMunicipio,
			JugTipoDocIdent jugTipoDocIdent, 
			List<JugProhibicion> jugProhibicionList) {
		this.idPersona = idPersona;
		this.numDocIdent = numDocIdent;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.domicilio = domicilio;
		this.codPostal = codPostal;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.expedProhibicion = expedProhibicion;
		this.observaciones = observaciones;
		this.lastUpdate = lastUpdate;
		this.modifiedBy = modifiedBy;
		this.pendienteCompletar = pendienteCompletar;
		this.estadoEtiqueta = estadoEtiqueta;
		this.estadoCarta = estadoCarta;
		this.jugProvincia = jugProvincia;
		this.jugMunicipio = jugMunicipio;
		this.jugTipoDocIdent = jugTipoDocIdent;
		this.jugProhibicionList = jugProhibicionList;
	}

	
	public Long getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	
	public Integer getPendienteCompletar() {
		return this.pendienteCompletar;
	}

	public void setPendienteCompletar(Integer pendienteCompletar) {
		this.pendienteCompletar = pendienteCompletar;
	}

	
	public String getExpedProhibicion() {
		return this.expedProhibicion;
	}

	public void setExpedProhibicion(String expedProhibicion) {
		this.expedProhibicion = expedProhibicion;
	}


	public JugTipoDocIdent getJugTipoDocIdent() {
		return this.jugTipoDocIdent;
	}

	public void setJugTipoDocIdent(JugTipoDocIdent jugTipoDocIdent) {
		this.jugTipoDocIdent = jugTipoDocIdent;
	}

	public String getNumDocIdent() {
		return this.numDocIdent;
	}

	public void setNumDocIdent(String numDocIdent) {
		if (numDocIdent != null) {
			numDocIdent = numDocIdent.trim().toUpperCase();
		}
		this.numDocIdent = numDocIdent;
	}

	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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


//	public JugPais getJugPais() {
//		return this.jugPais;
//	}
//
//	public void setJugPais(JugPais jugPais) {
//		this.jugPais = jugPais;
//	}


	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	
	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	
	public JugProvincia getJugProvincia() {
		return this.jugProvincia;
	}

	public void setJugProvincia(JugProvincia jugProvincia) {
		this.jugProvincia = jugProvincia;
	}

	
	public JugMunicipio getJugMunicipio() {
		return this.jugMunicipio;
	}

	public void setJugMunicipio(JugMunicipio jugMunicipio) {
		this.jugMunicipio = jugMunicipio;
	}

	public Integer getCodPostal() {
		return this.codPostal;
	}

	public void setCodPostal(Integer codPostal) {
		this.codPostal = codPostal;
	}

	
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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

	
	public String getEstadoEtiqueta() {
		return this.estadoEtiqueta;
	}

	public void setEstadoEtiqueta(String estadoEtiqueta) {
		this.estadoEtiqueta = estadoEtiqueta;
	}

	
	public String getEstadoCarta() {
		return this.estadoCarta;
	}

	public void setEstadoCarta(String estadoCarta) {
		this.estadoCarta = estadoCarta;
	}

	
	public List<JugProhibicion> getJugProhibicionList() {
		return this.jugProhibicionList;
	}

	public void setJugProhibicionList(List<JugProhibicion> jugProhibicionList) {
		this.jugProhibicionList = jugProhibicionList;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jugPersona")
//	public List<JugAdjuntoPersona> getJugAdjuntoPersonaList() {
//		return jugAdjuntoPersonaList;
//	}

//	public void setJugAdjuntoPersonaList(
//			List<JugAdjuntoPersona> jugAdjuntoPersonaList) {
//		this.jugAdjuntoPersonaList = jugAdjuntoPersonaList;
//	}

	@Transient
	public List<JugProhibicion> getProhibicionesNacionales() {
		ArrayList<JugProhibicion> list = new ArrayList<JugProhibicion>();
		for (JugProhibicion jugProhibicion : getJugProhibicionList()) {
			if (jugProhibicion.getJugComunidad().getCodigo().equals("NAC")) {
				list.add(jugProhibicion);
			}
		}
		ordenarProhibiciones(list);
		return list;
	}

	@Transient
	public List<JugProhibicion> getProhibicionesRegistros() {
		ArrayList<JugProhibicion> list = new ArrayList<JugProhibicion>();
		for (JugProhibicion jugProhibicion : getJugProhibicionList()) {
			if (jugProhibicion.getJugComunidad().getCodigo().equals("NAC")) {
				if (jugProhibicion.getJugTipoProhibicion().getCodigo().equals("RGIAJ")) {
					list.add(jugProhibicion);
				}	
				/*if (jugProhibicion.getJugTipoProhibicion().getCodigo().equals("RGPVO")) {
					list.add(jugProhibicion);
				}*/	
			}
		}
		ordenarProhibiciones(list);
		return list;
	}

	
	@Transient
	public List<JugProhibicion> getProhibicionesComunidad() {
		ArrayList<JugProhibicion> list = new ArrayList<JugProhibicion>();
		for (JugProhibicion jugProhibicion : getJugProhibicionList()) {
			if (!jugProhibicion.getJugComunidad().getCodigo().equals("NAC")) {
				list.add(jugProhibicion);
			}
		}
		ordenarProhibiciones(list);
		return list;
	}
	
	public JugProhibicion buscarProhibicionNacionalActiva(JugTipoProhibicion tipo) {
		for (JugProhibicion jugProhibicion: getProhibicionesNacionales()) {
			if (jugProhibicion.getJugSituacion().getTipoSituacion().equals("A")
					&& jugProhibicion.getJugTipoProhibicion().equals(tipo)) {
				return jugProhibicion;
			}
		}
		return null;
	}

	public JugProhibicion buscarUltimaProhibicionNacional(JugTipoProhibicion tipo) {
		JugProhibicion ultimaProhibicion = buscarProhibicionNacionalActiva(tipo);
		if (ultimaProhibicion == null) {
			for (JugProhibicion jugProhibicion: getProhibicionesNacionales()) {
				if (jugProhibicion.getJugTipoProhibicion().equals(tipo)) {
					if (ultimaProhibicion == null || ultimaProhibicion.getFechaSituacion().before(jugProhibicion.getFechaSituacion())) {
						ultimaProhibicion = jugProhibicion;
					}
				}
			}
		}
		return ultimaProhibicion;
	}
	
	private void ordenarProhibiciones(ArrayList<JugProhibicion> list) {
		Collections.sort(list, new ProhibicionesComparator());
	}
	
	@Transient
	public String getNombreCompleto() {
		StringBuilder builder = new StringBuilder();
		builder.append(getNombre());
		if (getApellido1() != null) {
			builder.append(" ").append(getApellido1());
		}
		if (getApellido2() != null) {
			builder.append(" ").append(getApellido2());
		}
		return builder.toString();
	}
	
	
	public Date getOrderLastUpdate() {
		return orderLastUpdate;
	}

	public void setOrderLastUpdate(Date orderLastUpdate) {
		this.orderLastUpdate = orderLastUpdate;
	}

	
	public String getOrderApellido2() {
		return orderApellido2;
	}
	
	public void setOrderApellido2(String orderApellido2) {
		this.orderApellido2 = orderApellido2;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Transient
	public String getEtiquetaProhibicion() {
		StringBuilder builder = new StringBuilder();
		for (JugProhibicion jugProhibicion: getProhibicionesNacionales()) {
			if (jugProhibicion.getJugSituacion().getTipoSituacion().equals("A")) {
				 if (builder.length() > 0) {
					 builder.append(", ");
				 }
				 builder.append(jugProhibicion.getJugTipoProhibicion().getDescripcion());
			}
		}
		return builder.toString();
	}

}
