package es.dgoj.rgiaj.business.service.test;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dgoj.core.common.bean.UserBean;

import es.dgoj.rgiaj.business.beans.SituacionBean;
import es.dgoj.rgiaj.business.beans.SituacionQueryBean;
import es.dgoj.rgiaj.business.beans.SituacionSearchResult;
import es.dgoj.rgiaj.business.service.SituacionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/integration-core-config.xml",
		"classpath:/spring/app-custom-persistence-hibernate.xml", 
		"classpath:/spring/app-test-persistence-hibernate.xml",
		"classpath:/spring/app-custom-reporting.xml"})
public class SituacionServiceTest {

	@Resource
	private SituacionService situacionService;

	@Test
	@Transactional
	public void pruebaCompletaSituacionTest() {
		
		// Carga de datos
		SituacionBean situacionBean = new SituacionBean();
		situacionBean.setId((long) 111);
		situacionBean.setCodigo("codigo");
		situacionBean.setDescripcion("descripcion");
		situacionBean.setActivo(true);

		UserBean userBean = new UserBean();
		userBean.setUsername("dgonzalezconnectis");
		userBean.setAppcode("RGIAJ_TEST");
		situacionService.altaSituacion(situacionBean, userBean);
		
		SituacionQueryBean situacionQueryBean = new SituacionQueryBean();
		situacionQueryBean.setId((long) 111);
		situacionQueryBean.setFirstResult(0);
		situacionQueryBean.setMaxResults(10);
		SituacionSearchResult situacionResultado = situacionService.getSituaciones(situacionQueryBean);
		
		assertEquals(new Long(1), situacionResultado.getNumResults());
		assertEquals("codigo", situacionResultado.getResults().get(0).getCodigo());
		
		situacionBean.setId((long) 111);
		situacionBean.setCodigo("codigo2");
		situacionBean.setDescripcion("descripcion");
		situacionBean.setActivo(true);
		
		situacionBean = situacionService.editarSituacion(situacionBean, userBean);
		
		assertEquals("codigo2", situacionBean.getCodigo());
		
	}
	
	
}
