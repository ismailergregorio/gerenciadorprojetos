package com.example.API_Fabrica_Software.Service.UsuarioService;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.API_Fabrica_Software.DTO.AuthDTO.authDTO;

public interface AuthenticacaoServises extends UserDetailsService{
    public String obtetToken(authDTO ayAuthDTO);
}
