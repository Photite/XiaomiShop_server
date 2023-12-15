package com.edu.shop_online.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.shop_online.dao.ShoppingcartDao;
import com.edu.shop_online.entity.Product;
import com.edu.shop_online.entity.Shoppingcart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ShoppingcartService {

    @Autowired
    private ShoppingcartDao shoppingcartDao;
    @Autowired
    private ProductService productService;

    public List<Shoppingcart> queryShopCartByUserId(String uid){
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id",uid);
        List<Shoppingcart> shopCartList = shoppingcartDao.selectList(qw);
        for (Shoppingcart Shoppingcart : shopCartList) {
            Product product =  productService.queryById(Shoppingcart.getProduct_id());
            Shoppingcart.setProduct(product);
        }
        //select *from product where product_id in()
        return shopCartList;
    }

    public boolean addShopCart (String uid,String pid){
        Shoppingcart shoppingcart = new Shoppingcart(Integer.valueOf(uid),Integer.valueOf(pid));
        Product product = productService.queryById(shoppingcart.getProduct_id());
        shoppingcart.setProduct(product);
        shoppingcart.setNum(1);
        int i = shoppingcartDao.insert(shoppingcart);
        return i > 0;
    }

    public boolean updateShopCart (String uid,String pid,int num){
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id",uid);
        qw.eq("product_id",pid);
        Shoppingcart shoppingcart = queryShopCartByPidAndUid(uid,pid);
        shoppingcart.setNum(num);
        int i = shoppingcartDao.update(shoppingcart,qw);
        return i>0?true:false;

  //      Shoppingcart shoppingcart = new Shoppingcart(Integer.valueOf(uid),Integer.valueOf(pid),Integer.valueOf(num));
//        Shoppingcart shoppingcart = shoppingcartDao.selectOne(qw);
//        shoppingcart.setNum(Integer.valueOf(num));
//        int i = shoppingcartDao.updateById(shoppingcart);
//        return i > 0;
//        int i = shoppingcartDao.update(shoppingcart,qw);
//        return i > 0;
    }

    public boolean updateShopCart(String uid,String pid){
        // set num = xxx where pid = xxx and uid = ##
        QueryWrapper qw = new QueryWrapper();
        qw.eq("product_id",pid);
        qw.eq("user_id",uid);
        //根据用户id商品id查询购物车信息
        Shoppingcart shopCart = queryShopCartByPidAndUid(uid,pid);
        shopCart.setNum(shopCart.getNum()+1);
        int i = shoppingcartDao.update(shopCart,qw);
        return i>0?true:false;
    }
//    public Shoppingcart queryshoppingcartByPidAndUid(String pid,String uid){
//        QueryWrapper qw = new QueryWrapper();
//        qw.eq("user_id",uid);
//        qw.eq("product_id",pid);
//        return shoppingcartDao.selectOne(qw);
//    }

    public List<Shoppingcart>queryshoppingcartList(Integer id){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",id);
        return shoppingcartDao.selectList(queryWrapper);
    }

    public Shoppingcart queryshoppingcartOne(Integer id,Integer pid){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",id);
        queryWrapper.eq("product_id",pid);
        return shoppingcartDao.selectOne(queryWrapper);
    }
    //根据uid,pid查询购物车信息-->查询某个商品是否在购物车中
    public Shoppingcart queryShopCartByPidAndUid(String uid,String pid){
        QueryWrapper qw = new QueryWrapper();
        qw.eq("product_id",pid);
        qw.eq("user_id",uid);
        return shoppingcartDao.selectOne(qw);
    }
    //通过uid，pid删除购物车中商品
    public boolean deleteShopCart(String uid,String pid){
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id",uid);
        qw.eq("product_id",pid);
        int i = shoppingcartDao.delete(qw);
        return i>0?true:false;
    }
    public boolean deleteShopCartByIds(String uid,String pids){
        QueryWrapper qw = new QueryWrapper();
        String[] arr = pids.split(",");
        qw.eq("user_id",uid);
        qw.in("product_id",arr);
        int i = shoppingcartDao.delete(qw);
        return i>0?true:false;
    }

}
