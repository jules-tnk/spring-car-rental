package com.example.springcarrental.service.impl;

import com.example.springcarrental.dao.AgencyRepository;
import com.example.springcarrental.model.Agency;
import com.example.springcarrental.service.AgencyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AgencyServiceImpl implements AgencyService {
    private final AgencyRepository repository;

    public AgencyServiceImpl(AgencyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Agency save(Agency entity) {
        return repository.save(entity);
    }

    @Override
    public List<Agency> save(List<Agency> entities) {
        return (List<Agency>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Agency> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Agency> findAll() {
        return (List<Agency>) repository.findAll();
    }

    @Override
    public Page<Agency> findAll(Pageable pageable) {
        Page<Agency> entityPage = repository.findAll(pageable);
        List<Agency> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Agency update(Agency entity, Long id) {
        Optional<Agency> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}