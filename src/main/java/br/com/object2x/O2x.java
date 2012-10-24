package br.com.object2x;

import java.io.File;
import java.io.InputStream;

import br.com.object2x.exception.O2xTransformException;
import br.com.object2x.impl.GenericsTypeClass;


/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public interface O2x{

	/**
	 * Transforma um objeto notado em um Objeto Java (POJO).
	 * @param serialized String serializada.
	 * @return Objeto convertido.
	 */
	<T>T deserialize(String serialized, Class<T> clazz) throws O2xTransformException;
	
	
	/**
	 * Transforma um arquivo notado em um Objeto Java (POJO).
	 * @param serialized File serializado.
	 * @return Objeto convertido.
	 */
	<T>T deserialize(File serialized, Class<T> clazz ) throws O2xTransformException;
	
	
	/**
	 * Transforma um inputStream notado em um Objeto Java (POJO).
	 * @param serialized InputStream serializado em algum padrao.
	 * @return Objeto convertido.
	 */
	<T>T deserialize(InputStream serialized, Class<T> clazz) throws O2xTransformException;
	
	
	
	/**
	 * Transforma um objeto notado em um Objeto Java (POJO).
	 * @param serialized String serializada.
	 * @return Objeto convertido.
	 */
	<T>T deserialize(String serialized, GenericsTypeClass<T> typedClazz) throws O2xTransformException;
	
	
	/**
	 * Transforma um OBJ em String notada.
	 * @param object OBJ que queria transformar.
	 * @return String serializada.
	 */
	String serializeString(Object object) throws O2xTransformException;
	
	
	/**
	 * Transforma um OBJ em InputStream notada.
	 * @param object OBJ que queria transformar.
	 * @return InputStream serializada.
	 */
	InputStream serializeInputStream(Object object) throws O2xTransformException;
	
}
