package com.example.springcarrental.mapper;

import com.example.springcarrental.dto.DriverDTO;
import com.example.springcarrental.model.Driver;
import org.mapstruct.Mapper;

@Mapper
public interface DriverMapper extends GenericMapper<Driver, DriverDTO> {
    @Override
    Driver asEntity(DriverDTO dto);
}