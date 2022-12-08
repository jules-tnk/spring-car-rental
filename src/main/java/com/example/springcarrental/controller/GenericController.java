package com.example.springcarrental.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface GenericController<EntityDTO, I>{
    public EntityDTO save(@RequestBody EntityDTO agency);

    public EntityDTO findById(@PathVariable("id") I id);

    public void delete(@PathVariable("id") I id);

    public List<EntityDTO> list();

    public Page<EntityDTO> pageQuery(Pageable pageable);

    public EntityDTO update(@RequestBody EntityDTO dto, @PathVariable("id") I id);
}
