package es.dgoj.rgiaj.business.repository;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.TipoJuegoQueryBean;
import es.dgoj.rgiaj.business.model.TipoJuego;



public interface TipoJuegoRepository<T, ID> extends IHibernateBaseRepository<TipoJuego, Long> {

	/**
	 * Encuentra los Tipos de Juego que cumplan las condiciones.
	 * @param tipoJuegoQueryBean 
	 * @return SearchResults<TipoJuego>
	 */
	SearchResults<TipoJuego> getTiposJuego(TipoJuegoQueryBean tipoJuegoQueryBean);

	/**
	 * Encuentra un Tipo de Juego por su ID.
	 * @param id
	 * @return TipoJuego
	 */
	TipoJuego getTipoJuegoById(Long id);
	
	/**
	 * Encuentra un Tipo de Juego por su Codigo.
	 * @param codigo
	 * @return TipoJuego
	 */
	TipoJuego getTipoJuegoByCodigo(String codigo);
	
	/**
	 * Devuelve un Tipo de Juego por su codigo que no tenga un Id.
	 * @param id
	 * @param codigo
	 * @return TipoJuego
	 */
	TipoJuego getTipoJuegoByCodigoNoID(Long id, String codigo);

	/**
	 * Edicion de un Tipo de Juego.
	 * @param tipoJuego
	 * @return true, en caso de exito
	 */
	boolean updateTipoJuego(TipoJuego tipoJuego);

	/**
	 * Alta de un Tipo de Juego.
	 * @param tipoJuego
	 * @return true, en caso de exito
	 */
	boolean addTipoJuego(TipoJuego tipoJuego);
	
	/**
	 * Baja de un Tipo de Juego.
	 * @param id
	 * @return true, en caso de exito
	 */
	boolean deleteTipoJuego(Long id);

}