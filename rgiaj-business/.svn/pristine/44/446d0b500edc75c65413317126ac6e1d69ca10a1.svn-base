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

import es.dgoj.rgiaj.business.beans.ComunidadAutonomaQueryBean;
import es.dgoj.rgiaj.business.model.ComunidadAutonoma;
import es.dgoj.rgiaj.business.repository.ComunidadAutonomaRepository;


/**
 * Clase ComunidadAutonomaRepositoryImpl
 * @author connectis
 */
@Repository
public class ComunidadAutonomaRepositoryImpl extends HibernateBaseRepositoryImpl<ComunidadAutonoma, Long> implements ComunidadAutonomaRepository<ComunidadAutonoma, Long>{

	/**
	 * Encuentra las Comunidades Autonomas que cumplan las condiciones.
	 * @param comunidadAutonomaQueryBean 
	 * @return SearchResults<ComunidadAutonoma>
	 */
	@Override
	public SearchResults<ComunidadAutonoma> getComunidadesAutonomas(ComunidadAutonomaQueryBean comunidadAutonomaQueryBean) {

		Criteria crit = getSession().createCriteria(ComunidadAutonoma.class);
		
		if (comunidadAutonomaQueryBean.getId() != null){
			crit.add(Property.forName("id").eq(comunidadAutonomaQueryBean.getId()));	
		}

		if (comunidadAutonomaQueryBean.getCodigo() != null){
			crit.add(Property.forName("codigo").like(comunidadAutonomaQueryBean.getCodigo(), MatchMode.ANYWHERE).ignoreCase());	
		}		
		
		if (comunidadAutonomaQueryBean.getDescripcion() != null){
			crit.add(Property.forName("nombre").like(comunidadAutonomaQueryBean.getDescripcion(), MatchMode.ANYWHERE).ignoreCase());	
		}			
		
		if (comunidadAutonomaQueryBean.getActivo() != null){
			crit.add(Property.forName("activo").eq(comunidadAutonomaQueryBean.getActivo()?"true":"false"));	
		}	
		
		
		if (comunidadAutonomaQueryBean.getFieldName()!=null && comunidadAutonomaQueryBean.getOrder()!=null) {
			if (comunidadAutonomaQueryBean.getOrder().equalsIgnoreCase("asc")){
				crit.addOrder(Order.asc(comunidadAutonomaQueryBean.getFieldName()));
			} else {
				crit.addOrder(Order.desc(comunidadAutonomaQueryBean.getFieldName()));
			}
		} else {
			crit.addOrder(Order.asc("id"));	
		}
		
		Long numResults = (Long) crit.setProjection(Projections.rowCount()).uniqueResult();
		crit.setProjection(null);

		crit.setFirstResult(comunidadAutonomaQueryBean.getFirstResult().intValue());
		crit.setMaxResults(comunidadAutonomaQueryBean.getMaxResults().intValue());
		
		List<ComunidadAutonoma> list = crit.list();
		
		SearchResults<ComunidadAutonoma> results = new SearchResults<ComunidadAutonoma>(list, Long.valueOf(comunidadAutonomaQueryBean.getMaxResults()), Long.valueOf(comunidadAutonomaQueryBean.getFirstResult()), numResults.longValue());

		return results;
	}

	
	/**
	 * Encuentra una Comunidad Autonoma por su ID.
	 * @param id
	 * @return ComunidadAutonoma
	 */
	@Override
	public ComunidadAutonoma getComunidadAutonomaById(Long id){

		Criteria crit = getSession().createCriteria(ComunidadAutonoma.class);
		
		if (id != null){
			crit.add(Property.forName("id").eq(id));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<ComunidadAutonoma> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Encuentra una Comunidad Autonoma por su Codigo.
	 * @param codigo
	 * @return ComunidadAutonoma
	 */
	@Override	
	public ComunidadAutonoma getComunidadAutonomaByCodigo(String codigo){

		Criteria crit = getSession().createCriteria(ComunidadAutonoma.class);
		
		if (codigo != null){
			crit.add(Property.forName("codigo").eq(codigo));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<ComunidadAutonoma> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Devuelve una Comunidad Autonoma por su codigo que no tenga un Id.
	 * @param id
	 * @param codigo
	 * @return ComunidadAutonoma
	 */
	@Override	
	public ComunidadAutonoma getComunidadAutonomaByCodigoNoID(Long id, String codigo){

		Criteria crit = getSession().createCriteria(ComunidadAutonoma.class);
		
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
		
		List<ComunidadAutonoma> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Baja de una Comunidad Autonoma.
	 * @param id
	 * @return true, en caso de exito
	 */
	@Override
	public boolean deleteComunidadAutonoma(Long id){
		
		ComunidadAutonoma tipo = getComunidadAutonomaById(id);
		
		this.remove(tipo);
		
		tipo = getComunidadAutonomaById(id);
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Edicion de una Comunidad Autonoma.
	 * @param comunidadAutonoma
	 * @return true, en caso de exito
	 */
	@Override
	public boolean updateComunidadAutonoma(ComunidadAutonoma comunidadAutonoma){
		
		getSession().merge(comunidadAutonoma);
		
		ComunidadAutonoma tipo = getComunidadAutonomaById(comunidadAutonoma.getId());
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Alta de una Comunidad Autonoma.
	 * @param comunidadAutonoma
	 * @return true, en caso de exito
	 */
	@Override
	public boolean addComunidadAutonoma(ComunidadAutonoma comunidadAutonoma){
		
		getSession().save(comunidadAutonoma);
		
		ComunidadAutonoma tipo = getComunidadAutonomaById(comunidadAutonoma.getId());
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
}
