package com.example.API_Fabrica_Software.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_Fabrica_Software.DTO.authiction.LoginRequestDTO;
import com.example.API_Fabrica_Software.DTO.authiction.RegisterRequestDTO;
import com.example.API_Fabrica_Software.DTO.authiction.ResponseDTO;
import com.example.API_Fabrica_Software.InfraSercurity.TokenService;
import com.example.API_Fabrica_Software.Model.ClassUsers;
import com.example.API_Fabrica_Software.Repository.RepositoryUser;

import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private RepositoryUser repository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequestDTO body) {

    ClassUsers user = repository.findByEmail(body.email())
        .orElseThrow(() -> new RuntimeException("User not found"));

    if (passwordEncoder.matches(body.password(), user.getPassword())) {
      String token = tokenService.generateToken(user);
      return ResponseEntity.ok(new ResponseDTO(user.getNome(), token));
    }

    return ResponseEntity.status(401).body("Senha inválida");
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody RegisterRequestDTO body) {
    System.out.println("NAME: " + body.name());
    System.out.println("EMAIL: " + body.email());
    System.out.println("PASSWORD: " + body.password());

    if (repository.findByEmail(body.email()).isPresent()) {
      return ResponseEntity.badRequest().body("Usuário já existe");
    }

    ClassUsers newUser = new ClassUsers();
    newUser.setEmail(body.email());
    newUser.setNome(body.name());
    newUser.setPassword(passwordEncoder.encode(body.password()));
    newUser.setRoles("new_list");

    repository.save(newUser);

    String token = tokenService.generateToken(newUser);
    return ResponseEntity.ok(new ResponseDTO(newUser.getNome(), token));
  }
}
