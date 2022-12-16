package com.example.springcarrental.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue
    private Long id;

    private String name;


    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //CONSTRUCTORS

    public City(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public City(String name) {
        this.name = name;
    }

    public City() {
    }
}
