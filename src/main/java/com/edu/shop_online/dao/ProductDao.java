package com.edu.shop_online.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.shop_online.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao extends BaseMapper<Product> {

}
