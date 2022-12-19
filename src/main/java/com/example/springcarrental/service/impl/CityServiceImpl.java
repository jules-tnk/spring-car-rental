package com.example.springcarrental.service.impl;

import com.example.springcarrental.dao.CityRepository;
import com.example.springcarrental.dto.CityDTO;
import com.example.springcarrental.mapper.CityMapper;
import com.example.springcarrental.model.City;
import com.example.springcarrental.service.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CityServiceImpl implements CityService {
    private final CityRepository repository;

    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public City save(City entity) {
        return repository.save(entity);
    }

    @Override
    public List<City> save(List<City> entities) {
        return (List<City>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<City> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<City> findAll() {
        return (List<City>) repository.findAll();
    }

    @Override
    public Page<City> findAll(Pageable pageable) {
        Page<City> entityPage = repository.findAll(pageable);
        List<City> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public City update(City entity, Long id) {
        Optional<City> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}