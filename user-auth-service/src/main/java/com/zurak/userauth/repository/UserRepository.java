package com.zurak.userauth.repository;

import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import com.zurak.userauth.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


public interface UserRepository extends SpannerRepository<User, UUID> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
