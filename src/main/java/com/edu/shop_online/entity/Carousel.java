package com.edu.shop_online.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carousel {
  @TableId("carouselid")
  private Integer carouselid;
  private String imgpath;
  private String describes;
}
