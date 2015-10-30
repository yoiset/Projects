
package es.redsara.intermediacion.scsp.esquemas.ws.respuesta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DatosEspecificosRespuestaType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DatosEspecificosRespuestaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EstadoResultado">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CodigoEstado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="LiteralError" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
@XmlType(name = "DatosEspecificosRespuestaType", propOrder = {
    "estadoResultado"
})
public class DatosEspecificosRespuestaType {

	@XmlElement(name = "EstadoResultado", namespace="http://www.map.es/scsp/esquemas/datosespecificos")
	protected DatosEspecificosRespuestaType.EstadoResultado estadoResultado;

    /**
     * Obtiene el valor de la propiedad estadoResultado.
     * 
     * @return
     *     possible object is
     *     {@link DatosEspecificosRespuestaType.EstadoResultado }
     *     
     */
    public DatosEspecificosRespuestaType.EstadoResultado getEstadoResultado() {
        return estadoResultado;
    }

    /**
     * Define el valor de la propiedad estadoResultado.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosEspecificosRespuestaType.EstadoResultado }
     *     
     */
    public void setEstadoResultado(DatosEspecificosRespuestaType.EstadoResultado value) {
        this.estadoResultado = value;
    }


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
     *         &lt;element name="CodigoEstado" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="LiteralError" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "literalError"
    })
    public static class EstadoResultado {

    	@XmlElement(name = "CodigoEstado", namespace="http://www.map.es/scsp/esquemas/datosespecificos")
    	protected String codigoEstado;
    	@XmlElement(name = "LiteralError", namespace="http://www.map.es/scsp/esquemas/datosespecificos")
    	protected String literalError;


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

    }

}
