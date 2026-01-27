package com.example.API_Fabrica_Software.DTO.UsersDTO;

import com.example.API_Fabrica_Software.Enun.NivelUsuario;
import com.example.API_Fabrica_Software.Model.ClassUsuario;

public record repostaUsuarioDTO(String usuario, String login, NivelUsuario role) {

 public repostaUsuarioDTO(ClassUsuario u) {
  this(u.getNome(),u.getLogin(), u.getRoles());
 }

}
