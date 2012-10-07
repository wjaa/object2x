package br.com.object2x.testObjects;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class PrimitiveTestObject {

	private boolean booleanValue = true;
	private char charValue = 'a';
	private String stringValue = "abcdefghijklmnopqrstuvxzABCDEFGHIJKLMNOPQRSTUVXZ!@#$%¨&*()_+{}][´~/;.,<>:?^ç`123456789";
	private byte byteValue = Byte.MAX_VALUE;
	private short shortValue = Short.MAX_VALUE;
	private int intValue = Integer.MAX_VALUE;
	private float floatValue = Float.MAX_VALUE;
	private long longValue = Long.MAX_VALUE;
	private double doubleValue = Double.MAX_VALUE;
	
	
	public boolean isBooleanValue() {
		return booleanValue;
	}
	public void setBooleanValue(boolean booleanValue) {
		this.booleanValue = booleanValue;
	}
	public char getCharValue() {
		return charValue;
	}
	public void setCharValue(char charValue) {
		this.charValue = charValue;
	}
	public String getStringValue() {
		return stringValue;
	}
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
	public byte getByteValue() {
		return byteValue;
	}
	public void setByteValue(byte byteValue) {
		this.byteValue = byteValue;
	}
	public short getShortValue() {
		return shortValue;
	}
	public void setShortValue(short shortValue) {
		this.shortValue = shortValue;
	}
	public int getIntValue() {
		return intValue;
	}
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}
	public float getFloatValue() {
		return floatValue;
	}
	public void setFloatValue(float floatValue) {
		this.floatValue = floatValue;
	}
	public long getLongValue() {
		return longValue;
	}
	public void setLongValue(long longValue) {
		this.longValue = longValue;
	}
	public double getDoubleValue() {
		return doubleValue;
	}
	public void setDoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (booleanValue ? 1231 : 1237);
		result = prime * result + byteValue;
		result = prime * result + charValue;
		long temp;
		temp = Double.doubleToLongBits(doubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(floatValue);
		result = prime * result + intValue;
		result = prime * result + (int) (longValue ^ (longValue >>> 32));
		result = prime * result + shortValue;
		result = prime * result
				+ ((stringValue == null) ? 0 : stringValue.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrimitiveTestObject other = (PrimitiveTestObject) obj;
		if (booleanValue != other.booleanValue)
			return false;
		if (byteValue != other.byteValue)
			return false;
		if (charValue != other.charValue)
			return false;
		if (Double.doubleToLongBits(doubleValue) != Double
				.doubleToLongBits(other.doubleValue))
			return false;
		if (Float.floatToIntBits(floatValue) != Float
				.floatToIntBits(other.floatValue))
			return false;
		if (intValue != other.intValue)
			return false;
		if (longValue != other.longValue)
			return false;
		if (shortValue != other.shortValue)
			return false;
		if (stringValue == null) {
			if (other.stringValue != null)
				return false;
		} else if (!stringValue.equals(other.stringValue))
			return false;
		return true;
	}
	
}
