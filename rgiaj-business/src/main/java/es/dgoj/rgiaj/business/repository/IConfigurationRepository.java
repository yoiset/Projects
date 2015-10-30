package es.dgoj.rgiaj.business.repository;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;

import es.dgoj.rgiaj.business.model.ConfiguracionEntity;

public interface IConfigurationRepository<T, ID> extends IHibernateBaseRepository <ConfiguracionEntity,Long> {

	public String getEndPoint(String name); 
	
}
