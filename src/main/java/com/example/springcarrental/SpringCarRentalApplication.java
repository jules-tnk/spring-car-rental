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

    CityServiceImpl cityService;
    AgencyServiceImpl agencyService;
    BrandServiceImpl brandService;
    CarModelServiceImpl carModelService;
    CarServiceImpl carService;

    public SpringCarRentalApplication(CityServiceImpl cityService,
                                      AgencyServiceImpl agencyService,
                                      BrandServiceImpl brandService,
                                      CarModelServiceImpl carModelService,
                                      CarServiceImpl carService) {
        this.cityService = cityService;
        this.agencyService = agencyService;
        this.brandService = brandService;
        this.carModelService = carModelService;
        this.carService = carService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCarRentalApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            City mainCity = new City("Rabat");
            Agency mainAgency = new Agency(mainCity, "Agdal, Av. Ibn Sina");

            List<CarModel> carModelList = new ArrayList<CarModel>();

            //BMW Brand and models
            Brand bmw = new Brand("BMW");
            //https://www.wandaloo.com/neuf/bmw/serie-3/fiche-technique/318d-sport/16350.html
            CarModel bmwModel1 = new CarModel(
                    bmw,
                    "Serie 3 - 318d Sport",
                    4,
                    true,
                    150,
                    224

            );
            carModelList.add(bmwModel1);
            //https://www.wandaloo.com/neuf/bmw/serie-3/fiche-technique/320d-elegance/16355.html
            CarModel bmwModel2 = new CarModel(
                    bmw,
                    "Serie 3 - 320d Elegance",
                    4,
                    true,
                    190,
                    235
            );
            carModelList.add(bmwModel2);

            //Mercedes brand and model
            Brand mercedes = new Brand("Mercedes");

            //https://www.carwale.com/mercedes-benz-cars/g-class/
            CarModel mercedesModel1 = new CarModel(
                    mercedes,
                    "G-class",
                    4,
                    true,
                    110,
                    190

            );
            carModelList.add(mercedesModel1);
            //https://www.carwale.com/mercedes-benz-cars/c-class/
            CarModel mercedesModel2 = new CarModel(
                    mercedes,
                    "C-class",
                    4,
                    false,
                    150,
                    250
            );
            carModelList.add(mercedesModel2);


            cityService.save(mainCity);
            agencyService.save(mainAgency);
            brandService.save(bmw);
            brandService.save(mercedes);
            carModelService.save(carModelList);
        };
    }

}
