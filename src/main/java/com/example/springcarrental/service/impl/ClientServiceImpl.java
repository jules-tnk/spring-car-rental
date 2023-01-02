package com.example.springcarrental.service.impl;

import com.example.springcarrental.dao.ClientRepository;
import com.example.springcarrental.model.Client;
import com.example.springcarrental.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client save(Client entity) {
        return repository.save(entity);
    }

    @Override
    public List<Client> save(List<Client> entities) {
        return (List<Client>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return (List<Client>) repository.findAll();
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
        Page<Client> entityPage = repository.findAll(pageable);
        List<Client> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Client update(Client entity, Long id) {
        Optional<Client> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }


    @Override
    public Client getByEmail(String email) {
        return repository.findByEmail(email);
    }
}