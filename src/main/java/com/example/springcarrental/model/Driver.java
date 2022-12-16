package com.example.springcarrental.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Driver {
    @Id
    @GeneratedValue
    private Long id;
    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //CONSTRUCTORS

    public Driver(Long id) {
        this.id = id;
    }

    public Driver() {
    }
}
