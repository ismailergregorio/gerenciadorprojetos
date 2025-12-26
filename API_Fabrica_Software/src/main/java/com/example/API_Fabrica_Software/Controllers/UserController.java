package com.example.API_Fabrica_Software.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_Fabrica_Software.DTO.UsersDTO.userDtoInfoBasic;
import com.example.API_Fabrica_Software.Service.ServicesClassUsers.ClassUserGetUser;
import com.example.API_Fabrica_Software.Service.ServicesClassUsers.ClassUserGetUsers;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    ClassUserGetUsers servicesClassUsersGets;

    @Autowired
    ClassUserGetUser serviUser;

    @GetMapping
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("sucesso!");
    }

    @GetMapping("/cont")
    public ResponseEntity<List<userDtoInfoBasic>> getUsers(){
        return servicesClassUsersGets.getUsers();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<userDtoInfoBasic> getUser(@PathVariable Long id){
        return serviUser.GetUser(id);
    }

}