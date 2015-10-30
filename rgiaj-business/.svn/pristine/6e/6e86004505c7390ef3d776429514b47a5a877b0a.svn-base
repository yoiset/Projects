package es.dgoj.rgiaj.business.repository;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.ComunidadQueryBean;
import es.dgoj.rgiaj.business.beans.UsuarioQueryBean;
import es.dgoj.rgiaj.business.model.JugUsuariocomunidad;

/**
 * @author ylopezconnectis
 *
 * @param <T>
 * @param <ID>
 */
public interface IUsuarioComunidadRepository <T, ID> extends IHibernateBaseRepository<JugUsuariocomunidad,Long>{
	

	/** Devuelve los usuarios asociados a la query
	 * @param query
	 * @return
	 */
	public SearchResults<JugUsuariocomunidad> getListaUsuarios(ComunidadQueryBean query);
	
	/**
	 * @param query
	 * @return
	 */
	public JugUsuariocomunidad getUsuarioComunidad(UsuarioQueryBean query);
}
