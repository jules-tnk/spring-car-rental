package com.example.springcarrental.dto;

import com.example.springcarrental.model.City;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AgencyDTO {
    private Long id;
    private City city;
    private String address;
}