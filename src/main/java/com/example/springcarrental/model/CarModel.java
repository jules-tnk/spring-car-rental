package com.example.springcarrental.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class CarModel {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Brand brand;

    private String name;

    private int passengerNumber;

    private boolean isAirConditioned;

    private int maxPower;

    private int maxSpeed;

    public CarModel(Brand brand, String name, int passengerNumber, boolean isAirConditioned, int maxPower, int maxSpeed) {
        this.brand = brand;
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.isAirConditioned = isAirConditioned;
        this.maxPower = maxPower;
        this.maxSpeed = maxSpeed;
    }
}
