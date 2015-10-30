package es.gob.cnjuego.ws.verificacionjugadores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.gob.cnjuego.ws.dao.VerificacionDao;

public class Fault extends SpringTestCase{

	
	private VerificacionDao dao;
	private VerificacionJugadores proxy;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.setDao((VerificacionDao)this.getContext().getBean("VerificacionDao"));
		this.setProxy((VerificacionJugadores)this.getContext().getBean("VerificacionJugadoresService"));
	}

	/**
	 * Verificamos que la configuración de los ficheros es correcta.
	 */
	@Test
	public void testInit() throws Exception {
		assertNotNull(this.getProxy());
	}
	
	
	/******************************************************************************************************************************/
	/*                          CASOS PRUEBA OPERACION VERIFICARJUGADOR                                                           */
	/******************************************************************************************************************************/
	
	
	/**	1) No esta cargado el certificado en JUG_OPERADOR_JUEGO
	 */
	@Test
	public void testVerificarJugador01() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("10000949C");
		jugador.setNombre("OLGA");
		jugador.setApellido1("SAN MIGUEL");
		jugador.setApellido2("CHAO");
		jugador.setFechaNacimiento(dateFormat.parse("02/06/1940"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
				
	}
	
	
	/**	 * 1) En la tabla  JUG_OPERADOR_JUEGO el 
	 *    MODO_ENABLED=0
	 */
	@Test
	public void testVerificarJugador02() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("10000949C");
		jugador.setNombre("OLGA");
		jugador.setApellido1("SAN MIGUEL");
		jugador.setApellido2("CHAO");
		jugador.setFechaNacimiento(dateFormat.parse("02/06/1940"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
				
	}
	
	
	
	/**	 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 */
	@Test
	public void testVerificarJugador05() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("10000949C");
		jugador.setNombre("OLGA");
		jugador.setApellido1("SAN MIGUEL");
		jugador.setApellido2("CHAO");
		jugador.setFechaNacimiento(dateFormat.parse("02/06/1940"));
		
		Jugador jugador2 = new Jugador();
		jugador2.setDni("10000949C");
		jugador2.setNombre("OLGA");
		jugador2.setApellido1("SAN MIGUEL");
		jugador2.setApellido2("CHAO");
		jugador2.setFechaNacimiento(dateFormat.parse("02/06/1940"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		jugadores.add(jugador2);
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
				
	}
	
	/**	 1) En la tabla  JUG_OPERADOR_JUEGO el MODO_ENABLED=2
	 */
	@Test
	public void testVerificarJugador06() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("10000949C");
		jugador.setNombre("OLGA");
		jugador.setApellido1(null);
		jugador.setApellido2("CHAO");
		jugador.setFechaNacimiento(dateFormat.parse("02/06/1940"));
			
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
				
	}
	
	/**
	 * Para facilitar las pruebas unitarias
	 */
	private ResultadoJugador getResultadoJugadorByDni(String dni, List<ResultadoJugador> lista) {
		for (ResultadoJugador resultado : lista) {
			if (resultado.getDni().equals(dni)) {
				return resultado;
			}
		}
		return null;
	}
	
	

	public VerificacionDao getDao() {
		return dao;
	}

	public void setDao(VerificacionDao dao) {
		this.dao = dao;
	}

	public VerificacionJugadores getProxy() {
		return proxy;
	}

	public void setProxy(VerificacionJugadores proxy) {
		this.proxy = proxy;
	}	
}
