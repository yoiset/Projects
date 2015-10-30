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
 * The primary key class for the Res_Agencia_Mes database table.
 * 
 */
@Embeddable
public class Res_Agencia_MesPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="Agencias_id")
	private int agencias_id;

	@Column(name="Ej_Fiscal_id")
	private byte ej_Fiscal_id;

	@Column(name="mes")
	private int mes;

	public Res_Agencia_MesPK() {
	}
	public int getAgencias_id() {
		return this.agencias_id;
	}
	public void setAgencias_id(int agencias_id) {
		this.agencias_id = agencias_id;
	}
	public byte getEj_Fiscal_id() {
		return this.ej_Fiscal_id;
	}
	public void setEj_Fiscal_id(byte ej_Fiscal_id) {
		this.ej_Fiscal_id = ej_Fiscal_id;
	}
	public int getMes() {
		return this.mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Res_Agencia_MesPK)) {
			return false;
		}
		Res_Agencia_MesPK castOther = (Res_Agencia_MesPK)other;
		return 
			(this.agencias_id == castOther.agencias_id)
			&& (this.ej_Fiscal_id == castOther.ej_Fiscal_id)
			&& (this.mes == castOther.mes);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.agencias_id;
		hash = hash * prime + ((int) this.ej_Fiscal_id);
		hash = hash * prime + ((int) this.mes);
		
		return hash;
	}
}