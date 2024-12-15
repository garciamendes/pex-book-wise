package com.pex.api_book_wise.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.pex.api_book_wise.domains.auth.Auth;

public interface AuthRepository extends JpaRepository<Auth, UUID> {
  UserDetails findByEmail(String email);
}
