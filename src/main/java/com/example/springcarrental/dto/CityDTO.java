package com.example.springcarrental.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CityDTO {
    private Integer id;
    private String name;

    public CityDTO(String name) {
        this.name = name;
    }

}