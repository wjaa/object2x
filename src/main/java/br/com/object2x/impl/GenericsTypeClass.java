package br.com.object2x.impl;

import static com.google.gson.internal.$Gson$Preconditions.checkArgument;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

import com.google.gson.internal.$Gson$Types;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 * @param <T>
 */
public class GenericsTypeClass<T> {

	private Type type;
	private Class<T> clazz;
	
	 /**
	   * Constructs a new type literal. Derives represented class from type
	   * parameter.
	   *
	   * <p>Clients create an empty anonymous subclass. Doing so embeds the type
	   * parameter in the anonymous class's type hierarchy so we can reconstitute it
	   * at runtime despite erasure.
	   */
	  @SuppressWarnings("unchecked")
	  public GenericsTypeClass() {
	    this.type = getSuperclassTypeParameter(getClass());
	    this.clazz = (Class<T>) getRawType(type);
	  }
	  
	  

	  /**
	   * Returns the type from super class's type parameter in {@link $Gson$Types#canonicalize
	   * canonical form}.
	   */
	  private Type getSuperclassTypeParameter(Class<?> subclass) {
	    Type superclass =  subclass.getGenericSuperclass();
	    if (superclass instanceof Class) {
	      throw new RuntimeException("Missing type parameter.");
	    }
	    ParameterizedType parameterized = (ParameterizedType) superclass;
	    return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
	  }
	  
	  
	  public static Class<?> getRawType(Type type) {
		    if (type instanceof Class<?>) {
		      // type is a normal class.
		      return (Class<?>) type;

		    } else if (type instanceof ParameterizedType) {
		      ParameterizedType parameterizedType = (ParameterizedType) type;

		      // I'm not exactly sure why getRawType() returns Type instead of Class.
		      // Neal isn't either but suspects some pathological case related
		      // to nested classes exists.
		      Type rawType = parameterizedType.getRawType();
		      checkArgument(rawType instanceof Class);
		      return (Class<?>) rawType;

		    } else if (type instanceof GenericArrayType) {
		      Type componentType = ((GenericArrayType)type).getGenericComponentType();
		      return Array.newInstance(getRawType(componentType), 0).getClass();

		    } else if (type instanceof TypeVariable) {
		      // we could use the variable's bounds, but that won't work if there are multiple.
		      // having a raw type that's more general than necessary is okay
		      return Object.class;

		    } else if (type instanceof WildcardType) {
		      return getRawType(((WildcardType) type).getUpperBounds()[0]);

		    } else {
		      String className = type == null ? "null" : type.getClass().getName();
		      throw new IllegalArgumentException("Expected a Class, ParameterizedType, or "
		          + "GenericArrayType, but <" + type + "> is of type " + className);
		    }
		}



	public Type getType() {
		return type;
	}



	public void setType(Type type) {
		this.type = type;
	}



	public Class<T> getClazz() {
		return clazz;
	}



	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	
}
