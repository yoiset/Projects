package es.dgoj.rgiaj.business.repository;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.CargoQueryBean;
import es.dgoj.rgiaj.business.model.Cargo;



public interface CargoRepository<T, ID> extends IHibernateBaseRepository<Cargo, Long> {

	/**
	 * Encuentra los Cargos que cumplan las condiciones.
	 * @param cargoQueryBean 
	 * @return SearchResults<Cargo>
	 */
	SearchResults<Cargo> getCargos(CargoQueryBean cargoQueryBean);
	
	/**
	 * Encuentra un Cargo por su ID.
	 * @param id
	 * @return Cargo
	 */
	Cargo getCargoById(Long id);
	
	/**
	 * Encuentra un Cargo por su Codigo.
	 * @param codigo
	 * @return Cargo
	 */
	Cargo getCargoByCodigo(String codigo);
	
	/**
	 * Devuelve un Cargo por su codigo que no tenga un Id.
	 * @param id
	 * @param codigo
	 * @return Cargo
	 */
	Cargo getCargoByCodigoNoID(Long id, String codigo);

	/**
	 * Edicion de un Cargo.
	 * @param cargo
	 * @return true, en caso de exito
	 */
	boolean updateCargo(Cargo cargo);

	/**
	 * Alta de un Cargo.
	 * @param cargo
	 * @return true, en caso de exito
	 */
	boolean addCargo(Cargo cargo);
	
	/**
	 * Baja de un Cargo.
	 * @param id
	 * @return true, en caso de exito
	 */
	boolean deleteCargo(Long id);

}