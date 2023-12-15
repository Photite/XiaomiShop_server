package com.edu.shop_online.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.shop_online.dao.PhotoDao;
import com.edu.shop_online.dao.ProductDao;
import com.edu.shop_online.dto.ResultVo;
import com.edu.shop_online.entity.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {
    //根据id查询对应图片
    @Autowired
    private PhotoDao photoDao;

    public List<Photo> queryAllPic(Integer pid){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("pid",pid);
        return photoDao.selectList(queryWrapper);
    }
}
