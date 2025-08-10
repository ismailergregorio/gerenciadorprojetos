package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.dtoGestoresPost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.dtoGestoresRespost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassGestores;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoyGestores;

@RestController
@RequestMapping("/gestores")
@CrossOrigin(origins = "*")
public class ControllersGestores {
    @Autowired
    RepositoyGestores repositoryGestores;

    @PostMapping("/addgestores")
    public ResponseEntity<dtoGestoresRespost> addGestores(dtoGestoresPost dtogestor){
        ClassGestores gestor = new ClassGestores();

        gestor.setName(dtogestor.getName());
        gestor.setCursoResposavel(dtogestor.getCursoResposavel());
        gestor.setC
        return ResponseEntity.ok(gestor);
    }
    
}
