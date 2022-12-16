package com.example.springcarrental.dto;

import com.example.springcarrental.model.CarDescription;


public class CarDTO {
    private String licensePlate;
    private CarDescription description;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public CarDescription getDescription() {
        return description;
    }

    public void setDescription(CarDescription description) {
        this.description = description;
    }

    public CarDTO(String licensePlate, CarDescription description) {
        this.licensePlate = licensePlate;
        this.description = description;
    }

    public CarDTO() {
    }
}