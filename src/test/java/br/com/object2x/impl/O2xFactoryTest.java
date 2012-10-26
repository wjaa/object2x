package br.com.object2x.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.object2x.O2x;
import br.com.object2x.TransformStrategy;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class O2xFactoryTest {
	
	private static TransformStrategy DEFAULT_STRATEGY = new TransformStrategy();

	@Test
	public void testCreateBasicO2Json() {
		O2x o2x = O2xFactory.createBasicO2Json();
		assertTrue(o2x instanceof O2Json);
	}

	@Test
	public void testCreateBasicO2Xml() {
		O2x o2x = O2xFactory.createBasicO2Xml();
		assertTrue(o2x instanceof O2Xml);
	}

	@Test
	public void testCreateBasicO2Csv() {
		O2x o2x = O2xFactory.createBasicO2Csv();
		assertTrue(o2x instanceof O2Csv);
	}

	@Test
	public void testCreateBasicO2Xls() {
		O2x o2x = O2xFactory.createBasicO2Xls();
		assertTrue(o2x instanceof O2Xls);
	}

	@Test
	public void testCreateO2Json() {
		O2x o2x = O2xFactory.createO2Json(DEFAULT_STRATEGY);
		assertTrue(o2x instanceof O2Json);
	}

	@Test
	public void testCreateO2Xml() {
		O2x o2x = O2xFactory.createO2Xml(DEFAULT_STRATEGY);
		assertTrue(o2x instanceof O2Xml);
	}

	@Test
	public void testCreateO2Csv() {
		O2x o2x = O2xFactory.createO2Csv(DEFAULT_STRATEGY);
		assertTrue(o2x instanceof O2Csv);
	}

	@Test
	public void testCreateO2Xls() {
		O2x o2x = O2xFactory.createO2Xls(DEFAULT_STRATEGY);
		assertTrue(o2x instanceof O2Xls);
	}

}
