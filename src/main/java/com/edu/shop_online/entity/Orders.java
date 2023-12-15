package com.edu.shop_online.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private String oid;
    private String products;
    private Integer uid;
    //添加一个临时对象-->商品集合
    @TableField(exist = false)
    private List<Shoppingcart> list;
    private String createTime;
    private double totalPrice;

    public Orders(String oid, String products, Integer uid) {
        this.oid = oid;
        this.products = products;
        this.uid = uid;
    }
}
