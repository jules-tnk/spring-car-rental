package com.example.springcarrental.dao;

import com.example.springcarrental.model.Agent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends PagingAndSortingRepository<Agent, Long> {
}