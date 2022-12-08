package com.example.springcarrental.controller.impl;

import com.example.springcarrental.controller.CarController;
import com.example.springcarrental.dto.CarDTO;
import com.example.springcarrental.mapper.CarMapper;
import com.example.springcarrental.model.Car;
import com.example.springcarrental.service.CarService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/car")
@RestController
public class CarControllerImpl implements CarController {
    private final CarService carService;
    private final CarMapper carMapper = Mappers.getMapper(CarMapper.class);

    public CarControllerImpl(CarService carService) {
        this.carService = carService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO save(@RequestBody CarDTO carDTO) {
        Car car = carMapper.asEntity(carDTO);
        return carMapper.asDTO(carService.save(car));
    }

    @Override
    @GetMapping("/{id}")
    public CarDTO findById(@PathVariable("id") String id) {
        Car car = carService.findById(id).orElse(null);
        return carMapper.asDTO(car);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        carService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<CarDTO> list() {
        return carMapper.asDTOList(carService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<CarDTO> pageQuery(Pageable pageable) {
        Page<Car> carPage = carService.findAll(pageable);
        List<CarDTO> dtoList = carPage
                .stream()
                .map(carMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, carPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public CarDTO update(@RequestBody CarDTO carDTO, @PathVariable("id") String id) {
        Car car = carMapper.asEntity(carDTO);
        return carMapper.asDTO(carService.update(car, id));
    }
}