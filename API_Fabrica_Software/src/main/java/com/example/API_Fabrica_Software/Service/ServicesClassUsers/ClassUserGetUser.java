package com.example.API_Fabrica_Software.Service.ServicesClassUsers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.API_Fabrica_Software.DTO.UsersDTO.userDtoInfoBasic;
import com.example.API_Fabrica_Software.Model.ClassUsers;
import com.example.API_Fabrica_Software.Repository.RepositoryUser;

@Service
public class ClassUserGetUser {
 @Autowired
 RepositoryUser repositoryUser;

 public ResponseEntity<userDtoInfoBasic> GetUser(Long id) {
  Optional<ClassUsers> usuario_selecionado = repositoryUser.findById(id);

  if (usuario_selecionado.isEmpty()) {
   return ResponseEntity.badRequest().build();
  }

  ClassUsers users = usuario_selecionado.get();

  userDtoInfoBasic usuario = new userDtoInfoBasic();

  usuario.setId(users.getId());
  usuario.setEmail(users.getEmail());
  usuario.setNome(users.getNome());
  usuario.setRoles(users.getRoles());

  return ResponseEntity.ok(usuario);
 }
}
