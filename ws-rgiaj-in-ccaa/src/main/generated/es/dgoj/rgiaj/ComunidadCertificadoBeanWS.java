
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
 * <p>Clase Java para ComunidadCertificadoBeanWS complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ComunidadCertificadoBeanWS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rgiaj.dgoj.es/}ComunidadBeanWS">
 *       &lt;sequence>
 *         &lt;element name="fechaDesde" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="certificado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hashCertificado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="indActivo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fechaHasta" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fechaCarga" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fingerSha1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComunidadCertificadoBeanWS", propOrder = {
    "fechaDesde",
    "certificado",
    "hashCertificado",
    "indActivo",
    "fechaHasta",
    "fechaCarga",
    "fingerSha1"
})
public class ComunidadCertificadoBeanWS
    extends ComunidadBeanWS
{

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date fechaDesde;
    @XmlElement(required = true)
    protected String certificado;
    @XmlElement(required = true)
    protected String hashCertificado;
    protected int indActivo;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date fechaHasta;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date fechaCarga;
    @XmlElement(required = true)
    protected String fingerSha1;

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
     * Obtiene el valor de la propiedad certificado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificado() {
        return certificado;
    }

    /**
     * Define el valor de la propiedad certificado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificado(String value) {
        this.certificado = value;
    }

    /**
     * Obtiene el valor de la propiedad hashCertificado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHashCertificado() {
        return hashCertificado;
    }

    /**
     * Define el valor de la propiedad hashCertificado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHashCertificado(String value) {
        this.hashCertificado = value;
    }

    /**
     * Obtiene el valor de la propiedad indActivo.
     * 
     */
    public int getIndActivo() {
        return indActivo;
    }

    /**
     * Define el valor de la propiedad indActivo.
     * 
     */
    public void setIndActivo(int value) {
        this.indActivo = value;
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
     * Obtiene el valor de la propiedad fechaCarga.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getFechaCarga() {
        return fechaCarga;
    }

    /**
     * Define el valor de la propiedad fechaCarga.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaCarga(Date value) {
        this.fechaCarga = value;
    }

    /**
     * Obtiene el valor de la propiedad fingerSha1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFingerSha1() {
        return fingerSha1;
    }

    /**
     * Define el valor de la propiedad fingerSha1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFingerSha1(String value) {
        this.fingerSha1 = value;
    }

}
