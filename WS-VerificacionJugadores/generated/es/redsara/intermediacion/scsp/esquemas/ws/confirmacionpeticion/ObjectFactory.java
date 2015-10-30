
package es.redsara.intermediacion.scsp.esquemas.ws.confirmacionpeticion;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.redsara.intermediacion.scsp.esquemas.ws.confirmacionpeticion package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TimeStamp_QNAME = new QName("http://intermediacion.redsara.es/scsp/esquemas/ws/confirmacionPeticion", "TimeStamp");
    private final static QName _IdPeticion_QNAME = new QName("http://intermediacion.redsara.es/scsp/esquemas/ws/confirmacionPeticion", "IdPeticion");
    private final static QName _CodigoCertificado_QNAME = new QName("http://intermediacion.redsara.es/scsp/esquemas/ws/confirmacionPeticion", "CodigoCertificado");
    private final static QName _NumElementos_QNAME = new QName("http://intermediacion.redsara.es/scsp/esquemas/ws/confirmacionPeticion", "NumElementos");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.redsara.intermediacion.scsp.esquemas.ws.confirmacionpeticion
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Estado }
     * 
     */
    public Estado createEstado() {
        return new Estado();
    }

    /**
     * Create an instance of {@link Atributos }
     * 
     */
    public Atributos createAtributos() {
        return new Atributos();
    }

    /**
     * Create an instance of {@link ConfirmacionPeticion }
     * 
     */
    public ConfirmacionPeticion createConfirmacionPeticion() {
        return new ConfirmacionPeticion();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://intermediacion.redsara.es/scsp/esquemas/ws/confirmacionPeticion", name = "TimeStamp")
    public JAXBElement<String> createTimeStamp(String value) {
        return new JAXBElement<String>(_TimeStamp_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://intermediacion.redsara.es/scsp/esquemas/ws/confirmacionPeticion", name = "IdPeticion")
    public JAXBElement<String> createIdPeticion(String value) {
        return new JAXBElement<String>(_IdPeticion_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://intermediacion.redsara.es/scsp/esquemas/ws/confirmacionPeticion", name = "CodigoCertificado")
    public JAXBElement<String> createCodigoCertificado(String value) {
        return new JAXBElement<String>(_CodigoCertificado_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://intermediacion.redsara.es/scsp/esquemas/ws/confirmacionPeticion", name = "NumElementos")
    public JAXBElement<Integer> createNumElementos(Integer value) {
        return new JAXBElement<Integer>(_NumElementos_QNAME, Integer.class, null, value);
    }

}
