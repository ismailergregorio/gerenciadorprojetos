package com.example.API_Fabrica_Software.Service.UsuarioService;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.API_Fabrica_Software.DTO.UsersDTO.criarUsuarioDTO;
import com.example.API_Fabrica_Software.DTO.UsersDTO.repostaUsuarioDTO;
import com.example.API_Fabrica_Software.DTO.UsersDTO.updateUsuarioDTO;

import jakarta.servlet.http.HttpServletRequest;

public interface UsuarioServices {
 public repostaUsuarioDTO salvar(criarUsuarioDTO usuario);

 List<repostaUsuarioDTO> usuarios();

 repostaUsuarioDTO getUser(Long id);

 ResponseEntity<?> deletaUsuario(Long id);

 ResponseEntity<?> updateUsuario(updateUsuarioDTO user);

}
