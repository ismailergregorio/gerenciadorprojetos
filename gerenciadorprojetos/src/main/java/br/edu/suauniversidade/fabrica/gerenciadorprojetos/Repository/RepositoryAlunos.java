package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassAlunos;

@Repository
public interface RepositoryAlunos extends JpaRepository<ClassAlunos,String>{
 Optional<ClassAlunos> findByNome(String ra);
}
