package com.corso.garage_service.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Garages")
public class Garage {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String OwnerName;

    @NotBlank
    private String address;

    @OneToMany(mappedBy="garage",cascade =
    CascadeType.ALL,orphanRemoval = true)
    private List<Vehicle> vehicles =new ArrayList<>();
}
