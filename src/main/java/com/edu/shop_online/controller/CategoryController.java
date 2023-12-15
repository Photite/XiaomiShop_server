package com.edu.shop_online.controller;

import com.edu.shop_online.dao.CategoryDao;
import com.edu.shop_online.dto.ResultVo;
import com.edu.shop_online.entity.Carousel;
import com.edu.shop_online.entity.Category;
import com.edu.shop_online.entity.Photo;
import com.edu.shop_online.service.CategoryService;
import com.edu.shop_online.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/all")
    public List<Category> getCategoryData() {
        List<Category> list = categoryService.queryAllCategory();
        return list;
    }
}
