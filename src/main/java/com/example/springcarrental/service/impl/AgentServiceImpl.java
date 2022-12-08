package com.example.springcarrental.service.impl;

import com.example.springcarrental.dao.AgentRepository;
import com.example.springcarrental.model.Agent;
import com.example.springcarrental.service.AgentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AgentServiceImpl implements AgentService {
    private final AgentRepository repository;

    public AgentServiceImpl(AgentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Agent save(Agent entity) {
        return repository.save(entity);
    }

    @Override
    public List<Agent> save(List<Agent> entities) {
        return (List<Agent>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Agent> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Agent> findAll() {
        return (List<Agent>) repository.findAll();
    }

    @Override
    public Page<Agent> findAll(Pageable pageable) {
        Page<Agent> entityPage = repository.findAll(pageable);
        List<Agent> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Agent update(Agent entity, Long id) {
        Optional<Agent> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}