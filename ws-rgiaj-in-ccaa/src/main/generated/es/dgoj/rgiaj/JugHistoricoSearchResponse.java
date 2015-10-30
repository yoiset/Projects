
package es.dgoj.rgiaj;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para JugHistoricoSearchResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JugHistoricoSearchResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rgiaj.dgoj.es/}SearchResponse">
 *       &lt;sequence>
 *         &lt;element name="listaHistorico" type="{http://rgiaj.dgoj.es/}JugHistoricoBeanWS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JugHistoricoSearchResponse", propOrder = {
    "listaHistorico"
})
public class JugHistoricoSearchResponse
    extends SearchResponse
{

    protected List<JugHistoricoBeanWS> listaHistorico;

    /**
     * Gets the value of the listaHistorico property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaHistorico property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaHistorico().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JugHistoricoBeanWS }
     * 
     * 
     */
    public List<JugHistoricoBeanWS> getListaHistorico() {
        if (listaHistorico == null) {
            listaHistorico = new ArrayList<JugHistoricoBeanWS>();
        }
        return this.listaHistorico;
    }

}
