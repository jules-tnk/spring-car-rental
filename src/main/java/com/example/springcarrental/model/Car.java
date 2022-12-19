package com.example.springcarrental.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Car {
    @Id
    private String licensePlate;

    @ManyToOne
    private CarDescription description;

    private boolean isAvailable;

    @ManyToOne
    private Agency agency;

    //CONSTRUCTORS
    public Car(String licensePlate, CarDescription description, boolean isAvailable, Agency agency) {
        this.licensePlate = licensePlate;
        this.description = description;
        this.isAvailable = isAvailable;
        this.agency = agency;
    }
}
