package com.example.springcarrental.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class CarRental {

    enum Status{
        RESERVED,
        TAKEN,
        RETURNED
    }

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private AppUser appUser;

    @ManyToOne
    private Car car;

    private double price;

    @OneToMany
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

    public void setCar(Car car) {
        this.car = car;
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
    public CarRental(Long id, AppUser appUser, Car car, double price, List<Payment> payments) {
        this.id = id;
        this.appUser = appUser;
        this.car = car;
        this.price = price;
        this.payments = payments;
    }

    public CarRental(AppUser appUser, Car car, double price, List<Payment> payments) {
        this.appUser = appUser;
        this.car = car;
        this.price = price;
        this.payments = payments;
    }

    public CarRental() {
    }
}
