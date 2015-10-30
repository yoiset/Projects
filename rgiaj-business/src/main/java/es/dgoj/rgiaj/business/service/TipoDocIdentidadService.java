package es.dgoj.rgiaj.business.service;

import java.util.List;

import com.dgoj.core.common.bean.UserBean;
import com.dgoj.core.common.bean.ParamBean;

import es.dgoj.rgiaj.business.beans.TipoDocIdentidadBean;
import es.dgoj.rgiaj.business.beans.TipoDocIdentidadQueryBean;
import es.dgoj.rgiaj.business.beans.TipoDocIdentidadSearchResult;

/**
 * Interfaz para el mantenimiento de tipos de documentos de identidad.
 * @author dgonzalez
 */
public interface TipoDocIdentidadService {

	/**
	 * Devuelve los tipos de documentos de identidad buscados.
	 * @param tipoDocIdentidadQueryBean
	 * @return TipoDocIdentidadSearchResult
	 */
	TipoDocIdentidadSearchResult getTiposDocIdentidad(TipoDocIdentidadQueryBean tipoDocIdentidadQueryBean);

	/**
	 * Exporta los datos de tipo de documentos de identidad a PDF
	 *
	 * @param username
	 * @param tipoDocIdentidadQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	byte[] exportTipoDocIdentidad(String username, TipoDocIdentidadQueryBean tipoDocIdentidadQueryBean, String reportType, String reportName, String reportTitle);

	/**
	 * Devuelve el tipo de documento de identidad por Id
	 *
	 * @param id
	 * @return TipoDocIdentidadBean
	 */
	TipoDocIdentidadBean getTipoDocIdentidadById(Long id);
	
	/**
	 * Devuelve el tipo de documento de identidad por codigo.
	 * @param codigo
	 * @return TipoDocIdentidadBean
	 */
	TipoDocIdentidadBean getTipoDocIdentidadByCodigo(String codigo);
	
	/**
	 * Devuelve el tipo de documento de identidad por codigo que no tenga el Id.
	 * @param id 
	 * @param codigo
	 * @return TipoDocIdentidadBean
	 */
	TipoDocIdentidadBean getTipoDocIdentidadByCodigoNoID(Long id, String codigo);

	/**
	 * Alta de un tipo de documentos de identidad.
	 * @param TipoDocIdentidadBean 
	 * @param userBean 
	 */
	void altaTipoDocIdentidad(TipoDocIdentidadBean tipoDocIdentidadBean, UserBean userBean);

	/**
	 * Baja de un tipo de documento de identidad.
	 * @param id
	 * @param userBean
	 * @return true, en caso de exito
	 */
	boolean bajaTipoDocIdentidad(Long id, UserBean userBean);

	/**
	 * Edicion de un tipo de documentos de identidad.
	 *
	 * @param tipoDocIdentidadBean un tipo de documento de identidad
	 * @param userBean datos del usuario
	 * @return TipoDocIdentidadBean el tipo de documento de identidad modificado
	 */
	TipoDocIdentidadBean editarTipoDocIdentidad(TipoDocIdentidadBean tipoDocIdentidadBean, UserBean userBean);

	/**
	 * Devuelve la lista de tipos de documentos de identidad para mostar en un combo.
	 * @return List<ParamBean>, la lista de tipos
	 */
	List<ParamBean> getListaTiposDocIdentidad();
	
}
