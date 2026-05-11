package com.corso.garage_service.Service;

import com.corso.garage_service.Entity.Garage;
import com.corso.garage_service.Entity.Vehicle;
import com.corso.garage_service.Repository.VehicleRepository;
import com.corso.garage_service.Repository.GarageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService {


    private final GarageRepository garageRepository;

    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public List<Garage> getAll() {
        return garageRepository.findAll();
    }

    public Garage save(Garage garage) {
        return garageRepository.save(garage);
    }
}
