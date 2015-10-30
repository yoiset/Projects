package es.dgoj.rgiaj.business.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.jeveris.persistence.hibernate.repository.impl.HibernateBaseRepositoryImpl;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.SituacionQueryBean;
import es.dgoj.rgiaj.business.model.Situacion;
import es.dgoj.rgiaj.business.repository.SituacionRepository;


/**
 * Clase SituacionRepositoryImpl
 * @author connectis
 */
@Repository
public class SituacionRepositoryImpl extends HibernateBaseRepositoryImpl<Situacion, Long> implements SituacionRepository<Situacion, Long>{

	/**
	 * Encuentra las situaciones que cumplan las condiciones.
	 * @param situacionQueryBean 
	 * @return SearchResults<Situacion>
	 */
	@Override
	public SearchResults<Situacion> getSituaciones(SituacionQueryBean situacionQueryBean) {

		Criteria crit = getSession().createCriteria(Situacion.class);
		
		if (situacionQueryBean.getId() != null){
			crit.add(Property.forName("id").eq(situacionQueryBean.getId()));	
		}

		if (situacionQueryBean.getCodigo() != null){
			crit.add(Property.forName("codigo").like(situacionQueryBean.getCodigo(), MatchMode.ANYWHERE).ignoreCase());	
		}		
		
		if (situacionQueryBean.getDescripcion() != null){
			crit.add(Property.forName("nombre").like(situacionQueryBean.getDescripcion(), MatchMode.ANYWHERE).ignoreCase());	
		}			
		
		if (situacionQueryBean.getActivo() != null){
			crit.add(Property.forName("activo").eq(situacionQueryBean.getActivo()?"true":"false"));	
		}	
		
		if (situacionQueryBean.getTipoSituacion() != null){
			crit.add(Property.forName("tipoSituacion").eq(situacionQueryBean.getTipoSituacion()));	
		}
		
		if (situacionQueryBean.getSituacionMaq() != null){
			crit.add(Property.forName("situacionMaq").eq(situacionQueryBean.getSituacionMaq()));	
		}
		if (situacionQueryBean.getSituacionEmp() != null){
			crit.add(Property.forName("situacionEmp").eq(situacionQueryBean.getSituacionEmp()));	
		}
		if (situacionQueryBean.getSituacionLocal() != null){
			crit.add(Property.forName("situacionLocal").eq(situacionQueryBean.getSituacionLocal()));	
		}
		if (situacionQueryBean.getSituacionPersona() != null){
			crit.add(Property.forName("situacionPersona").eq(situacionQueryBean.getSituacionPersona()));	
		}
		if (situacionQueryBean.getSituacionModelo() != null){
			crit.add(Property.forName("situacionModelo").eq(situacionQueryBean.getSituacionModelo()));	
		}
		
		if (situacionQueryBean.getFieldName()!=null && situacionQueryBean.getOrder()!=null) {
			if (situacionQueryBean.getOrder().equalsIgnoreCase("asc")){
				crit.addOrder(Order.asc(situacionQueryBean.getFieldName()));
			} else {
				crit.addOrder(Order.desc(situacionQueryBean.getFieldName()));
			}
		} else {
			crit.addOrder(Order.asc("id"));	
		}
		
		Long numResults = (Long) crit.setProjection(Projections.rowCount()).uniqueResult();
		crit.setProjection(null);

		crit.setFirstResult(situacionQueryBean.getFirstResult().intValue());
		crit.setMaxResults(situacionQueryBean.getMaxResults().intValue());
		
		List<Situacion> list = crit.list();
		
		SearchResults<Situacion> results = new SearchResults<Situacion>(list, Long.valueOf(situacionQueryBean.getMaxResults()), Long.valueOf(situacionQueryBean.getFirstResult()), numResults.longValue());

		return results;
	}

	
	/**
	 * Encuentra una Situacion por su ID.
	 * @param id
	 * @return Situacion
	 */
	@Override
	public Situacion getSituacionById(Long id){

		Criteria crit = getSession().createCriteria(Situacion.class);
		
		if (id != null){
			crit.add(Property.forName("id").eq(id));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<Situacion> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Encuentra una Situacion por su Codigo.
	 * @param codigo
	 * @return Situacion
	 */
	@Override	
	public Situacion getSituacionByCodigo(String codigo){

		Criteria crit = getSession().createCriteria(Situacion.class);
		
		if (codigo != null){
			crit.add(Property.forName("codigo").eq(codigo));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<Situacion> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Devuelve una Situacion por su codigo que no tenga un Id.
	 * @param id
	 * @param codigo
	 * @return Situacion
	 */
	@Override	
	public Situacion getSituacionByCodigoNoID(Long id, String codigo){

		Criteria crit = getSession().createCriteria(Situacion.class);
		
		if (codigo != null){
			crit.add(Property.forName("codigo").eq(codigo));	
		} else {
			return null;
		}
		
		if (id != null){
			crit.add(Property.forName("id").ne(id));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<Situacion> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Baja de una Situacion.
	 * @param id
	 * @return true, en caso de exito
	 */
	@Override
	public boolean deleteSituacion(Long id){
		
		Situacion tipo = getSituacionById(id);
		
		this.remove(tipo);
		
		tipo = getSituacionById(id);
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Edicion de una Situacion.
	 * @param situacion
	 * @return true, en caso de exito
	 */
	@Override
	public boolean updateSituacion(Situacion situacion){
		
		getSession().merge(situacion);
		
		Situacion tipo = getSituacionById(situacion.getId());
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Alta de una Situacion.
	 * @param situacion
	 * @return true, en caso de exito
	 */
	@Override
	public boolean addSituacion(Situacion situacion){
		
		getSession().save(situacion);
		
		Situacion tipo = getSituacionById(situacion.getId());
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
}
