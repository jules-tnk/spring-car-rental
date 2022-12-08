package com.example.springcarrental.mapper;

import com.example.springcarrental.dto.CarDescriptionDTO;
import com.example.springcarrental.model.CarDescription;
import org.mapstruct.Mapper;

@Mapper
public interface CarDescriptionMapper extends GenericMapper<CarDescription, CarDescriptionDTO> {
    @Override
    CarDescription asEntity(CarDescriptionDTO dto);
}