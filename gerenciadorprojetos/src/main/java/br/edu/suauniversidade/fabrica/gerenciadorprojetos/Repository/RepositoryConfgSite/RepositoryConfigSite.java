package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryConfgSite;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage.ClassConfigSite;

@Repository
public interface RepositoryConfigSite extends JpaRepository<ClassConfigSite, Long>{
 Optional<ClassConfigSite> findByCodigoDaConfguracao(String codigoDaConfguracao);

}