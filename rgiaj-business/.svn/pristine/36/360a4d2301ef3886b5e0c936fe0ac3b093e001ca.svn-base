package es.dgoj.rgiaj.business.service.test;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dgoj.core.common.bean.UserBean;

import es.dgoj.rgiaj.business.beans.TipoProhibicionBean;
import es.dgoj.rgiaj.business.beans.TipoProhibicionQueryBean;
import es.dgoj.rgiaj.business.beans.TipoProhibicionSearchResult;
import es.dgoj.rgiaj.business.service.TipoProhibicionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/integration-core-config.xml",
		"classpath:/spring/app-custom-persistence-hibernate.xml", 
		"classpath:/spring/app-test-persistence-hibernate.xml",
		"classpath:/spring/app-custom-reporting.xml"})
public class TipoProhibicionServiceTest {

	@Resource
	private TipoProhibicionService tipoProhibicionService;

	@Test
	@Transactional
	public void pruebaCompletaTipoProhibicionTest() {
		
		// Carga de datos
		TipoProhibicionBean tipoProhibicionBean = new TipoProhibicionBean();
		tipoProhibicionBean.setId((long) 111);
		tipoProhibicionBean.setCodigo("codigo");
		tipoProhibicionBean.setDescripcion("descripcion");
		tipoProhibicionBean.setActivo(true);

		UserBean userBean = new UserBean();
		userBean.setUsername("dgonzalezconnectis");
		userBean.setAppcode("RGIAJ_TEST");
		tipoProhibicionService.altaTipoProhibicion(tipoProhibicionBean, userBean);
		
		TipoProhibicionQueryBean tipoProhibicionQueryBean = new TipoProhibicionQueryBean();
		tipoProhibicionQueryBean.setId((long) 111);
		tipoProhibicionQueryBean.setFirstResult(0);
		tipoProhibicionQueryBean.setMaxResults(10);
		TipoProhibicionSearchResult tipoProhibicionResultado = tipoProhibicionService.getTiposProhibicion(tipoProhibicionQueryBean);
		
		assertEquals(new Long(1), tipoProhibicionResultado.getNumResults());
		assertEquals("codigo", tipoProhibicionResultado.getResults().get(0).getCodigo());
		
		tipoProhibicionBean.setId((long) 111);
		tipoProhibicionBean.setCodigo("codigo2");
		tipoProhibicionBean.setDescripcion("descripcion");
		tipoProhibicionBean.setActivo(true);
		
		tipoProhibicionBean = tipoProhibicionService.editarTipoProhibicion(tipoProhibicionBean, userBean);
		
		assertEquals("codigo2", tipoProhibicionBean.getCodigo());
		
	}
	
	
}
