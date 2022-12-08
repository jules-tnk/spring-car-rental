package com.example.springcarrental.dao;

import com.example.springcarrental.model.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long> {
}