package es.dgoj.rgiaj.business.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jeveris.persistence.hibernate.repository.impl.HibernateBaseRepositoryImpl;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.ComunidadQueryBean;
import es.dgoj.rgiaj.business.beans.UsuarioQueryBean;
import es.dgoj.rgiaj.business.model.JugUsuariocomunidad;
import es.dgoj.rgiaj.business.repository.IUsuarioComunidadRepository;

/**
 * @author ylopezconnectis
 *
 */
@Repository("usuarioComunidadRepository")
public class UsuarioComunidadRepositoryImpl extends  HibernateBaseRepositoryImpl<JugUsuariocomunidad, Long> implements IUsuarioComunidadRepository<JugUsuariocomunidad, Long> {

	/** Devuelve los usuarios asociados a la query
	 * @see es.dgoj.rgiaj.business.repository.IUsuarioComunidadRepository#getListaUsuarios(es.dgoj.rgiaj.business.bean.UsuarioQueryBean)
	 */
	@Override
	public SearchResults<JugUsuariocomunidad> getListaUsuarios(	ComunidadQueryBean query) {
		// TODO Auto-generated method stub
		
		String hql="select u from JugUsuariocomunidad u where u.jugComunidad.id=:id order by u.usuario asc";
		Query myQuery=getSession().createQuery(hql).setParameter("id", query.getIdComunidad());
		
		List<JugUsuariocomunidad> list = myQuery.list();
		
		SearchResults<JugUsuariocomunidad> results = new SearchResults<JugUsuariocomunidad>(list, new Long(query.getMaxResults().intValue()), 
				new Long(query.getFirstResult().intValue() ), list.size());
		
		return results;
		
	}
	
	
	/**
	 * @param query
	 * @return
	 */
	public JugUsuariocomunidad getUsuarioComunidad(UsuarioQueryBean query){
		
		String hql="select u from JugUsuariocomunidad u where u.usuario=:user";
		Query myQuery=getSession().createQuery(hql).setParameter("user", query.getUsuario()).setMaxResults(1);
		return (JugUsuariocomunidad) myQuery.uniqueResult();
		
	}
	
	

	
}
