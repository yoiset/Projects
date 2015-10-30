
package es.dgoj.rgiaj;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>Clase Java para JugHistoricoBeanWS complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JugHistoricoBeanWS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idHistoricoDescarga" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="fechaDescarga" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="comunidad" type="{http://rgiaj.dgoj.es/}ComunidadBeanWS"/>
 *         &lt;element name="confirmada" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ultimo" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JugHistoricoBeanWS", propOrder = {
    "idHistoricoDescarga",
    "fechaDescarga",
    "tipo",
    "comunidad",
    "confirmada",
    "ultimo"
})
public class JugHistoricoBeanWS {

    protected long idHistoricoDescarga;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date fechaDescarga;
    @XmlElement(required = true)
    protected String tipo;
    @XmlElement(required = true)
    protected ComunidadBeanWS comunidad;
    @XmlElement(required = true)
    protected String confirmada;
    protected long ultimo;

    /**
     * Obtiene el valor de la propiedad idHistoricoDescarga.
     * 
     */
    public long getIdHistoricoDescarga() {
        return idHistoricoDescarga;
    }

    /**
     * Define el valor de la propiedad idHistoricoDescarga.
     * 
     */
    public void setIdHistoricoDescarga(long value) {
        this.idHistoricoDescarga = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDescarga.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getFechaDescarga() {
        return fechaDescarga;
    }

    /**
     * Define el valor de la propiedad fechaDescarga.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaDescarga(Date value) {
        this.fechaDescarga = value;
    }

    /**
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Obtiene el valor de la propiedad comunidad.
     * 
     * @return
     *     possible object is
     *     {@link ComunidadBeanWS }
     *     
     */
    public ComunidadBeanWS getComunidad() {
        return comunidad;
    }

    /**
     * Define el valor de la propiedad comunidad.
     * 
     * @param value
     *     allowed object is
     *     {@link ComunidadBeanWS }
     *     
     */
    public void setComunidad(ComunidadBeanWS value) {
        this.comunidad = value;
    }

    /**
     * Obtiene el valor de la propiedad confirmada.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmada() {
        return confirmada;
    }

    /**
     * Define el valor de la propiedad confirmada.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmada(String value) {
        this.confirmada = value;
    }

    /**
     * Obtiene el valor de la propiedad ultimo.
     * 
     */
    public long getUltimo() {
        return ultimo;
    }

    /**
     * Define el valor de la propiedad ultimo.
     * 
     */
    public void setUltimo(long value) {
        this.ultimo = value;
    }

}
