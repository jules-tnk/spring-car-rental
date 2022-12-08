package com.example.springcarrental.controller.impl;

import com.example.springcarrental.controller.CarRentalController;
import com.example.springcarrental.dto.CarRentalDTO;
import com.example.springcarrental.mapper.CarRentalMapper;
import com.example.springcarrental.model.CarRental;
import com.example.springcarrental.service.CarRentalService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/car-rental")
@RestController
public class CarRentalControllerImpl implements CarRentalController {
    private final CarRentalService carRentalService;
    private final CarRentalMapper carRentalMapper = Mappers.getMapper(CarRentalMapper.class);

    public CarRentalControllerImpl(CarRentalService carRentalService) {
        this.carRentalService = carRentalService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarRentalDTO save(@RequestBody CarRentalDTO carRentalDTO) {
        CarRental carRental = carRentalMapper.asEntity(carRentalDTO);
        return carRentalMapper.asDTO(carRentalService.save(carRental));
    }

    @Override
    @GetMapping("/{id}")
    public CarRentalDTO findById(@PathVariable("id") Long id) {
        CarRental carRental = carRentalService.findById(id).orElse(null);
        return carRentalMapper.asDTO(carRental);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        carRentalService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<CarRentalDTO> list() {
        return carRentalMapper.asDTOList(carRentalService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<CarRentalDTO> pageQuery(Pageable pageable) {
        Page<CarRental> carRentalPage = carRentalService.findAll(pageable);
        List<CarRentalDTO> dtoList = carRentalPage
                .stream()
                .map(carRentalMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, carRentalPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public CarRentalDTO update(@RequestBody CarRentalDTO carRentalDTO, @PathVariable("id") Long id) {
        CarRental carRental = carRentalMapper.asEntity(carRentalDTO);
        return carRentalMapper.asDTO(carRentalService.update(carRental, id));
    }
}