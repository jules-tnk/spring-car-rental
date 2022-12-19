package com.example.springcarrental.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Agency {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private City city;

    private String address;

    //CONSTRUCTORS
    public Agency(City city, String address) {
        this.city = city;
        this.address = address;
    }
}
