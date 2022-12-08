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
    private User user;

    @ManyToOne
    private CarDescription carDescription;

    private double price;

    @OneToMany
    private List<Payment> payments;

}
