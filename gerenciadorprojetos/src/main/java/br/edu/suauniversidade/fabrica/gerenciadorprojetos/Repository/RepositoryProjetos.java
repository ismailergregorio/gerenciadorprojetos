package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassProjetos;
// CRIAÇÃO DO REPOSITORIO DE PROJETOS


@Repository
public interface RepositoryProjetos extends JpaRepository<ClassProjetos,Long>{
  Optional<ClassProjetos> findByIdenticadorProjetos(String identicadorProjetos);
}
