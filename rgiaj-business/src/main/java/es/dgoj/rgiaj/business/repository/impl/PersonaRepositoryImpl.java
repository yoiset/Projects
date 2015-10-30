package es.dgoj.rgiaj.business.repository.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import com.jeveris.persistence.hibernate.repository.impl.HibernateBaseRepositoryImpl;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.PersonaQueryBean;
import es.dgoj.rgiaj.business.model.Persona;
import es.dgoj.rgiaj.business.repository.PersonaRepository;


/**
 * Clase CargoRepositoryImpl
 * @author connectis
 */
@Repository
public class PersonaRepositoryImpl extends HibernateBaseRepositoryImpl<Persona, Long> implements PersonaRepository<Persona, Long>{

	/**
	 * Encuentra los Tipos de Prohibicion que cumplan las condiciones.
	 * @param personaQueryBean 
	 * @return SearchResults<Persona>
	 */
	@Override
	public SearchResults<Persona> getPersonas(PersonaQueryBean personaQueryBean) {

		Criteria crit = getSession().createCriteria(Persona.class, "persona");
		
		if (personaQueryBean.getExpedProhibicion() != null){
			crit.add(Property.forName("persona.expedProhibicion").eq(personaQueryBean.getExpedProhibicion()));	
		}
		
		if (personaQueryBean.getIdPersona() != null){
			crit.add(Property.forName("persona.idPersona").eq(personaQueryBean.getIdPersona()));	
		}

		if (personaQueryBean.getNombre() != null){
			crit.add(Property.forName("persona.nombre").like(personaQueryBean.getNombre(), MatchMode.ANYWHERE).ignoreCase());	
		}		
		
		if (personaQueryBean.getApellido1() != null){
			crit.add(Property.forName("persona.apellido1").like(personaQueryBean.getApellido1(), MatchMode.ANYWHERE).ignoreCase());	
		}			
		
		if (personaQueryBean.getApellido2() != null){
			crit.add(Property.forName("persona.apellido2").like(personaQueryBean.getApellido2(), MatchMode.ANYWHERE).ignoreCase());	
		}	

		if (personaQueryBean.getTipoDocIdent() != null){
			crit.add(Property.forName("persona.tipoDocIdent.id").eq(personaQueryBean.getTipoDocIdent().getId()));	
		}	

		if (personaQueryBean.getNumDocIdent() != null){
			crit.add(Property.forName("persona.numDocIdent").like(personaQueryBean.getNumDocIdent(), MatchMode.ANYWHERE).ignoreCase());	
		}	

		/* Criterios de búsqueda avanzados */
		if (personaQueryBean.getSexo() != null){
			crit.add(Property.forName("persona.sexo").eq(personaQueryBean.getSexo()));	
		}	
		
		if (personaQueryBean.getDomicilio() != null){
			crit.add(Property.forName("persona.domicilio").like(personaQueryBean.getDomicilio(), MatchMode.ANYWHERE).ignoreCase());	
		}	
				
		if (personaQueryBean.getCodPostal() != null){
			crit.add(Property.forName("persona.codPostal").eq(personaQueryBean.getCodPostal()));	
		}	
		
		if (personaQueryBean.getTelefono() != null){
			crit.add(Property.forName("persona.telefono").eq(personaQueryBean.getTelefono()));	
		}	
		
		if (personaQueryBean.getObservaciones() != null){
			crit.add(Property.forName("persona.observaciones").like(personaQueryBean.getObservaciones(), MatchMode.ANYWHERE).ignoreCase());	
		}	
		
		if ((personaQueryBean.getFechaNacimientoDesde() != null) && (personaQueryBean.getFechaNacimientoHasta() != null)){
			crit.add(Property.forName("persona.fechaNacimiento").between(personaQueryBean.getFechaNacimientoDesde(), personaQueryBean.getFechaNacimientoHasta()));	
		}
		
		//Criteria critProvincia = crit.createCriteria("provincia");
		if (personaQueryBean.getProvincia() != null) {
			
			if (personaQueryBean.getProvincia().getId() != null)
				crit.add(Property.forName("persona.provincia.id").eq(personaQueryBean.getProvincia().getId()));	

			if ((personaQueryBean.getProvincia().getComunidad() != null) && (personaQueryBean.getProvincia().getComunidad().getId() != null)){
				crit.createCriteria("provincia").add(Restrictions.eq("comunidadAutonoma.id", personaQueryBean.getProvincia().getComunidad().getId()));  
			}	
		}

		/* Criterios de búsqueda por prohibiciones */

		/* No se cogen las prohibiciones de vinculados (id = 4) */
		Criteria critProhibicion = crit.createCriteria("prohibiciones","prohibicion").add(Restrictions.ne("tipoProhibicion.id", Long.valueOf(4)));
		
		if (personaQueryBean.getIdTipoProhibicion() != null){
			critProhibicion.add(Restrictions.eq("tipoProhibicion.id", personaQueryBean.getIdTipoProhibicion()));
		}
		
		if (personaQueryBean.getIdSituacion() != null){
			critProhibicion.add(Restrictions.eq("situacion.id", personaQueryBean.getIdSituacion()));
		}

		if ((personaQueryBean.getFechaProhibicionDesde() != null) && (personaQueryBean.getFechaProhibicionHasta() != null)){
			critProhibicion.add(Restrictions.between("fechaProhibicion",personaQueryBean.getFechaProhibicionDesde(), personaQueryBean.getFechaProhibicionHasta()));	
		}

		if ((personaQueryBean.getFechaSituacionDesde() != null) && (personaQueryBean.getFechaSituacionHasta() != null)){
			critProhibicion.add(Restrictions.between("fechaSituacion",personaQueryBean.getFechaSituacionDesde(), personaQueryBean.getFechaSituacionHasta()));
		}

		if (personaQueryBean.getIdCausaProhibicion() != null){
			critProhibicion.add(Restrictions.eq("causaProhibicion.id", personaQueryBean.getIdCausaProhibicion()));
		}
		
		if (personaQueryBean.getDuracion() != null){
			critProhibicion.add(Restrictions.eq("duracion", personaQueryBean.getDuracion()));
		}
		
		if (personaQueryBean.getObsProhibicion() != null){
			critProhibicion.add(Restrictions.eq("observaciones", personaQueryBean.getObsProhibicion()));
		}

		/* Criterios para generar Etiquetas Pendientes */
		if (personaQueryBean.getEtiquetasPendientes()){
			crit.add(Property.forName("persona.estadoEtiqueta").eq("NOT_UPDATED"));
			/*critProhibicion.add(Restrictions.eq("tipoProhibicion.codigo", "RGIAJ"));*/
			/*critProhibicion.add(Restrictions.eq("tipoProhibicion.id", Long.valueOf(3)));*/
			critProhibicion.add(Restrictions.eq("comunidad.id", Long.valueOf(871)));
		}

		
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		if (personaQueryBean.getFieldName()!=null && personaQueryBean.getOrder()!=null) {
			if (personaQueryBean.getFieldName().equalsIgnoreCase("lastUpdate")){
				crit.addOrder(Order.desc("lastUpdate"));
			} else if (personaQueryBean.getOrder().equalsIgnoreCase("asc")){
				crit.addOrder(Order.asc(personaQueryBean.getFieldName()));
			} else {
				crit.addOrder(Order.desc(personaQueryBean.getFieldName()));
			} 
		} else if (personaQueryBean.getEtiquetasPendientes()){ 
			crit.addOrder(Order.asc("persona.apellido1"));
			crit.addOrder(Order.asc("persona.apellido2"));
			crit.addOrder(Order.asc("persona.nombre"));	
			crit.addOrder(Order.asc("persona.idPersona"));
		} else {
			crit.addOrder(Order.asc("persona.idPersona"));	
		}
		
		Long numResults = (Long) crit.setProjection(Projections.countDistinct("persona.idPersona")).uniqueResult();
		crit.setProjection(null);
		
		crit.setFirstResult(personaQueryBean.getFirstResult().intValue());
		crit.setMaxResults(personaQueryBean.getMaxResults().intValue());

	    crit.setProjection(Projections.distinct(Projections.projectionList()
	    		.add(Projections.max("prohibicion.lastUpdate"), "lastUpdate")
	    		.add(Projections.property("idPersona"), "idPersona")
	    		.add(Projections.property("expedProhibicion"), "expedProhibicion")
	    		.add(Projections.property("nombre"), "nombre")
	    		.add(Projections.property("apellido1"), "apellido1")
	    		.add(Projections.property("apellido2"), "apellido2")
	    		.add(Projections.property("provincia"), "provincia")
	    		.add(Projections.property("tipoDocIdent"), "tipoDocIdent")
	    		.add(Projections.property("numDocIdent"), "numDocIdent")
	    		.add(Projections.groupProperty("idPersona"))
	    		.add(Projections.groupProperty("expedProhibicion"))
	    		.add(Projections.groupProperty("nombre"))
	    		.add(Projections.groupProperty("apellido1"))
	    		.add(Projections.groupProperty("apellido2"))
	    		.add(Projections.groupProperty("provincia"))
	    		.add(Projections.groupProperty("tipoDocIdent"))
	    		.add(Projections.groupProperty("numDocIdent"))
	    		))
	       .setResultTransformer(new AliasToBeanResultTransformer(Persona.class));
		
		List<Persona> list = crit.list();
		
		SearchResults<Persona> results = new SearchResults<Persona>(list, Long.valueOf(personaQueryBean.getMaxResults()), Long.valueOf(personaQueryBean.getFirstResult()), numResults.longValue());

		return results;
	}

	
	/**
	 * Encuentra un Cargo por su ID.
	 * @param id
	 * @return Cargo
	 */
	@Override
	public Persona getPersonaById(Long id){

		Criteria crit = getSession().createCriteria(Persona.class);
		
		if (id != null){
			crit.add(Property.forName("idPersona").eq(id));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<Persona> list = crit.list();
		
		if (list == null || (list != null && list.isEmpty())){
			return null;	
		} else  { 
			return list.get(0);
		}
		
	}
}
