
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
 *         &lt;element name="jugadores" type="{http://ws.cnjuego.gob.es/VerificacionJugadores/}Jugador" maxOccurs="100"/>
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
    "jugadores"
})
@XmlRootElement(name = "verificarRGIAJ")
public class VerificarRGIAJ {

    @XmlElement(required = true)
    protected List<Jugador> jugadores;

    /**
     * Gets the value of the jugadores property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jugadores property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJugadores().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Jugador }
     * 
     * 
     */
    public List<Jugador> getJugadores() {
        if (jugadores == null) {
            jugadores = new ArrayList<Jugador>();
        }
        return this.jugadores;
    }

}
