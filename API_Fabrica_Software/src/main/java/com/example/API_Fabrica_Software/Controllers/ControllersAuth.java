package com.example.API_Fabrica_Software.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_Fabrica_Software.DTO.AuthDTO.authDTO;
import com.example.API_Fabrica_Software.Service.Auth.AuthenticationServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class ControllersAuth {
 @Autowired
 AuthenticationManager authenticationManager;
 @Autowired
 AuthenticationServices authenticationServices;

 @PostMapping()
 public ResponseEntity<?> auth(@RequestBody authDTO auth) {
  // TODO: process POST request
  var usuarioAuth = new UsernamePasswordAuthenticationToken(auth.email(), auth.senha());
  authenticationManager.authenticate(usuarioAuth);
  return ResponseEntity.ok(authenticationServices.obterToken(auth));
 }

}
