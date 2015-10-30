package es.dgoj.rgiaj.business.repository;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.ProvinciaQueryBean;
import es.dgoj.rgiaj.business.model.Provincia;



public interface ProvinciaRepository<T, ID> extends IHibernateBaseRepository<Provincia, Long> {

	/**
	 * Encuentra las provincias que cumplan las condiciones.
	 * @param provinciaQueryBean 
	 * @return SearchResults<Provincia>
	 */
	SearchResults<Provincia> getProvincias(ProvinciaQueryBean provinciaQueryBean);

}