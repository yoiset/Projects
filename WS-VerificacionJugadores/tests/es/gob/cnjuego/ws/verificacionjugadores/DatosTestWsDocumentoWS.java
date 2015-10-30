package es.gob.cnjuego.ws.verificacionjugadores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.gob.cnjuego.ws.dao.VerificacionDao;

public class DatosTestWsDocumentoWS extends SpringTestCase {
   


	
	private VerificacionDao dao;
	private VerificacionJugadores proxy;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.setDao((VerificacionDao)this.getContext().getBean("VerificacionDao"));
		this.setProxy((VerificacionJugadores)this.getContext().getBean("VerificacionJugadoresService"));
	}

	/**
	 * Verificamos que la configuraci�n de los ficheros es correcta.
	 */
	@Test
	public void testInit() throws Exception {
		assertNotNull(this.getProxy());
	}
	
	
	/******************************************************************************************************************************/
	/*                          CASOS PRUEBA OPERACION VERIFICARJUGADOR                                                           */
	/******************************************************************************************************************************/
	
	
	/**1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * 1Prueba1.1 Dni que existe en TEST_WS , correcto y est� en  RGIAJ (case 31)
	 */
	@Test
	public void testVerificarJugador1_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000000T");
		jugador.setNombre("Maria");
		jugador.setApellido1("Gonzalez");
		jugador.setApellido2("Lopez");
		jugador.setFechaNacimiento(dateFormat.parse("10/04/1960"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("00000000T", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	/**1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 1Prueba1.2 Dni que existe en TEST_WS , correcto y est� en  RGIAJ (case 31)
	 */
	@Test
	public void testVerificarJugador1_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000000T");
		jugador.setNombre("Maria");
		jugador.setApellido1("Gonzalez");
		jugador.setApellido2("Lopez");
		jugador.setFechaNacimiento(dateFormat.parse("10/04/1960"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("00000000T", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	/**1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * 1Prueba1.3 Dni que existe en TEST_WS , correcto y est� en  RGIAJ (case 31)
	 */
	@Test
	public void testVerificarJugador1_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000000T");
		jugador.setNombre("Maria");
		jugador.setApellido1("Gonzalez");
		jugador.setApellido2("Lopez");
		jugador.setFechaNacimiento(dateFormat.parse("10/04/1960"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("00000000T", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 */
	@Test
	public void testVerificarJugador2_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("Y9999999G");
		jugador.setNombre("Esperanza");
		jugador.setApellido1("San Juan");
		jugador.setApellido2("Mateo");
		jugador.setFechaNacimiento(dateFormat.parse("05/06/1985"));
		
				
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
//		jugadores.add(jugador2);
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("Y9999999G", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
		
//		resultado = respuesta.get(1);
//		assertEquals("X0000040V", resultado.getDni());
//		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
//		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 */
	@Test
	public void testVerificarJugador2_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("Y9999999G");
		jugador.setNombre("Esperanza");
		jugador.setApellido1("San Juan");
		jugador.setApellido2("Mateo");
		jugador.setFechaNacimiento(dateFormat.parse("05/06/1985"));
		
				
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
//		jugadores.add(jugador2);
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("Y9999999G", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
		
//		resultado = respuesta.get(1);
//		assertEquals("X0000040V", resultado.getDni());
//		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
//		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 */
	@Test
	public void testVerificarJugador2_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("Y9999999G");
		jugador.setNombre("Esperanza");
		jugador.setApellido1("San Juan");
		jugador.setApellido2("Mateo");
		jugador.setFechaNacimiento(dateFormat.parse("05/06/1985"));
		
				
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
//		jugadores.add(jugador2);
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("Y9999999G", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
		
//		resultado = respuesta.get(1);
//		assertEquals("X0000040V", resultado.getDni());
//		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
//		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 */
	@Test
	public void testVerificarJugador3_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000048W");
		jugador.setNombre("Laura");
		jugador.setApellido1("Dorado");
		jugador.setApellido2("La�on");
		jugador.setFechaNacimiento(dateFormat.parse("27/04/1968"));
		
				
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("00000048W", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());
		
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 */
	@Test
	public void testVerificarJugador3_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000048W");
		jugador.setNombre("Laura");
		jugador.setApellido1("Dorado");
		jugador.setApellido2("La�on");
		jugador.setFechaNacimiento(dateFormat.parse("27/04/1968"));
		
				
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("00000048W", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
		
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 */
	@Test
	public void testVerificarJugador3_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000048W");
		jugador.setNombre("Laura");
		jugador.setApellido1("Dorado");
		jugador.setApellido2("La�on");
		jugador.setFechaNacimiento(dateFormat.parse("27/04/1968"));
		
				
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("00000048W", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());
		
	}
	
	
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba4.1 Dni que existe en TEST_WS , correcto y no est� en  RGIAJ (Case 27)
	 */
	@Test
	public void testVerificarJugador4_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X0000066C");
		jugador.setNombre("Susana");
		jugador.setApellido1("Ayala");
		jugador.setApellido2("Gracia");
		jugador.setFechaNacimiento(dateFormat.parse("24/09/1971"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("X0000066C", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba4.1 Dni que existe en TEST_WS , correcto y no est� en  RGIAJ (Case 27)
	 */
	@Test
	public void testVerificarJugador4_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X0000066C");
		jugador.setNombre("Susana");
		jugador.setApellido1("Ayala");
		jugador.setApellido2("Gracia");
		jugador.setFechaNacimiento(dateFormat.parse("24/09/1971"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("X0000066C", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba4.1 Dni que existe en TEST_WS , correcto y no est� en  RGIAJ (Case 27)
	 */
	@Test
	public void testVerificarJugador4_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X0000066C");
		jugador.setNombre("Susana");
		jugador.setApellido1("Ayala");
		jugador.setApellido2("Gracia");
		jugador.setFechaNacimiento(dateFormat.parse("24/09/1971"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("X0000066C", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba5.1 Dni que existe en TEST_WS , correcto y no est� en  RGIAJ (Case 34)
	 */
	@Test
	public void testVerificarJugador5_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X0000019L");
		jugador.setNombre("Hassan");
		jugador.setApellido1("Almud");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("01/01/1960"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("X0000019L", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba5.1 Dni que existe en TEST_WS , correcto y no est� en  RGIAJ (Case 34)
	 */
	@Test
	public void testVerificarJugador5_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X0000019L");
		jugador.setNombre("Hassan");
		jugador.setApellido1("Almud");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("01/01/1960"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("X0000019L", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba5.3 Dni que existe en TEST_WS , correcto y no est� en  RGIAJ (Case 34)
	 */
	@Test
	public void testVerificarJugador5_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X0000019L");
		jugador.setNombre("Hassan");
		jugador.setApellido1("Almud");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("01/01/1960"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("X0000019L", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());
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
