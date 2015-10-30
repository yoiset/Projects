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

import es.dgoj.rgiaj.business.beans.TipoFirmaQueryBean;
import es.dgoj.rgiaj.business.model.TipoFirma;
import es.dgoj.rgiaj.business.repository.TipoFirmaRepository;


/**
 * Clase TipoFirmaRepositoryImpl
 * @author connectis
 */
@Repository
public class TipoFirmaRepositoryImpl extends HibernateBaseRepositoryImpl<TipoFirma, Long> implements TipoFirmaRepository<TipoFirma, Long>{

	/**
	 * Encuentra los Tipos de Firma que cumplan las condiciones.
	 * @param tipoFirmaQueryBean 
	 * @return SearchResults<TipoFirma>
	 */
	@Override
	public SearchResults<TipoFirma> getTiposFirma(TipoFirmaQueryBean tipoFirmaQueryBean) {

		Criteria crit = getSession().createCriteria(TipoFirma.class);
		
		if (tipoFirmaQueryBean.getId() != null){
			crit.add(Property.forName("id").eq(tipoFirmaQueryBean.getId()));	
		}

		if (tipoFirmaQueryBean.getCodigo() != null){
			crit.add(Property.forName("codigo").like(tipoFirmaQueryBean.getCodigo(), MatchMode.ANYWHERE).ignoreCase());	
		}		
		
		if (tipoFirmaQueryBean.getDescripcion() != null){
			crit.add(Property.forName("nombre").like(tipoFirmaQueryBean.getDescripcion(), MatchMode.ANYWHERE).ignoreCase());	
		}			
		
		if (tipoFirmaQueryBean.getActivo() != null){
			crit.add(Property.forName("activo").eq(tipoFirmaQueryBean.getActivo()?"true":"false"));	
		}	
		
		if (tipoFirmaQueryBean.getDefecto() != null){
			crit.add(Property.forName("defecto").eq(tipoFirmaQueryBean.getDefecto()?"true":"false"));	
		}	
		
		if (tipoFirmaQueryBean.getFieldName()!=null && tipoFirmaQueryBean.getOrder()!=null) {
			if (tipoFirmaQueryBean.getOrder().equalsIgnoreCase("asc")){
				crit.addOrder(Order.asc(tipoFirmaQueryBean.getFieldName()));
			} else {
				crit.addOrder(Order.desc(tipoFirmaQueryBean.getFieldName()));
			}
		} else {
			crit.addOrder(Order.asc("id"));	
		}
		
		Long numResults = (Long) crit.setProjection(Projections.rowCount()).uniqueResult();
		crit.setProjection(null);

		crit.setFirstResult(tipoFirmaQueryBean.getFirstResult().intValue());
		crit.setMaxResults(tipoFirmaQueryBean.getMaxResults().intValue());
		
		List<TipoFirma> list = crit.list();
		
		SearchResults<TipoFirma> results = new SearchResults<TipoFirma>(list, Long.valueOf(tipoFirmaQueryBean.getMaxResults()), Long.valueOf(tipoFirmaQueryBean.getFirstResult()), numResults.longValue());

		return results;
	}

	
	/**
	 * Encuentra un Tipo de Firma por su ID.
	 * @param id
	 * @return TipoFirma
	 */
	@Override
	public TipoFirma getTipoFirmaById(Long id){

		Criteria crit = getSession().createCriteria(TipoFirma.class);
		
		if (id != null){
			crit.add(Property.forName("id").eq(id));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<TipoFirma> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Encuentra un Tipo de Firma por su Codigo.
	 * @param codigo
	 * @return TipoFirma
	 */
	@Override	
	public TipoFirma getTipoFirmaByCodigo(String codigo){

		Criteria crit = getSession().createCriteria(TipoFirma.class);
		
		if (codigo != null){
			crit.add(Property.forName("codigo").eq(codigo));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<TipoFirma> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Devuelve un Tipo de Firma por su codigo que no tenga un Id.
	 * @param id
	 * @param codigo
	 * @return TipoFirma
	 */
	@Override	
	public TipoFirma getTipoFirmaByCodigoNoID(Long id, String codigo){

		Criteria crit = getSession().createCriteria(TipoFirma.class);
		
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
		
		List<TipoFirma> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Baja de un Tipo de Firma.
	 * @param id
	 * @return true, en caso de exito
	 */
	@Override
	public boolean deleteTipoFirma(Long id){
		
		TipoFirma tipo = getTipoFirmaById(id);
		
		this.remove(tipo);
		
		tipo = getTipoFirmaById(id);
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Edicion de un Tipo de Firma.
	 * @param tipoFirma
	 * @return true, en caso de exito
	 */
	@Override
	public boolean updateTipoFirma(TipoFirma tipoFirma){
		
		getSession().merge(tipoFirma);
		
		TipoFirma tipo = getTipoFirmaById(tipoFirma.getId());
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Alta de un Tipo de Firma.
	 * @param tipoFirma
	 * @return true, en caso de exito
	 */
	@Override
	public boolean addTipoFirma(TipoFirma tipoFirma){
		
		getSession().save(tipoFirma);
		
		TipoFirma tipo = getTipoFirmaById(tipoFirma.getId());
		
		if (tipo !=null){
			return false;
		}
		
		return true;
	}
}
