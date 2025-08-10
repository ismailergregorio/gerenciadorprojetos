package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Controllers.ClassControllersConfgPage;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage.dtoClassImageCursoPost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage.dtoClassImageCursoResp;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage.ClassImageCursos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryConfgSite.RepositoryImagensCurso;


@RestController
@RequestMapping("/imagemcurso")
@CrossOrigin(origins = "*")
public class ControllerClassImageCurso {
    @Autowired
    RepositoryImagensCurso crepositoryImagensCurso;

    @PostMapping("/imagemcurso")
    public ResponseEntity<dtoClassImageCursoResp> AddImagenCurso(@RequestBody dtoClassImageCursoPost dto){
        ClassImageCursos imagen =  new ClassImageCursos();

        imagen.setLinkImagemCurso(dto.getLinkImagemCurso());
        imagen.setAltImagem(dto.getAltImagem());

        crepositoryImagensCurso.save(imagen);

        dtoClassImageCursoResp dtoResposta = new dtoClassImageCursoResp();

        dtoResposta.setCodigoImagem(imagen.getCodigoImagem());
        dtoResposta.setAltImagem(imagen.getAltImagem());
        dtoResposta.setLinkImagemCurso(imagen.getLinkImagemCurso());

        return ResponseEntity.ok(dtoResposta);
    }

    @GetMapping("/imagemcurso")
    public List<dtoClassImageCursoResp> GetImagens(){
        List<ClassImageCursos> dados = crepositoryImagensCurso.findAll();
        return dados.stream().map(dtoClassImageCursoResp::new).toList();
    }

    @GetMapping("/imagemcurso/{codigoImagem}")
    public ResponseEntity<dtoClassImageCursoResp> GetImagen(@PathVariable String codigoImagem){
        Optional<ClassImageCursos> imagens = crepositoryImagensCurso.findByCodigoImagem(codigoImagem);
        if(imagens.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        ClassImageCursos imagen = imagens.get();
        dtoClassImageCursoResp repostaDto =  new dtoClassImageCursoResp();

        repostaDto.setCodigoImagem(imagen.getCodigoImagem());
        repostaDto.setLinkImagemCurso(imagen.getLinkImagemCurso());
        repostaDto.setAltImagem(imagen.getAltImagem());

        return ResponseEntity.ok(repostaDto);
    }
    @DeleteMapping("/imagemcurso/{codigoImagem}")
    public ResponseEntity<dtoClassImageCursoResp> DeletImagen(@PathVariable String codigoImagem){
        Optional<ClassImageCursos> itenSelecionado =  crepositoryImagensCurso.findByCodigoImagem(codigoImagem);

        if(itenSelecionado.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        ClassImageCursos iten = itenSelecionado.get();

        crepositoryImagensCurso.delete(iten);

        dtoClassImageCursoResp itensDeletado = new dtoClassImageCursoResp();

        itensDeletado.setCodigoImagem(iten.getCodigoImagem());
        itensDeletado.setLinkImagemCurso(iten.getLinkImagemCurso());
        itensDeletado.setAltImagem(iten.getAltImagem());
        return ResponseEntity.ok(itensDeletado);
    }
}
