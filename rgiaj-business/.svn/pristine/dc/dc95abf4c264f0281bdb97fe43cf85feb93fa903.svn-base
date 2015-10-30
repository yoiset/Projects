package es.dgoj.rgiaj.business.service.test;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dgoj.core.common.bean.UserBean;

import es.dgoj.rgiaj.business.beans.CartaBean;
import es.dgoj.rgiaj.business.beans.CartaQueryBean;
import es.dgoj.rgiaj.business.beans.CartaSearchResult;
import es.dgoj.rgiaj.business.service.CartaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/integration-core-config.xml",
		"classpath:/spring/app-custom-persistence-hibernate.xml", 
		"classpath:/spring/app-test-persistence-hibernate.xml",
		"classpath:/spring/app-custom-reporting.xml"})
public class CartaServiceTest {

	@Resource
	private CartaService cartaService;

	@Test
	@Transactional
	public void pruebaCompletaCartaTest() {
		
		// Carga de datos
		CartaBean cartaBean = new CartaBean();
		cartaBean.setId((long) 111);
		cartaBean.setTexto("texto");
		cartaBean.setDescripcion("descripcion");
		cartaBean.setCargo((long) 112);

		UserBean userBean = new UserBean();
		userBean.setUsername("dgonzalezconnectis");
		userBean.setAppcode("RGIAJ_TEST");
		cartaService.altaCarta(cartaBean, userBean);
		
		CartaQueryBean cartaQueryBean = new CartaQueryBean();
		cartaQueryBean.setId((long) 111);
		cartaQueryBean.setFirstResult(0);
		cartaQueryBean.setMaxResults(10);
		CartaSearchResult cartaResultado = cartaService.getCartas(cartaQueryBean);
		
		assertEquals(new Long(1), cartaResultado.getNumResults());
		assertEquals("texto", cartaResultado.getResults().get(0).getTexto());
		
		cartaBean.setId((long) 111);
		cartaBean.setTexto("texto2");
		cartaBean.setDescripcion("descripcion");
		cartaBean.setCargo((long) 112);
		
		cartaBean = cartaService.editarCarta(cartaBean, userBean);
		
		assertEquals("texto2", cartaBean.getTexto());
		
	}
	
	
}
