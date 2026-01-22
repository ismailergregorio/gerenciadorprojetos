package com.example.API_Fabrica_Software.Service.UsuarioService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.API_Fabrica_Software.DTO.UsersDTO.criarUsuarioDTO;
import com.example.API_Fabrica_Software.DTO.UsersDTO.repostaUsuarioDTO;
import com.example.API_Fabrica_Software.Repository.RepositoryUsuario;
import com.example.API_Fabrica_Software.Model.Usuario;

@Service
public class UsuarioService {
  @Autowired
  RepositoryUsuario repositoryUsuario;
  @Autowired
  PasswordEncoder encoder;

  public ResponseEntity<?> salvar(criarUsuarioDTO usuario) {
    Optional<Usuario> user = repositoryUsuario.existsByLogin(usuario.login());
    if (!user.isPresent()) {
      return ResponseEntity.notFound().build();
    }
    Usuario novoUsuario = new Usuario();
    var senhaCriptografada =  encoder.encode(usuario.senha());
    novoUsuario.setLogin(usuario.login());
    novoUsuario.setNome(usuario.nome());
    novoUsuario.setSenha(senhaCriptografada);
    novoUsuario.setRoles(usuario.roles());

    repositoryUsuario.save(novoUsuario);
    return ResponseEntity.ok().body(new repostaUsuarioDTO(novoUsuario));
  }
}
