package com.example.springcarrental.dao;

import com.example.springcarrental.model.AppUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<AppUser, Long> {
}