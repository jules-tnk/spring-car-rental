package com.example.springcarrental.mapper;

import com.example.springcarrental.dto.UserDTO;
import com.example.springcarrental.model.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper extends GenericMapper<AppUser, UserDTO> {
    @Override
    AppUser asEntity(UserDTO dto);

    @Override
    //@Mapping(source = "id", target = "id")
    UserDTO asDTO(AppUser user);
}