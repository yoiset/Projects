/**
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * %(c) Copyright 2013. GAMCO S.L.
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * % Proyecto: Red Program
 * % Modulo: Calculos
 * % Autor/es: Fernando Pavón
 * % Fecha: 07/08/2013
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * % Modificaciones (autor, fecha, modificaciones)
 * % <Autor>, <fecha>, <modificaciones>
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * %
 * %  Clase que calcula los campos calculables de la tabla 
 * %	"Res_Agente_Semana"
 * %	En este caso sólo: "Ptos"
 * %	El otro campo calculable: "Ventas_netas_h" se hace implícitamente
 * %	en la entidad.
 * %
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 */
package es.gamco.redprogram.service.calculos;

import java.util.Iterator;
import java.util.List;

import es.gamco.redprogram.entity.Res_Agente_Semana;

/**
 * @author fpavon
 *
 */
public class CalculaAgenteSemana
{
	/**
	 * Calcula el campo Ptos.
	 * Ojo se supone que la lista de agentes viene ordenada, no se comprueba.
	 * 
	 * @param agentesOrdenados Lista de agentes ordenados descendentemente 
	 * por el campo ventas_netas_h
	 * 
	 */
	public void calculaPtos (List<Res_Agente_Semana> agentesOrdenados)
	{
		Iterator<Res_Agente_Semana> iAgente = agentesOrdenados.iterator();
		Res_Agente_Semana agente;
		
		int posicion = 1; 
		while (iAgente.hasNext())
		{
			agente = iAgente.next();
			switch(posicion)
			{
			case 1: // 3 puntos 
				agente.setPuntos(3);
				break;
			case 2: // 2 puntos
				agente.setPuntos(2);
				break;
			case 3: // 1 punto
				agente.setPuntos(1);
				break;
			default: // 0 puntos
				agente.setPuntos(0);					
			}
			posicion++;
		}		
	}	
}
