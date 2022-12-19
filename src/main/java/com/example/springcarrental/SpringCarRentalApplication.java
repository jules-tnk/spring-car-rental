package com.example.springcarrental;

import com.example.springcarrental.model.*;
import com.example.springcarrental.service.AgencyService;
import com.example.springcarrental.service.CarService;
import com.example.springcarrental.service.CityService;
import com.example.springcarrental.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringCarRentalApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCarRentalApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {};
    }

}
