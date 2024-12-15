package com.pex.api_book_wise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pex.api_book_wise.repositories.AuthRepository;

@Service
public class AuthenticateService implements UserDetailsService {
  @Autowired
  private AuthRepository authRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return this.authRepository.findByEmail(email);
  }

}
