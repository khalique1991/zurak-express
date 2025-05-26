package com.zurak.userauth.domain;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;
    private String password;
    private String email;
    public User(){

    }
    public User(String username, String encodedPassword, String email) {
        this.username=username;
        this.password=encodedPassword;
        this.email= email;
    }

    // Constructors, getters, setters

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // You might have roles associated with your user
        // For now, let's just return an empty list or a default role
        return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Or based on your logic
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Or based on your logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Or based on your logic
    }

    @Override
    public boolean isEnabled() {
        return true; // Or based on your logic
    }
}