package com.example.springcarrental.mapper;

import com.example.springcarrental.dto.CarModelDTO;
import com.example.springcarrental.model.CarModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CarModelMapper extends GenericMapper<CarModel, CarModelDTO> {
    @Override
    @Mapping(source = "dto.brand", target="brand.name")
    CarModel asEntity(CarModelDTO dto);

    @Override
    @Mapping(source = "carModel.brand.name", target = "brand")
    CarModelDTO asDTO(CarModel carModel);
}