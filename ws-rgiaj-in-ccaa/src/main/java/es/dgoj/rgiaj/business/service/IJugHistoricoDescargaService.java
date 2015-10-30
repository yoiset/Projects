package es.dgoj.rgiaj.business.service;

import es.dgoj.rgiaj.business.bean.JugHistoricoQueryBean;
import es.dgoj.rgiaj.business.bean.JugHistoricoSearchResult;

/**
 * @author ylopezconnectis
 *
 */
public interface IJugHistoricoDescargaService {
	
	
	
	/**
	 * @param query
	 * @return
	 */
	public JugHistoricoSearchResult getHistorico(JugHistoricoQueryBean query);

}
