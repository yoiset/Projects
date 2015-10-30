package es.gob.cnjuego.ws.verificacionjugadores;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class SpringTestCase {

	private ApplicationContext context;

	/**
	 * Este método se invoca antes de la ejecución de cada test.
	 * Carga el contexto de Spring para que esté disponible en los test cases 
	 */
	@Before
	public void setUp() throws Exception {
		ApplicationContext contextoSpring = new ClassPathXmlApplicationContext(
				new String[] { 
						"/applicationContext_jpa.xml", 
						"/tests/applicationContext_datasource_JUnit.xml",
						"/tests/applicationContext_ws_JUnit.xml" });
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
