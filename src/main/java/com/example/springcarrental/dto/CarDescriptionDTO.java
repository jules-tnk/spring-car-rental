package com.example.springcarrental.dto;

import com.example.springcarrental.model.Agency;
import com.example.springcarrental.model.CarDescription;
import com.example.springcarrental.model.CarModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarDescriptionDTO{
    private Long id;
    private CarModel model;
    private String color;
    private double pricePerHour;
    private Agency agency;
    private String imgUrl;

    public CarDescriptionDTO(CarModel model, String color, double pricePerHour, Agency agency, String imgUrl) {
        this.model = model;
        this.color = color;
        this.pricePerHour = pricePerHour;
        this.agency = agency;
        this.imgUrl = imgUrl;
    }
}