package es.gob.cnjuego.ws.verificacionjugadores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.gob.cnjuego.ws.dao.VerificacionDao;

public class VerificacionIdentidadTest extends SpringTestCase {


	
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
	/*                          CASOS PRUEBA OPERACION verificarIdentidad                                                           */
	/******************************************************************************************************************************/
	
	
	/**
	 * 1) identidad.modoDebug=false
       2)  En la tabla DNI_DEBUG_IDENTIDAD el  Dni '10000949C'
       3) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
       4) Registros ya existentes  de ese DNI con COD003 y CACHE_IDENTIDAD=0 en JUGADORES_OPERADOR
	 */
	@Test
	public void testVerificarIdentidad01_1() throws Exception {
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
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("10000949C", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**Modificamos alguno de los valores de la tabla de Configuracion, en este caso el de identidad.modoDebug, lo ponemos a "true"
	 * @throws Exception
	 */
	@Test
	public void testVerificarIdentidad01_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("xxxxxxxxx");
		jugador.setNombre("xxxxxxxxx");
		jugador.setApellido1("xxxxxxxxx");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("14/06/1945"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);

		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("xxxxxxxxx", resultado.getDni());
		assertEquals("CODXXX", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**1) identidad.modoDebug=true
	 * 2)  En la tabla DNI_DEBUG_IDENTIDAD el  Dni '10000949C'
	 * 3) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 4) Registros ya existentes  de ese DNI con COD003 y CACHE_IDENTIDAD=0en JUGADORES_OPERADOR
	 */
	@Test
	public void testVerificarIdentidad01_3() throws Exception {
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
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("10000949C", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**
	 * Caso de prueba:
	 * - 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 *   2) No existe un registros en JUGADORES_OPERADOR para ese DNI con COD003 y CACHE_IDENTIDAD=0 
	 */
	@Test
	public void testVerificarIdentidad02_1() throws Exception {
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
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("Y9999999G", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * 2) Existe un registro  en JUGADORES_OPERADOR para ese DNI con COD003 y CACHE_IDENTIDAD=0
	 */
	@Test
	public void testVerificarIdentidad02_2() throws Exception {
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
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("Y9999999G", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * 2) No existe registro en JUGADORES_OPERADOR para ese DNI
	 */
	@Test
	public void testVerificarIdentidad03_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("Y0336380L");
//		jugador.setDni("X273388X");
//		jugador.setDni("");
		jugador.setNombre("GUSTAVO KAUA");
		jugador.setApellido1("GARCIA");
		jugador.setApellido2("");
//		jugador.setNumSoporte("E15459086");
		jugador.setFechaNacimiento(dateFormat.parse("25/09/2003"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
//		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
//		assertEquals("Y0336380L", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * 2) Existe registro en JUGADORES_OPERADOR para ese DNI con COD003 y CACHE_IDENTIDAD=0
	 */
	@Test
	public void testVerificarIdentidad03_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("Y0336380L");
		jugador.setNombre("GUSTAVO KAUA");
		jugador.setApellido1("G�RCIA");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("25/09/2003"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("Y0336380L", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * 2) Existe registro en JUGADORES_OPERADOR para ese DNI con COD003 y CACHE_IDENTIDAD=0, pero con los datos correctos
	 */
	@Test
	public void testVerificarIdentidad03_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("Y0336380L");
		jugador.setNombre("GUSTAVO KAUA�");
		jugador.setApellido1("GAR�CIA");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("25/09/2003"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("Y0336380L", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * 2) Existe registro en JUGADORES_OPERADOR para ese DNI pero solo de COD004 y CACHE_IDENTIDAD=0)
	 */
	@Test
	public void testVerificarIdentidad04() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("94180565G");
		jugador.setNombre("FRANCISO JAVIER");
		jugador.setApellido1("GARCIA");
		jugador.setApellido2("REYES");
		jugador.setFechaNacimiento(dateFormat.parse("21/12/1945"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("94180565G", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * 2) Existe registro en JUGADORES_OPERADOR para ese DNI con COD003 y CACHE_IDENTIDAD=0, pero con datos distintos)
	 */
	@Test
	public void testVerificarIdentidad05() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("94180565G");
		jugador.setNombre("FRANCISO");
		jugador.setApellido1("GARCIA");
		jugador.setApellido2("REYES");
		jugador.setFechaNacimiento(dateFormat.parse("21/12/1945"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("94180565G", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * 2)No  existe registro en JUGADORES_OPERADOR para ese DNI
	 */
	@Test
	public void testVerificarIdentidad06() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("00000002R");
		jugador.setNombre("LUIS");
		jugador.setApellido1("LOPEZ");
		jugador.setApellido2("REYES");
		jugador.setFechaNacimiento(dateFormat.parse("21/12/1945"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("00000002R", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 *1) 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 *2)No  existe registro en JUGADORES_OPERADOR para ese DNI
	 **/
	@Test
	public void testVerificarIdentidad06_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("000000002W");
		jugador.setNombre("LUIS");
		jugador.setApellido1("LOPEZ");
		jugador.setApellido2("REYES");
		jugador.setFechaNacimiento(dateFormat.parse("21/12/1945"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("000000002W", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoIdentidad().getCodigo());
	}	
	
	
	/**
	 *1) 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 *2)No  existe registro en JUGADORES_OPERADOR para ese DNI
	 **/
	@Test
	public void testVerificarIdentidad06_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X000074M");
		jugador.setNombre("LUIS");
		jugador.setApellido1("LOPEZ");
		jugador.setApellido2("REYES");
		jugador.setFechaNacimiento(dateFormat.parse("21/12/1945"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("X000074M", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoIdentidad().getCodigo());
	}	
	
	/**
	 *1) 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 *2)No  existe registro en JUGADORES_OPERADOR para ese DNI
	 **/
	@Test
	public void testVerificarIdentidad06_4() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("5393496L");
		jugador.setNombre("LUIS");
		jugador.setApellido1("LOPEZ");
		jugador.setApellido2("REYES");
		jugador.setFechaNacimiento(dateFormat.parse("21/12/1945"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("5393496L", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}	
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * 2)Existen registros en JUGADORES_OPERADOR para ese DNI
	 */
	@Test
	public void testVerificarIdentidad07() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("30000067V");
		jugador.setNombre("JUAN");
		jugador.setApellido1("GARCIA");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("14/06/1945"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("30000067V", resultado.getDni());
		assertEquals("COD903", resultado.getResultadoIdentidad().getCodigo());
	}
	
	@Test
	public void testVerificarIdentidad07_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("30000067V");
		jugador.setNombre("JUAN");
		jugador.setApellido1("");
		jugador.setApellido2("LOSADA");
		jugador.setFechaNacimiento(dateFormat.parse("14/06/1945"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("30000067V", resultado.getDni());
		assertEquals("COD903", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 2)Existe registro en JUGADORES_OPERADOR para ese DNI
	 */
	@Test
	public void testVerificarIdentidad08() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("30000067V");
		jugador.setNombre("JUAN");
		jugador.setApellido1("GARCIA");
		jugador.setApellido2("LOSADA");
		jugador.setFechaNacimiento(dateFormat.parse("14/06/1845"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("30000067V", resultado.getDni());
		assertEquals("COD904", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 2)Existe registro en JUGADORES_OPERADOR para ese DNI
	 */
	@Test
	public void testVerificarIdentidad09() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("30000067V");
		jugador.setNombre("JUAN@123");
		jugador.setApellido1("GARCIA");
		jugador.setApellido2("LOSADA");
		jugador.setFechaNacimiento(dateFormat.parse("14/06/1945"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("30000067V", resultado.getDni());
		assertEquals("COD902", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 2)No  existe registro en JUGADORES_OPERADOR para ese DNI
	 */
	@Test
	public void testVerificarIdentidad09_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("30000067V");
		jugador.setNombre("JUAN");
		jugador.setApellido1("GARCIA");
		jugador.setApellido2("LOSADA");
		jugador.setFechaNacimiento(dateFormat.parse("14/06/1945"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("30000067V", resultado.getDni());
		assertEquals("COD005", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * Caso de prueba: 
	 * - Caracteres que se formatean
	 * - MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * - Existe registro en JUGADORES_OPERADOR para ese DNI
	 * 
	 * Comprobaciones manuales luego del test:
	 * - Comprobamos que ha ido al SVDI,pero que ah� ha dado error el SW (mirar en la base de datos de
	 * requirente)
	 * - Comprobamos que esta bien grabada la petici�n 
	 */
	@Test
	public void testVerificarIdentidad10() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("65000010D");
		jugador.setNombre("��B�MA");
		jugador.setApellido1("L����R");
		jugador.setApellido2("��B�R��");
		jugador.setFechaNacimiento(dateFormat.parse("31/08/1969"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("65000010D", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 2)Existe registro en JUGADORES_OPERADOR para ese DNI
	 */
	@Test
	public void testVerificarIdentidad11() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("10000320N");
		jugador.setNombre("MARIA� ENCINA");
		jugador.setApellido1("FELIZ");
		jugador.setApellido2("VARELA");
		jugador.setFechaNacimiento(dateFormat.parse("18/05/1944"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("10000320N", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * Caso de prueba: 
	 * - Peticion de varios registros
	 * - MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * - Existen registros en JUGADORES_OPERADOR para ese DNI 
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - Comprobamos que ha ido al SVDI con los DNI que corresponde
	 * - Comprobamos que esta bien grabada la petici�n
	 */
	@Test
	public void testVerificarIdentidad12() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador j1 = new Jugador();
		j1.setDni("30000067V");
		j1.setNombre("JUAN");
		j1.setApellido1("GARCIA");
		j1.setApellido2("LOSADA");
		j1.setFechaNacimiento(dateFormat.parse("14/06/1945"));
		Jugador j2 = new Jugador();
		j2.setDni("10000949C");
		j2.setNombre("OLGA");
		j2.setApellido1("SAN MIGUEL");
		j2.setApellido2("CHAO");
		j2.setFechaNacimiento(dateFormat.parse("02/06/1940"));
		Jugador j3 = new Jugador();
		j3.setDni("10000320N");
		j3.setNombre("MARIA� ENCINA");
		j3.setApellido1("FELIZ");
		j3.setApellido2("VARELA");
		j3.setFechaNacimiento(dateFormat.parse("18/05/1944"));
		Jugador j4 = new Jugador();
		j4.setDni("00000060Z");
		j4.setNombre("SANTIAGO");
		j4.setApellido1("MARTIN");
		j4.setApellido2("G�EL");
		j4.setFechaNacimiento(dateFormat.parse("23/02/1982"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(j1);
		jugadores.add(j2);
		jugadores.add(j3);
		jugadores.add(j4);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		assertEquals(4, respuesta.size());

		ResultadoIdentidad resultado = this.getResultadoIdentidadByDni("30000067V", respuesta);
		assertEquals("30000067V", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());

		resultado = this.getResultadoIdentidadByDni("10000949C", respuesta);
		assertEquals("10000949C", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());

		resultado = this.getResultadoIdentidadByDni("10000320N", respuesta);
		assertEquals("10000320N", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());

		resultado = this.getResultadoIdentidadByDni("00000060Z", respuesta);
		assertEquals("00000060Z", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 2) El parametro  "verificarIdentidad.timestamp.opcional" de la tabla de CONFIGURACION est� a "false"
	 */
	@Test
	public void testVerificarIdentidad13() throws Exception {
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
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		// Aqui debe de dar Error. esto hay que ptobarlo con SOAP UI
		
	}
	
	
	/**1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 2) El NIE no existe en JUGADORES_OPERADOR
	 * 3) Solo se manda Apellido1 
	 */
	@Test
	public void testVerificarIdentidad14_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X9135296H");
		jugador.setNombre("antonio luis");
		jugador.setApellido1("henriques");
		jugador.setApellido2(null);
		jugador.setFechaNacimiento(dateFormat.parse("13/05/1985"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("X9135296H", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 2) El NIE existe en JUGADORES_OPERADOR  pero solo con APELLIDO1
	 * 3) Se m anda Apellido1 y Apellido2
	 */
	@Test
	public void testVerificarIdentidad14_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X9135296H");
		jugador.setNombre("antonio luis");
		jugador.setApellido1("henriques");
		jugador.setApellido2("lopes");
		jugador.setFechaNacimiento(dateFormat.parse("13/05/1985"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("X9135296H", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**1) 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 2) El NIE ya existe en JUGADORES_OPERADOR  tanto solo con Apellido1 como con apellido1 y apellido2
	 * 3) Solo se manda Apellido1
	 */
	@Test
	public void testVerificarIdentidad14_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X9135296H");
		jugador.setNombre("antonio luis");
		jugador.setApellido1("henriques");
		jugador.setApellido2(null);
		jugador.setFechaNacimiento(dateFormat.parse("13/05/1985"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("X9135296H", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
       2) El NIE existe en JUGADORES_OPERADOR  con APELLIDO1, y con APELLIDO1 y APELLDIO"
       3) Se manda Apellido1 y Apellido2
       */
	@Test
	public void testVerificarIdentidad14_4() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X9135296H");
		jugador.setNombre("antonio luis");
		jugador.setApellido1("henriques");
		jugador.setApellido2(null);
		jugador.setFechaNacimiento(dateFormat.parse("13/05/1985"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("X9135296H", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
       2) El NIE existe en JUGADORES_OPERADOR  con APELLIDO1, y con APELLIDO1 y APELLDIO" 
       3) Se manda Apellido1 diferente
    */
	@Test
	public void testVerificarIdentidad14_5() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X9135296H");
		jugador.setNombre("antonio luis");
		jugador.setApellido1("henrique");
		jugador.setApellido2(null);
		jugador.setFechaNacimiento(dateFormat.parse("13/05/1985"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("X9135296H", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**11) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 2) El NIE existe en JUGADORES_OPERADOR  con APELLIDO1, y con APELLIDO1 y APELLDIO"
	 * 3) Se manda Apellido1 y Apellido2 diferente
	 * */
	@Test
	public void testVerificarIdentidad14_6() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X9135296H");
		jugador.setNombre("antonio luis");
		jugador.setApellido1("henriques");
		jugador.setApellido2("lope");
		jugador.setFechaNacimiento(dateFormat.parse("13/05/1985"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("X9135296H", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 2) El DNI no existe y mandamos como Apellido1= "De la.."
	 */
	@Test
	public void testVerificarIdentidad15_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("18110879N");
		jugador.setNombre("jesus javier");
		jugador.setApellido1("de la torre");
		jugador.setApellido2("valverde");
		jugador.setFechaNacimiento(dateFormat.parse("09/04/1978"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("18110879N", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 2) El DNI no existe y mandamos como Apellido1= De�" sin el la
	 */
	@Test
	public void testVerificarIdentidad15_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("18110879N");
		jugador.setNombre("jesus javier");
		jugador.setApellido1("de torre");
		jugador.setApellido2("valverde");
		jugador.setFechaNacimiento(dateFormat.parse("09/04/1978"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("18110879N", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 2) El DNI no existe y mandamos como Apellido1= De la " 
	 */
	@Test
	public void testVerificarIdentidad15_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("18110879N");
		jugador.setNombre("jesus javier");
		jugador.setApellido1("de la torre");
		jugador.setApellido2("valverde");
		jugador.setFechaNacimiento(dateFormat.parse("09/04/1978"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("18110879N", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * 1) MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 2) El DNI no existe y mandamos como Apellido1= De�" sin el la
	 */
	@Test
	public void testVerificarIdentidad15_4() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("18110879N");
		jugador.setNombre("jesus javier");
		jugador.setApellido1("de torre");
		jugador.setApellido2("valverde");
		jugador.setFechaNacimiento(dateFormat.parse("09/04/1978"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocaci�n del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guard� la petici�n en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("18110879N", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
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