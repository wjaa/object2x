package br.com.object2x.impl;

import java.awt.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import br.com.object2x.AbstractO2x;
import br.com.object2x.TransformStrategy;
import br.com.object2x.exception.O2xTransformException;
import br.com.object2x.utils.ReflectionUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
final class O2Json extends AbstractO2x {

	private GsonBuilder gsonBuilder;
	
	
	O2Json(){
		this(DEFAULT_TRANSFORM_STRATEGY);
	}
	
	O2Json(TransformStrategy transformStrategy) {
		super(transformStrategy);
		gsonBuilder = new GsonBuilder().setDateFormat(transformStrategy.getDateFormat());
	}

	
	
	@Override
	public <T> T deserialize(String serialized, GenericsTypeClass<T> typedClazz)
			throws O2xTransformException {
		Gson gson = this.gsonBuilder.create();
		return gson.fromJson(serialized,typedClazz.getType());
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T>T deserialize(String serialized, Class<T> clazz) throws O2xTransformException {
		Gson gson = this.gsonBuilder.create();
		return gson.fromJson(serialized,clazz); 
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T>T deserialize(File serialized, Class<T> clazz) throws O2xTransformException {
		
		if (!serialized.exists()){
			throw new O2xTransformException("FileNotFound");
		}
		
		try{
			FileInputStream fin = new FileInputStream(serialized);
			StringBuilder sb = new StringBuilder();
			sb.append(IOUtils.toCharArray(fin,this.getTransformStrategy().getEncode()));
			return deserialize(sb.toString(), clazz);
			
		}catch (IOException e) {
			throw new O2xTransformException("IO");
		}
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public<T>T deserialize(InputStream serialized, Class<T> clazz) throws O2xTransformException {
		
		try{
			if (serialized.available() < 1){
				throw new O2xTransformException("FileVazio");
			}
			StringBuilder sb = new StringBuilder();
			sb.append(IOUtils.toCharArray(serialized,this.getTransformStrategy().getEncode()));
			return deserialize(sb.toString(), clazz);
			
		}catch (IOException e) {
			throw new O2xTransformException("IO");
		}
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String serializeString(Object object) throws O2xTransformException {
		Gson g = gsonBuilder.create();
		return g.toJson(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public InputStream serializeInputStream(Object object) throws O2xTransformException {
		Gson g = gsonBuilder.create();
		String json = g.toJson(object);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			IOUtils.write(json, out, this.getTransformStrategy().getEncode());
		} catch (IOException e) {
			throw new O2xTransformException("ErroNaEscritaJson");
		}
		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
		return in;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		ReflectionUtils.getTypeGenericInstance(List.class);
	}
	
}
