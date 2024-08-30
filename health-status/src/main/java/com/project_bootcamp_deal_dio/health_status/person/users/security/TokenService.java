package com.project_bootcamp_deal_dio.health_status.person.users.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.project_bootcamp_deal_dio.health_status.person.users.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

  @Value("{api.security.token.secret}")
  private String secret;

  public String generateToken(Users users) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      String token =
          JWT.create()
              .withIssuer("health_status")
              .withSubject(users.getLogin())
              .withExpiresAt(genExpirationDate())
              .sign(algorithm);
      return token;
    } catch (JWTCreationException e) {
      throw new JWTCreationException("Ocorreu um erro ao gerar o token", e);
    }
  }

  private Instant genExpirationDate() {
    return LocalDateTime.now().plusHours(24).toInstant(ZoneOffset.of("-03:00"));
  }

  public String validateToken(String token) {
    try{
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.require(algorithm)
              .withIssuer("health_status")
              .build()
              .verify(token)
              .getSubject();
    } catch (JWTVerificationException e) {
      throw new JWTVerificationException("Token inválido ou expirado", e);
    }
  }
}