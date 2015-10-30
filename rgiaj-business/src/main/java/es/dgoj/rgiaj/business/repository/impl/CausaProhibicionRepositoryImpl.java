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

import es.dgoj.rgiaj.business.beans.CausaProhibicionQueryBean;
import es.dgoj.rgiaj.business.model.CausaProhibicion;
import es.dgoj.rgiaj.business.repository.CausaProhibicionRepository;


/**
 * Clase CausaProhibicionRepositoryImpl
 * @author connectis
 */
@Repository
public class CausaProhibicionRepositoryImpl extends HibernateBaseRepositoryImpl<CausaProhibicion, Long> implements CausaProhibicionRepository<CausaProhibicion, Long>{

	/**
	 * Encuentra las Causas de Prohibicion que cumplan las condiciones.
	 * @param causaProhibicionQueryBean 
	 * @return SearchResults<CausaProhibicion>
	 */
	@Override
	public SearchResults<CausaProhibicion> getCausasProhibicion(CausaProhibicionQueryBean causaProhibicionQueryBean) {

		Criteria crit = getSession().createCriteria(CausaProhibicion.class);
		
		if (causaProhibicionQueryBean.getId() != null){
			crit.add(Property.forName("id").eq(causaProhibicionQueryBean.getId()));	
		}

		if (causaProhibicionQueryBean.getCodigo() != null){
			crit.add(Property.forName("codigo").like(causaProhibicionQueryBean.getCodigo(), MatchMode.ANYWHERE).ignoreCase());	
		}		
		
		if (causaProhibicionQueryBean.getDescripcion() != null){
			crit.add(Property.forName("nombre").like(causaProhibicionQueryBean.getDescripcion(), MatchMode.ANYWHERE).ignoreCase());	
		}			
		
		if (causaProhibicionQueryBean.getActivo() != null){
			crit.add(Property.forName("activo").eq(causaProhibicionQueryBean.getActivo()?"true":"false"));	
		}	
		
		
		if (causaProhibicionQueryBean.getFieldName()!=null && causaProhibicionQueryBean.getOrder()!=null) {
			if (causaProhibicionQueryBean.getOrder().equalsIgnoreCase("asc")){
				crit.addOrder(Order.asc(causaProhibicionQueryBean.getFieldName()));
			} else {
				crit.addOrder(Order.desc(causaProhibicionQueryBean.getFieldName()));
			}
		} else {
			crit.addOrder(Order.asc("id"));	
		}
		
		Long numResults = (Long) crit.setProjection(Projections.rowCount()).uniqueResult();
		crit.setProjection(null);

		crit.setFirstResult(causaProhibicionQueryBean.getFirstResult().intValue());
		crit.setMaxResults(causaProhibicionQueryBean.getMaxResults().intValue());
		
		List<CausaProhibicion> list = crit.list();
		
		SearchResults<CausaProhibicion> results = new SearchResults<CausaProhibicion>(list, Long.valueOf(causaProhibicionQueryBean.getMaxResults()), Long.valueOf(causaProhibicionQueryBean.getFirstResult()), numResults.longValue());

		return results;
	}

	
	/**
	 * Encuentra una Causa de Prohibicion por su ID.
	 * @param id
	 * @return CausaProhibicion
	 */
	@Override
	public CausaProhibicion getCausaProhibicionById(Long id){

		Criteria crit = getSession().createCriteria(CausaProhibicion.class);
		
		if (id != null){
			crit.add(Property.forName("id").eq(id));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<CausaProhibicion> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Encuentra una Causa de Prohibicion por su Codigo.
	 * @param codigo
	 * @return CausaProhibicion
	 */
	@Override	
	public CausaProhibicion getCausaProhibicionByCodigo(String codigo){

		Criteria crit = getSession().createCriteria(CausaProhibicion.class);
		
		if (codigo != null){
			crit.add(Property.forName("codigo").eq(codigo));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<CausaProhibicion> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Devuelve una Causa de Prohibicion por su codigo que no tenga un Id.
	 * @param id
	 * @param codigo
	 * @return CausaProhibicion
	 */
	@Override	
	public CausaProhibicion getCausaProhibicionByCodigoNoID(Long id, String codigo){

		Criteria crit = getSession().createCriteria(CausaProhibicion.class);
		
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
		
		List<CausaProhibicion> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Baja de una Causa de Prohibicion.
	 * @param id
	 * @return true, en caso de exito
	 */
	@Override
	public boolean deleteCausaProhibicion(Long id){
		
		CausaProhibicion tipo = getCausaProhibicionById(id);
		
		this.remove(tipo);
		
		tipo = getCausaProhibicionById(id);
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Edicion de una Causa de Prohibicion.
	 * @param causaProhibicion
	 * @return true, en caso de exito
	 */
	@Override
	public boolean updateCausaProhibicion(CausaProhibicion causaProhibicion){
		
		getSession().merge(causaProhibicion);
		
		CausaProhibicion tipo = getCausaProhibicionById(causaProhibicion.getId());
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Alta de una Causa de Prohibicion.
	 * @param causaProhibicion
	 * @return true, en caso de exito
	 */
	@Override
	public boolean addCausaProhibicion(CausaProhibicion causaProhibicion){
		
		getSession().save(causaProhibicion);
		
		CausaProhibicion tipo = getCausaProhibicionById(causaProhibicion.getId());
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
}
