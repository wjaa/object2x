package br.com.object2x.impl;

import br.com.object2x.O2x;
import br.com.object2x.TransformStrategy;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public final class O2xFactory {
	
	private static O2xBuilder o2JsonBuilder = new O2xBuilder(O2xType.JSON);
	private static O2xBuilder o2XmlBuilder = new O2xBuilder(O2xType.XML);
	private static O2xBuilder o2CsvBuilder = new O2xBuilder(O2xType.CSV);
	private static O2xBuilder o2XlsBuilder = new O2xBuilder(O2xType.XLS);
	
	 
	
	/**
	 * Cria um O2Json basico sem nenhuma configuracao.
	 * @return O2x
	 */
	public static O2x createBasicO2Json(){
		o2JsonBuilder.resetStrategy();
		return o2JsonBuilder.createO2x();
	}
	
	/**
	 * Cria um O2Xml basico sem nenhuma configuracao.
	 * @return O2Xml
	 */
	public static O2x createBasicO2Xml(){
		o2XmlBuilder.resetStrategy();
		return o2XmlBuilder.createO2x();
	}
	
	
	/**
	 * Cria um O2Csv basico sem nenhuma configuracao.
	 * @return O2Csv
	 */
	public static O2x createBasicO2Csv(){
		o2CsvBuilder.resetStrategy();
		return o2CsvBuilder.createO2x();
	}
	
	/**
	 * Cria um O2Xls basico sem nenhuma configuracao.
	 * @return O2Xls
	 */
	public static O2x createBasicO2Xls(){
		o2XlsBuilder.resetStrategy();
		return o2XlsBuilder.createO2x();
	}

	
	/**
	 * Cria um O2Json com a uma configuracao customizada.
	 * @return O2xJson
	 */
	public static O2x createO2Json(TransformStrategy transformStrategy){
		o2JsonBuilder.setTransformStrategy(transformStrategy);
		return o2JsonBuilder.createO2x();
	}
	
	/**
	 * Cria um O2Xml com uma configuracao customizada.
	 * @return O2Xml
	 */
	public static O2x createO2Xml(TransformStrategy transformStrategy){
		o2XmlBuilder.setTransformStrategy(transformStrategy);
		return o2XmlBuilder.createO2x();
	}
	
	
	/**
	 * Cria um O2Csv com uma configuracao customizada.
	 * @return O2Csv
	 */
	public static O2x createO2Csv(TransformStrategy transformStrategy){
		o2CsvBuilder.setTransformStrategy(transformStrategy);
		return o2CsvBuilder.createO2x();
	}
	
	/**
	 * Cria um O2Xls com uma configuracao customizada.
	 * @return O2Xls
	 */
	public static O2x createO2Xls(TransformStrategy transformStrategy){
		o2XlsBuilder.setTransformStrategy(transformStrategy);
		return o2XlsBuilder.createO2x();
	}
	
}
