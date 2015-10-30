package es.dgoj.rgiaj.business.beans;

import java.util.List;

import com.dgoj.core.common.util.BeanFormatter;

public class ComunidadSearchResult {



	/*
	 * Resultado de la búsqueda. En el caso de búsqueda paginada,
	 * contiene sólo las entidades de la página.
	 */
	private List<ComunidadBean> results;
	
	/*
	 * En el caso de búsqueda paginada, contiene el número total
	 * de resultados, siempre que en el BeanQuery se utilice calculateNumResults = true
	 * Si la búsqueda no es paginada, es null
	 */
	private Long numResults;
	
	/*
	 * En el caso de búsqueda paginada, indica que existen más
	 * resultados, siempre que en el BeanQuery se utilice calculateNumResults = false
	 * Si la búsqueda no es paginada, es null
	 */
	private Boolean hasNext;
	
	/*
	 * Tiempo de ejecución de la consulta, o null si no se calcula
	 */
	private Long lapse;

	
	/**
	 * 
	 */
	public ComunidadSearchResult() {
		super();
	}
	
	/**
	 * @param results
	 */
	public ComunidadSearchResult(List<ComunidadBean> results) {
		super();
		this.results = results;
	}
	
	

	/**
	 * List of entities, result of search.<br/> 
	 * 
	 * Resultado de la búsqueda. En el caso de búsqueda paginada,
	 * contiene sólo las entidades de la página.
	 * 
	 * @return
	 */
	public List<ComunidadBean> getResults() {
		return results;
	}
	
	/**
	 * @param results
	 */
	public void setResults(List<ComunidadBean> results) {
		this.results = results;
	}
	
	/**
	 * When {@code calculateNumResults} is {@code true}, contains total number of results.<br/>
	 * 
	 * En el caso de búsqueda paginada, contiene el número total de resultados, siempre que 
	 * en el BeanQuery se utilice calculateNumResults = true. Es la opción default, y se utiliza
	 * cuando el cálculo del total de resultados no es costoso.
	 * Si la búsqueda no es paginada, es {@code null}
	 */
	public Long getNumResults() {
		return numResults;
	}

	public void setNumResults(Long numResults) {
		this.numResults = numResults;
	}

	/**
	 * When {@code calculateNumResults} is {@code false}, indicates if there are more results.<br/>
	 * 
	 * En el caso de búsqueda paginada, indica que existen más resultados, siempre que 
	 * en el BeanQuery se utilice calculateNumResults = false. Se utiliza cuando el cálculo del
	 * total de resultados es costoso.
	 * Si la búsqueda no es paginada, es null
	 */
	public Boolean getHasNext() {
		return hasNext;
	}

	public void setHasNext(Boolean hasNext) {
		this.hasNext = hasNext;
	}

	/**
	 * Tiempo de ejecución de la consulta, o null si no se calcula.
	 */
	public Long getLapse() {
        return lapse;
    }

    public void setLapse(Long lapse) {
        this.lapse = lapse;
    }

    /**
     * Number of results in the list
     * @return
     */
    public int size() {
		return results.size();
	}

    /**
     * String representation of search results
     */
    public String toString() {
        return new BeanFormatter().format(this);
    }



}
