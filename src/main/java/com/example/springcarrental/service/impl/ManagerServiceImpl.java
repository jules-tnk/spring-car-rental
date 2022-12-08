package com.example.springcarrental.service.impl;

import com.example.springcarrental.dao.ManagerRepository;
import com.example.springcarrental.model.Manager;
import com.example.springcarrental.service.ManagerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository repository;

    public ManagerServiceImpl(ManagerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Manager save(Manager entity) {
        return repository.save(entity);
    }

    @Override
    public List<Manager> save(List<Manager> entities) {
        return (List<Manager>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Manager> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Manager> findAll() {
        return (List<Manager>) repository.findAll();
    }

    @Override
    public Page<Manager> findAll(Pageable pageable) {
        Page<Manager> entityPage = repository.findAll(pageable);
        List<Manager> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Manager update(Manager entity, Long id) {
        Optional<Manager> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}