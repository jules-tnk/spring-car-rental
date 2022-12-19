package com.example.springcarrental.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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

    public CarRental(AppUser appUser, Car car, double price, List<Payment> payments) {
        this.appUser = appUser;
        this.car = car;
        this.price = price;
        this.payments = payments;
    }

}
