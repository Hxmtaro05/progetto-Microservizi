package com.corso.garage_service.Controller;

import com.corso.garage_service.Entity.Garage;
import com.corso.garage_service.Entity.Vehicle;
import com.corso.garage_service.Service.GarageService;
import com.corso.garage_service.Service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garages")
@CrossOrigin("*")
public class garageController {

    private final GarageService garageService;
    private final VehicleService vehicleService;

    public garageController(
            GarageService garageService,
            VehicleService vehicleService) {
        this.garageService = garageService;
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Garage> getGarages() {
        return garageService.getAll();
    }

    @PostMapping
    public Garage createGarage(@RequestBody Garage garage) {
        return garageService.save(garage);
    }

    @PostMapping("/{garageId}/vehicles")
    public Vehicle addVehicle(
            @PathVariable Long garageId,
            @RequestBody Vehicle vehicle) {

        return vehicleService.addVehicle(garageId,vehicle);
    }
}
