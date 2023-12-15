package com.edu.shop_online.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.shop_online.dao.ProductDao;
import com.edu.shop_online.dto.ResultVo;
import com.edu.shop_online.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    //查询商品列表
    public IPage<Product> queryGoodList(String category_id, String product_name,
                               Integer pageIndex, Integer pageSize) {
        if (Objects.equals(category_id, "0")){
            IPage<Product> page = new Page<>(pageIndex,pageSize);
            productDao.selectPage(page, null);
            return page;
        }
        //创建分页对象
        IPage<Product> page = new Page<>(pageIndex,pageSize);
        QueryWrapper<Product> qw = new QueryWrapper<>();

        qw.eq(category_id!=null&&""!=category_id,"category_id",category_id);
        qw.like(product_name!=null&&""!=product_name,"product_name",product_name);

        productDao.selectPage(page, qw);

        return page;
    }
    //查询商品详情
    public Product queryById(Integer product_id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("product_id",product_id);
        return productDao.selectOne(queryWrapper);
//        return productDao.selectById(product_id);
    }
    //添加商品




}
