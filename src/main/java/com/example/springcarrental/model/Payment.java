package com.example.springcarrental.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    private double amount;

    private String method;

    //CONSTRUCTORS
    public Payment(double amount, String method) {
        this.amount = amount;
        this.method = method;
    }
}
