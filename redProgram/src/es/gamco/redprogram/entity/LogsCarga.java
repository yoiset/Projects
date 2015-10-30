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
import java.util.Date;


/**
 * The persistent class for the logs_carga database table.
 * 
 */
@Entity
@Table(name="logs_carga")
public class LogsCarga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Integer nRegistros;

	@Column(name="Periodo_mes")
	private Integer periodo_mes;

	@Column(name="Periodo_semana")
	private Integer periodo_semana;

	//bi-directional many-to-one association to Ej_Fiscal
	@ManyToOne
	@JoinColumn(name="Ej_Fiscal_id", nullable=false)
	private Ej_Fiscal ejFiscal;

	//bi-directional many-to-one association to P
	@ManyToOne
	@JoinColumn(name="P_id")
	private P p;

	public LogsCarga() {
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getNRegistros() {
		return this.nRegistros;
	}

	public void setNRegistros(Integer nRegistros) {
		this.nRegistros = nRegistros;
	}

	public Integer getPeriodo_mes() {
		return this.periodo_mes;
	}

	public void setPeriodo_mes(Integer periodo_mes) {
		this.periodo_mes = periodo_mes;
	}

	public Integer getPeriodo_semana() {
		return this.periodo_semana;
	}

	public void setPeriodo_semana(Integer periodo_semana) {
		this.periodo_semana = periodo_semana;
	}

	public Ej_Fiscal getEjFiscal() {
		return this.ejFiscal;
	}

	public void setEjFiscal(Ej_Fiscal ejFiscal) {
		this.ejFiscal = ejFiscal;
	}

	public P getP() {
		return this.p;
	}

	public void setP(P p) {
		this.p = p;
	}

}