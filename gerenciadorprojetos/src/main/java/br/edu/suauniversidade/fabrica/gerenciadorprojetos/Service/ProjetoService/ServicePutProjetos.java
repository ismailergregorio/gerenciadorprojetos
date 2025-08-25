package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Service.ProjetoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoAtulizacaoInfomacao;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoResp;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassAlunos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryAlunos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryProjetos;
@Service
public class ServicePutProjetos {
 @Autowired
 RepositoryProjetos repositoryProjetos;

 @Autowired
 RepositoryAlunos repositoryAlunos;

 public ResponseEntity<dtoProjetoAtulizacaoInfomacao> putProjeto(String identificador , dtoProjetoAtulizacaoInfomacao objDto){

  Optional<ClassProjetos> projeto = repositoryProjetos.findByCodigoProjeto(identificador);

  if(projeto.isEmpty()){
   System.out.println("Class Não existe");
   return ResponseEntity.badRequest().build();
  }

  List<String> listaAlunos =  new ArrayList<>();
  if(objDto.getAlunosParticipantesDoProjeto() != null){
    for(String ra : objDto.getAlunosParticipantesDoProjeto()){

     //Verifica se Aluno existe
     Optional<ClassAlunos> alunoExiste = repositoryAlunos.findByRa(ra);
     if(alunoExiste.isEmpty()){
      ResponseEntity.badRequest().build();
     }

     if(repositoryAlunos.existsByRaAndProjetoSelecionadoIsNotNull(ra)){
      listaAlunos.add(ra);
     }
    }
  }

  dtoProjetoAtulizacaoInfomacao respostaDTO = new dtoProjetoAtulizacaoInfomacao();

  respostaDTO.setNomeDoProjeto(objDto.getNomeDoProjeto());
  respostaDTO.setAlunosParticipantesDoProjeto(listaAlunos);

  return ResponseEntity.ok(respostaDTO);
 }
}
