package es.gob.cnjuego.ws.dao;

import java.sql.BatchUpdateException;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import es.gob.cnjuego.ws.entity.OperadorEntity;

@Repository(value="operadorDAO")
public class OperadorDAOImpl implements OperadorDAO {
	
	private Logger log = Logger.getLogger(OperadorDAOImpl.class);

	@PersistenceContext//(unitName="JohanJPA",type=PersistenceContextType.TRANSACTION)
	EntityManager manager;
	
	@Override
	public Collection<OperadorEntity> obtenerOperadores() {
		Query query = manager.createQuery("SELECT o FROM OperadorEntity o");
		List<OperadorEntity> lista = query.getResultList();
		return lista;
	}
	
	@Override
	public void altaOperador(OperadorEntity operador) throws BatchUpdateException{
		manager.persist(operador);
	}
	
	@Override
	public OperadorEntity obtenerOperador(String cif) {
		Query query = manager.createQuery("SELECT o FROM OperadorEntity o WHERE o.cif = :cif");
		query.setParameter("cif", cif);
		List<OperadorEntity> lista = query.getResultList();
		OperadorEntity operador = null;
		if (lista.size()>0){
			operador = lista.get(0);
//	TODO Comentado		Collection<LicenciaGeneral> licenciasGenerales = operador.getLicenciasGenerales();
//			if (licenciasGenerales!=null){
//				for (LicenciaGeneral licencia : licenciasGenerales){
//					Hibernate.initialize(licencia.getLicenciasSingulares());
//				}
//			}
		}
		return operador;
	}

	@Override
	public void modificarOperador(OperadorEntity operador) throws BatchUpdateException{
		manager.merge(operador);
	}

	
	
	@Override
	public OperadorEntity obtenerOperadorPorHashCertificado(String hashCertificado) {
		Query query = manager.createQuery("SELECT o FROM OperadorEntity o WHERE hashCertificado = :hashCertificado and o.modeEnabled<>0");
		query.setParameter("hashCertificado", hashCertificado);
		List<OperadorEntity> lista = query.getResultList();
		OperadorEntity operador = null;
		if (lista.size()>0){
			operador = lista.get(0);
		}
		return operador;
	}
	@Override
	public OperadorEntity obtenerOperadorPorHashCertificadoAll(String hashCertificado) {
		Query query = manager.createQuery("SELECT o FROM OperadorEntity o WHERE hashCertificado = :hashCertificado ");
		query.setParameter("hashCertificado", hashCertificado);
		List<OperadorEntity> lista = query.getResultList();
		OperadorEntity operador = null;
		if (lista.size()>0){
			operador = lista.get(0);
		}
		return operador;
	}

	
	
}
