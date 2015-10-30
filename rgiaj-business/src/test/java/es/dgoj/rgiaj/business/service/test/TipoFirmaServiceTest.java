package es.dgoj.rgiaj.business.service.test;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dgoj.core.common.bean.UserBean;

import es.dgoj.rgiaj.business.beans.TipoFirmaBean;
import es.dgoj.rgiaj.business.beans.TipoFirmaQueryBean;
import es.dgoj.rgiaj.business.beans.TipoFirmaSearchResult;
import es.dgoj.rgiaj.business.service.TipoFirmaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/integration-core-config.xml",
		"classpath:/spring/app-custom-persistence-hibernate.xml", 
		"classpath:/spring/app-test-persistence-hibernate.xml",
		"classpath:/spring/app-custom-reporting.xml"})
public class TipoFirmaServiceTest {

	@Resource
	private TipoFirmaService tipoFirmaService;

	@Test
	@Transactional
	public void pruebaCompletaTipoFirmaTest() {
		
		// Carga de datos
		TipoFirmaBean tipoFirmaBean = new TipoFirmaBean();
		tipoFirmaBean.setId((long) 111);
		tipoFirmaBean.setCodigo("codigo");
		tipoFirmaBean.setDescripcion("descripcion");
		tipoFirmaBean.setActivo(true);

		UserBean userBean = new UserBean();
		userBean.setUsername("dgonzalezconnectis");
		userBean.setAppcode("RGIAJ_TEST");
		tipoFirmaService.altaTipoFirma(tipoFirmaBean, userBean);
		
		TipoFirmaQueryBean tipoFirmaQueryBean = new TipoFirmaQueryBean();
		tipoFirmaQueryBean.setId((long) 111);
		tipoFirmaQueryBean.setFirstResult(0);
		tipoFirmaQueryBean.setMaxResults(10);
		TipoFirmaSearchResult tipoFirmaResultado = tipoFirmaService.getTiposFirma(tipoFirmaQueryBean);
		
		assertEquals(new Long(1), tipoFirmaResultado.getNumResults());
		assertEquals("codigo", tipoFirmaResultado.getResults().get(0).getCodigo());
		
		tipoFirmaBean.setId((long) 111);
		tipoFirmaBean.setCodigo("codigo2");
		tipoFirmaBean.setDescripcion("descripcion");
		tipoFirmaBean.setActivo(true);
		
		tipoFirmaBean = tipoFirmaService.editarTipoFirma(tipoFirmaBean, userBean);
		
		assertEquals("codigo2", tipoFirmaBean.getCodigo());
		
	}
	
	
}
