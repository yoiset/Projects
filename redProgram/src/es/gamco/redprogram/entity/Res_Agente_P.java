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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Res_Agente_P")
public class Res_Agente_P implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private Res_Agente_PPK id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Agentes_id", nullable=false, insertable=false, updatable=false)
	private Agente agente;	
	
	@ManyToOne
	@JoinColumn(name="Ej_Fiscal_id", nullable=false, insertable=false, updatable=false)
	private Ej_Fiscal ejFiscal;
	
	@ManyToOne
	@JoinColumn(name="P_id",nullable=false, insertable=false, updatable=false)
	private P p;
	
	@Column(name="Ptos_P")
	private int puntos_p;
	
	@Column(name="Participa_carrera")
	private Boolean participa_carrera;
	
	@Column(name="Ventas_netas_h")
	private float ventas_netas_h;
	
	@Column(name="Ptos_Mundial")
	private int ptos_Mundial;
	
	@Column(name="Calidad")
	private int calidad;
	
	@Column(name="Convergencia")
	private int convergencia;
	
	@Column(name="Agente_nuevo")
	private boolean agente_nuevo;
	
	@Column(name="Revelacion")
	private Boolean revelacion;
	
	@Column(name="Ventas_netas")
	private Float ventas_netas;

	
	
	
	public Res_Agente_PPK getId() {
		return id;
	}

	public void setId(Res_Agente_PPK id) {
		this.id = id;
	}

	public int getPuntos_p() {
		return puntos_p;
	}

	public void setPuntos_p(int puntos_p) {
		this.puntos_p = puntos_p;
	}

	public Boolean isParticipa_carrera() {
		return participa_carrera;
	}

	public void setParticipa_carrera(Boolean participa_carrera) {
		this.participa_carrera = participa_carrera;
	}

	public float getVentas_netas_h() {
		return ventas_netas_h;
	}

	public void setVentas_netas_h(float ventas_netas_h) {
		this.ventas_netas_h = ventas_netas_h;
	}

	public int getPtos_Mundial() {
		return ptos_Mundial;
	}

	public void setPtos_Mundial(int ptos_Mundial) {
		this.ptos_Mundial = ptos_Mundial;
	}

	public int getCalidad() {
		return calidad;
	}

	public void setCalidad(int calidad) {
		this.calidad = calidad;
	}

	public int getConvergencia() {
		return convergencia;
	}

	public void setConvergencia(int convergencia) {
		this.convergencia = convergencia;
	}

	public boolean isAgente_nuevo() {
		return agente_nuevo;
	}

	public void setAgente_nuevo(boolean agente_nuevo) {
		this.agente_nuevo = agente_nuevo;
	}

	public Boolean isRevelacion() {
		return revelacion;
	}

	public void setRevelacion(Boolean revelacion) {
		this.revelacion = revelacion;
	}

	public P getP() {
		return p;
	}

	public void setP(P p) {
		this.p = p;
	}

	public Float getVentas_netas() {
		return ventas_netas;
	}

	public void setVentas_netas(Float ventas_netas) {
		this.ventas_netas = ventas_netas;
	}
	
	

}
