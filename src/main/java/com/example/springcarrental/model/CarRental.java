package com.example.springcarrental.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class CarRental {

    public enum Status{
        RESERVED,
        TAKEN,
        RETURNED
    }

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private AppUser client;

    @ManyToOne
    private Car car;

    private Status status;

    @OneToMany
    private List<Payment> payments = new ArrayList<Payment>();

    private Date startDate;
    private Date endDate;


    public CarRental(AppUser client, Car car, List<Payment> payments) {
        this.client = client;
        this.car = car;
        this.payments = payments;
    }

}
