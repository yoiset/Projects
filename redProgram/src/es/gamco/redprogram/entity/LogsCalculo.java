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
 * The persistent class for the logs_calculo database table.
 * 
 */
@Entity
@Table(name="logs_calculo")
public class LogsCalculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int fecha;

	private String periodoCalculo;

	public LogsCalculo() {
	}

	public int getFecha() {
		return this.fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public String getPeriodoCalculo() {
		return this.periodoCalculo;
	}

	public void setPeriodoCalculo(String periodoCalculo) {
		this.periodoCalculo = periodoCalculo;
	}

}