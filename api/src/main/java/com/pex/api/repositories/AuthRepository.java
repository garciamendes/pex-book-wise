package com.pex.api.repositories;

import com.pex.api.entities.Auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface AuthRepository extends JpaRepository<Auth, UUID> {
    UserDetails findByEmail(String email);
}
