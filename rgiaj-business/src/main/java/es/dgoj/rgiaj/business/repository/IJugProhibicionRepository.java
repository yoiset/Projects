package es.dgoj.rgiaj.business.repository;


import java.util.List;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.JugProhibicionQueryBean;
import es.dgoj.rgiaj.business.model.JugComunidad;
import es.dgoj.rgiaj.business.model.JugHistoricodescargasproh;
import es.dgoj.rgiaj.business.model.JugProhibicion;

public interface IJugProhibicionRepository<T, ID> extends IHibernateBaseRepository<JugProhibicion, Long> {
	
	/**
	 * @param jugProhibidoBean
	 * @return
	 */
	public SearchResults<JugProhibicion> getProhibidoList  (JugProhibicionQueryBean jugProhibidoBean);
	
	/**
	 * @param codComunidad
	 * @return
	 */
	public JugHistoricodescargasproh getLastConfirmada(String codComunidad);
	
	
	/**
	 * @param user
	 * @return
	 */
	public JugComunidad getComunidad(String user);

	
	public JugHistoricodescargasproh getLast(String codComunidad);
	
	public List<JugComunidad> getComunidadList();
	
	public List<JugProhibicion> getAllProhibidosComunidadProvinciaList(JugProhibicionQueryBean queryBean);

}
