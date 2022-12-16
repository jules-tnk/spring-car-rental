package com.example.springcarrental.model;

import javax.persistence.*;

@Entity
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


    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public boolean isAirConditioned() {
        return isAirConditioned;
    }

    public void setAirConditioned(boolean airConditioned) {
        isAirConditioned = airConditioned;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    //CONSTRUCTORS
    public CarModel(Long id, Brand brand, String name, int passengerNumber, boolean isAirConditioned, int maxPower, int maxSpeed) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.isAirConditioned = isAirConditioned;
        this.maxPower = maxPower;
        this.maxSpeed = maxSpeed;
    }

    public CarModel(Brand brand, String name, int passengerNumber, boolean isAirConditioned, int maxPower, int maxSpeed) {
        this.brand = brand;
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.isAirConditioned = isAirConditioned;
        this.maxPower = maxPower;
        this.maxSpeed = maxSpeed;
    }

    public CarModel() {
    }
}
