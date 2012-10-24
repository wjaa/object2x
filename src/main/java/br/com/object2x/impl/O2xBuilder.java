package br.com.object2x.impl;

import br.com.object2x.O2x;
import br.com.object2x.TransformStrategy;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class O2xBuilder {

	
	private O2xType o2xType;
	private TransformStrategy transformStrategy = new TransformStrategy();
	
	public O2xBuilder(O2xType o2xType){
		this.o2xType = o2xType;
	}
	
	public O2x createO2x() {
		return create();
	}
	
	public O2xBuilder setDateFormat(String dateFormat) {
		this.transformStrategy.setDateFormat(dateFormat);
		return this;
	}

	public O2xBuilder setEncode(String encode) {
		this.transformStrategy.setEncode(encode);
		return this;
	}
	
	public O2xBuilder setProcessAnnotations(boolean process) {
		this.transformStrategy.setProcessAnnotations(process);
		return this;
	}
	
	private O2x create(){
		switch (this.o2xType) {
			case JSON: return this.createO2Json();
			case XML: return this.createO2Xml();
		}
		return null;
	}

	private O2x createO2Xml() {
		return new O2Xml(this.transformStrategy);
	}

	private O2x createO2Json() {
		return new O2Json(this.transformStrategy);
	}
	
	
	public void resetStrategy(){
		this.transformStrategy = new TransformStrategy();
	}
	
	public void setTransformStrategy(TransformStrategy transformStrategy){
		this.transformStrategy = transformStrategy;
	}
	
}
