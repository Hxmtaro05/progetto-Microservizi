package com.corso.garage_service.Repository;

import com.corso.garage_service.Entity.garageEntity;
import com.corso.garage_service.Service.GarageService;
import org.springframework.data.jpa.repository.JpaRepository;
public interface garageRepository extends JpaRepository<GarageService, Long>{
}
