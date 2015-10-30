package es.dgoj.rgiaj.business.service;

import java.util.List;

import com.dgoj.core.common.bean.ParamBean;
import com.dgoj.core.common.bean.UserBean;

import es.dgoj.rgiaj.business.beans.CausaProhibicionBean;
import es.dgoj.rgiaj.business.beans.CausaProhibicionQueryBean;
import es.dgoj.rgiaj.business.beans.CausaProhibicionSearchResult;


/**
 * Interfaz para el mantenimiento de causas de prohibicion.
 * @author dgonzalez
 */
public interface CausaProhibicionService {

	/**
	 * Devuelve las causas de prohibicion buscadas.
	 * @param causaProhibicionQueryBean
	 * @return CausaProhibicionSearchResult
	 */
	CausaProhibicionSearchResult getCausasProhibicion(CausaProhibicionQueryBean causaProhibicionQueryBean);

	List<ParamBean> getListaCausasProhibicion();
	
	/**
	 * Exporta los datos de causa de prohibicion a PDF
	 *
	 * @param username
	 * @param causaProhibicionQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	byte[] exportCausaProhibicion(String username, CausaProhibicionQueryBean causaProhibicionQueryBean, String reportType, String reportName, String reportTitle);

	/**
	 * Devuelve la causa de prohibicion por Id
	 *
	 * @param id
	 * @return CausaProhibicionBean
	 */
	CausaProhibicionBean getCausaProhibicionById(Long id);
	
	/**
	 * Devuelve la causa de prohibicion por codigo.
	 * @param codigo
	 * @return CausaProhibicionBean
	 */
	CausaProhibicionBean getCausaProhibicionByCodigo(String codigo);
	
	/**
	 * Devuelve la causa de prohibicion por codigo que no tenga el Id.
	 * @param id 
	 * @param codigo
	 * @return CausaProhibicionBean
	 */
	CausaProhibicionBean getCausaProhibicionByCodigoNoID(Long id, String codigo);

	/**
	 * Alta de una causa de prohibicion.
	 * @param CausaProhibicionBean
	 * @param userBean 
	 */
	void altaCausaProhibicion(CausaProhibicionBean causaProhibicionBean, UserBean userBean);

	/**
	 * Baja de una causa de prohibicion.
	 * @param id
	 * @param userBean
	 * @return true, en caso de exito
	 */
	boolean bajaCausaProhibicion(Long id, UserBean userBean);

	/**
	 * Edicion de una causa de prohibicion.
	 *
	 * @param causaProhibicionBean una causa de prohibicion
	 * @param userBean datos del usuario
	 * @return CausaProhibicionBean la causa de prohibicion modificada
	 */
	CausaProhibicionBean editarCausaProhibicion(CausaProhibicionBean causaProhibicionBean, UserBean userBean);
	
}
