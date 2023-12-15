package com.edu.shop_online.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  @TableId("product_id")
  private Integer product_id;
  private String product_name;
  private String product_title;
  private String product_intro;
  private String product_picture;
  private double product_price;
  private double product_selling_price;
  private Integer product_num;
  private Integer product_sales;
//  @TableField(exist = false)
  private Integer category_id;

}
