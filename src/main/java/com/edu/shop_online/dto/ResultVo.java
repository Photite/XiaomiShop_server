package com.edu.shop_online.dto;

import com.edu.shop_online.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo<T> {
    private String message;
    private boolean success;
    private Integer pageIndex;
    private Integer pageSize;
//    private List<T> data;
    private Object data;
    private Integer count;//总记录数
    private String token;

    public ResultVo(String message, boolean success, Object data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public ResultVo(String message, boolean success, UserDTO data, String token) {
        this.message = message;
        this.success = success;
        this.data = data;
        this.token = token;
    }

    public ResultVo(String message, boolean success, Integer pageIndex, Integer pageSize, List<Product> data, Integer count) {
        this.message = message;
        this.success = success;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.data = data;
        this.count = count;
    }


    public ResultVo(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
