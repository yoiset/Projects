
package es.redsara.intermediacion.scsp.esquemas.ws.peticion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CodigoEstado" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CodigoEstadoSecundario" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="16"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LiteralError" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TiempoEstimadoRespuesta" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="4"/>
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="9999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codigoEstado",
    "codigoEstadoSecundario",
    "literalError",
    "tiempoEstimadoRespuesta"
})
@XmlRootElement(name = "Estado")
public class Estado {

    @XmlElement(name = "CodigoEstado")
    protected String codigoEstado;
    @XmlElement(name = "CodigoEstadoSecundario")
    protected String codigoEstadoSecundario;
    @XmlElement(name = "LiteralError")
    protected String literalError;
    @XmlElement(name = "TiempoEstimadoRespuesta")
    protected Integer tiempoEstimadoRespuesta;

    /**
     * Obtiene el valor de la propiedad codigoEstado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoEstado() {
        return codigoEstado;
    }

    /**
     * Define el valor de la propiedad codigoEstado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoEstado(String value) {
        this.codigoEstado = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoEstadoSecundario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoEstadoSecundario() {
        return codigoEstadoSecundario;
    }

    /**
     * Define el valor de la propiedad codigoEstadoSecundario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoEstadoSecundario(String value) {
        this.codigoEstadoSecundario = value;
    }

    /**
     * Obtiene el valor de la propiedad literalError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLiteralError() {
        return literalError;
    }

    /**
     * Define el valor de la propiedad literalError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLiteralError(String value) {
        this.literalError = value;
    }

    /**
     * Obtiene el valor de la propiedad tiempoEstimadoRespuesta.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTiempoEstimadoRespuesta() {
        return tiempoEstimadoRespuesta;
    }

    /**
     * Define el valor de la propiedad tiempoEstimadoRespuesta.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTiempoEstimadoRespuesta(Integer value) {
        this.tiempoEstimadoRespuesta = value;
    }

}
