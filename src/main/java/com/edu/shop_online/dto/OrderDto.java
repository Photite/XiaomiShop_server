package com.edu.shop_online.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    /**
     * 商户订单号，必填
     */
    private String orderNo;
    /**
     * 订单名称，必填
     */
    private String orderName;
    /**
     * 付款金额，必填
     * 根据支付宝接口协议，必须使用下划线
     */
    private String totalPrice;
    /**
     * 商品描述，可空
     */
}
