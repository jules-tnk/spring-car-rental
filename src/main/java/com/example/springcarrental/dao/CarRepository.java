package com.example.springcarrental.dao;

import com.example.springcarrental.model.Car;
import com.example.springcarrental.model.CarDescription;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends PagingAndSortingRepository<Car, String> {
    public Car findFirstByDescription_IdAndIsAvailableIsTrue(Long descriptionId);
}