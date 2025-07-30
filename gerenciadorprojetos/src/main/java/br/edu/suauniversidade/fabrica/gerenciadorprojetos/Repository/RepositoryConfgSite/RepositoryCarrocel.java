package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryConfgSite;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage.ClassCarrocel;

@Repository
public interface RepositoryCarrocel extends JpaRepository<ClassCarrocel, Long> {
 Optional<ClassCarrocel> findByCodigoImagem(String codigoImagem);
}
