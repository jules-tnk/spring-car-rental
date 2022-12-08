package com.example.springcarrental.dao;

import com.example.springcarrental.model.Agency;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends PagingAndSortingRepository<Agency, Long> {
}