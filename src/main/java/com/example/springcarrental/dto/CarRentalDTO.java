package com.example.springcarrental.dto;

import com.example.springcarrental.model.AppUser;
import com.example.springcarrental.model.Car;
import com.example.springcarrental.model.Payment;


import java.util.List;

public class CarRentalDTO {
    private Long id;
    private AppUser appUser;
    private Car car;
    private double price;
    private List<Payment> payments;

    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car Car) {
        this.car = Car;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    //CONSTRUCTORS

    public CarRentalDTO(AppUser appUser, Car car, double price, List<Payment> payments) {
        this.appUser = appUser;
        this.car = car;
        this.price = price;
        this.payments = payments;
    }

    public CarRentalDTO() {
    }
}