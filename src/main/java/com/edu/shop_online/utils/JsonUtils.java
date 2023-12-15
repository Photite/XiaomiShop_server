package com.edu.shop_online.utils;

import com.edu.shop_online.entity.Carousel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JsonUtils<T> {

    public String parseString(Object object){
        ObjectMapper mapper = new ObjectMapper();

        try{
            return mapper.writeValueAsString(object);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }

    }

    public List<T> parseObject(String string, Class<T> clazz){
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);

        try{
            return mapper.readValue(string,javaType);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
