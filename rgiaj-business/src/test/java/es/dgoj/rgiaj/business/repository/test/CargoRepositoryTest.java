package es.dgoj.rgiaj.business.repository.test;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import es.dgoj.rgiaj.business.model.Cargo;
import es.dgoj.rgiaj.business.repository.CargoRepository;

/**
 * Esta clase implementa las pruebas unitarias del repositorio. 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/integration-core-config.xml",
		"classpath:/spring/app-custom-persistence-hibernate.xml", 
		"classpath:/spring/app-test-persistence-hibernate.xml",
		"classpath:/spring/app-custom-reporting.xml"})
public class CargoRepositoryTest {

	@Autowired 
	private CargoRepository<Cargo, Long> repository;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetCargoById() {
		Cargo tipo = this.repository.getCargoById(Long.valueOf(3));
		assertNotNull(tipo);
	}
	
}