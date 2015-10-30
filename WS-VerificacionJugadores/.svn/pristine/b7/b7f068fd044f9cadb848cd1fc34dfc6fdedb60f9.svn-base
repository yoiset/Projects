package es.gob.cnjuego.ws.verificacionjugadores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.gob.cnjuego.ws.dao.VerificacionDao;

public class DocumentoWSCasos extends SpringTestCase{
	
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
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * 2) Existe registro en JUGADORES_OPERADOR para ese DNI con COD003 y CACHE_IDENTIDAD=0
	 */
	@Test
	public void testVerificarJugador1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("20000717D");
		jugador.setNombre("RICARDO");
		jugador.setApellido1("GARCIA");
		jugador.setApellido2("GARCIA");
		jugador.setFechaNacimiento(dateFormat.parse("03/11/1967"));
		
		Jugador jugador2 = new Jugador();
		jugador2.setDni("30000024C");
		jugador2.setNombre("Francisco Javier");
		jugador2.setApellido1("GARCIA");
		jugador2.setApellido2("Reyes");
		jugador2.setFechaNacimiento(dateFormat.parse("21/12/1945"));
		
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		jugadores.add(jugador2);
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
		
		resultado = respuesta.get(1);
		assertEquals("30000024C", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * 2) No existe registro en JUGADORES_OPERADOR para ese DNI
	 */
	@Test
	public void testVerificarJugador2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("30000067V");
		jugador.setNombre("Juan");
		jugador.setApellido1("GARCIA");
		jugador.setApellido2("Losada");
		jugador.setFechaNacimiento(dateFormat.parse("14/06/1945"));
		
		Jugador jugador2 = new Jugador();
		jugador2.setDni("30000260B");
		jugador2.setNombre("Juan");
		jugador2.setApellido1("GARCIA");
		jugador2.setApellido2("Soto");
		jugador2.setFechaNacimiento(dateFormat.parse("02/01/1938"));
		
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		jugadores.add(jugador2);
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
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
		
		resultado = respuesta.get(1);
		assertEquals("30000260B", resultado.getDni());
		assertEquals("COD901", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD901", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * 2) Existe registro en JUGADORES_OPERADOR para ese DNI con COD003 y CACHE_IDENTIDAD=0
	 */
	@Test
	public void testVerificarJugador3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("30000529L");
		jugador.setNombre("Jose");
		jugador.setApellido1("GARCIA");
		jugador.setApellido2("Plata");
		jugador.setFechaNacimiento(dateFormat.parse("04/10/1944"));
		
		Jugador jugador2 = new Jugador();
		jugador2.setDni("30000831E");
		jugador2.setNombre("Pedro");
		jugador2.setApellido1("GARCIA");
		jugador2.setApellido2("Giraldo");
		jugador2.setFechaNacimiento(dateFormat.parse("20/02/1946"));
		
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		jugadores.add(jugador2);
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
		assertEquals("30000529L", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());
		
		resultado = respuesta.get(1);
		assertEquals("30000831E", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	/**
	 * 1) MODE_ENABLED=3 de JUG_OPERADOR_JUEGO
	 * 2) No existe registro en JUGADORES_OPERADOR para ese DNI 

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
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	@Test
	public void testVerificarJugador5_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X6246189X");
		jugador.setNombre("Driss");
		jugador.setApellido1("Garcia");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("23/01/1966"));
		jugador.setNumSoporte("E11343669");
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
		assertEquals("X6246189X", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	@Test
	public void testVerificarJugador5_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X6246189X");
		jugador.setNombre("Driss");
		jugador.setApellido1("Garcia");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("23/01/1966"));
		jugador.setNumSoporte("X11343669");
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
		assertEquals("X6246189X", resultado.getDni());
		assertEquals("COD905", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD905", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	@Test
	public void testVerificarJugador5_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X6246189X");
		jugador.setNombre("Driss");
		jugador.setApellido1("Garcia");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("23/01/1966"));
		jugador.setNumSoporte("E11343665");
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
		assertEquals("X6246189X", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	@Test
	public void testVerificarJugador5_4() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X6246189X");
		jugador.setNombre("Driss");
		jugador.setApellido1("Garcia");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("23/01/1966"));
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
		assertEquals("X6246189X", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	@Test
	public void testVerificarJugador6_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X0021895E");
		jugador.setNombre("Eduardo");
		jugador.setApellido1("Garcia");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("01/08/1923"));
		jugador.setNumSoporte("E00000012");
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
		assertEquals("X0021895E", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	@Test
	public void testVerificarJugador6_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X0021895E");
		jugador.setNombre("Eduardo");
		jugador.setApellido1("Garcia");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("01/08/1923"));
		jugador.setNumSoporte("E00012");
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
		assertEquals("X0021895E", resultado.getDni());
		assertEquals("COD905", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD905", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	@Test
	public void testVerificarJugador6_3() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X0021895E");
		jugador.setNombre("Eduardo");
		jugador.setApellido1("Garcia");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("01/08/1923"));
		jugador.setNumSoporte("E00000011");
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
		assertEquals("X0021895E", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	@Test
	public void testVerificarJugador6_4() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X0021895E");
		jugador.setNombre("Eduardo");
		jugador.setApellido1("Garcia");
		jugador.setApellido2("");
		jugador.setFechaNacimiento(dateFormat.parse("01/08/1923"));
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
		assertEquals("X0021895E", resultado.getDni());
		assertEquals("COD003", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD002", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	@Test
	public void testVerificarJugador7() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("X0000074M");
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
		assertEquals("X0000074M", resultado.getDni());
		assertEquals("COD906", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD906", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	@Test
	public void bajaJugador8() throws Exception {
		Baja baja=new Baja();
		baja.setDni("10000320N"); /// COD010
		baja.setCausa("A");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("10000320N", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_BAJA_OK, respuesta.getResultadoBaja().getCodigo());
		
	}
	
	@Test
	public void bajaJugador9() throws Exception {
		Baja baja=new Baja();
		baja.setDni("99999030K"); /// COD010
		baja.setCausa("R");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("99999030K", respuesta.getDni());
		assertEquals("COD021", respuesta.getResultadoBaja().getCodigo());
		
	}
	
	@Test
	public void bajaJugador10() throws Exception {
		Baja baja=new Baja();
		baja.setDni("10000320N"); /// COD010
		baja.setCausa("A");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("10000320N", respuesta.getDni());
		assertEquals("COD022", respuesta.getResultadoBaja().getCodigo());
		
	}
	
	@Test
	public void bajaJugador11() throws Exception {
		Baja baja=new Baja();
		baja.setDni("10000949C"); /// COD010
		baja.setCausa("Z");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("10000949C", respuesta.getDni());
		assertEquals("COD023", respuesta.getResultadoBaja().getCodigo());
		
	}
	
	@Test
	public void bajaJugador12() throws Exception {
		Baja baja=new Baja();
		baja.setDni("30000260B"); /// COD010
		baja.setCausa("A");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("30000260B", respuesta.getDni());
		assertEquals("COD901", respuesta.getResultadoBaja().getCodigo());
		
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
