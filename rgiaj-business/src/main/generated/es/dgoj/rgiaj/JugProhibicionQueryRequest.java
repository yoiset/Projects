
package es.dgoj.rgiaj;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>Clase Java para JugProhibicionQueryRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JugProhibicionQueryRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rgiaj.dgoj.es/}AbstractQueryEntityRquest">
 *       &lt;sequence>
 *         &lt;element name="codComunidad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="formatoDescarga" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoDescarga" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="desde" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="last" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="service" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JugProhibicionQueryRequest", propOrder = {
    "codComunidad",
    "formatoDescarga",
    "tipoDescarga",
    "desde",
    "last",
    "service"
})
public class JugProhibicionQueryRequest
    extends AbstractQueryEntityRquest
{

    @XmlElement(required = true)
    protected String codComunidad;
    @XmlElement(required = true)
    protected String formatoDescarga;
    @XmlElement(required = true)
    protected String tipoDescarga;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date desde;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long last;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean service;

    /**
     * Obtiene el valor de la propiedad codComunidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodComunidad() {
        return codComunidad;
    }

    /**
     * Define el valor de la propiedad codComunidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodComunidad(String value) {
        this.codComunidad = value;
    }

    /**
     * Obtiene el valor de la propiedad formatoDescarga.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatoDescarga() {
        return formatoDescarga;
    }

    /**
     * Define el valor de la propiedad formatoDescarga.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatoDescarga(String value) {
        this.formatoDescarga = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDescarga.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDescarga() {
        return tipoDescarga;
    }

    /**
     * Define el valor de la propiedad tipoDescarga.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDescarga(String value) {
        this.tipoDescarga = value;
    }

    /**
     * Obtiene el valor de la propiedad desde.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getDesde() {
        return desde;
    }

    /**
     * Define el valor de la propiedad desde.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesde(Date value) {
        this.desde = value;
    }

    /**
     * Obtiene el valor de la propiedad last.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLast() {
        return last;
    }

    /**
     * Define el valor de la propiedad last.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLast(Long value) {
        this.last = value;
    }

    /**
     * Obtiene el valor de la propiedad service.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isService() {
        return service;
    }

    /**
     * Define el valor de la propiedad service.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setService(Boolean value) {
        this.service = value;
    }

}
