package com.example.API_Fabrica_Software.Service.ServicesClassUsers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.API_Fabrica_Software.DTO.UsersDTO.userDtoInfoBasic;
import com.example.API_Fabrica_Software.Model.ClassUsers;
import com.example.API_Fabrica_Software.Repository.RepositoryUser;

@Service
public class ClassUserGetUsers {
 @Autowired
 RepositoryUser repositoryUser;

 public ResponseEntity<List<userDtoInfoBasic>> getUsers() {
  List<ClassUsers> dados = repositoryUser.findAll();

  if (dados.isEmpty()) {
   return ResponseEntity.noContent().build();
  }

  List<userDtoInfoBasic> userDTOS = dados.stream().map(user -> new userDtoInfoBasic(
   user.getId(),user.getNome(),user.getEmail(),user.getRoles()
  )).toList();
  

  return ResponseEntity.ok(userDTOS);
 }
}
