package com.example.springcarrental.dao;

import com.example.springcarrental.model.CarDescription;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDescriptionRepository extends PagingAndSortingRepository<CarDescription, Long> {
}