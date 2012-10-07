package br.com.object2x;


/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 * 
 */
public abstract class AbstractO2x implements O2x {

	private TransformStrategy transformStrategy;
	
	protected static final TransformStrategy DEFAULT_TRANSFORM_STRATEGY = new TransformStrategy();
	
	
	public AbstractO2x(TransformStrategy transformStrategy){
		this.transformStrategy = new TransformStrategy();
	}

	public TransformStrategy getTransformStrategy() {
		return transformStrategy;
	}

	public void setTransformStrategy(TransformStrategy transformStrategy) {
		this.transformStrategy = transformStrategy;
	}
	
}
