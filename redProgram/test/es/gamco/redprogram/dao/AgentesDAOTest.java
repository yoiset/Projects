package es.gamco.redprogram.dao;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import es.gamco.redprogram.entity.Agente;

@ContextConfiguration("classpath:applicationContext.xml")
public class AgentesDAOTest extends AbstractTransactionalJUnit4SpringContextTests {


	@Autowired
	private ResAgenteDAO resAgenteDAO;
	
	@Test
	public void testAllAgentes(){
	  List<Agente>	list=  resAgenteDAO.getAllAgentes();
	  assertNotNull(list);
	  
//	  Tambien se puede usar el assertEquals para comprar valores esperados
	//  assertEquals(expected, actual)
	  
		
	}
	
	
}