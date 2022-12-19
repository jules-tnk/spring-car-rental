package com.example.springcarrental.controller.impl;

import com.example.springcarrental.controller.ManagerController;
import com.example.springcarrental.dto.ManagerDTO;
import com.example.springcarrental.mapper.ManagerMapper;
import com.example.springcarrental.model.Manager;
import com.example.springcarrental.service.ManagerService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/manager")
@RestController
public class ManagerControllerImpl implements ManagerController {
    private final ManagerService managerService;
    private final ManagerMapper managerMapper = Mappers.getMapper(ManagerMapper.class);

    public ManagerControllerImpl(ManagerService managerService) {
        this.managerService = managerService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ManagerDTO save(@RequestBody ManagerDTO managerDTO) {
        Manager manager = managerMapper.asEntity(managerDTO);
        return managerMapper.asDTO(managerService.save(manager));
    }

    @Override
    @GetMapping("/{id}")
    public ManagerDTO findById(@PathVariable("id") Long id) {
        Manager manager = managerService.findById(id).orElse(null);
        return managerMapper.asDTO(manager);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        managerService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<ManagerDTO> list() {
        return managerMapper.asDTOList(managerService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<ManagerDTO> pageQuery(Pageable pageable) {
        Page<Manager> managerPage = managerService.findAll(pageable);
        List<ManagerDTO> dtoList = managerPage
                .stream()
                .map(managerMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, managerPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public ManagerDTO update(@RequestBody ManagerDTO managerDTO, @PathVariable("id") Long id) {
        Manager manager = managerMapper.asEntity(managerDTO);
        return managerMapper.asDTO(managerService.update(manager, id));
    }
}