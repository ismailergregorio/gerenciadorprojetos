package com.example.API_Fabrica_Software.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_Fabrica_Software.DTO.UsersDTO.criarUsuarioDTO;
import com.example.API_Fabrica_Software.DTO.UsersDTO.repostaUsuarioDTO;
import com.example.API_Fabrica_Software.Service.UsuarioService.UsuarioServices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/user")
public class ControllersUsers {
 @Autowired
 UsuarioServices usuarioServices;

 @PostMapping()
 public repostaUsuarioDTO postMethodName(@RequestBody criarUsuarioDTO entity) {
     return usuarioServices.salvar(entity);
 }

 @GetMapping()
 public List<repostaUsuarioDTO> getMethodName() {
     return usuarioServices.usuarios();
 }
 
 
}
