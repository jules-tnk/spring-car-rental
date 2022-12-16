package com.example.springcarrental.dto;

import com.example.springcarrental.model.Agency;
import com.example.springcarrental.model.CarDescription;
import com.example.springcarrental.model.CarModel;

public class CarDescriptionDTO{
    private Long id;
    private CarModel model;
    private CarDescription.Color color;
    private double pricePerHour;
    private Agency agency;
    private String imgUrl;

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

    public CarDescription.Color getColor() {
        return color;
    }

    public void setColor(CarDescription.Color color) {
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

    public CarDescriptionDTO(Long id, CarModel model, CarDescription.Color color, double pricePerHour, Agency agency, String imgUrl) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.pricePerHour = pricePerHour;
        this.agency = agency;
        this.imgUrl = imgUrl;
    }

    public CarDescriptionDTO(CarModel model, CarDescription.Color color, double pricePerHour, Agency agency, String imgUrl) {
        this.model = model;
        this.color = color;
        this.pricePerHour = pricePerHour;
        this.agency = agency;
        this.imgUrl = imgUrl;
    }

    public CarDescriptionDTO() {
    }
}