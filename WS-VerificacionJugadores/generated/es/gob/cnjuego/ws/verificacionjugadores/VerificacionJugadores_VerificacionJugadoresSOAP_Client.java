
package es.gob.cnjuego.ws.verificacionjugadores;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.2
 * 2013-06-20T17:48:22.629+02:00
 * Generated source version: 2.7.2
 * 
 */
public final class VerificacionJugadores_VerificacionJugadoresSOAP_Client {

    private static final QName SERVICE_NAME = new QName("http://ws.cnjuego.gob.es/VerificacionJugadores/", "VerificacionJugadores");

    private VerificacionJugadores_VerificacionJugadoresSOAP_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = VerificacionJugadores_Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        VerificacionJugadores_Service ss = new VerificacionJugadores_Service(wsdlURL, SERVICE_NAME);
        VerificacionJugadores port = ss.getVerificacionJugadoresSOAP();  
        
        {
        System.out.println("Invoking verificarIdentidad...");
        java.util.List<es.gob.cnjuego.ws.verificacionjugadores.Jugador> _verificarIdentidad_jugadores = null;
        try {
            java.util.List<es.gob.cnjuego.ws.verificacionjugadores.ResultadoIdentidad> _verificarIdentidad__return = port.verificarIdentidad(_verificarIdentidad_jugadores);
            System.out.println("verificarIdentidad.result=" + _verificarIdentidad__return);

        } catch (VerificarIdentidadFault_Exception e) { 
            System.out.println("Expected exception: VerificarIdentidadFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking verificarRGIAJ...");
        java.util.List<es.gob.cnjuego.ws.verificacionjugadores.Jugador> _verificarRGIAJ_jugadores = null;
        try {
            java.util.List<es.gob.cnjuego.ws.verificacionjugadores.ResultadoRGIAJ> _verificarRGIAJ__return = port.verificarRGIAJ(_verificarRGIAJ_jugadores);
            System.out.println("verificarRGIAJ.result=" + _verificarRGIAJ__return);

        } catch (VerificarRGIAJFault_Exception e) { 
            System.out.println("Expected exception: VerificarRGIAJFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking verificarCambiosRGIAJ...");
        try {
            java.util.List<es.gob.cnjuego.ws.verificacionjugadores.CambioRGIAJ> _verificarCambiosRGIAJ__return = port.verificarCambiosRGIAJ();
            System.out.println("verificarCambiosRGIAJ.result=" + _verificarCambiosRGIAJ__return);

        } catch (VerificarCambiosRGIAJFault_Exception e) { 
            System.out.println("Expected exception: verificarCambiosRGIAJFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking verificarJugador...");
        java.util.List<es.gob.cnjuego.ws.verificacionjugadores.Jugador> _verificarJugador_jugadores = null;
        try {
            java.util.List<es.gob.cnjuego.ws.verificacionjugadores.ResultadoJugador> _verificarJugador__return = port.verificarJugador(_verificarJugador_jugadores);
            System.out.println("verificarJugador.result=" + _verificarJugador__return);

        } catch (VerificarJugadorFault_Exception e) { 
            System.out.println("Expected exception: VerificarJugadorFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking bajaJugador...");
        es.gob.cnjuego.ws.verificacionjugadores.Baja _bajaJugador_bajaJugador = null;
        try {
            es.gob.cnjuego.ws.verificacionjugadores.ResultadoBajaJugador _bajaJugador__return = port.bajaJugador(_bajaJugador_bajaJugador);
            System.out.println("bajaJugador.result=" + _bajaJugador__return);

        } catch (BajaJugadorFault_Exception e) { 
            System.out.println("Expected exception: bajaJugadorFault has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}
