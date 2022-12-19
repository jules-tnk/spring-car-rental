package com.example.springcarrental.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public City(String name) {
        this.name = name;
    }

}
