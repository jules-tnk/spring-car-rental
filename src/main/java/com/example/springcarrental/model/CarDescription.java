package com.example.springcarrental.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class CarDescription {
    public enum Color {
        RED,
        WHITE,
        BLACK,
        GREY
    }

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private CarModel model;

    @Enumerated(EnumType.STRING)
    private Color color;

    private double pricePerHour;

    @ManyToOne
    private Agency agency;

    private String imgUrl;
}
