package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.AlunosDTO.dtoAlunoAtulizarInfomacao;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.AlunosDTO.dtoAlunosPost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.AlunosDTO.dtoAlunosRespost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassAlunos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryAlunos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryProjetos;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*")
public class ControllersAlunos {
    @Autowired
    RepositoryAlunos repositoryAlunos;

    @Autowired
    RepositoryProjetos repositoryProjetos;

    @PostMapping("/addalunos")
    public ResponseEntity<dtoAlunosRespost> postAlunos(@RequestBody dtoAlunosPost dto) {
        // TODO: process POST request
        ClassAlunos aluno = new ClassAlunos();
        ClassProjetos projetoParaSalvar = new ClassProjetos();

        if (dto.getProjetoSelecionado() != null) {
            Optional<ClassProjetos> projeto = repositoryProjetos.findByCodigoProjeto(dto.getProjetoSelecionado());
            projetoParaSalvar = projeto.get();

            if (projeto.isPresent()) {
                aluno.setProjetoSelecionado(projetoParaSalvar);
            }
        } else {
            aluno.setProjetoSelecionado(null);
        }

        aluno.setRa(dto.getRa());
        aluno.setNome(dto.getNome());
        aluno.setEmailInstitucional(dto.getEmailInstitucional());
        aluno.setCurso(dto.getCurso());
        aluno.setDataInscricao(dto.getDataInscricao());
        aluno.setMotivoDaInscricao(dto.getMotivoDaInscricao());

        ClassAlunos salvo = repositoryAlunos.save(aluno);

        dtoAlunosRespost dtoResposta = new dtoAlunosRespost();

        dtoResposta.setRa(salvo.getRa());
        dtoResposta.setNome(salvo.getNome());
        dtoResposta.setEmailInstitucional(salvo.getEmailInstitucional());
        dtoResposta.setCurso(salvo.getCurso());
        dtoResposta.setProjetoSelecionado(aluno.getProjetoSelecionado().getNomeDoProjeto());
        dtoResposta.setMotivoDaInscricao(salvo.getMotivoDaInscricao());

        return ResponseEntity.ok(dtoResposta);
    }

    @GetMapping("/alunos")
    public List<dtoAlunosRespost> getAlunos() {
        List<ClassAlunos> alunos = repositoryAlunos.findAll();
        return alunos.stream().map(dtoAlunosRespost::new).toList();
    }

    @GetMapping("/aluno/{ra}")
    public ResponseEntity<dtoAlunosRespost> getAluno(@PathVariable String ra) {
        Optional<ClassAlunos> alunoOptional = repositoryAlunos.findByRa(ra);

        if (alunoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ClassAlunos projeto = alunoOptional.get();

        dtoAlunosRespost dtoSelecionado = new dtoAlunosRespost();

        dtoSelecionado.setRa(projeto.getRa());
        dtoSelecionado.setNome(projeto.getNome());
        dtoSelecionado.setEmailInstitucional(projeto.getEmailInstitucional());
        dtoSelecionado.setCurso(projeto.getCurso());
        // dtoSelecionado.setProjetoSelecionado(projeto.getProjetoSelecionado());
        dtoSelecionado.setMotivoDaInscricao(projeto.getMotivoDaInscricao());

        return ResponseEntity.ok(dtoSelecionado);
    }

    @DeleteMapping("/aluno/{ra}")
    public ResponseEntity<dtoAlunosRespost> delAluno(@PathVariable String ra) {
        Optional<ClassAlunos> deletAluno = repositoryAlunos.findByRa(ra);

        if (deletAluno.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ClassAlunos alunoDeletado = deletAluno.get();

        dtoAlunosRespost dtoAlunoResp = new dtoAlunosRespost();

        dtoAlunoResp.setRa(alunoDeletado.getRa());
        dtoAlunoResp.setNome(alunoDeletado.getNome());
        dtoAlunoResp.setEmailInstitucional(alunoDeletado.getEmailInstitucional());
        dtoAlunoResp.setCurso(alunoDeletado.getCurso());
        // dtoAlunoResp.setProjetoSelecionado(alunoDeletado.getProjetoSelecionado());
        dtoAlunoResp.setMotivoDaInscricao(alunoDeletado.getMotivoDaInscricao());

        repositoryAlunos.delete(alunoDeletado);

        return ResponseEntity.ok(dtoAlunoResp);
    }

    @PutMapping("/aluno/{ra}")
    public ResponseEntity<dtoAlunosRespost> putMethodName(@PathVariable String ra,
            @RequestBody dtoAlunoAtulizarInfomacao dtoAluno) {

        Optional<ClassAlunos> alunoSelecionado = repositoryAlunos.findByRa(ra);

        if (alunoSelecionado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ClassAlunos alunoEncontrado = alunoSelecionado.get();

        if (dtoAluno.getProjetoSelecionado() != null) {
            Optional<ClassProjetos> projeto = repositoryProjetos
                    .findByCodigoProjeto(dtoAluno.getProjetoSelecionado());
            if (projeto.isPresent()) {
                alunoEncontrado.setProjetoSelecionado(projeto.get());
            } else {
                return ResponseEntity.badRequest().build();
            }
        }

        alunoEncontrado.setNome(dtoAluno.getNome());
        alunoEncontrado.setEmailInstitucional(dtoAluno.getEmailInstitucional());
        alunoEncontrado.setCurso(dtoAluno.getCurso());
        alunoEncontrado.setMotivoDaInscricao(dtoAluno.getMotivoDaInscricao());

        ClassAlunos novoAluno = repositoryAlunos.save(alunoEncontrado);

        dtoAlunosRespost dtoResposta = new dtoAlunosRespost(novoAluno);

        return ResponseEntity.ok(dtoResposta);
    }

}
