package com.example.springcarrental.dto;

import com.example.springcarrental.model.AppUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ClientDTO extends UserDTO{
}