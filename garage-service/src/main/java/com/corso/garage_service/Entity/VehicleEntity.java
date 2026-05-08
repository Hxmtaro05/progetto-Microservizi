package com.corso.garage_service.Entity;

import com.corso.garage_service.GarageServiceApplication;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="vehicles")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long externalId;

    @NotBlank
    private String VehicleType;

    @ManyToOne
    @JoinColumn(name="garage_id")
    @JsonIgnore
    private GarageServiceApplication garage;
}
