package com.example.springcarrental.controller;

import com.example.springcarrental.dto.CarRentalDTO;
import com.example.springcarrental.dto.incoming.CarRentalRequestDTO;


public interface CarRentalController extends GenericController<CarRentalDTO, Long>{
    public CarRentalDTO createNewRental(CarRentalRequestDTO carRentalRequest);
}