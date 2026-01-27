package com.example.API_Fabrica_Software.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_Fabrica_Software.DTO.AuthDTO.ResponseAuthDTO;
import com.example.API_Fabrica_Software.DTO.AuthDTO.authDTO;
import com.example.API_Fabrica_Software.Service.UsuarioService.implementacao.AuthenticacaoServices;

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
    AuthenticacaoServices authenticacaoServices;

    @PostMapping
    public ResponseAuthDTO auth(@RequestBody authDTO entity) {
        var usuarioAutenticadoComToken = new UsernamePasswordAuthenticationToken(entity.login(), entity.senha());
        authenticationManager.authenticate(usuarioAutenticadoComToken);
        return new ResponseAuthDTO(authenticacaoServices.obtetToken(entity), null);
    }

}
