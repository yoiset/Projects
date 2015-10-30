package es.dgoj.rgiaj.business.repository.impl;
//package es.dgoj.rgiaj.business.repository.impl;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//import org.hibernate.Criteria;
//import org.hibernate.Query;
//import org.hibernate.criterion.MatchMode;
//import org.hibernate.criterion.Order;
//import org.hibernate.criterion.Projections;
//import org.hibernate.criterion.Property;
//import org.springframework.stereotype.Repository;
//
//import es.dgoj.rgiaj.business.bean.ComunidadQueryBean;
//import es.dgoj.rgiaj.business.model.JugComunidad;
//import es.dgoj.rgiaj.business.model.JugComunidadCertificado;
//import es.dgoj.rgiaj.business.model.JugComunidadCertificadoPK;
//import es.dgoj.rgiaj.business.repository.IComunidadRepository;
//import com.jeveris.persistence.hibernate.repository.impl.HibernateBaseRepositoryImpl;
//import com.mysema.query.SearchResults;
//
///**
// * @author ylopezconnectis
// *
// */
//@Repository("comunidadRepository")
//public class ComunidadRepositoryImpl  extends  HibernateBaseRepositoryImpl<JugComunidadCertificado, JugComunidadCertificadoPK> implements IComunidadRepository<JugComunidadCertificado, JugComunidadCertificadoPK> {
//
//	/** Devuelve los certificados de comunidad asociados al query
//	 * @see es.dgoj.rgiaj.business.repository.IComunidadRepository#getListComunidadCertificado(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
//	 */
//	@Override
//	public SearchResults<JugComunidadCertificado> getListComunidadCertificado(ComunidadQueryBean query) {
//		// TODO Auto-generated method stub
//		
//		Criteria crit=getSession().createCriteria(JugComunidadCertificado.class);
//		
//		if(query.getIdComunidad()!=null)
//			crit.add(Property.forName("id.idComunidad").eq(query.getIdComunidad()));	
//		
//		if(query.getCertificado()!=null)
//			crit.add(Property.forName("certificado").like(query.getCertificado(),MatchMode.ANYWHERE).ignoreCase());	
//		
//		if(query.getHashCertificado()!=null)
//			crit.add(Property.forName("hashCertificado").like(query.getHashCertificado(),MatchMode.ANYWHERE).ignoreCase());
//		
//				
//		if(query.getIndActivo()!=null && !query.getIndActivo().equals(0))
//			crit.add(Property.forName("indActivo").eq(query.getIndActivo().intValue()));
//		
//		crit.addOrder(Order.desc("id.fechaDesde"));
//		crit.addOrder(Order.desc("fechaCarga"));
//		
//		
//		Long numResults = (Long) crit.setProjection(Projections.rowCount()).uniqueResult();
//		crit.setProjection(null);
//
//		crit.setFirstResult(query.getFirstResult().intValue());
//		crit.setMaxResults(query.getMaxResults().intValue());
//		
//		List<JugComunidadCertificado> list = crit.list();
//		
//		SearchResults<JugComunidadCertificado> results = new SearchResults<JugComunidadCertificado>(list, new Long(query.getMaxResults().intValue()), 
//				new Long(query.getFirstResult().intValue() ), numResults.longValue());
//		
//		return results;
//		
//	}
//	
//	
//	
//	@Override
//	public void addComunidadCertificado(ComunidadQueryBean query) {
////		JugComunidad comunidad=getComunidad(query.getIdComunidad());
//		
////		JugComunidadCertificadoPK id= new JugComunidadCertificadoPK(query.getIdComunidad(), query.getFechaDesde());
//		JugComunidadCertificado entity=new JugComunidadCertificado(new JugComunidadCertificadoPK(query.getIdComunidad(), query.getFechaDesde()));
//		
//		
//		fillEntityFromQuery(entity, query);			
//		getSession().merge(entity);
//	
//		// TODO Auto-generated method stub
//		
//		
//	}
//
//	/** Actualiza o inserta (si no existe) un nuevo certificado asociado a la comunidad
//	 * @see es.dgoj.rgiaj.business.repository.IComunidadRepository#updateComunidadCertificado(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
//	 */
//	@Override
//	public void updateComunidadCertificado(ComunidadQueryBean query) {
////		JugComunidad comunidad=getComunidad(query.getIdComunidad());
//		
////		JugComunidadCertificadoPK id= new JugComunidadCertificadoPK(query.getIdComunidad(), query.getFechaDesde());
//		JugComunidadCertificado entity=getCertificadoByHash(query);
//		
//		if(entity!=null){
//			fillEntityFromQuery(entity, query);			
//			getSession().merge(entity);
//		}
//		// TODO Auto-generated method stub
//		
//		
//	}
//	
//	
//	/**  Devuelve si un certificado esta activo dado su hash
//	 * @see es.dgoj.rgiaj.business.repository.IComunidadRepository#getCertificadoActivoByHash(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
//	 */
//	public JugComunidadCertificado getCertificadoActivoByHash(ComunidadQueryBean query){
//		
//		String hql="select c from JugComunidadCertificado c where c.hashCertificado=:hash and c.indActivo=1";
//		Query myQuery= getSession().createQuery(hql).setString("hash", query.getHashCertificado()).setMaxResults(1);
//		return (JugComunidadCertificado) myQuery.uniqueResult();
//		
//	}
//	
//	/** Devuelve el certificado activo de una comunidad
//	 * @see es.dgoj.rgiaj.business.repository.IComunidadRepository#getCertificadoActivoComunidad(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
//	 */
//	public JugComunidadCertificado getCertificadoActivoComunidad(ComunidadQueryBean query){
//		
//		String hql="select c from JugComunidadCertificado c where c.indActivo=1 and c.id.idComunidad=:idComunidad";
//		Query myQuery= getSession().createQuery(hql).setParameter("idComunidad", query.getIdComunidad()).setMaxResults(1);
//		return (JugComunidadCertificado) myQuery.uniqueResult();
//		
//	}
//	
//   public JugComunidadCertificado getCertificadoActivoOtraComunidad(ComunidadQueryBean query){
//		
//		String hql="select c from JugComunidadCertificado c where c.hashCertificado=:hash and c.indActivo=1 and c.id.idComunidad!=:idComunidad";
//		Query myQuery= getSession().createQuery(hql).setParameter("hash", query.getHashCertificado()).setParameter("idComunidad", query.getIdComunidad()).setMaxResults(1);
//		return (JugComunidadCertificado) myQuery.uniqueResult();
//		
//	}
//	
//	
//   public JugComunidadCertificado getCertificadoByHashComunidad(ComunidadQueryBean query){
//		
//		String hql="select c from JugComunidadCertificado c where c.hashCertificado=:hash and c.id.idComunidad=:idComunidad";
//		Query myQuery= getSession().createQuery(hql).setParameter("hash", query.getHashCertificado()).setParameter("idComunidad", query.getIdComunidad()).setMaxResults(1);
//		return (JugComunidadCertificado) myQuery.uniqueResult();
//		
//	}
//	
//	private void fillEntityFromQuery(JugComunidadCertificado entity,	ComunidadQueryBean query) {
//		// TODO Auto-generated method stub
//		if(query.getCertificado()!=null)
//		 entity.setCertificado(query.getCertificado());
//		
//		if(query.getHashCertificado()!=null)		
//		 entity.setHashCertificado(query.getHashCertificado());
//		
//		if(query.getFingerSha1()!=null)
//		 entity.setFingerSha1(query.getFingerSha1());
//		
//		
//		if(query.getIndActivo()!=null)
//		  entity.setIndActivo(query.getIndActivo().intValue());
//		
//		if(query.getFechaHasta()!=null)
//		 entity.setFechaHasta(query.getFechaHasta());
//		
////		if(query.getFechaCarga()!=null)
//		entity.setFechaCarga(query.getFechaCarga());
//		
//		
//	}
//	
//	
//	/** Obtiene la lista de Comunidadades registradas
//	 * @see es.dgoj.rgiaj.business.repository.IJugHistoricoDescargasprohRepository#getComunidadList()
//	 */
//	@Override
//	public List<JugComunidad> getComunidadList() {
//		// TODO Auto-generated method stub
//		String hql="select c from JugComunidad c order by id desc";
//		return getSession().createQuery(hql).list();
//		
//	}
//	
//
//	/**
//	 * @param code
//	 * @return
//	 */
//	private JugComunidad getComunidad(String code){
//		String hql="select c from JugComunidad c where c.codigo=:codigo";
//		return (JugComunidad) getSession().createQuery(hql).setParameter("codigo", code).uniqueResult();
//		
//	}
//	
//	public JugComunidad getComunidad(Long id){
//		String hql="select c from JugComunidad c where c.id=:id";
//		return (JugComunidad) getSession().createQuery(hql).setParameter("id", id).uniqueResult();
//		
//	}
//	
//   /**
// * @param query
// * @return
// */
//private JugComunidadCertificado getCertificadoByHash(ComunidadQueryBean query){
//		
//		String hql="select c from JugComunidadCertificado c where c.hashCertificado=:hash and c.id.idComunidad=:idComunidad";
//		Query myQuery= getSession().createQuery(hql).setParameter("hash", query.getHashCertificado()).setParameter("idComunidad", query.getIdComunidad()).setMaxResults(1);
//		return (JugComunidadCertificado) myQuery.uniqueResult();
//		
//	}
//
//	
//	
//}
