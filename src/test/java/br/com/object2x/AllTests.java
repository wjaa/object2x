package br.com.object2x;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.object2x.impl.O2JsonTest;
import br.com.object2x.impl.O2XmlTest;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ O2JsonTest.class, O2XmlTest.class })
public class AllTests {

	/**
	 * Suite de testes.
	 */
	
}
