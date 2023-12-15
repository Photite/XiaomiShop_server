package com.edu.shop_online.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.shop_online.dao.OrdersDao;
import com.edu.shop_online.entity.Orders;
import com.edu.shop_online.entity.Product;
import com.edu.shop_online.entity.Shoppingcart;
import com.edu.shop_online.utils.DateUtils;
import com.edu.shop_online.utils.JsonUtils;
import com.edu.shop_online.utils.OrderNoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrderNoUtils orderNoUtils;
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private JsonUtils jsonUtils;
    @Autowired
    private DateUtils dateUtils;

    public boolean addOrder(String uid, List<Shoppingcart> productList,double totalPrice){
        Orders orders = new Orders();
        orders.setUid(Integer.valueOf(uid));
        orders.setOid(orderNoUtils.createOrderNo());
        orders.setList(productList);
        orders.setTotalPrice(totalPrice);
        //将集合转为字符串
        String products = jsonUtils.parseString(productList);
        //给orders中的products赋值
        orders.setProducts(products);
        orders.setCreateTime(dateUtils.getDate());
        return ordersDao.insert(orders)>0?true:false;
    }

    public List<Orders> queryOrders(String uid){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("uid",uid);
        List<Orders> list = ordersDao.selectList(queryWrapper);
        //遍历订单信息--》给订单实体的属性赋值
        for (Orders orders: list) {
            String products = orders.getProducts();
            List<Shoppingcart> shoppingcartList = jsonUtils.parseObject(products,Shoppingcart.class);
            orders.setList(shoppingcartList);
        }
        return list;
    }
}
