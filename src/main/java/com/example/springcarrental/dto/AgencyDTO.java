package com.example.springcarrental.dto;

import com.example.springcarrental.model.City;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AgencyDTO {
    private Long id;
    private Long cityId;
    private String city;
    private String address;

    public AgencyDTO(Long cityId, String city, String address) {
        //this.cityId = cityId;
        this.city = city;
        this.address = address;
    }
}