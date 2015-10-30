package es.dgoj.rgiaj.business.service.test;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dgoj.core.common.bean.UserBean;

import es.dgoj.rgiaj.business.beans.CargoBean;
import es.dgoj.rgiaj.business.beans.CargoQueryBean;
import es.dgoj.rgiaj.business.beans.CargoSearchResult;
import es.dgoj.rgiaj.business.service.CargoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/integration-core-config.xml",
		"classpath:/spring/app-custom-persistence-hibernate.xml", 
		"classpath:/spring/app-custom-reporting.xml",
		"classpath:/spring/app-test-persistence-hibernate.xml"})
public class CargoServiceTest {

	@Resource
	private CargoService cargoService;

	@Test
	@Transactional
	public void pruebaCompletaCargoTest() {
		
		// Carga de datos
		CargoBean cargoBean = new CargoBean();
		cargoBean.setId((long) 111);
		cargoBean.setCodigo("codigo");
		cargoBean.setDescripcion("descripcion");
		cargoBean.setActivo(true);

		UserBean userBean = new UserBean();
		userBean.setUsername("dgonzalezconnectis");
		userBean.setAppcode("RGIAJ_TEST");
		cargoService.altaCargo(cargoBean, userBean);
		
		CargoQueryBean cargoQueryBean = new CargoQueryBean();
		cargoQueryBean.setId((long) 111);
		cargoQueryBean.setFirstResult(0);
		cargoQueryBean.setMaxResults(10);
		CargoSearchResult cargoResultado = cargoService.getCargos(cargoQueryBean);
		
		assertEquals(new Long(1), cargoResultado.getNumResults());
		assertEquals("codigo", cargoResultado.getResults().get(0).getCodigo());
		
		cargoBean.setId((long) 111);
		cargoBean.setCodigo("codigo2");
		cargoBean.setDescripcion("descripcion");
		cargoBean.setActivo(true);
		
		cargoBean = cargoService.editarCargo(cargoBean, userBean);
		
		assertEquals("codigo2", cargoBean.getCodigo());
		
	}
	
	
}
