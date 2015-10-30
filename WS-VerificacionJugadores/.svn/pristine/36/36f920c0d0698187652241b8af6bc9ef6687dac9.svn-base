package es.gob.cnjuego.ws.verificacionjugadores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.gob.cnjuego.ws.dao.VerificacionDao;

public class DatosTestWSVIdentidad extends SpringTestCase{
	

	


	
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
	/*                          CASOS PRUEBA OPERACION ResultadoIdentidad                                                           */
	/******************************************************************************************************************************/
	
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Dni que existe en TEST_WS , correcto y está en  RGIAJ
	 */
	@Test
	public void testverificarIdentidad01_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X0000052Y");
		jugador.setNombre("Oscar");
		jugador.setApellido1("l·üçar");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("03/03/1964"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("X0000052Y", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Dni que existe en TEST_WS , correcto y está en  RGIAJ
	 */
	@Test
	public void testverificarIdentidad01_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X0000052Y");
		jugador.setNombre("Oscar");
		jugador.setApellido1("l·üçar");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("03/03/1964"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);

		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("X0000052Y", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Dni que existe en TEST_WS , correcto y está en  RGIAJ
	 */
	@Test
	public void testverificarIdentidad01_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X0000052Y");
		jugador.setNombre("Oscar");
		jugador.setApellido1("l·üçar");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("03/03/1964"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("X0000052Y", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Dni que existe en TEST_WS , correcto y no está en  RGIAJ
	 * (Case 22)
	 */
	@Test
	public void testverificarIdentidad02_1() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("X0000066C", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba2.2 Dni que existe en TEST_WS , correcto y no está en  RGIAJ
	 */
	@Test
	public void testverificarIdentidad02_2() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("X0000066C", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba2.3 Dni que existe en TEST_WS , correcto y no está en  RGIAJ
	 */
	@Test
	public void testverificarIdentidad02_3() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("X0000066C", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba3.1 Dni que existe en TEST_WS , titular no correcto y  está en  RGIAJ (case23)
	 */
	@Test
	public void testverificarIdentidad03_1() throws Exception {
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
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000048W", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba3.2 Dni que existe en TEST_WS , titular no correcto y  está en  RGIAJ
	 */
	@Test
	public void testverificarIdentidad03_2() throws Exception {
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
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000048W", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba3.3 Dni que existe en TEST_WS , titular no correcto y  está en  RGIAJ
	 */
	@Test
	public void testverificarIdentidad03_3() throws Exception {
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
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000048W", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba4.1 Dni que existe en TEST_WS , titular no correcto y  no esta  RGIAJ (case 24)
	 */
	@Test
	public void testverificarIdentidad04_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000047R");
		jugador.setNombre("Xavier");
		jugador.setApellido1("Cañas");
		jugador.setApellido2("Gonzalez");
		jugador.setFechaNacimiento(dateFormat.parse("20/08/1992"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000047R", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba4.2 Dni que existe en TEST_WS , titular no correcto y  no esta  RGIAJ
	 */
	@Test
	public void testverificarIdentidad04_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000047R");
		jugador.setNombre("Xavier");
		jugador.setApellido1("Cañas");
		jugador.setApellido2("Gonzalez");
		jugador.setFechaNacimiento(dateFormat.parse("20/08/1992"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000047R", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba4.3 Dni que existe en TEST_WS , titular no correcto y  no esta  RGIAJ
	 */
	@Test
	public void testverificarIdentidad04_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000047R");
		jugador.setNombre("Xavier");
		jugador.setApellido1("Cañas");
		jugador.setApellido2("Gonzalez");
		jugador.setFechaNacimiento(dateFormat.parse("20/08/1992"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000047R", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba5.1 Dni que existe en TEST_WS , pero con un nombre distinto al de la tabla, pero de los de titular no identificado y no en RGIAJ
	 */
	@Test
	public void testverificarIdentidad05_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000047R");
		jugador.setNombre("Xavier");
		jugador.setApellido1("Canas");
		jugador.setApellido2("Gonzalez");
		jugador.setFechaNacimiento(dateFormat.parse("20/08/1992"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000047R", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba5.1 Dni que existe en TEST_WS , pero con un nombre distinto al de la tabla, pero de los de titular no identificado y no en RGIAJ
	 */
	@Test
	public void testverificarIdentidad05_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000047R");
		jugador.setNombre("Xavier");
		jugador.setApellido1("Canas");
		jugador.setApellido2("Gonzalez");
		jugador.setFechaNacimiento(dateFormat.parse("20/08/1992"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000047R", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba5.1 Dni que existe en TEST_WS , pero con un nombre distinto al de la tabla, pero de los de titular no identificado y no en RGIAJ
	 */
	@Test
	public void testverificarIdentidad05_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000047R");
		jugador.setNombre("Xavier");
		jugador.setApellido1("Canas");
		jugador.setApellido2("Gonzalez");
		jugador.setFechaNacimiento(dateFormat.parse("20/08/1992"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000047R", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba6.1 Dni que existe en TEST_WS , pero con un nombre distinto al de la tabla,  de los de titular  identificado y  en RGIAJ (case21)
	 */
	@Test
	public void testverificarIdentidad06_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000034B");
		jugador.setNombre("Emilio Jose");
		jugador.setApellido1("Garcia");
		jugador.setApellido2("Gonzalez");
		jugador.setFechaNacimiento(dateFormat.parse("01/08/1953"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000034B", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba6.1 Dni que existe en TEST_WS , pero con un nombre distinto al de la tabla,  de los de titular  identificado y  en RGIAJ (case21)
	 */
	@Test
	public void testverificarIdentidad06_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000034B");
		jugador.setNombre("Emilio Jose");
		jugador.setApellido1("Garcia");
		jugador.setApellido2("Gonzalez");
		jugador.setFechaNacimiento(dateFormat.parse("01/08/1953"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000034B", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba6.1 Dni que existe en TEST_WS , pero con un nombre distinto al de la tabla,  de los de titular  identificado y  en RGIAJ (case21)
	 */
	@Test
	public void testverificarIdentidad06_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000034B");
		jugador.setNombre("Emilio Jose");
		jugador.setApellido1("Garcia");
		jugador.setApellido2("Gonzalez");
		jugador.setFechaNacimiento(dateFormat.parse("01/08/1953"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000034B", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba7.1 Dni que  existe en TEST_WS, pero enviamos un fecha de nacimiento menor al 1900 (Case 21)
	 */
	@Test
	public void testverificarIdentidad07_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000034B");
		jugador.setNombre("Emilio Jose");
		jugador.setApellido1("Garcia Ruiz");
		jugador.setApellido2("Gonzalez");
		jugador.setFechaNacimiento(dateFormat.parse("01/08/1853"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000034B", resultado.getDni());
		assertEquals("COD904", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba7.1 Dni que  existe en TEST_WS, pero enviamos un fecha de nacimiento menor al 1900 (Case 21)
	 */
	@Test
	public void testverificarIdentidad07_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000034B");
		jugador.setNombre("Emilio Jose");
		jugador.setApellido1("Garcia Ruiz");
		jugador.setApellido2("Gonzalez");
		jugador.setFechaNacimiento(dateFormat.parse("01/08/1853"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000034B", resultado.getDni());
		assertEquals("COD904", resultado.getResultadoIdentidad().getCodigo());
	}
		
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba7.1 Dni que  existe en TEST_WS, pero enviamos un fecha de nacimiento menor al 1900 (Case 21)
	 */
	@Test
	public void testverificarIdentidad07_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000034B");
		jugador.setNombre("Emilio Jose");
		jugador.setApellido1("Garcia Ruiz");
		jugador.setApellido2("Gonzalez");
		jugador.setFechaNacimiento(dateFormat.parse("01/08/1853"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000034B", resultado.getDni());
		assertEquals("COD904", resultado.getResultadoIdentidad().getCodigo());
	}
		
	
		
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba8.1 Dni que  no existe en TEST_WS. (Case 25)
	 */
	@Test
	public void testverificarIdentidad08_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X0000074M");
		jugador.setNombre("Maria");
		jugador.setApellido1("Garcia");
		jugador.setApellido2("Perez");
		jugador.setFechaNacimiento(dateFormat.parse("01/09/1990"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("X0000074M", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba8.1 Dni que  no existe en TEST_WS. (Case 25)
	 */
	@Test
	public void testverificarIdentidad08_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X0000074M");
		jugador.setNombre("Maria");
		jugador.setApellido1("Garcia");
		jugador.setApellido2("Perez");
		jugador.setFechaNacimiento(dateFormat.parse("01/09/1990"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("X0000074M", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba8.1 Dni que  no existe en TEST_WS. (Case 25)
	 */
	@Test
	public void testverificarIdentidad08_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X0000074M");
		jugador.setNombre("Maria");
		jugador.setApellido1("Garcia");
		jugador.setApellido2("Perez");
		jugador.setFechaNacimiento(dateFormat.parse("01/09/1990"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("X0000074M", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba9.1 Dni erroneo. (Case 28)
	 */
	@Test
	public void testverificarIdentidad09_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000018K");
		jugador.setNombre("Carlos");
		jugador.setApellido1("Guerrero");
		jugador.setApellido2("Grau");
		jugador.setFechaNacimiento(dateFormat.parse("11/05/1996"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000018K", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba9.1 Dni erroneo. (Case 28)
	 */
	@Test
	public void testverificarIdentidad09_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000018K");
		jugador.setNombre("Carlos");
		jugador.setApellido1("Guerrero");
		jugador.setApellido2("Grau");
		jugador.setFechaNacimiento(dateFormat.parse("11/05/1996"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000018K", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba9.1 Dni erroneo. (Case 28)
	 */
	@Test
	public void testverificarIdentidad09_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000018K");
		jugador.setNombre("Carlos");
		jugador.setApellido1("Guerrero");
		jugador.setApellido2("Grau");
		jugador.setFechaNacimiento(dateFormat.parse("11/05/1996"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000018K", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba10.1 Dni erroneo. (Case 28)
	 */
	@Test
	public void testverificarIdentidad10_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("000000018K");
		jugador.setNombre("Carlos");
		jugador.setApellido1("Guerrero");
		jugador.setApellido2("Grau");
		jugador.setFechaNacimiento(dateFormat.parse("11/05/1996"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("000000018K", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba10.2 Dni erroneo. (Case 28)
	 */
	@Test
	public void testverificarIdentidad10_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("000000018K");
		jugador.setNombre("Carlos");
		jugador.setApellido1("Guerrero");
		jugador.setApellido2("Grau");
		jugador.setFechaNacimiento(dateFormat.parse("11/05/1996"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("000000018K", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba10.3 Dni erroneo. (Case 28)
	 */
	@Test
	public void testverificarIdentidad10_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("000000018K");
		jugador.setNombre("Carlos");
		jugador.setApellido1("Guerrero");
		jugador.setApellido2("Grau");
		jugador.setFechaNacimiento(dateFormat.parse("11/05/1996"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("000000018K", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * 2)  Se lanza hasta que supere el numero de intentos que marca el CONFIGURACION  "intentos.COD005.pruebas".
	 */
	@Test
	public void testverificarIdentidad11_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000015S");
		jugador.setNombre("Jaime");
		jugador.setApellido1("Toledo");
		jugador.setApellido2("hernandez");
		jugador.setFechaNacimiento(dateFormat.parse("17/08/1992"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000015S", resultado.getDni());
		assertEquals("COD005", resultado.getResultadoIdentidad().getCodigo());
		
		/*Segunda vuelta para superar el numero de intento fijados en: 
		 intentos.COD005.pruebas*/
		 respuesta = this.getProxy().verificarIdentidad(jugadores);
		 resultado = respuesta.get(0);
		 assertEquals("00000015S", resultado.getDni());
		 assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 2)  Se lanza hasta que supere el numero de intentos que marca el CONFIGURACION  "intentos.COD005.pruebas".
	 */
	@Test
	public void testverificarIdentidad11_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000015S");
		jugador.setNombre("Jaime");
		jugador.setApellido1("Toledo");
		jugador.setApellido2("hernandez");
		jugador.setFechaNacimiento(dateFormat.parse("17/08/1992"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000015S", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		
		/*Segunda vuelta para superar el numero de intento fijados en: 
		 intentos.COD005.pruebas*/
		 respuesta = this.getProxy().verificarIdentidad(jugadores);
		 resultado = respuesta.get(0);
		 assertEquals("00000015S", resultado.getDni());
		 assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * 2)  Se lanza hasta que supere el numero de intentos que marca el CONFIGURACION  "intentos.COD005.pruebas".
	 */
	@Test
	public void testverificarIdentidad11_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000015S");
		jugador.setNombre("Jaime");
		jugador.setApellido1("Toledo");
		jugador.setApellido2("hernandez");
		jugador.setFechaNacimiento(dateFormat.parse("17/08/1992"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000015S", resultado.getDni());
		assertEquals("COD005", resultado.getResultadoIdentidad().getCodigo());
		
		/*Segunda vuelta para superar el numero de intento fijados en: 
		 intentos.COD005.pruebas*/
		 respuesta = this.getProxy().verificarIdentidad(jugadores);
		 resultado = respuesta.get(0);
		 assertEquals("00000015S", resultado.getDni());
		 assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * 2)  Se lanza hasta que supere el numero de intentos que marca el CONFIGURACION  "intentos.COD005.pruebas".
	 */
	@Test
	public void testverificarIdentidad12_1() throws Exception {
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
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000048W", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		
		/*Segunda vuelta para superar el numero de intento fijados en: 
		 intentos.COD005.pruebas*/
		 respuesta = this.getProxy().verificarIdentidad(jugadores);
		 resultado = respuesta.get(0);
		 assertEquals("00000048W", resultado.getDni());
		 assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 2)  Se lanza hasta que supere el numero de intentos que marca el CONFIGURACION  "intentos.COD005.pruebas".
	 */
	@Test
	public void testverificarIdentidad12_2() throws Exception {
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
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000048W", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		
		/*Segunda vuelta para superar el numero de intento fijados en: 
		 intentos.COD005.pruebas*/
		 respuesta = this.getProxy().verificarIdentidad(jugadores);
		 resultado = respuesta.get(0);
		 assertEquals("00000048W", resultado.getDni());
		 assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * 2)  Se lanza hasta que supere el numero de intentos que marca el CONFIGURACION  "intentos.COD005.pruebas".
	 */
	@Test
	public void testverificarIdentidad12_3() throws Exception {
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
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000048W", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		
		/*Segunda vuelta para superar el numero de intento fijados en: 
		 intentos.COD005.pruebas*/
		 respuesta = this.getProxy().verificarIdentidad(jugadores);
		 resultado = respuesta.get(0);
		 assertEquals("00000048W", resultado.getDni());
		 assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	
		
	
	/**
	 * Para facilitar las pruebas unitarias
	 */
	private ResultadoIdentidad getResultadoIdentidadByDni(String dni, List<ResultadoIdentidad> lista) {
		for (ResultadoIdentidad resultado : lista) {
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
