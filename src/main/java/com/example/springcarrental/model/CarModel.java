package com.example.springcarrental.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class CarModel {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int passengerNumber;

    private boolean isAirConditioned;

    private int maxPower;

    private int maxSpeed;
}
