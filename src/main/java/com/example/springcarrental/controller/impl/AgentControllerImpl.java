package com.example.springcarrental.controller.impl;

import com.example.springcarrental.controller.AgentController;
import com.example.springcarrental.dto.AgentDTO;
import com.example.springcarrental.model.Agent;
import com.example.springcarrental.service.AgentService;
import com.example.springcarrental.mapper.AgentMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/agent")
@RestController
public class AgentControllerImpl implements AgentController {
    private final AgentService agentService;
    private final AgentMapper agentMapper = Mappers.getMapper(AgentMapper.class);

    public AgentControllerImpl(AgentService agentService) {
        this.agentService = agentService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgentDTO save(@RequestBody AgentDTO agentDTO) {
        Agent agent = agentMapper.asEntity(agentDTO);
        return agentMapper.asDTO(agentService.save(agent));
    }

    @Override
    @GetMapping("/{id}")
    public AgentDTO findById(@PathVariable("id") Long id) {
        Agent agent = agentService.findById(id).orElse(null);
        return agentMapper.asDTO(agent);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        agentService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AgentDTO> list() {
        return agentMapper.asDTOList(agentService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AgentDTO> pageQuery(Pageable pageable) {
        Page<Agent> agentPage = agentService.findAll(pageable);
        List<AgentDTO> dtoList = agentPage
                .stream()
                .map(agentMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, agentPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AgentDTO update(@RequestBody AgentDTO agentDTO, @PathVariable("id") Long id) {
        Agent agent = agentMapper.asEntity(agentDTO);
        return agentMapper.asDTO(agentService.update(agent, id));
    }
}