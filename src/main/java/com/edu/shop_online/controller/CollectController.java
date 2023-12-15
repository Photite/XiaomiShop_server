package com.edu.shop_online.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.edu.shop_online.dto.ResultVo;
import com.edu.shop_online.entity.Collect;
import com.edu.shop_online.entity.Product;
import com.edu.shop_online.service.CollectService;
import com.edu.shop_online.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
//@CrossOrigin(origins = "http://192.168.153.212:5173")
@RestController
public class CollectController {
    @Autowired
    private CollectService collectService;
    @Autowired
    private ProductService productService;

    @GetMapping("/collect/getUserCollect")
    public ResultVo<Collect> getUserCollect(String user_id) {
        List<Collect> list = collectService.getUserCollect(Integer.valueOf(user_id));
        List<Product> list1 = new ArrayList<>();
        for (Collect collect:list) {
            Product product = productService.queryById(collect.getProduct_id());
            list1.add(product);
        }
        ResultVo<Collect> rv = new ResultVo<>("商品信息", true,list1);
        return rv;
    }

    @PostMapping("/collect/add")
    public ResultVo<Collect> addUserCollect(@RequestBody Collect collect) {
        boolean b = collectService.addCollect(collect.getUser_id(),collect.getProduct_id());
        ResultVo<Collect> rv = null;
        if (b){
            rv = new ResultVo<>("加入收藏成功", true);

        }else {
            rv = new ResultVo<>("加入收藏失败", false);
        }
        return rv;
    }

    @PostMapping("/collect/one")
    public ResultVo<Collect> queryCollect(@RequestBody Collect collect) {
        boolean b = collectService.queryCollect(collect.getUser_id(),collect.getProduct_id());
        ResultVo<Collect> rv = null;
        if (b){
            rv = new ResultVo<>("已经收藏了该商品", false);

        }else {
            rv = new ResultVo<>("加入收藏成功", true);
        }
        return rv;
    }
    @PostMapping("/collect/del")
    public ResultVo<Collect> delCollect(@RequestBody Collect collect){
        boolean b = collectService.delCollect(collect.getUser_id(),collect.getProduct_id());
        ResultVo<Collect> rv = null;
        if (b){
            rv = new ResultVo<>("取消收藏成功", true);

        }else {
            rv = new ResultVo<>("取消收藏失败", false);
        }
        return rv;
    }
}
