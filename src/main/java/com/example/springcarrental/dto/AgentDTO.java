package com.example.springcarrental.dto;

import com.example.springcarrental.model.Agency;
import com.example.springcarrental.model.AppUser;


public class AgentDTO{
    private Long id;
    private AppUser appUser;
    private Agency agency;

    //GETTERS AND SETTERS

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

    //CONSTRUCTORS

    public AgentDTO(Long id, AppUser appUser, Agency agency) {
        this.id = id;
        this.appUser = appUser;
        this.agency = agency;
    }

    public AgentDTO(AppUser appUser, Agency agency) {
        this.appUser = appUser;
        this.agency = agency;
    }

    public AgentDTO() {
    }
}