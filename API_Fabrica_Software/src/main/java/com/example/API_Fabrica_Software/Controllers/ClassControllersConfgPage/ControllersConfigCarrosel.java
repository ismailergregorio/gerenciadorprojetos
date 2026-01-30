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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_Fabrica_Software.DTO.ConfgDTOPage.dtoConfgCarrocelPost;
import com.example.API_Fabrica_Software.DTO.ConfgDTOPage.dtoConfigCarrocelResp;
import com.example.API_Fabrica_Software.Exception.ApiError;
import com.example.API_Fabrica_Software.Model.ClassConfigPage.ClassCarrocel;
import com.example.API_Fabrica_Software.Repository.RepositoryConfgSite.RepositoryCarrocel;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/carrocel")
public class ControllersConfigCarrosel {

    @Autowired
    RepositoryCarrocel repositorioImagens;

    @PreAuthorize("hasRole(\"ADMIN\")")
    @PostMapping("/addimagen")
    public ResponseEntity<dtoConfigCarrocelResp> PostImagens(@RequestBody dtoConfgCarrocelPost dtoCarrocel) {

        ClassCarrocel imagem = new ClassCarrocel();

        imagem.setLinkImagenCarrocel(dtoCarrocel.getLinkImagenCarrocel());
        imagem.setImagenAtivadaDesativada(dtoCarrocel.getImagenAtivadaDesativada());

        repositorioImagens.save(imagem);

        dtoConfigCarrocelResp dtoRepost = new dtoConfigCarrocelResp();

        dtoRepost.setcodigoImagem(imagem.getCodigoImagem());
        dtoRepost.setLinkImagenCarrocel(imagem.getLinkImagenCarrocel());
        dtoRepost.setImagenAtivadaDesativada(imagem.getImagenAtivadaDesativada());

        return ResponseEntity.ok(dtoRepost);
    }

    @GetMapping("/carrocel_imagens")
    @PreAuthorize("hasRole(\"ADMIN\")")
    public List<dtoConfigCarrocelResp> getImagens() {
        List<ClassCarrocel> imagens = repositorioImagens.findAll();

        return imagens.stream().map(dtoConfigCarrocelResp::new).toList();
    }
    @PreAuthorize("hasRole(\"ADMIN\")")
    @PutMapping("path/{codigoImagem}")
    public ResponseEntity<?> putAlizarImg(@PathVariable String codigoImagem,
            @RequestBody dtoConfgCarrocelPost dto, HttpServletRequest request) {
        // TODO: process PUT request

        Optional<ClassCarrocel> imagem = repositorioImagens.findByCodigoImagem(codigoImagem);
        if (!imagem.isPresent()) {
            System.out.println("Iten não encontardor");
            return ResponseEntity.status(404).body(
                    new ApiError(
                            LocalDateTime.now(),
                            404,
                            "NOT_FOUND",
                            "Projeto nao encontrado",
                            request.getRequestURI()));
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
    @PreAuthorize("hasRole(\"ADMIN\")")
    @DeleteMapping("path/{codigoImagem}")
    public ResponseEntity<?> putAlizarImg(@PathVariable String codigoImagem, HttpServletRequest request) {

        Optional<ClassCarrocel> imagem = repositorioImagens.findByCodigoImagem(codigoImagem);
        if (!imagem.isPresent()) {
            System.out.println("Iten não encontardor");
            return ResponseEntity.status(404).body(
                    new ApiError(
                            LocalDateTime.now(),
                            404,
                            "NOT_FOUND",
                            "Projeto nao encontrado",
                            request.getRequestURI()));
        }

        ClassCarrocel imgEncontrada = imagem.get();

        repositorioImagens.delete(imgEncontrada);

        dtoConfgCarrocelPost dtoResposta = new dtoConfgCarrocelPost();

        dtoResposta.setLinkImagenCarrocel(imgEncontrada.getLinkImagenCarrocel());
        dtoResposta.setImagenAtivadaDesativada(imgEncontrada.getImagenAtivadaDesativada());

        return ResponseEntity.ok(dtoResposta);
    }
}
