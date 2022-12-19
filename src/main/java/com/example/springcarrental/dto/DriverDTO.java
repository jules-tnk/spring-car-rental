package com.example.springcarrental.dto;

import com.example.springcarrental.model.AppUser;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DriverDTO {
    private Long id;
    private AppUser appUser;

    public DriverDTO(AppUser appUser) {
        this.appUser = appUser;
    }

}