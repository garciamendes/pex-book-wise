package com.pex.api_book_wise.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.pex.api_book_wise.domains.auth.Auth;

@Service
public class TokenService {
  @Value("${api.security.token.secret}")
  private String secret;

  public String generateToken(Auth auth) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      String token = JWT.create()
          .withIssuer("api-auth")
          .withSubject(auth.getEmail())
          .withExpiresAt(this.genExpirationDate())
          .sign(algorithm);

      return token;
    } catch (JWTCreationException exception) {
      throw new RuntimeException("Error generating token", exception);
    }
  }

  public String verifyToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);

      String auth = JWT.require(algorithm)
          .withIssuer("api-auth")
          .build()
          .verify(token)
          .getSubject();

      return auth;
    } catch (JWTVerificationException e) {
      System.out.println("Erro ao validar o token JWT: " + e.getMessage());
      return "";
    }
  }

  private Instant genExpirationDate() {
    return LocalDateTime.now().plusHours(24).toInstant(ZoneOffset.of("-03:00"));
  }
}
