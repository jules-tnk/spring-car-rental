package com.example.springcarrental.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
public class Driver {
    @Id
    @GeneratedValue
    private Long id;

    //CONSTRUCTORS

    public Driver(Long id) {
        this.id = id;
    }

}
