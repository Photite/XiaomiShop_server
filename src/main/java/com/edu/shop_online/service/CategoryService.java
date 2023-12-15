package com.edu.shop_online.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.shop_online.dao.CategoryDao;
import com.edu.shop_online.dao.PhotoDao;
import com.edu.shop_online.entity.Category;
import com.edu.shop_online.entity.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public List<Category> queryAllCategory(){

        return categoryDao.selectList(null);
    }
}
