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
@Table(name="Res_Agente_Mes")
public class Res_Agente_Mes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private Res_Agente_MesPK id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Agentes_id", nullable=false, insertable=false,updatable=false)
	private Agente agente;	
	
	@ManyToOne
	@JoinColumn(name="Ej_Fiscal_id", nullable=false, insertable=false, updatable=false)
	private Ej_Fiscal ejFiscal;
	
	@Column(name="Ptos")
	private Integer puntos;
	
	@Column(name="Calidad")
	private Integer calidad;
	
	@Column(name="Convergencia")
	private Integer convergencia;
	
	@Column(name="Revelacion")
	private Boolean revelacion;

	public Res_Agente_MesPK getId() {
		return id;
	}

	public void setId(Res_Agente_MesPK id) {
		this.id = id;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public Integer getCalidad() {
		return calidad;
	}

	public void setCalidad(Integer calidad) {
		this.calidad = calidad;
	}

	public Integer getCorvengencia() {
		return convergencia;
	}

	public void setCorvengencia(Integer corvengencia) {
		this.convergencia = corvengencia;
	}

	public Boolean isRevelacion() {
		return revelacion;
	}

	public void setRevelacion(Boolean revelacion) {
		this.revelacion = revelacion;
	}
	
	/**
	 * Este metodo calcula los campos calculables de esta entidad
	 */
	public void autoCalcular(){
		
	}
    
}
