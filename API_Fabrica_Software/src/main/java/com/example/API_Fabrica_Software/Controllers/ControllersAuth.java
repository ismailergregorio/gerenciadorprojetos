package com.example.API_Fabrica_Software.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_Fabrica_Software.DTO.AuthDTO.ResponseAuthDTO;
import com.example.API_Fabrica_Software.DTO.AuthDTO.authDTO;
import com.example.API_Fabrica_Software.DTO.AuthDTO.authRefrashToker;
import com.example.API_Fabrica_Software.Service.UsuarioService.implementacao.AuthenticacaoService;

import org.springframework.beans.factory.annotation.Autowired;
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
    AuthenticacaoService authenticacaoServices;

    @PostMapping
    public ResponseAuthDTO auth(@RequestBody authDTO entity) {
        System.out.println(entity.login() + entity.senha());
        var usuarioAutenticadoComToken = new UsernamePasswordAuthenticationToken(entity.login(), entity.senha());
        authenticationManager.authenticate(usuarioAutenticadoComToken);
        return authenticacaoServices.obtetToken(entity);
    }

    @PostMapping("/refresh")
    public ResponseAuthDTO authRefreshToker(@RequestBody authRefrashToker refresh) {
        return authenticacaoServices.obtetTokenRefreshToker(refresh.refresh());
    }

}
