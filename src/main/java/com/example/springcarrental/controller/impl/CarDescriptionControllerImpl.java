package com.example.springcarrental.controller.impl;

import com.example.springcarrental.controller.CarDescriptionController;
import com.example.springcarrental.dto.CarDescriptionDTO;
import com.example.springcarrental.mapper.CarDescriptionMapper;
import com.example.springcarrental.model.CarDescription;
import com.example.springcarrental.service.CarDescriptionService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/car-description")
@RestController
public class CarDescriptionControllerImpl implements CarDescriptionController {
    private final CarDescriptionService carDescriptionService;
    private final CarDescriptionMapper carDescriptionMapper = Mappers.getMapper(CarDescriptionMapper.class);

    public CarDescriptionControllerImpl(CarDescriptionService carDescriptionService) {
        this.carDescriptionService = carDescriptionService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarDescriptionDTO save(@RequestBody CarDescriptionDTO carDescriptionDTO) {
        CarDescription carDescription = carDescriptionMapper.asEntity(carDescriptionDTO);
        return carDescriptionMapper.asDTO(carDescriptionService.save(carDescription));
    }

    @Override
    @GetMapping("/{id}")
    public CarDescriptionDTO findById(@PathVariable("id") Long id) {
        CarDescription carDescription = carDescriptionService.findById(id).orElse(null);
        return carDescriptionMapper.asDTO(carDescription);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        carDescriptionService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<CarDescriptionDTO> list() {
        return carDescriptionMapper.asDTOList(carDescriptionService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<CarDescriptionDTO> pageQuery(Pageable pageable) {
        Page<CarDescription> carDescriptionPage = carDescriptionService.findAll(pageable);
        List<CarDescriptionDTO> dtoList = carDescriptionPage
                .stream()
                .map(carDescriptionMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, carDescriptionPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public CarDescriptionDTO update(@RequestBody CarDescriptionDTO carDescriptionDTO, @PathVariable("id") Long id) {
        CarDescription carDescription = carDescriptionMapper.asEntity(carDescriptionDTO);
        return carDescriptionMapper.asDTO(carDescriptionService.update(carDescription, id));
    }
}