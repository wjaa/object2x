package br.com.object2x.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class ReflectionUtils {

	
	/**
	 * Resgata o tipo generico da classe 
	 * @param clazz Classe generics
	 * @return Generic Type
	 */
	public static Class<?> getTypeGenericInstance(Class<?> clazz){
		ParameterizedType parameterized = (ParameterizedType) clazz.getGenericSuperclass();
		Type[] arguments = parameterized.getActualTypeArguments();
		return (Class<?>) arguments[0];
	}
	
	/**
	 * Resgata o tipo generico da classe pelo seu index
	 * @param clazz Classe generics
	 * @param i index do generic.
	 * @return Generic Type
	 */
	public static Class<?> getTypeGenericInstance(Class<?> clazz, int i){
		ParameterizedType parameterized = (ParameterizedType) clazz.getGenericSuperclass();
		Type[] arguments = parameterized.getActualTypeArguments();
		return (Class<?>) arguments[i];
	}
	
	/**
	 * Resgata todos os generics da classe.
	 * @param clazz Classe generics
	 * @return Generic Type
	 */
	public static Class<?> [] getTypeGenericsInstance(Class<?> clazz){
		ParameterizedType parameterized = (ParameterizedType) clazz.getGenericSuperclass();
		Type[] arguments = parameterized.getActualTypeArguments();
		Class<?>[] classes = new Class[arguments.length];
		
		for (int i = 0; i < classes.length; i++) {
			classes [i] = (Class<?>)arguments[i];
		}
		return classes;
	}
	
}
