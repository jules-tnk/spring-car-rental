package com.example.springcarrental.mapper;

import com.example.springcarrental.dto.CityDTO;
import com.example.springcarrental.model.City;
import org.mapstruct.Mapper;

@Mapper
public interface CityMapper extends GenericMapper<City, CityDTO> {
    @Override
    City asEntity(CityDTO dto);
}