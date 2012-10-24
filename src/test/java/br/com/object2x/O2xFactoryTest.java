package br.com.object2x;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.object2x.impl.O2JsonTest;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class O2xFactoryTest {

	@Test
	public void testCreateBasicO2Json() {
		
		O2x o2x = O2xFactory.createBasicO2Json();
		assertTrue(o2x != null);
		//o2x.
	}

	@Test
	public void testCreateBasicO2Xml() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateBasicO2Csv() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateBasicO2Xls() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateO2Json() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateO2Xml() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateO2Csv() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateO2Xls() {
		fail("Not yet implemented");
	}

}
