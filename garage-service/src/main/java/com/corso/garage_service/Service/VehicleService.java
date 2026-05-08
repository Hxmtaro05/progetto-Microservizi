package com.corso.garage_service.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class VehicleService {
    public Vehicle addVehicle(Long garageId, Vehicle v) {
        if (!validator.exists(v.getVehicleType(), v.getExternalId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Vehicle " + v.getVehicleType() + ":" + v.getExternalId() + " does not exist");
        }
        Garage garage = GarageRepository.garageRepository.findById(garageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        v.setGarage(garage);
        return vehicleRepository.save(v);
    }
}
