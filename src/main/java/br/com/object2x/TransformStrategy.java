package br.com.object2x;

import java.util.List;


/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class TransformStrategy {

	
	private String dateFormat = "yyyy/mm/dd hh:mm:ss";
	private String encode = "UTF-8";
	private List<AliasClass> aliasClasses;
	private boolean processAnnotations = true;
	
	
	public String getDateFormat() {
		return dateFormat;
	}
	public TransformStrategy setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
		return this;
	}
	public String getEncode() {
		return encode;
	}
	public TransformStrategy setEncode(String encode) {
		this.encode = encode;
		return this;
	}
	public List<AliasClass> getAliasClasses() {
		return aliasClasses;
	}
	public void setAliasClasses(List<AliasClass> aliasClasses) {
		this.aliasClasses = aliasClasses;
	}
	public boolean existisAliasClass() {
		return this.aliasClasses != null && this.aliasClasses.size() > 0;
	}
	
	public boolean isProcessAnnotations() {
		return processAnnotations;
	}
	public void setProcessAnnotations(boolean processAnnotations) {
		this.processAnnotations = processAnnotations;
	}
	
	
	
}
