package es.gob.cnjuego.ws.verificacionjugadores.interceptor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPMessage;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.log4j.Logger;

import sun.misc.BASE64Encoder;
import es.gob.cnjuego.ws.dao.VerificacionDao;
import es.gob.cnjuego.ws.entity.OperadorEntity;
import es.gob.cnjuego.ws.verificacionjugadores.CodigosVerificacion;

/**
 * Este interceptor extrae de la cabecera el certificdo enviado por el cliente.
 * Luego calcula un hash y con él obtiene el identificador del operador consultando la base de
 * datos. Finalmente, se inyecta el objeto con los datos operador dentro del contenxto de la invocación,
 * para que esté disponible cuando se procesan las invocaciones.
 */
public class InterceptorEntradaProcesarCertificado extends WSS4JInInterceptor {

	public static String OPERADOR = "OPERADOR";
	private static Logger log = Logger.getLogger(InterceptorEntradaProcesarCertificado.class);
	private VerificacionDao dao;

	public void handleMessage(SoapMessage mensaje) throws Fault {
		try {
			String certificadoOperador = this.getCertificado(mensaje);
			String hash = this.calcularHashCertificado(certificadoOperador);
			OperadorEntity operador = this.getDao().getOperadorByHash(hash);
			if (operador != null) {
				mensaje.getExchange().getInMessage().put(OPERADOR, operador);
			} else {
				mensaje.getExchange().getInMessage().put(OPERADOR, OperadorEntity.NullOperador());
			}
		} catch (Exception e) {
			log.error("Error procesando certificado", e);
			throw new Fault(e);
		}
	}
	
	/**
	 * Extrae el certificado que viene en las cabeceras del mensaje y lo retorna como 
	 * un string.
	 * Notar que debemos hacer una conversión del mensaje antes de poder manipularlo.
	 */
	private String getCertificado(SoapMessage mensaje) throws Exception {
		SOAPMessage documento = this.getSOAPMessage(mensaje);
		SOAPElement securityElement = this.getChildElementByName(documento.getSOAPHeader(), "Security");
		if (securityElement != null) {
			SOAPElement tokenElement = this.getChildElementByName(securityElement, "BinarySecurityToken");
			if (tokenElement != null) {
				String certificado = tokenElement.getFirstChild().getNodeValue();
				certificado = certificado.replaceAll("[\r\n]","");
				return certificado;
			}
		}
		throw new Exception("Certificate not present in the request");
	}

	/**
	 * Dado un nodo de la cabecera, retorna el nodo hijo cuyo nombre coincide con el
	 * parámetro. 
	 */
	private SOAPElement getChildElementByName(SOAPElement parent, String childName) {
		for (Iterator<SOAPElement> iterator = parent.getChildElements(); iterator.hasNext();) {
			SOAPElement child = (SOAPElement) iterator.next();
			if (child.getLocalName().equals(childName)) {
					return child;
			}
		}
		return null;
	}

	/**
	 * Calcula el hash del certificado.
	 */
	public String calcularHashCertificado(String certificado) {
		try{
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			byte[] input = digest.digest(certificado.getBytes());
			String hash = new BASE64Encoder().encode(input);
			return hash;
		} catch (NoSuchAlgorithmException e) {
			log.error("Algoritmo de Hash SHA-1 no encontrado", e);
		}
		return null;
	}
	
    private SOAPMessage getSOAPMessage(SoapMessage mensaje) {
        SAAJInInterceptor.INSTANCE.handleMessage(mensaje);
        return mensaje.getContent(SOAPMessage.class);
    }
	
	public VerificacionDao getDao() {
		return dao;
	}

	public void setDao(VerificacionDao dao) {
		this.dao = dao;
	}

}
