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
 * The persistent class for the Clasi_Q database table.
 * 
 */
@Entity
@Table(name="Clasi_Q")
public class Clasi_Q implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String tipo;
	
	@OneToMany
	@JoinColumn(name="Clasi_Q_id")
	private List<Q1>  q1List;
	
	@OneToMany
	@JoinColumn(name="Clasi_Q_id")
	private List<Q2>  q2List;
	
	@OneToMany
	@JoinColumn(name="Clasi_Q_id")
	private List<Q3>  q3List;


	
	public Clasi_Q() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Q1> getQ1List() {
		return q1List;
	}

	public void setQ1List(List<Q1> q1List) {
		this.q1List = q1List;
	}

	public List<Q2> getQ2List() {
		return q2List;
	}

	public void setQ2List(List<Q2> q2List) {
		this.q2List = q2List;
	}

	public List<Q3> getQ3List() {
		return q3List;
	}

	public void setQ3List(List<Q3> q3List) {
		this.q3List = q3List;
	}



}