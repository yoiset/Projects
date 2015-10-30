package es.dgoj.rgiaj.business.repository;

import java.util.List;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.OperadorQueryBean;
import es.dgoj.rgiaj.business.model.Operador;


/**
 * Repository interface that extends generic interface.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 * @see com.jeveris.persitence.hibernate.IHibernateBaseRepository
 */
public interface OperadorRepository<T, ID> extends IHibernateBaseRepository<Operador, Long> {

	/**
	 * Devuelve el valor del campo operador.
	 *
	 * @param operadorQuery the operador query
	 * @return Operador
	 */
	SearchResults<Operador> getOperador(OperadorQueryBean operadorQuery);

	/**
	 * Devuelve el valor del campo lista operadores.
	 *
	 * @return ListaOperadores
	 */
	List<Operador> getListaOperadores();

	/**
	 * Devuelve el valor del campo lista cache operadores.
	 *
	 * @return ListaCacheOperadores
	 */
	List<Operador> getListaCacheOperadores();

}