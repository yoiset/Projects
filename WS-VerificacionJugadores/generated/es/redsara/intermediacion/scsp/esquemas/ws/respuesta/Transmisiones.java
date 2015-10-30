
package es.redsara.intermediacion.scsp.esquemas.ws.respuesta;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="TransmisionDatos" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="DatosGenericos">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}Emisor"/>
 *                             &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}Solicitante"/>
 *                             &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}Titular"/>
 *                             &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}Transmision" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="DatosEspecificos" type="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}DatosEspecificosRespuestaType"/>
 *                 &lt;/all>
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
@XmlType(name = "", propOrder = {
    "transmisionDatos"
})
@XmlRootElement(name = "Transmisiones")
public class Transmisiones {

    @XmlElement(name = "TransmisionDatos", required = true)
    protected List<Transmisiones.TransmisionDatos> transmisionDatos;

    /**
     * Gets the value of the transmisionDatos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transmisionDatos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransmisionDatos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Transmisiones.TransmisionDatos }
     * 
     * 
     */
    public List<Transmisiones.TransmisionDatos> getTransmisionDatos() {
        if (transmisionDatos == null) {
            transmisionDatos = new ArrayList<Transmisiones.TransmisionDatos>();
        }
        return this.transmisionDatos;
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
     *       &lt;all>
     *         &lt;element name="DatosGenericos">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}Emisor"/>
     *                   &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}Solicitante"/>
     *                   &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}Titular"/>
     *                   &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}Transmision" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="DatosEspecificos" type="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}DatosEspecificosRespuestaType"/>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class TransmisionDatos {

        @XmlElement(name = "DatosGenericos", required = true)
        protected Transmisiones.TransmisionDatos.DatosGenericos datosGenericos;
        @XmlElement(name = "DatosEspecificos", namespace="http://www.map.es/scsp/esquemas/datosespecificos")
        protected DatosEspecificosRespuestaType datosEspecificos;


        /**
         * Obtiene el valor de la propiedad datosGenericos.
         * 
         * @return
         *     possible object is
         *     {@link Transmisiones.TransmisionDatos.DatosGenericos }
         *     
         */
        public Transmisiones.TransmisionDatos.DatosGenericos getDatosGenericos() {
            return datosGenericos;
        }

        /**
         * Define el valor de la propiedad datosGenericos.
         * 
         * @param value
         *     allowed object is
         *     {@link Transmisiones.TransmisionDatos.DatosGenericos }
         *     
         */
        public void setDatosGenericos(Transmisiones.TransmisionDatos.DatosGenericos value) {
            this.datosGenericos = value;
        }

        /**
         * Obtiene el valor de la propiedad datosEspecificos.
         * 
         * @return
         *     possible object is
         *     {@link DatosEspecificosRespuestaType }
         *     
         */
        public DatosEspecificosRespuestaType getDatosEspecificos() {
            return datosEspecificos;
        }

        /**
         * Define el valor de la propiedad datosEspecificos.
         * 
         * @param value
         *     allowed object is
         *     {@link DatosEspecificosRespuestaType }
         *     
         */
        public void setDatosEspecificos(DatosEspecificosRespuestaType value) {
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
         *         &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}Emisor"/>
         *         &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}Solicitante"/>
         *         &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}Titular"/>
         *         &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}Transmision" minOccurs="0"/>
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
            "emisor",
            "solicitante",
            "titular",
            "transmision"
        })
        public static class DatosGenericos {

            @XmlElement(name = "Emisor", required = true)
            protected Emisor emisor;
            @XmlElement(name = "Solicitante", required = true)
            protected Solicitante solicitante;
            @XmlElement(name = "Titular", required = true)
            protected Titular titular;
            @XmlElement(name = "Transmision")
            protected Transmision transmision;

            /**
             * Obtiene el valor de la propiedad emisor.
             * 
             * @return
             *     possible object is
             *     {@link Emisor }
             *     
             */
            public Emisor getEmisor() {
                return emisor;
            }

            /**
             * Define el valor de la propiedad emisor.
             * 
             * @param value
             *     allowed object is
             *     {@link Emisor }
             *     
             */
            public void setEmisor(Emisor value) {
                this.emisor = value;
            }

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

            /**
             * Obtiene el valor de la propiedad transmision.
             * 
             * @return
             *     possible object is
             *     {@link Transmision }
             *     
             */
            public Transmision getTransmision() {
                return transmision;
            }

            /**
             * Define el valor de la propiedad transmision.
             * 
             * @param value
             *     allowed object is
             *     {@link Transmision }
             *     
             */
            public void setTransmision(Transmision value) {
                this.transmision = value;
            }

        }

    }

}
