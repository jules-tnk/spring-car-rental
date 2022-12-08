package com.example.springcarrental.mapper;

import com.example.springcarrental.dto.ClientDTO;
import com.example.springcarrental.model.Client;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper extends GenericMapper<Client, ClientDTO> {
    @Override
    Client asEntity(ClientDTO dto);
}