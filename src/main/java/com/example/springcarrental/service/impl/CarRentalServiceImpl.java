package com.example.springcarrental.service.impl;

import com.example.springcarrental.dao.CarRentalRepository;
import com.example.springcarrental.model.CarRental;
import com.example.springcarrental.service.CarRentalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarRentalServiceImpl implements CarRentalService {
    private final CarRentalRepository repository;

    public CarRentalServiceImpl(CarRentalRepository repository) {
        this.repository = repository;
    }

    @Override
    public CarRental save(CarRental entity) {
        return repository.save(entity);
    }

    @Override
    public List<CarRental> save(List<CarRental> entities) {
        return (List<CarRental>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<CarRental> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<CarRental> findAll() {
        return (List<CarRental>) repository.findAll();
    }

    @Override
    public Page<CarRental> findAll(Pageable pageable) {
        Page<CarRental> entityPage = repository.findAll(pageable);
        List<CarRental> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public CarRental update(CarRental entity, Long id) {
        Optional<CarRental> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}