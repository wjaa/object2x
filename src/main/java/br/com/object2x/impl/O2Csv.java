package br.com.object2x.impl;

import java.io.File;
import java.io.InputStream;

import br.com.object2x.AbstractO2x;
import br.com.object2x.TransformStrategy;
import br.com.object2x.exception.O2xTransformException;

class O2Csv extends AbstractO2x {

	O2Csv(){
		super(DEFAULT_TRANSFORM_STRATEGY);
	}
	
	O2Csv(TransformStrategy transformStrategy) {
		super(transformStrategy);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T deserialize(String serialized, Class<T> clazz)
			throws O2xTransformException {
		String [] linha = serialized.split("\n");
		
		
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T deserialize(File serialized, Class<T> clazz)
			throws O2xTransformException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T deserialize(InputStream serialized, Class<T> clazz)
			throws O2xTransformException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T deserialize(String serialized, GenericsTypeClass<T> typedClazz)
			throws O2xTransformException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String serializeString(Object object) throws O2xTransformException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public InputStream serializeInputStream(Object object)
			throws O2xTransformException {
		// TODO Auto-generated method stub
		return null;
	}

}
