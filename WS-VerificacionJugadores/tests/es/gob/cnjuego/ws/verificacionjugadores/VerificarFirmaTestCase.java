package es.gob.cnjuego.ws.verificacionjugadores;

import java.net.URL;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.ws.security.WSSecurityEngineResult;
import org.apache.ws.security.components.crypto.Crypto;
import org.apache.ws.security.components.crypto.Merlin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import es.gob.cnjuego.ws.verificacionjugadores.interceptor.DgojWSSecurityEngine;

public class VerificarFirmaTestCase {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Este test verifica la firma de un mensaje leído desde un fichero XML.
	 * Es necesario que el mensaje tenga un timestamp válido. Como el timestamp va firmado,
	 * no se puede modificar el documento XML. En cambio, es necesario capturar un mensaje
	 * nuevo y guardarlo en el fichero. 
	 * Para generar un mensaje nuevo, usar el ClienteServidorVerificacion y capturar el mensaje
	 * con el TCP/IP monitor de Eclipse.
	 * La prueba es correcta cuando no se producen excepciones durante la verificación!
	 */
	@Test
	public void testVerificarFirma() throws Exception {
		URL url = this.getClass().getResource("/tests/mensaje_prueba_firma.xml");
		String path = url.toString();
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dbFactory.setNamespaceAware(true);
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(path);
		doc.getDocumentElement().normalize ();
		
		// Para depurar, el siguiente fragmento envía el documento XML a la consola
		DOMImplementationLS domImplLS = (DOMImplementationLS) doc.getImplementation();
		LSSerializer serializer = domImplLS.createLSSerializer();
		String documentoSerializado = serializer.writeToString(doc);
		//System.out.println(documentoSerializado);
		
		DgojWSSecurityEngine secEngine = new DgojWSSecurityEngine();
		Crypto crypto = new Merlin();
		List<WSSecurityEngineResult> results = secEngine.processSecurityHeader(doc, null, null, crypto);
		//System.out.println(results);
	}

}
