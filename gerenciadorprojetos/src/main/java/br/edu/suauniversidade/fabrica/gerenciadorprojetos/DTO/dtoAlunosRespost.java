package br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassAlunos;

public class dtoAlunosRespost {
 private String ra;
 private String emailInstitucional;
 private String nome;
 private String curso;
 private String projetoSelecionado;
 private String motivoDaInscricao;

 public dtoAlunosRespost(){

 }

 public dtoAlunosRespost(ClassAlunos classAlunos) {
  this.ra = classAlunos.getRa();
  this.emailInstitucional = classAlunos.getEmailInstitucional();
  this.nome = classAlunos.getNome();
  this.curso = classAlunos.getCurso();
  this.projetoSelecionado = classAlunos.getProjetoSelecionado();
  this.motivoDaInscricao = classAlunos.getMotivoDaInscricao();
 }

 public String getRa() {
  return ra;
 }

 public void setRa(String ra) {
  this.ra = ra;
 }
 
 public String getEmailInstitucional() {
  return emailInstitucional;
 }
 public void setEmailInstitucional(String emailInstitucional) {
  this.emailInstitucional = emailInstitucional;
 }
 public String getNome() {
  return nome;
 }
 public void setNome(String nome) {
  this.nome = nome;
 }
 public String getCurso() {
  return curso;
 }
 public void setCurso(String curso) {
  this.curso = curso;
 }
 public String getProjetoSelecionado() {
  return projetoSelecionado;
 }
 public void setProjetoSelecionado(String projetoSelecionado) {
  this.projetoSelecionado = projetoSelecionado;
 }
 public String getMotivoDaInscricao() {
  return motivoDaInscricao;
 }
 public void setMotivoDaInscricao(String motivoDaInscricao) {
  this.motivoDaInscricao = motivoDaInscricao;
 }
}
