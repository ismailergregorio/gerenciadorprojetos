package com.example.API_Fabrica_Software.Service.UsuarioService;

import java.util.List;

import com.example.API_Fabrica_Software.DTO.UsersDTO.criarUsuarioDTO;
import com.example.API_Fabrica_Software.DTO.UsersDTO.repostaUsuarioDTO;

public interface UsuarioServices {
 public repostaUsuarioDTO salvar(criarUsuarioDTO usuario);

 List<repostaUsuarioDTO> usuarios();
}
