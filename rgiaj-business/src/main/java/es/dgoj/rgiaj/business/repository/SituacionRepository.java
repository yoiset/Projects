package es.dgoj.rgiaj.business.repository;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.SituacionQueryBean;
import es.dgoj.rgiaj.business.model.Situacion;



public interface SituacionRepository<T, ID> extends IHibernateBaseRepository<Situacion, Long> {

	/**
	 * Encuentra las Situaciones que cumplan las condiciones.
	 * @param situacionQueryBean 
	 * @return SearchResults<Situacion>
	 */
	SearchResults<Situacion> getSituaciones(SituacionQueryBean situacionQueryBean);

	/**
	 * Encuentra una Situacion por su ID.
	 * @param id
	 * @return Situacion
	 */
	Situacion getSituacionById(Long id);
	
	/**
	 * Encuentra una Situacion por su Codigo.
	 * @param codigo
	 * @return Situacion
	 */
	Situacion getSituacionByCodigo(String codigo);
	
	/**
	 * Devuelve una Situacion por su codigo que no tenga un Id.
	 * @param id
	 * @param codigo
	 * @return Situacion
	 */
	Situacion getSituacionByCodigoNoID(Long id, String codigo);

	/**
	 * Edicion de una Situacion.
	 * @param situacion
	 * @return true, en caso de exito
	 */
	boolean updateSituacion(Situacion situacion);

	/**
	 * Alta de una Situacion.
	 * @param situacion
	 * @return true, en caso de exito
	 */
	boolean addSituacion(Situacion situacion);
	
	/**
	 * Baja de una Situacion.
	 * @param id
	 * @return true, en caso de exito
	 */
	boolean deleteSituacion(Long id);

}