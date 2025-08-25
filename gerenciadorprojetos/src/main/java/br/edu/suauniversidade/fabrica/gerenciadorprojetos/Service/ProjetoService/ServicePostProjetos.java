package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Service.ProjetoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoPost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoResp;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassAlunos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassGestores;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryAlunos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryGestores;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryProjetos;

@Service
public class ServicePostProjetos {
 @Autowired
 RepositoryGestores repositoryGestores;

 @Autowired
 RepositoryProjetos repositoryProjetos;

 @Autowired
 RepositoryAlunos repositoryAlunos;

 public ResponseEntity<dtoProjetoResp> postProjeto(dtoProjetoPost dto) {

  List<ClassGestores> gestores = new ArrayList<>();

  if (dto.getProfesorOrientador() != null) {
   for (String identicadorGestor : dto.getProfesorOrientador()) {
    Optional<ClassGestores> gestor = repositoryGestores.findByCodigoGestor(identicadorGestor);
    System.out.println("Existe");
    if (gestor.isPresent()) {
     gestores.add(gestor.get());
    } else {
     return ResponseEntity.notFound().build();
    }
   }
  }

  List<ClassAlunos> alunos = new ArrayList<>();

  if (dto.getAlunosParticipantesDoProjeto() != null) {
   for (String identicadorAlunos : dto.getAlunosParticipantesDoProjeto()) {
    Optional<ClassAlunos> aluno = repositoryAlunos.findByRa(identicadorAlunos);

    if (aluno.isPresent()) {
     alunos.add(aluno.get());
    } else {
     return ResponseEntity.notFound().build();
    }
   }
  }

  ClassProjetos novoProjeto = new ClassProjetos();

  novoProjeto.setNomeDoProjeto(dto.getNomeDoProjeto());
  novoProjeto.setDescricaoDoProjeto(dto.getDescricaoDoProjeto());
  novoProjeto.setAreaDeConhecimento(dto.getAreaDeConhecimento());
  novoProjeto.setDataDeInicioDoProjeto(dto.getDataDeInicioDoProjeto());
  novoProjeto.setDataDoFimDoProjeto(dto.getDataDoFimDoProjeto());
  novoProjeto.setAlunosParticipantesDoProjeto(alunos);
  novoProjeto.setProfesorOrientador(gestores);
  novoProjeto.setLinkGit(dto.getLinkGit());
  novoProjeto.setLinkImage(dto.getLinkImage());

  ClassProjetos projetosavo = repositoryProjetos.save(novoProjeto);

  dtoProjetoResp resProjeto = new dtoProjetoResp();

  resProjeto.setCodigoProjeto(projetosavo.getCodigoProjeto());
  resProjeto.setNomeDoProjeto(projetosavo.getNomeDoProjeto());
  resProjeto.setDescricaoDoProjeto(projetosavo.getDescricaoDoProjeto());
  resProjeto.setAreaDeConhecimento(projetosavo.getAreaDeConhecimento());
  resProjeto.setDataDeInicioDoProjeto(projetosavo.getDataDeInicioDoProjeto());
  resProjeto.setDataDoFimDoProjeto(projetosavo.getDataDoFimDoProjeto());
  resProjeto.setAlunosParticipantesDoProjeto(dto.getAlunosParticipantesDoProjeto());
  resProjeto.setProfesorOrientador(dto.getProfesorOrientador());
  resProjeto.setLinkGit(projetosavo.getLinkGit());
  resProjeto.setLinkImage(projetosavo.getLinkImage());

  return ResponseEntity.ok(resProjeto);
 }
}
