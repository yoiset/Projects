package es.gob.cnjuego.ws.verificacionjugadores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.gob.cnjuego.ws.dao.VerificacionDao;

public class Acentos extends SpringTestCase{
	
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
	
	
	/**
	 * 
	 */
	@Test
	public void testVerificarJugador1() throws Exception {
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
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("10000949C", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	/**
	 * 
	 */
	@Test
	public void testVerificarJugador2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("10000320N");
		jugador.setNombre("MARIA ENCINA");
		jugador.setApellido1("FELIZ");
		jugador.setApellido2("VARELA");
		jugador.setFechaNacimiento(dateFormat.parse("18/05/1944"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("10000320N", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	/**1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba3 Dni que existe en TEST_WS , titular no correcto y  está en  RGIAJ (case23)
	 */
	@Test
	public void testVerificarJugador3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000048W");
		jugador.setNombre("Laura");
		jugador.setApellido1("Dorado");
		jugador.setApellido2("Laçon");
		jugador.setFechaNacimiento(dateFormat.parse("27/04/1968"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("00000048W", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	/**1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba4 Dni que existe en TEST_WS , correcto y no está en  RGIAJ (Case 22)
	 */
	@Test
	public void testVerificarJugador4() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("Y9999999G");
		jugador.setNombre("Esperanza");
		jugador.setApellido1("San Juan");
		jugador.setApellido2("Mateo");
		jugador.setFechaNacimiento(dateFormat.parse("05/06/1985"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("Y9999999G", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	@Test
	public void testVerificarJugador5() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("Y9999999G");
		jugador.setNombre("Hatziri Dhamar");
		jugador.setApellido1("Retzle");
		jugador.setApellido2("Moreau");
		jugador.setFechaNacimiento(dateFormat.parse("22/04/1982"));
		jugador.setNumSoporte("X22353243");
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("Y130499B", resultado.getDni());
		assertEquals("COD905", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD905", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	@Test
	public void testVerificarJugador6() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000014Z");
		jugador.setNombre("Maria");
		jugador.setApellido1("Garcia");
		jugador.setApellido2("Perez");
		jugador.setFechaNacimiento(dateFormat.parse("01/09/1990"));
		jugador.setNumSoporte("E22353243");
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("00000014Z", resultado.getDni());
		assertEquals("COD906", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD906", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	@Test
	public void testBajaJugador7() throws Exception {
		Baja baja=new Baja();
		baja.setDni("Y0307082T"); /// COD010
		baja.setCausa("R");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("Y0307082T", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_BAJA_DNI_NO_ACTIVADO, respuesta.getResultadoBaja().getCodigo());
		
	}
	
	@Test
	public void testBajaJugador8() throws Exception {
		Baja baja=new Baja();
		baja.setDni("10000320N"); /// COD010
		baja.setCausa("A");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("10000320N", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_BAJA_DNI_BAJA, respuesta.getResultadoBaja().getCodigo());
		
	}
	
	
	@Test
	public void testBajaJugador9() throws Exception {
		Baja baja=new Baja();
		baja.setDni("10000949C"); /// COD010
		baja.setCausa("Z");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("10000949C", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_BAJA_CAUSA, respuesta.getResultadoBaja().getCodigo());
		
	}
	
	@Test
	public void testBajaJugador10() throws Exception {
		Baja baja=new Baja();
		baja.setDni("30000260B"); /// COD010
		baja.setCausa("A");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("30000260B", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_FORMATO_INCORRECTO, respuesta.getResultadoBaja().getCodigo());
		
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
