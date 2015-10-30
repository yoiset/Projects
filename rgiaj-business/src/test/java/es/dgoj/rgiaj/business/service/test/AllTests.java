/**
 * 
 */
package es.dgoj.rgiaj.business.service.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author connectis
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ 
	CartaServiceTest.class,
	CargoServiceTest.class,
	CausaProhibicionServiceTest.class,
	ComunidadAutonomaServiceTest.class,
	SituacionServiceTest.class,
	TipoDocIdentidadServiceTest.class,
	TipoFirmaServiceTest.class,
	TipoProhibicionServiceTest.class})
public class AllTests {

}
