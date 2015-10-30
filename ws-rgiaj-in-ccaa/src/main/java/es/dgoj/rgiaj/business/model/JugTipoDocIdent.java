package es.dgoj.rgiaj.business.model;

// Generated by Expand 2.2.0 

//import com.transtools.expand.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author ylopezconnectis
 *
 */
@Entity
@Table(name = "JUG_TIPO_DOC_IDENT")
public class JugTipoDocIdent implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "CODIGO")
	private String codigo;
	
	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;
	
	@Column(name = "ACTIVO", nullable = false)
	private Integer activo;

	//	private List<JugEmpresa> jugEmpresaList = new ArrayList<JugEmpresa>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jugTipoDocIdent")
	private List<JugPersona> jugPersonaList = new ArrayList<JugPersona>(0);

	public JugTipoDocIdent() {
	}

	public JugTipoDocIdent(Long id, String descripcion, Integer activo) {
		this.id = id;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public JugTipoDocIdent(Long id, String codigo, String descripcion,
			Integer activo, /*List<JugEmpresa> jugEmpresaList,*/
			List<JugPersona> jugPersonaList) {
		this.id = id;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.activo = activo;
//		this.jugEmpresaList = jugEmpresaList;
		this.jugPersonaList = jugPersonaList;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getActivo() {
		return this.activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jugTipoDocIdent")
//	public List<JugEmpresa> getJugEmpresaList() {
//		return this.jugEmpresaList;
//	}
//
//	public void setJugEmpresaList(List<JugEmpresa> jugEmpresaList) {
//		this.jugEmpresaList = jugEmpresaList;
//	}

	
	public List<JugPersona> getJugPersonaList() {
		return this.jugPersonaList;
	}

	public void setJugPersonaList(List<JugPersona> jugPersonaList) {
		this.jugPersonaList = jugPersonaList;
	}

}