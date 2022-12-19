package com.example.springcarrental.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarModelDTO {
    private Long id;
    private String name;

    private String brand;
    private int passengerNumber;
    private boolean isAirConditioned;
    private int maxPower;
    private int maxSpeed;

    public CarModelDTO(String name, String brand, int passengerNumber, boolean isAirConditioned, int maxPower, int maxSpeed) {
        this.name = name;
        this.brand = brand;
        this.passengerNumber = passengerNumber;
        this.isAirConditioned = isAirConditioned;
        this.maxPower = maxPower;
        this.maxSpeed = maxSpeed;
    }
}