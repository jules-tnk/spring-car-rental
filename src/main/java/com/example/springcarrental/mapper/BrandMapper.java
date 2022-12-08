package com.example.springcarrental.mapper;

import com.example.springcarrental.dto.BrandDTO;
import com.example.springcarrental.model.Brand;
import org.mapstruct.Mapper;

@Mapper
public interface BrandMapper extends GenericMapper<Brand, BrandDTO> {
    @Override
    Brand asEntity(BrandDTO dto);
}