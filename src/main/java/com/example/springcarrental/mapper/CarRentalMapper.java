package com.example.springcarrental.mapper;

import com.example.springcarrental.dto.CarRentalDTO;
import com.example.springcarrental.model.CarRental;
import org.mapstruct.Mapper;

@Mapper
public interface CarRentalMapper extends GenericMapper<CarRental, CarRentalDTO> {
    @Override
    CarRental asEntity(CarRentalDTO dto);
}