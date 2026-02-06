package com.example.API_Fabrica_Software.Service.PaginaUserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API_Fabrica_Software.DTO.RetornoDTOpeges.RetornoAlunosDTO;
import com.example.API_Fabrica_Software.DTO.RetornoDTOpeges.RetornoProjetosDTO;
import com.example.API_Fabrica_Software.Model.ClassAlunos;
import com.example.API_Fabrica_Software.Model.ClassProjetos;
import com.example.API_Fabrica_Software.Repository.RepositoryProjetos;

@Service
public class PaginaUserProjeto {

    @Autowired
    RepositoryProjetos repositoryProjetos;

    public List<RetornoProjetosDTO> getProjetos() {
        List<ClassProjetos> projetos = repositoryProjetos.findAll();

        List<RetornoProjetosDTO> dados = projetos.stream().map(projeto -> new RetornoProjetosDTO(
                projeto.getCodigoProjeto(), 
                projeto.getNomeDoProjeto(), 
                projeto.getDescricaoDoProjeto(),
                projeto.getAreaDeConhecimento(),
                projeto.getAlunosParticipantesDoProjeto(),
                projeto.getProfesorOrientador(),
                projeto.getLinkGit(),
                projeto.getLinkImage())).toList();

        return null;
    }

    public RetornoProjetosDTO getProjeto(String ra) {
        Optional<ClassAlunos> alunos = repositoryAlunos.findByRa(ra);

        if (alunos.isPresent()) {
            ClassAlunos aluno = alunos.get();
            return new RetornoAlunosDTO(aluno.getRa(), aluno.getNome(), aluno.getProjetoSelecionado(),
                    aluno.getCurso());
        }
        return null;
    }
}
