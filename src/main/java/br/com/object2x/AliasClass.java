package br.com.object2x;


/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class AliasClass {

	private String alias;
	private Class<?> clazz;
	private String atributeName;
	
	
	public AliasClass(String alias, Class<?> clazz, String atributeName){
		this.alias = alias;
		this.clazz = clazz;
		this.atributeName = atributeName;
	}
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Class<?> getClazz() {
		return clazz;
	}
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}
	public String getAtributeName() {
		return atributeName;
	}
	public void setAtributeName(String atributeName) {
		this.atributeName = atributeName;
	}
	
}
