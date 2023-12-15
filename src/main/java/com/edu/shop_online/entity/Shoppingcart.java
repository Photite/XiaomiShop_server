package com.edu.shop_online.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shoppingcart {
  @TableId(type = IdType.AUTO)
  private Integer id;
  private Integer user_id;
  private Integer product_id;
  private Integer num;
  @TableField(exist = false)
  private Product product;
  public Shoppingcart(Integer user_id, Integer product_id, Integer num) {
    this.user_id = user_id;
    this.product_id = product_id;
    this.num = num;
  }

  public Shoppingcart(Integer user_id, Integer product_id) {
    this.user_id = user_id;
    this.product_id = product_id;
  }
}
