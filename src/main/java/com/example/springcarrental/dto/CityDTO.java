package com.example.springcarrental.dto;


public class CityDTO {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityDTO(String name) {
        this.name = name;
    }

    public CityDTO() {
    }
}