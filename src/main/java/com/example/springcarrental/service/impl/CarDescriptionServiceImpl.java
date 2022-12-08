package com.example.springcarrental.service.impl;

import com.example.springcarrental.dao.CarDescriptionRepository;
import com.example.springcarrental.model.CarDescription;
import com.example.springcarrental.service.CarDescriptionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarDescriptionServiceImpl implements CarDescriptionService {
    private final CarDescriptionRepository repository;

    public CarDescriptionServiceImpl(CarDescriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public CarDescription save(CarDescription entity) {
        return repository.save(entity);
    }

    @Override
    public List<CarDescription> save(List<CarDescription> entities) {
        return (List<CarDescription>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<CarDescription> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<CarDescription> findAll() {
        return (List<CarDescription>) repository.findAll();
    }

    @Override
    public Page<CarDescription> findAll(Pageable pageable) {
        Page<CarDescription> entityPage = repository.findAll(pageable);
        List<CarDescription> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public CarDescription update(CarDescription entity, Long id) {
        Optional<CarDescription> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}