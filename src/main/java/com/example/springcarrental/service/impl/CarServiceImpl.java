package com.example.springcarrental.service.impl;

import com.example.springcarrental.dao.CarRepository;
import com.example.springcarrental.model.Car;
import com.example.springcarrental.model.CarDescription;
import com.example.springcarrental.service.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    private final CarRepository repository;

    public CarServiceImpl(CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public Car save(Car entity) {
        return repository.save(entity);
    }

    @Override
    public List<Car> save(List<Car> entities) {
        return (List<Car>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Car> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Car> findAll() {
        return (List<Car>) repository.findAll();
    }

    @Override
    public Page<Car> findAll(Pageable pageable) {
        Page<Car> entityPage = repository.findAll(pageable);
        List<Car> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Car update(Car entity, String id) {
        Optional<Car> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }

    //@Override
    public Car findFirstAvailable(CarDescription carDescription) {
        return repository.findFirstByDescription_IdAndIsAvailableIsTrue(carDescription.getId());
    }
}