package es.gob.cnjuego.ws.verificacionjugadores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.gob.cnjuego.ws.dao.VerificacionDao;

public class VerificacionCambiosRGIAJ extends SpringTestCase{



	
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
	/*                          CASOS PRUEBA OPERACION verificarIdentidad                                                           */
	/******************************************************************************************************************************/
	
	
	@Test
	public void testVerificarCambios1_1() throws Exception {
		List<CambioRGIAJ> respuesta = this.getProxy().verificarCambiosRGIAJ();
		assertNotNull(respuesta);
		System.out.println("Cambios RGIAJ del Operador 8: ");
		System.out.println("Jugador: DNI             Motivo             Fecha");
		int i=1;
		int size=String.valueOf(respuesta.size()).length();
		String zeros="";
		int decimal=0;
		if(size>1 && respuesta.size()>1){
			for (int j = 1; j < size; j++) 
				zeros+="0";			
			decimal=Integer.parseInt("1"+zeros );
		}
		for (CambioRGIAJ item : respuesta) {
			String tag=(i<decimal)? zeros+i+"- " : i+"- ";
			System.out.print(tag);
			System.out.print(item.getDNI());
			System.out.print("             ");			
			System.out.print(item.getMotivoCambio());
			System.out.print("             ");
			System.out.println(item.getFechaCambio());
			i++;
		}
		
	}
	
	
	@Test
	public void testVerificarJugador01_1() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Jugador jugador = new Jugador();
		jugador.setDni("60111111J");
		jugador.setNombre("OLGA");
		jugador.setApellido1("SAN MIGUEL");
		jugador.setApellido2("CHAO");
		jugador.setFechaNacimiento(dateFormat.parse("02/06/1940"));
		
		
		Jugador jugador2 = new Jugador();
		jugador2.setDni("31313131B");
		jugador2.setNombre("OLGA");
		jugador2.setApellido1("SAN MIGUEL");
		jugador2.setApellido2("CHAO");
		jugador2.setFechaNacimiento(dateFormat.parse("02/06/1940"));
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		jugadores.add(jugador2);
		
		List<ResultadoJugador> respuesta = this.getProxy().verificarJugador(jugadores);
		
		ResultadoJugador resultado = respuesta.get(0);
		assertEquals("60111111J", resultado.getDni());
		assertEquals("COD004", resultado.getResultadoIdentidad().getCodigo());
		assertEquals("COD001", resultado.getResultadoRGIAJ().getCodigo());
	}
	
	
	
	
	@Test
	public void bajaJugador1_1() throws Exception {
		Baja baja=new Baja();
		baja.setDni("60111111J"); /// COD010
		baja.setCausa("A");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("60111111J", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_BAJA_OK, respuesta.getResultadoBaja().getCodigo());
		
	}
	
	
	@Test
	public void bajaJugador1_2() throws Exception {
		Baja baja=new Baja();
		baja.setDni("31313131B"); /// COD010
		baja.setCausa("R");		

		ResultadoBajaJugador respuesta = this.getProxy().bajaJugador(baja);
		assertNotNull(respuesta);

		assertEquals("31313131B", respuesta.getDni());
		assertEquals(CodigosVerificacion.COD_BAJA_OK, respuesta.getResultadoBaja().getCodigo());
		
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
