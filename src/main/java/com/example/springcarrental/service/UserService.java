package com.example.springcarrental.service;

import com.example.springcarrental.model.AppUser;

public interface UserService extends GenericService<AppUser, Long> {
    AppUser getUserByEmail(String userEmail);
}