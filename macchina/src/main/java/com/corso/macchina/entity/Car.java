package com.corso.macchina.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
//serve a dire al framework che una classe Java rappresenta una tabella all'interno di un database relazionale.
@Table(name = "Cars")
//@Table serve per mappare una classe Java a una tabella del database.
//oppure Data = @Getter + @Setter
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Car {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotBlank
    private String fuelType;

    @Min(2)
    private Integer doors;

    @Min(2)
    private Integer seats;

    @Min(1900)
    private Integer year;

    @Min(0)
    private double price;
 }