package es.dgoj.rgiaj.business.repository;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.FirmaQueryBean;
import es.dgoj.rgiaj.business.model.Firma;



public interface FirmaRepository<T, ID> extends IHibernateBaseRepository<Firma, Long> {

	/**
	 * Encuentra las Firmas que cumplan las condiciones.
	 * @param firmaQueryBean 
	 * @return SearchResults<Firma>
	 */
	SearchResults<Firma> getFirmas(FirmaQueryBean firmaQueryBean);
	
}