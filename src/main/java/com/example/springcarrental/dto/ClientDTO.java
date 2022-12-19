package com.example.springcarrental.dto;

import com.example.springcarrental.model.AppUser;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ClientDTO {
    private Long id;
    private AppUser appUser;

    public ClientDTO(AppUser appUser) {
        this.appUser = appUser;
    }
}