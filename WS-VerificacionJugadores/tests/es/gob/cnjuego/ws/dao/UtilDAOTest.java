//package es.gob.cnjuego.ws.dao;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import java.util.Date;
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import es.gob.cnjuego.ws.entity.ConfiguracionEntity;
//import es.gob.cnjuego.ws.entity.TraduccionCaracteres;
//import es.gob.cnjuego.ws.verificacionjugadores.SpringTestCase;
//
//public class UtilDAOTest extends SpringTestCase {
//
//	private UtilDAO utilDAO;
//	
//	
//	@Before
//	public void setUp() throws Exception{
//		super.setUp();
//		utilDAO= (UtilDAO) getContext().getBean("utilDAO");
//	}
//	
//	
//	@After
//	public void tearDown() throws Exception {
//		super.tearDown();
//	}
//	
//	@Test
//	public void testInit() throws Exception {
//		assertNotNull(this.getUtilDAO());
//	}
//	
//	@Test
//	public void testCaracteresCache(){
//		List<TraduccionCaracteres> list= utilDAO.findAll(TraduccionCaracteres.class, "idTraduccion", true);
//		assertNotNull(list);
//		assertEquals(new Long(1), list.get(0).getIdTraduccion());
//		assertEquals('á', list.get(0).getOriginal());
//		assertEquals('a', list.get(0).getTraduccion());
//		assertEquals(37, list.size());
//		
//	}
//	
//	@Test
//	public void testConfiguracion(){
//		List<ConfiguracionEntity> list=utilDAO.findAll(ConfiguracionEntity.class, "idConfiguracion", true);
//		assertNotNull(list);
//		assertEquals(31, list.size());
//		for (ConfiguracionEntity configuracion : list) {
//			System.out.println(configuracion.getClave() + " :" + " " + configuracion.getValor());
//		}
//	}
//
//	public UtilDAO getUtilDAO() {
//		return utilDAO;
//	}
//
//	public void setUtilDAO(UtilDAO utilDAO) {
//		this.utilDAO = utilDAO;
//	}
//	
//}
