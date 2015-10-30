package es.dgoj.rgiaj.business.repository;

import java.util.List;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.JugHistoricoQueryBean;
import es.dgoj.rgiaj.business.beans.JugProhibicionQueryBean;
import es.dgoj.rgiaj.business.exceptions.JuegoExternoException;
import es.dgoj.rgiaj.business.model.JugHistoricodescargasproh;

public interface IJugHistoricoDescargasprohRep <T, ID> extends IHibernateBaseRepository<JugHistoricodescargasproh, Long>  {
	
	/** Actualiza el historico de descargas
	 * @param query
	 * @throws JuegoExternoException
	 */
	public void insertHistoricoDescargas(JugProhibicionQueryBean query) throws JuegoExternoException;
	
		
	/**
	 * @param entity
	 * @throws JuegoExternoException
	 */
	public void updateHistoricoDescargas(JugHistoricodescargasproh entity)	throws JuegoExternoException;
	
	
	
	/**
	 * @param queryBean
	 * @return
	 * @throws JuegoExternoException
	 */
	public List<JugHistoricodescargasproh> getUltimasDescargasConfirmadas(JugProhibicionQueryBean queryBean)throws JuegoExternoException;
	
	
	
	

	/**
	 * @param query
	 * @return
	 */
	public SearchResults<JugHistoricodescargasproh> getHistorico(	JugHistoricoQueryBean query) ;
	

}
