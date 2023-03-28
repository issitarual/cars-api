package com.tastecamp.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tastecamp.dto.CarDTO;

@RestController
@RequestMapping("/cars")
public class CarsController {

    @PostMapping
    public void create(@RequestBody CarDTO req) {
        System.out.println(req);
    }
}
