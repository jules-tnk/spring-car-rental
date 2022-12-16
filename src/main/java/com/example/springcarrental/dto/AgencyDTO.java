package com.example.springcarrental.dto;

import com.example.springcarrental.model.City;

public class AgencyDTO {
    private Long id;
    private City city;
    private String address;

    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //CONSTRUCTORS

    public AgencyDTO(Long id, City city, String address) {
        this.id = id;
        this.city = city;
        this.address = address;
    }

    public AgencyDTO(City city, String address) {
        this.city = city;
        this.address = address;
    }

    public AgencyDTO() {
    }
}