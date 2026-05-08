package com.corso.moto.service;

import com.corso.moto.entity.Bike;
import com.corso.moto.repository.BikeRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//dice a Spring di considerare quest'area come un servizio
public class BikeService {

    private final BikeRepository bikeRepo;
    public BikeService(BikeRepository bikeRepo) {this.bikeRepo=bikeRepo;}

    public List <Bike> getAllBikes(){
        return bikeRepo.findAll();
    }

    public Optional<Bike> getBikeById(Long id) {
        return bikeRepo.findById(id);
    }

    public Bike saveBike(Bike bike){
        return bikeRepo.save(bike);
    }

    public void deleteBike(Long id){
        bikeRepo.deleteById(id);
    }

    public Bike updateBike(Long id,Bike updateBike){
        return bikeRepo.findById(id)
                .map(existingBike -> {
                    existingBike.setBrand(updateBike.getBrand());
                    existingBike.setModel(updateBike.getModel());
                    existingBike.setEngineCC(updateBike.getEngineCC());
                    existingBike.setType(updateBike.getType());
                    existingBike.setYear(updateBike.getYear());
                    existingBike.setPrice(updateBike.getPrice());
                    return bikeRepo.save(existingBike);
                })
                .orElseThrow(() -> new RuntimeException("Bike not found: " + id));
    }
}
