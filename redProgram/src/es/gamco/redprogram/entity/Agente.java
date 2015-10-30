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
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the Agentes database table.
 * 
 */
@Entity
@Table(name="Agentes")
public class Agente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	
	@Column(name="Coordinador_id")
	private int coordinador_id;
	
	@JoinColumn(name="Agentes_id", nullable=true)
	private UsuarioWeb usuarioWeb;

    @OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Agencias_id", nullable=true)
	private Agencia agencia;
    
    @OneToMany(mappedBy="agente")    
    private List<Res_Agente_Mes>  listRes_Agente_mes;
    
    @OneToMany(mappedBy="agente")    
    private List<Res_Agente_Semana>  listRes_Agente_semana;
    
    @OneToMany(mappedBy="agente")    
    private List<Res_Agente_P>  listRes_Agente_P;

	public Agente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getCoordinador_id() {
		return this.coordinador_id;
	}
	public void setCoordinador_id(int coordinador_id) {
		this.coordinador_id = coordinador_id;
	}

	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public List<Res_Agente_Mes> getListRes_Agente_mes() {
		return listRes_Agente_mes;
	}

	public void setListRes_Agente_mes(List<Res_Agente_Mes> listRes_Agente_mes) {
		this.listRes_Agente_mes = listRes_Agente_mes;
	}

	public List<Res_Agente_Semana> getListRes_Agente_semana() {
		return listRes_Agente_semana;
	}

	public void setListRes_Agente_semana(
			List<Res_Agente_Semana> listRes_Agente_semana) {
		this.listRes_Agente_semana = listRes_Agente_semana;
	}

	public List<Res_Agente_P> getListRes_Agente_P() {
		return listRes_Agente_P;
	}

	public void setListRes_Agente_P(List<Res_Agente_P> listRes_Agente_P) {
		this.listRes_Agente_P = listRes_Agente_P;
	}

}