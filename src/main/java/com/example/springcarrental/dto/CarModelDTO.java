package com.example.springcarrental.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarModelDTO {
    private Long id;
    private String name;
    private int passengerNumber;
    private boolean isAirConditioned;
    private int maxPower;
    private int maxSpeed;
}