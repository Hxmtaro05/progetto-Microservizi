package com.corso.moto.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//serve a dire al framework che una classe Java rappresenta una tabella all'interno di un database relazionale.
@Table(name = "bikes")
//@Table serve per mappare una classe Java a una tabella del database.
//oppure Data = @Getter + @Setter
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @Min(50)
    private Integer engineCC;

    @NotBlank
    private String type;

    @Min(1900)
    private Integer year;

    @Min(0)
    private Double price;
 }