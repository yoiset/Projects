package es.gob.cnjuego.ws.verificacionjugadores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.ws.soap.SOAPFaultException;

import org.junit.Before;
import org.junit.Test;

import es.gob.cnjuego.ws.dao.VerificacionDao;

public class VerificacionJugadoresImplTestCase extends SpringTestCase {

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
	/*                          CASOS PRUEBA OPERACION VERIFICARIDENTIDAD                                                           */
	/******************************************************************************************************************************/
	
	@Test
	public void testVerificarIdentidadOK1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		List<Jugador> jugadores = new ArrayList<Jugador>();

		Jugador j1 = new Jugador();
		j1.setNombre("MARIA ENCINA");
		j1.setApellido1("FELIZ");
		j1.setApellido2("VARELA");
		j1.setDni("10000320N");
		Date fecha1 = dateFormat.parse("18/05/1944"); 
		j1.setFechaNacimiento(fecha1);
		jugadores.add(j1);
		
		Jugador j2 = new Jugador();
		j2.setNombre("Emilio Jose");
		j2.setApellido1("García Ruiz");
		j2.setApellido2("González");
		j2.setDni("00000034B");
		Date fecha2 = dateFormat.parse("01/08/1953"); 
		j2.setFechaNacimiento(fecha2);
		jugadores.add(j2);
		
		List<ResultadoIdentidad> resultado = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(resultado);
		assertEquals("COD003", resultado.get(0).getResultadoIdentidad().getCodigo());
		assertEquals("10000320N", resultado.get(0).getDni());

		assertEquals("COD003", resultado.get(1).getResultadoIdentidad().getCodigo());
		assertEquals("00000034B", resultado.get(1).getDni());

	}
	
	
	/**
	 * Caso de prueba: 
	 * - El modo debug está activado (en la tabla CONFIGURACION el valor "identidad.modoDebug"=true). El
	 * servicio debe comprobar el DNI directamente en SVDI, sin pasar por la caché.
	 * - En la tabla DNI_DEBUG_IDENTIDAD el  Dni '10000949C'
	 * - MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * - Registros ya existentes  de ese DNI con COD003 y CACHE_IDENTIDAD=0 en JUGADORES_OPERADOR
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - Comprobamos que realmente ha ido al SVDI mirando en la BBDD de requirente
	 */
	@Test
	public void testVerificarIdentidad01() throws Exception {
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
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("10000949C", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * Caso de prueba:
	 * - El modo debug está desactivado (en la tabla CONFIGURACION el valor "identidad.modoDebug"=false). El
	 * servicio debe comprobar el DNI en la caché
	 * - Identidad.modoDebug=false
	 * - En la tabla DNI_DEBUG_IDENTIDAD el  Dni '10000949C'
	 * - MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * - Registros ya existentes  de ese DNI con COD003 y CACHE_IDENTIDAD=0 en JUGADORES_OPERADOR
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - Comprobamos que no ha ido al SVDI, sino que ha sacado los codigos de respuesta por cacheo	 
	 */
	@Test
	public void testVerificarIdentidad03() throws Exception {
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
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("10000320N", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * Mismo DNI de la prueba anterior, es decir, existe un registro previo correcto con Cache_Identidad=0
	 * Comprobaciones manuales luego del test: 
	 * - Comprobamos que no ha ido al SVDI, sino que ha sacado los codigos de respuesta por cacheo	 
	 */
	@Test
	public void testVerificarIdentidad04() throws Exception {
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
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("10000320N", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/**
	 * Caso de prueba:
	 * - Dni con registros previos, correcto
	 * - MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * - Existe registro en JUGADORES_OPERADOR para ese DNI con COD003 y CACHE_IDENTIDAD=0
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - Comprobamos que no ha ido al SVDI, sino que ha sacado los codigos de respuesta por cacheo
	 * - Comprobamos que esta bien grabada la petición
	 */
	@Test
	public void testVerificarIdentidad05() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("20000717D");
		jugador.setNombre("RICARDO");
		jugador.setApellido1("GARCIA");
		jugador.setApellido2("GARCIA");
		jugador.setFechaNacimiento(dateFormat.parse("03/11/1967"));
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
		assertEquals("20000717D", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/** Prueba con caracter no permitido en el nombre
	 * @throws Exception
	 */
	@Test
	public void testVerificarIdentidad11() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("30000067V", resultado.getDni());
		assertEquals("COD902", resultado.getResultadoIdentidad().getCodigo());
	}
	
	/** Prueba con una Fecha anterior a 1900
	 * @throws Exception
	 */
	@Test
	public void testVerificarIdentidad16() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoIdentidad> respuesta = this.getProxy().verificarIdentidad(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoIdentidad resultado = respuesta.get(0);
		assertEquals("30000067V", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoIdentidad().getCodigo());
	}
	
	
	/** Prueba para recargar la tabla de Configuracion
	 * @throws Exception
	 */
	@Test
	public void testVerificarIdentidad17() throws Exception {
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
	
	/******************************************************************************************************************************/
	/*                          CASOS PRUEBA OPERACION VERIFICARGIAJ                                                              */
	/******************************************************************************************************************************/
	
	@Test
	public void testVerificarRGIAJ_OK_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha1 = dateFormat.parse("18/05/1944"); 
		Jugador j1 = new Jugador();
		j1.setNombre("MARIA ENCINA");
		j1.setApellido1("FELIZ");
		j1.setApellido2("VARELA");
		j1.setDni("10000320N");
		j1.setFechaNacimiento(fecha1);
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(j1);
		
//		// Obtenemos la cantidad de peticiones antes de hacer
//		// la invocación del servicio
//		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoRGIAJ> resultado = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(resultado);
		assertEquals("COD001", resultado.get(0).getResultadoRGIAJ().getCodigo());
		assertEquals("10000320N", resultado.get(0).getDni());
		
		//long cantidadDespues = this.getDao().getCantidadPeticiones();
		
//		// Comprobamos que el interceptor de CXF guardó la petición en la BD
//		assertEquals(cantidadAntes + 1, cantidadDespues);		
	}
	
	@Test
	public void testVerificarRGIAJ_OK_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha1 = dateFormat.parse("01/08/1953"); 
		Jugador j1 = new Jugador();
		j1.setNombre("Emilio Jose");
		j1.setApellido1("García Ruiz");
		j1.setApellido2("González");
		j1.setDni("00000034B");
		j1.setFechaNacimiento(fecha1);
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(j1);
		
		List<ResultadoRGIAJ> resultado = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(resultado);
		assertEquals("COD001", resultado.get(0).getResultadoRGIAJ().getCodigo());
		assertEquals("00000034B", resultado.get(0).getDni());
	}
	
	@Test
	public void testVerificarRGIAJ_OK_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		List<Jugador> jugadores = new ArrayList<Jugador>();

		Jugador j1 = new Jugador();
		j1.setNombre("MARIA ENCINA");
		j1.setApellido1("FELIZ");
		j1.setApellido2("VARELA");
		j1.setDni("10000320N");
		Date fecha1 = dateFormat.parse("18/05/1944"); 
		j1.setFechaNacimiento(fecha1);
		jugadores.add(j1);
		
		Jugador j2 = new Jugador();
		j2.setNombre("Emilio Jose");
		j2.setApellido1("García Ruiz");
		j2.setApellido2("González");
		j2.setDni("00000034B");
		Date fecha2 = dateFormat.parse("01/08/1953"); 
		j2.setFechaNacimiento(fecha2);
		jugadores.add(j2);
		
		List<ResultadoRGIAJ> resultado = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(resultado);
		assertEquals("COD001", resultado.get(0).getResultadoRGIAJ().getCodigo());
		assertEquals("10000320N", resultado.get(0).getDni());

		assertEquals("COD001", resultado.get(1).getResultadoRGIAJ().getCodigo());
		assertEquals("00000034B", resultado.get(1).getDni());

	}
	
	/* 
	 * En este test se comprueba que en el caso de usar la operación VerificarRGIAJ con una lista de jugadores
	 * con un DNI repetido se devuelve una excepción
	 */
	@Test
	public void testVerificarRGIAJ_KO() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		List<Jugador> jugadores = new ArrayList<Jugador>();

		Date fecha1 = dateFormat.parse("18/05/1944"); 
		Jugador j1 = new Jugador();
		j1.setNombre("MARIA ENCINA");
		j1.setApellido1("FELIZ");
		j1.setApellido2("VARELA");
		j1.setDni("10000320N");
		j1.setFechaNacimiento(fecha1);
		jugadores.add(j1);

		Date fecha2 = dateFormat.parse("18/05/1944"); 
		Jugador j2 = new Jugador();
		j2.setNombre("MARIA ENCINA");
		j2.setApellido1("FELIZ");
		j2.setApellido2("VARELA");
		j2.setDni("10000320N");
		j2.setFechaNacimiento(fecha2);
		jugadores.add(j2);
		

		try{
			List<ResultadoRGIAJ> resultado = this.getProxy().verificarRGIAJ(jugadores);
			
			assertNotNull(false);
		} catch (VerificarRGIAJFault_Exception e1) {
			assertNotNull(true);
		} catch (SOAPFaultException e1) {
			assertNotNull(true);
		}
		
	}
	
	/**
	 * Caso de prueba: 
	 * - El modo debug está activado (en la tabla CONFIGURACION el valor "identidad.modoDebug"=true). El
	 * servicio debe comprobar el DNI directamente en SVDI, sin pasar por la caché.
	 * - En la tabla DNI_DEBUG_IDENTIDAD el  Dni '10000949C'
	 * - MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * - Valor esperado RES_RGIAJ='COD002'
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - Comprobamos que realmente ha ido al SVDI mirando en la BBDD de requirente
	 */
	
	
	/**
	 * Esta prueba comprueba la invocación que recupera los DNIs de los
	 * jugadores que han cambiado de estado, para un operador dado.
	 * Nótese que la información del operador viaja en las cabeceras de
	 * la invocación (parte pública del certificado usado para la firma)
	 */
	@Test
	public void testVerificarCambiosRGIAJOk() throws Exception {
		List<CambioRGIAJ> resultado = this.getProxy().verificarCambiosRGIAJ();
		assertNotNull(resultado);
		assertTrue(!resultado.isEmpty());
		CambioRGIAJ cambio = resultado.get(0);
		assertTrue(!cambio.getDNI().equals(""));
		assertTrue(cambio.getMotivoCambio().equals("A") || cambio.getMotivoCambio().equals("B"));
		assertNotNull(cambio.getFechaCambio());
	}
	
	/******************************************************************************************************************************/
	/*                          CASOS PRUEBA OPERACION VERIFICARJUGADOR                                                           */
	/******************************************************************************************************************************/
	
	
	/**
	 * Caso de prueba: 
	 * - El modo debug está activado (en la tabla CONFIGURACION el valor "identidad.modoDebug"=true). El
	 * servicio debe comprobar el DNI directamente en SVDI, sin pasar por la caché.
	 * - En la tabla DNI_DEBUG_IDENTIDAD el  Dni '10000949C'
	 * - MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * - Registros ya existentes  de ese DNI con COD003 y CACHE_IDENTIDAD=0 en JUGADORES_OPERADOR
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - Comprobamos que realmente ha ido al SVDI mirando en la BBDD de requirente
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
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("10000949C", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * Caso de prueba:
	 * - El modo debug está desactivado (en la tabla CONFIGURACION el valor "identidad.modoDebug"=false). El
	 * servicio debe comprobar el DNI en la caché
	 * - Identidad.modoDebug=false
	 * - En la tabla DNI_DEBUG_IDENTIDAD el  Dni '10000949C'
	 * - MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * - Registros ya existentes  de ese DNI con COD003 y CACHE_IDENTIDAD=0 en JUGADORES_OPERADOR
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - Comprobamos que no ha ido al SVDI, sino que ha sacado los codigos de respuesta por cacheo	 
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
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("10000949C", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * Caso de prueba:
	 * - Dni nuevo, sin registros previos, correcto y está en  RGIAJ
	 * - MODE_ENABLED=3 de JUG_OPERADOR_JUEGO 
	 * - No existe un registros en JUGADORES_OPERADOR para ese DNI con COD003 y CACHE_IDENTIDAD=0 
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - Comprobamos que realmente ha ido al SVDI mirando en la BBDD de requirente
	 */
	@Test
	public void testVerificarJugador03() throws Exception {
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
	
	/**
	 * Caso de prueba:
	 * - Mismo Dni de la prueba anterior, es decir, existe un  registros previo correcto, con CACHE_IDENTIDAD=0
	 * - MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * - Existe un registro en JUGADORES_OPERADOR para ese DNI con COD003 y CACHE_IDENTIDAD=0  
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - Comprobamos que no ha ido al SVDI, sino que ha sacado los codigos de respuesta por cacheo
	 */
	@Test
	public void testVerificarJugador04() throws Exception {
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
	
	/**
	 * Caso de prueba:
	 * - Dni con registros previos, correcto y no está en  RGIAJ
	 * - MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * - Existe registro en JUGADORES_OPERADOR para ese DNI con COD003 y CACHE_IDENTIDAD=0
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - Comprobamos que no ha ido al SVDI, sino que ha sacado los codigos de respuesta por cacheo
	 * - Comprobamos que esta bien grabada la petición
	 */
	@Test
	public void testVerificarJugador05() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("20000717D");
		jugador.setNombre("RICARDO");
		jugador.setApellido1("GARCIA");
		jugador.setApellido2("GARCIA");
		jugador.setFechaNacimiento(dateFormat.parse("03/11/1967"));
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
		assertEquals("20000717D", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * Caso de prueba: 
	 * - Dni con registros previos, pero no identificado y no está en  RGIAJ.
	 * - MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * - Existe registro en JUGADORES_OPERADOR para ese DNI pero solo de COD004 y CACHE_IDENTIDAD=0)
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - Comprobamos que  ha ido al SVDI
	 * - Comprobamos que esta bien grabada la petición
	 */
	@Test
	public void testVerificarJugador06() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("20000717D", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * Caso de prueba: 
	 * - Dni con registros previos, pero no identificado y no está en  RGIAJ.
	 * - MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * - Existe registro en JUGADORES_OPERADOR para ese DNI con COD003 y CACHE_IDENTIDAD=0, 
	 * pero con datos distintos)
	 * 
	 * Comprobaciones manuales luego del test:
	 * - Comprobamos que no ha ido al SVDI, sino que los codigos de respuesta los ha obtenido por el cache
	 * - Comprobamos que esta bien grabada la petición 
	 */
	@Test
	public void testVerificarJugador07() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("94180565G", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * Caso de prueba:
	 * - Dni erroneo
	 * - MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * - No existe registro en JUGADORES_OPERADOR para ese DNI
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - Comprobamos que  no ha ido al SVDI, por ser error de datos
	 * - Comprobamos que esta bien grabada la petición
	 */
	@Test
	public void testVerificarJugador08() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("00000002R", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD901", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * Caso de prueba: 
	 * - Sin segundo apellido y es un NIF
	 * - MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * - No existe registro en JUGADORES_OPERADOR para ese DNI 
	 * 
	 * Comprobaciones manuales luego del test:
	 * - Comprobamos que  no ha ido al SVDI, por ser error de datos
	 * - Comprobamos que esta bien grabada la petición	 
	 */
	@Test
	public void testVerificarJugador09() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("30000067V", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD901", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * Caso de prueba: 
	 * - Con fecha de nacimiento menor que 01/01/1900
	 * - MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * - No existe registro en JUGADORES_OPERADOR para ese DNI 
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - Comprobamos que ha ido al SVDI y que este devuleve error de datos por ser una fecha 
	 * anterior al 01/01/1900
	 * - Comprobamos que esta bien grabada la petición
	 */
	@Test
	public void testVerificarJugador10() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("30000067V", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * Caso de prueba: 
	 * - Con un carácter no permitido en el nombre
	 * - MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * - No existe registro en JUGADORES_OPERADOR para ese DNI 
	 * 
	 * Comprobaciones manuales luego del test:
	 * - Comprobamos que  no  ha ido al SVDI,ya que hay error en datos
	 * - Comprobamos que esta bien grabada la petición
	 */
	@Test
	public void testVerificarJugador11() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("30000067V", resultado.getDni());
		assertEquals("COD902", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD902", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * Caso de prueba: 
	 * - Error de servicio del SVDI
	 * - MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * - No existe registro en JUGADORES_OPERADOR para ese DNI
	 * 
	 * Comprobaciones manuales luego del test:
	 * - Comprobamos que ha ido al SVDI, pero que ahí ha dado error el SW (mirar en la base 
	 * de datos de requirente)
	 * - Comprobamos que esta bien grabada la petición 
	 */
	@Test
	public void testVerificarJugador12() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("30000067V", resultado.getDni());
		assertEquals("COD005", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * Caso de prueba: 
	 * - Caracteres que se formatean
	 * - MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * - No existe registro en JUGADORES_OPERADOR para ese DNI
	 * 
	 * Comprobaciones manuales luego del test:
	 * - Comprobamos que ha ido al SVDI,pero que ahí ha dado error el SW (mirar en la base de datos de
	 * requirente)
	 * - Comprobamos que esta bien grabada la petición 
	 */
	@Test
	public void testVerificarJugador13() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("65000010D");
		jugador.setNombre("ÑÉBÌMA");
		jugador.setApellido1("L·ÜÇÄR");
		jugador.setApellido2("ÇÖBËRÏÀ");
		jugador.setFechaNacimiento(dateFormat.parse("31/08/1969"));
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
		assertEquals("65000010D", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * Caso de prueba:
	 * - Caracteres que CACHE_IDENTIDAD=2
	 * - MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * - No existe registro en JUGADORES_OPERADOR para ese DNI 
	 * 
	 * Comprobaciones manuales luego del test:
	 * - Comprobamos que ha ido al SVDI,pero que ahí ha dado error el SW (mirar en la base de 
	 * datos de requirente)
	 * - Comprobamos que esta bien grabada la petición
	 */
	@Test
	public void testVerificarJugador14() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("10000320N");
		jugador.setNombre("Mª ENCINA");
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
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * Caso de prueba: 
	 * - Peticion de varios registros
	 * - MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * - Existen registros en JUGADORES_OPERADOR para ese DNI 
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - Comprobamos que ha ido al SVDI con los DNI que corresponde
	 * - Comprobamos que esta bien grabada la petición
	 */
	@Test
	public void testVerificarJugador15() throws Exception {
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
		j3.setNombre("MARIA ENCINA");
		j3.setApellido1("FELIZ");
		j3.setApellido2("VARELA");
		j3.setFechaNacimiento(dateFormat.parse("18/05/1944"));
		Jugador j4 = new Jugador();
		j4.setDni("00000060Z");
		j4.setNombre("SANTIAGO");
		j4.setApellido1("MARTIN");
		j4.setApellido2("GÜEL");
		j4.setFechaNacimiento(dateFormat.parse("23/02/1982"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(j1);
		jugadores.add(j2);
		jugadores.add(j3);
		jugadores.add(j4);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		assertEquals(4, respuesta.size());

		ResultadoJugador resultado = this.getResultadoJugadorByDni("30000067V", respuesta);
		assertEquals("30000067V", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());

		resultado = this.getResultadoJugadorByDni("10000949C", respuesta);
		assertEquals("10000949C", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());

		resultado = this.getResultadoJugadorByDni("10000320N", respuesta);
		assertEquals("10000320N", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());

		resultado = this.getResultadoJugadorByDni("00000060Z", respuesta);
		assertEquals("00000060Z", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	/**
	 * Caso de prueba: 
	 * - El certificado del operador no esta cargado en JUG_OPERADOR_JUEGO
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - FAULT con error de operador no valido (ERR002) en la tabla de peticiones y no hay registro 
	 * en JUGADORES_OPERADOR
	 */
	@Test
	public void testVerificarJugadorFault01() throws Exception {
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
		
		try {
			List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
			assertTrue("No se produjo la excepción!", false);
		} catch (VerificarJugadorFault_Exception e) {
			assertTrue("Esperaba esta excepción!", true);
			long cantidadDespues = this.getDao().getCantidadPeticiones();
			// Comprobamos que el interceptor de CXF guardó la petición en la BD
			assertEquals(cantidadAntes + 1, cantidadDespues);
		}
	}
	
	/**
	 * Caso de prueba: 
	 * - Operador no activado
	 * - En la tabla  JUG_OPERADOR_JUEGO el MODO_ENABLED=0
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - FAULT con error de operador no valido (ERR002) en la tabla de peticiones y no hay registro 
	 * en JUGADORES_OPERADOR
	 */
	@Test
	public void testVerificarJugadorFault02() throws Exception {
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
		
		try {
			List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
			assertTrue("No se produjo la excepción!", false);
		} catch (VerificarJugadorFault_Exception e) {
			assertTrue("Esperaba esta excepción!", true);
			long cantidadDespues = this.getDao().getCantidadPeticiones();
			// Comprobamos que el interceptor de CXF guardó la petición en la BD
			assertEquals(cantidadAntes + 1, cantidadDespues);
		}
	}
	
	/**
	 * Caso de prueba: 
	 * - Error tecnico
	 * - No levantados los servicion internos (SCSP, JuegosDNIs)
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - FAULT con error de operador no valido (ERR001) en la tabla de peticiones y no hay registro
	 *  en JUGADORES_OPERADOR
	 */
	@Test
	public void testVerificarJugadorFault03() throws Exception {
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
		
		try {
			List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
			assertTrue("No se produjo la excepción!", false);
		} catch (VerificarJugadorFault_Exception e) {
			assertTrue("Esperaba esta excepción!", true);
			long cantidadDespues = this.getDao().getCantidadPeticiones();
			// Comprobamos que el interceptor de CXF guardó la petición en la BD
			assertEquals(cantidadAntes + 1, cantidadDespues);
		}
	}
	
	/**
	 * Caso de prueba: 
	 * - Error tecnico
	 * - La base de datos no está disponible
	 * 
	 * Comprobaciones manuales luego del test: 
	 * - FAULT con error de operador no valido (ERR001) en la tabla de peticiones y no hay registro
	 *  en JUGADORES_OPERADOR
	 */
	@Test
	public void testVerificarJugadorFault04() throws Exception {
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
		
		try {
			List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
			assertTrue("No se produjo la excepción!", false);
		} catch (VerificarJugadorFault_Exception e) {
			assertTrue("Esperaba esta excepción!", true);
			long cantidadDespues = this.getDao().getCantidadPeticiones();
			// Comprobamos que el interceptor de CXF guardó la petición en la BD
			assertEquals(cantidadAntes + 1, cantidadDespues);
		}
	}
	
	/**
	 * Caso de prueba: 
	 * - Peticion masiva con Dni repetidos
	 * - MODE_ENABLED=2 de JUG_OPERADOR_JUEGO
	 * 
	 * Comprobaciones manuales luego del test:
	 * - FAULT con error de operador no valido (ERR003) en la tabla de peticiones y no hay registros
	 * en JUGADORES_OPERADOR 
	 */
	@Test
	public void testVerificarJugadorFault05() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador j1 = new Jugador();
		j1.setDni("10000949C");
		j1.setNombre("OLGA");
		j1.setApellido1("SAN MIGUEL");
		j1.setApellido2("CHAO");
		j1.setFechaNacimiento(dateFormat.parse("02/06/1940"));
		Jugador j2 = new Jugador();
		j2.setDni("10000949C");
		j2.setNombre("OLGA");
		j2.setApellido1("SAN MIGUEL");
		j2.setApellido2("CHAO");
		j2.setFechaNacimiento(dateFormat.parse("02/06/1940"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(j1);
		jugadores.add(j2);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		try {
			List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
			assertTrue("No se produjo la excepción!", false);
		} catch (VerificarJugadorFault_Exception e) {
			assertTrue("Esperaba esta excepción!", true);
			long cantidadDespues = this.getDao().getCantidadPeticiones();
			// Comprobamos que el interceptor de CXF guardó la petición en la BD
			assertEquals(cantidadAntes + 1, cantidadDespues);
		}
	}
	
	/**
	 * Caso de prueba: 
	 * - No enviado algún dato obligatoro
	 * - En la tabla JUG_OPERADOR_JUEGO el MODO_ENABLED=2
	 * 
	 * Comprobaciones manuales luego del test:
	 * - Error soap-fault indicando que falta el APELLIDO1
	 */
	@Test
	public void testVerificarJugadorFault06() throws Exception {
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
		
		try {
			List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
			assertTrue("No se produjo la excepción!", false);
		} catch (VerificarJugadorFault_Exception e) {
			assertTrue("Esperaba esta excepción!", true);
			long cantidadDespues = this.getDao().getCantidadPeticiones();
			// Comprobamos que el interceptor de CXF guardó la petición en la BD
			assertEquals(cantidadAntes + 1, cantidadDespues);
		}
	}
	
	@Test
	public void testVerificarRGIAJ01() throws Exception {
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
		List<Jugador> list=new ArrayList<Jugador>();
		list.add(jugador);
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(list);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("10000949C", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());

	}
	
	/**DNI nuevo, sin registros previos, correcto y esta en el RGIAJ 
	 * Operador Mode_Enable=3
	 * @throws Exception
	 */
	@Test
	public void testVerificarRGIAJ03() throws Exception {
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
		List<Jugador> list=new ArrayList<Jugador>();
		list.add(jugador);
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(list);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("10000320N", resultado.getDni());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());

	}
	
	/**DNI con registros previos, correcto y no esta en el RGIAJ 
	 * Operador Mode_Enable=3
	 * @throws Exception
	 */
	@Test
	public void testVerificarRGIAJ05() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("20000717D");
		jugador.setNombre("RICARDO");
		jugador.setApellido1("GARCIA");
		jugador.setApellido2("GARCIA");
		jugador.setFechaNacimiento(dateFormat.parse("03/11/1967"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		List<Jugador> list=new ArrayList<Jugador>();
		list.add(jugador);
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(list);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("20000717D", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());

	}
	
	
	/**DNI con registros previos, no identificado y no esta en el RGIAJ 
	 * Operador Mode_Enable=3
	 * @throws Exception
	 */
	@Test
	public void testVerificarRGIAJ06() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		List<Jugador> list=new ArrayList<Jugador>();
		list.add(jugador);
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(list);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("94180565G", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());

	}
	
	
	/**DNI con registros previos, no identificado y no esta en el RGIAJ 
	 * Operador Mode_Enable=3
	 * @throws Exception
	 */
	@Test
	public void testVerificarRGIAJ07() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("30000024C");
		jugador.setNombre("FRANCISO");
		jugador.setApellido1("GARCIA");
		jugador.setApellido2("REYES");
		jugador.setFechaNacimiento(dateFormat.parse("21/12/1945"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		List<Jugador> list=new ArrayList<Jugador>();
		list.add(jugador);
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(list);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("30000024C", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());

	}
	
	/**DNI erroneo,
	 * Operador Mode_Enable=2
	 * @throws Exception
	 */
	@Test
	public void testVerificarRGIAJ08() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		List<Jugador> list=new ArrayList<Jugador>();
		list.add(jugador);
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(list);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("00000002R", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoRGIAJ().getCodigo());

	}
	
	/**Sin segundo apellido y es un NIF
	 * Operador Mode_Enable=2
	 * @throws Exception
	 */
	@Test
	public void testVerificarRGIAJ09() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		List<Jugador> list=new ArrayList<Jugador>();
		list.add(jugador);
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(list);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("30000067V", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoRGIAJ().getCodigo());

	}
	
	/**Con fecha de nacimiento menor que 01/01/1900
	 * Operador Mode_Enable=2
	 * @throws Exception
	 */
	@Test
	public void testVerificarRGIAJ10() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		List<Jugador> list=new ArrayList<Jugador>();
		list.add(jugador);
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(list);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("30000067V", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());

	}
	
	/**Con un caracter no permitido en el nombre
	 * Operador Mode_Enable=2
	 * @throws Exception
	 */
	@Test
	public void testVerificarRGIAJ11() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		List<Jugador> list=new ArrayList<Jugador>();
		list.add(jugador);
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(list);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("30000067V", resultado.getDni());
		assertEquals("COD902", resultado.getResultadoRGIAJ().getCodigo());

	}
	
	
	/**Error de servicio del SVDI
	 * Operador Mode_Enable=2
	 * @throws Exception
	 */
	@Test
	public void testVerificarRGIAJ12() throws Exception {
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
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		List<Jugador> list=new ArrayList<Jugador>();
		list.add(jugador);
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(list);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("30000067V", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());

	}
	
	/**Caracteres que se formatean
	 * Operador Mode_Enable=2
	 * @throws Exception
	 */
	@Test
	public void testVerificarRGIAJ13() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("65000010D");
		jugador.setNombre("ÑÉBÌMA");
		jugador.setApellido1("L·ÜÇÄR");
		jugador.setApellido2("ÇÖBËRÏÀ");
		jugador.setFechaNacimiento(dateFormat.parse("31/08/1969"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		List<Jugador> list=new ArrayList<Jugador>();
		list.add(jugador);
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(list);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("65000010D", resultado.getDni());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());

	}
	
	
	/**Caracteres con CACHE_IDENTIDAD=2
	 * Operador Mode_Enable=2
	 * @throws Exception
	 */
	@Test
	public void testVerificarRGIAJ14() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("10000320N");
		jugador.setNombre("Mª ENCINA");
		jugador.setApellido1("FELIZ");
		jugador.setApellido2("VARELA");
		jugador.setFechaNacimiento(dateFormat.parse("18/05/1944"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		List<Jugador> list=new ArrayList<Jugador>();
		list.add(jugador);
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(list);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		ResultadoRGIAJ resultado = respuesta.get(0);
		assertEquals("10000320N", resultado.getDni());
//		System.out.println("Codigo resultamte: " + resultado.getResultadoRGIAJ().getCodigo());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());		

	}
	
	
	/**Peticion Masiva
	 * Operador Mode_Enable=2
	 * @throws Exception
	 */
	@Test
	public void testVerificarRGIAJ15() throws Exception {
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
		j3.setNombre("MARIA ENCINA");
		j3.setApellido1("FELIZ");
		j3.setApellido2("VARELA");
		j3.setFechaNacimiento(dateFormat.parse("18/05/1944"));
		Jugador j4 = new Jugador();
		j4.setDni("00000060Z");
		j4.setNombre("SANTIAGO");
		j4.setApellido1("MARTIN");
		j4.setApellido2("GÜEL");
		j4.setFechaNacimiento(dateFormat.parse("23/02/1982"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(j1);
		jugadores.add(j2);
		jugadores.add(j3);
		jugadores.add(j4);
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		List<ResultadoRGIAJ> respuesta = this.getProxy().verificarRGIAJ(jugadores);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		System.out.println("ID Peticion a partir: " + cantidadAntes);
		
		ResultadoRGIAJ resultado1 = respuesta.get(0);
		assertEquals("30000067V", resultado1.getDni());
		assertEquals("COD002", resultado1.getResultadoRGIAJ().getCodigo());		
		
		ResultadoRGIAJ resultado2 = respuesta.get(1);
		assertEquals("10000949C", resultado2.getDni());
		assertEquals("COD002", resultado2.getResultadoRGIAJ().getCodigo());	
		
		ResultadoRGIAJ resultado3 = respuesta.get(2);
		assertEquals("10000320N", resultado3.getDni());
		assertEquals("COD001", resultado3.getResultadoRGIAJ().getCodigo());	
		
		ResultadoRGIAJ resultado4 = respuesta.get(3);
		assertEquals("00000060Z", resultado4.getDni());
		assertEquals("COD002", resultado4.getResultadoRGIAJ().getCodigo());	

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
