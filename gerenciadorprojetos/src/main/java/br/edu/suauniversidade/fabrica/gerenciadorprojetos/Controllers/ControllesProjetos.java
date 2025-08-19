package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoAtulizacaoInfomacao;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoPost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO.dtoProjetoResp;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassAlunos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryAlunos;
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

 @Autowired
 RepositoryAlunos repositoryAlunos;

 @PostMapping("/addprojetos")
 public ResponseEntity<dtoProjetoResp> CreatinProjeto(@RequestBody dtoProjetoPost DTO) {
  ClassProjetos projeto = new ClassProjetos();
  
  projeto.setNomeDoProjeto(DTO.getNomeDoProjeto());
  projeto.setDescricaoDoProjeto(DTO.getDescricaoDoProjeto());
  projeto.setAreaDeConhecimento(DTO.getAreaDeConhecimento());
  projeto.setDataDeInicioDoProjeto(DTO.getDataDeInicioDoProjeto());
  projeto.setDataDoFimDoProjeto(DTO.getDataDoFimDoProjeto());
  // projeto.setAlunosParticipantesDoProjeto(DTO.getAlunosParticipantesDoProjeto());
  projeto.setProfesorOrientador(DTO.getProfesorOrientador());
  projeto.setLinkGit(DTO.getLinkGit());
  projeto.setLinkImage(DTO.getLinkImage());

  ClassProjetos salvar = repositorioProjetos.save(projeto);

  dtoProjetoResp dtoProjetoResposta = new dtoProjetoResp(salvar);

  // dtoProjetoResposta.setIdenticadorProjetos(salvar.getIdenticadorProjetos());
  // dtoProjetoResposta.setNomeDoProjeto(salvar.getNomeDoProjeto());
  // dtoProjetoResposta.setDescricaoDoProjeto(salvar.getDescricaoDoProjeto());
  // dtoProjetoResposta.setAreaDeConhecimento(salvar.getAreaDeConhecimento());
  // dtoProjetoResposta.setDataDeInicioDoProjeto(salvar.getDataDeInicioDoProjeto());
  // dtoProjetoResposta.setDataDoFimDoProjeto(salvar.getDataDoFimDoProjeto());
  // dtoProjetoResposta.setAlunosParticipantesDoProjeto(salvar.getAlunosParticipantesDoProjeto());
  // dtoProjetoResposta.setProfesorOrientador(salvar.getProfesorOrientador());
  // dtoProjetoResposta.setLinkGit(salvar.getLinkGit());
  // dtoProjetoResposta.setLinkImage(salvar.getLinkImage());

  return ResponseEntity.ok(dtoProjetoResposta);
 }

 @GetMapping("/getprojetos")
 public List<dtoProjetoResp> GetProjeto() {
  List<ClassProjetos> projetos = repositorioProjetos.findAll();

  return projetos.stream().map(dtoProjetoResp::new).toList();
 }

 @GetMapping("/getprojetos/{identicadorProjetos}")
 public ResponseEntity<dtoProjetoResp> GetProjetoId(@PathVariable String identicadorProjetos) {

  Optional<ClassProjetos> projetoOptional = repositorioProjetos.findByIdenticadorProjetos(identicadorProjetos);

  if (projetoOptional.isEmpty()) {
   return ResponseEntity.notFound().build();
  }

  ClassProjetos projeto = projetoOptional.get();

  dtoProjetoResp dtoSelecionado = new dtoProjetoResp();

  dtoSelecionado.setNomeDoProjeto(projeto.getNomeDoProjeto());
  dtoSelecionado.setDescricaoDoProjeto(projeto.getDescricaoDoProjeto());
  dtoSelecionado.setAreaDeConhecimento(projeto.getAreaDeConhecimento());
  dtoSelecionado.setDataDeInicioDoProjeto(projeto.getDataDeInicioDoProjeto());
  dtoSelecionado.setDataDoFimDoProjeto(projeto.getDataDoFimDoProjeto());
  // dtoSelecionado.setAlunosParticipantesDoProjeto(projeto.getAlunosParticipantesDoProjeto());
  dtoSelecionado.setProfesorOrientador(projeto.getProfesorOrientador());
  dtoSelecionado.setLinkGit(projeto.getLinkGit());
  dtoSelecionado.setLinkImage(projeto.getLinkImage());

  return ResponseEntity.ok(dtoSelecionado);
 }

 @PutMapping("/{identicadorProjetos}")
 public ResponseEntity<dtoProjetoAtulizacaoInfomacao> updateProjetos(@PathVariable String identicadorProjetos, @RequestBody dtoProjetoAtulizacaoInfomacao projeto) {

  Optional<ClassProjetos> projetoSelecionado = repositorioProjetos.findByIdenticadorProjetos(identicadorProjetos);
  if (projetoSelecionado.isEmpty()) {
   return ResponseEntity.badRequest().build();
  }

  ClassProjetos projetoEncontrado = projetoSelecionado.get();

  projetoEncontrado.setNomeDoProjeto(projeto.getNomeDoProjeto());
  projetoEncontrado.setDescricaoDoProjeto(projeto.getDescricaoDoProjeto());
  projetoEncontrado.setAreaDeConhecimento(projeto.getAreaDeConhecimento());
  projetoEncontrado.setDataDeInicioDoProjeto(projeto.getDataDeInicioDoProjeto());
  projetoEncontrado.setDataDoFimDoProjeto(projeto.getDataDoFimDoProjeto());
  // projetoEncontrado.setAlunosParticipantesDoProjeto(projeto.getAlunosParticipantesDoProjeto());
  projetoEncontrado.setProfesorOrientador(projeto.getProfesorOrientador());
  projetoEncontrado.setLinkGit(projeto.getLinkGit());
  projetoEncontrado.setLinkImage(projeto.getLinkImage());

  repositorioProjetos.save(projetoEncontrado);

  dtoProjetoAtulizacaoInfomacao alualizacao =  new dtoProjetoAtulizacaoInfomacao();

  alualizacao.setNomeDoProjeto(projetoEncontrado.getNomeDoProjeto());
  alualizacao.setDescricaoDoProjeto(projetoEncontrado.getDescricaoDoProjeto());
  alualizacao.setAreaDeConhecimento(projetoEncontrado.getAreaDeConhecimento());
  alualizacao.setDataDeInicioDoProjeto(projetoEncontrado.getDataDeInicioDoProjeto());
  alualizacao.setDataDoFimDoProjeto(projetoEncontrado.getDataDoFimDoProjeto());
  // projetoEncontrado.setAlunosParticipantesDoProjeto(projeto.getAlunosParticipantesDoProjeto());
  alualizacao.setProfesorOrientador(projetoEncontrado.getProfesorOrientador());
  alualizacao.setLinkGit(projetoEncontrado.getLinkGit());
  alualizacao.setLinkImage(projetoEncontrado.getLinkImage());

  return ResponseEntity.ok(alualizacao); // Melhor retornar o produto atualizado
 }

 @DeleteMapping("/{identicadorProjetos}")
 public ResponseEntity<?> DeleteProduct(@PathVariable String identicadorProjetos) {
  Optional<ClassProjetos> projeto = repositorioProjetos.findByIdenticadorProjetos(identicadorProjetos);

  if (projeto.isEmpty()) {
   return ResponseEntity.badRequest().body("Item não encontrado");
  }
  ClassProjetos projetoEncontrado = projeto.get();
  repositorioProjetos.delete(projetoEncontrado);

  return ResponseEntity.ok(projetoEncontrado);
 }

}
