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

    @OneToOne
    private User user;

    @ManyToOne
    private Agency agency;
}
