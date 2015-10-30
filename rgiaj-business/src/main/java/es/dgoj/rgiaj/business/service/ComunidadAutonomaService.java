package es.dgoj.rgiaj.business.service;

import java.util.List;

import com.dgoj.core.common.bean.ParamBean;
import com.dgoj.core.common.bean.UserBean;

import es.dgoj.rgiaj.business.beans.ComunidadAutonomaBean;
import es.dgoj.rgiaj.business.beans.ComunidadAutonomaQueryBean;
import es.dgoj.rgiaj.business.beans.ComunidadAutonomaSearchResult;


/**
 * Interfaz para el mantenimiento de comunidades autónoma.
 * @author dgonzalez
 */
public interface ComunidadAutonomaService {

	/**
	 * Devuelve las comunidades autónoma buscadas.
	 * @param comunidadAutonomaQueryBean
	 * @return ComunidadAutonomaSearchResult
	 */
	ComunidadAutonomaSearchResult getComunidadesAutonomas(ComunidadAutonomaQueryBean comunidadAutonomaQueryBean);

	List<ParamBean> getListaComunidadesAutonomas();
	
	/**
	 * Exporta los datos de comunidad autónoma a PDF
	 *
	 * @param username
	 * @param comunidadAutonomaQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	byte[] exportComunidadAutonoma(String username, ComunidadAutonomaQueryBean comunidadAutonomaQueryBean, String reportType, String reportName, String reportTitle);

	/**
	 * Devuelve la comunidad autónoma por Id
	 *
	 * @param id
	 * @return ComunidadAutonomaBean
	 */
	ComunidadAutonomaBean getComunidadAutonomaById(Long id);
	
	/**
	 * Devuelve la comunidad autónoma por codigo.
	 * @param codigo
	 * @return ComunidadAutonomaBean
	 */
	ComunidadAutonomaBean getComunidadAutonomaByCodigo(String codigo);
	
	/**
	 * Devuelve la comunidad autónoma por codigo que no tenga el Id.
	 * @param id 
	 * @param codigo
	 * @return ComunidadAutonomaBean
	 */
	ComunidadAutonomaBean getComunidadAutonomaByCodigoNoID(Long id, String codigo);

	/**
	 * Alta de una comunidad autónoma.
	 * @param ComunidadAutonomaBean 
	 * @param userBean
	 */
	void altaComunidadAutonoma(ComunidadAutonomaBean comunidadAutonomaBean, UserBean userBean);

	/**
	 * Baja de una comunidad autónoma.
	 * @param id
	 * @param userBean
	 * @return true, en caso de exito
	 */
	boolean bajaComunidadAutonoma(Long id, UserBean userBean);

	/**
	 * Edicion de una comunidad autónoma.
	 *
	 * @param comunidadAutonomaBean una comunidad autónoma
	 * @param userBean datos del usuario
	 * @return ComunidadAutonomaBean la comunidad autónoma modificada
	 */
	ComunidadAutonomaBean editarComunidadAutonoma(ComunidadAutonomaBean comunidadAutonomaBean, UserBean userBean);
	
}
