package es.dgoj.rgiaj.business.repository;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.TipoDocIdentidadQueryBean;
import es.dgoj.rgiaj.business.model.TipoDocIdentidad;



public interface TipoDocIdentidadRepository<T, ID> extends IHibernateBaseRepository<TipoDocIdentidad, Long> {

	/**
	 * Encuentra los Tipos de Documentos de Identidad que cumplan las condiciones.
	 * @param tipoDocIdentidadQueryBean 
	 * @return SearchResults<TipoDocIdentidad>
	 */
	SearchResults<TipoDocIdentidad> getTiposDocIdentidad(TipoDocIdentidadQueryBean tipoDocIdentidadQueryBean);

	/**
	 * Encuentra un Tipo de Documento de Identidad por su ID.
	 * @param id
	 * @return TipoDocIdentidad
	 */
	TipoDocIdentidad getTipoDocIdentidadById(Long id);
	
	/**
	 * Encuentra un Tipo de Documento de Identidad por su Codigo.
	 * @param codigo
	 * @return TipoDocIdentidad
	 */
	TipoDocIdentidad getTipoDocIdentidadByCodigo(String codigo);
	
	/**
	 * Devuelve un Tipo de Documento de Identidad por su codigo que no tenga un Id.
	 * @param id
	 * @param codigo
	 * @return TipoDocIdentidad
	 */
	TipoDocIdentidad getTipoDocIdentidadByCodigoNoID(Long id, String codigo);

	/**
	 * Edicion de un Tipo de Documento de Identidad.
	 * @param tipoDocIdentidad
	 * @return true, en caso de exito
	 */
	boolean updateTipoDocIdentidad(TipoDocIdentidad tipoDocIdentidad);

	/**
	 * Alta de un Tipo de Documento de Identidad.
	 * @param tipoDocIdentidad
	 * @return true, en caso de exito
	 */
	boolean addTipoDocIdentidad(TipoDocIdentidad tipoDocIdentidad);
	
	/**
	 * Baja de un Tipo de Documento de Identidad.
	 * @param id
	 * @return true, en caso de exito
	 */
	boolean deleteTipoDocIdentidad(Long id);

}