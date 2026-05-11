package com.corso.garage_service.Repository;

import com.corso.garage_service.Entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GarageRepository extends JpaRepository<Garage, Long>{
}
