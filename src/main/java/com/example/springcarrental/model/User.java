package com.example.springcarrental.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class User {

    public enum Role {
        CLIENT,
        ADMIN,
        AGENT,
        DRIVER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(length = 50)
    private String email;
}
