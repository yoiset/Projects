package es.dgoj.rgiaj.business.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Property;
import org.hibernate.metamodel.binding.HibernateTypeDescriptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;

import com.jeveris.persistence.hibernate.repository.impl.HibernateBaseRepositoryImpl;
import com.mysema.query.SearchResults;
import com.mysema.query.jpa.hibernate.HibernateUtil;

import es.dgoj.rgiaj.business.beans.JugHistoricoQueryBean;
import es.dgoj.rgiaj.business.beans.JugProhibicionQueryBean;
import es.dgoj.rgiaj.business.beans.type.TipoDescargaProhibidos;
import es.dgoj.rgiaj.business.exceptions.JuegoExternoException;
import es.dgoj.rgiaj.business.model.JugComunidad;
import es.dgoj.rgiaj.business.model.JugHistoricodescargasproh;
import es.dgoj.rgiaj.business.model.JugProhibicion;
import es.dgoj.rgiaj.business.repository.IJugHistoricoDescargasprohRep;
import es.dgoj.rgiaj.business.util.Constantes;

@Repository("jugHistoricodescargasprohRepository")
public class JugHistoricodescargasprohRepImpl extends  HibernateBaseRepositoryImpl<JugHistoricodescargasproh, Long> implements IJugHistoricoDescargasprohRep <JugHistoricodescargasproh, Long> {

	/* (non-Javadoc)
	 * @see es.dgoj.rgiaj.business.repository.IJugHistoricodescargasprohRepository#updateHistoricoDescargas(es.dgoj.rgiaj.business.bean.JugProhibicionQueryBean)
	 */
	@Override
	public void insertHistoricoDescargas(JugProhibicionQueryBean queryBean)	throws JuegoExternoException {
		// TODO Auto-generated method stub
		JugHistoricodescargasproh entity = new JugHistoricodescargasproh();
		if (TipoDescargaProhibidos.Completa.equals(queryBean.getTipoDescargaProhibidos())) 
			entity.setCompleta(1);
		 else entity.setCompleta(0);
		
		entity.setFechaDescarga(new Date());
		entity.setJugComunidad(getComunidad(queryBean.getCodComunidad()));
		entity.setUltimo(getLast());
		
	    entity.setConfirmada(0);
		
		getSession().persist(entity);		
	}
	
	
	
	
	
	@Override
	public void updateHistoricoDescargas(JugHistoricodescargasproh entity)	throws JuegoExternoException {
		// TODO Auto-generated method stub
		
		getSession().merge(entity);
		
	}
	
	
	


	@Override
	public List<JugHistoricodescargasproh> getUltimasDescargasConfirmadas(JugProhibicionQueryBean queryBean) throws JuegoExternoException {
		// TODO Auto-generated method stub
		String hql="select h from JugHistoricodescargasproh h " +
				"where h.jugComunidad.codigo =:codigo  " +
				"and  h.confirmada=1 " +
				"order by h.fechaDescarga desc";
		Query query = getSession().createQuery(hql).setParameter("codigo", queryBean.getCodComunidad()).setMaxResults(queryBean.getMaxResults());
		return query.list();
	}
	
	
	
	/** Obtiene el ultimo pedido     could not resolve property: jugComunidad.codigo of: es.dgoj.rgiaj.business.model.JugProhibicion
	 * @param codComunidad
	 * @return
	 */
	private long getLast(){ 
		
		long result=0;
		String hql="select p from JugProhibicion p where p.jugComunidad.codigo='NAC' and p.jugTipoProhibicion.codigo= 'RGIAJ' order by  p.idProhibicionEnvio desc";		
		Query query = getSession().createQuery(hql).setMaxResults(1);
		result=((JugProhibicion)query.uniqueResult()).getIdProhibicionEnvio();		
	    return result;
	}
	
	
	/** Devuelve una comunidad dado el Codigo
	 * @param code
	 * @return
	 */
	private JugComunidad getComunidad(String code){
		Property propCodComunidad = Property.forName("codigo");	
		
		Criteria crit = getSession().createCriteria(JugComunidad.class);
		
		crit.add(propCodComunidad.eq(code));	
	    return ((JugComunidad)crit.uniqueResult());
	}





	





	/** Obtiene el resultado de busqueda de historico
	 * @see es.dgoj.rgiaj.business.repository.IJugHistoricoDescargasprohRep#getHistorico(es.dgoj.rgiaj.business.bean.JugHistoricoQueryBean)
	 */
	@Override
	public SearchResults<JugHistoricodescargasproh> getHistorico(JugHistoricoQueryBean query) {
		// TODO Auto-generated method stub
		String hql="";
				   
		if(query.getCodComunidad()!=null)
			hql+= "select h from JugHistoricodescargasproh h where h.jugComunidad.codigo=:codigo ";
		
		if(query.getFechaDesde()!=null)
			if(!hql.isEmpty())
			  hql+= "and trunc(h.fechaDescarga) >=trunc(:fechaDesde) ";
			else hql+="select h from JugHistoricodescargasproh h where trunc(h.fechaDescarga) >=trunc(:fechaDesde) ";
		
		if(query.getFechaHasta()!=null)
			if(!hql.isEmpty())
		      hql+= "and trunc(h.fechaDescarga) <=trunc(:fechaHasta) ";
			else hql+= "select h from JugHistoricodescargasproh h where trunc(h.fechaDescarga) <=trunc(:fechaHasta) "; 
		
		if(query.getProcedencia()!=null){
			if(!hql.isEmpty()){
				if(query.getProcedencia().equalsIgnoreCase(Constantes.WS))
		            hql+= "and h.procedencia='WS' ";
				else  hql+= "and h.procedencia is null ";
			}else{
				if(query.getProcedencia().equalsIgnoreCase(Constantes.WS))
					hql+= "select h from JugHistoricodescargasproh h where h.procedencia='WS' ";
				else hql+= "select h from JugHistoricodescargasproh h where h.procedencia is null ";
			} 
		}
			
				 
		
		if(query.getConfirmada()!=null){
			if(!hql.isEmpty())
				if(!query.getConfirmada())
					 hql+= "and (h.confirmada=:conf or h.confirmada is null) ";
				else   hql+= "and h.confirmada=:conf ";
			else 
				if(!query.getConfirmada())
				   hql+= "select h from JugHistoricodescargasproh h where (h.confirmada=:conf or h.confirmada is null) "; 
				else  hql+= "select h from JugHistoricodescargasproh h where h.confirmada=:conf "; 
			
		}
		
		if(query.getFieldName()==null){
			if(!hql.isEmpty())
				  hql+="order by fechaDescarga desc";
			else hql+= "select h from JugHistoricodescargasproh h order by fechaDescarga desc";
		} else{
			String order="desc";
			if(query.getOrder()!=null && query.getOrder().equalsIgnoreCase("asc"))
			 order="asc";
			if(!hql.isEmpty())
				  hql+="order by " + query.getFieldName() + " " +  order;
			else hql+= "select h from JugHistoricodescargasproh h order by " + query.getFieldName() + " " + order;
			
		}
		
		
			
		
		Query query1= getSession().createQuery(hql);
		
		if(query.getCodComunidad()!=null)
			query1.setParameter("codigo", query.getCodComunidad());
		
		if(query.getFechaDesde()!=null)
			query1.setParameter("fechaDesde", query.getFechaDesde());
		
		if(query.getFechaHasta()!=null)
			query1.setParameter("fechaHasta", query.getFechaHasta());
		
		if(query.getConfirmada()!=null){
			int conf=0;
			if(query.getConfirmada()) conf=1;
			query1.setParameter("conf", conf);
		}
	
			
		int rowCount=query1.list().size();
		if(query.getMaxResults()==null) query.setMaxResults(rowCount);
		List<JugHistoricodescargasproh> list = query1.setFirstResult(query.getFirstResult()).setMaxResults(query.getMaxResults()).list();
		if(list!=null)
		 return new SearchResults<JugHistoricodescargasproh>(list,new Long(query.getMaxResults()),new Long(query.getFirstResult()) ,rowCount);
		
		return null;
	}
	
	
	public List<JugComunidad> getComunidadList() {
		// TODO Auto-generated method stub
		String hql="select c from JugComunidad c order by id desc";
		return getSession().createQuery(hql).list();
	
   }




	
	
//	private void update(){
//		entityManager.joinTransaction();
//		JugHistoricodescargasproh jugHistoricodescargasproh = new JugHistoricodescargasproh();
//		if (queryBean.getTipoDescargaProhibidos().Completa == TipoDescargaProhibidos.Completa) {
//			jugHistoricodescargasproh.setCompleta(1);
//		} else {
//			jugHistoricodescargasproh.setCompleta(0);
//		}
//		
//		
//		jugHistoricodescargasproh.setFechaDescarga(new Date());
//		jugHistoricodescargasproh.setJugComunidad(jugComunidadHome.buscarPorCodigo(comunidad.getCodigo()));
//		if (ultimo == 0) {
//			Long lastId = (Long) entityManager.createQuery("select max(idProhibicionEnvio) from JugProhibicion where jugComunidad.codigo = 'NAC' and jugTipoProhibicion.codigo = 'RGIAJ' ").getSingleResult();
//			if (lastId != null) {
//				ultimo = lastId;
//			}
//		}
//		jugHistoricodescargasproh.setUltimo(ultimo);
//		entityManager.persist(jugHistoricodescargasproh);
//		entityManager.flush();
//	}

	
	
}
