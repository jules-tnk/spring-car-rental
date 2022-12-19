package com.example.springcarrental.mapper;

import com.example.springcarrental.dto.AgencyDTO;
import com.example.springcarrental.model.Agency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AgencyMapper extends GenericMapper<Agency, AgencyDTO> {
    @Override
    @Mapping(source = "dto.city", target = "city.name")
    @Mapping(source = "dto.cityId", target = "city.id")
    Agency asEntity(AgencyDTO dto);

    @Override
    @Mapping(source = "agency.city.name", target = "city")
    @Mapping(source = "agency.city.id", target = "cityId")
    AgencyDTO asDTO(Agency agency);
}