package es.dgoj.rgiaj.business.service;

import java.util.List;

import com.dgoj.core.common.bean.ParamBean;
import com.dgoj.core.common.bean.UserBean;

import es.dgoj.rgiaj.business.beans.TipoProhibicionBean;
import es.dgoj.rgiaj.business.beans.TipoProhibicionQueryBean;
import es.dgoj.rgiaj.business.beans.TipoProhibicionSearchResult;


/**
 * Interfaz para el mantenimiento de tipos de prohibicion.
 * @author dgonzalez
 */
public interface TipoProhibicionService {

	/**
	 * Devuelve los tipos de prohibicion buscados.
	 * @param tipoProhibicionQueryBean
	 * @return TipoProhibicionSearchResult
	 */
	TipoProhibicionSearchResult getTiposProhibicion(TipoProhibicionQueryBean tipoProhibicionQueryBean);

	List<ParamBean> getListaTiposProhibicion();
	
	/**
	 * Exporta los datos de tipo de prohibicion a PDF
	 *
	 * @param username
	 * @param tipoProhibicionQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	byte[] exportTipoProhibicion(String username, TipoProhibicionQueryBean tipoProhibicionQueryBean, String reportType, String reportName, String reportTitle);

	/**
	 * Devuelve el tipo de prohibicion por Id
	 *
	 * @param id
	 * @return TipoProhibicionBean
	 */
	TipoProhibicionBean getTipoProhibicionById(Long id);
	
	/**
	 * Devuelve el tipo de prohibicion por codigo.
	 * @param codigo
	 * @return TipoProhibicionBean
	 */
	TipoProhibicionBean getTipoProhibicionByCodigo(String codigo);
	
	/**
	 * Devuelve el tipo de prohibicion por codigo que no tenga el Id.
	 * @param id 
	 * @param codigo
	 * @return TipoProhibicionBean
	 */
	TipoProhibicionBean getTipoProhibicionByCodigoNoID(Long id, String codigo);

	/**
	 * Alta de un tipo de prohibicion.
	 * @param TipoProhibicionBean the jugador prueba bean
	 * @param userBean the user bean
	 */
	void altaTipoProhibicion(TipoProhibicionBean tipoProhibicionBean, UserBean userBean);

	/**
	 * Baja de un tipo de prohibicion.
	 * @param id
	 * @param userBean
	 * @return true, en caso de exito
	 */
	boolean bajaTipoProhibicion(Long id, UserBean userBean);

	/**
	 * Edicion de un tipo de prohibicion.
	 *
	 * @param tipoProhibicionBean un tipo de prohibicion
	 * @param userBean datos del usuario
	 * @return TipoProhibicionBean el tipo de prohibicion modificado
	 */
	TipoProhibicionBean editarTipoProhibicion(TipoProhibicionBean tipoProhibicionBean, UserBean userBean);
	
}
