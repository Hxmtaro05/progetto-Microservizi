package com.corso.moto.controller;

import java.util.List;
import com.corso.moto.entity.Bike;
import com.corso.moto.service.BikeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bikes")

public class BikeCotroller {
    private final BikeService bikeService;

    public BikeCotroller(BikeService bikeService) {this.bikeService = bikeService;}

    @GetMapping
    public List<Bike> getBikes() { return bikeService.getAllBikes();}

    @GetMapping("/id")
    public ResponseEntity<Bike> getById(@PathVariable Long id){
        return bikeService.getBikeById(id)
                .map(ResponseEntity::ok)
                //map trasforma bike in 200 ok + json
                //orElse: restituisce 404 not found
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Bike> createBike(@RequestBody @Valid Bike bike){
        return ResponseEntity.status(201).body(bikeService.saveBike(bike));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bike> updateBike(@PathVariable Long id, @RequestBody Bike bike){
        return ResponseEntity.ok(bikeService.updateBike(id, bike));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBike(@PathVariable Long id){
        bikeService.deleteBike(id);
        return ResponseEntity.noContent().build();
    }

}
