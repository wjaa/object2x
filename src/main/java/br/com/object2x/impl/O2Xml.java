package br.com.object2x.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

import br.com.object2x.AbstractO2x;
import br.com.object2x.TransformStrategy;
import br.com.object2x.exception.O2xTransformException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 
 *
 */
final class O2Xml extends AbstractO2x {
	private XStream xStream;
	
	O2Xml() {
		this(DEFAULT_TRANSFORM_STRATEGY);
	}
	
	O2Xml(TransformStrategy transformStrategy) {
		super(transformStrategy);
		this.xStream = new XStream(new DomDriver(transformStrategy.getEncode(), new NoNameCoder()));
		this.xStream.registerConverter(new O2XmlConverter(transformStrategy.getDateFormat()));
		
	}
	
	@Override
	public <T> T deserialize(String serialized, GenericsTypeClass<T> typedClazz)
			throws O2xTransformException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T>T deserialize(String serialized, Class<T> clazz) throws O2xTransformException {
		try {
			this.processAnnotations(clazz);
			return (T)this.xStream.fromXML(serialized, clazz.newInstance());
		} catch (InstantiationException e) {
			throw new O2xTransformException("Error ao deserializar os dados para a clazz :" + clazz.getName());
		} catch (IllegalAccessException e) {
			throw new O2xTransformException("Error ao deserializar os dados para a clazz :" + clazz.getName());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T>T deserialize(File serialized, Class<T> clazz) throws O2xTransformException {
		try {
			this.processAnnotations(clazz);
			return (T)this.xStream.fromXML(serialized, clazz.newInstance());
		} catch (InstantiationException e) {
			throw new O2xTransformException("Error ao deserializar os dados para a clazz :" + clazz.getName());
		} catch (IllegalAccessException e) {
			throw new O2xTransformException("Error ao deserializar os dados para a clazz :" + clazz.getName());
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public <T>T deserialize(InputStream serialized, Class<T> clazz) throws O2xTransformException {
		
		try {
			this.processAnnotations(clazz);
			return (T)this.xStream.fromXML(serialized, clazz.newInstance());
		} catch (InstantiationException e) {
			throw new O2xTransformException("Error ao deserializar os dados para a clazz :" + clazz.getName());
		} catch (IllegalAccessException e) {
			throw new O2xTransformException("Error ao deserializar os dados para a clazz :" + clazz.getName());
		}
	}

	@Override
	public String serializeString(Object object) throws O2xTransformException {
		return this.xStream.toXML(object);
	}

	@Override
	public InputStream serializeInputStream(Object object) throws O2xTransformException {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		this.xStream.toXML(object, bout);
		return new ByteArrayInputStream(bout.toByteArray());
	}
	
	private <T> void processAnnotations(Class<T> clazz) {
		if (this.getTransformStrategy().isProcessAnnotations()){
			this.xStream.processAnnotations(clazz);
		}
	}
	
}
