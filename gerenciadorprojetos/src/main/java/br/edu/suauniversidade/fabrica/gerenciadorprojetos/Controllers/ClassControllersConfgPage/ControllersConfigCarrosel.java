package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Controllers.ClassControllersConfgPage;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage.dtoConfgCarrocelPost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage.dtoConfigCarrocelResp;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage.ClassCarrocel;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryConfgSite.RepositoryCarrocel;




@RestController
@RequestMapping("/carrocel")
public class ControllersConfigCarrosel {

    @Autowired
    RepositoryCarrocel repositorioImagens;

    @PostMapping("/addimagen")
    public ResponseEntity<dtoConfigCarrocelResp> PostImagens(@RequestBody dtoConfgCarrocelPost dtoCarrocel){

        ClassCarrocel imagem = new ClassCarrocel();

        imagem.setLinkImagenCarrocel(dtoCarrocel.getLinkImagenCarrocel());
        imagem.setImagenAtivadaDesativada(dtoCarrocel.getImagenAtivadaDesativada());

        repositorioImagens.save(imagem);

        dtoConfigCarrocelResp dtoRepost =  new dtoConfigCarrocelResp();

        dtoRepost.setcodigoImagem(imagem.getcodigoImagem());
        dtoRepost.setLinkImagenCarrocel(imagem.getLinkImagenCarrocel());
        dtoRepost.setImagenAtivadaDesativada(imagem.getImagenAtivadaDesativada());
         
    
        return ResponseEntity.ok(dtoRepost);
    }

    @GetMapping("/carrocel_imagens")
    public List<dtoConfigCarrocelResp> getImagens(){
        List<ClassCarrocel> imagens = repositorioImagens.findAll();

        return imagens.stream().map(dtoConfigCarrocelResp::new).toList();
    }
    @PutMapping("path/{codigoImagem}")
    public ResponseEntity<dtoConfgCarrocelPost> putAlizarImg(@PathVariable String codigoImagem, @RequestBody dtoConfgCarrocelPost dto) {
        //TODO: process PUT request

        Optional<ClassCarrocel> imagem = repositorioImagens.findByCodigoImagem(codigoImagem); 

        if(imagem.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        ClassCarrocel imgEncontrada = imagem.get();

        imgEncontrada.setLinkImagenCarrocel(dto.getLinkImagenCarrocel());
        imgEncontrada.setImagenAtivadaDesativada(dto.getImagenAtivadaDesativada());
        
    
        repositorioImagens.save(imgEncontrada);

        dtoConfgCarrocelPost dtoResposta = new dtoConfgCarrocelPost();

        dtoResposta.setLinkImagenCarrocel(imgEncontrada.getLinkImagenCarrocel());
        dtoResposta.setImagenAtivadaDesativada(imgEncontrada.getImagenAtivadaDesativada());

        return ResponseEntity.ok(dtoResposta);
    }

    @DeleteMapping("path/{codigoImagem}")
    public ResponseEntity<dtoConfgCarrocelPost> putAlizarImg(@PathVariable String codigoImagem) {

        Optional<ClassCarrocel> imagem = repositorioImagens.findByCodigoImagem(codigoImagem); 

        if(imagem.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        ClassCarrocel imgEncontrada = imagem.get();
        

        repositorioImagens.delete(imgEncontrada);

        dtoConfgCarrocelPost dtoResposta = new dtoConfgCarrocelPost();

        dtoResposta.setLinkImagenCarrocel(imgEncontrada.getLinkImagenCarrocel());
        dtoResposta.setImagenAtivadaDesativada(imgEncontrada.getImagenAtivadaDesativada());

        return ResponseEntity.ok(dtoResposta);
    }
}
