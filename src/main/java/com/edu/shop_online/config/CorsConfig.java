package com.edu.shop_online.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import java.util.Arrays;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:5173")
////                .allowedOrigins("http://192.168.153.212:5173")
//                .allowedMethods("GET", "POST")
//                .allowedHeaders("X-Custom-Header");
//    }
//
//    @Bean
//    public Filter corsFilter() {
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
////        config.setAllowedOrigins(Arrays.asList("http://192.168.153.212:5173"));
//        config.setAllowedMethods(Arrays.asList("GET", "POST"));
//        config.setAllowedHeaders(Arrays.asList("X-Custom-Header"));
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/api/**", config);
//
//        return new CorsFilter(source);
//    }
}
