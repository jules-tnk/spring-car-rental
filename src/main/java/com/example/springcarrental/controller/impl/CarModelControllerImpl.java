package com.example.springcarrental.controller.impl;

import com.example.springcarrental.controller.CarModelController;
import com.example.springcarrental.dto.CarModelDTO;
import com.example.springcarrental.mapper.CarModelMapper;
import com.example.springcarrental.model.CarModel;
import com.example.springcarrental.service.CarModelService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/car-model")
@RestController
public class CarModelControllerImpl implements CarModelController {
    private final CarModelService carModelService;
    private final CarModelMapper carModelMapper = Mappers.getMapper(CarModelMapper.class);

    public CarModelControllerImpl(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarModelDTO save(@RequestBody CarModelDTO carModelDTO) {
        CarModel carModel = carModelMapper.asEntity(carModelDTO);
        return carModelMapper.asDTO(carModelService.save(carModel));
    }

    @Override
    @GetMapping("/{id}")
    public CarModelDTO findById(@PathVariable("id") Long id) {
        CarModel carModel = carModelService.findById(id).orElse(null);
        return carModelMapper.asDTO(carModel);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        carModelService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<CarModelDTO> list() {
        return carModelMapper.asDTOList(carModelService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<CarModelDTO> pageQuery(Pageable pageable) {
        Page<CarModel> carModelPage = carModelService.findAll(pageable);
        List<CarModelDTO> dtoList = carModelPage
                .stream()
                .map(carModelMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, carModelPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public CarModelDTO update(@RequestBody CarModelDTO carModelDTO, @PathVariable("id") Long id) {
        CarModel carModel = carModelMapper.asEntity(carModelDTO);
        return carModelMapper.asDTO(carModelService.update(carModel, id));
    }
}