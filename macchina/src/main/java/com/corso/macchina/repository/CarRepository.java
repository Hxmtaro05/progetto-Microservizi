package com.corso.macchina.repository;

import com.corso.macchina.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long > {

}
