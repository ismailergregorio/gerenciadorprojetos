package com.example.API_Fabrica_Software.Service.UsuarioService.implementacao;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.API_Fabrica_Software.DTO.AuthDTO.authDTO;
import com.example.API_Fabrica_Software.Model.ClassUsuario;
import com.example.API_Fabrica_Software.Repository.RepositoryUsuario;
import com.example.API_Fabrica_Software.Service.UsuarioService.AuthenticacaoServises;

@Service
public class AuthenticacaoServices implements AuthenticacaoServises {

    @Autowired
    RepositoryUsuario repositoryUsuario;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return repositoryUsuario.findByLogin(login);
    }

    @Override
    public String obtetToken(authDTO ayAuthDTO) {

        ClassUsuario usuario = repositoryUsuario.findByLogin(ayAuthDTO.login());
        return geraToken(usuario);
    }

    public String geraToken(ClassUsuario usuario) {

        try {
            Algorithm algorithm = Algorithm.HMAC256("my-secret");
            return JWT.create().withIssuer("auth-api")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(geraDataExpiracao())
                    .sign(algorithm);
        } catch (Exception e) {
            return "Erro ao gerar token";
        }
    }

    private Instant geraDataExpiracao() {
        return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
    }

}
