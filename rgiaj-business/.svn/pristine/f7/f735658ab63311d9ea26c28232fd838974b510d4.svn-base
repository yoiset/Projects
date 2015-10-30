package es.dgoj.rgiaj.business.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class SpringTestCase {

	private ApplicationContext context;

	/**
	 * Este m�todo se invoca antes de la ejecuci�n de cada test.
	 * Carga el contexto de Spring para que est� disponible en los test cases 
	 */
	@Before
	public void setUp() throws Exception {
		ApplicationContext contextoSpring = new ClassPathXmlApplicationContext(
				new String[] { 
						"/spring/app-custom-business-beans.xml",
						"/spring/app-custom-persistence-hibernate.xml",
						"/spring/app-test-persistence-hibernate.xml", 
						"/spring/integration-core-config.xml" });
		this.setContext(contextoSpring);
	}

	@After
	public void tearDown() throws Exception {
	}

	protected ApplicationContext getContext() {
		return context;
	}

	protected void setContext(ApplicationContext context) {
		this.context = context;
	}

}
