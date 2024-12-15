package com.pex.api_book_wise.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pex.api_book_wise.domains.auth.Auth;
import com.pex.api_book_wise.domains.user.User;
import com.pex.api_book_wise.dtos.AuthDTO;
import com.pex.api_book_wise.dtos.RegisterDTO;
import com.pex.api_book_wise.dtos.ResponseLoginDTO;
import com.pex.api_book_wise.dtos.ResponseMessageDTO;
import com.pex.api_book_wise.repositories.AuthRepository;
import com.pex.api_book_wise.repositories.UserRepository;
import com.pex.api_book_wise.services.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {
  @Autowired
  private AuthenticationManager authManager;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AuthRepository authRepository;

  @Autowired
  private TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody @Validated AuthDTO authDto) {
    var usernamePassword = new UsernamePasswordAuthenticationToken(authDto.email(), authDto.password());
    var auth = this.authManager.authenticate(usernamePassword);

    var token = this.tokenService.generateToken((Auth) auth.getPrincipal());

    return ResponseEntity.ok(new ResponseLoginDTO(token));
  }

  @PostMapping("/register")
  public ResponseEntity register(@RequestBody @Validated RegisterDTO registerDTO) {
    if (this.authRepository.findByEmail(registerDTO.email()) != null) {
      return ResponseEntity.badRequest().body(new ResponseMessageDTO("Email already exists"));
    }

    if (!registerDTO.password().equals(registerDTO.confirmPassword())) {
      return ResponseEntity.badRequest().body(new ResponseMessageDTO("Passwords not match"));
    }

    String hashPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
    this.createUserAndAuth(registerDTO.email(), hashPassword);
    return ResponseEntity.ok().build();
  }

  @Transactional
  private void createUserAndAuth(String email, String password) {
    User user = new User();
    user.setName(email);
    this.userRepository.save(user);

    Auth auth = new Auth();
    auth.setEmail(email);
    auth.setPassword(password);
    auth.setUser(user);
    this.authRepository.save(auth);
  }
}
