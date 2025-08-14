package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.dtoProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryProjetos;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/projetos")
@CrossOrigin(origins = "*")
public class ControllesProjetos {
 @Autowired
 RepositoryProjetos repositorioProjetos;

 @PostMapping("/addprojetos")
 public ResponseEntity<dtoProjetos> CreatinProjeto(@RequestBody dtoProjetos DTO) {
  ClassProjetos projeto = new ClassProjetos();
  projeto.setNomeDoProjeto(DTO.getNomeDoProjeto());
  projeto.setDescricaoDoProjeto(DTO.getDescricaoDoProjeto());
  projeto.setAreaDeConhecimento(DTO.getAreaDeConhecimento());
  projeto.setDataDeInicioDoProjeto(DTO.getDataDeInicioDoProjeto());
  projeto.setDataDoFimDoProjeto(DTO.getDataDoFimDoProjeto());
  projeto.setAlunosParticipantesDoProjeto(DTO.getAlunosParticipantesDoProjeto());
  projeto.setProfesorOrientador(DTO.getProfesorOrientador());
  projeto.setLinkGit(DTO.getLinkGit());
  projeto.setLinkImage(DTO.getLinkImage());

  ClassProjetos salvar = repositorioProjetos.save(projeto);

  dtoProjetos dtoProjetoResposta = new dtoProjetos(projeto);

  dtoProjetoResposta.setNomeDoProjeto(salvar.getNomeDoProjeto());
  dtoProjetoResposta.setDescricaoDoProjeto(salvar.getDescricaoDoProjeto());
  dtoProjetoResposta.setAreaDeConhecimento(salvar.getAreaDeConhecimento());
  dtoProjetoResposta.setDataDeInicioDoProjeto(salvar.getDataDeInicioDoProjeto());
  dtoProjetoResposta.setDataDoFimDoProjeto(salvar.getDataDoFimDoProjeto());
  dtoProjetoResposta.setAlunosParticipantesDoProjeto(salvar.getAlunosParticipantesDoProjeto());
  dtoProjetoResposta.setProfesorOrientador(salvar.getProfesorOrientador());
  dtoProjetoResposta.setLinkGit(salvar.getLinkGit());
  dtoProjetoResposta.setLinkImage(salvar.getLinkImage());

  return ResponseEntity.ok(dtoProjetoResposta);
 }

 @GetMapping("/getprojetos")
 public List<dtoProjetos> GetProjeto() {
  List<ClassProjetos> projetos = repositorioProjetos.findAll();

  return projetos.stream().map(dtoProjetos::new).toList();
 }

 @GetMapping("/getprojetos/{id}")
 public ResponseEntity<dtoProjetos> GetProjetoId(@PathVariable Long id) {

  Optional<ClassProjetos> projetoOptional = repositorioProjetos.findById(id);

  if (projetoOptional.isEmpty()) {
   return ResponseEntity.notFound().build();
  }

  ClassProjetos projeto = projetoOptional.get();

  dtoProjetos dtoSelecionado = new dtoProjetos();

  dtoSelecionado.setNomeDoProjeto(projeto.getNomeDoProjeto());
  dtoSelecionado.setDescricaoDoProjeto(projeto.getDescricaoDoProjeto());
  dtoSelecionado.setAreaDeConhecimento(projeto.getAreaDeConhecimento());
  dtoSelecionado.setDataDeInicioDoProjeto(projeto.getDataDeInicioDoProjeto());
  dtoSelecionado.setDataDoFimDoProjeto(projeto.getDataDoFimDoProjeto());
  dtoSelecionado.setAlunosParticipantesDoProjeto(projeto.getAlunosParticipantesDoProjeto());
  dtoSelecionado.setProfesorOrientador(projeto.getProfesorOrientador());
  dtoSelecionado.setLinkGit(projeto.getLinkGit());
  dtoSelecionado.setLinkImage(projeto.getLinkImage());

  return ResponseEntity.ok(dtoSelecionado);
 }

 @PutMapping("/{id}")
 public ResponseEntity<?> updateProjetos(@PathVariable Long id, @RequestBody ClassProjetos projetos) {

  Optional<ClassProjetos> projeto = repositorioProjetos.findById(id);

  if (projeto.isEmpty()) {
   return ResponseEntity.badRequest().body("Item não encontrado");
  }

  ClassProjetos projetoEncontrado = projeto.get();
  projetoEncontrado.setNomeDoProjeto(projetos.getNomeDoProjeto());
  projetoEncontrado.setDescricaoDoProjeto(projetos.getDescricaoDoProjeto());
  projetoEncontrado.setAreaDeConhecimento(projetos.getAreaDeConhecimento());
  projetoEncontrado.setDataDeInicioDoProjeto(projetos.getDataDeInicioDoProjeto());
  projetoEncontrado.setDataDoFimDoProjeto(projetos.getDataDoFimDoProjeto());
  projetoEncontrado.setAlunosParticipantesDoProjeto(projetos.getAlunosParticipantesDoProjeto());
  projetoEncontrado.setProfesorOrientador(projetos.getProfesorOrientador());
  projetoEncontrado.setLinkGit(projetos.getLinkGit());
  projetoEncontrado.setLinkImage(projetos.getLinkImage());

  repositorioProjetos.save(projetoEncontrado);

  return ResponseEntity.ok(projetoEncontrado); // Melhor retornar o produto atualizado
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<?> DeleteProduct(@PathVariable Long id, @RequestBody ClassProjetos projetos) {
  Optional<ClassProjetos> projeto = repositorioProjetos.findById(id);

  if (projeto.isEmpty()) {
   return ResponseEntity.badRequest().body("Item não encontrado");
  }
  ClassProjetos projetoEncontrado = projeto.get();
  repositorioProjetos.delete(projetoEncontrado);

  return ResponseEntity.ok(projetoEncontrado);
 }

}
