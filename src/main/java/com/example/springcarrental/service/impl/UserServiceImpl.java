package com.example.springcarrental.service.impl;

import com.example.springcarrental.dao.UserRepository;
import com.example.springcarrental.model.AppUser;
import com.example.springcarrental.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public AppUser save(AppUser entity) {
        return repository.save(entity);
    }

    @Override
    public List<AppUser> save(List<AppUser> entities) {
        return (List<AppUser>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AppUser> findAll() {
        return (List<AppUser>) repository.findAll();
    }

    @Override
    public Page<AppUser> findAll(Pageable pageable) {
        Page<AppUser> entityPage = repository.findAll(pageable);
        List<AppUser> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AppUser update(AppUser entity, Long id) {
        Optional<AppUser> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }

    @Override
    public AppUser getUserByEmail(String userEmail) {
        return repository.findAppUserByEmail(userEmail);
    }
}