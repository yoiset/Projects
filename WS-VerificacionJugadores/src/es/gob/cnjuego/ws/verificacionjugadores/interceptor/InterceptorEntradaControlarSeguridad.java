package es.gob.cnjuego.ws.verificacionjugadores.interceptor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;

import org.apache.cxf.binding.soap.SoapFault;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.log4j.Logger;
import org.apache.ws.security.WSSecurityEngineResult;
import org.apache.ws.security.components.crypto.Crypto;
import org.apache.ws.security.components.crypto.Merlin;
import org.w3c.dom.Document;

import es.gob.cnjuego.ws.dao.VerificacionDao;
import es.gob.cnjuego.ws.util.Constantes;

/**
 * Este interceptor verifica la validez de la firma digital del mensaje SOAP y adem�s
 * que el timestamp no haya expirado.
 * La verificaci�n de la firma en nuestro caso consiste en tomar el certificado que viaja en
 * el mensaje (elemento <BinarySecurityToken>) y usarlo para verificar la firma del cuerpo y el
 * timestamp. Para ello hemos reimplementado un par de clases de WSS4J, para
 * desactivar algunas fases (validaci�n usando un almac�n de certificados).
 * Por lo dem�s, la validaci�n de la firma y timestamp se realizan de forma est�ndar.
 */
public class InterceptorEntradaControlarSeguridad extends WSS4JInInterceptor {

	private static Logger log = Logger.getLogger(InterceptorEntradaControlarSeguridad.class);
	private VerificacionDao dao;

	public void handleMessage(SoapMessage mensaje) throws Fault {
		try {
			Document documentoXML = this.toDocument(mensaje);
			DgojWSSecurityEngine securityEngine = new DgojWSSecurityEngine();
			securityEngine.processSecurityHeader(documentoXML, null, null, new Merlin());
			if (!this.comprobarPresenciaTimestamp(mensaje)) {
				throw new RuntimeException("Required timestamp not present.");
			} else {
				mensaje.put(SECURITY_PROCESSED, Boolean.TRUE);
			}
		} catch (Exception e) {
			log.error("Error de seguridad", e);
			throw new SoapFault("Security error: " + e.getMessage(), e, mensaje.getVersion().getSender());
		}
	}
	
	/**
	 * Retorna un documento XML para el mensaje SOAP recibido.
	 */
    private Document toDocument(SoapMessage mensaje) throws TransformerConfigurationException, TransformerException, SOAPException, IOException {
        SAAJInInterceptor.INSTANCE.handleMessage(mensaje);
        SOAPMessage soapMsg = mensaje.getContent(SOAPMessage.class);
		Source src = soapMsg.getSOAPPart().getContent();  
		TransformerFactory tf = TransformerFactory.newInstance();  
		Transformer transformer = tf.newTransformer();  
		DOMResult result = new DOMResult();  
		transformer.transform(src, result);  
		return (Document)result.getNode();  
	}  
	
    /**
     * Comprueba si el mensaje incluye el timestamp. Esta comprobaci�n 
     * NO debe hacerse cuando la propiedad "verificarJugadores.timestamp.opcional" vale true.
     * En cualquier otro caso, se realiza la comprobaci�n.
     * Retorna 'true': cuando la comprobaci�n es correcta o bien no es necesaria
     * Retorna 'false': cuando el timestamp no est� presente en el mensaje
     * 
     * Nota: la *caducidad* del timestamp es validada por CXF cuando comprueba
     * la firma digital. Pero CXF lo hace solamente si el timestamp viene en el mensaje.
     * Por esa raz�n, aqu� simplemente comprobamos la presencia del elemento en el XML.
     */
    private boolean comprobarPresenciaTimestamp(SoapMessage mensaje) throws Exception {
    	String timestampOpcional = this.getDao().getValorPropiedad(Constantes.CFG_TIMESTAMP_OPCIONAL);
    	if (timestampOpcional != null && timestampOpcional.toLowerCase().equals("true") ) {
			return true;
		}
		SAAJInInterceptor.INSTANCE.handleMessage(mensaje);
		SOAPMessage doc = mensaje.getContent(SOAPMessage.class);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		doc.writeTo(baos);
		String soapString = new String(baos.toByteArray());
		return soapString.toLowerCase().indexOf("timestamp") > -1;
    }

	public VerificacionDao getDao() {
		return dao;
	}

	public void setDao(VerificacionDao dao) {
		this.dao = dao;
	}
}
