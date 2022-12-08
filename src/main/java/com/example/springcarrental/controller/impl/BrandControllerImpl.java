package com.example.springcarrental.controller.impl;

import com.example.springcarrental.controller.BrandController;
import com.example.springcarrental.dto.BrandDTO;
import com.example.springcarrental.mapper.BrandMapper;
import com.example.springcarrental.model.Brand;
import com.example.springcarrental.service.BrandService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/brand")
@RestController
public class BrandControllerImpl implements BrandController {
    private final BrandService brandService;
    private final BrandMapper brandMapper = Mappers.getMapper(BrandMapper.class);

    public BrandControllerImpl(BrandService brandService) {
        this.brandService = brandService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BrandDTO save(@RequestBody BrandDTO brandDTO) {
        Brand brand = brandMapper.asEntity(brandDTO);
        return brandMapper.asDTO(brandService.save(brand));
    }

    @Override
    @GetMapping("/{id}")
    public BrandDTO findById(@PathVariable("id") Long id) {
        Brand brand = brandService.findById(id).orElse(null);
        return brandMapper.asDTO(brand);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        brandService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<BrandDTO> list() {
        return brandMapper.asDTOList(brandService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<BrandDTO> pageQuery(Pageable pageable) {
        Page<Brand> brandPage = brandService.findAll(pageable);
        List<BrandDTO> dtoList = brandPage
                .stream()
                .map(brandMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, brandPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public BrandDTO update(@RequestBody BrandDTO brandDTO, @PathVariable("id") Long id) {
        Brand brand = brandMapper.asEntity(brandDTO);
        return brandMapper.asDTO(brandService.update(brand, id));
    }
}