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
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the Ej_Fiscal database table.
 * 
 */
@Entity
public class Ej_Fiscal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_in")
	private Date fechaIn;

	//bi-directional many-to-one association to M_Escuderia
	@OneToMany(mappedBy="ejFiscal")
	private List<M_Escuderia> MEscuderias;

	//bi-directional many-to-one association to Noticia
	@OneToMany(mappedBy="ejFiscal")
	private List<Noticia> noticias;

	//bi-directional many-to-one association to Res_Agencia_Mes
	@OneToMany(mappedBy="ejFiscal")
	private List<Res_Agencia_Mes> resAgenciaMes;

	//bi-directional many-to-one association to Res_Agencia_P
	@OneToMany(mappedBy="ejFiscal")
	private List<Res_Agencia_P> resAgenciaPs;
	
	
	@OneToMany(mappedBy="ejFiscal")
	private List<Res_Agente_Mes> resAgenteMesList;
	
	@OneToMany(mappedBy="ejFiscal")
	private List<Res_Agente_Semana> resAgenteSemanaList;

	//bi-directional many-to-one association to LogsCarga
	@OneToMany(mappedBy="ejFiscal")
	private List<LogsCarga> logsCargas;

	public Ej_Fiscal() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaIn() {
		return this.fechaIn;
	}

	public void setFechaIn(Date fechaIn) {
		this.fechaIn = fechaIn;
	}

	public List<M_Escuderia> getMEscuderias() {
		return this.MEscuderias;
	}

	public void setMEscuderias(List<M_Escuderia> MEscuderias) {
		this.MEscuderias = MEscuderias;
	}

	public M_Escuderia addMEscuderia(M_Escuderia MEscuderia) {
		getMEscuderias().add(MEscuderia);
		MEscuderia.setEjFiscal(this);

		return MEscuderia;
	}

	public M_Escuderia removeMEscuderia(M_Escuderia MEscuderia) {
		getMEscuderias().remove(MEscuderia);
		MEscuderia.setEjFiscal(null);

		return MEscuderia;
	}

	public List<Noticia> getNoticias() {
		return this.noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public Noticia addNoticia(Noticia noticia) {
		getNoticias().add(noticia);
		noticia.setEjFiscal(this);

		return noticia;
	}

	public Noticia removeNoticia(Noticia noticia) {
		getNoticias().remove(noticia);
		noticia.setEjFiscal(null);

		return noticia;
	}

	public List<Res_Agencia_Mes> getResAgenciaMes() {
		return this.resAgenciaMes;
	}

	public void setResAgenciaMes(List<Res_Agencia_Mes> resAgenciaMes) {
		this.resAgenciaMes = resAgenciaMes;
	}

	public Res_Agencia_Mes addResAgenciaMe(Res_Agencia_Mes resAgenciaMe) {
		getResAgenciaMes().add(resAgenciaMe);
		resAgenciaMe.setEjFiscal(this);

		return resAgenciaMe;
	}

	public Res_Agencia_Mes removeResAgenciaMe(Res_Agencia_Mes resAgenciaMe) {
		getResAgenciaMes().remove(resAgenciaMe);
		resAgenciaMe.setEjFiscal(null);

		return resAgenciaMe;
	}

	public List<Res_Agencia_P> getResAgenciaPs() {
		return this.resAgenciaPs;
	}

	public void setResAgenciaPs(List<Res_Agencia_P> resAgenciaPs) {
		this.resAgenciaPs = resAgenciaPs;
	}

	public Res_Agencia_P addResAgenciaP(Res_Agencia_P resAgenciaP) {
		getResAgenciaPs().add(resAgenciaP);
		resAgenciaP.setEjFiscal(this);

		return resAgenciaP;
	}

	public Res_Agencia_P removeResAgenciaP(Res_Agencia_P resAgenciaP) {
		getResAgenciaPs().remove(resAgenciaP);
		resAgenciaP.setEjFiscal(null);

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
		logsCarga.setEjFiscal(this);

		return logsCarga;
	}

	public LogsCarga removeLogsCarga(LogsCarga logsCarga) {
		getLogsCargas().remove(logsCarga);
		logsCarga.setEjFiscal(null);

		return logsCarga;
	}

	public List<Res_Agente_Mes> getResAgenteMesList() {
		return resAgenteMesList;
	}

	public void setResAgenteMesList(List<Res_Agente_Mes> resAgenteMesList) {
		this.resAgenteMesList = resAgenteMesList;
	}

	public List<Res_Agente_Semana> getResAgenteSemanaList() {
		return resAgenteSemanaList;
	}

	public void setResAgenteSemanaList(List<Res_Agente_Semana> resAgenteSemanaList) {
		this.resAgenteSemanaList = resAgenteSemanaList;
	}

}