package com.example.API_Fabrica_Software.Controllers.ClassControllersConfgPage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_Fabrica_Software.DTO.ConfgDTOPage.dtoClassConfgSiteResp;
import com.example.API_Fabrica_Software.DTO.ConfgDTOPage.dtoClassConfigSitePost;
import com.example.API_Fabrica_Software.DTO.ConfgDTOPage.dtoClassConfigSitePut;
import com.example.API_Fabrica_Software.Model.ClassConfigPage.ClassConfigSite;
import com.example.API_Fabrica_Software.Repository.RepositoryConfgSite.RepositoryConfigSite;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/config")
public class ControllerClassConfigSite {

  @Autowired
  RepositoryConfigSite repositoryConfigSite;

  @PreAuthorize("hasRole(\"ADMIN\")")
  @GetMapping("/config")
  public List<dtoClassConfgSiteResp> getConfigSite() {
    List<ClassConfigSite> itens = repositoryConfigSite.findAll();
    return itens.stream().map(dtoClassConfgSiteResp::new).toList();
  }

  @PreAuthorize("hasRole(\"ADMIN\")")
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

  @PreAuthorize("hasRole(\"ADMIN\")")
  @PutMapping("/config/{nomeConfig}")
  public ResponseEntity<dtoClassConfgSiteResp> putMethodName(@PathVariable String nomeConfig,
      @RequestBody dtoClassConfigSitePut dto) {
    Optional<ClassConfigSite> itens = repositoryConfigSite.findByNomeConfig(nomeConfig);

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

  @PreAuthorize("hasRole(\"ADMIN\")")
  @DeleteMapping("/config/{nomeConfig}")
  public ResponseEntity<dtoClassConfgSiteResp> DeleteConfig(@PathVariable String nomeConfig) {
    Optional<ClassConfigSite> itens = repositoryConfigSite.findByNomeConfig(nomeConfig);

    if (itens.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    ClassConfigSite itenSelecionado = itens.get();

    repositoryConfigSite.delete(itenSelecionado);

    dtoClassConfgSiteResp dtoResp = new dtoClassConfgSiteResp();

    dtoResp.setCodigoDaConfguracao(itenSelecionado.getCodigoDaConfguracao());
    dtoResp.setNomeConfig(itenSelecionado.getNomeConfig());
    dtoResp.setValorSalvo(itenSelecionado.getValorSalvo());

    return ResponseEntity.ok(dtoResp);
  }

}
