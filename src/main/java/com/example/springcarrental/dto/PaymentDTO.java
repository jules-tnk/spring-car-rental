package com.example.springcarrental.dto;

import com.example.springcarrental.model.CarRental;

public class PaymentDTO {
    private Long id;
    private double amount;
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

    public PaymentDTO(Long id, double amount, CarRental rental) {
        this.id = id;
        this.amount = amount;
        this.rental = rental;
    }

    public PaymentDTO(double amount, CarRental rental) {
        this.amount = amount;
        this.rental = rental;
    }

    public PaymentDTO() {
    }
}