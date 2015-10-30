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

import es.dgoj.rgiaj.business.beans.OperadorQueryBean;
import es.dgoj.rgiaj.business.model.Operador;
import es.dgoj.rgiaj.business.repository.OperadorRepository;


/**
 * The Class OperadorRepositoryImpl.
 */
@Repository
public class OperadorRepositoryImpl extends HibernateBaseRepositoryImpl<Operador, Long> implements OperadorRepository<Operador, Long>{

	/** Campo lista cache operadores. */
	private List<Operador> listaCacheOperadores = null;

		
	/* (non-Javadoc)
	 * @see es.dgoj.rgiaj.business.repository.OperadorRepository#getOperador(es.dgoj.rgiaj.business.bean.OperadorQueryBean)
	 */
	@Override
	public SearchResults<Operador> getOperador(OperadorQueryBean operadorQuery){
		
		Criteria crit = getSession().createCriteria(Operador.class);
		
		/* Criterios de busqueda para la consulta general de operadores */
		if (operadorQuery.getIdOperador() != null){
			crit.add(Property.forName("idOperador").eq(operadorQuery.getIdOperador()));	
		}
		
		if (operadorQuery.getIdOperadorWeb() != null){
			crit.add(Property.forName("idOperadorWeb").eq(operadorQuery.getIdOperadorWeb()));	
		}
	
		if (operadorQuery.getCif() != null){
			crit.add(Property.forName("cif").like(operadorQuery.getCif(), MatchMode.ANYWHERE).ignoreCase());	
		}
		
		if (operadorQuery.getRazonSocial() != null){
			crit.add(Property.forName("razonSocial").like(operadorQuery.getRazonSocial(), MatchMode.ANYWHERE).ignoreCase());	
		}
		
		if (operadorQuery.getNombreCorto() != null){
			crit.add(Property.forName("nombreCorto").like(operadorQuery.getNombreCorto(), MatchMode.ANYWHERE).ignoreCase());	
		}

		if (operadorQuery.getModeEnabled() != null){
			crit.add(Property.forName("modeEnabled").eq(operadorQuery.getModeEnabled()));	
		}
		
		Long numResults = (Long) crit.setProjection(Projections.rowCount()).uniqueResult();
		crit.setProjection(null);

		crit.setFirstResult(operadorQuery.getFirstResult().intValue());
		crit.setMaxResults(operadorQuery.getMaxResults().intValue());
		
		if (operadorQuery.getFieldName()!=null && operadorQuery.getOrder()!=null) {
			if (operadorQuery.getOrder().equalsIgnoreCase("asc")){
				crit.addOrder(Order.asc(operadorQuery.getFieldName()));
			} else {
				crit.addOrder(Order.desc(operadorQuery.getFieldName()));
			}
		} else {
			crit.addOrder(Order.asc("idOperador"));	
		}
		
		List<Operador> list = crit.list();
		
		SearchResults<Operador> results = new SearchResults<Operador>(list, Long.valueOf(operadorQuery.getMaxResults()), Long.valueOf(operadorQuery.getFirstResult()), numResults.longValue());
		
		return results;		
	}
	
	/* (non-Javadoc)
	 * @see es.dgoj.rgiaj.business.repository.OperadorRepository#getListaOperadores()
	 */
	@Override
	public List<Operador> getListaOperadores() {
			Criteria crit = getSession().createCriteria(Operador.class);
			crit.addOrder(Order.asc("idOperador"));
			List<Operador> list = crit.list();
			listaCacheOperadores = list;
			return list;
	}
	

	/* (non-Javadoc)
	 * @see es.dgoj.rgiaj.business.repository.OperadorRepository#getListaCacheOperadores()
	 */
	@Override
	public List<Operador> getListaCacheOperadores() {
		if (listaCacheOperadores == null){
			listaCacheOperadores = getListaOperadores();
		} 
		return listaCacheOperadores;
	}

}
