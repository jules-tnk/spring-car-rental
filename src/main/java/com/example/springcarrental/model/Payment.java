package com.example.springcarrental.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    private double amount;

    @ManyToOne
    private CarRental rental;

    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CarRental getRental() {
        return rental;
    }

    public void setRental(CarRental rental) {
        this.rental = rental;
    }

    //CONSTRUCTORS

    public Payment(Long id, double amount, CarRental rental) {
        this.id = id;
        this.amount = amount;
        this.rental = rental;
    }

    public Payment(double amount, CarRental rental) {
        this.amount = amount;
        this.rental = rental;
    }

    public Payment() {
    }
}
