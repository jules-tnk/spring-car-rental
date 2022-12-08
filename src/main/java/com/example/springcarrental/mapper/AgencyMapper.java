package com.example.springcarrental.mapper;

import com.example.springcarrental.dto.AgencyDTO;
import com.example.springcarrental.model.Agency;
import org.mapstruct.Mapper;

@Mapper
public interface AgencyMapper extends GenericMapper<Agency, AgencyDTO> {
    @Override
    Agency asEntity(AgencyDTO dto);
}