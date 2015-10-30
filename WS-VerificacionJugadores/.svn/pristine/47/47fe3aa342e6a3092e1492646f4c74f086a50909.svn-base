package es.gob.cnjuego.ws.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import es.gob.cnjuego.ws.entity.JugadorTestWS;

public class JugadoresTestDAO {

	private Logger log = Logger.getLogger(JugadoresTestDAO.class);

	@PersistenceContext///(unitName="JohanJPA",type=PersistenceContextType.TRANSACTION)
	EntityManager manager;
		
	public JugadorTestWS obtenerJugadorPrueba(String dni){
		JugadorTestWS jugadorPrueba = null;
		Query query = manager.createQuery("SELECT c FROM JugadorTestWS c where c.dni=:dni");
		query.setParameter("dni", dni);
		List<JugadorTestWS> res = query.getResultList();
		if (res != null && !res.isEmpty())
			{
			jugadorPrueba = (JugadorTestWS)res.iterator().next();
			}
		
		return jugadorPrueba;
	}
	
	
	
		
}
