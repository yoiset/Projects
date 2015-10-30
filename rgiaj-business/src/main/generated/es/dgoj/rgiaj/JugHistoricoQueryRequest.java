
package es.dgoj.rgiaj;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter2;


/**
 * <p>Clase Java para JugHistoricoQueryRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JugHistoricoQueryRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rgiaj.dgoj.es/}AbstractQueryEntityRquest">
 *       &lt;sequence>
 *         &lt;element name="codComunidad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaDesde" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="fechaHasta" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="confirmada" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JugHistoricoQueryRequest", propOrder = {
    "codComunidad",
    "fechaDesde",
    "fechaHasta",
    "confirmada"
})
public class JugHistoricoQueryRequest
    extends AbstractQueryEntityRquest
{

    @XmlElement(required = true)
    protected String codComunidad;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected Date fechaDesde;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected Date fechaHasta;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean confirmada;

    /**
     * Obtiene el valor de la propiedad codComunidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodComunidad() {
        return codComunidad;
    }

    /**
     * Define el valor de la propiedad codComunidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodComunidad(String value) {
        this.codComunidad = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDesde.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getFechaDesde() {
        return fechaDesde;
    }

    /**
     * Define el valor de la propiedad fechaDesde.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaDesde(Date value) {
        this.fechaDesde = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHasta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getFechaHasta() {
        return fechaHasta;
    }

    /**
     * Define el valor de la propiedad fechaHasta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaHasta(Date value) {
        this.fechaHasta = value;
    }

    /**
     * Obtiene el valor de la propiedad confirmada.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConfirmada() {
        return confirmada;
    }

    /**
     * Define el valor de la propiedad confirmada.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConfirmada(Boolean value) {
        this.confirmada = value;
    }

}
