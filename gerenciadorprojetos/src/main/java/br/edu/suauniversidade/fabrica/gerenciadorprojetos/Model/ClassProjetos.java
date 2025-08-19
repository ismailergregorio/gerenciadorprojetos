package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

//CLASSE DE INSTANCIA DE PROJETOS E A CRIAÇÃO DE TABELA DE PROJETOS

@Entity
@Table(name = "db_projetos")
public class ClassProjetos {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String identicadorProjetos;

  @Column(unique = true, nullable = false)
  private String nomeDoProjeto;
  @Column(columnDefinition = "TEXT", nullable = false)
  private String descricaoDoProjeto;

  @Column(nullable = false)
  private String areaDeConhecimento;

  @Column(nullable = false)
  private LocalDate dataDeInicioDoProjeto;

  @Column(nullable = false)
  private LocalDate dataDoFimDoProjeto;

  @OneToMany(mappedBy = "projetoSelecionado",cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<ClassAlunos> alunosParticipantesDoProjeto = new ArrayList<>();

  private String profesorOrientador;

  @Column(unique = true, nullable = false, columnDefinition = "TEXT")
  private String linkGit;
  private String linkImage;

  public ClassProjetos() {

  }

  public ClassProjetos(Long id, String identicadorProjetos, String nomeDoProjeto, String descricaoDoProjeto,
      String areaDeConhecimento, LocalDate dataDeInicioDoProjeto, LocalDate dataDoFimDoProjeto,
      List<ClassAlunos> alunosParticipantesDoProjeto, String profesorOrientador, String linkGit, String linkImage) {
    this.id = id;
    this.identicadorProjetos = identicadorProjetos;
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

  @PrePersist
  public void geraCodigoProjeto() {
    String prefixo = "PROJ";
    int numero = (int) (Math.random() * 9000) + 1000;
    this.identicadorProjetos = prefixo + numero;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getIdenticadorProjetos() {
    return identicadorProjetos;
  }

  public void setIdenticadorProjetos(String identicadorProjetos) {
    this.identicadorProjetos = identicadorProjetos;
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

  public List<ClassAlunos> getAlunosParticipantesDoProjeto() {
    return alunosParticipantesDoProjeto;
  }

  public void setAlunosParticipantesDoProjeto(List<ClassAlunos> alunosParticipantesDoProjeto) {
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
