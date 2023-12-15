package com.edu.shop_online.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TokenUtils {
    //生成token的方法
    public String createToken(String uid,String name){
        // uid+pwd+uuid+当前时间==>md5
        UUID uuid = UUID.randomUUID();
        long now = System.currentTimeMillis();
        String token = uid+name+uuid+now;
        return token;
    }
}
