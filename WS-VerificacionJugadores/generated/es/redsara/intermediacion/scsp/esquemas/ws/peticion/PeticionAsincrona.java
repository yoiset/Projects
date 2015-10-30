
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
 *       &lt;all>
 *         &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/peticion}Atributos"/>
 *         &lt;element ref="{http://intermediacion.redsara.es/scsp/esquemas/ws/peticion}Solicitudes"/>
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
@XmlRootElement(name = "PeticionAsincrona")
public class PeticionAsincrona {

    @XmlElement(name = "Atributos", required = true)
    protected Atributos atributos;
    @XmlElement(name = "Solicitudes", required = true)
    protected Solicitudes solicitudes;

    /**
     * Obtiene el valor de la propiedad atributos.
     * 
     * @return
     *     possible object is
     *     {@link Atributos }
     *     
     */
    public Atributos getAtributos() {
        return atributos;
    }

    /**
     * Define el valor de la propiedad atributos.
     * 
     * @param value
     *     allowed object is
     *     {@link Atributos }
     *     
     */
    public void setAtributos(Atributos value) {
        this.atributos = value;
    }

    /**
     * Obtiene el valor de la propiedad solicitudes.
     * 
     * @return
     *     possible object is
     *     {@link Solicitudes }
     *     
     */
    public Solicitudes getSolicitudes() {
        return solicitudes;
    }

    /**
     * Define el valor de la propiedad solicitudes.
     * 
     * @param value
     *     allowed object is
     *     {@link Solicitudes }
     *     
     */
    public void setSolicitudes(Solicitudes value) {
        this.solicitudes = value;
    }

}
