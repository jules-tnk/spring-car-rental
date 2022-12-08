package com.example.springcarrental.service.impl;

import com.example.springcarrental.dao.DriverRepository;
import com.example.springcarrental.model.Driver;
import com.example.springcarrental.service.DriverService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    private final DriverRepository repository;

    public DriverServiceImpl(DriverRepository repository) {
        this.repository = repository;
    }

    @Override
    public Driver save(Driver entity) {
        return repository.save(entity);
    }

    @Override
    public List<Driver> save(List<Driver> entities) {
        return (List<Driver>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Driver> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Driver> findAll() {
        return (List<Driver>) repository.findAll();
    }

    @Override
    public Page<Driver> findAll(Pageable pageable) {
        Page<Driver> entityPage = repository.findAll(pageable);
        List<Driver> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Driver update(Driver entity, Long id) {
        Optional<Driver> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}