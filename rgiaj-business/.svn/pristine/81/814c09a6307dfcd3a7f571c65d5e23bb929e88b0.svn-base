package es.dgoj.rgiaj.business.repository;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.PersonaQueryBean;
import es.dgoj.rgiaj.business.model.Persona;



public interface PersonaRepository<T, ID> extends IHibernateBaseRepository<Persona, Long> {

	/**
	 * Encuentra las Personas que cumplan las condiciones.
	 * @param personaQueryBean 
	 * @return SearchResults<Persona>
	 */
	SearchResults<Persona> getPersonas(PersonaQueryBean personaQueryBean);

	/**
	 * Encuentra una Persona por su ID.
	 * @param id
	 * @return Persona
	 */
	Persona getPersonaById(Long id);
	
}