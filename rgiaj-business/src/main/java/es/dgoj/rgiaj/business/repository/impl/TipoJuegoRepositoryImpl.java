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

import es.dgoj.rgiaj.business.beans.TipoJuegoQueryBean;
import es.dgoj.rgiaj.business.model.TipoJuego;
import es.dgoj.rgiaj.business.repository.TipoJuegoRepository;


/**
 * Clase TipoJuegoRepositoryImpl
 * @author connectis
 */
@Repository
public class TipoJuegoRepositoryImpl extends HibernateBaseRepositoryImpl<TipoJuego, Long> implements TipoJuegoRepository<TipoJuego, Long>{

	/**
	 * Encuentra los Tipos de Juego que cumplan las condiciones.
	 * @param tipoJuegoQueryBean 
	 * @return SearchResults<TipoJuego>
	 */
	@Override
	public SearchResults<TipoJuego> getTiposJuego(TipoJuegoQueryBean tipoJuegoQueryBean) {

		Criteria crit = getSession().createCriteria(TipoJuego.class);
		
		if (tipoJuegoQueryBean.getId() != null){
			crit.add(Property.forName("id").eq(tipoJuegoQueryBean.getId()));	
		}

		if (tipoJuegoQueryBean.getCodigo() != null){
			crit.add(Property.forName("codigo").like(tipoJuegoQueryBean.getCodigo(), MatchMode.ANYWHERE).ignoreCase());	
		}		
		
		if (tipoJuegoQueryBean.getDescripcion() != null){
			crit.add(Property.forName("nombre").like(tipoJuegoQueryBean.getDescripcion(), MatchMode.ANYWHERE).ignoreCase());	
		}			
		
		if (tipoJuegoQueryBean.getActivo() != null){
			crit.add(Property.forName("activo").eq(tipoJuegoQueryBean.getActivo()?"true":"false"));	
		}	
		
		
		if (tipoJuegoQueryBean.getFieldName()!=null && tipoJuegoQueryBean.getOrder()!=null) {
			if (tipoJuegoQueryBean.getOrder().equalsIgnoreCase("asc")){
				crit.addOrder(Order.asc(tipoJuegoQueryBean.getFieldName()));
			} else {
				crit.addOrder(Order.desc(tipoJuegoQueryBean.getFieldName()));
			}
		} else {
			crit.addOrder(Order.asc("id"));	
		}
		
		Long numResults = (Long) crit.setProjection(Projections.rowCount()).uniqueResult();
		crit.setProjection(null);

		crit.setFirstResult(tipoJuegoQueryBean.getFirstResult().intValue());
		crit.setMaxResults(tipoJuegoQueryBean.getMaxResults().intValue());
		
		List<TipoJuego> list = crit.list();
		
		SearchResults<TipoJuego> results = new SearchResults<TipoJuego>(list, Long.valueOf(tipoJuegoQueryBean.getMaxResults()), Long.valueOf(tipoJuegoQueryBean.getFirstResult()), numResults.longValue());

		return results;
	}

	
	/**
	 * Encuentra un Tipo de Juego por su ID.
	 * @param id
	 * @return TipoJuego
	 */
	@Override
	public TipoJuego getTipoJuegoById(Long id){

		Criteria crit = getSession().createCriteria(TipoJuego.class);
		
		if (id != null){
			crit.add(Property.forName("id").eq(id));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<TipoJuego> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Encuentra un Tipo de Juego por su Codigo.
	 * @param codigo
	 * @return TipoJuego
	 */
	@Override	
	public TipoJuego getTipoJuegoByCodigo(String codigo){

		Criteria crit = getSession().createCriteria(TipoJuego.class);
		
		if (codigo != null){
			crit.add(Property.forName("codigo").eq(codigo));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<TipoJuego> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Devuelve un Tipo de Juego por su codigo que no tenga un Id.
	 * @param id
	 * @param codigo
	 * @return TipoJuego
	 */
	@Override	
	public TipoJuego getTipoJuegoByCodigoNoID(Long id, String codigo){

		Criteria crit = getSession().createCriteria(TipoJuego.class);
		
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
		
		List<TipoJuego> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Baja de un Tipo de Juego.
	 * @param id
	 * @return true, en caso de exito
	 */
	@Override
	public boolean deleteTipoJuego(Long id){
		
		TipoJuego tipo = getTipoJuegoById(id);
		
		this.remove(tipo);
		
		tipo = getTipoJuegoById(id);
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Edicion de un Tipo de Juego.
	 * @param tipoJuego
	 * @return true, en caso de exito
	 */
	@Override
	public boolean updateTipoJuego(TipoJuego tipoJuego){
		
		getSession().merge(tipoJuego);
		
		TipoJuego tipo = getTipoJuegoById(tipoJuego.getId());
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Alta de un Tipo de Juego.
	 * @param tipoJuego
	 * @return true, en caso de exito
	 */
	@Override
	public boolean addTipoJuego(TipoJuego tipoJuego){
		
		getSession().save(tipoJuego);
		
		TipoJuego tipo = getTipoJuegoById(tipoJuego.getId());
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
}
