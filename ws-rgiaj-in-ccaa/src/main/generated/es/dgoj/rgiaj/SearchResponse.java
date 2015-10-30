
package es.dgoj.rgiaj;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SearchResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SearchResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numResults" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="hasNext" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="lapse" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchResponse", propOrder = {
    "numResults",
    "hasNext",
    "lapse"
})
@XmlSeeAlso({
    ComunidadSearchResponse.class,
    JugHistoricoSearchResponse.class
})
public class SearchResponse {

    protected long numResults;
    protected boolean hasNext;
    protected long lapse;

    /**
     * Obtiene el valor de la propiedad numResults.
     * 
     */
    public long getNumResults() {
        return numResults;
    }

    /**
     * Define el valor de la propiedad numResults.
     * 
     */
    public void setNumResults(long value) {
        this.numResults = value;
    }

    /**
     * Obtiene el valor de la propiedad hasNext.
     * 
     */
    public boolean isHasNext() {
        return hasNext;
    }

    /**
     * Define el valor de la propiedad hasNext.
     * 
     */
    public void setHasNext(boolean value) {
        this.hasNext = value;
    }

    /**
     * Obtiene el valor de la propiedad lapse.
     * 
     */
    public long getLapse() {
        return lapse;
    }

    /**
     * Define el valor de la propiedad lapse.
     * 
     */
    public void setLapse(long value) {
        this.lapse = value;
    }

}
