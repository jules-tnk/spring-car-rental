package com.example.springcarrental.dao;

import com.example.springcarrental.model.CarModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepository extends PagingAndSortingRepository<CarModel, Long> {
}