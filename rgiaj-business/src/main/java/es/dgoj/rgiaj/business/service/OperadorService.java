package es.dgoj.rgiaj.business.service;

import java.util.List;

import com.dgoj.core.common.bean.ParamBean;

/**
 * Interfaz para el mantenimiento de operadores de juego.
 * @author dgonzalez
 * @version 1.0
 */
public interface OperadorService {

	/**
	 * Devuelve el valor del campo lista operadores.
	 *
	 * @return ListaOperadores
	 */
	List<ParamBean> getListaOperadores();

}
