package es.gob.cnjuego.ws.verificacionjugadores;

import org.junit.runner.RunWith;  
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;  

@RunWith(Suite.class)
@SuiteClasses({ 
	ClienteSCSPServiceTestCase.class,
	VerificacionDaoTestCase.class,
	VerificacionJugadoresImplTestCase.class})
public class AllTests {

}
