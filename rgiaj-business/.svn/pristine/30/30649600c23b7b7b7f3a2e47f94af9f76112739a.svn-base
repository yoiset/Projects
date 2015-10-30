package es.dgoj.rgiaj.business.repository;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.CausaProhibicionQueryBean;
import es.dgoj.rgiaj.business.model.CausaProhibicion;



public interface CausaProhibicionRepository<T, ID> extends IHibernateBaseRepository<CausaProhibicion, Long> {

	/**
	 * Encuentra los Tipos de Prohibicion que cumplan las condiciones.
	 * @param jugadorPruebaQueryBean 
	 * @return SearchResults<CausaProhibicion>
	 */
	SearchResults<CausaProhibicion> getCausasProhibicion(CausaProhibicionQueryBean causaProhibicionQueryBean);

	/**
	 * Encuentra una Causa de Prohibicion por su ID.
	 * @param id
	 * @return CausaProhibicion
	 */
	CausaProhibicion getCausaProhibicionById(Long id);
	
	/**
	 * Encuentra una Causa de Prohibicion por su Codigo.
	 * @param codigo
	 * @return CausaProhibicion
	 */
	CausaProhibicion getCausaProhibicionByCodigo(String codigo);
	
	/**
	 * Devuelve una Causa de Prohibicion por su codigo que no tenga un Id.
	 * @param id
	 * @param codigo
	 * @return CausaProhibicion
	 */
	CausaProhibicion getCausaProhibicionByCodigoNoID(Long id, String codigo);

	/**
	 * Edicion de una Causa de Prohibicion.
	 * @param causaProhibicion
	 * @return true, en caso de exito
	 */
	boolean updateCausaProhibicion(CausaProhibicion causaProhibicion);

	/**
	 * Alta de uan Causa de Prohibicion.
	 * @param causaProhibicion
	 * @return true, en caso de exito
	 */
	boolean addCausaProhibicion(CausaProhibicion causaProhibicion);
	
	/**
	 * Baja de una Causa de Prohibicion.
	 * @param id
	 * @return true, en caso de exito
	 */
	boolean deleteCausaProhibicion(Long id);

}