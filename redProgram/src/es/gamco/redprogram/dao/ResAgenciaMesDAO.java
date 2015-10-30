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
 * %  DAO Layer
 * %
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 */
package es.gamco.redprogram.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import es.gamco.redprogram.entity.Agencia;
import es.gamco.redprogram.entity.Res_Agente_Mes;

@Repository("resAgenciaMesDAO")
public class ResAgenciaMesDAO {
	
	
	/**
	 * Contexto de persistencia
	 */
	@PersistenceContext
	private EntityManager em;
	
	
	/** Devuelve todas las agencias de BD
	 * @return
	 */
	public List<Agencia> getListAgencia(){
		String strQuery="select a from Agencia a";
		List<Agencia> resultList = em.createQuery(strQuery, Agencia.class).getResultList();
		return resultList;		
	}
	
	/** Devuelve yodas las Agencias Mes dado el A�o Fiscal y el Mes
	 * @param idEjFiscal
	 * @param mes
	 * @return
	 */
	public List<Res_Agente_Mes> getListAgenciaMes(int idEjFiscal, int mes){
		String strQuery="select a from Res_Agente_Mes a where a.id.ej_Fiscal_id=:idEjFiscal and a.id.mes=:mes";
		List<Res_Agente_Mes> list = em.createQuery(strQuery,Res_Agente_Mes.class)
				                            .setParameter("idEjFiscal", idEjFiscal) 
				                            .setParameter("mes", mes) 
				                            .getResultList();
		return list;		
	}
	
	/** Actualizar Agencia MEs
	 * @param entity
	 */
	public void updateAgenciaMes(Res_Agente_Mes entity){
		em.merge(entity);
	}
	/** Dar de alta Agencia Mes
	 * @param entity
	 */
	public void addAgenciaMes(Res_Agente_Mes entity){
		em.persist(entity);
	}	
	
	


	public void setEm(EntityManager em) {
		this.em = em;
	}
	

}
