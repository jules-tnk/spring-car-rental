package com.example.springcarrental.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Car {
    @Id
    private String licensePlate;

    @ManyToOne
    private CarDescription description;
}
