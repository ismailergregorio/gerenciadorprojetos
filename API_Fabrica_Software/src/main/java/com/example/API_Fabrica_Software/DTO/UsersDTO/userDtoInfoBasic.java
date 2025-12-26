package com.example.API_Fabrica_Software.DTO.UsersDTO;

public class userDtoInfoBasic {
 private Long id;
 private String nome;
 private String email;
 private String roles;

 public String getRoles() {
  return roles;
 }

 public void setRoles(String roles) {
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

 public userDtoInfoBasic(Long id, String nome, String email,String roles) {
  this.id = id;
  this.nome = nome;
  this.email = email;
  this.roles =  roles;
 }
 public userDtoInfoBasic(){

 }
}
