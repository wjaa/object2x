package br.com.object2x.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
class O2XmlConverter implements Converter {

	 private SimpleDateFormat sdf;

     public O2XmlConverter(String dateFormat) {
             if (StringUtils.isBlank(dateFormat)){
            	 dateFormat = "yyyy/mm/dd hh:mm:ss";
             }
             
             sdf = new SimpleDateFormat(dateFormat);
     }

     public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {
             return Date.class.isAssignableFrom(clazz);
     }

     public void marshal(Object value, HierarchicalStreamWriter writer,
                     MarshallingContext context) {
             Date date = (Date) value;
             
             writer.setValue(this.sdf.format(date));
     }

     public Object unmarshal(HierarchicalStreamReader reader,
                     UnmarshallingContext context) {
             
             try {
                     return this.sdf.parse(reader.getValue());
             } catch (ParseException e) {
                     throw new ConversionException(e.getMessage(), e);
             }
     }

}
