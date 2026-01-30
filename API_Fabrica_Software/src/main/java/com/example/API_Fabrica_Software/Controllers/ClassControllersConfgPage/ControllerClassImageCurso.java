package com.example.API_Fabrica_Software.Controllers.ClassControllersConfgPage;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_Fabrica_Software.DTO.ConfgDTOPage.dtoClassImageCursoPost;
import com.example.API_Fabrica_Software.DTO.ConfgDTOPage.dtoClassImageCursoResp;
import com.example.API_Fabrica_Software.Exception.ApiError;
import com.example.API_Fabrica_Software.Model.ClassConfigPage.ClassImageCursos;
import com.example.API_Fabrica_Software.Repository.RepositoryConfgSite.RepositoryImagensCurso;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/imagemcurso")
@CrossOrigin(origins = "*")
public class ControllerClassImageCurso {
    @Autowired
    RepositoryImagensCurso crepositoryImagensCurso;

    @PostMapping("/imagemcurso")
    @PreAuthorize("hasRole(\"ADMIN\")")
    public ResponseEntity<dtoClassImageCursoResp> AddImagenCurso(@RequestBody dtoClassImageCursoPost dto) {
        ClassImageCursos imagen = new ClassImageCursos();

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
    @PreAuthorize("hasRole(\"ADMIN\")")
    public List<dtoClassImageCursoResp> GetImagens() {
        List<ClassImageCursos> dados = crepositoryImagensCurso.findAll();
        return dados.stream().map(dtoClassImageCursoResp::new).toList();
    }

    @GetMapping("/imagemcurso/{codigoImagem}")
    @PreAuthorize("hasRole(\"ADMIN\")")
    public ResponseEntity<?> GetImagen(@PathVariable String codigoImagem, HttpServletRequest request) {
        Optional<ClassImageCursos> imagens = crepositoryImagensCurso.findByCodigoImagem(codigoImagem);
        if (!imagens.isPresent()) {
            System.out.println("Iten não encontardor");
            return ResponseEntity.status(404).body(
                    new ApiError(
                            LocalDateTime.now(),
                            404,
                            "NOT_FOUND",
                            "Projeto nao encontrado",
                            request.getRequestURI()));
        }

        ClassImageCursos imagen = imagens.get();
        dtoClassImageCursoResp repostaDto = new dtoClassImageCursoResp();

        repostaDto.setCodigoImagem(imagen.getCodigoImagem());
        repostaDto.setLinkImagemCurso(imagen.getLinkImagemCurso());
        repostaDto.setAltImagem(imagen.getAltImagem());

        return ResponseEntity.ok(repostaDto);
    }

    @DeleteMapping("/imagemcurso/{codigoImagem}")
    @PreAuthorize("hasRole(\"ADMIN\")")
    public ResponseEntity<?> DeletImagen(@PathVariable String codigoImagem, HttpServletRequest request) {
        Optional<ClassImageCursos> itenSelecionado = crepositoryImagensCurso.findByCodigoImagem(codigoImagem);

        if (!itenSelecionado.isPresent()) {
            System.out.println("Iten não encontardor");
            return ResponseEntity.status(404).body(
                    new ApiError(
                            LocalDateTime.now(),
                            404,
                            "NOT_FOUND",
                            "Projeto nao encontrado",
                            request.getRequestURI()));
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
