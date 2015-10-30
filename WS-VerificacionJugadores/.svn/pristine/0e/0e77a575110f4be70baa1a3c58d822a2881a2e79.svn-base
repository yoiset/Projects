package es.gob.cnjuego.ws.verificacionjugadores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class ClienteJuegoDniServiceTestCase extends SpringTestCase {

	private ClienteJuegoDniService clienteServicio;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		ClienteJuegoDniService proxyBean = (ClienteJuegoDniService)this.getContext().getBean("ClienteJuegoDniService");
		this.setClienteServicio(proxyBean);
	}

	/**
	 * Verificamos que la configuración de los ficheros es correcta.
	 */
	@Test
	public void testInit() throws Exception {
		assertNotNull(this.getClienteServicio());
	}

	/**
	 * Esta prueba comprueba que la invocación funciona correctamente.
	 * En este caso se verifica que al enviar una lista con un DNI incluido devuelve true.
	 */
	@Test
	public void testVerificarListaDni1() throws Exception {
		ArrayList<String> listaDni = new ArrayList<String>();
		listaDni.add("10000320N");
		ArrayList<ResultadoRGIAJ> respuesta = this.getClienteServicio().verificarJuegoDni(listaDni);
				
		// Comprobamos la respuesta
		assertNotNull(respuesta);
		
		assertEquals("10000320N", respuesta.get(0).getDni());
		assertEquals("COD001", respuesta.get(0).getResultadoRGIAJ().getCodigo());
	}

	/**
	 * Esta prueba comprueba que la invocación funciona correctamente.
	 * En este caso se verifica que al enviar una lista con dos DNIs incluidos devuelve true 
	 * en ambos.
	 */
	@Test
	public void testVerificarListaDni2() throws Exception {
		ArrayList<String> listaDni = new ArrayList<String>();
		listaDni.add("30000529L");
		listaDni.add("30000831E");
		ArrayList<ResultadoRGIAJ> respuesta = this.getClienteServicio().verificarJuegoDni(listaDni);
		
		
		// Comprobamos la respuesta
		assertNotNull(respuesta);
		
		assertEquals("30000529L", respuesta.get(0).getDni());
		assertEquals("COD001", respuesta.get(0).getResultadoRGIAJ().getCodigo());

		assertEquals("30000831E", respuesta.get(1).getDni());
		assertEquals("COD001", respuesta.get(1).getResultadoRGIAJ().getCodigo());

	}
	
	/**
	 * Esta prueba comprueba que la invocación funciona correctamente.
	 * En este caso se verifica que al enviar una lista con un DNI no incluido devuelve false.
	 */
	@Test
	public void testVerificarListaDni3() throws Exception {
		ArrayList<String> listaDni = new ArrayList<String>();
		listaDni.add("30000320N");
		ArrayList<ResultadoRGIAJ> respuesta = this.getClienteServicio().verificarJuegoDni(listaDni);
				
		// Comprobamos la respuesta
		assertNotNull(respuesta);
		
		assertEquals("30000320N", respuesta.get(0).getDni());
		assertEquals("COD002", respuesta.get(0).getResultadoRGIAJ().getCodigo());
	}

	/**
	 * Esta prueba comprueba que la invocación funciona correctamente.
	 * En este caso se verifica que al enviar una lista con dos DNIs no incluidos devuelve false 
	 * en ambos.
	 */
	@Test
	public void testVerificarListaDni4() throws Exception {
		ArrayList<String> listaDni = new ArrayList<String>();
		listaDni.add("10000529L");
		listaDni.add("10000831E");
		ArrayList<ResultadoRGIAJ> respuesta = this.getClienteServicio().verificarJuegoDni(listaDni);
		
		
		// Comprobamos la respuesta
		assertNotNull(respuesta);
		
		assertEquals("10000529L", respuesta.get(0).getDni());
		assertEquals("COD002", respuesta.get(0).getResultadoRGIAJ().getCodigo());

		assertEquals("10000831E", respuesta.get(1).getDni());
		assertEquals("COD002", respuesta.get(1).getResultadoRGIAJ().getCodigo());

	}	
	
	/**
	 * Esta prueba comprueba que la invocación funciona correctamente.
	 * En este caso se verifica que al enviar una lista con un DNI incluido 
	 * y otro no incluido devuelve true en el primero y false en el segundo.
	 */
	@Test
	public void testVerificarListaDni5() throws Exception {
		ArrayList<String> listaDni = new ArrayList<String>();
		listaDni.add("30000529L");
		listaDni.add("10000831E");
		ArrayList<ResultadoRGIAJ> respuesta = this.getClienteServicio().verificarJuegoDni(listaDni);
		
		
		// Comprobamos la respuesta
		assertNotNull(respuesta);
		
		assertEquals("30000529L", respuesta.get(0).getDni());
		assertEquals("COD001", respuesta.get(0).getResultadoRGIAJ().getCodigo());

		assertEquals("10000831E", respuesta.get(1).getDni());
		assertEquals("COD002", respuesta.get(1).getResultadoRGIAJ().getCodigo());
	}

	/**
	 * Esta prueba comprueba que la invocación funciona correctamente.
	 * En este caso se verifica que al enviar una lista con valor null
	 */
	@Test
	public void testVerificarListaDni6() throws Exception {
		ArrayList<String> listaDni = new ArrayList<String>();
		ArrayList<ResultadoRGIAJ> respuesta = this.getClienteServicio().verificarJuegoDni(listaDni);
		
		
		// Comprobamos la respuesta
		assertNotNull(respuesta);
	}

	public ClienteJuegoDniService getClienteServicio() {
		return clienteServicio;
	}

	public void setClienteServicio(ClienteJuegoDniService proxy) {
		this.clienteServicio = proxy;
	}

}