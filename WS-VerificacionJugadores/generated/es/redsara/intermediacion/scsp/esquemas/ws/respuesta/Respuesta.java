
package es.redsara.intermediacion.scsp.esquemas.ws.respuesta;

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
 *         &lt;element name="Atributos">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}IdPeticion"/>
 *                   &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}NumElementos"/>
 *                   &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}TimeStamp"/>
 *                   &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}Estado" minOccurs="0"/>
 *                   &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}CodigoCertificado"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}Transmisiones" minOccurs="0"/>
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
    "atributos",
    "transmisiones"
})
@XmlRootElement(name = "Respuesta")
public class Respuesta {

    @XmlElement(name = "Atributos", required = true)
    protected Respuesta.Atributos atributos;
    @XmlElement(name = "Transmisiones")
    protected Transmisiones transmisiones;

    /**
     * Obtiene el valor de la propiedad atributos.
     * 
     * @return
     *     possible object is
     *     {@link Respuesta.Atributos }
     *     
     */
    public Respuesta.Atributos getAtributos() {
        return atributos;
    }

    /**
     * Define el valor de la propiedad atributos.
     * 
     * @param value
     *     allowed object is
     *     {@link Respuesta.Atributos }
     *     
     */
    public void setAtributos(Respuesta.Atributos value) {
        this.atributos = value;
    }

    /**
     * Obtiene el valor de la propiedad transmisiones.
     * 
     * @return
     *     possible object is
     *     {@link Transmisiones }
     *     
     */
    public Transmisiones getTransmisiones() {
        return transmisiones;
    }

    /**
     * Define el valor de la propiedad transmisiones.
     * 
     * @param value
     *     allowed object is
     *     {@link Transmisiones }
     *     
     */
    public void setTransmisiones(Transmisiones value) {
        this.transmisiones = value;
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
     *         &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}IdPeticion"/>
     *         &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}NumElementos"/>
     *         &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}TimeStamp"/>
     *         &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}Estado" minOccurs="0"/>
     *         &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}CodigoCertificado"/>
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
    public static class Atributos {

        @XmlElement(name = "IdPeticion", required = true)
        protected String idPeticion;
        @XmlElement(name = "NumElementos")
        protected int numElementos;
        @XmlElement(name = "TimeStamp", required = true)
        protected String timeStamp;
        @XmlElement(name = "Estado")
        protected Estado estado;
        @XmlElement(name = "CodigoCertificado", required = true)
        protected String codigoCertificado;

        /**
         * Obtiene el valor de la propiedad idPeticion.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIdPeticion() {
            return idPeticion;
        }

        /**
         * Define el valor de la propiedad idPeticion.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIdPeticion(String value) {
            this.idPeticion = value;
        }

        /**
         * Obtiene el valor de la propiedad numElementos.
         * 
         */
        public int getNumElementos() {
            return numElementos;
        }

        /**
         * Define el valor de la propiedad numElementos.
         * 
         */
        public void setNumElementos(int value) {
            this.numElementos = value;
        }

        /**
         * Obtiene el valor de la propiedad timeStamp.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTimeStamp() {
            return timeStamp;
        }

        /**
         * Define el valor de la propiedad timeStamp.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTimeStamp(String value) {
            this.timeStamp = value;
        }

        /**
         * Obtiene el valor de la propiedad estado.
         * 
         * @return
         *     possible object is
         *     {@link Estado }
         *     
         */
        public Estado getEstado() {
            return estado;
        }

        /**
         * Define el valor de la propiedad estado.
         * 
         * @param value
         *     allowed object is
         *     {@link Estado }
         *     
         */
        public void setEstado(Estado value) {
            this.estado = value;
        }

        /**
         * Obtiene el valor de la propiedad codigoCertificado.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodigoCertificado() {
            return codigoCertificado;
        }

        /**
         * Define el valor de la propiedad codigoCertificado.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodigoCertificado(String value) {
            this.codigoCertificado = value;
        }

    }

}
