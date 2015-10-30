package es.gob.cnjuego.ws.verificacionjugadores;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.2
 * 2013-06-20T17:48:22.687+02:00
 * Generated source version: 2.7.2
 * 
 */
@WebService(targetNamespace = "http://ws.cnjuego.gob.es/VerificacionJugadores/", name = "VerificacionJugadores")
@XmlSeeAlso({ObjectFactory.class})
public interface VerificacionJugadores {

    @WebResult(name = "resultadosIdentidad", targetNamespace = "")
    @RequestWrapper(localName = "verificarIdentidad", targetNamespace = "http://ws.cnjuego.gob.es/VerificacionJugadores/", className = "es.gob.cnjuego.ws.verificacionjugadores.VerificarIdentidad")
    @WebMethod(action = "https://ws.cnjuego.gob.es/VerificacionJugadores/verificarIdentidad")
    @ResponseWrapper(localName = "verificarIdentidadResponse", targetNamespace = "http://ws.cnjuego.gob.es/VerificacionJugadores/", className = "es.gob.cnjuego.ws.verificacionjugadores.VerificarIdentidadResponse")
    public java.util.List<es.gob.cnjuego.ws.verificacionjugadores.ResultadoIdentidad> verificarIdentidad(
        @WebParam(name = "jugadores", targetNamespace = "")
        java.util.List<es.gob.cnjuego.ws.verificacionjugadores.Jugador> jugadores
    ) throws VerificarIdentidadFault_Exception;

    @WebResult(name = "resultadosRGIAJ", targetNamespace = "")
    @RequestWrapper(localName = "verificarRGIAJ", targetNamespace = "http://ws.cnjuego.gob.es/VerificacionJugadores/", className = "es.gob.cnjuego.ws.verificacionjugadores.VerificarRGIAJ")
    @WebMethod(action = "https://ws.cnjuego.gob.es/VerificacionJugadores/verificarRGIAJ")
    @ResponseWrapper(localName = "verificarRGIAJResponse", targetNamespace = "http://ws.cnjuego.gob.es/VerificacionJugadores/", className = "es.gob.cnjuego.ws.verificacionjugadores.VerificarRGIAJResponse")
    public java.util.List<es.gob.cnjuego.ws.verificacionjugadores.ResultadoRGIAJ> verificarRGIAJ(
        @WebParam(name = "jugadores", targetNamespace = "")
        java.util.List<es.gob.cnjuego.ws.verificacionjugadores.Jugador> jugadores
    ) throws VerificarRGIAJFault_Exception;

    @WebResult(name = "cambioRGIAJ", targetNamespace = "")
    @RequestWrapper(localName = "verificarCambiosRGIAJ", targetNamespace = "http://ws.cnjuego.gob.es/VerificacionJugadores/", className = "es.gob.cnjuego.ws.verificacionjugadores.VerificarCambiosRGIAJ")
    @WebMethod(action = "https://ws.cnjuego.gob.es/VerificacionJugadores/verificarCambiosRGIAJ")
    @ResponseWrapper(localName = "verificarCambiosRGIAJResponse", targetNamespace = "http://ws.cnjuego.gob.es/VerificacionJugadores/", className = "es.gob.cnjuego.ws.verificacionjugadores.VerificarCambiosRGIAJResponse")
    public java.util.List<es.gob.cnjuego.ws.verificacionjugadores.CambioRGIAJ> verificarCambiosRGIAJ() throws VerificarCambiosRGIAJFault_Exception;

    @WebResult(name = "resultadosJugador", targetNamespace = "")
    @RequestWrapper(localName = "verificarJugador", targetNamespace = "http://ws.cnjuego.gob.es/VerificacionJugadores/", className = "es.gob.cnjuego.ws.verificacionjugadores.VerificarJugador")
    @WebMethod(action = "https://ws.cnjuego.gob.es/VerificacionJugadores/verificarJugador")
    @ResponseWrapper(localName = "verificarJugadorResponse", targetNamespace = "http://ws.cnjuego.gob.es/VerificacionJugadores/", className = "es.gob.cnjuego.ws.verificacionjugadores.VerificarJugadorResponse")
    public java.util.List<es.gob.cnjuego.ws.verificacionjugadores.ResultadoJugador> verificarJugador(
        @WebParam(name = "jugadores", targetNamespace = "")
        java.util.List<es.gob.cnjuego.ws.verificacionjugadores.Jugador> jugadores
    ) throws VerificarJugadorFault_Exception;

    @WebResult(name = "resultadoBajaJugador", targetNamespace = "")
    @RequestWrapper(localName = "bajaJugador", targetNamespace = "http://ws.cnjuego.gob.es/VerificacionJugadores/", className = "es.gob.cnjuego.ws.verificacionjugadores.BajaJugador")
    @WebMethod(action = "https://ws.cnjuego.gob.es/VerificacionJugadores/bajaJugador")
    @ResponseWrapper(localName = "bajaJugadorResponse", targetNamespace = "http://ws.cnjuego.gob.es/VerificacionJugadores/", className = "es.gob.cnjuego.ws.verificacionjugadores.BajaJugadorResponse")
    public es.gob.cnjuego.ws.verificacionjugadores.ResultadoBajaJugador bajaJugador(
        @WebParam(name = "bajaJugador", targetNamespace = "")
        es.gob.cnjuego.ws.verificacionjugadores.Baja bajaJugador
    ) throws BajaJugadorFault_Exception;
}