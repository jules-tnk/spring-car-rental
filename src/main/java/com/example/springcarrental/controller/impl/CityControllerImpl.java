package com.example.springcarrental.controller.impl;

import com.example.springcarrental.controller.CityController;
import com.example.springcarrental.dto.CityDTO;
import com.example.springcarrental.mapper.CityMapper;
import com.example.springcarrental.model.City;
import com.example.springcarrental.service.CityService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/city")
@RestController
public class CityControllerImpl implements CityController {
    private final CityService cityService;
    private final CityMapper cityMapper = Mappers.getMapper(CityMapper.class);

    public CityControllerImpl(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CityDTO save(@RequestBody CityDTO cityDTO) {
        City city = cityMapper.asEntity(cityDTO);
        return cityMapper.asDTO(cityService.save(city));
    }

    @Override
    @GetMapping("/{id}")
    public CityDTO findById(@PathVariable("id") Long id) {
        City city = cityService.findById(id).orElse(null);
        return cityMapper.asDTO(city);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        cityService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<CityDTO> list() {
        return cityMapper.asDTOList(cityService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<CityDTO> pageQuery(Pageable pageable) {
        Page<City> cityPage = cityService.findAll(pageable);
        List<CityDTO> dtoList = cityPage
                .stream()
                .map(cityMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, cityPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public CityDTO update(@RequestBody CityDTO cityDTO, @PathVariable("id") Long id) {
        City city = cityMapper.asEntity(cityDTO);
        return cityMapper.asDTO(cityService.update(city, id));
    }
}