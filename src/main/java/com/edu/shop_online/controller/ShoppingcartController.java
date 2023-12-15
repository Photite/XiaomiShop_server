package com.edu.shop_online.controller;


import com.edu.shop_online.dto.ResultVo;
import com.edu.shop_online.dto.ShopCartDTO;
import com.edu.shop_online.entity.Shoppingcart;
import com.edu.shop_online.service.ShoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ShoppingcartController {
    @Autowired
    private ShoppingcartService service;

    @GetMapping("/shoppingcart/list")
    public ResultVo<Shoppingcart> queryShopCartList(String user_id) {
        List<Shoppingcart> shopCartList = service.queryShopCartByUserId(user_id);
        ResultVo<Shoppingcart> vo = new ResultVo<>("购物车信息", true, shopCartList);
        return vo;
    }

    @PutMapping("/shoppingcart/update")
    public ResultVo<Shoppingcart> updateShopCart(@RequestBody ShopCartDTO shopCartDto) {
        boolean flag = service.updateShopCart(shopCartDto.getUser_id(), shopCartDto.getProduct_id());
        ResultVo<Shoppingcart> vo = null;
        if (flag) {
            //购物车更新成功
            vo = new ResultVo<>("购物车更新成功", true, null);
        } else {
            vo = new ResultVo<>("购物车更新失败", false, null);
        }
        return vo;
    }

    @PutMapping("/shoppingcart/updateNum")
    public ResultVo<Shoppingcart> updateShopCart(@RequestBody Map<String, String> map) {
        //获取三个参数
        String userId = map.get("user_id");
        String product_id = map.get("product_id");
        String num = map.get("num");
        boolean flag = service.updateShopCart(userId, product_id, Integer.valueOf(num));
        ResultVo<Shoppingcart> vo = null;
        if (flag) {
            //购物车更新成功
            vo = new ResultVo<>("购物车更新成功", true, null);
        } else {
            vo = new ResultVo<>("购物车更新失败", false, null);
        }
        return vo;
    }

    @PostMapping("/shoppingcart/add")
    public ResultVo<Shoppingcart> addShopCart(@RequestBody ShopCartDTO shopCartDto) {
        //System.out.println(params);
        boolean flag = service.addShopCart(shopCartDto.getUser_id(), shopCartDto.getProduct_id());
        ResultVo<Shoppingcart> vo = null;
        if (flag) {
            //购物车更新成功
            vo = new ResultVo<>("添加购物车成功", true, null);
        } else {
            vo = new ResultVo<>("添加购物车失败", false, null);
        }
        return vo;
    }

    @GetMapping("/shoppingcart/one")
    public ResultVo<Shoppingcart> checkShopCart(String user_id, String product_id) {
        Shoppingcart shopCart = service.queryShopCartByPidAndUid(user_id, product_id);
        ResultVo vo = null;
        if (shopCart != null) {
            //该商品在购物车中
            vo = new ResultVo<>("该商品在购物车中", true, null);
        } else {
            //该商品不在购物车中
            vo = new ResultVo<>("该商品不在购物车中", false, null);
        }
        return vo;
    }

    @DeleteMapping("/shoppingcart/delete")
    public ResultVo<Shoppingcart> deleteShopCart(ShopCartDTO shopCartDto) {
        boolean flag = service.deleteShopCart(shopCartDto.getUser_id(), shopCartDto.getProduct_id());
        return flag ? new ResultVo<>("购物车商品删除成功", true, null) :
                new ResultVo<>("购物车商品删除失败", false, null);
    }

    @GetMapping("/shopcart/deleteBatch")
    public boolean deleteShopCartByIds(String uid,String pids){
        boolean b = service.deleteShopCartByIds(uid, pids);
        return b;

    }
}
