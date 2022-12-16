package com.example.springcarrental.model;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    private String licensePlate;

    @ManyToOne
    private CarDescription description;

    @ManyToOne
    private Agency agency;

    //GETTERS AND SETTERS

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

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    //CONSTRUCTORS

    public Car(String licensePlate, CarDescription description, Agency agency) {
        this.licensePlate = licensePlate;
        this.description = description;
        this.agency = agency;
    }


    public Car() {
    }
}
