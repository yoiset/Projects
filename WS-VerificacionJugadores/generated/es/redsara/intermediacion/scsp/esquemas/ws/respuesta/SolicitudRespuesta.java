
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
 *       &lt;all>
 *         &lt;element name="Atributos">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}IdPeticion"/>
 *                   &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}CodigoCertificado"/>
 *                   &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}NumElementos"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
@XmlRootElement(name = "SolicitudRespuesta")
public class SolicitudRespuesta {

    @XmlElement(name = "Atributos", required = true)
    protected SolicitudRespuesta.Atributos atributos;

    /**
     * Obtiene el valor de la propiedad atributos.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudRespuesta.Atributos }
     *     
     */
    public SolicitudRespuesta.Atributos getAtributos() {
        return atributos;
    }

    /**
     * Define el valor de la propiedad atributos.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudRespuesta.Atributos }
     *     
     */
    public void setAtributos(SolicitudRespuesta.Atributos value) {
        this.atributos = value;
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
     *         &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}CodigoCertificado"/>
     *         &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/respuesta}NumElementos"/>
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
        @XmlElement(name = "CodigoCertificado", required = true)
        protected String codigoCertificado;
        @XmlElement(name = "NumElementos")
        protected int numElementos;

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

    }

}
