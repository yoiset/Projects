/**
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * %(c) Copyright 2007. GAMCO S.L.
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * % Proyecto: Red Program
 * % Modulo: redProgram Web App
 * % Autor/es: Yoiset Lopez<nombre>
 * % Fecha: 05/08/2013
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * % Modificaciones (autor, fecha, modificaciones)
 * % <Autor>, <fecha>, <modificaciones>
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * %
 * %  The persistence class module
 * %
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 */
package es.gamco.redprogram.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="UsuarioWeb")
public class UsuarioWeb implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
//	@Column(name="Agentes_id")
//	private Integer agentes_id;
	
	@OneToOne(mappedBy="usuarioWeb", fetch=FetchType.EAGER)
	private Agente agente;
	
	@Column(name="Coordinador_id")
	private Integer coordinador_id;
	
//	@Column(name="Agencias_id")
//	private Integer agencias_id;
	@OneToOne(mappedBy="usuarioWeb", fetch=FetchType.EAGER)
	private Agencia agencia;
	
//	@Column(name="Tipo_Usuario_id")
//	private Integer tipo_Usuario_id;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Tipo_Usuario_id")
	private Tipo_Usuario tipoUSuario;
		
	@Column(name="login")
	private String login;
	
	@Column(name="pass")
	private String pass;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getCoordinador_id() {
		return coordinador_id;
	}

	public void setCoordinador_id(Integer coordinador_id) {
		this.coordinador_id = coordinador_id;
	}

	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Tipo_Usuario getTipoUSuario() {
		return tipoUSuario;
	}

	public void setTipoUSuario(Tipo_Usuario tipoUSuario) {
		this.tipoUSuario = tipoUSuario;
	}

}
