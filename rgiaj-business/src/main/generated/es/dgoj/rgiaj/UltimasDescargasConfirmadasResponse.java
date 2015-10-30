
package es.dgoj.rgiaj;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="ultimasDescargas" type="{http://rgiaj.dgoj.es/}JugProhibicionBeanWS" maxOccurs="unbounded" minOccurs="0"/>
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
    "ultimasDescargas"
})
@XmlRootElement(name = "ultimasDescargasConfirmadasResponse")
public class UltimasDescargasConfirmadasResponse {

    protected List<JugProhibicionBeanWS> ultimasDescargas;

    /**
     * Gets the value of the ultimasDescargas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ultimasDescargas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUltimasDescargas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JugProhibicionBeanWS }
     * 
     * 
     */
    public List<JugProhibicionBeanWS> getUltimasDescargas() {
        if (ultimasDescargas == null) {
            ultimasDescargas = new ArrayList<JugProhibicionBeanWS>();
        }
        return this.ultimasDescargas;
    }

}
