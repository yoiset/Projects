package es.dgoj.rgiaj.business.beans;

import java.util.List;

import com.dgoj.core.common.util.BeanFormatter;

import es.dgoj.rgiaj.business.util.AbstractSearchResult;


/**
 * Resultado de una busqueda de provincias que puede utilizar paginacion.
 * @author connecits
 */
public class ProvinciaSearchResult extends AbstractSearchResult{

	/** Campo results. */
	private List<ProvinciaBean> results;

	/**
	 * Instancia un objeto de la clase ProvinciaSearchResult rellenando la lista de resultados.
	 *
	 * @param results lista de resultados
	 */
	public ProvinciaSearchResult(List<ProvinciaBean> results) {
		this.results = results;
	}
	
	/**
	 * Instancia un objeto de la clase ProvinciaSearchResult.
	 */
	public ProvinciaSearchResult() {
	}

	/**
	 * Resultado de la busqueda. En el caso de busqueda paginada,
	 * contiene solo las entidades de la pagina.
	 *
	 * @return Results
	 */
	public List<ProvinciaBean> getResults() {
		return results;
	}
	
	/**
	 * Establece el valor del campo results.
	 *
	 * @param results the results
	 */
	public void setResults(List<ProvinciaBean> results) {
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
