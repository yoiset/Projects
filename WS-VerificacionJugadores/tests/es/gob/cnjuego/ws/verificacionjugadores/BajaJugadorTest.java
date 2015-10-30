package es.gob.cnjuego.ws.verificacionjugadores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import es.gob.cnjuego.ws.dao.VerificacionDao;

public class BajaJugadorTest extends SpringTestCase{

	
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
	
	
	@Test
	public void bajaJugador() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Baja baja=new Baja();
		baja.setDni("Y0336380L"); /// COD010
		baja.setCausa("A");
		
		// Obtenemos la cantidad de peticiones antes de hacer
		// la invocación del servicio
		long cantidadAntes = this.getDao().getCantidadPeticiones();
		
		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);
		long cantidadDespues = this.getDao().getCantidadPeticiones();
		
		// Comprobamos que el interceptor de CXF guardó la petición en la BD
		// y los datos de la respuesta
		assertEquals(cantidadAntes + 1, cantidadDespues);
		assertEquals("Y0336380L", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_BAJA_DNI_BAJA, respuesta.getResultadoBaja().getCodigo());
		
//		assertEquals("COD010", respuesta.getDescripcion());
	}
	
	
	/** Salida esperada
	 * IND_RGIAJ=5
       IND_IDENTIDAD=0
       RES_IDENTIDAD=null
       RES_RGIAJ='COD0010'
       CACHE_IDENTIDAD=0 
	 * @throws Exception
	 */
	@Test
	public void bajaJugador1_1() throws Exception {
		Baja baja=new Baja();
		baja.setDni("Y9999999G"); /// COD010
		baja.setCausa("A");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("Y9999999G", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_BAJA_OK, respuesta.getResultadoBaja().getCodigo());
		
	}
	
	/** Salida esperada
	 * IND_RGIAJ=6
       IND_IDENTIDAD=0
       RES_IDENTIDAD=null
       RES_RGIAJ='COD0010'
       CACHE_IDENTIDAD=0 
	 * @throws Exception
	 */
	@Test
	public void bajaJugador1_2() throws Exception {
		Baja baja=new Baja();
		baja.setDni("Y0336380L"); /// COD010
		baja.setCausa("R");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("Y0336380L", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_BAJA_OK, respuesta.getResultadoBaja().getCodigo());
		
	}
	
	
	/** Salida esperada
	 * IND_RGIAJ=5
       IND_IDENTIDAD=0
       RES_IDENTIDAD=null
       RES_RGIAJ='COD021'
       CACHE_IDENTIDAD=0 
	 * @throws Exception
	 */
	@Test
	public void bajaJugador2_1() throws Exception {
		Baja baja=new Baja();
		baja.setDni("12312312K"); /// COD010
		baja.setCausa("A");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("12312312K", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_BAJA_DNI_NO_ACTIVADO, respuesta.getResultadoBaja().getCodigo());
//		assertEquals(CodigosVerificacion.COD_FORMATO_INCORRECTO, respuesta.getResultadoBaja().getCodigo());
		
	}
	
	
	/** Salida esperada
	 * IND_RGIAJ=6
       IND_IDENTIDAD=0
       RES_IDENTIDAD=null
       RES_RGIAJ='COD021'
       CACHE_IDENTIDAD=0 
	 * @throws Exception
	 */
	@Test
	public void bajaJugador2_2() throws Exception {
		Baja baja=new Baja();
		baja.setDni("99988877B"); /// COD010
		baja.setCausa("R");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("99988877B", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_BAJA_DNI_NO_ACTIVADO, respuesta.getResultadoBaja().getCodigo());
//		assertEquals(CodigosVerificacion.COD_FORMATO_INCORRECTO, respuesta.getResultadoBaja().getCodigo());
		
	}
	
	
	/** Salida esperada
	 * IND_RGIAJ=5
       IND_IDENTIDAD=0
       RES_IDENTIDAD=null
       RES_RGIAJ='COD022'
       CACHE_IDENTIDAD=0 
	 * @throws Exception
	 */
	@Test
	public void bajaJugador3_1() throws Exception {
		Baja baja=new Baja();
		baja.setDni("Y9999999G"); /// COD010
		baja.setCausa("A");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("Y9999999G", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_BAJA_DNI_BAJA, respuesta.getResultadoBaja().getCodigo());
		
	}
	
	
	/** Salida esperada
	 * IND_RGIAJ=5
       IND_IDENTIDAD=0
       RES_IDENTIDAD=null
       RES_RGIAJ='COD023'
       CACHE_IDENTIDAD=0 
	 * @throws Exception
	 */
	@Test
	public void bajaJugador4() throws Exception {
		Baja baja=new Baja();
		baja.setDni("Y9999999G"); /// COD010
		baja.setCausa("Z");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("Y9999999G", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_BAJA_CAUSA, respuesta.getResultadoBaja().getCodigo());
		
	}
	
	
	/** Salida esperada
	 * IND_RGIAJ=6
       IND_IDENTIDAD=0
       RES_IDENTIDAD=null
       RES_RGIAJ='COD901'
       CACHE_IDENTIDAD=0 
	 * @throws Exception
	 */
	@Test
	public void bajaJugador5_1() throws Exception {
		Baja baja=new Baja();
		baja.setDni("00000002R"); /// COD010
		baja.setCausa("R");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("00000002R", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_FORMATO_INCORRECTO, respuesta.getResultadoBaja().getCodigo());
		
	}
	
	
	/** Salida esperada
	 * IND_RGIAJ=5
       IND_IDENTIDAD=0
       RES_IDENTIDAD=null
       RES_RGIAJ='COD901'
       CACHE_IDENTIDAD=0 
	 * @throws Exception
	 */
	@Test
	public void bajaJugador5_2() throws Exception {
		Baja baja=new Baja();
		baja.setDni("000000002W"); /// COD010
		baja.setCausa("A");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("000000002W", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_FORMATO_INCORRECTO, respuesta.getResultadoBaja().getCodigo());
		
	}
	
	/** Salida esperada
	 * IND_RGIAJ=5
       IND_IDENTIDAD=0
       RES_IDENTIDAD=null
       RES_RGIAJ='COD901'
       CACHE_IDENTIDAD=0 
	 * @throws Exception
	 */
	@Test
	public void bajaJugador5_3() throws Exception {
		Baja baja=new Baja();
		baja.setDni("X273388X"); /// COD010
		baja.setCausa("A");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("X273388X", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_FORMATO_INCORRECTO, respuesta.getResultadoBaja().getCodigo());
		
	}
	
	
	/** Salida esperada
	 * IND_RGIAJ=6
       IND_IDENTIDAD=0
       RES_IDENTIDAD=null
       RES_RGIAJ='COD0010'
       CACHE_IDENTIDAD=0 
	 * @throws Exception
	 */
	@Test
	public void bajaJugador5_4() throws Exception {
		Baja baja=new Baja();
		baja.setDni("1444441H"); /// COD010
		baja.setCausa("R");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("1444441H", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_BAJA_OK, respuesta.getResultadoBaja().getCodigo());
		
	}
	
	/** Salida esperada
	 * IND_RGIAJ=5
       IND_IDENTIDAD=0
       RES_IDENTIDAD=null
       RES_RGIAJ='COD903'
       CACHE_IDENTIDAD=0 
	 * @throws Exception
	 */
	@Test
	public void bajaJugador6_1() throws Exception {
		Baja baja=new Baja();
		baja.setDni(""); /// COD010
		baja.setCausa("A");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_FALTA_CAMPO, respuesta.getResultadoBaja().getCodigo());
		
	}
	
	/** Salida esperada
	 * IND_RGIAJ=5
       IND_IDENTIDAD=0
       RES_IDENTIDAD=null
       RES_RGIAJ='COD023'
       CACHE_IDENTIDAD=0 
	 * @throws Exception
	 */
	@Test
	public void bajaJugador6_2() throws Exception {
		Baja baja=new Baja();
		baja.setDni("Y9999999G"); /// COD010
		baja.setCausa("");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("Y9999999G", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_BAJA_CAUSA, respuesta.getResultadoBaja().getCodigo());
		
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
