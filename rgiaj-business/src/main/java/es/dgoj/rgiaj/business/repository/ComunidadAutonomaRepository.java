package es.dgoj.rgiaj.business.repository;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.ComunidadAutonomaQueryBean;
import es.dgoj.rgiaj.business.model.ComunidadAutonoma;



public interface ComunidadAutonomaRepository<T, ID> extends IHibernateBaseRepository<ComunidadAutonoma, Long> {

	/**
	 * Encuentra las Comunidades Autonomas que cumplan las condiciones.
	 * @param comunidadAutonomaQueryBean 
	 * @return SearchResults<ComunidadAutonoma>
	 */
	SearchResults<ComunidadAutonoma> getComunidadesAutonomas(ComunidadAutonomaQueryBean comunidadAutonomaQueryBean);

	/**
	 * Encuentra una Comunidad Autonoma por su ID.
	 * @param id
	 * @return ComunidadAutonoma
	 */
	ComunidadAutonoma getComunidadAutonomaById(Long id);
	
	/**
	 * Encuentra una Comunidad Autonoma por su Codigo.
	 * @param codigo
	 * @return ComunidadAutonoma
	 */
	ComunidadAutonoma getComunidadAutonomaByCodigo(String codigo);
	
	/**
	 * Devuelve una Comunidad Autonoma por su codigo que no tenga un Id.
	 * @param id
	 * @param codigo
	 * @return ComunidadAutonoma
	 */
	ComunidadAutonoma getComunidadAutonomaByCodigoNoID(Long id, String codigo);

	/**
	 * Edicion de una Comunidad Autonoma.
	 * @param comunidadAutonoma
	 * @return true, en caso de exito
	 */
	boolean updateComunidadAutonoma(ComunidadAutonoma comunidadAutonoma);

	/**
	 * Alta de una Comunidad Autonoma.
	 * @param comunidadAutonoma
	 * @return true, en caso de exito
	 */
	boolean addComunidadAutonoma(ComunidadAutonoma comunidadAutonoma);
	
	/**
	 * Baja de una Comunidad Autonoma.
	 * @param id
	 * @return true, en caso de exito
	 */
	boolean deleteComunidadAutonoma(Long id);

}