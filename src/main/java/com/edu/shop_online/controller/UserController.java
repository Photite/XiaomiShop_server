package com.edu.shop_online.controller;

import com.edu.shop_online.dto.ResultVo;
import com.edu.shop_online.dto.UserDTO;
import com.edu.shop_online.entity.User;
import com.edu.shop_online.service.UserService;
import com.edu.shop_online.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
//@CrossOrigin(origins = "http://192.168.153.212:5173")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private TokenUtils tokenUtils;

    @PostMapping("/login")
    public ResultVo<UserDTO>  login(@RequestBody User object) {
        // 调用UserService的方法获取用户信息
        UserDTO user = service.login(object.getName(), object.getPassword()); // 请替换成实际的获取用户信息的方法
        ResultVo<UserDTO> vo = null;
        if (user != null) {
            //登录成功
            /**
             * 1.生成一个token  字符串  比较长，随机
             * */
            String token = tokenUtils.createToken(object.getId()+"",object.getName());
            //将token保存到redis
            service.saveToken(token);
            vo = new ResultVo<>("登录成功",true,user,token);
        }else {
            vo = new ResultVo<>("账号或者密码错误",false,null);
        }
        return vo;
    }

    @GetMapping("/checkUserName")
    public ResultVo<User> checkUserName(@RequestParam String name) {
        // 根据用户名检查是否存在，这里假设 username 不存在
        User user = service.findByUsername(name);
        System.out.println(user);
        ResultVo<User> vo = null;
        if(user!=null){
            //重复了
            vo = new ResultVo<>("用户名重复了",true,null);
        }else{
            //可以注册
            vo = new ResultVo<>("用户名不重复",false,null);
        }
        return vo;

    }

    //用户注册
    @PostMapping("/register")
    public ResultVo<User> Register(@RequestBody User object) {
        boolean flag = service.Register(object.getName(), object.getPassword());
        ResultVo<User> vo = null;
        if (flag) {
            //注册成功
            vo = new ResultVo<>("注册成功",true,null);
        } else {
            //注册成功
            vo = new ResultVo<>("用户信息注册失败",false,null);
        }
        return vo;
    }

}
