package com.edu.shop_online.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.shop_online.dao.CategoryDao;
import com.edu.shop_online.dao.CollectDao;
import com.edu.shop_online.dao.ProductDao;
import com.edu.shop_online.entity.Category;
import com.edu.shop_online.entity.Collect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectService {
    @Autowired
    private CollectDao collectDao;

    public List<Collect> getUserCollect(Integer uid){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",uid);
        return collectDao.selectList(queryWrapper);
    }
    public boolean addCollect(Integer uid,Integer pid){
        Collect collect = new Collect(null,uid,pid);
        int i = collectDao.insert(collect);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    public boolean delCollect(Integer uid,Integer pid){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",uid);
        queryWrapper.eq("product_id",pid);
        Collect collect = collectDao.selectOne(queryWrapper);

        int i = collectDao.deleteById(collect.getId());
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    public boolean queryCollect(Integer uid,Integer pid){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",uid);
        queryWrapper.eq("product_id",pid);
        Collect collect = collectDao.selectOne(queryWrapper);
        if (collect == null){
            return false;
        }else{
            return true;
        }
    }
}
