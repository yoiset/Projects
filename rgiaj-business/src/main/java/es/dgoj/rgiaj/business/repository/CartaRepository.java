package es.dgoj.rgiaj.business.repository;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.CartaQueryBean;
import es.dgoj.rgiaj.business.model.Carta;



public interface CartaRepository<T, ID> extends IHibernateBaseRepository<Carta, Long> {

	/**
	 * Encuentra las Cartas que cumplan las condiciones.
	 * @param cartaQueryBean 
	 * @return SearchResults<Carta>
	 */
	SearchResults<Carta> getCartas(CartaQueryBean cartaQueryBean);

	/**
	 * Encuentra una Carta por su ID.
	 * @param id
	 * @return Carta
	 */
	Carta getCartaById(Long id);
	
	
	/**
	 * Edicion de una Carta.
	 * @param carta
	 * @return true, en caso de exito
	 */
	boolean updateCarta(Carta carta);

	/**
	 * Alta de una Carta.
	 * @param carta
	 * @return true, en caso de exito
	 */
	boolean addCarta(Carta carta);
	
	/**
	 * Baja de una Carta.
	 * @param id
	 * @return true, en caso de exito
	 */
	boolean deleteCarta(Long id);

}