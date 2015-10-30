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

import es.dgoj.rgiaj.business.beans.FirmaQueryBean;
import es.dgoj.rgiaj.business.model.Firma;
import es.dgoj.rgiaj.business.repository.FirmaRepository;


/**
 * Clase FirmaRepositoryImpl
 * @author connectis
 */
@Repository
public class FirmaRepositoryImpl extends HibernateBaseRepositoryImpl<Firma, Long> implements FirmaRepository<Firma, Long>{

	/**
	 * Encuentra las firmas que cumplan las condiciones.
	 * @param firmaQueryBean 
	 * @return SearchResults<Firma>
	 */
	@Override
	public SearchResults<Firma> getFirmas(FirmaQueryBean firmaQueryBean) {

		Criteria crit = getSession().createCriteria(Firma.class);
		
		if (firmaQueryBean.getId() != null){
			crit.add(Property.forName("id").eq(firmaQueryBean.getId()));	
		}

		if (firmaQueryBean.getCodigo() != null){
			crit.add(Property.forName("codigo").like(firmaQueryBean.getCodigo(), MatchMode.ANYWHERE).ignoreCase());	
		}		
		
		if (firmaQueryBean.getDescripcion() != null){
			crit.add(Property.forName("nombre").like(firmaQueryBean.getDescripcion(), MatchMode.ANYWHERE).ignoreCase());	
		}			
		
		if (firmaQueryBean.getActivo() != null){
			crit.add(Property.forName("activo").eq(firmaQueryBean.getActivo()?"true":"false"));	
		}	

		if (firmaQueryBean.getDefecto() != null){
			crit.add(Property.forName("defecto").eq(firmaQueryBean.getDefecto()?"true":"false"));	
		}	
		
		if (firmaQueryBean.getFieldName()!=null && firmaQueryBean.getOrder()!=null) {
			if (firmaQueryBean.getOrder().equalsIgnoreCase("asc")){
				crit.addOrder(Order.asc(firmaQueryBean.getFieldName()));
			} else {
				crit.addOrder(Order.desc(firmaQueryBean.getFieldName()));
			}
		} else {
			crit.addOrder(Order.asc("id"));	
		}
		
		Long numResults = (Long) crit.setProjection(Projections.rowCount()).uniqueResult();
		crit.setProjection(null);

		crit.setFirstResult(firmaQueryBean.getFirstResult().intValue());
		crit.setMaxResults(firmaQueryBean.getMaxResults().intValue());
		
		List<Firma> list = crit.list();
		
		SearchResults<Firma> results = new SearchResults<Firma>(list, Long.valueOf(firmaQueryBean.getMaxResults()), Long.valueOf(firmaQueryBean.getFirstResult()), numResults.longValue());

		return results;
	}

	

}
