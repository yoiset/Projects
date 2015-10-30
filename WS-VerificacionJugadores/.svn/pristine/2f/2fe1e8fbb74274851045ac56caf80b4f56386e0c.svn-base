package es.gob.cnjuego.ws.verificacionjugadores.interceptor;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.Date;

import javax.xml.soap.SOAPMessage;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.ws.security.wss4j.AbstractWSS4JInterceptor;
import org.apache.log4j.Logger;

import es.gob.cnjuego.ws.dao.VerificacionDao;
import es.gob.cnjuego.ws.entity.PeticionEntity;

/**
 * Este interceptor completa los datos de la petición con el mensaje SOAP de respuesta
 * enviado por el servidor. Luego actualiza el registro en la base de datos 
 */
public class InterceptorSalidaRegistrarRespuesta extends AbstractWSS4JInterceptor {

	private static Logger log = Logger.getLogger(InterceptorSalidaRegistrarRespuesta.class);
	private VerificacionDao dao;

	public InterceptorSalidaRegistrarRespuesta() {
        setPhase(Phase.POST_STREAM);
	}
	
	public void handleMessage(SoapMessage mensaje) throws Fault {
		try {
			PeticionEntity peticion = (PeticionEntity)mensaje.getExchange().getInMessage().get(InterceptorEntradaRegistrarInvocacion.PETICION);
			this.completarPeticion(peticion, mensaje);
			this.getDao().actualizarPeticion(peticion);
		} catch (Exception e) {
			log.error("Error actualizando la petici\u00F3n", e);
		}
	}

	/**
	 * Agrega a la petición el mensaje SOAP de respuesta serializado y 
	 * la fecha/hora actual.
	 */
	private void completarPeticion(PeticionEntity peticion, SoapMessage mensaje) throws Exception {
        SAAJInInterceptor.INSTANCE.handleMessage(mensaje);
		SOAPMessage doc = mensaje.getContent(SOAPMessage.class);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		doc.writeTo(baos);
		String soapString = new String(baos.toByteArray(),"UTF-8");		
		peticion.setRespuesta(soapString);
		peticion.setFechaRespuesta(new Date());
	}
	
	public VerificacionDao getDao() {
		return dao;
	}

	public void setDao(VerificacionDao dao) {
		this.dao = dao;
	}

}
