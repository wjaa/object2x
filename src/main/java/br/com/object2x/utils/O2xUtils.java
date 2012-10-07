package br.com.object2x.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
*
* Classe Utilitaria.
*
* @author wagner.araujo
*
*/
public class O2xUtils {

	private static String [] REPLACES;
	private static Pattern [] PATTERNS;
	static {

		REPLACES = new String[]{ "a","A","e","E","i","I","o","O","u","U","c","C"};

		PATTERNS = new Pattern[REPLACES.length];

		PATTERNS[0] = Pattern.compile("[âãáàä]");
		PATTERNS[1] = Pattern.compile("[ÂÃÁÀÄ]");
		PATTERNS[2] = Pattern.compile("[éèêë]");
		PATTERNS[3] = Pattern.compile("[ÉÈÊË]");
		PATTERNS[4] = Pattern.compile("[íìîï]");
		PATTERNS[5] = Pattern.compile("[ÍÌÎÏ]");
		PATTERNS[6] = Pattern.compile("[óòôõö]");
		PATTERNS[7] = Pattern.compile("[ÓÒÔÕÖ]");
		PATTERNS[8] = Pattern.compile("[úùûü]");
		PATTERNS[9] = Pattern.compile("[ÚÙÛÜ]");
		PATTERNS[10] = Pattern.compile("[ç]");
		PATTERNS[11] = Pattern.compile("[Ç]");
}


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


	public static String replaceSpecial( String text ) {
		String result = text;
		for (int i = 0; i < PATTERNS.length; i++) {
			Matcher matcher = PATTERNS[i].matcher(result);
			result = matcher.replaceAll(REPLACES[i]);
		}
		return result;
	}
	
}

