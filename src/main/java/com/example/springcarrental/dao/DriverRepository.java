package com.example.springcarrental.dao;

import com.example.springcarrental.model.Driver;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends PagingAndSortingRepository<Driver, Long> {
}