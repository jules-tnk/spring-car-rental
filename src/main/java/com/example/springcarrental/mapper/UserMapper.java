package com.example.springcarrental.mapper;

import com.example.springcarrental.dto.UserDTO;
import com.example.springcarrental.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends GenericMapper<User, UserDTO> {
    @Override
    User asEntity(UserDTO dto);
}