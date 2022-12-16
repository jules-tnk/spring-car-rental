package com.example.springcarrental.dto;

import com.example.springcarrental.model.AppUser;



public class ClientDTO {
    private Long id;
    private AppUser appUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public ClientDTO(Long id, AppUser appUser) {
        this.id = id;
        this.appUser = appUser;
    }

    public ClientDTO(AppUser appUser) {
        this.appUser = appUser;
    }

    public ClientDTO() {
    }
}