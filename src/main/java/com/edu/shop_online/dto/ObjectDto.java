package com.edu.shop_online.dto;


import com.edu.shop_online.entity.Shoppingcart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectDto {
    private String user_id;
    private Shoppingcart[] products;
    private double totalPrice;
}

