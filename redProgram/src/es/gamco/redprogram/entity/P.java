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
import java.util.List;


/**
 * The persistent class for the P database table.
 * 
 */
@Table(name="P")
@Entity
public class P implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String meses;

	//bi-directional many-to-one association to Res_Agencia_P
	@OneToMany(mappedBy="p")
	private List<Res_Agencia_P> resAgenciaPs;
	
	@OneToMany(mappedBy="p")
	private List<Res_Agente_P> resAgenteP;

	//bi-directional many-to-one association to LogsCarga
	@OneToMany(mappedBy="p")
	private List<LogsCarga> logsCargas;

	public P() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMeses() {
		return this.meses;
	}

	public void setMeses(String meses) {
		this.meses = meses;
	}

	public List<Res_Agencia_P> getResAgenciaPs() {
		return this.resAgenciaPs;
	}

	public void setResAgenciaPs(List<Res_Agencia_P> resAgenciaPs) {
		this.resAgenciaPs = resAgenciaPs;
	}

	public Res_Agencia_P addResAgenciaP(Res_Agencia_P resAgenciaP) {
		getResAgenciaPs().add(resAgenciaP);
		resAgenciaP.setP(this);

		return resAgenciaP;
	}

	public Res_Agencia_P removeResAgenciaP(Res_Agencia_P resAgenciaP) {
		getResAgenciaPs().remove(resAgenciaP);
		resAgenciaP.setP(null);

		return resAgenciaP;
	}

	public List<LogsCarga> getLogsCargas() {
		return this.logsCargas;
	}

	public void setLogsCargas(List<LogsCarga> logsCargas) {
		this.logsCargas = logsCargas;
	}

	public LogsCarga addLogsCarga(LogsCarga logsCarga) {
		getLogsCargas().add(logsCarga);
		logsCarga.setP(this);

		return logsCarga;
	}

	public LogsCarga removeLogsCarga(LogsCarga logsCarga) {
		getLogsCargas().remove(logsCarga);
		logsCarga.setP(null);

		return logsCarga;
	}

	public List<Res_Agente_P> getResAgenteP() {
		return resAgenteP;
	}

	public void setResAgenteP(List<Res_Agente_P> resAgenteP) {
		this.resAgenteP = resAgenteP;
	}

}