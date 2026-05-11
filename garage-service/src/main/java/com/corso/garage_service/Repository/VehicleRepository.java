package com.corso.garage_service.Repository;

import com.corso.garage_service.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
}
