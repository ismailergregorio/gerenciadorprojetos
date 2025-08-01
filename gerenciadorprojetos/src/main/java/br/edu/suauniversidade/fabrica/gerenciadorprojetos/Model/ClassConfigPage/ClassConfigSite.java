package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "db_configuracao_site")
public class ClassConfigSite {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(nullable = false)
 private String codigoDaConfguracao;

 @Column(nullable = false)
 private String nomeConfig;

 @Column(nullable = false)
 private String valorSalvo;

 public ClassConfigSite(){
  
 }

 public ClassConfigSite(Long id, String codigoDaConfguracao, String nomeConfig, String valorSalvo) {
  this.id = id;
  this.codigoDaConfguracao = codigoDaConfguracao;
  this.nomeConfig = nomeConfig;
  this.valorSalvo = valorSalvo;
 }
 @PrePersist
 public void GeradorDeCodigoConfiguracao(){
  String prefixo = "CONF";
  int numero = (int) (Math.random() * 9000) + 1000;
  this.codigoDaConfguracao = prefixo + numero;
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getCodigoDaConfguracao() {
  return codigoDaConfguracao;
 }

 public void setCodigoDaConfguracao(String codigoDaConfguracao) {
  this.codigoDaConfguracao = codigoDaConfguracao;
 }

 public String getNomeConfig() {
  return nomeConfig;
 }

 public void setNomeConfig(String nomeConfig) {
  this.nomeConfig = nomeConfig;
 }

 public String getValorSalvo() {
  return valorSalvo;
 }

 public void setValorSalvo(String valorSalvo) {
  this.valorSalvo = valorSalvo;
 }

}
