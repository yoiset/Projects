
package es.gob.cnjuego.ws.verificacionjugadores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Resultado de dar baja a un jugador. Incluye:
 * 						dni: El	Documento Nacional de Identidad del jugador.
 * 						resultadoType: (codigo del resultado,  y descripción)						
 * 					
 * 
 * <p>Clase Java para ResultadoBajaJugador complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ResultadoBajaJugador">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dni" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="resultadoBaja" type="{http://ws.cnjuego.gob.es/VerificacionJugadores/}ResultadoType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultadoBajaJugador", propOrder = {
    "dni",
    "resultadoBaja"
})
public class ResultadoBajaJugador {

    @XmlElement(required = true)
    protected String dni;
    @XmlElement(required = true)
    protected ResultadoType resultadoBaja;

    /**
     * Obtiene el valor de la propiedad dni.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDni() {
        return dni;
    }

    /**
     * Define el valor de la propiedad dni.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDni(String value) {
        this.dni = value;
    }

    /**
     * Obtiene el valor de la propiedad resultadoBaja.
     * 
     * @return
     *     possible object is
     *     {@link ResultadoType }
     *     
     */
    public ResultadoType getResultadoBaja() {
        return resultadoBaja;
    }

    /**
     * Define el valor de la propiedad resultadoBaja.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultadoType }
     *     
     */
    public void setResultadoBaja(ResultadoType value) {
        this.resultadoBaja = value;
    }

}
