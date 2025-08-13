package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<dtoGestoresRespost> addGestores(dtoGestoresPost dtogestor) {
        ClassGestores gestor = new ClassGestores();



        gestor.setName(dtogestor.getName());
        gestor.setCursoResposavel(dtogestor.getCursoResposavel());
        gestor.setDescricao(dtogestor.getDescricao());
        gestor.setLinkImagenGestor(dtogestor.getLinkImagenGestor());

        repositoryGestores.save(gestor);

        dtoGestoresRespost dtoreposta = new dtoGestoresRespost();

        dtoreposta.setCodigoGestor(gestor.getCodigoGestor());
        dtoreposta.setName(gestor.getName());
        dtoreposta.setCursoResposavel(gestor.getCursoResposavel());
        dtoreposta.setDescricao(gestor.getDescricao());
        dtoreposta.setLinkImagenGestor(gestor.getLinkImagenGestor());

        return ResponseEntity.ok(dtoreposta);
    }

    @GetMapping("/gestores")
    public List<dtoGestoresRespost> GetGestores(){
        List<ClassGestores> gestores = repositoryGestores.findAll();

        return gestores.stream().map(dtoGestoresRespost::new).toList();
    }

}
