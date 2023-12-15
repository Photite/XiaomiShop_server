package com.edu.shop_online.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collect {
  @TableId(type = IdType.AUTO)
  private Integer id;
  private Integer user_id;
  private Integer product_id;

}
