package br.com.object2x.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.object2x.exception.O2xTransformException;
import br.com.object2x.testObjects.TestObject;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class O2JsonTest {

	private O2xBuilder o2xBuilder = new O2xBuilder(O2xType.JSON);
	
	
	@Test
	public void testDeserializeStringType() {
		List<TestObject> listTestObject = new ArrayList<TestObject>();
		listTestObject.add(new TestObject());
		listTestObject.add(new TestObject());
		listTestObject.add(new TestObject());
		
		try {
			String jsonTest = this.o2xBuilder.createO2x().serializeString(listTestObject);
			List<TestObject> listResultTestObject = this.o2xBuilder.createO2x().deserialize(jsonTest, new GenericsTypeClass<List<TestObject>>());
			assertNotNull(listResultTestObject);
			assertTrue(listResultTestObject.equals(listTestObject));
		} catch (O2xTransformException e) {
			fail();
		} 
	}
	
	
	@Test
	public void testDeserializeStringClassOfT() {
		TestObject testObject = new TestObject();
		try {
			String jsonTest = this.o2xBuilder.createO2x().serializeString(testObject);
			TestObject resultTestObject = this.o2xBuilder.createO2x().deserialize(jsonTest, TestObject.class);
			assertNotNull(resultTestObject);
			assertTrue(resultTestObject.equals(testObject));
		} catch (O2xTransformException e) {
			fail();
		} 
	}

	@Test
	public void testDeserializeFileClassOfT() {
		TestObject testObject = new TestObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
		try {
			//setando a data igual a que está no arquivo de json.
			testObject.setDate(sdf.parse("2012/08/29 05:08:00"));
			URL url = ClassLoader.getSystemResource("jsonTest.json");  
			File fJson = new File(url.toURI());
			TestObject resultTestObject = this.o2xBuilder.createO2x().deserialize(fJson,TestObject.class);
			assertNotNull(resultTestObject);
			assertTrue(resultTestObject.equals(testObject));
		} catch (O2xTransformException e) {
			fail();
		} catch (Exception ex) {
			fail();
		}
	}

	@Test
	public void testDeserializeInputStreamClassOfT() {
		TestObject testObject = new TestObject();
		try {
			InputStream in = o2xBuilder.createO2x().serializeInputStream(testObject);
			TestObject resultTestObject = this.o2xBuilder.createO2x().deserialize(in, TestObject.class);
			assertNotNull(resultTestObject);
			assertTrue(resultTestObject.equals(testObject));
		} catch (O2xTransformException e) {
			fail();
		}
	}

	@Test
	public void testSerializeString() {
		TestObject testObject = new TestObject();
		try {
			String json = this.o2xBuilder.createO2x().serializeString(testObject);
			assertNotNull(json);
			TestObject resultTestObject = this.o2xBuilder.createO2x().deserialize(json, TestObject.class);
			assertTrue(resultTestObject.equals(testObject));
		} catch (O2xTransformException e) {
			fail();
		}
	}

	@Test
	public void testSerializeInputStream() {
		TestObject testObject = new TestObject();
		try {
			InputStream inJson = this.o2xBuilder.createO2x().serializeInputStream(testObject);
			assertNotNull(inJson);
			assertTrue(inJson.available() > 0);
			TestObject resultTestObject = this.o2xBuilder.createO2x().deserialize(inJson, TestObject.class);
			assertTrue(resultTestObject.equals(testObject));
		} catch (O2xTransformException e) {
			fail();
		}  catch (Exception ex) {
			fail();
		}
	}
	
}
