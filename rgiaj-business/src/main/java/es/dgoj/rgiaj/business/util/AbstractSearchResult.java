package es.dgoj.rgiaj.business.util;

import com.dgoj.core.common.util.BeanFormatter;

/**
 * Resultado de una busqueda con paginacion.
 *
 * @author dgonzalez
 * @version 1.0
 */
public class AbstractSearchResult {
	
	/** Campo numResults: contiene el numero de resultados totales */
	private Long numResults;
	
	/** Campo has next: indica si hay mas campos */
	private Boolean hasNext;
	
	/** Campo lapse: indica el desfase (registro desde el que se muestran datos) */
	private Long lapse;

	/**
	 * Constructor genérico
	 */
	public AbstractSearchResult() {
	}

	
	/**
	 * Devuelve el valor del campo num results.
	 *
	 * @return NumResults
	 */
	public Long getNumResults() {
		return numResults;
	}

	/**
	 * Establece el valor del campo num results.
	 *
	 * @param numResults the num results
	 */
	public void setNumResults(Long numResults) {
		this.numResults = numResults;
	}


	/**
	 * Devuelve el valor del campo checks for next.
	 *
	 * @return HasNext
	 */
	public Boolean getHasNext() {
		return hasNext;
	}

	/**
	 * Establece el valor del campo checks for next.
	 *
	 * @param hasNext the has next
	 */
	public void setHasNext(Boolean hasNext) {
		this.hasNext = hasNext;
	}

	/**
	 * Tiempo de ejecucion de la consulta, o null si no se calcula.
	 *
	 * @return Lapse
	 */
	public Long getLapse() {
        return lapse;
    }

    /**
     * Establece el valor del campo lapse.
     *
     * @param lapse the lapse
     */
    public void setLapse(Long lapse) {
        this.lapse = lapse;
    }

    /**
     * String representation of search results.
     *
     * @return string
     */
    public String toString() {
        return new BeanFormatter().format(this);
    }
}
