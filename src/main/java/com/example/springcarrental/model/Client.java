package com.example.springcarrental.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    //CONSTRUCTORS

    public Client(Long id) {
        this.id = id;
    }

}
