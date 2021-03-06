package es.gob.cnjuego.ws.verificacionjugadores.interceptor;

import java.io.ByteArrayOutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.xml.soap.SOAPMessage;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.SoapActionInInterceptor;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.log4j.Logger;

import es.gob.cnjuego.ws.dao.VerificacionDao;
import es.gob.cnjuego.ws.entity.OperadorEntity;
import es.gob.cnjuego.ws.entity.PeticionEntity;

/**
 * Este interceptor crea una petici�n para guardar el mensaje SOAP entrante (serializado)
 * en la base de datos, junto con el ID del operador y el nombre de la operaci�n que se invoca.
 * El mensaje se guarda por cuestiones legales y para poder hacer consultas sobre las peticiones
 * recibidas.
 * Por otro lado, tambi�n se guardan algunos datos de la petici�n HTTP: direcci�n IP, nombre del servidor
 * y puerto desde donde sale la invocaci�n. 
 */
public class InterceptorEntradaRegistrarInvocacion extends WSS4JInInterceptor {

	public static String PETICION = "PETICION";
	private static Logger log = Logger.getLogger(InterceptorEntradaRegistrarInvocacion.class);
	private VerificacionDao dao;

	public void handleMessage(SoapMessage mensaje) throws Fault {
		try {
			PeticionEntity peticion = this.crearPeticion(mensaje);
			String httpInfo = this.getHttpInfo(mensaje);
			this.getDao().agregarPeticion(peticion);
			log.info("\n"+ "********** Operador: "+ peticion.getIdOperador()+ " con ID Peticion: " + peticion.getIdPeticion() + " **********" + "\n");
			this.getDao().guardarInfoInvocacionHttp(httpInfo);
			mensaje.getExchange().getInMessage().put(PETICION, peticion);
		} catch (Exception e) {
			log.error("Error guardando la peticion", e);
		}
	}

	/**
	 * Retorna un objeto para guardar toda la informaci�n de la invocaci�n. Contiene:
	 * - El mensaje SOAP serializado
	 * - Fecha/hora actual
	 * - Nombre de la operaci�n (SOAPAction de la cabecera HTTP)
	 * - ID del operador correspondiente al certificado extra�do de las cabeceras.
	 * Podr�a ocurrir que el operador no est� presente, pero a�n as� debemos guardar la petici�n.
	 */
	private PeticionEntity crearPeticion(SoapMessage mensaje) throws Exception {
        SAAJInInterceptor.INSTANCE.handleMessage(mensaje);
		SOAPMessage doc = mensaje.getContent(SOAPMessage.class);
		// Serializamos el mensaje SOAP
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		doc.writeTo(baos);
		String soapString = new String(baos.toByteArray());
		// Recuperamos el operador que fue inyectado por otro interceptor
		OperadorEntity operador = (OperadorEntity)mensaje.getExchange().getInMessage().get(InterceptorEntradaProcesarCertificado.OPERADOR);
		// Obtenemos el nombre de la operaci�n que se invoca
		String nombreOperacion = this.getNombreOperacion(mensaje);
		PeticionEntity peticion = new PeticionEntity();
		peticion.setPeticion(soapString);
		peticion.setFechaPeticion(new Date());
		peticion.setCodPeticion(nombreOperacion);
		if (operador.isNullOperador()) {
			peticion.setIdOperador(null);
		} else {
			peticion.setIdOperador(operador.getIdOperador());
		}
		return peticion;
	}
	
	/**
	 * Extraemos del contexto del mensaje la informaci�n de la petici�n HTTP: direcci�n IP,
	 * nombre del servidor y puerto.
	 */
	private String getHttpInfo(SoapMessage message) throws Fault {
		HttpServletRequest request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
		if (null != request) {
			String info = request.getRemoteAddr() + " " + request.getServerName() + " " + request.getServerPort();
			return info;
		} else {
			return "Error info HTTP";
		}
	}

	/**
	 * Retorna el valor de la cabecera SOAPAction que viaja en el mensaje HTTP.
	 * Ej: Si SOAPAction="https://ws.cnjuego.gob.es/VerificacionJugadores/verificarCambiosRGIAJ",
	 * la operaci�n es "verificarCambiosRGIAJ".
	 * La implementaci�n del m�todo se basa en SoapActionInInterceptor.getSoapAction(Message)
	 * 
	 * N�tese que podr�a ocurrir que la cabecera de SOAPAction no estuviera en el mensaje HTTP.
	 * En ese caso, el nombre de la operaci�n se sibreescribe desde las operaciones del servicio.
	 */
    private String getNombreOperacion(SoapMessage mensaje) {
    	String soapAction = SoapActionInInterceptor.getSoapAction(mensaje);
    	if (soapAction == null) {
			return null;
		}
    	int i = -1;
    	// Si soapAction termina en "/", entonces buscamos la operaci�n a partir del separador anterior 
        if (soapAction.endsWith("/")) {
        	i = soapAction.substring(0, soapAction.length() - 1).lastIndexOf("/");
        } else {
        	i = soapAction.lastIndexOf("/");
        }
    	String nombreOperacion = soapAction.substring(i + 1);
    	return nombreOperacion;
    }

	public VerificacionDao getDao() {
		return dao;
	}

	public void setDao(VerificacionDao dao) {
		this.dao = dao;
	}
	
}
