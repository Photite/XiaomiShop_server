package com.edu.shop_online.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.shop_online.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
