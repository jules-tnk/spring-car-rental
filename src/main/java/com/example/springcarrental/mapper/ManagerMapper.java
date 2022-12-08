package com.example.springcarrental.mapper;

import com.example.springcarrental.dto.ManagerDTO;
import com.example.springcarrental.model.Manager;
import org.mapstruct.Mapper;

@Mapper
public interface ManagerMapper extends GenericMapper<Manager, ManagerDTO> {
    @Override
    Manager asEntity(ManagerDTO dto);
}