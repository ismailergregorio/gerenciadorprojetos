package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.dtoGestores.dtoGestoresPost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.dtoGestores.dtoGestoresRespost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassGestores;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryProjetos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryGestores;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/gestores")
@CrossOrigin(origins = "*")
public class ControllersGestores {
    @Autowired
    RepositoryGestores repositoryGestores;

    @Autowired
    RepositoryProjetos repositoryProjetos;

    @PostMapping("/addgestores")
    public ResponseEntity<dtoGestoresRespost> addGestores(dtoGestoresPost dtogestor) {
        ClassGestores gestor = new ClassGestores();

        gestor.setName(dtogestor.getName());
        gestor.setCursoResposavel(dtogestor.getCursoResposavel());
        gestor.setDescricao(dtogestor.getDescricao());
        gestor.setLinkImagenGestor(dtogestor.getLinkImagenGestor());

        // gestor.setProjetos(dtogestor.getProjetos());

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
    @GetMapping("/gestore/{CodigoGestor}")
    public ResponseEntity<dtoGestoresRespost> getMethodName(@PathVariable String CodigoGestor) {
        Optional<ClassGestores> gestoresselecionados =  repositoryGestores.findByCodigoGestor(CodigoGestor);

        if(gestoresselecionados.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        ClassGestores gestor = gestoresselecionados.get();

        dtoGestoresRespost dtoRes = new dtoGestoresRespost();

        dtoRes.setCodigoGestor(gestor.getCodigoGestor());
        dtoRes.setName(gestor.getName());
        dtoRes.setCursoResposavel(gestor.getCursoResposavel());
        dtoRes.setDescricao(gestor.getDescricao());
        dtoRes.setLinkImagenGestor(gestor.getLinkImagenGestor());

        return ResponseEntity.ok(dtoRes);
    }
    @PutMapping("/gestore/{CodigoGestor}")
    public ResponseEntity<dtoGestoresRespost> putGestores(@PathVariable String CodigoGestor, @RequestBody dtoGestoresPost gestorAtulisado) {
        //TODO: process PUT request
        Optional<ClassGestores> itenOptional =  repositoryGestores.findByCodigoGestor(CodigoGestor);

        if(itenOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        ClassGestores gestor = itenOptional.get();

        gestor.setName(gestorAtulisado.getName());
        gestor.setCursoResposavel(gestorAtulisado.getCursoResposavel());
        gestor.setDescricao(gestorAtulisado.getDescricao());
        gestor.setLinkImagenGestor(gestorAtulisado.getLinkImagenGestor());

        repositoryGestores.save(gestor);

        dtoGestoresRespost dtoRes = new dtoGestoresRespost();

        dtoRes.setCodigoGestor(gestor.getCodigoGestor());
        dtoRes.setName(gestor.getName());
        dtoRes.setCursoResposavel(gestor.getCursoResposavel());
        dtoRes.setDescricao(gestor.getDescricao());
        dtoRes.setLinkImagenGestor(gestor.getLinkImagenGestor());

        return ResponseEntity.ok(dtoRes);
    }
    @DeleteMapping("/gestore/{CodigoGestor}")
    public ResponseEntity<dtoGestoresRespost> deleteGestores(@PathVariable String CodigoGestor){

        Optional<ClassGestores> itenOptional =  repositoryGestores.findByCodigoGestor(CodigoGestor);

        if(itenOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        ClassGestores gestorDeletado = itenOptional.get();

        dtoGestoresRespost dtoRes = new dtoGestoresRespost();

        dtoRes.setCodigoGestor(gestorDeletado.getCodigoGestor());
        dtoRes.setName(gestorDeletado.getName());
        dtoRes.setCursoResposavel(gestorDeletado.getCursoResposavel());
        dtoRes.setDescricao(gestorDeletado.getDescricao());
        dtoRes.setLinkImagenGestor(gestorDeletado.getLinkImagenGestor());

        repositoryGestores.delete(gestorDeletado);

        return ResponseEntity.ok(dtoRes);
    } 
    

}
