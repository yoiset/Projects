package es.gob.cnjuego.ws.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.gob.cnjuego.ws.entity.IJugadoresCambioRGIAJ;
import es.gob.cnjuego.ws.verificacionjugadores.SpringTestCase;

public class VerificacionDaoTest extends SpringTestCase {
	
	private VerificacionDao dao; 
	
	@Before
	public void setUp() throws Exception{
		super.setUp();
		dao=  (VerificacionDao)getContext().getBean("VerificacionDao");
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
	public void testCambiosJugadores(){
		
		List<IJugadoresCambioRGIAJ> respuesta=  dao.getCambiosJugadores(8);
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
		for (IJugadoresCambioRGIAJ item : respuesta) {
			String tag=(i<decimal)? zeros+i+"- " : i+"- ";
			System.out.print(tag);
			System.out.print(item.getId().getDni());
			System.out.print("             ");			
			System.out.print(item.getEvento());
			System.out.print("             ");
			System.out.println(item.getFechaValor());
			i++;
		}
		
		
		
	}


	public VerificacionDao getDao() {
		return dao;
	}


	public void setDao(VerificacionDao dao) {
		this.dao = dao;
	}
}
