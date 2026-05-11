package com.corso.garage_service.Service;

import com.corso.garage_service.Entity.Garage;
import com.corso.garage_service.Entity.Vehicle;
import com.corso.garage_service.Repository.GarageRepository;
import com.corso.garage_service.Repository.VehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final GarageRepository garageRepository;
    private final VehicleValidator validator;

    public VehicleService(
            VehicleRepository vehicleRepository,
            GarageRepository garageRepository,
            VehicleValidator validator) {

        this.vehicleRepository = vehicleRepository;
        this.garageRepository = garageRepository;
        this.validator = validator;
    }

    public Vehicle addVehicle(Long garageId, Vehicle vehicle) {

        boolean exists = validator.exists(
                vehicle.getVehicleType(),
                vehicle.getExternalId()
        );

        if (!exists) {
            throw new RuntimeException("Vehicle does not exist");
        }

        Garage garage = garageRepository.findById(garageId)
                .orElseThrow(() -> new RuntimeException("Garage not found"));

        vehicle.setGarage(garage);

        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long vehicleId) {

        vehicleRepository.deleteById(vehicleId);
    }
}
