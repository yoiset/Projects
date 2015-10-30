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

import es.dgoj.rgiaj.business.beans.ProvinciaQueryBean;
import es.dgoj.rgiaj.business.model.Provincia;
import es.dgoj.rgiaj.business.repository.ProvinciaRepository;


/**
 * Clase ProvinciaRepositoryImpl
 * @author connectis
 */
@Repository
public class ProvinciaRepositoryImpl extends HibernateBaseRepositoryImpl<Provincia, Long> implements ProvinciaRepository<Provincia, Long>{

	/**
	 * Encuentra las Comunidades Autonomas que cumplan las condiciones.
	 * @param provinciaQueryBean 
	 * @return SearchResults<Provincia>
	 */
	@Override
	public SearchResults<Provincia> getProvincias(ProvinciaQueryBean provinciaQueryBean) {

		Criteria crit = getSession().createCriteria(Provincia.class);
		
		if (provinciaQueryBean.getId() != null){
			crit.add(Property.forName("id").eq(provinciaQueryBean.getId()));	
		}

		if (provinciaQueryBean.getCodigo() != null){
			crit.add(Property.forName("codigo").like(provinciaQueryBean.getCodigo(), MatchMode.ANYWHERE).ignoreCase());	
		}		
		
		if (provinciaQueryBean.getDescripcion() != null){
			crit.add(Property.forName("nombre").like(provinciaQueryBean.getDescripcion(), MatchMode.ANYWHERE).ignoreCase());	
		}			
		
		if (provinciaQueryBean.getFieldName()!=null && provinciaQueryBean.getOrder()!=null) {
			if (provinciaQueryBean.getOrder().equalsIgnoreCase("asc")){
				crit.addOrder(Order.asc(provinciaQueryBean.getFieldName()));
			} else {
				crit.addOrder(Order.desc(provinciaQueryBean.getFieldName()));
			}
		} else {
			crit.addOrder(Order.asc("id"));	
		}
		
		Long numResults = (Long) crit.setProjection(Projections.rowCount()).uniqueResult();
		crit.setProjection(null);

		crit.setFirstResult(provinciaQueryBean.getFirstResult().intValue());
		crit.setMaxResults(provinciaQueryBean.getMaxResults().intValue());
		
		List<Provincia> list = crit.list();
		
		SearchResults<Provincia> results = new SearchResults<Provincia>(list, Long.valueOf(provinciaQueryBean.getMaxResults()), Long.valueOf(provinciaQueryBean.getFirstResult()), numResults.longValue());

		return results;
	}

	
}
