package es.dgoj.rgiaj.business.service;

import java.util.List;

import com.dgoj.core.common.bean.ParamBean;
import com.dgoj.core.common.bean.UserBean;

import es.dgoj.rgiaj.business.beans.CargoBean;
import es.dgoj.rgiaj.business.beans.CargoQueryBean;
import es.dgoj.rgiaj.business.beans.CargoSearchResult;


/**
 * Interfaz para el mantenimiento de cargos.
 * @author dgonzalez
 */
public interface CargoService {

	/**
	 * Devuelve los cargos buscados.
	 * @param cargoQueryBean
	 * @return CargoSearchResult
	 */
	CargoSearchResult getCargos(CargoQueryBean cargoQueryBean);
	List<ParamBean> getListaCargos();
	/**
	 * Exporta los datos de cargos a PDF
	 *
	 * @param username
	 * @param cargoQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	byte[] exportCargo(String username, CargoQueryBean cargoQueryBean, String reportType, String reportName, String reportTitle);

	/**
	 * Devuelve el cargo por Id
	 *
	 * @param id
	 * @return CargoBean
	 */
	CargoBean getCargoById(Long id);
	
	/**
	 * Devuelve el cargo por codigo.
	 * @param codigo
	 * @return CargoBean
	 */
	CargoBean getCargoByCodigo(String codigo);
	
	/**
	 * Devuelve el cargo por codigo que no tenga el Id.
	 * @param id 
	 * @param codigo
	 * @return CargoBean
	 */
	CargoBean getCargoByCodigoNoID(Long id, String codigo);

	/**
	 * Alta de un cargo.
	 * @param CargoBean the jugador prueba bean
	 * @param userBean the user bean
	 */
	void altaCargo(CargoBean cargoBean, UserBean userBean);

	/**
	 * Baja de un cargo.
	 * @param id
	 * @param userBean
	 * @return true, en caso de exito
	 */
	boolean bajaCargo(Long id, UserBean userBean);

	/**
	 * Edicion de un cargo.
	 *
	 * @param cargoBean un cargo
	 * @param userBean datos del usuario
	 * @return CargoBean el cargo modificado
	 */
	CargoBean editarCargo(CargoBean cargoBean, UserBean userBean);
	
}
