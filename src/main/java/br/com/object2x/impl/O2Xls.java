package br.com.object2x.impl;

import java.io.File;
import java.io.InputStream;

import br.com.object2x.AbstractO2x;
import br.com.object2x.TransformStrategy;
import br.com.object2x.exception.O2xTransformException;

class O2Xls extends AbstractO2x {

	
	O2Xls() {
		super(DEFAULT_TRANSFORM_STRATEGY);
	}
	
	O2Xls(TransformStrategy transformStrategy) {
		super(transformStrategy);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T deserialize(String serialized, Class<T> clazz)
			throws O2xTransformException {
		// TODO Auto-generated method stub
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
