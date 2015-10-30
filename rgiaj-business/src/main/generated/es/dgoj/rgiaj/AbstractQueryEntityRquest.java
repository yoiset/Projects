
package es.dgoj.rgiaj;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AbstractQueryEntityRquest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AbstractQueryEntityRquest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="firstResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxResults" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="queryTimeout" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="calculateNumResults" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="fixDatetimes" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="orders" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="order" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fieldName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractQueryEntityRquest", propOrder = {
    "firstResult",
    "maxResults",
    "queryTimeout",
    "calculateNumResults",
    "fixDatetimes",
    "orders",
    "order",
    "fieldName"
})
@XmlSeeAlso({
    ComunidadQueryRequest.class,
    JugHistoricoQueryRequest.class,
    JugProhibicionQueryRequest.class
})
public class AbstractQueryEntityRquest {

    protected int firstResult;
    protected int maxResults;
    protected int queryTimeout;
    protected boolean calculateNumResults;
    protected boolean fixDatetimes;
    protected List<String> orders;
    @XmlElement(required = true)
    protected String order;
    @XmlElement(required = true)
    protected String fieldName;

    /**
     * Obtiene el valor de la propiedad firstResult.
     * 
     */
    public int getFirstResult() {
        return firstResult;
    }

    /**
     * Define el valor de la propiedad firstResult.
     * 
     */
    public void setFirstResult(int value) {
        this.firstResult = value;
    }

    /**
     * Obtiene el valor de la propiedad maxResults.
     * 
     */
    public int getMaxResults() {
        return maxResults;
    }

    /**
     * Define el valor de la propiedad maxResults.
     * 
     */
    public void setMaxResults(int value) {
        this.maxResults = value;
    }

    /**
     * Obtiene el valor de la propiedad queryTimeout.
     * 
     */
    public int getQueryTimeout() {
        return queryTimeout;
    }

    /**
     * Define el valor de la propiedad queryTimeout.
     * 
     */
    public void setQueryTimeout(int value) {
        this.queryTimeout = value;
    }

    /**
     * Obtiene el valor de la propiedad calculateNumResults.
     * 
     */
    public boolean isCalculateNumResults() {
        return calculateNumResults;
    }

    /**
     * Define el valor de la propiedad calculateNumResults.
     * 
     */
    public void setCalculateNumResults(boolean value) {
        this.calculateNumResults = value;
    }

    /**
     * Obtiene el valor de la propiedad fixDatetimes.
     * 
     */
    public boolean isFixDatetimes() {
        return fixDatetimes;
    }

    /**
     * Define el valor de la propiedad fixDatetimes.
     * 
     */
    public void setFixDatetimes(boolean value) {
        this.fixDatetimes = value;
    }

    /**
     * Gets the value of the orders property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orders property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrders().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOrders() {
        if (orders == null) {
            orders = new ArrayList<String>();
        }
        return this.orders;
    }

    /**
     * Obtiene el valor de la propiedad order.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrder() {
        return order;
    }

    /**
     * Define el valor de la propiedad order.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrder(String value) {
        this.order = value;
    }

    /**
     * Obtiene el valor de la propiedad fieldName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Define el valor de la propiedad fieldName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldName(String value) {
        this.fieldName = value;
    }

}
