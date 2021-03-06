
package es.dgoj.rgiaj;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ComunidadSearchResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ComunidadSearchResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rgiaj.dgoj.es/}SearchResponse">
 *       &lt;sequence>
 *         &lt;element name="listaComunidad" type="{http://rgiaj.dgoj.es/}ComunidadCertificadoBeanWS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="listaUsuario" type="{http://rgiaj.dgoj.es/}UsuarioComunidadBeanWS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComunidadSearchResponse", propOrder = {
    "listaComunidad",
    "listaUsuario"
})
public class ComunidadSearchResponse
    extends SearchResponse
{

    protected List<ComunidadCertificadoBeanWS> listaComunidad;
    protected List<UsuarioComunidadBeanWS> listaUsuario;

    /**
     * Gets the value of the listaComunidad property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaComunidad property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaComunidad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComunidadCertificadoBeanWS }
     * 
     * 
     */
    public List<ComunidadCertificadoBeanWS> getListaComunidad() {
        if (listaComunidad == null) {
            listaComunidad = new ArrayList<ComunidadCertificadoBeanWS>();
        }
        return this.listaComunidad;
    }

    /**
     * Gets the value of the listaUsuario property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaUsuario property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaUsuario().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UsuarioComunidadBeanWS }
     * 
     * 
     */
    public List<UsuarioComunidadBeanWS> getListaUsuario() {
        if (listaUsuario == null) {
            listaUsuario = new ArrayList<UsuarioComunidadBeanWS>();
        }
        return this.listaUsuario;
    }

}
