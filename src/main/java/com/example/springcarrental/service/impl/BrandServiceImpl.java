package com.example.springcarrental.service.impl;

import com.example.springcarrental.dao.BrandRepository;
import com.example.springcarrental.model.Brand;
import com.example.springcarrental.service.BrandService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    private final BrandRepository repository;

    public BrandServiceImpl(BrandRepository repository) {
        this.repository = repository;
    }

    @Override
    public Brand save(Brand entity) {
        return repository.save(entity);
    }

    @Override
    public List<Brand> save(List<Brand> entities) {
        return (List<Brand>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Brand> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Brand> findAll() {
        return (List<Brand>) repository.findAll();
    }

    @Override
    public Page<Brand> findAll(Pageable pageable) {
        Page<Brand> entityPage = repository.findAll(pageable);
        List<Brand> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Brand update(Brand entity, Long id) {
        Optional<Brand> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}