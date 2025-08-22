package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Service.ProjetoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoResp;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryProjetos;

@Service
public class ServiceGetProjetos {
 @Autowired
 RepositoryProjetos repositoryProjetos;

 public List<dtoProjetoResp> getProjetos(){
  List<ClassProjetos> projetos = repositoryProjetos.findAll();
  return projetos.stream().map(dtoProjetoResp::new).toList();
 }
}
