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

import es.dgoj.rgiaj.business.beans.CartaQueryBean;
import es.dgoj.rgiaj.business.model.Carta;
import es.dgoj.rgiaj.business.repository.CartaRepository;


/**
 * Clase CartaRepositoryImpl
 * @author connectis
 */
@Repository
public class CartaRepositoryImpl extends HibernateBaseRepositoryImpl<Carta, Long> implements CartaRepository<Carta, Long>{

	/**
	 * Encuentra las Cartas que cumplan las condiciones.
	 * @param cartaQueryBean 
	 * @return SearchResults<Carta>
	 */
	@Override
	public SearchResults<Carta> getCartas(CartaQueryBean cartaQueryBean) {

		Criteria crit = getSession().createCriteria(Carta.class);
		
		if (cartaQueryBean.getId() != null){
			crit.add(Property.forName("id").eq(cartaQueryBean.getId()));	
		}

		if (cartaQueryBean.getDescripcion() != null){
			crit.add(Property.forName("descripcion").like(cartaQueryBean.getDescripcion(), MatchMode.ANYWHERE).ignoreCase());	
		}			
		
		if (cartaQueryBean.getCargo() != null){
			crit.add(Property.forName("cargo").eq(cartaQueryBean.getCargo()));	
		}	
		
		if (cartaQueryBean.getResponsable() != null){
			crit.add(Property.forName("responsable").eq(cartaQueryBean.getResponsable()));	
		}	
		
		if (cartaQueryBean.getFieldName()!=null && cartaQueryBean.getOrder()!=null) {
			if (cartaQueryBean.getOrder().equalsIgnoreCase("asc")){
				crit.addOrder(Order.asc(cartaQueryBean.getFieldName()));
			} else {
				crit.addOrder(Order.desc(cartaQueryBean.getFieldName()));
			}
		} else {
			crit.addOrder(Order.asc("id"));	
		}
		
		Long numResults = (Long) crit.setProjection(Projections.rowCount()).uniqueResult();
		crit.setProjection(null);

		crit.setFirstResult(cartaQueryBean.getFirstResult().intValue());
		crit.setMaxResults(cartaQueryBean.getMaxResults().intValue());
		
		List<Carta> list = crit.list();
		
		SearchResults<Carta> results = new SearchResults<Carta>(list, Long.valueOf(cartaQueryBean.getMaxResults()), Long.valueOf(cartaQueryBean.getFirstResult()), numResults.longValue());

		return results;
	}

	
	/**
	 * Encuentra una Carta por su ID.
	 * @param id
	 * @return Carta
	 */
	@Override
	public Carta getCartaById(Long id){

		Criteria crit = getSession().createCriteria(Carta.class);
		
		if (id != null){
			crit.add(Property.forName("id").eq(id));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<Carta> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Encuentra una Carta por su Codigo.
	 * @param codigo
	 * @return Carta
	
	@Override	
	public Carta getCartaByCodigo(String codigo){

		Criteria crit = getSession().createCriteria(Carta.class);
		
		if (codigo != null){
			crit.add(Property.forName("codigo").eq(codigo));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<Carta> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	} */
	
	/**
	 * Devuelve una Carta por su codigo que no tenga un Id.
	 * @param id
	 * @param codigo
	 * @return Carta
	 
	@Override	
	public Carta getCartaByCodigoNoID(Long id, String codigo){

		Criteria crit = getSession().createCriteria(Carta.class);
		
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
		
		List<Carta> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}*/
	
	/**
	 * Baja de una Carta.
	 * @param id
	 * @return true, en caso de exito
	 */
	@Override
	public boolean deleteCarta(Long id){
		
		Carta carta = getCartaById(id);
		
		this.remove(carta);
		
		carta = getCartaById(id);
		
		if (carta !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Edicion de una Carta.
	 * @param carta
	 * @return true, en caso de exito
	 */
	@Override
	public boolean updateCarta(Carta carta){
		
		getSession().merge(carta);
		
		Carta miCarta = getCartaById(carta.getId());
		
		if (miCarta !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Alta de una Carta.
	 * @param carta
	 * @return true, en caso de exito
	 */
	@Override
	public boolean addCarta(Carta carta){
		
		getSession().save(carta);
		
		Carta miCarta = getCartaById(carta.getId());
		
		if (miCarta !=null){
			return false;
		}
		
		return true;
	}
}
