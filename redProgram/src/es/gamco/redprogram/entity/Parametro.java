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
import javax.persistence.*;


/**
 * The persistent class for the Parametros database table.
 * 
 */
@Entity
@Table(name="Parametros")
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="Calidad_mes_lim")
	private Integer calidad_mes_lim;

	@Column(name="Calidad_mes_ventas_min")
	private Integer calidad_mes_ventas_min;

	@Column(name="Calidad_P_lim")
	private Integer calidad_P_lim;

	@Column(name="Calidad_P_ventas_min")
	private Integer calidad_P_ventas_min;

	@Column(name="Convergencia_mes_lim")
	private Integer convergencia_mes_lim;

	@Column(name="Convergencia_mes_ventas_min")
	private Integer convergencia_mes_ventas_min;

	@Column(name="Convergencia_P_ventas_min")
	private Integer convergencia_P_ventas_min;

	@Column(name="Q1_inf")
	private float q1_inf;

	@Column(name="Q1_sup")
	private float q1_sup;

	@Column(name="Q2_inf")
	private float q2_inf;

	@Column(name="Q2_sup")
	private Integer q2_sup;

	@Column(name="Q3_inf")
	private Integer q3_inf;

	@Column(name="Q3_sup")
	private Integer q3_sup;

	public Parametro() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getCalidad_mes_lim() {
		return this.calidad_mes_lim;
	}

	public void setCalidad_mes_lim(Integer calidad_mes_lim) {
		this.calidad_mes_lim = calidad_mes_lim;
	}

	public Integer getCalidad_mes_ventas_min() {
		return this.calidad_mes_ventas_min;
	}

	public void setCalidad_mes_ventas_min(Integer calidad_mes_ventas_min) {
		this.calidad_mes_ventas_min = calidad_mes_ventas_min;
	}

	public Integer getCalidad_P_lim() {
		return this.calidad_P_lim;
	}

	public void setCalidad_P_lim(Integer calidad_P_lim) {
		this.calidad_P_lim = calidad_P_lim;
	}

	public Integer getCalidad_P_ventas_min() {
		return this.calidad_P_ventas_min;
	}

	public void setCalidad_P_ventas_min(Integer calidad_P_ventas_min) {
		this.calidad_P_ventas_min = calidad_P_ventas_min;
	}

	public Integer getConvergencia_mes_lim() {
		return this.convergencia_mes_lim;
	}

	public void setConvergencia_mes_lim(Integer convergencia_mes_lim) {
		this.convergencia_mes_lim = convergencia_mes_lim;
	}

	public Integer getConvergencia_mes_ventas_min() {
		return this.convergencia_mes_ventas_min;
	}

	public void setConvergencia_mes_ventas_min(Integer convergencia_mes_ventas_min) {
		this.convergencia_mes_ventas_min = convergencia_mes_ventas_min;
	}

	public Integer getConvergencia_P_ventas_min() {
		return this.convergencia_P_ventas_min;
	}

	public void setConvergencia_P_ventas_min(Integer convergencia_P_ventas_min) {
		this.convergencia_P_ventas_min = convergencia_P_ventas_min;
	}

	public float getQ1_inf() {
		return this.q1_inf;
	}

	public void setQ1_inf(Integer q1_inf) {
		this.q1_inf = q1_inf;
	}

	public float getQ1_sup() {
		return this.q1_sup;
	}

	public void setQ1_sup(Integer q1_sup) {
		this.q1_sup = q1_sup;
	}

	public float getQ2_inf() {
		return this.q2_inf;
	}

	public void setQ2_inf(Integer q2_inf) {
		this.q2_inf = q2_inf;
	}

	public Integer getQ2_sup() {
		return this.q2_sup;
	}

	public void setQ2_sup(Integer q2_sup) {
		this.q2_sup = q2_sup;
	}

	public Integer getQ3_inf() {
		return this.q3_inf;
	}

	public void setQ3_inf(Integer q3_inf) {
		this.q3_inf = q3_inf;
	}

	public Integer getQ3_sup() {
		return this.q3_sup;
	}

	public void setQ3_sup(Integer q3_sup) {
		this.q3_sup = q3_sup;
	}

}