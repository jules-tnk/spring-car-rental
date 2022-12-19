package com.example.springcarrental.controller.impl;

import com.example.springcarrental.controller.ClientController;
import com.example.springcarrental.dto.ClientDTO;
import com.example.springcarrental.mapper.ClientMapper;
import com.example.springcarrental.model.Client;
import com.example.springcarrental.service.ClientService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/client")
@RestController
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);

    public ClientControllerImpl(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO save(@RequestBody ClientDTO clientDTO) {
        Client client = clientMapper.asEntity(clientDTO);
        return clientMapper.asDTO(clientService.save(client));
    }

    @Override
    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable("id") Long id) {
        Client client = clientService.findById(id).orElse(null);
        return clientMapper.asDTO(client);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        clientService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<ClientDTO> list() {
        return clientMapper.asDTOList(clientService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<ClientDTO> pageQuery(Pageable pageable) {
        Page<Client> clientPage = clientService.findAll(pageable);
        List<ClientDTO> dtoList = clientPage
                .stream()
                .map(clientMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, clientPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public ClientDTO update(@RequestBody ClientDTO clientDTO, @PathVariable("id") Long id) {
        Client client = clientMapper.asEntity(clientDTO);
        return clientMapper.asDTO(clientService.update(client, id));
    }
}