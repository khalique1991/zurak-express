package com.zurak.userauth.service;

import com.zurak.userauth.domain.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    User registerUser(String username, String password, String email);
    Optional<User> findUserById(UUID id);
    Optional<User> findUserByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
