package com.example.springcarrental.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentDTO {
    private Long id;
    private double amount;

    private String method;

    //CONSTRUCTORS
    public PaymentDTO(double amount, String method) {
        this.amount = amount;
        this.method = method;
    }
}