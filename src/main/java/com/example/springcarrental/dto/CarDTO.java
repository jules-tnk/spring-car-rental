package com.example.springcarrental.dto;

import com.example.springcarrental.model.CarDescription;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarDTO {
    private String licensePlate;
    private CarDescription description;

    private boolean isAvailable;

    public CarDTO(String licensePlate, CarDescription description, boolean isAvailable) {
        this.licensePlate = licensePlate;
        this.description = description;
        this.isAvailable = isAvailable;
    }
}