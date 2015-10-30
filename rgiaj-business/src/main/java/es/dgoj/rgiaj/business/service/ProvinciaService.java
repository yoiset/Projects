package es.dgoj.rgiaj.business.service;

import java.util.List;

import com.dgoj.core.common.bean.ParamBean;

import es.dgoj.rgiaj.business.beans.ProvinciaQueryBean;
import es.dgoj.rgiaj.business.beans.ProvinciaSearchResult;


/**
 * Interfaz para el mantenimiento de provincias
 * @author dgonzalez
 */
public interface ProvinciaService {

	/**
	 * Devuelve las provincias buscadas.
	 * @param provinciaQueryBean
	 * @return ProvinciaSearchResult
	 */
	ProvinciaSearchResult getProvincias(ProvinciaQueryBean provinciaQueryBean);

	List<ParamBean> getListaProvincias();
	
}
