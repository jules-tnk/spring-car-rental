package com.example.springcarrental.dto;

import com.example.springcarrental.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private User.Role role;
    private String email;
}