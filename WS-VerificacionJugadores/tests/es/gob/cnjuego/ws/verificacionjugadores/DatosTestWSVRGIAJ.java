package es.gob.cnjuego.ws.verificacionjugadores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.gob.cnjuego.ws.dao.VerificacionDao;

public class DatosTestWSVRGIAJ extends SpringTestCase {
	

	


	
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
	/*                          CASOS PRUEBA OPERACION verificarRGIAJ                                                           */
	/******************************************************************************************************************************/
	
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Dni que existe en TEST_WS , correcto y está en  RGIAJ
	 */
	@Test
	public void testverificarRGIAJ01_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000034B");
		jugador.setNombre("Emilio Jose");
		jugador.setApellido1("Garcia Ruiz");
		jugador.setApellido2("Gonzalez");
		jugador.setFechaNacimiento(dateFormat.parse("01/08/1953"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000034B", resultado.getDni());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	/**1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Dni que existe en TEST_WS , correcto y está en  RGIAJ
	 */
	@Test
	public void testverificarRGIAJ01_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000034B");
		jugador.setNombre("Emilio Jose");
		jugador.setApellido1("Garcia Ruiz");
		jugador.setApellido2("Gonzalez");
		jugador.setFechaNacimiento(dateFormat.parse("01/08/1953"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);

		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000034B", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Dni que existe en TEST_WS , correcto y está en  RGIAJ
	 */
	@Test
	public void testverificarRGIAJ01_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000034B");
		jugador.setNombre("Emilio Jose");
		jugador.setApellido1("Garcia Ruiz");
		jugador.setApellido2("Gonzalez");
		jugador.setFechaNacimiento(dateFormat.parse("01/08/1953"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000034B", resultado.getDni());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Dni que existe en TEST_WS , correcto y no está en  RGIAJ
	 * (Case 22)
	 */
	@Test
	public void testverificarRGIAJ02_1() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("Y9999999G", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba2.2 Dni que existe en TEST_WS , correcto y no está en  RGIAJ
	 */
	@Test
	public void testverificarRGIAJ02_2() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("Y9999999G", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba2.3 Dni que existe en TEST_WS , correcto y no está en  RGIAJ
	 */
	@Test
	public void testverificarRGIAJ02_3() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("Y9999999G", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba3.1 Dni que existe en TEST_WS , titular no correcto y  está en  RGIAJ (case23)
	 */
	@Test
	public void testverificarRGIAJ03_1() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000048W", resultado.getDni());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba3.2 Dni que existe en TEST_WS , titular no correcto y  está en  RGIAJ
	 */
	@Test
	public void testverificarRGIAJ03_2() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000048W", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba3.3 Dni que existe en TEST_WS , titular no correcto y  está en  RGIAJ
	 */
	@Test
	public void testverificarRGIAJ03_3() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000048W", resultado.getDni());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba4.1 Dni que existe en TEST_WS , titular no correcto y  no esta  RGIAJ (case 24)
	 */
	@Test
	public void testverificarRGIAJ04_1() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000047R", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba4.2 Dni que existe en TEST_WS , titular no correcto y  no esta  RGIAJ
	 */
	@Test
	public void testverificarRGIAJ04_2() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000047R", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba4.3 Dni que existe en TEST_WS , titular no correcto y  no esta  RGIAJ
	 */
	@Test
	public void testverificarRGIAJ04_3() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000047R", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba5.1 Dni que existe en TEST_WS , pero con un nombre distinto al de la tabla, pero de los de titular no identificado y no en RGIAJ
	 */
	@Test
	public void testverificarRGIAJ05_1() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000047R", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba5.1 Dni que existe en TEST_WS , pero con un nombre distinto al de la tabla, pero de los de titular no identificado y no en RGIAJ
	 */
	@Test
	public void testverificarRGIAJ05_2() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000047R", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba5.1 Dni que existe en TEST_WS , pero con un nombre distinto al de la tabla, pero de los de titular no identificado y no en RGIAJ
	 */
	@Test
	public void testverificarRGIAJ05_3() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000047R", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba6.1 Dni que existe en TEST_WS , pero con un nombre distinto al de la tabla,  de los de titular  identificado y  en RGIAJ (case21)
	 */
	@Test
	public void testverificarRGIAJ06_1() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000034B", resultado.getDni());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba6.1 Dni que existe en TEST_WS , pero con un nombre distinto al de la tabla,  de los de titular  identificado y  en RGIAJ (case21)
	 */
	@Test
	public void testverificarRGIAJ06_2() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000034B", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba6.1 Dni que existe en TEST_WS , pero con un nombre distinto al de la tabla,  de los de titular  identificado y  en RGIAJ (case21)
	 */
	@Test
	public void testverificarRGIAJ06_3() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000034B", resultado.getDni());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba7.1 Dni que  existe en TEST_WS, pero enviamos un fecha de nacimiento menor al 1900 (Case 21)
	 */
	@Test
	public void testverificarRGIAJ07_1() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000034B", resultado.getDni());
		assertEquals("COD904", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba7.1 Dni que  existe en TEST_WS, pero enviamos un fecha de nacimiento menor al 1900 (Case 21)
	 */
	@Test
	public void testverificarRGIAJ07_2() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000034B", resultado.getDni());
		assertEquals("COD904", resultado.getResultadoRGIAJ().getCodigo());
	}
		
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba7.1 Dni que  existe en TEST_WS, pero enviamos un fecha de nacimiento menor al 1900 (Case 21)
	 */
	@Test
	public void testverificarRGIAJ07_3() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000034B", resultado.getDni());
		assertEquals("COD904", resultado.getResultadoRGIAJ().getCodigo());
	}
		
	
		
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba8.1 Dni que  no existe en TEST_WS. (Case 25)
	 */
	@Test
	public void testverificarRGIAJ08_1() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("X0000074M", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba8.1 Dni que  no existe en TEST_WS. (Case 25)
	 */
	@Test
	public void testverificarRGIAJ08_2() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("X0000074M", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba8.1 Dni que  no existe en TEST_WS. (Case 25)
	 */
	@Test
	public void testverificarRGIAJ08_3() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("X0000074M", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba9.1 Dni erroneo. (Case 28)
	 */
	@Test
	public void testverificarRGIAJ09_1() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000018K", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba9.1 Dni erroneo. (Case 28)
	 */
	@Test
	public void testverificarRGIAJ09_2() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000018K", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba9.1 Dni erroneo. (Case 28)
	 */
	@Test
	public void testverificarRGIAJ09_3() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000018K", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=1 de JUG_OPERADOR_JUEGO
	 * Prueba10.1 Dni erroneo. (Case 28)
	 */
	@Test
	public void testverificarRGIAJ10_1() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("000000018K", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * Prueba10.2 Dni erroneo. (Case 28)
	 */
	@Test
	public void testverificarRGIAJ10_2() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("000000018K", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * Prueba10.3 Dni erroneo. (Case 28)
	 */
	@Test
	public void testverificarRGIAJ10_3() throws Exception {
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
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("000000018K", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	
	/**
	 * Para facilitar las pruebas unitarias
	 */
	private ResultadoRGIAJ getResultadoRGIAJByDni(String dni, List<ResultadoRGIAJ> lista) {
		for (ResultadoRGIAJ resultado : lista) {
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
