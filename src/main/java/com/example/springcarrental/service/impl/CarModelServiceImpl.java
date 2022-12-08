package com.example.springcarrental.service.impl;

import com.example.springcarrental.dao.CarModelRepository;
import com.example.springcarrental.model.CarModel;
import com.example.springcarrental.service.CarModelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarModelServiceImpl implements CarModelService {
    private final CarModelRepository repository;

    public CarModelServiceImpl(CarModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public CarModel save(CarModel entity) {
        return repository.save(entity);
    }

    @Override
    public List<CarModel> save(List<CarModel> entities) {
        return (List<CarModel>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<CarModel> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<CarModel> findAll() {
        return (List<CarModel>) repository.findAll();
    }

    @Override
    public Page<CarModel> findAll(Pageable pageable) {
        Page<CarModel> entityPage = repository.findAll(pageable);
        List<CarModel> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public CarModel update(CarModel entity, Long id) {
        Optional<CarModel> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}