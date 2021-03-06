package es.gob.cnjuego.ws.verificacionjugadores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.message.Message;
import org.apache.log4j.Logger;

import es.gob.cnjuego.ws.dao.VerificacionDao;
import es.gob.cnjuego.ws.util.Constantes;
import es.mir.juego.component.ws.service.InfoResultado;
import es.mir.juego.component.ws.service.JuegoDni;
import es.mir.juego.component.ws.service.ListaDniRequest;
import es.mir.juego.component.ws.service.ListaDniResponse;


/**
 * Esta clase act�a como intermediario para efectuar las consultas de verificaci�n de usuarios 
 * en el RGIAJ.
 * Este cliente invoca al servicio JuegoDni que corre dentro de la DGOJ y que a su vez invoca
 * al servicio SVDI remoto.
 */
public class ClienteJuegoDniService {

	static Logger log = Logger.getLogger(ClienteJuegoDniService.class);
	private JuegoDni clienteJuegoDni;
	private VerificacionDao verificacionDao;

	/**
	 * Inicializa el servicio con par�metros que residen en la base de datos. 
	 * Como estos par�metros pueden cambiar en tiempo de ejecuci�n, debemos 
	 * re-asignarlos en cada invocaci�n. 
	 * N�tese que no es una gran penalizaci�n porque en realidad los par�metros residen
	 * en una cach� gestionada por el DAO (y se vuelven a leer desde la BD solamente 
	 * en circunstancias especiales) 
	 */
	private void initServicio(){
		String endpointAddress = this.getVerificacionDao().getValorPropiedad(Constantes.CFG_ENDPOINT_JUEGO_DNI);
		BindingProvider proxy = (BindingProvider)this.getClienteJuegoDni();
		Map<String, Object> map = proxy.getRequestContext();
		map.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointAddress);		
		setClientTimeOut(map);
	}
	
    private void setClientTimeOut(Map<String, Object> map) {		
		map.put(Message.CONNECTION_TIMEOUT, this.getVerificacionDao().getValorPropiedad(Constantes.CFG_JUEGODNI_CONNECT_TIMEOUT));
		map.put(Message.RECEIVE_TIMEOUT, this.getVerificacionDao().getValorPropiedad(Constantes.CFG_JUEGODNI_RESPONSE_TIMEOUT));
		
	}

	public ArrayList<ResultadoRGIAJ> verificarJuegoDni(List<String> listaDni) throws Exception {
		try {
			this.initServicio();
			ListaDniRequest listaDniReq = new ListaDniRequest();
			listaDniReq.getDni().addAll(listaDni);
			ListaDniResponse listaDniRes = this.getClienteJuegoDni().listaDni(listaDniReq);
			
			ArrayList<ResultadoRGIAJ> estado = comprobarRespuesta(listaDniRes);
			return estado;
		} catch (Exception ex) {
			log.error("AccesoSCSP.verificarIdentidad():No se ha podido verificar la identidad del usuario",	ex);
			throw ex;
		}
	}

	/**
	 * Se procesa la respuesta enviada por JuegoDni y se retorna una lista de resultados de jugadores 
	 * que incluyen un DNI y un c�digo y descripci�n que indican si est� inscrito o no en el RGIAJ
	 */
	private ArrayList<ResultadoRGIAJ> comprobarRespuesta(ListaDniResponse listaDniRes) {
		ArrayList<ResultadoRGIAJ> listaResultados = new ArrayList<ResultadoRGIAJ>();
		
		for (InfoResultado unResultado : listaDniRes.getInforesultado()){
			ResultadoRGIAJ nuevoResultado = new ResultadoRGIAJ();
			ResultadoType rt = new ResultadoType();
			
			nuevoResultado.setDni(unResultado.getDni());
			if (unResultado.isResultado()) {
				rt.setCodigo(CodigosVerificacion.COD_INSCRITO_RGIAJ);
				rt.setDescripcion(CodigosVerificacion.DESC_INSCRITO_RGIAJ);
				nuevoResultado.setResultadoRGIAJ(rt);
			} else {
				rt.setCodigo(CodigosVerificacion.COD_NO_INSCRITO_RGIAJ);
				rt.setDescripcion(CodigosVerificacion.DESC_NO_INSCRITO_RGIAJ);
				nuevoResultado.setResultadoRGIAJ(rt);
			}
			
			listaResultados.add(nuevoResultado);
		}
		return listaResultados;
	}

	public JuegoDni getClienteJuegoDni() {
		return clienteJuegoDni;
	}

	public void setClienteJuegoDni(JuegoDni clienteJuegoDni) {
		this.clienteJuegoDni = clienteJuegoDni;
	}

	public VerificacionDao getVerificacionDao() {
		return verificacionDao;
	}

	public void setVerificacionDao(VerificacionDao verificacionDao) {
		this.verificacionDao = verificacionDao;
	}

}
