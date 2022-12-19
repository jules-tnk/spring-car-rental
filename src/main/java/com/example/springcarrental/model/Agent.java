package com.example.springcarrental.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Agent {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Agency agency;

    //CONSTRUCTORS
    public Agent(Agency agency) {
        this.agency = agency;
    }

}
