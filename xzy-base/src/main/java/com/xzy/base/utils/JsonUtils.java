package com.xzy.base.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author luobo
 * @Date 2022-12-23
 **/
@Slf4j
public class JsonUtils {

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        // 设置属性值为空时不显示
        //objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static String toJson(Object object) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            log.error("toJson error", e);
        }
        return json;
    }

    public static <T> T toObject(String json, Class<T> clazz) {
        T returnObj = null;
        try {
            returnObj = objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            log.error("toObject error,json:{}", json, e);
        }
        return returnObj;
    }
}
