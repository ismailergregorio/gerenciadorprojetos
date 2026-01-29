package com.example.API_Fabrica_Software.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_Fabrica_Software.DTO.UsersDTO.criarUsuarioDTO;
import com.example.API_Fabrica_Software.DTO.UsersDTO.repostaUsuarioDTO;
import com.example.API_Fabrica_Software.Enun.NivelUsuario;
import com.example.API_Fabrica_Software.Model.ClassUsuario;
import com.example.API_Fabrica_Software.Service.UsuarioService.UsuarioServices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/user")
public class ControllersUsers {
    @Autowired
    UsuarioServices usuarioServices;

    @PostMapping()
    public repostaUsuarioDTO postMethodName(@RequestBody criarUsuarioDTO entity) {
        return usuarioServices.salvar(entity);
    }

    @GetMapping()
    @PreAuthorize("hasAnyRole(\"ADMIN\",\"USER\")")
    public List<repostaUsuarioDTO> getMethodName(Authentication auth) {
        ClassUsuario usuarioLogado = (ClassUsuario) auth.getPrincipal();
        System.out.println(usuarioLogado.getRoles());

        if (!usuarioLogado.getRoles().equals(NivelUsuario.ADMIN)) {
            return List.of(
                    usuarioServices.getUser(usuarioLogado.getId()));
        }
        return usuarioServices.usuarios();

    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole(\"ADMIN\",\"USER\")")
    public ResponseEntity<?> getMethodName(@PathVariable Long id, Authentication auth) {
        ClassUsuario usuarioLogado = (ClassUsuario) auth.getPrincipal();
        System.out.println(usuarioLogado.getRoles());

        var user = usuarioServices.getUser(id);

        if (user == null) {
            return ResponseEntity.badRequest().body("Usuario não Existe");
        }

        if (!usuarioLogado.getRoles().equals(NivelUsuario.ADMIN)) {
            return ResponseEntity.ok().body(usuarioServices.getUser(usuarioLogado.getId()));
        }

        return ResponseEntity.ok().body(user);
    }

}
