package es.dgoj.rgiaj.business.repository;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.TipoProhibicionQueryBean;
import es.dgoj.rgiaj.business.model.TipoProhibicion;



public interface TipoProhibicionRepository<T, ID> extends IHibernateBaseRepository<TipoProhibicion, Long> {

	/**
	 * Encuentra los Tipos de Prohibicion que cumplan las condiciones.
	 * @param tipoProhibicionQueryBean 
	 * @return SearchResults<TipoProhibicion>
	 */
	SearchResults<TipoProhibicion> getTiposProhibicion(TipoProhibicionQueryBean tipoProhibicionQueryBean);

	/**
	 * Encuentra un Tipo de Prohibicion por su ID.
	 * @param id
	 * @return TipoProhibicion
	 */
	TipoProhibicion getTipoProhibicionById(Long id);
	
	/**
	 * Encuentra un Tipo de Prohibicion por su Codigo.
	 * @param codigo
	 * @return TipoProhibicion
	 */
	TipoProhibicion getTipoProhibicionByCodigo(String codigo);
	
	/**
	 * Devuelve un Tipo de Prohibicion por su codigo que no tenga un Id.
	 * @param id
	 * @param codigo
	 * @return TipoProhibicion
	 */
	TipoProhibicion getTipoProhibicionByCodigoNoID(Long id, String codigo);

	/**
	 * Edicion de un Tipo de Prohibicion.
	 * @param tipoProhibicion
	 * @return true, en caso de exito
	 */
	boolean updateTipoProhibicion(TipoProhibicion tipoProhibicion);

	/**
	 * Alta de un Tipo de Prohibicion.
	 * @param tipoProhibicion
	 * @return true, en caso de exito
	 */
	boolean addTipoProhibicion(TipoProhibicion tipoProhibicion);
	
	/**
	 * Baja de un Tipo de Prohibicion.
	 * @param id
	 * @return true, en caso de exito
	 */
	boolean deleteTipoProhibicion(Long id);

}