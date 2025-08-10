package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Controllers.ClassControllersConfgPage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage.dtoClassConfgSiteResp;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage.dtoClassConfigSitePost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage.dtoClassConfigSitePut;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage.ClassConfigSite;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryConfgSite.RepositoryConfigSite;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/config")
@CrossOrigin(origins = "*")
public class ControllerClassConfigSite {

 @Autowired
 RepositoryConfigSite repositoryConfigSite;

 @GetMapping("/config")
 public List<dtoClassConfgSiteResp> getConfigSite() {
  List<ClassConfigSite> itens = repositoryConfigSite.findAll();
  return itens.stream().map(dtoClassConfgSiteResp::new).toList();
 }

 @PostMapping("/config")
 public ResponseEntity<dtoClassConfgSiteResp> postMethodName(@RequestBody dtoClassConfigSitePost entity) {
  // TODO: process POST request
  ClassConfigSite configuracao = new ClassConfigSite();

  configuracao.setNomeConfig(entity.getNomeConfig());
  configuracao.setValorSalvo(entity.getValorSalvo());

  repositoryConfigSite.save(configuracao);

  dtoClassConfgSiteResp iten = new dtoClassConfgSiteResp();

  iten.setCodigoDaConfguracao(configuracao.getCodigoDaConfguracao());
  iten.setNomeConfig(configuracao.getNomeConfig());
  iten.setValorSalvo(configuracao.getValorSalvo());

  return ResponseEntity.ok(iten);
 }

 @PutMapping("/config/{codigoDaConfguracao}")
 public ResponseEntity<dtoClassConfgSiteResp> putMethodName(@PathVariable String codigoDaConfguracao,
   @RequestBody dtoClassConfigSitePut dto) {
  Optional<ClassConfigSite> itens = repositoryConfigSite.findByCodigoDaConfguracao(codigoDaConfguracao);

  if (itens.isEmpty()) {
   return ResponseEntity.notFound().build();
  }

  ClassConfigSite itenSelecionado = itens.get();

  itenSelecionado.setValorSalvo(dto.getValorSalvo());
  repositoryConfigSite.save(itenSelecionado);

  dtoClassConfgSiteResp dtoResp = new dtoClassConfgSiteResp();

  dtoResp.setCodigoDaConfguracao(itenSelecionado.getCodigoDaConfguracao());
  dtoResp.setNomeConfig(itenSelecionado.getNomeConfig());
  dtoResp.setValorSalvo(itenSelecionado.getValorSalvo());

  return ResponseEntity.ok(dtoResp);
 }

 @DeleteMapping("/config/{codigoDaConfguracao}")
 public ResponseEntity<dtoClassConfgSiteResp> DeleteConfig(@PathVariable String codigoDaConfguracao){
  Optional<ClassConfigSite> itens = repositoryConfigSite.findByCodigoDaConfguracao(codigoDaConfguracao);

  if(itens.isEmpty()){
   return ResponseEntity.notFound().build();
  }

  ClassConfigSite itenSelecionado = itens.get();

  repositoryConfigSite.delete(itenSelecionado);

  dtoClassConfgSiteResp dtoResp =  new dtoClassConfgSiteResp();

  dtoResp.setCodigoDaConfguracao(itenSelecionado.getCodigoDaConfguracao());
  dtoResp.setNomeConfig(itenSelecionado.getNomeConfig());
  dtoResp.setValorSalvo(itenSelecionado.getValorSalvo());

  return ResponseEntity.ok(dtoResp);
 }

}
