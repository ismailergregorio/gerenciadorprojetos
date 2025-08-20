package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassGestores;
@Repository
public interface RepositoryGestores extends JpaRepository<ClassGestores,Long>{
    Optional<ClassGestores> findByCodigoGestor(String codigoGestor);   
}
