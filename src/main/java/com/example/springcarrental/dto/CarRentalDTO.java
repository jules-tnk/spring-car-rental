package com.example.springcarrental.dto;

import com.example.springcarrental.model.AppUser;
import com.example.springcarrental.model.Car;
import com.example.springcarrental.model.Payment;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@NoArgsConstructor
public class CarRentalDTO {
    private Long id;
    private AppUser appUser;
    private Car car;
    private double price;
    private List<Payment> payments;

    //CONSTRUCTORS

    public CarRentalDTO(AppUser appUser, Car car, double price, List<Payment> payments) {
        this.appUser = appUser;
        this.car = car;
        this.price = price;
        this.payments = payments;
    }
}