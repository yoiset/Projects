
package es.gob.cnjuego.ws.verificacionjugadores;

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
 *         &lt;element name="resultadosIdentidad" type="{http://ws.cnjuego.gob.es/VerificacionJugadores/}ResultadoIdentidad" maxOccurs="100"/>
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
    "resultadosIdentidad"
})
@XmlRootElement(name = "verificarIdentidadResponse")
public class VerificarIdentidadResponse {

    @XmlElement(required = true)
    protected List<ResultadoIdentidad> resultadosIdentidad;

    /**
     * Gets the value of the resultadosIdentidad property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resultadosIdentidad property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResultadosIdentidad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResultadoIdentidad }
     * 
     * 
     */
    public List<ResultadoIdentidad> getResultadosIdentidad() {
        if (resultadosIdentidad == null) {
            resultadosIdentidad = new ArrayList<ResultadoIdentidad>();
        }
        return this.resultadosIdentidad;
    }

}
