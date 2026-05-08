package com.corso.macchina.service;

import com.corso.macchina.entity.Car;
import com.corso.macchina.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//dice a Spring di considerare quest'area come un servizio
public class CarService {

    private final CarRepository carRepo;
    public CarService(CarRepository carRepo) {this.carRepo=carRepo;}

    public List <Car> getAllCars(){
        return carRepo.findAll();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepo.findById(id);
    }

    public Car saveCar(Car car){
        return carRepo.save(car);
    }

    public void deleteCar(Long id){
        carRepo.deleteById(id);
    }

    public Car updateCar(Long id, Car updateCar){
        return carRepo.findById(id)
                .map(existingCar -> {
                    existingCar.setBrand(updateCar.getBrand());
                    existingCar.setModel(updateCar.getModel());
                    existingCar.setFuelType(updateCar.getFuelType());
                    existingCar.setDoors(updateCar.getDoors());
                    existingCar.setSeats(updateCar.getSeats());
                    existingCar.setYear(updateCar.getYear());
                    existingCar.setPrice(updateCar.getPrice());
                    return carRepo.save(existingCar);
                })
                .orElseThrow(() -> new RuntimeException("Car not found: " + id));
    }
}
