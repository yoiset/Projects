/**
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * %(c) Copyright 2013. GAMCO S.L.
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * % Proyecto: Red Program
 * % Modulo: Utilities
 * % Autor/es: Fernando Pavón
 * % Fecha: 07/08/2013
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * % Modificaciones (autor, fecha, modificaciones)
 * % <Autor>, <fecha>, <modificaciones>
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * %
 * %  Clase que guarda el instante o periodo determinado.
 * %	El periodo viene definido por un año fiscal, mes, un P y una
 * %	semana
 * %
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 */

package es.gamco.redprogram.utilities;

/**
 * @author fpavon
 * Se considera que un año tiene 53 semanas, sino tenemos un problema cuando la 
 * 1ª semana del año n+1 tiene días del año n.
 * Esto sucede en diciembre del 2013, donde el 31 y 31 son lunes y martes de la
 * primera semana del 2014.
 */
public class Periodo
{
	/**
	 * El ejercicio fiscal es un número que corresponderá con el id de la tabla 
	 * Ej_Fiscal en la bbdd
	 */
	private int ejFiscal;
	private int mes;
	private int p;
	private int semana;
	
	Periodo (int ejFiscal,int mes,int p,int semana) throws Exception
	{		
		if (mes<1 || mes>12)
		{
			Exception e = new Exception("Mes incorrecto: " + mes);
			throw e;
		}
		if (p<1 || p>6)
		{
			Exception e = new Exception("P incorrecto: " + p);
			throw e;
	   }			
		if (semana<1 || semana>53)
		{
			Exception e = new Exception("Semana incorrecta: " + semana);
			throw e;
		}
		
		this.setEjFiscal(ejFiscal);
		this.setMes(mes);
		this.setP(p);
		this.setSemana(semana);
		
	}

	public int getEjFiscal()
	{
		return ejFiscal;
	}

	private void setEjFiscal(int ejFiscal)
	{
		this.ejFiscal = ejFiscal;
	}

	public int getMes()
	{
		return mes;
	}

	private void setMes(int mes)
	{
		this.mes = mes;
	}

	public int getP()
	{
		return p;
	}

	private void setP(int p)
	{
		this.p = p;
	}

	public int getSemana()
	{
		return semana;
	}

	private void setSemana(int semana)
	{
		this.semana = semana;
	}
}
