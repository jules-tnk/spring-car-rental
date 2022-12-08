package com.example.springcarrental.dto;

import com.example.springcarrental.model.CarDescription;
import com.example.springcarrental.model.Payment;
import com.example.springcarrental.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CarRentalDTO {
    private Long id;
    private User user;
    private CarDescription carDescription;
    private double price;
    private List<Payment> payments;
}