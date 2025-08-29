package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model;

import java.time.LocalDate;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//CLASSE DE INSTANCIA DE ALUNOS E A CRIAÇÃO DE TABELA DE ALUNOS

@Entity
@Table(name = "db_alunos")
public class ClassAlunos {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String ra;

  @Column(unique = true, nullable = false)
  private String emailInstitucional;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private String curso;

  @ManyToOne(optional = true)
  @JoinColumn(name = "projeto", referencedColumnName = "codigoProjeto", nullable = true)
  @JsonBackReference
  private ClassProjetos projetoSelecionado;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String motivoDaInscricao;

  @Column(nullable = false, columnDefinition = "TEXT")
  private LocalDate dataInscricao;

  @ColumnDefault("false")
  private boolean status;

  public ClassAlunos() {

  }

  public ClassAlunos(Long id, String ra, String emailInstitucional, String nome, String curso,
      ClassProjetos projetoSelecionado, String motivoDaInscricao, LocalDate dataInscricao, boolean status) {
    this.id = id;
    this.ra = ra;
    this.emailInstitucional = emailInstitucional;
    this.nome = nome;
    this.curso = curso;
    this.projetoSelecionado = projetoSelecionado;
    this.motivoDaInscricao = motivoDaInscricao;
    this.dataInscricao = dataInscricao;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public ClassProjetos getProjetoSelecionado() {
    return projetoSelecionado;
  }

  public void setProjetoSelecionado(ClassProjetos projetoSelecionado) {
    this.projetoSelecionado = projetoSelecionado;
  }

  public String getMotivoDaInscricao() {
    return motivoDaInscricao;
  }

  public void setMotivoDaInscricao(String motivoDaInscricao) {
    this.motivoDaInscricao = motivoDaInscricao;
  }

  public LocalDate getDataInscricao() {
    return dataInscricao;
  }

  public void setDataInscricao(LocalDate dataInscricao) {
    this.dataInscricao = dataInscricao;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

}