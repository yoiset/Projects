
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
 *         &lt;element name="DatosGenericos">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/peticion}Solicitante"/>
 *                   &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/peticion}Titular"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DatosEspecificos" type="{http://intermediacion.redsara.es/scsp/esquemas/ws/peticion}DatosEspecificosPeticionType"/>
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
    "datosGenericos",
    "datosEspecificos"
})
@XmlRootElement(name = "SolicitudTransmision")
public class SolicitudTransmision {

    @XmlElement(name = "DatosGenericos", required = true)
    protected SolicitudTransmision.DatosGenericos datosGenericos;
    @XmlElement(name = "DatosEspecificos", required = true)
    protected DatosEspecificosPeticionType datosEspecificos;

    /**
     * Obtiene el valor de la propiedad datosGenericos.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudTransmision.DatosGenericos }
     *     
     */
    public SolicitudTransmision.DatosGenericos getDatosGenericos() {
        return datosGenericos;
    }

    /**
     * Define el valor de la propiedad datosGenericos.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudTransmision.DatosGenericos }
     *     
     */
    public void setDatosGenericos(SolicitudTransmision.DatosGenericos value) {
        this.datosGenericos = value;
    }

    /**
     * Obtiene el valor de la propiedad datosEspecificos.
     * 
     * @return
     *     possible object is
     *     {@link DatosEspecificosPeticionType }
     *     
     */
    public DatosEspecificosPeticionType getDatosEspecificos() {
        return datosEspecificos;
    }

    /**
     * Define el valor de la propiedad datosEspecificos.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosEspecificosPeticionType }
     *     
     */
    public void setDatosEspecificos(DatosEspecificosPeticionType value) {
        this.datosEspecificos = value;
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
     *         &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/peticion}Solicitante"/>
     *         &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/peticion}Titular"/>
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
        "solicitante",
        "titular"
    })
    public static class DatosGenericos {

        @XmlElement(name = "Solicitante", required = true)
        protected Solicitante solicitante;
        @XmlElement(name = "Titular", required = true)
        protected Titular titular;

        /**
         * Obtiene el valor de la propiedad solicitante.
         * 
         * @return
         *     possible object is
         *     {@link Solicitante }
         *     
         */
        public Solicitante getSolicitante() {
            return solicitante;
        }

        /**
         * Define el valor de la propiedad solicitante.
         * 
         * @param value
         *     allowed object is
         *     {@link Solicitante }
         *     
         */
        public void setSolicitante(Solicitante value) {
            this.solicitante = value;
        }

        /**
         * Obtiene el valor de la propiedad titular.
         * 
         * @return
         *     possible object is
         *     {@link Titular }
         *     
         */
        public Titular getTitular() {
            return titular;
        }

        /**
         * Define el valor de la propiedad titular.
         * 
         * @param value
         *     allowed object is
         *     {@link Titular }
         *     
         */
        public void setTitular(Titular value) {
            this.titular = value;
        }

    }

}
