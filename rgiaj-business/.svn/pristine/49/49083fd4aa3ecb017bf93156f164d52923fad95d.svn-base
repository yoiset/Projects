package es.dgoj.rgiaj.business.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jeveris.persistence.hibernate.repository.impl.HibernateBaseRepositoryImpl;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.JugProhibicionQueryBean;
import es.dgoj.rgiaj.business.beans.type.TipoDescargaProhibidos;
import es.dgoj.rgiaj.business.model.JugComunidad;
import es.dgoj.rgiaj.business.model.JugHistoricodescargasproh;
import es.dgoj.rgiaj.business.model.JugProhibicion;
import es.dgoj.rgiaj.business.model.JugUsuariocomunidad;
import es.dgoj.rgiaj.business.repository.IJugProhibicionRepository;



/**  DAO Repository para gestionar los Prohibidos
 * @author ylopezconnectis
 *
 */
@Repository("jugProhibicionRepository")
public class JugProhibicionRepositoryImpl extends  HibernateBaseRepositoryImpl<JugProhibicion, Long> implements	IJugProhibicionRepository<JugProhibicion, Long> {

	@Override
	public SearchResults<JugProhibicion> getProhibidoList(JugProhibicionQueryBean jugProhibicionQueryBean) {
		// TODO Auto-generated method stub
		
		SearchResults<JugProhibicion> result= getProhibidosList(jugProhibicionQueryBean);
		return result;
	}
	
	
	/** 
	 * @param queryBean
	 * @return
	 */
	private SearchResults<JugProhibicion> getProhibidosList(JugProhibicionQueryBean queryBean) {
		
		String hql="select p from JugProhibicion p where p.jugComunidad.codigo ='NAC' and p.jugTipoProhibicion.codigo = 'RGIAJ'";
		
		Query query=null;		
				
		if (queryBean.getTipoDescargaProhibidos() == TipoDescargaProhibidos.Incremental) {
			long last=0;
			if(queryBean.getLast()!=null && queryBean.getDesde()!=null)
				last=queryBean.getLast();
			else last=getLastConfirmada(queryBean.getCodComunidad()).getUltimo();
			
			hql+= " and p.idProhibicionEnvio > :last order by p.idProhibicionEnvio desc" ;
			query = getSession().createQuery(hql).setParameter("last", last);
		}else{
			hql+=" order by p.idProhibicionEnvio desc";
			query = getSession().createQuery(hql);
		} 
			
		
		List<JugProhibicion> list= query.list();
		
		SearchResults<JugProhibicion> result= new SearchResults<JugProhibicion>( list, new Long(queryBean.getMaxResults()), new Long(queryBean.getFirstResult()),list.size());
		
		return result;
		
	}
	
		
	/** Obtiene la ultima descarga confirmada dado una Comunidad
	 * @param codComunidad
	 * @return
	 */
	public JugHistoricodescargasproh getLastConfirmada(String codComunidad){ 
		
		JugHistoricodescargasproh result=null;
		String hql="select p from JugHistoricodescargasproh p where p.jugComunidad.codigo=:comunidad and p.confirmada=1 order by  p.fechaDescarga desc";		
		Query query = getSession().createQuery(hql).setParameter("comunidad", codComunidad).setMaxResults(1);
		
		if(query.uniqueResult()!=null)
		  result=((JugHistoricodescargasproh)query.uniqueResult());		
	    return result;
			
	}
	
	@Override
	public JugHistoricodescargasproh getLast(String codComunidad) {
		JugHistoricodescargasproh result=null;
		String hql="select p from JugHistoricodescargasproh p where p.jugComunidad.codigo=:comunidad order by  p.fechaDescarga desc";		
		Query query = getSession().createQuery(hql).setParameter("comunidad", codComunidad).setMaxResults(1);
		
		if(query.uniqueResult()!=null)
		  result=((JugHistoricodescargasproh)query.uniqueResult());		
	    return result;
	}
	
	public JugComunidad getComunidad(String user){
		JugUsuariocomunidad entity=null;
		String hql="select uc from JugUsuariocomunidad uc where uc.usuario=:usuario";
		Query query = getSession().createQuery(hql).setParameter("usuario",user).setMaxResults(1);
		if(query.uniqueResult()!=null)
			return ((JugUsuariocomunidad) query.uniqueResult()).getJugComunidad();
		
		return null;
	}
	
	@Override
	public List<JugComunidad> getComunidadList() {
		// TODO Auto-generated method stub
		String hql="select c from JugComunidad c order by id desc";
		return getSession().createQuery(hql).list();
		
	}
	


	private Query createProhibidosQuery2(JugComunidad comunidad, TipoDescargaProhibidos tipoDescarga) {

		return null;
	}
	
   public List<JugProhibicion> getAllProhibidosComunidadProvinciaList(JugProhibicionQueryBean queryBean) {
		
		String hql="select p from JugProhibicion p where p.jugComunidad.codigo ='NAC' and p.jugTipoProhibicion.codigo = 'RGIAJ' and p.jugSituacion.codigo= 'AC'";
		if(queryBean.getCodComunidad()!=null){
			hql+=" and p.jugPersona.jugProvincia.jugComunidad.codigo=:codComunidad";
		}
//		hql+=" order by p.jugPersona.jugProvincia.jugComunidad.codigo desc";
		
		Query query=null;
		if(queryBean.getCodComunidad()==null)
		  query = getSession().createQuery(hql);
		else  query = getSession().createQuery(hql).setParameter("codComunidad", queryBean.getCodComunidad());
				
				
		return query.list();
		
		
	}


}
