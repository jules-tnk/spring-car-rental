package com.example.springcarrental.model;


import javax.persistence.*;

@Entity
public class Agent {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Agency agency;

    //GETTERS
    public Long getId() {
        return id;
    }

    public Agency getAgency() {
        return agency;
    }


    //SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }


    //CONSTRUCTORS

    public Agent(Long id, Agency agency) {
        this.id = id;
        this.agency = agency;
    }

    public Agent(Agency agency) {
        this.agency = agency;
    }

    public Agent() {
    }
}
