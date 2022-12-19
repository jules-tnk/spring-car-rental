package com.example.springcarrental.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Brand {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Brand(String name) {
        this.name = name;
    }

}
