package es.dgoj.rgiaj.business.service;

import java.util.List;


import es.dgoj.rgiaj.business.bean.ComunidadBean;
import es.dgoj.rgiaj.business.bean.JugProhibicionBean;
import es.dgoj.rgiaj.business.bean.ProhibicionQueryBean;
import es.dgoj.rgiaj.business.exceptions.JuegoExternoException;

public interface IJugProhibicionService {

	/** Devuelve el flujo de Byte de un fichero comprimido con la lista de Prohibidos en fotmato TXT o XML segun se especifica en el parametro de entrada JugProhibicionQueryBean
	 * @param queryBean
	 * @return
	 * @throws JuegoExternoException
	 */
	public byte[] getProhibidosList(ProhibicionQueryBean queryBean)throws JuegoExternoException;
	
		
	/**
	 * @param queryBean
	 * @throws JuegoExternoException
	 */
	public void confirmHistoricoDescargas(ProhibicionQueryBean queryBean) throws JuegoExternoException ;
	
	
	/**
	 * @param queryBean
	 * @return
	 */
	public boolean hasPending(ProhibicionQueryBean queryBean);
	
	
	/**
	 * @param queryBean
	 * @throws JuegoExternoException
	 */
	public void confirmHistoricoDescargasPendiente(ProhibicionQueryBean queryBean) throws JuegoExternoException;
	
	
	
	
	/**
	 * @param queryBean
	 * @return
	 * @throws JuegoExternoException
	 */
	public List<JugProhibicionBean> getUltimasDescargasConfirmadas(ProhibicionQueryBean queryBean)throws JuegoExternoException;
	
	
	
	
	/**
	 * @param user
	 * @return
	 */
	public JugProhibicionBean getComunidad(String user);
	
	
	/**
	 * @return
	 */
	public List<ComunidadBean> getComunidadList();
}
