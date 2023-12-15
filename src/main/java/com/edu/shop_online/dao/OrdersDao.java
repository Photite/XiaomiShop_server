package com.edu.shop_online.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.shop_online.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersDao extends BaseMapper<Orders> {
}
