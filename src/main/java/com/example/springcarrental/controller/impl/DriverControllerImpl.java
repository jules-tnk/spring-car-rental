package com.example.springcarrental.controller.impl;

import com.example.springcarrental.controller.DriverController;
import com.example.springcarrental.dto.DriverDTO;
import com.example.springcarrental.mapper.DriverMapper;
import com.example.springcarrental.model.Driver;
import com.example.springcarrental.service.DriverService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/driver")
@RestController
public class DriverControllerImpl implements DriverController {
    private final DriverService driverService;
    private final DriverMapper driverMapper = Mappers.getMapper(DriverMapper.class);

    public DriverControllerImpl(DriverService driverService) {
        this.driverService = driverService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DriverDTO save(@RequestBody DriverDTO driverDTO) {
        Driver driver = driverMapper.asEntity(driverDTO);
        return driverMapper.asDTO(driverService.save(driver));
    }

    @Override
    @GetMapping("/{id}")
    public DriverDTO findById(@PathVariable("id") Long id) {
        Driver driver = driverService.findById(id).orElse(null);
        return driverMapper.asDTO(driver);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        driverService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<DriverDTO> list() {
        return driverMapper.asDTOList(driverService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<DriverDTO> pageQuery(Pageable pageable) {
        Page<Driver> driverPage = driverService.findAll(pageable);
        List<DriverDTO> dtoList = driverPage
                .stream()
                .map(driverMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, driverPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public DriverDTO update(@RequestBody DriverDTO driverDTO, @PathVariable("id") Long id) {
        Driver driver = driverMapper.asEntity(driverDTO);
        return driverMapper.asDTO(driverService.update(driver, id));
    }
}