package com.tastecamp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tastecamp.api.dto.CarDTO;
import com.tastecamp.api.model.Car;
import com.tastecamp.api.repository.CarRepository;

@RestController
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarRepository repository;

    @GetMapping
    private List<Car> listAll() {
        return repository.findAll();
    }

    @PostMapping
    public void create(@RequestBody CarDTO req) {
        repository.save(new Car (req));
    }
}
