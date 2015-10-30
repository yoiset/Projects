package es.dgoj.rgiaj.business.service;

import java.util.List;

import com.dgoj.core.common.bean.ParamBean;
import com.dgoj.core.common.bean.UserBean;

import es.dgoj.rgiaj.business.beans.SituacionBean;
import es.dgoj.rgiaj.business.beans.SituacionQueryBean;
import es.dgoj.rgiaj.business.beans.SituacionSearchResult;


/**
 * Interfaz para el mantenimiento de situaciones.
 * @author dgonzalez
 */
public interface SituacionService {

	/**
	 * Devuelve las situaciones buscadas.
	 * @param situacionQueryBean
	 * @return SituacionSearchResult
	 */
	SituacionSearchResult getSituaciones(SituacionQueryBean situacionQueryBean);

	List<ParamBean> getListaSituaciones();
	
	/**
	 * Exporta los datos de tipo de prohibicion a PDF
	 *
	 * @param username
	 * @param situacionQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	byte[] exportSituacion(String username, SituacionQueryBean situacionQueryBean, String reportType, String reportName, String reportTitle);

	/**
	 * Devuelve la situacion por Id
	 *
	 * @param id
	 * @return SituacionBean
	 */
	SituacionBean getSituacionById(Long id);
	
	/**
	 * Devuelve la situacion por codigo.
	 * @param codigo
	 * @return SituacionBean
	 */
	SituacionBean getSituacionByCodigo(String codigo);
	
	/**
	 * Devuelve la situacion por codigo que no tenga el Id.
	 * @param id 
	 * @param codigo
	 * @return SituacionBean
	 */
	SituacionBean getSituacionByCodigoNoID(Long id, String codigo);

	/**
	 * Alta de una situacion.
	 * @param SituacionBean 
	 * @param userBean 
	 */
	void altaSituacion(SituacionBean situacionBean, UserBean userBean);

	/**
	 * Baja de una situacion.
	 * @param id
	 * @param userBean
	 * @return true, en caso de exito
	 */
	boolean bajaSituacion(Long id, UserBean userBean);

	/**
	 * Edicion de una situacion.
	 *
	 * @param situacionBean una situacion
	 * @param userBean datos del usuario
	 * @return SituacionBean la situacion modificada
	 */
	SituacionBean editarSituacion(SituacionBean situacionBean, UserBean userBean);
	
}
