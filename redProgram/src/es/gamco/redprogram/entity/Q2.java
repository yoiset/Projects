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
 * The persistent class for the Q2 database table.
 * 
 */
@Entity
@Table(name="Q2")
public class Q2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Q2PK id;
	
	@ManyToOne
    @JoinColumn(name="Clasi_Q_id",insertable=false, updatable=false)
	private Clasi_Q clasi_Q;

	public Q2() {
	}

	public Q2PK getId() {
		return this.id;
	}

	public void setId(Q2PK id) {
		this.id = id;
	}

	public Clasi_Q getClasi_Q() {
		return clasi_Q;
	}

	public void setClasi_Q(Clasi_Q clasi_Q) {
		this.clasi_Q = clasi_Q;
	}

}