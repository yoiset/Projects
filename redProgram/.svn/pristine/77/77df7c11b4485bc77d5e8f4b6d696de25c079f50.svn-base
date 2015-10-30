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
 * The persistent class for the M_Escuderias database table.
 * 
 */
@Entity
@Table(name="M_Escuderias")
public class M_Escuderia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private M_EscuderiaPK id;

	@Column(name="Ptos")
	private Integer ptos;

	//bi-directional many-to-one association to Agencia
	@ManyToOne
	@JoinColumn(name="Agencias_id",nullable=false, insertable=false, updatable=false)
	private Agencia agencia;

	//bi-directional many-to-one association to Ej_Fiscal
	@ManyToOne
	@JoinColumn(name="Ej_Fiscal_id",nullable=false, insertable=false, updatable=false)
	private Ej_Fiscal ejFiscal;

	public M_Escuderia() {
	}

	public M_EscuderiaPK getId() {
		return this.id;
	}

	public void setId(M_EscuderiaPK id) {
		this.id = id;
	}

	public Integer getPtos() {
		return this.ptos;
	}

	public void setPtos(Integer ptos) {
		this.ptos = ptos;
	}

	public Agencia getAgencia() {
		return this.agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Ej_Fiscal getEjFiscal() {
		return this.ejFiscal;
	}

	public void setEjFiscal(Ej_Fiscal ejFiscal) {
		this.ejFiscal = ejFiscal;
	}

}