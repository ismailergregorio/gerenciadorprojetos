package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassAlunos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassProjetos;

// CRIAÇÃO DO REPOSITORIO DE ALUNOS

@Repository
public interface RepositoryAlunos extends JpaRepository<ClassAlunos, Long> {
 Optional<ClassAlunos> findByRa(String ra);
 boolean existsByRaAndProjetoSelecionadoIsNotNull(String ra);
 
 Optional<ClassAlunos> findByProjetoSelecionado(ClassProjetos projetoSelecionado);
}
