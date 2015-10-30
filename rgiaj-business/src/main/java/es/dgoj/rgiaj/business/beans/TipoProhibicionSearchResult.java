package es.dgoj.rgiaj.business.beans;

import java.util.List;

import com.dgoj.core.common.util.BeanFormatter;

import es.dgoj.rgiaj.business.util.AbstractSearchResult;


/**
 * Resultado de una busqueda de tipos de prohibicion que puede utilizar paginacion.
 * @author connecits
 */
public class TipoProhibicionSearchResult extends AbstractSearchResult{

	/** Campo results. */
	private List<TipoProhibicionBean> results;

	/**
	 * Instancia un objeto de la clase JugadorPruebaSearchResult rellenando la lista de resultados.
	 *
	 * @param results lista de resultados
	 */
	public TipoProhibicionSearchResult(List<TipoProhibicionBean> results) {
		this.results = results;
	}
	
	/**
	 * Instancia un objeto de la clase JugadorPruebaSearchResult.
	 */
	public TipoProhibicionSearchResult() {
	}

	/**
	 * Resultado de la busqueda. En el caso de busqueda paginada,
	 * contiene solo las entidades de la página.
	 *
	 * @return Results
	 */
	public List<TipoProhibicionBean> getResults() {
		return results;
	}
	
	/**
	 * Establece el valor del campo results.
	 *
	 * @param results the results
	 */
	public void setResults(List<TipoProhibicionBean> results) {
		this.results = results;
	}

    /**
     * Numero de resultados de la lista.
     *
     * @return int
     */
    public int size() {
		return results.size();
	}

    /**
     * Representacion en String de los resultados.
     *
     * @return string
     */
    public String toString() {
        return new BeanFormatter().format(this);
    }
}
