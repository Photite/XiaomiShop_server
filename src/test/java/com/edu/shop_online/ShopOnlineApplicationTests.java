package com.edu.shop_online;

import com.edu.shop_online.entity.Product;
import com.edu.shop_online.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import com.edu.shop_online.service.ProductService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class ShopOnlineApplicationTests {
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Autowired
//    private ProductService ps;
//
//    @Test
//    void contextLoads() {
//        IPage<Product> page = ps.queryGoodList("1", "小米10", 1, 5);
//        System.out.println(page.getRecords());
//    }
//
//    @Test
//    void stringTest() {
//        //获取对象
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        //设置值
//        valueOperations.set("name", "张三");
//        //获取值
//        String name = (String) valueOperations.get("name");
//        System.out.println(name);
//
//        //设置值并设置过期时间
//        valueOperations.set("age", "18", 10, TimeUnit.SECONDS);
//        //获取值
//        String age = (String) valueOperations.get("age");
//        System.out.println(age);
//    }
//
//    @Test
//    void HashTest() {
//        //获取对象
//        HashOperations hashOperations = redisTemplate.opsForHash();
//
////        //设置值
////        hashOperations.put("user", "name", "张三");
////        hashOperations.put("user", "age", "18");
////        //获取值
////        String name =(String) hashOperations.get("user", "name");
////        System.out.println(name);
////        String age =(String) hashOperations.get("user", "age");
////        System.out.println(age);
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "李四");
//        map.put("age", "20");
//        //设置值
//        hashOperations.putAll("user", map);
//        //获取值
//        Map<String, String> user = hashOperations.entries("user");
//        Set<String> keys = user.keySet();
//        for (String key : keys) {
//            System.out.println(key + ":" + user.get(key));
//        }
//        //获取指定对象的所有的key
////        Set keys = hashOperations.keys("user");
////        for (Object key : keys) {
////            System.out.println(key + ":" + hashOperations.get("user", key));
////        }
////        hashOperations.values("user").forEach(System.out::println);
//        //获取指定对象的所有的value
////        List values = hashOperations.values("user");
////        for (Object value : values) {
////            System.out.println(value);
////        }
//        //存储对象
//        User user01 = new User(1, "张三");
//        Map<String, Object> map01 = new HashMap<>();
//        map01.put("name", user01.getName());
//        hashOperations.putAll("user01", map01);
//        //获取对象
//        Map<String, String> user02 = hashOperations.entries("user01");
//        Set<String> keys01 = user02.keySet();
//        for (String key : keys01) {
//            System.out.println(key + ":" + user02.get(key));
//            System.out.println(user02.get(key));
//        }
//
//
//    }
//
//    @Test
//    public void testList() {
//        ListOperations listOperations = redisTemplate.opsForList();
//        //存储数据
//        listOperations.leftPush("list", "张三");
//        listOperations.leftPush("list", "李四");
//        listOperations.leftPush("list", "王五");
//        //获取数据
//        //List list = listOperations.range("list", 0, -1);
//        List list = listOperations.range("list", 2, 2);
//        for (Object o : list) {
//            System.out.println(o);
//        }
////        listOperations.indexOf("list", "王五");
//
//    }
//
//    @Test
//    public void testSet() {
//        //获取对象
//        SetOperations setOperations = redisTemplate.opsForSet();
//        //值不能相同，无序
//        //存储数据
//        setOperations.add("set", "张三");
//        setOperations.add("set", "李四");
//
//        //获取数据
//        Set set = setOperations.members("set");
//        for (Object o : set) {
//            System.out.println(o);
//        }
//    }
//
//    @Test
//    public void testZSet() {
//        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
//        //添加数据
//        zSetOperations.add("demo", "12", 10);
//        zSetOperations.add("demo", "23", 8);
//        zSetOperations.add("demo", "34", 18);
//        Set demo = zSetOperations.range("demo", 0, -1);
//        demo.forEach(System.out::println);
//    }
}
