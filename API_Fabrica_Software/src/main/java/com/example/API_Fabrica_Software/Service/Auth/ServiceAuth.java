package com.example.API_Fabrica_Software.Service.Auth;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.API_Fabrica_Software.DTO.AuthDTO.ResponseAuthDTO;
import com.example.API_Fabrica_Software.DTO.AuthDTO.authDTO;
import com.example.API_Fabrica_Software.Model.Usuario;
import com.example.API_Fabrica_Software.Repository.RepositoryUsuario;

@Service
public class ServiceAuth implements AuthenticationServices {

  @Value("${jwt.secret}")
  private String secret;
  @Value("${jwt.expiration}")
  private Integer time_token;
  @Value("${jwt.refresh-token}")
  private Integer time_refresh;

  @Autowired
  RepositoryUsuario repository;

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    return repository.findByLogin(login);
  }

  public String geraToken(Usuario usuario, Integer timeExpire) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.create()
          .withIssuer("auth-api")
          .withSubject(usuario.getLogin())
          .withClaim("roles", List.of(usuario.getRoles().name()))
          .withExpiresAt(geraDataExipiracao(timeExpire))
          .sign(algorithm);
    } catch (JWTCreationException exception) {
      return "erro na criação do Toker";
    }
  }

  @Override
  public ResponseAuthDTO obterToken(authDTO authDTO) {
    Usuario usuario = repository.findByLogin(authDTO.email());
    return ResponseAuthDTO
        .builder()
        .toker(geraToken(usuario, time_token))
        .build();
  }

  public String validarToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      // System.out.println("HEADER Authorization = " + request.getHeader("Authorization"));
      System.out.println("TOKEN EXTRAÍDO = [" + token + "]");
      return JWT.require(algorithm)
          .withIssuer("auth-api")
          .build()
          .verify(token)
          .getSubject();

    } catch (TokenExpiredException e) {
      throw e; // deixa o filtro tratar como token expirado

    } catch (JWTVerificationException e) {
      throw e; // token inválido
    }
  }

  private Instant geraDataExipiracao(Integer timeExpiracao) {
    return LocalDateTime.now().plusMinutes(timeExpiracao).toInstant(ZoneOffset.of("-03:00"));
  }
}
