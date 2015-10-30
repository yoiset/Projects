
package es.gob.cnjuego.ws.verificacionjugadores;

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
 *         &lt;element name="verificarCambiosRGIAJFault" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "verificarCambiosRGIAJFault"
})
@XmlRootElement(name = "verificarCambiosRGIAJFault")
public class VerificarCambiosRGIAJFault {

    @XmlElement(required = true)
    protected String verificarCambiosRGIAJFault;

    /**
     * Obtiene el valor de la propiedad verificarCambiosRGIAJFault.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerificarCambiosRGIAJFault() {
        return verificarCambiosRGIAJFault;
    }

    /**
     * Define el valor de la propiedad verificarCambiosRGIAJFault.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerificarCambiosRGIAJFault(String value) {
        this.verificarCambiosRGIAJFault = value;
    }

}
