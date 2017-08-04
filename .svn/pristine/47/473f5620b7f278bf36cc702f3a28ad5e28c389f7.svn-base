package com.hoau.how.module.util;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

import java.io.IOException;
import java.util.List;

/**
 * Created by Alex on 2016/3/15.
 */
public class JsonHelper {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        DeserializationConfig deserializationConfig = mapper.getDeserializationConfig();
        deserializationConfig.set(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }

    public static <T> T toObject(String jsonStr, Class<T> t) {
        if (jsonStr == null || "".equals(jsonStr)) {
            return null;
        }
        try {
            return mapper.readValue(jsonStr, t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String toJson(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JsonNode toJsonNode(String jsonStr) {
        if (jsonStr == null || "".equals(jsonStr)) {
            return null;
        }

        try {
            return mapper.readTree(jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static <T> List<T> toList(String jsonStr, Class<T> clazz){
        JavaType javaType = getCollectionType(List.class,clazz);

        try {
            return mapper.readValue(jsonStr, javaType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> toList(JsonNode jsonStr, Class<T> clazz){
        JavaType javaType = getCollectionType(List.class,clazz);

        try {
            return mapper.readValue(jsonStr, javaType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static JavaType getCollectionType(Class<?> collectionClass,
                                             Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass,
                elementClasses);
    }
}
