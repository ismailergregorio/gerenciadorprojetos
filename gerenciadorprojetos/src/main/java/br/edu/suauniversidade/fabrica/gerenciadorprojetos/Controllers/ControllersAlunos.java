package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Controllers;

import java.util.List;
import java.util.Optional;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.dtoAlunosPost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.dtoAlunosRespost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.dtoProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassAlunos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryAlunos;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/alunos")

public class ControllersAlunos {
    @Autowired
    RepositoryAlunos repositoryAlunos;

    @PostMapping("/addalunos")
    public ResponseEntity<dtoAlunosRespost> postAlunos(@RequestBody dtoAlunosPost dto) {
        // TODO: process POST request
        ClassAlunos aluno = new ClassAlunos();

        aluno.setRa(dto.getRa());
        aluno.setNome(dto.getNome());
        aluno.setEmailInstitucional(dto.getEmailInstitucional());
        aluno.setCurso(dto.getCurso());
        aluno.setDataInscricao(dto.getDataInscricao());
        aluno.setProjetoSelecionado(dto.getProjetoSelecionado());

        ClassAlunos salvo = repositoryAlunos.save(aluno);

        dtoAlunosRespost dtoResposta = new dtoAlunosRespost();

        dtoResposta.setNome(salvo.getNome());
        dtoResposta.setEmailInstitucional(salvo.getEmailInstitucional());
        dtoResposta.setCurso(salvo.getCurso());
        dtoResposta.setProjetoSelecionado(salvo.getProjetoSelecionado());

        return ResponseEntity.ok(dtoResposta);
    }

    @GetMapping("/alunos")
    public List<dtoAlunosRespost> getAlunos() {
        List<ClassAlunos> alunos = repositoryAlunos.findAll();
        return alunos.stream().map(dtoAlunosRespost::new).toList();
    }

    @GetMapping("/aluno{ra}")
    public ResponseEntity<dtoAlunosRespost> getAluno(@PathVariable String ra) {
        Optional<ClassAlunos> alunoOptional = repositoryAlunos.findByNome(ra);

        if (alunoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ClassAlunos projeto = alunoOptional.get();

        dtoAlunosRespost dtoSelecionado = new dtoAlunosRespost();

        dtoSelecionado.getNome();
        dtoSelecionado.getEmailInstitucional();
        dtoSelecionado.getCurso();
        dtoSelecionado.getProjetoSelecionado();
        dtoSelecionado.getMotivoDaInscricao();
        return ResponseEntity.ok(ra);
    }

}
