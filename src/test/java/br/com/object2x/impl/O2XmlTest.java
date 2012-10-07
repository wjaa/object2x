package br.com.object2x.impl;

import static org.junit.Assert.*;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;

import org.junit.Test;

import br.com.object2x.exception.O2xTransformException;
import br.com.object2x.impl.O2xBuilder;
import br.com.object2x.impl.O2xType;
import br.com.object2x.testObjects.TestObject;

public class O2XmlTest {

	private O2xBuilder o2xBuilder = new O2xBuilder(O2xType.XML);
	
	@Test
	public void testDeserializeStringClassOfT() {
		TestObject testObject = new TestObject();
		try {
			String xml = this.o2xBuilder.createO2x().serializeString(testObject);
			TestObject resultTestObject = this.o2xBuilder.createO2x().deserialize(xml,TestObject.class);
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
			testObject.setDate(sdf.parse("2012/38/10 12:38:20"));
			URL url = ClassLoader.getSystemResource("xmlTest.xml");
			File fileXml = new File(url.toURI());
			TestObject resultTestObject = this.o2xBuilder.createO2x().deserialize(fileXml, TestObject.class);
			assertNotNull(resultTestObject);
			assertTrue(resultTestObject.equals(testObject));
		} catch (O2xTransformException e) {
			fail();
		}catch (Exception ex){
			fail();
		}
	}

	@Test
	public void testDeserializeInputStreamClassOfT() {
		TestObject testObject = new TestObject();
		try {
			InputStream inXml = this.o2xBuilder.createO2x().serializeInputStream(testObject);
			TestObject resultTestObject = this.o2xBuilder.createO2x().deserialize(inXml,TestObject.class);
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
			String xml = this.o2xBuilder.createO2x().serializeString(testObject);
			assertNotNull(xml);
			TestObject resultTestObject = this.o2xBuilder.createO2x().deserialize(xml,TestObject.class);
			assertTrue(resultTestObject.equals(testObject));
		} catch (O2xTransformException e) {
			fail();
		}
		
	}

	@Test
	public void testSerializeInputStream() {
		TestObject testObject = new TestObject();
		try {
			InputStream inXml = this.o2xBuilder.createO2x().serializeInputStream(testObject);
			assertNotNull(inXml);
			TestObject resultTestObject = this.o2xBuilder.createO2x().deserialize(inXml,TestObject.class);
			assertTrue(resultTestObject.equals(testObject));
		} catch (O2xTransformException e) {
			fail();
		}
	}

}
