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

import es.dgoj.rgiaj.business.beans.CargoQueryBean;
import es.dgoj.rgiaj.business.model.Cargo;
import es.dgoj.rgiaj.business.repository.CargoRepository;


/**
 * Clase CargoRepositoryImpl
 * @author connectis
 */
@Repository
public class CargoRepositoryImpl extends HibernateBaseRepositoryImpl<Cargo, Long> implements CargoRepository<Cargo, Long>{

	/**
	 * Encuentra los Cargos que cumplan las condiciones.
	 * @param cargoQueryBean 
	 * @return SearchResults<Cargo>
	 */
	@Override
	public SearchResults<Cargo> getCargos(CargoQueryBean cargoQueryBean) {

		Criteria crit = getSession().createCriteria(Cargo.class);
		
		if (cargoQueryBean.getId() != null){
			crit.add(Property.forName("id").eq(cargoQueryBean.getId()));	
		}

		if (cargoQueryBean.getCodigo() != null){
			crit.add(Property.forName("codigo").like(cargoQueryBean.getCodigo(), MatchMode.ANYWHERE).ignoreCase());	
		}		
		
		if (cargoQueryBean.getDescripcion() != null){
			crit.add(Property.forName("nombre").like(cargoQueryBean.getDescripcion(), MatchMode.ANYWHERE).ignoreCase());	
		}			
		
		if (cargoQueryBean.getActivo() != null){
			crit.add(Property.forName("activo").eq(cargoQueryBean.getActivo()?"true":"false"));	
		}	

		if (cargoQueryBean.getDefecto() != null){
			crit.add(Property.forName("defecto").eq(cargoQueryBean.getDefecto()?"true":"false"));	
		}	
		
		if (cargoQueryBean.getFieldName()!=null && cargoQueryBean.getOrder()!=null) {
			if (cargoQueryBean.getOrder().equalsIgnoreCase("asc")){
				crit.addOrder(Order.asc(cargoQueryBean.getFieldName()));
			} else {
				crit.addOrder(Order.desc(cargoQueryBean.getFieldName()));
			}
		} else {
			crit.addOrder(Order.asc("id"));	
		}
		
		Long numResults = (Long) crit.setProjection(Projections.rowCount()).uniqueResult();
		crit.setProjection(null);

		crit.setFirstResult(cargoQueryBean.getFirstResult().intValue());
		crit.setMaxResults(cargoQueryBean.getMaxResults().intValue());
		
		List<Cargo> list = crit.list();
		
		SearchResults<Cargo> results = new SearchResults<Cargo>(list, Long.valueOf(cargoQueryBean.getMaxResults()), Long.valueOf(cargoQueryBean.getFirstResult()), numResults.longValue());

		return results;
	}

	/**
	 * Encuentra un Cargo por su ID.
	 * @param id
	 * @return Cargo
	 */
	@Override
	public Cargo getCargoById(Long id){

		Criteria crit = getSession().createCriteria(Cargo.class);
		
		if (id != null){
			crit.add(Property.forName("id").eq(id));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<Cargo> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Encuentra un Cargo por su Codigo.
	 * @param codigo
	 * @return Cargo
	 */
	@Override	
	public Cargo getCargoByCodigo(String codigo){

		Criteria crit = getSession().createCriteria(Cargo.class);
		
		if (codigo != null){
			crit.add(Property.forName("codigo").eq(codigo));	
		} else {
			return null;
		}
		
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		
		List<Cargo> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Devuelve un Cargo por su codigo que no tenga un Id.
	 * @param id
	 * @param codigo
	 * @return Cargo
	 */
	@Override	
	public Cargo getCargoByCodigoNoID(Long id, String codigo){

		Criteria crit = getSession().createCriteria(Cargo.class);
		
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
		
		List<Cargo> list = crit.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Baja de un Cargo.
	 * @param id
	 * @return true, en caso de exito
	 */
	@Override
	public boolean deleteCargo(Long id){
		
		Cargo cargo = getCargoById(id);
		
		this.remove(cargo);
		
		cargo = getCargoById(id);
		
		if (cargo !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Edicion de un Cargo.
	 * @param cargo
	 * @return true, en caso de exito
	 */
	@Override
	public boolean updateCargo(Cargo cargo){
		
		getSession().merge(cargo);
		
		Cargo miCargo = getCargoById(cargo.getId());
		
		if (miCargo !=null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Alta de un Cargo.
	 * @param cargo
	 * @return true, en caso de exito
	 */
	@Override
	public boolean addCargo(Cargo cargo){
		
		getSession().save(cargo);
		
		Cargo miCargo = getCargoById(cargo.getId());
		
		if (miCargo !=null){
			return false;
		}
		
		return true;
	}
}
