package com.example.springcarrental.mapper;

import com.example.springcarrental.dto.AgentDTO;
import com.example.springcarrental.model.Agent;
import org.mapstruct.Mapper;

@Mapper
public interface AgentMapper extends GenericMapper<Agent, AgentDTO> {
    @Override
    Agent asEntity(AgentDTO dto);


}