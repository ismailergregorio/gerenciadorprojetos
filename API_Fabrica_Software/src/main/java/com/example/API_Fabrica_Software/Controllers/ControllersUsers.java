package com.example.API_Fabrica_Software.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_Fabrica_Software.DTO.UsersDTO.criarUsuarioDTO;
import com.example.API_Fabrica_Software.Service.UsuarioService.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class ControllersUsers {
 @Autowired
 UsuarioService servise;

 @PostMapping()
 public ResponseEntity<?> postUser(@RequestBody criarUsuarioDTO entity) {
  return servise.salvar(entity);
 }

}
