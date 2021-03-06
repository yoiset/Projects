
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
 * <p>Clase Java para JugProhibicionBeanWS complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JugProhibicionBeanWS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idComunidad" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaDescarga" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
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
@XmlType(name = "JugProhibicionBeanWS", propOrder = {
    "idComunidad",
    "codigo",
    "descripcion",
    "fechaDescarga",
    "ultimo"
})
public class JugProhibicionBeanWS {

    protected long idComunidad;
    @XmlElement(required = true)
    protected String codigo;
    @XmlElement(required = true)
    protected String descripcion;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date fechaDescarga;
    protected long ultimo;

    /**
     * Obtiene el valor de la propiedad idComunidad.
     * 
     */
    public long getIdComunidad() {
        return idComunidad;
    }

    /**
     * Define el valor de la propiedad idComunidad.
     * 
     */
    public void setIdComunidad(long value) {
        this.idComunidad = value;
    }

    /**
     * Obtiene el valor de la propiedad codigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define el valor de la propiedad codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
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
