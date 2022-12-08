package com.example.springcarrental.controller.impl;

import com.example.springcarrental.controller.AgencyController;
import com.example.springcarrental.dto.AgencyDTO;
import com.example.springcarrental.mapper.AgencyMapper;
import com.example.springcarrental.model.Agency;
import com.example.springcarrental.service.AgencyService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/agency")
@RestController
public class AgencyControllerImpl implements AgencyController {
    private final AgencyService agencyService;
    private final AgencyMapper agencyMapper = Mappers.getMapper(AgencyMapper.class);

    public AgencyControllerImpl(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @Override
    @PostMapping
    public AgencyDTO save(@RequestBody AgencyDTO agencyDTO) {
        Agency agency = agencyMapper.asEntity(agencyDTO);
        return agencyMapper.asDTO(agencyService.save(agency));
    }

    @Override
    @GetMapping("/{id}")
    public AgencyDTO findById(@PathVariable("id") Long id) {
        Agency agency = agencyService.findById(id).orElse(null);
        return agencyMapper.asDTO(agency);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        agencyService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AgencyDTO> list() {
        return agencyMapper.asDTOList(agencyService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AgencyDTO> pageQuery(Pageable pageable) {
        Page<Agency> agencyPage = agencyService.findAll(pageable);
        List<AgencyDTO> dtoList = agencyPage
                .stream()
                .map(agencyMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, agencyPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AgencyDTO update(@RequestBody AgencyDTO agencyDTO, @PathVariable("id") Long id) {
        Agency agency = agencyMapper.asEntity(agencyDTO);
        return agencyMapper.asDTO(agencyService.update(agency, id));
    }
}