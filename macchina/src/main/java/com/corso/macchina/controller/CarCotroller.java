package com.corso.macchina.controller;

import java.util.List;
import com.corso.macchina.entity.Car;
import com.corso.macchina.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")

public class CarCotroller {
    private final CarService carService;

    public CarCotroller(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCars() { return carService.getAllCars();}

    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable Long id){
        return carService.getCarById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody @Valid Car car){
        return ResponseEntity.status(201).body(carService.saveCar(car));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car){
        return ResponseEntity.ok(carService.updateCar(id, car));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

}
