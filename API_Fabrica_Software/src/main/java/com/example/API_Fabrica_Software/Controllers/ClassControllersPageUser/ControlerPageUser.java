package com.example.API_Fabrica_Software.Controllers.ClassControllersPageUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_Fabrica_Software.DTO.RetornoDTOpeges.RetornoAlunosDTO;
import com.example.API_Fabrica_Software.DTO.RetornoDTOpeges.RetornoGestorDTO;
import com.example.API_Fabrica_Software.DTO.RetornoDTOpeges.RetornoProjetosDTO;
import com.example.API_Fabrica_Software.Service.PaginaUserService.PaginaUserAluno;
import com.example.API_Fabrica_Software.Service.PaginaUserService.PaginaUserGestores;
import com.example.API_Fabrica_Software.Service.PaginaUserService.PaginaUserProjeto;

@RestController
@RequestMapping("/page")
public class ControlerPageUser {

    @Autowired
    PaginaUserAluno paginaUserAluno;

    @Autowired
    PaginaUserProjeto paginaUserProjeto;

    @Autowired
    PaginaUserGestores paginaUserGestores;

    @GetMapping("/alunos")
    public ResponseEntity<List<RetornoAlunosDTO>> getAlunosPage() {
        System.out.println("Chegou");
        return ResponseEntity.ok().body(paginaUserAluno.getAlunosPeges());
    }

    @GetMapping("/aluno/{ra}")
    public ResponseEntity<RetornoAlunosDTO> getAlunoPage(@PathVariable String ra) {
        return ResponseEntity.ok().body(paginaUserAluno.getAlunoPege(ra));
    }

    @GetMapping("/projetos")
    public ResponseEntity<List<RetornoProjetosDTO>> getProjetosPage() {
        return ResponseEntity.ok().body(paginaUserProjeto.getProjetos());
    }

    @GetMapping("/projeto/{codigoProjeto}")
    public ResponseEntity<RetornoProjetosDTO> getProjetoPage(@PathVariable String codigoProjeto) {
        return ResponseEntity.ok().body(paginaUserProjeto.getProjeto(codigoProjeto));
    }

    @GetMapping("/gestores")
    public ResponseEntity<List<RetornoGestorDTO>> getGestoresPage() {
        return ResponseEntity.ok().body(paginaUserGestores.getGestoresPeges());
    }

    @GetMapping("/gestor/{co}")
    public ResponseEntity<RetornoGestorDTO> getGestorPage(@PathVariable String co) {
        return ResponseEntity.ok().body(paginaUserGestores.getGestorPege(co));
    }
}
