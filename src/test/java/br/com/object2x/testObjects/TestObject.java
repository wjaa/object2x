package br.com.object2x.testObjects;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class TestObject {

	private PrimitiveTestObject primitiveTestObject;
	private WrapperTestObject wrapperTestObject;
	private List<WrapperTestObject> listWrapperTestObject;
	private List<PrimitiveTestObject> listPrimitiveTestObject;
	private Date date;
	
	
	public TestObject(){
		this.listPrimitiveTestObject = new ArrayList<PrimitiveTestObject>();
		this.listPrimitiveTestObject.add(new PrimitiveTestObject());
		this.listPrimitiveTestObject.add(new PrimitiveTestObject());
		this.listPrimitiveTestObject.add(new PrimitiveTestObject());
		this.listWrapperTestObject = new ArrayList<WrapperTestObject>();
		this.listWrapperTestObject.add(new WrapperTestObject());
		this.listWrapperTestObject.add(new WrapperTestObject());
		this.listWrapperTestObject.add(new WrapperTestObject());
		this.date = new Date();
	}
	
	
	public PrimitiveTestObject getPrimitiveTestObject() {
		return primitiveTestObject;
	}
	public void setPrimitiveTestObject(PrimitiveTestObject primitiveTestObject) {
		this.primitiveTestObject = primitiveTestObject;
	}
	public WrapperTestObject getWrapperTestObject() {
		return wrapperTestObject;
	}
	public void setWrapperTestObject(WrapperTestObject wrapperTestObject) {
		this.wrapperTestObject = wrapperTestObject;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<WrapperTestObject> getListWrapperTestObject() {
		return listWrapperTestObject;
	}
	public void setListWrapperTestObject(
			List<WrapperTestObject> listWrapperTestObject) {
		this.listWrapperTestObject = listWrapperTestObject;
	}
	public List<PrimitiveTestObject> getListPrimitiveTestObject() {
		return listPrimitiveTestObject;
	}
	public void setListPrimitiveTestObject(
			List<PrimitiveTestObject> listPrimitiveTestObject) {
		this.listPrimitiveTestObject = listPrimitiveTestObject;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime
				* result
				+ ((listPrimitiveTestObject == null) ? 0
						: listPrimitiveTestObject.hashCode());
		result = prime
				* result
				+ ((listWrapperTestObject == null) ? 0 : listWrapperTestObject
						.hashCode());
		result = prime
				* result
				+ ((primitiveTestObject == null) ? 0 : primitiveTestObject
						.hashCode());
		result = prime
				* result
				+ ((wrapperTestObject == null) ? 0 : wrapperTestObject
						.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss:mmm");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestObject other = (TestObject) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!sdf.format(date).equals(sdf.format(other.date)))
			return false;
		if (listPrimitiveTestObject == null) {
			if (other.listPrimitiveTestObject != null)
				return false;
		} else if (!listPrimitiveTestObject
				.equals(other.listPrimitiveTestObject))
			return false;
		if (listWrapperTestObject == null) {
			if (other.listWrapperTestObject != null)
				return false;
		} else if (!listWrapperTestObject.equals(other.listWrapperTestObject))
			return false;
		if (primitiveTestObject == null) {
			if (other.primitiveTestObject != null)
				return false;
		} else if (!primitiveTestObject.equals(other.primitiveTestObject))
			return false;
		if (wrapperTestObject == null) {
			if (other.wrapperTestObject != null)
				return false;
		} else if (!wrapperTestObject.equals(other.wrapperTestObject))
			return false;
		return true;
	}


	
	
	
}
