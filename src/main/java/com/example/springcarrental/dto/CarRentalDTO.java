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
    private AppUser client;
    private Car car;
    private List<Payment> payments;

    //CONSTRUCTORS
    public CarRentalDTO(AppUser client, Car car, List<Payment> payments) {
        this.client = client;
        this.car = car;
        this.payments = payments;
    }
}