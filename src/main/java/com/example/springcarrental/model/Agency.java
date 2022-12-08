package com.example.springcarrental.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Agency {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private City city;

    private String address;

    /*
    @OneToOne
    private User manager;

    @OneToMany
    private List<User> agents;

    @ManyToMany
    private List<Car> cars;
    */
}
