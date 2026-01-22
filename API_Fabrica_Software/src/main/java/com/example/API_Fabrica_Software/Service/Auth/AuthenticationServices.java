package com.example.API_Fabrica_Software.Service.Auth;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.API_Fabrica_Software.DTO.AuthDTO.ResponseAuthDTO;
import com.example.API_Fabrica_Software.DTO.AuthDTO.authDTO;

public interface AuthenticationServices extends UserDetailsService{

 public ResponseAuthDTO obterToken(authDTO authDTO);
 public String validarToken(String token);
 
}
