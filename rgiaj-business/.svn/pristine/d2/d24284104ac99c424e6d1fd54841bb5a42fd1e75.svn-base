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

import es.dgoj.rgiaj.business.beans.TipoDocIdentidadQueryBean;
import es.dgoj.rgiaj.business.model.TipoDocIdentidad;
import es.dgoj.rgiaj.business.repository.TipoDocIdentidadRepository;


/**
 * Clase TipoDocIdentidadRepositoryImpl
 * @author connectis
 */
@Repository
public class TipoDocIdentidadRepositoryImpl extends HibernateBaseRepositoryImpl<TipoDocIdentidad, Long> implements TipoDocIdentidadRepository<TipoDocIdentidad, Long>{

	/**
	 * Encuentra los Tipos de Documentos de Identidad que cumplan las condiciones.
	 * @param tipoDocIdentidadQueryBean 
	 * @return SearchResults<TipoDocIdentidad>
	 */
	@Override
	public SearchResults<TipoDocIdentidad> getTiposDocIdentidad(TipoDocIdentidadQueryBean tipoDocIdentidadQueryBean) {

		Criteria crit = getSession().createCriteria(TipoDocIdentidad.class);
		
		if (tipoDocIdentidadQueryBean.getId() != null){
			crit.add(Property.forName("id").eq(tipoDocIdentidadQueryBean.getId()));	
		}

		if (tipoDocIdentidadQueryBean.getCodigo() != null){
			crit.add(Property.forName("codigo").like(tipoDocIdentidadQueryBean.getCodigo(), MatchMode.ANYWHERE).ignoreCase());	
		}		
		
		if (tipoDocIdentidadQueryBean.getDescripcion() != null){
			crit.add(Property.forName("nombre").like(tipoDocIdentidadQueryBean.getDescripcion(), MatchMode.ANYWHERE).ignoreCase());	
		}			
		
		if (tipoDocIdentidadQueryBean.getActivo() != null){
			crit.add(Property.forName("activo").eq(tipoDocIdentidadQueryBean.getActivo()?"true":"false"));	
		}	
		
		
		if (tipoDocIdentidadQueryBean.getFieldName()!=null && tipoDocIdentidadQueryBean.getOrder()!=null) {
			if (tipoDocIdentidadQueryBean.getOrder().equalsIgnoreCase("asc")){
				crit.addOrder(Order.asc(tipoDocIdentidadQueryBean.getFieldName()));
			} else {
				crit.addOrder(Order.desc(tipoDocIdentidadQueryBean.getFieldName()));
			}
		} else {
			crit.addOrder(Order.asc("id"));	
		}
		
		Long numResults = (Long) crit.setProjection(Projections.rowCount()).uniqueResult();
		crit.setProjection(null);

		crit.setFirstResult(tipoDocIdentidadQueryBean.getFirstResult().intValue());
		crit.setMaxResults(tipoDocIdentidadQueryBean.getMaxResults().intValue());
		
		List<TipoDocIdentidad> list = crit.list();
		
		SearchResults<TipoDocIdentidad> results = new SearchResults<TipoDocIdentidad>(list, Long.valueOf(tipoDocIdentidadQueryBean.getMaxResults()), Long.valueOf(tipoDocIdentidadQueryBean.getFirstResult()), numResults.longValue());

		return results;
	}

	
	/**
	 * Encuentra un Tipo de Documento de Identidad por su ID.
	 * @param id
	 * @return TipoDocIdentidad
	 */
	@Override
	public TipoDocIdentidad getTipoDocIdentidadById(Long id){

		Criteria crit = getSession().createCriteria(TipoDocIdentidad.class);
		
		if (id != null){
			crit.add(Property.forName("id").eq(id));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<TipoDocIdentidad> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Encuentra un Tipo de Documento de Identidad por su Codigo.
	 * @param codigo
	 * @return TipoDocIdentidad
	 */
	@Override	
	public TipoDocIdentidad getTipoDocIdentidadByCodigo(String codigo){

		Criteria crit = getSession().createCriteria(TipoDocIdentidad.class);
		
		if (codigo != null){
			crit.add(Property.forName("codigo").eq(codigo));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<TipoDocIdentidad> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Devuelve un Tipo de Documento de Identidad por su codigo que no tenga un Id.
	 * @param id
	 * @param codigo
	 * @return TipoDocIdentidad
	 */
	@Override	
	public TipoDocIdentidad getTipoDocIdentidadByCodigoNoID(Long id, String codigo){

		Criteria crit = getSession().createCriteria(TipoDocIdentidad.class);
		
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
		
		List<TipoDocIdentidad> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Baja de un Tipo de Documento de Identidad.
	 * @param id
	 * @return true, en caso de exito
	 */
	@Override
	public boolean deleteTipoDocIdentidad(Long id){
		
		TipoDocIdentidad tipo = getTipoDocIdentidadById(id);
		
		this.remove(tipo);
		
		tipo = getTipoDocIdentidadById(id);
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Edicion de un Tipo de Documento de Identidad.
	 * @param tipoDocIdentidad
	 * @return true, en caso de exito
	 */
	@Override
	public boolean updateTipoDocIdentidad(TipoDocIdentidad tipoDocIdentidad){
		
		getSession().merge(tipoDocIdentidad);
		
		TipoDocIdentidad tipo = getTipoDocIdentidadById(tipoDocIdentidad.getId());
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Alta de un Tipo de Documento de Identidad.
	 * @param tipoDocIdentidad
	 * @return true, en caso de exito
	 */
	@Override
	public boolean addTipoDocIdentidad(TipoDocIdentidad tipoDocIdentidad){
		
		getSession().save(tipoDocIdentidad);
		
		TipoDocIdentidad tipo = getTipoDocIdentidadById(tipoDocIdentidad.getId());
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
}
