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
    private CarDescription.Color color;
    private double pricePerHour;
    private Agency agency;
    private String imgUrl;

}