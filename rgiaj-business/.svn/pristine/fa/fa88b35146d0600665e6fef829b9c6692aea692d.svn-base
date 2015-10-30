package es.dgoj.rgiaj.business.service;

import es.dgoj.rgiaj.business.beans.JugHistoricoQueryBean;
import es.dgoj.rgiaj.business.beans.JugHistoricoSearchResult;

/**
 * @author ylopezconnectis
 *
 */
public interface IJugHistoricoDescargaServ {
	
	
	
	/**
	 * @param query
	 * @return
	 */
	public JugHistoricoSearchResult getHistorico(JugHistoricoQueryBean query);

	
	/**
	 * @param username
	 * @param query
	 * @param reportType
	 * @param reportName
	 * @param reportTitle
	 * @return
	 */
	public byte[] exportHistorico(String username, JugHistoricoQueryBean query,	String reportType, String reportName, String reportTitle);

}
