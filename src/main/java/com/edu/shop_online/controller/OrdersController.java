package com.edu.shop_online.controller;

import com.edu.shop_online.dto.ObjectDto;
import com.edu.shop_online.dto.ResultVo;
import com.edu.shop_online.entity.Orders;
import com.edu.shop_online.entity.Shoppingcart;
import com.edu.shop_online.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/order/addOrder")
    public ResultVo addOrders(@RequestBody ObjectDto objectDto){
        Shoppingcart[] products = objectDto.getProducts();
        //将数组转换为集合
        List<Shoppingcart> shopCartList = Arrays.asList(products);
        boolean flag = ordersService.addOrder(objectDto.getUser_id(),shopCartList,objectDto.getTotalPrice());
        ResultVo vo = new ResultVo();
        if(flag){
            vo = new ResultVo("订单生成成功",true,null);
        }else{
            vo = new ResultVo("订单生成失败",false,null);
        }
        return vo;
    }

    @GetMapping("/order/getUserOrder")
    public ResultVo queryOrders(String user_id){
        List<Orders> orders = ordersService.queryOrders(user_id);
        Collections.sort(orders, new Comparator<Orders>() {
            @Override
            public int compare(Orders o1, Orders o2) {
                // 比较下单日期和时间
                int dateComparison = o2.getCreateTime().compareTo(o1.getCreateTime());
                if (dateComparison != 0) {
                    return dateComparison;
                } else {
                    // 如果日期相同，比较具体时间
                    return o2.getCreateTime().compareTo(o1.getCreateTime());
                }
            }
        });
        return new ResultVo("用户订单",true,orders);
    }
}

