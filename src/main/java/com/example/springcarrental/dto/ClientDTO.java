package com.example.springcarrental.dto;

import com.example.springcarrental.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientDTO {
    private Long id;
    private User user;

}