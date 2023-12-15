package com.edu.shop_online.service;

import com.edu.shop_online.dao.CarouselDao;
import com.edu.shop_online.entity.Carousel;
import com.edu.shop_online.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CarouselService {
    @Autowired
    private JsonUtils<Carousel> jsonUtils;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    private CarouselDao carouselDao;

    public List<Carousel> getCarouselData() {
        List<Carousel> list = null;

        String images = redisTemplate.boundValueOps("indexImages").get();
        if (images != null) {
                list = jsonUtils.parseObject(images, Carousel.class);
        } else {
            //redis没有-->去数据库中查询--->存储到redis中
            list = carouselDao.selectList(null);
            //向redis中存储-->将集合转换成字符串  json解析
            redisTemplate.boundValueOps("indexImages").set(jsonUtils.parseString(list));
            //设置缓存的生存时间
            redisTemplate.expire("indexImages", 7, TimeUnit.DAYS);
        }

        return list;
    }

}
