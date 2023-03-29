package com.tastecamp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tastecamp.api.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
    
}
