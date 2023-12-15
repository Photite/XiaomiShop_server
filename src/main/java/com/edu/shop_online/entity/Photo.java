package com.edu.shop_online.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
  @TableId("id")
  private Integer id;
  private String name;
  private Integer pid;


}
