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

import es.dgoj.rgiaj.business.beans.TipoProhibicionQueryBean;
import es.dgoj.rgiaj.business.model.TipoProhibicion;
import es.dgoj.rgiaj.business.repository.TipoProhibicionRepository;


/**
 * Clase TipoProhibicionRepositoryImpl
 * @author connectis
 */
@Repository
public class TipoProhibicionRepositoryImpl extends HibernateBaseRepositoryImpl<TipoProhibicion, Long> implements TipoProhibicionRepository<TipoProhibicion, Long>{

	/**
	 * Encuentra los Tipos de Prohibicion que cumplan las condiciones.
	 * @param tipoProhibicionQueryBean 
	 * @return SearchResults<TipoProhibicion>
	 */
	@Override
	public SearchResults<TipoProhibicion> getTiposProhibicion(TipoProhibicionQueryBean tipoProhibicionQueryBean) {

		Criteria crit = getSession().createCriteria(TipoProhibicion.class);
		
		if (tipoProhibicionQueryBean.getId() != null){
			crit.add(Property.forName("id").eq(tipoProhibicionQueryBean.getId()));	
		}

		if (tipoProhibicionQueryBean.getCodigo() != null){
			crit.add(Property.forName("codigo").like(tipoProhibicionQueryBean.getCodigo(), MatchMode.ANYWHERE).ignoreCase());	
		}		
		
		if (tipoProhibicionQueryBean.getDescripcion() != null){
			crit.add(Property.forName("nombre").like(tipoProhibicionQueryBean.getDescripcion(), MatchMode.ANYWHERE).ignoreCase());	
		}			
		
		if (tipoProhibicionQueryBean.getActivo() != null){
			crit.add(Property.forName("activo").eq(tipoProhibicionQueryBean.getActivo()?"true":"false"));	
		}	
		
		
		if (tipoProhibicionQueryBean.getFieldName()!=null && tipoProhibicionQueryBean.getOrder()!=null) {
			if (tipoProhibicionQueryBean.getOrder().equalsIgnoreCase("asc")){
				crit.addOrder(Order.asc(tipoProhibicionQueryBean.getFieldName()));
			} else {
				crit.addOrder(Order.desc(tipoProhibicionQueryBean.getFieldName()));
			}
		} else {
			crit.addOrder(Order.asc("id"));	
		}
		
		Long numResults = (Long) crit.setProjection(Projections.rowCount()).uniqueResult();
		crit.setProjection(null);

		crit.setFirstResult(tipoProhibicionQueryBean.getFirstResult().intValue());
		crit.setMaxResults(tipoProhibicionQueryBean.getMaxResults().intValue());
		
		List<TipoProhibicion> list = crit.list();
		
		SearchResults<TipoProhibicion> results = new SearchResults<TipoProhibicion>(list, Long.valueOf(tipoProhibicionQueryBean.getMaxResults()), Long.valueOf(tipoProhibicionQueryBean.getFirstResult()), numResults.longValue());

		return results;
	}

	
	/**
	 * Encuentra un Tipo de Prohibicion por su ID.
	 * @param id
	 * @return TipoProhibicion
	 */
	@Override
	public TipoProhibicion getTipoProhibicionById(Long id){

		Criteria crit = getSession().createCriteria(TipoProhibicion.class);
		
		if (id != null){
			crit.add(Property.forName("id").eq(id));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<TipoProhibicion> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Encuentra un Tipo de Prohibicion por su Codigo.
	 * @param codigo
	 * @return TipoProhibicion
	 */
	@Override	
	public TipoProhibicion getTipoProhibicionByCodigo(String codigo){

		Criteria crit = getSession().createCriteria(TipoProhibicion.class);
		
		if (codigo != null){
			crit.add(Property.forName("codigo").eq(codigo));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<TipoProhibicion> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Devuelve un Tipo de Prohibicion por su codigo que no tenga un Id.
	 * @param id
	 * @param codigo
	 * @return TipoProhibicion
	 */
	@Override	
	public TipoProhibicion getTipoProhibicionByCodigoNoID(Long id, String codigo){

		Criteria crit = getSession().createCriteria(TipoProhibicion.class);
		
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
		
		List<TipoProhibicion> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Baja de un Tipo de Prohibicion.
	 * @param id
	 * @return true, en caso de exito
	 */
	@Override
	public boolean deleteTipoProhibicion(Long id){
		
		TipoProhibicion tipo = getTipoProhibicionById(id);
		
		this.remove(tipo);
		
		tipo = getTipoProhibicionById(id);
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Edicion de un Tipo de Prohibicion.
	 * @param tipoProhibicion
	 * @return true, en caso de exito
	 */
	@Override
	public boolean updateTipoProhibicion(TipoProhibicion tipoProhibicion){
		
		getSession().merge(tipoProhibicion);
		
		TipoProhibicion tipo = getTipoProhibicionById(tipoProhibicion.getId());
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Alta de un Tipo de Prohibicion.
	 * @param tipoProhibicion
	 * @return true, en caso de exito
	 */
	@Override
	public boolean addTipoProhibicion(TipoProhibicion tipoProhibicion){
		
		getSession().save(tipoProhibicion);
		
		TipoProhibicion tipo = getTipoProhibicionById(tipoProhibicion.getId());
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
}
