package es.dgoj.rgiaj.business.service;

import java.util.List;


import es.dgoj.rgiaj.business.beans.ComunidadBean;
import es.dgoj.rgiaj.business.beans.ComunidadProviciaReport;
import es.dgoj.rgiaj.business.beans.JugProhibicionBean;
import es.dgoj.rgiaj.business.beans.JugProhibicionQueryBean;
import es.dgoj.rgiaj.business.exceptions.JuegoExternoException;

public interface IJugProhibicionServ {

	/** Devuelve el flujo de Byte de un fichero comprimido con la lista de Prohibidos en fotmato TXT o XML segun se especifica en el parametro de entrada JugProhibicionQueryBean
	 * @param queryBean
	 * @return
	 * @throws JuegoExternoException
	 */
	public byte[] getProhibidosList(JugProhibicionQueryBean queryBean)throws JuegoExternoException;
	
		
	/**
	 * @param queryBean
	 * @throws JuegoExternoException
	 */
	public void confirmHistoricoDescargas(JugProhibicionQueryBean queryBean) throws JuegoExternoException ;
	
	
	/**
	 * @param queryBean
	 * @return
	 */
	public boolean hasPending(JugProhibicionQueryBean queryBean);
	
	
	/**
	 * @param queryBean
	 * @throws JuegoExternoException
	 */
	public void confirmHistoricoDescargasPendiente(JugProhibicionQueryBean queryBean) throws JuegoExternoException;
	
	
	
	
	/**
	 * @param queryBean
	 * @return
	 * @throws JuegoExternoException
	 */
	public List<JugProhibicionBean> getUltimasDescargasConfirmadas(JugProhibicionQueryBean queryBean)throws JuegoExternoException;
	
	
	
	
	/**
	 * @param user
	 * @return
	 */
	public JugProhibicionBean getComunidad(String user);
	
	
	/**
	 * @return
	 */
	public List<ComunidadBean> getComunidadList(); 
	
	
	public ComunidadProviciaReport getAllProhibidosComunidadProvinciaList(JugProhibicionQueryBean queryBean);
	
	public byte[] exportProhibidosComunidadProvincia(String username, JugProhibicionQueryBean query,	String reportType, String reportName, String reportTitle) ;
}
