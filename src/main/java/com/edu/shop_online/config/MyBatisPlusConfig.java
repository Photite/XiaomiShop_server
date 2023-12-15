package com.edu.shop_online.config;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor myInterceptor = new MybatisPlusInterceptor();
        myInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        new PaginationInnerInterceptor() {
            @Override
            protected void handlerOverflow(IPage<?> page) {
                //原来的逻辑是超出范围返回第一页
                //page.setCurrent(1L);
                //修改成返回最后一页
                page.setCurrent(page.getPages());
            }

        };

        return myInterceptor;
    }
}
