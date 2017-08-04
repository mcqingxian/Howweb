package com.hoau.how.module.bse.shared.utils;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

public class JsonUtils {
	private static final ObjectMapper mapper = new ObjectMapper();
	
	static{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(df);
		mapper.getDeserializationConfig().set(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
	}
	
	public static <T> T toObject(String jsonStr,Class<T> t){
		if(jsonStr == null || "".equals(jsonStr)){
			return null;
		}
		try {
			return mapper.readValue(jsonStr, t);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String toJson(Object o){
		try {
			return mapper.writeValueAsString(o);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * jsonToList<T> 带泛�?
	 * jsonStr  
	 * clazz  集合元素类型
	 */
	
	public static <T> List<T> toList(String jsonStr,Class<T> clazz){
		JavaType javaType = getCollectionType(List.class,clazz);
		try {
			return mapper.readValue(jsonStr, javaType);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * jsonToMap<T> 带泛�?
	 * jsonStr  json字符�?
	 * keyClazz     key class
	 * valueClazz 	value class
	 */
	public static <K,V> Map<K, V> toMap(String jsonStr,Class<K> keyClazz,Class<V> valueClazz){
		JavaType javaType = mapper.getTypeFactory().constructParametricType(Map.class, keyClazz,valueClazz);
		try {
			return mapper.readValue(jsonStr, javaType);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static JavaType getCollectionType(Class<?> collectionClass,
			Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass,
				elementClasses);
	}
}
