package es.dgoj.rgiaj.business.service;

import com.dgoj.core.common.bean.UserBean;

import es.dgoj.rgiaj.business.beans.TipoFirmaBean;
import es.dgoj.rgiaj.business.beans.TipoFirmaQueryBean;
import es.dgoj.rgiaj.business.beans.TipoFirmaSearchResult;


/**
 * Interfaz para el mantenimiento de tipos de Firma.
 * @author dgonzalez
 */
public interface TipoFirmaService {

	/**
	 * Devuelve los tipos de firma buscados.
	 * @param tipoFirmaQueryBean
	 * @return TipoFirmaSearchResult
	 */
	TipoFirmaSearchResult getTiposFirma(TipoFirmaQueryBean tipoFirmaQueryBean);

	/**
	 * Exporta los datos de tipo de firma a PDF
	 *
	 * @param username
	 * @param tipoFirmaQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	byte[] exportTipoFirma(String username, TipoFirmaQueryBean tipoFirmaQueryBean, String reportType, String reportName, String reportTitle);

	/**
	 * Devuelve el tipo de firma por Id
	 *
	 * @param id
	 * @return TipoFirmaBean
	 */
	TipoFirmaBean getTipoFirmaById(Long id);
	
	/**
	 * Devuelve el tipo de firma por codigo.
	 * @param codigo
	 * @return TipoFirmaBean
	 */
	TipoFirmaBean getTipoFirmaByCodigo(String codigo);
	
	/**
	 * Devuelve el tipo de firma por codigo que no tenga el Id.
	 * @param id 
	 * @param codigo
	 * @return TipoFirmaBean
	 */
	TipoFirmaBean getTipoFirmaByCodigoNoID(Long id, String codigo);

	/**
	 * Alta de un tipo de firma.
	 * @param TipoFirmaBean 
	 * @param userBean 
	 */
	void altaTipoFirma(TipoFirmaBean tipoFirmaBean, UserBean userBean);

	/**
	 * Baja de un tipo de firma.
	 * @param id
	 * @param userBean
	 * @return true, en caso de exito
	 */
	boolean bajaTipoFirma(Long id, UserBean userBean);

	/**
	 * Edicion de un tipo de firma.
	 *
	 * @param tipoFirmaBean un tipoFirma
	 * @param userBean datos del usuario
	 * @return TipoFirmaBean el tipoFirma modificado
	 */
	TipoFirmaBean editarTipoFirma(TipoFirmaBean tipoFirmaBean, UserBean userBean);
	
}
