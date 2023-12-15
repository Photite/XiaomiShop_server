package com.edu.shop_online.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.shop_online.dao.UserDao;
import com.edu.shop_online.dto.UserDTO;
import com.edu.shop_online.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private StringRedisTemplate redisTemplate;
    //用户登录
    public UserDTO login(String username, String password) {
        String pwd  = DigestUtils.md5Hex(password+username);
        // 使用QueryWrapper构建查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", username).eq("password", pwd);
        // 调用UserDao的selectOne方法来进行用户登录验证
        User user = userDao.selectOne(queryWrapper);
        if (user!=null){
            return new UserDTO(user.getId(),user.getName());
        }
        return null;
    }
    public User findByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", username);
        return userDao.selectOne(queryWrapper);
    }
    //用户注册
    public boolean Register(String username,String password){
        String pwd = DigestUtils.md5Hex(password+username);
        int i = userDao.insert(new User(username,pwd));
        if(i>0){
            return true;
        }
        return false;
    }
    public void saveToken(String token){
        redisTemplate.boundValueOps("userToken").set(token);
        redisTemplate.expire("userToken",7, TimeUnit.DAYS);
    }
}
