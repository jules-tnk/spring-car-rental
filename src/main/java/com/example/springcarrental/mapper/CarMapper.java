package com.example.springcarrental.mapper;

import com.example.springcarrental.dto.CarDTO;
import com.example.springcarrental.model.Car;
import org.mapstruct.Mapper;

@Mapper
public interface CarMapper extends GenericMapper<Car, CarDTO> {
    @Override
    Car asEntity(CarDTO dto);
}