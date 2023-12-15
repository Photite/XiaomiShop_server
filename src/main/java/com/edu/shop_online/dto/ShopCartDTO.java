package com.edu.shop_online.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopCartDTO {

    private String user_id;
    private String product_id;
    private double salePrice;
    private String pname;
    private String picImage;
    private Integer num;
}
