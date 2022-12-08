package com.example.springcarrental.dao;

import com.example.springcarrental.model.CarRental;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRentalRepository extends PagingAndSortingRepository<CarRental, Long> {
}