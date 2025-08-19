package br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ProjetoDTO;

import java.time.LocalDate;
import java.util.List;

public class dtoProjetoPost {
 private String nomeDoProjeto;
 private String descricaoDoProjeto;
 private String areaDeConhecimento;
 private LocalDate dataDeInicioDoProjeto;
 private LocalDate dataDoFimDoProjeto;
 private List<String> alunosParticipantesDoProjeto;
 private String profesorOrientador;
 private String linkGit;
 private String linkImage;

 public dtoProjetoPost(String nomeDoProjeto, String descricaoDoProjeto, String areaDeConhecimento,
   LocalDate dataDeInicioDoProjeto, LocalDate dataDoFimDoProjeto, List<String> alunosParticipantesDoProjeto,
   String profesorOrientador, String linkGit, String linkImage) {
  this.nomeDoProjeto = nomeDoProjeto;
  this.descricaoDoProjeto = descricaoDoProjeto;
  this.areaDeConhecimento = areaDeConhecimento;
  this.dataDeInicioDoProjeto = dataDeInicioDoProjeto;
  this.dataDoFimDoProjeto = dataDoFimDoProjeto;
  this.alunosParticipantesDoProjeto = alunosParticipantesDoProjeto;
  this.profesorOrientador = profesorOrientador;
  this.linkGit = linkGit;
  this.linkImage = linkImage;
 }

 public String getNomeDoProjeto() {
  return nomeDoProjeto;
 }

 public void setNomeDoProjeto(String nomeDoProjeto) {
  this.nomeDoProjeto = nomeDoProjeto;
 }

 public String getDescricaoDoProjeto() {
  return descricaoDoProjeto;
 }

 public void setDescricaoDoProjeto(String descricaoDoProjeto) {
  this.descricaoDoProjeto = descricaoDoProjeto;
 }

 public String getAreaDeConhecimento() {
  return areaDeConhecimento;
 }

 public void setAreaDeConhecimento(String areaDeConhecimento) {
  this.areaDeConhecimento = areaDeConhecimento;
 }

 public LocalDate getDataDeInicioDoProjeto() {
  return dataDeInicioDoProjeto;
 }

 public void setDataDeInicioDoProjeto(LocalDate dataDeInicioDoProjeto) {
  this.dataDeInicioDoProjeto = dataDeInicioDoProjeto;
 }

 public LocalDate getDataDoFimDoProjeto() {
  return dataDoFimDoProjeto;
 }

 public void setDataDoFimDoProjeto(LocalDate dataDoFimDoProjeto) {
  this.dataDoFimDoProjeto = dataDoFimDoProjeto;
 }

 public List<String> getAlunosParticipantesDoProjeto() {
  return alunosParticipantesDoProjeto;
 }

 public void setAlunosParticipantesDoProjeto(List<String> alunosParticipantesDoProjeto) {
  this.alunosParticipantesDoProjeto = alunosParticipantesDoProjeto;
 }

 public String getProfesorOrientador() {
  return profesorOrientador;
 }

 public void setProfesorOrientador(String profesorOrientador) {
  this.profesorOrientador = profesorOrientador;
 }

 public String getLinkGit() {
  return linkGit;
 }

 public void setLinkGit(String linkGit) {
  this.linkGit = linkGit;
 }

 public String getLinkImage() {
  return linkImage;
 }

 public void setLinkImage(String linkImage) {
  this.linkImage = linkImage;
 }

}
