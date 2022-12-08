package com.example.springcarrental.dao;

import com.example.springcarrental.model.Car;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends PagingAndSortingRepository<Car, String> {
}