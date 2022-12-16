package com.example.springcarrental.model;


import javax.persistence.*;

@Entity
public class Agency {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private City city;

    private String address;


    //GETTERS
    public Long getId() {
        return id;
    }

    public City getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }


    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    //CONSTRUCTORS
    public Agency(Long id, City city, String address) {
        this.id = id;
        this.city = city;
        this.address = address;
    }

    public Agency(City city, String address) {
        this.city = city;
        this.address = address;
    }

    public Agency() {
    }
}
