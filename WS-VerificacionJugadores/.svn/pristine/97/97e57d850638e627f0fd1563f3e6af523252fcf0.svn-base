package es.gob.cnjuego.ws.juegodni;

import static org.junit.Assert.assertNotNull;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;

import org.junit.Before;
import org.junit.Test;

import es.gob.cnjuego.ws.verificacionjugadores.ClienteJuegoDniService;
import es.gob.cnjuego.ws.verificacionjugadores.ResultadoRGIAJ;
import es.gob.cnjuego.ws.verificacionjugadores.SpringTestCase;

public class VerificacionJuegoDni extends SpringTestCase { 
	
	private ClienteJuegoDniService proxy;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.setProxy((ClienteJuegoDniService)this.getContext().getBean("ClienteJuegoDniService"));
	}
	
	
	@Test
	public void testInit() throws Exception {
		assertNotNull(this.getProxy());
	}	
	
	@Test
	public void testPeticion() throws Exception{
		List<String> listDNI=new ArrayList<String>();
		listDNI.add("10000949C");
		listDNI.add("99999028L");
		listDNI.add("10000320N");
		Long time= Calendar.getInstance().getTimeInMillis();
		List<ResultadoRGIAJ> ListResponse= proxy.verificarJuegoDni(listDNI);
		Long delay= Calendar.getInstance().getTimeInMillis()- time; 
		System.out.println("Tiempo de Peticion y Respuesta " +  delay.toString() + " ms");
		for (ResultadoRGIAJ res : ListResponse) {
			System.out.println("Resultado RGIAJ " +  res.getDni() + " " + res.getResultadoRGIAJ().getCodigo()+ " " + res.getResultadoRGIAJ().getDescripcion());
		}
		
	}
	

	public ClienteJuegoDniService getProxy() {
		return proxy;
	}

	public void setProxy(ClienteJuegoDniService proxy) {
		this.proxy = proxy;
	}

}
