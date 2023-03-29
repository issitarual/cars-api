package com.tastecamp.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tastecamp.api.dto.CarDTO;
import com.tastecamp.api.model.Car;
import com.tastecamp.api.repository.CarRepository;

import jakarta.validation.Valid;

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
    public void create(@RequestBody @Valid CarDTO req) {
        repository.save(new Car (req));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> update(
        @PathVariable Long id,
        @RequestBody @Valid CarDTO req
    ) {
        Optional<Car> carData =repository.findById(id);

    if (carData.isPresent()) {
      Car _car = carData.get();
      _car.setModelo(req.modelo());
      _car.setFabricante(req.fabricante());
      _car.setDataFabricacao(req.dataFabricacao());
      _car.setValor(req.valor());
      _car.setAnoModelo(req.anoModelo());
      return new ResponseEntity<>(repository.save(_car), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
