package es.dgoj.rgiaj.business.service;

import java.util.List;

import com.dgoj.core.common.bean.ParamBean;

import es.dgoj.rgiaj.business.beans.FirmaQueryBean;
import es.dgoj.rgiaj.business.beans.FirmaSearchResult;


/**
 * Interfaz para el mantenimiento de firmas.
 * @author dgonzalez
 */
public interface FirmaService {

	/**
	 * Devuelve las firmas buscadas.
	 * @param firmaQueryBean
	 * @return FirmaSearchResult
	 */
	FirmaSearchResult getFirmas(FirmaQueryBean firmaQueryBean);
	List<ParamBean> getListaFirmas();
		
}
