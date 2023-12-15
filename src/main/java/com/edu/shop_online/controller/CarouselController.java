package com.edu.shop_online.controller;


import com.edu.shop_online.entity.Carousel;
import com.edu.shop_online.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
//@CrossOrigin(origins = "http://192.168.153.212:5173")
@RestController
public class CarouselController {
    @Autowired
    private CarouselService service;

    @GetMapping("/carousel/list")
    public List<Carousel> getCarouselData() {
        List<Carousel> list = service.getCarouselData();
        return list;
    }
}
