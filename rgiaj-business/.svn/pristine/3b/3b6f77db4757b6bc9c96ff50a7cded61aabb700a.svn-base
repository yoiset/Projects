package es.dgoj.rgiaj.business.service.test;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dgoj.core.common.bean.UserBean;

import es.dgoj.rgiaj.business.beans.CausaProhibicionBean;
import es.dgoj.rgiaj.business.beans.CausaProhibicionQueryBean;
import es.dgoj.rgiaj.business.beans.CausaProhibicionSearchResult;
import es.dgoj.rgiaj.business.service.CausaProhibicionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/integration-core-config.xml",
		"classpath:/spring/app-custom-persistence-hibernate.xml", 
		"classpath:/spring/app-test-persistence-hibernate.xml",
		"classpath:/spring/app-custom-reporting.xml"})
public class CausaProhibicionServiceTest {

	@Resource
	private CausaProhibicionService causaProhibicionService;

	@Test
	@Transactional
	public void pruebaCompletaCausaProhibicionTest() {
		
		// Carga de datos
		CausaProhibicionBean causaProhibicionBean = new CausaProhibicionBean();
		causaProhibicionBean.setId((long) 111);
		causaProhibicionBean.setCodigo("codigo");
		causaProhibicionBean.setDescripcion("descripcion");
		causaProhibicionBean.setActivo(true);

		UserBean userBean = new UserBean();
		userBean.setUsername("dgonzalezconnectis");
		userBean.setAppcode("RGIAJ_TEST");
		causaProhibicionService.altaCausaProhibicion(causaProhibicionBean, userBean);
		
		CausaProhibicionQueryBean causaProhibicionQueryBean = new CausaProhibicionQueryBean();
		causaProhibicionQueryBean.setId((long) 111);
		causaProhibicionQueryBean.setFirstResult(0);
		causaProhibicionQueryBean.setMaxResults(10);
		CausaProhibicionSearchResult causaProhibicionResultado = causaProhibicionService.getCausasProhibicion(causaProhibicionQueryBean);
		
		assertEquals(new Long(1), causaProhibicionResultado.getNumResults());
		assertEquals("codigo", causaProhibicionResultado.getResults().get(0).getCodigo());
		
		causaProhibicionBean.setId((long) 111);
		causaProhibicionBean.setCodigo("codigo2");
		causaProhibicionBean.setDescripcion("descripcion");
		causaProhibicionBean.setActivo(true);
		
		causaProhibicionBean = causaProhibicionService.editarCausaProhibicion(causaProhibicionBean, userBean);
		
		assertEquals("codigo2", causaProhibicionBean.getCodigo());
		
	}
	
	
}
