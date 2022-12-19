package com.example.springcarrental.dto;

import com.example.springcarrental.model.CarRental;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentDTO {
    private Long id;
    private double amount;
    private CarRental rental;

    //CONSTRUCTORS
    public PaymentDTO(double amount, CarRental rental) {
        this.amount = amount;
        this.rental = rental;
    }
}