package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Service;

import org.springframework.stereotype.Service;

@Service
public class GeradorDeCodigo {

 public String GeraCodigo(String prefixo) {
  int numero = (int) (Math.random() * 9000) + 1000;
   
  return prefixo + numero;
 }
}
