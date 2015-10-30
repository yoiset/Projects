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

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the Q1 database table.
 * 
 */
@Entity
@Table(name="Q1")
public class Q1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Q1PK id;
	
		
	@ManyToOne
    @JoinColumn(name="Clasi_Q_id",insertable=false, updatable=false)
	private Clasi_Q clasi_Q;

	public Q1() {
	}

	public Q1PK getId() {
		return this.id;
	}

	public void setId(Q1PK id) {
		this.id = id;
	}



	public Clasi_Q getClasi_Q() {
		return clasi_Q;
	}

	public void setClasi_Q(Clasi_Q clasi_Q) {
		this.clasi_Q = clasi_Q;
	}


}