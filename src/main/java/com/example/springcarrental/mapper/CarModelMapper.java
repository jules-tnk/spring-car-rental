package com.example.springcarrental.mapper;

import com.example.springcarrental.dto.CarModelDTO;
import com.example.springcarrental.model.CarModel;
import org.mapstruct.Mapper;

@Mapper
public interface CarModelMapper extends GenericMapper<CarModel, CarModelDTO> {
    @Override
    CarModel asEntity(CarModelDTO dto);
}