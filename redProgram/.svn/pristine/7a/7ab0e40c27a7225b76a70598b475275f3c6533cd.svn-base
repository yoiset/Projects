/**
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * %(c) Copyright 2013. GAMCO S.L.
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * % Proyecto: Red Program
 * % Modulo: redProgram Web App
 * % Autor/es: Yoiset Lopez
 * % Fecha: 05/08/2013
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * % Modificaciones (autor, fecha, modificaciones)
 * % <Autor>, <fecha>, <modificaciones>
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * %
 * %  Service Layer. Clase para gestionar los agentes a nivel de servicio
 * %
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 */
package es.gamco.redprogram.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.gamco.redprogram.dao.ResAgenteDAO;
import es.gamco.redprogram.entity.Agente;
import es.gamco.redprogram.entity.Res_Agente_Mes;
import es.gamco.redprogram.entity.Res_Agente_P;
import es.gamco.redprogram.entity.Res_Agente_Semana;
import es.gamco.redprogram.service.calculos.CalculaAgentes;
import es.gamco.redprogram.utilities.Periodo;
import es.gamco.redprogram.utilities.PeriodoCalculo;

@Service("agenteService")
public class AgenteService 
{
	
	/**
	 *  DAO para gestionar Agentes a nivel de BD
	 */
	@Resource
	private ResAgenteDAO resAgenteDAO;
	
	@Autowired
	private AgenciaService agenciaService;


	/**
	 * Referencia al modulo de Calculo de Agentes
	 */
	private CalculaAgentes calculaAgentes;
	
	

	/**
	 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 * %Este método será el invocado desde afuera del servicio por el Backing Bean
	 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 * @param actual
	 * @param pCal
	 * @throws Exception 
	 */
	public void calcularAgentes(Periodo actual, PeriodoCalculo pCal , int instante) throws Exception{
		
		calculaAgentes=new CalculaAgentes(actual, pCal, agenciaService.getAllAgencias(), this);
		calculaAgentes.setCalculos(instante);
	}
	
	
	/**
	 * Persiste una lista de agentes.
	 * Pueden ser de la entidad Res_Agente_Semana, Res_Agente_Mes,
	 * Res_Agente_P
	 * 	
	 */
	@Transactional
	public void updateAgentes(List listaAgentes)
	{
		for (Object entiy : listaAgentes) {
			resAgenteDAO.updateAgente(entiy);
		}
	}
	
	/**
	 * Persiste una lista de agentes.
	 * Pueden ser de la entidad Res_Agente_Semana, Res_Agente_Mes,
	 * Res_Agente_P
	 */
	@Transactional
	public void newAgente(List listaAgentes)
	{
		for (Object entiy : listaAgentes) {
			resAgenteDAO.newAgente(entiy);
		}
	}
	
	
	
	/** Retorna todos los agentes por semana  de una agencia ordenados por Venta_netas_h, dado el ejercicio fiscal,mes, semana y la agencia
	 * @param efiscal
	 * @param mes
	 * @param semana
	 * @param idAgencia
	 * @return
	 */
	public List<Res_Agente_Semana> getListAgenteSemana(int efiscal, int mes, int semana, int idAgencia){
		return resAgenteDAO.getListAgenteSemana(efiscal, mes, semana, idAgencia);
	}
	
	/** Retorna para un agente los agentes semana (del mismo Agente)  de una agencia. Dado el ejercicio fiscal,mes, semana y la agencia
	 * @param efiscal
	 * @param mes
	 * @param idAgente
	 * @param idAgencia
	 * @return
	 */
	public List<Res_Agente_Semana> getListAgenteSemanaAgente(int efiscal, int mes, int idAgente, int idAgencia){
		return resAgenteDAO.getListAgenteSemanaAgente(efiscal, mes, idAgente, idAgencia);
	}
	
	
	/** Retorna el valor mensual de todos los Agentes de una agencia dado el ejercicio fiscal,mes y la agencia.
	 *  Este tambien vale para pedir los del Mes anterior. Ojo hay que controlar el Mes en se está porque puede ocurrir cambio de E Fiscal
	 * @param efiscal
	 * @param mes
	 * @param idAgencia
	 * @return
	 */
	public List<Res_Agente_Mes> getListAgenteMes(int efiscal, int mes, int idAgencia){
		return resAgenteDAO.getListAgenteMes(efiscal, mes, idAgencia);
	}
	

	/** Retorna todos los Agentes que pertenecen a una Agencia
	 * @param idAgencia
	 * @return
	 */
	public List<Agente> getAgentesAgencia(int idAgencia){
		return resAgenteDAO.getAgentesAgencia(idAgencia);
	}
	
	
	/** Retorna todos los Agentes en BD
	 * @return
	 */
	public List<Agente> getAllAgentes(){
		return resAgenteDAO.getAllAgentes();
	}
	
	
	/** Retorna todos los Agentes de un P por Agencia dado el P y el E Fiscal
	 * @param efiscal
	 * @param p
	 * @param idAgencia
	 * @return
	 */
	public List<Res_Agente_P> getAgentesP(int efiscal, int p, int idAgencia){
		return resAgenteDAO.getAgentesP(efiscal, p, idAgencia);
	}
	
	/** Retorna para un Agente todos los P (Res_Agente_P) por Agencia dado el E Fiscal
	 * @param efiscal
	 * @param idAgente
	 * @param idAgencia
	 * @return
	 */
	public List<Res_Agente_P> getAgentesPAgentes(int efiscal, int idAgente){
		return resAgenteDAO.getAgentesPAgentes(efiscal, idAgente);
	}
	
	
	/** Retorna una la lista de todos los Agentes, donde cada elemento Agente contiene la lista llena de  Res_Agentes_P
	 * @param efiscal
	 * @return
	 */
	public List<Agente> getAllPAgentes(int efiscal){
		List<Agente> list=getAllAgentes();
		for (Agente agente : list) {
			agente.setListRes_Agente_P(getAgentesPAgentes(efiscal, agente.getId()));
		}
		
		return list;
	}
	
	/** Retorna la lista de Agentes nuevo en un P por Agencia
	 * @param efiscal
	 * @param p
	 * @param idAgencia
	 * @return
	 */
	public List<Res_Agente_P> getAgentesNuevoP(int efiscal, int p, int idAgencia){
		return resAgenteDAO.getAgentesNuevoP(efiscal, p, idAgencia);
	}
	
	
	/** Retorna todos los Agentes que participan en Carrera en un P de todas las Agencias. Ordenados por ptos_p
	 * @param efiscal
	 * @param p
	 * @return
	 */
	public List<Res_Agente_P> getAgentesParticipanCarreraP(int efiscal, int p){
		return resAgenteDAO.getAgentesParticipanCarreraP(efiscal, p);
	}
	
	
	
}
