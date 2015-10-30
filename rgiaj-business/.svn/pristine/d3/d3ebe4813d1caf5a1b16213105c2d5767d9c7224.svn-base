package es.dgoj.rgiaj.business.service;

import com.dgoj.core.common.bean.UserBean;

import es.dgoj.rgiaj.business.beans.CartaBean;
import es.dgoj.rgiaj.business.beans.CartaQueryBean;
import es.dgoj.rgiaj.business.beans.CartaSearchResult;


/**
 * Interfaz para el mantenimiento de cartas.
 * @author dgonzalez
 */
public interface CartaService {

	/**
	 * Devuelve las cartas buscados.
	 * @param cartaQueryBean
	 * @return CartaSearchResult
	 */
	CartaSearchResult getCartas(CartaQueryBean cartaQueryBean);

	/**
	 * Exporta los datos de cartas a PDF
	 *
	 * @param username
	 * @param cartaQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	byte[] exportCarta(String username, CartaQueryBean cartaQueryBean, String reportType, String reportName, String reportTitle);

	/**
	 * Devuelve la carta por Id
	 *
	 * @param id 
	 * @return CartaBean, una carta
	 */
	CartaBean getCartaById(Long id);

	/**
	 * Alta de una carta.
	 * @param CartaBean, una carta
	 * @param userBean, datos del usuario
	 */
	void altaCarta(CartaBean cartaBean, UserBean userBean);

	/**
	 * Baja de una carta.
	 * @param id
	 * @param userBean
	 * @return true, en caso de exito
	 */
	boolean bajaCarta(Long id, UserBean userBean);

	/**
	 * Edicion de una carta.
	 *
	 * @param cartaBean, una carta
	 * @param userBean, datos del usuario
	 * @return CartaBean, la carta modificado
	 */
	CartaBean editarCarta(CartaBean cartaBean, UserBean userBean);
	
}
