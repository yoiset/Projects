package es.dgoj.rgiaj.business.service.test;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dgoj.core.common.bean.UserBean;

import es.dgoj.rgiaj.business.beans.TipoDocIdentidadBean;
import es.dgoj.rgiaj.business.beans.TipoDocIdentidadQueryBean;
import es.dgoj.rgiaj.business.beans.TipoDocIdentidadSearchResult;
import es.dgoj.rgiaj.business.service.TipoDocIdentidadService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/integration-core-config.xml",
		"classpath:/spring/app-custom-persistence-hibernate.xml", 
		"classpath:/spring/app-test-persistence-hibernate.xml",
		"classpath:/spring/app-custom-reporting.xml"})
public class TipoDocIdentidadServiceTest {

	@Resource
	private TipoDocIdentidadService tipoDocIdentidadService;

	@Test
	@Transactional
	public void pruebaCompletaTipoDocIdentidadTest() {
		
		// Carga de datos
		TipoDocIdentidadBean tipoDocIdentidadBean = new TipoDocIdentidadBean();
		tipoDocIdentidadBean.setId((long) 111);
		tipoDocIdentidadBean.setCodigo("codigo");
		tipoDocIdentidadBean.setDescripcion("descripcion");
		tipoDocIdentidadBean.setActivo(true);

		UserBean userBean = new UserBean();
		userBean.setUsername("dgonzalezconnectis");
		userBean.setAppcode("RGIAJ_TEST");
		tipoDocIdentidadService.altaTipoDocIdentidad(tipoDocIdentidadBean, userBean);
		
		TipoDocIdentidadQueryBean tipoDocIdentidadQueryBean = new TipoDocIdentidadQueryBean();
		tipoDocIdentidadQueryBean.setId((long) 111);
		tipoDocIdentidadQueryBean.setFirstResult(0);
		tipoDocIdentidadQueryBean.setMaxResults(10);
		TipoDocIdentidadSearchResult tipoDocIdentidadResultado = tipoDocIdentidadService.getTiposDocIdentidad(tipoDocIdentidadQueryBean);
		
		assertEquals(new Long(1), tipoDocIdentidadResultado.getNumResults());
		assertEquals("codigo", tipoDocIdentidadResultado.getResults().get(0).getCodigo());
		
		tipoDocIdentidadBean.setId((long) 111);
		tipoDocIdentidadBean.setCodigo("codigo2");
		tipoDocIdentidadBean.setDescripcion("descripcion");
		tipoDocIdentidadBean.setActivo(true);
		
		tipoDocIdentidadBean = tipoDocIdentidadService.editarTipoDocIdentidad(tipoDocIdentidadBean, userBean);
		
		assertEquals("codigo2", tipoDocIdentidadBean.getCodigo());
		
	}
	
	
}
