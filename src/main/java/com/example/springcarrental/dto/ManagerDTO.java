package com.example.springcarrental.dto;

import com.example.springcarrental.model.Agency;
import com.example.springcarrental.model.AppUser;

public class ManagerDTO {
    private Long id;
    private AppUser appUser;
    private Agency agency;

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

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public ManagerDTO(Long id, AppUser appUser, Agency agency) {
        this.id = id;
        this.appUser = appUser;
        this.agency = agency;
    }

    public ManagerDTO(AppUser appUser, Agency agency) {
        this.appUser = appUser;
        this.agency = agency;
    }

    public ManagerDTO() {
    }
}