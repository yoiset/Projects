
package es.gob.cnjuego.ws.verificacionjugadores;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>Clase Java para CambioRGIAJ complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CambioRGIAJ">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DNI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="motivoCambio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaCambio" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CambioRGIAJ", propOrder = {
    "dni",
    "motivoCambio",
    "fechaCambio"
})
public class CambioRGIAJ {

    @XmlElement(name = "DNI", required = true)
    protected String dni;
    @XmlElement(required = true)
    protected String motivoCambio;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date fechaCambio;

    /**
     * Obtiene el valor de la propiedad dni.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDNI() {
        return dni;
    }

    /**
     * Define el valor de la propiedad dni.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDNI(String value) {
        this.dni = value;
    }

    /**
     * Obtiene el valor de la propiedad motivoCambio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivoCambio() {
        return motivoCambio;
    }

    /**
     * Define el valor de la propiedad motivoCambio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivoCambio(String value) {
        this.motivoCambio = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaCambio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getFechaCambio() {
        return fechaCambio;
    }

    /**
     * Define el valor de la propiedad fechaCambio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaCambio(Date value) {
        this.fechaCambio = value;
    }

}
