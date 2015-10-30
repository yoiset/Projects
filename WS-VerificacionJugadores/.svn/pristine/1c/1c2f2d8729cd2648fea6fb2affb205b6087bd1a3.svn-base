package es.gob.cnjuego.ws.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.gob.cnjuego.ws.entity.JugadorTestWS;
import es.gob.cnjuego.ws.verificacionjugadores.SpringTestCase;

public class JugadoresTestDAOTest extends SpringTestCase {

	private JugadoresTestDAO dao;
	
	
	@Before
	public void setUp() throws Exception{
		super.setUp();
		dao= (JugadoresTestDAO) getContext().getBean("jugadoresTestDAO");
	}
	
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testInit() throws Exception {
		assertNotNull(this.getDao());
	}
	
	@Test
	public void testObtenerResultadoIdentidadTestWS(){
		JugadorTestWS jugador=new JugadorTestWS();
		jugador.setDni("00000000T");
//		jugador.setNombre("Maria");
//		jugador.setApellido1("Gonzalez");
//		jugador.setApellido2("Lopez");
//		jugador.setFechaNacimiento(new GregorianCalendar(1960, 04, 10).getTime());
//		jugador.setResultadoRGIAJ("COD002");
//		jugador.setResultadoIdentidad("COD004");
		
		jugador=dao.obtenerJugadorPrueba(jugador.getDni());
		
		assertNotNull(jugador);
		assertEquals("00000000T", jugador.getDni());
		assertEquals("Maria", jugador.getNombre());
		assertEquals("Gonzalez", jugador.getApellido1());
		assertEquals("Lopez", jugador.getApellido2());
		SimpleDateFormat simple= new SimpleDateFormat("YYYY/MM/dd");
		String date= simple.format(jugador.getFechaNacimiento());
		
		assertEquals(simple.format(new GregorianCalendar(1960,03,10).getTime()), date);
		assertEquals("COD002", jugador.getResultadoRGIAJ());
	}
	
	
	
	public JugadoresTestDAO getDao() {
		return dao;
	}


	public void setDao(JugadoresTestDAO dao) {
		this.dao = dao;
	}
}
