package es.dgoj.rgiaj.business.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeveris.persistence.hibernate.repository.impl.HibernateBaseRepositoryImpl;

import es.dgoj.rgiaj.business.model.ConfiguracionEntity;
import es.dgoj.rgiaj.business.repository.IConfigurationRepository;

@Repository(value="configurationRepository")
public class ConfigurationRepositoryImpl  extends  HibernateBaseRepositoryImpl<ConfiguracionEntity,Long> implements IConfigurationRepository<ConfiguracionEntity,Long> {


	public String getEndPoint(String name){
		
		String strQuery="SELECT c FROM ConfiguracionEntity c where c.clave=:name"; 
		List<ConfiguracionEntity> list=  getSession().createQuery(strQuery).setParameter("name", name).list();
		if(!list.isEmpty())
			return list.get(0).getValor();
		
		return null;
		
	}
	
}
