package br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage.ClassConfigSite;

public class dtoClassConfigSitePut {
 private String valorSalvo;

 public dtoClassConfigSitePut(String valorSalvo) {
  this.valorSalvo = valorSalvo;
 }
 public dtoClassConfigSitePut() {

 }

 public dtoClassConfigSitePut(ClassConfigSite valorConfguracao) {
  this.valorSalvo = valorConfguracao.getValorSalvo();
 }


 public String getValorSalvo() {
  return valorSalvo;
 }

 public void setValorSalvo(String valorSalvo) {
  this.valorSalvo = valorSalvo;
 }
}
