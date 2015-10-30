
package es.mir.juego.component.ws.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

//import com.ibm.gbs.johan.ws.rgiaj.TiposOperacion;


/**
 * <p>Java class for tramitacionRegistro complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tramitacionRegistro">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fechaCarencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaFin" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaInicio" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="operacion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tramitacionRegistro", propOrder = {
    "fechaCarencia",
    "fechaFin",
    "fechaInicio",
    "operacion",
    "tipo"
})
public class TramitacionRegistro {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaCarencia;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaFin;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInicio;
    protected Integer operacion;
    protected String tipo;
    
    
	/**
     * Gets the value of the fechaCarencia property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaCarencia() {
        return fechaCarencia;
    }
    public Date getFechaCarenciaDate() {
        return fechaCarencia!=null?fechaCarencia.toGregorianCalendar().getTime():null;
    }
    /**
     * Sets the value of the fechaCarencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaCarencia(XMLGregorianCalendar value) {
        this.fechaCarencia = value;
    }

    public void setFechaCarenciaDate(Date value) throws DatatypeConfigurationException {
        this.fechaCarencia = dateToXmlCalendar(value);
    }

    private XMLGregorianCalendar dateToXmlCalendar(Date value)
			throws DatatypeConfigurationException {
		GregorianCalendar cale = (GregorianCalendar) GregorianCalendar.getInstance();
    	cale.setTime(value);
    	XMLGregorianCalendar xmlCale = DatatypeFactory.newInstance().newXMLGregorianCalendar(cale);
		return xmlCale;
	}

    /**
     * Gets the value of the fechaFin property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaFin() {
        return fechaFin;
    }
    public Date getFechaFinDate() {
        return fechaFin!=null?fechaFin.toGregorianCalendar().getTime():null;
    }

    /**
     * Sets the value of the fechaFin property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaFin(XMLGregorianCalendar value) {
        this.fechaFin = value;
    }
    public void setFechaFinDate(Date value) throws DatatypeConfigurationException {
        this.fechaFin = dateToXmlCalendar(value);
    }

    
    /**
     * Gets the value of the fechaInicio property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInicio() {
       
    	return fechaInicio;
    }
    public Date getFechaInicioDate() {
    	//en el alta no queremos que se muestre la fecha de inicio
    	if(this.getFechaInicio()==null)
    		return null;
    	
        return fechaInicio!=null?fechaInicio.toGregorianCalendar().getTime():null;
    }

    /**
     * Sets the value of the fechaInicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInicio(XMLGregorianCalendar value) {
    	this.fechaInicio = value;
    }
    public void setFechaInicioDate(Date value) throws DatatypeConfigurationException {
        if (value==null)
        	value=new Date();
    	this.fechaInicio = dateToXmlCalendar(value);
    }

    /**
     * Gets the value of the operacion property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOperacion() {
        return operacion;
    }
    
//    public String getsOperacion(){
//       	return TiposOperacion.getOperacion(operacion);
//    }
    

    /**
     * Sets the value of the operacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOperacion(Integer value) {
        this.operacion = value;
    }

    /**
     * Gets the value of the tipo property.
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
     * Sets the value of the tipo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

}
