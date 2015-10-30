package es.dgoj.rgiaj.business.service;

import com.dgoj.core.common.bean.UserBean;

import es.dgoj.rgiaj.business.beans.TipoJuegoBean;
import es.dgoj.rgiaj.business.beans.TipoJuegoQueryBean;
import es.dgoj.rgiaj.business.beans.TipoJuegoSearchResult;


/**
 * Interfaz para el mantenimiento de tipos de Juego.
 * @author dgonzalez
 */
public interface TipoJuegoService {

	/**
	 * Devuelve los tipos de Juego buscados.
	 * @param tipoJuegoQueryBean
	 * @return TipoJuegoSearchResult
	 */
	TipoJuegoSearchResult getTiposJuego(TipoJuegoQueryBean tipoJuegoQueryBean);

	/**
	 * Exporta los datos de tipo de Juego a PDF
	 *
	 * @param username
	 * @param tipoJuegoQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	byte[] exportTipoJuego(String username, TipoJuegoQueryBean tipoJuegoQueryBean, String reportType, String reportName, String reportTitle);

	/**
	 * Devuelve el tipo de Juego por Id
	 *
	 * @param id
	 * @return TipoJuegoBean
	 */
	TipoJuegoBean getTipoJuegoById(Long id);
	
	/**
	 * Devuelve el tipo de Juego por codigo.
	 * @param codigo
	 * @return TipoJuegoBean
	 */
	TipoJuegoBean getTipoJuegoByCodigo(String codigo);
	
	/**
	 * Devuelve el tipo de Juego por codigo que no tenga el Id.
	 * @param id 
	 * @param codigo
	 * @return TipoJuegoBean
	 */
	TipoJuegoBean getTipoJuegoByCodigoNoID(Long id, String codigo);

	/**
	 * Alta de un tipo de Juego.
	 * @param TipoJuegoBean the jugador prueba bean
	 * @param userBean the user bean
	 */
	void altaTipoJuego(TipoJuegoBean tipoJuegoBean, UserBean userBean);

	/**
	 * Baja de un tipo de Juego.
	 * @param id
	 * @param userBean
	 * @return true, en caso de exito
	 */
	boolean bajaTipoJuego(Long id, UserBean userBean);

	/**
	 * Edicion de un tipo de Juego.
	 *
	 * @param tipoJuegoBean un tipo de Juego
	 * @param userBean datos del usuario
	 * @return TipoJuegoBean el tipo de Juego modificado
	 */
	TipoJuegoBean editarTipoJuego(TipoJuegoBean tipoJuegoBean, UserBean userBean);
	
}
