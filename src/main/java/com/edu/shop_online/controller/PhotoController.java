package com.edu.shop_online.controller;

import com.edu.shop_online.dto.ResultVo;
import com.edu.shop_online.entity.Photo;
import com.edu.shop_online.entity.Product;
import com.edu.shop_online.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @GetMapping("/product/getAllPicture")
    public ResultVo<Photo> queryById(Integer product_id) {
        List<Photo> photoList = photoService.queryAllPic(product_id);
        System.out.println(photoList);
        if (!photoList.isEmpty()){
            ResultVo<Photo> vo = new ResultVo<>("商品图片",true,photoList);
            return vo;
        }else {
            ResultVo<Photo> vo = new ResultVo<>("商品图片",false, null);
            return vo;
        }
    }
}
