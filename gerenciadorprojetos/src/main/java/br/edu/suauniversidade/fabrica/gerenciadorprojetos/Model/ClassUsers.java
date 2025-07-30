package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//CLASSE DE INSTANCIA DE USUARIOS E A CRIAÇÃO DE TABELA DE USUARIOS

@Entity
@Table(name = "db_users")
public class ClassUsers{
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nome;

 @Column(nullable = false)
 private String email;
 private String passoword;
 
 @Column(nullable = false)
 private String roles;

 public ClassUsers(){

 }

 public ClassUsers(Long id, String nome, String email, String passoword, String roles) {
  this.id = id;
  this.nome = nome;
  this.email = email;
  this.passoword = passoword;
  this.roles = roles;
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getNome() {
  return nome;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }
 
 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getPassoword() {
  return passoword;
 }

 public void setPassoword(String passoword) {
  this.passoword = passoword;
 }

 public String getRoles() {
  return roles;
 }

 public void setRoles(String roles) {
  this.roles = roles;
 }

}
