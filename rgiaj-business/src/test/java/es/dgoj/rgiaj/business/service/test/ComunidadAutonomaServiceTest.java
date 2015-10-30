package es.dgoj.rgiaj.business.service.test;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dgoj.core.common.bean.UserBean;

import es.dgoj.rgiaj.business.beans.ComunidadAutonomaBean;
import es.dgoj.rgiaj.business.beans.ComunidadAutonomaQueryBean;
import es.dgoj.rgiaj.business.beans.ComunidadAutonomaSearchResult;
import es.dgoj.rgiaj.business.service.ComunidadAutonomaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/integration-core-config.xml",
		"classpath:/spring/app-custom-persistence-hibernate.xml", 
		"classpath:/spring/app-test-persistence-hibernate.xml",
		"classpath:/spring/app-custom-reporting.xml"})
public class ComunidadAutonomaServiceTest {

	@Resource
	private ComunidadAutonomaService comunidadAutonomaService;

	@Test
	@Transactional
	public void pruebaCompletaComunidadAutonomaTest() {
		
		// Carga de datos
		ComunidadAutonomaBean comunidadAutonomaBean = new ComunidadAutonomaBean();
		comunidadAutonomaBean.setId((long) 111);
		comunidadAutonomaBean.setCodigo("codigo");
		comunidadAutonomaBean.setDescripcion("descripcion");
		comunidadAutonomaBean.setActivo(true);

		UserBean userBean = new UserBean();
		userBean.setUsername("dgonzalezconnectis");
		userBean.setAppcode("RGIAJ_TEST");
		comunidadAutonomaService.altaComunidadAutonoma(comunidadAutonomaBean, userBean);
		
		ComunidadAutonomaQueryBean comunidadAutonomaQueryBean = new ComunidadAutonomaQueryBean();
		comunidadAutonomaQueryBean.setId((long) 111);
		comunidadAutonomaQueryBean.setFirstResult(0);
		comunidadAutonomaQueryBean.setMaxResults(10);
		ComunidadAutonomaSearchResult comunidadAutonomaResultado = comunidadAutonomaService.getComunidadesAutonomas(comunidadAutonomaQueryBean);
		
		assertEquals(new Long(1), comunidadAutonomaResultado.getNumResults());
		assertEquals("codigo", comunidadAutonomaResultado.getResults().get(0).getCodigo());
		
		comunidadAutonomaBean.setId((long) 111);
		comunidadAutonomaBean.setCodigo("codigo2");
		comunidadAutonomaBean.setDescripcion("descripcion");
		comunidadAutonomaBean.setActivo(true);
		
		comunidadAutonomaBean = comunidadAutonomaService.editarComunidadAutonoma(comunidadAutonomaBean, userBean);
		
		assertEquals("codigo2", comunidadAutonomaBean.getCodigo());
		
	}
	
	
}
