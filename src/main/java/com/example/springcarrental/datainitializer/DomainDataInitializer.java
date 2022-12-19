package com.example.springcarrental.datainitializer;

import com.example.springcarrental.dto.incoming.LoginDTO;
import com.example.springcarrental.model.*;
import com.example.springcarrental.service.impl.*;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class DomainDataInitializer implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;
    CityServiceImpl cityService;
    AgencyServiceImpl agencyService;
    BrandServiceImpl brandService;
    CarModelServiceImpl carModelService;
    CarDescriptionServiceImpl carDescriptionService;
    CarServiceImpl carService;

    public DomainDataInitializer(CityServiceImpl cityService, AgencyServiceImpl agencyService, BrandServiceImpl brandService, CarModelServiceImpl carModelService, CarDescriptionServiceImpl carDescriptionService, CarServiceImpl carService) {
        this.cityService = cityService;
        this.agencyService = agencyService;
        this.brandService = brandService;
        this.carModelService = carModelService;
        this.carDescriptionService = carDescriptionService;
        this.carService = carService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) {return;}
        City mainCity = new City("Rabat");
        Agency mainAgency = new Agency(mainCity, "Agdal, Av. Ibn Sina");
        List<Brand> brandList = new ArrayList<Brand>();
        List<CarModel> carModelList = new ArrayList<CarModel>();
        List<CarDescription> carDescriptionList = new ArrayList<CarDescription>();
        List<Car> carList = new ArrayList<Car>();

        //Add BMW brand, models, descriptions and cars----------------------------
        Brand bmw = new Brand("BMW");
        //https://www.wandaloo.com/neuf/bmw/serie-3/fiche-technique/318d-sport/16350.html
        CarModel bmwModel1 = new CarModel(bmw, "Serie 3 - 318d Sport", 4, true, 150, 224);
        CarDescription bmwModel1Desc1 = new CarDescription(bmwModel1, "Red", 500, mainAgency, "https://www.wandaloo.com/files/Voiture-Neuve/bmw-serie-3.jpg");
        Car car1 = new Car("A1234", bmwModel1Desc1, true, mainAgency);
        Car car2 = new Car("A2234", bmwModel1Desc1, false, mainAgency);

        CarDescription bmwModel1Desc2 = new CarDescription(bmwModel1, "Black", 600, mainAgency, "https://www.wandaloo.com/files/Voiture-Neuve/bmw-serie-3.jpg");
        Car car3 = new Car("A1334", bmwModel1Desc2, true, mainAgency);
        Car car4 = new Car("A2334", bmwModel1Desc2, true, mainAgency);
        //https://www.wandaloo.com/neuf/bmw/serie-3/fiche-technique/320d-elegance/16355.html
        CarModel bmwModel2 = new CarModel(bmw, "Serie 3 - 320d Elegance", 4, true, 190, 235);
        CarDescription bmwModel2Desc1 = new CarDescription(bmwModel2, "White", 500, mainAgency, "https://www.wandaloo.com/files/Voiture-Neuve/bmw-serie-8-coupe.jpg");
        CarDescription bmwModel2Desc2 = new CarDescription(bmwModel2, "Grey", 600, mainAgency, "https://www.wandaloo.com/files/Voiture-Neuve/bmw-serie-8-coupe.jpg");
        brandList.add(bmw);
        carModelList.add(bmwModel1);
        carDescriptionList.add(bmwModel1Desc1);
        carDescriptionList.add(bmwModel1Desc2);
        carModelList.add(bmwModel2);
        carDescriptionList.add(bmwModel2Desc1);
        carDescriptionList.add(bmwModel2Desc2);
        carList.add(car1); carList.add(car2); carList.add(car3); carList.add(car4);



        //Add BMW brand, models, descriptions and cars----------------------------
        Brand mercedes = new Brand("Mercedes");
        //https://www.carwale.com/mercedes-benz-cars/g-class/
        CarModel mercedesModel1 = new CarModel(mercedes, "G-class", 4, true, 110, 190);
        //https://www.carwale.com/mercedes-benz-cars/c-class/
        CarModel mercedesModel2 = new CarModel(mercedes, "C-class", 4, false, 150, 250);
        brandList.add(mercedes);
        carModelList.add(mercedesModel1);
        carModelList.add(mercedesModel2);


        cityService.save(mainCity);
        agencyService.save(mainAgency);
        brandService.save(bmw);
        brandService.save(mercedes);
        carModelService.save(carModelList);
        carDescriptionService.save(carDescriptionList);
        carService.save(carList);

        alreadySetup = false;
    }
}
