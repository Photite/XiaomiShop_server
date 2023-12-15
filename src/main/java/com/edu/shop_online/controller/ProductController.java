package com.edu.shop_online.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.edu.shop_online.dto.ResultVo;
import com.edu.shop_online.entity.Product;
import com.edu.shop_online.entity.User;
import com.edu.shop_online.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
//@CrossOrigin(origins = "http://192.168.153.212:5173")
@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    //查询商品列表
    @GetMapping("/product/search")
    public ResultVo<Product> queryGoods(String category_id, String product_name,
                                        Integer pageIndex, Integer pageSize) {

        IPage<Product> page = service.queryGoodList(category_id, product_name, pageIndex, pageSize);
        List<Product> list = page.getRecords();
        list.forEach(System.out::println);
//        Integer count = Math.toIntExact(page.getTotal());
        Integer count = (int)page.getTotal();
        ResultVo<Product> rv = new ResultVo<>("商品信息", true, pageIndex, pageSize, list,count);
        return rv;
    }

    @GetMapping("/product/one")
    public ResultVo<Product> queryById(@RequestParam Integer product_id) {
        Product product = service.queryById(product_id);
//        List<Product> product = (List<Product>) service.queryById(product_id);
        if (product != null) {
            ResultVo<Product> vo = new ResultVo<>("商品详情", true, product);
            return vo;
        } else {
            ResultVo<Product> vo = new ResultVo<>("商品详情", false, null);
            return vo;
        }
    }
    //根据id查询商品信息


}

