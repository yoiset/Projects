package es.dgoj.rgiaj.business.repository;

import java.util.List;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.bean.JugHistoricoQueryBean;
import es.dgoj.rgiaj.business.bean.ProhibicionQueryBean;
import es.dgoj.rgiaj.business.exceptions.JuegoExternoException;
import es.dgoj.rgiaj.business.model.JugComunidad;
import es.dgoj.rgiaj.business.model.JugHistoricodescargasproh;

public interface IJugHistoricoDescargasprohRepository <T, ID> extends IHibernateBaseRepository<JugHistoricodescargasproh, Long>  {
	
	/** Actualiza el historico de descargas
	 * @param query
	 * @throws JuegoExternoException
	 */
	public void insertHistoricoDescargas(ProhibicionQueryBean query) throws JuegoExternoException;
	
		
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
	public List<JugHistoricodescargasproh> getUltimasDescargasConfirmadas(ProhibicionQueryBean queryBean)throws JuegoExternoException;
	
	
	
	

	/**
	 * @param query
	 * @return
	 */
	public SearchResults<JugHistoricodescargasproh> getHistorico(	JugHistoricoQueryBean query) ;
	
	
	/**
	 * @return
	 */
	public List<JugComunidad> getComunidadList();
	

}
