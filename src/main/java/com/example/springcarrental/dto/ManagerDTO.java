package com.example.springcarrental.dto;

import com.example.springcarrental.model.Agency;
import com.example.springcarrental.model.AppUser;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ManagerDTO {
    private Long id;
    private AppUser appUser;
    private Agency agency;

    public ManagerDTO(AppUser appUser, Agency agency) {
        this.appUser = appUser;
        this.agency = agency;
    }

}