package com.example.springcarrental.dao;

import com.example.springcarrental.model.Manager;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends PagingAndSortingRepository<Manager, Long> {
}