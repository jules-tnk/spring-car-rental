package com.example.springcarrental.mapper;

import com.example.springcarrental.dto.UserDTO;
import com.example.springcarrental.model.AppUser;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends GenericMapper<AppUser, UserDTO> {
    @Override
    AppUser asEntity(UserDTO dto);

    @Override
    UserDTO asDTO(AppUser user);
}