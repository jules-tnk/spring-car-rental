package com.example.springcarrental.controller.impl;

import com.example.springcarrental.controller.UserController;
import com.example.springcarrental.dto.UserDTO;
import com.example.springcarrental.mapper.UserMapper;
import com.example.springcarrental.model.User;
import com.example.springcarrental.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/user")
@RestController
public class UserControllerImpl implements UserController {
    private final UserService userService;
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO save(@RequestBody UserDTO userDTO) {
        User user = userMapper.asEntity(userDTO);
        return userMapper.asDTO(userService.save(user));
    }

    @Override
    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable("id") Long id) {
        User user = userService.findById(id).orElse(null);
        return userMapper.asDTO(user);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<UserDTO> list() {
        return userMapper.asDTOList(userService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<UserDTO> pageQuery(Pageable pageable) {
        Page<User> userPage = userService.findAll(pageable);
        List<UserDTO> dtoList = userPage
                .stream()
                .map(userMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, userPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public UserDTO update(@RequestBody UserDTO userDTO, @PathVariable("id") Long id) {
        User user = userMapper.asEntity(userDTO);
        return userMapper.asDTO(userService.update(user, id));
    }
}