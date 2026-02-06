package com.example.API_Fabrica_Software.Controllers.ClassControllersPageUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_Fabrica_Software.DTO.RetornoDTOpeges.RetornoAlunosDTO;
import com.example.API_Fabrica_Software.Service.PaginaUserService.PaginaUserAluno;

@RestController
@RequestMapping("/page")
public class ControlerPageUser {

    @Autowired
    PaginaUserAluno paginaUserAluno;

    @GetMapping("/alunos")
    public ResponseEntity<List<RetornoAlunosDTO>> getAlunosPage() {
        return ResponseEntity.ok().body(paginaUserAluno.getAlunosPeges());
    }
    
    @GetMapping("/aluno/{ra}")
    public  ResponseEntity<RetornoAlunosDTO> getAlunoPage(@PathVariable String ra) {
        return ResponseEntity.ok().body(paginaUserAluno.getAlunoPege(ra));
    }
}
