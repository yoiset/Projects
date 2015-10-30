package es.dgoj.rgiaj.business.repository.test;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import es.dgoj.rgiaj.business.model.Carta;
import es.dgoj.rgiaj.business.repository.CartaRepository;

/**
 * Esta clase implementa las pruebas unitarias del repositorio. 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/integration-core-config.xml",
		"classpath:/spring/app-custom-persistence-hibernate.xml", 
		"classpath:/spring/app-test-persistence-hibernate.xml",
		"classpath:/spring/app-custom-reporting.xml"})
public class CartaRepositoryTest {

	@Autowired 
	private CartaRepository<Carta, Long> repository;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetCartaById() {
		Carta tipo = this.repository.getCartaById(Long.valueOf(3));
		assertNotNull(tipo);
	}
	
}