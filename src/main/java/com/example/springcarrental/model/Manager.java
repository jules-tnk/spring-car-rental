package com.example.springcarrental.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Manager {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Agency agency;

    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //CONSTRUCTORS

    public Manager(Long id) {
        this.id = id;
    }

    public Manager() {
    }
}
