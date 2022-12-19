package com.example.springcarrental.model;

import javax.persistence.*;

@Entity
public class CarDescription {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private CarModel model;

    private String color;

    private double pricePerHour;

    @ManyToOne
    private Agency agency;

    private String imgUrl;

    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    //CONSTRUCTORS
    public CarDescription(Long id, CarModel model, String color, double pricePerHour, Agency agency, String imgUrl) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.pricePerHour = pricePerHour;
        this.agency = agency;
        this.imgUrl = imgUrl;
    }

    public CarDescription(CarModel model, String color, double pricePerHour, Agency agency, String imgUrl) {
        this.model = model;
        this.color = color;
        this.pricePerHour = pricePerHour;
        this.agency = agency;
        this.imgUrl = imgUrl;
    }

    public CarDescription() {
    }
}
