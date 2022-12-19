package com.example.springcarrental.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    private double amount;

    @ManyToOne
    private CarRental rental;

    //CONSTRUCTORS
    public Payment(double amount, CarRental rental) {
        this.amount = amount;
        this.rental = rental;
    }
}
