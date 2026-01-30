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

import com.example.API_Fabrica_Software.DTO.ConfgDTOPage.dtoClassCursoPost;
import com.example.API_Fabrica_Software.DTO.ConfgDTOPage.dtoClassCursoResp;
import com.example.API_Fabrica_Software.Exception.ApiError;
import com.example.API_Fabrica_Software.Model.ClassConfigPage.ClassCursos;
import com.example.API_Fabrica_Software.Repository.RepositoryConfgSite.RepositoryCurso;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/curso")
@CrossOrigin(origins = "*")
public class ControllerClassCurso {
    @Autowired
    RepositoryCurso repositoryCurso;

    @PostMapping("/curso")
    @PreAuthorize("hasRole(\"ADMIN\")")
    public ResponseEntity<dtoClassCursoResp> AddImagenCurso(@RequestBody dtoClassCursoPost dto) {
        ClassCursos curso = new ClassCursos();

        curso.setNomeDoCurso(dto.getNomeDoCurso());

        repositoryCurso.save(curso);

        dtoClassCursoResp dtoResposta = new dtoClassCursoResp();

        dtoResposta.setCodigoDoCurso(curso.getCodigoDoCurso());
        dtoResposta.setNomeDoCurso(curso.getNomeDoCurso());

        return ResponseEntity.ok(dtoResposta);
    }

    @GetMapping("/curso")
    @PreAuthorize("hasRole(\"ADMIN\")")
    public List<dtoClassCursoResp> GetImagens() {
        List<ClassCursos> dados = repositoryCurso.findAll();
        return dados.stream().map(dtoClassCursoResp::new).toList();
    }

    @GetMapping("/curso/{codigoDoCurso}")
    @PreAuthorize("hasRole(\"ADMIN\")")
    public ResponseEntity<dtoClassCursoResp> GetImagen(@PathVariable String codigoDoCurso) {
        Optional<ClassCursos> curso = repositoryCurso.findByCodigoDoCurso(codigoDoCurso);
        if (curso.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ClassCursos cursos = curso.get();
        dtoClassCursoResp repostaDto = new dtoClassCursoResp();

        repostaDto.setCodigoDoCurso(cursos.getCodigoDoCurso());
        repostaDto.setNomeDoCurso(cursos.getNomeDoCurso());

        return ResponseEntity.ok(repostaDto);
    }

    @DeleteMapping("/curso/{codigoDoCurso}")
    @PreAuthorize("hasRole(\"ADMIN\")")
    public ResponseEntity<?> DeletImagen(@PathVariable String codigoDoCurso,HttpServletRequest request) {
        Optional<ClassCursos> itenSelecionado = repositoryCurso.findByCodigoDoCurso(codigoDoCurso);

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

        ClassCursos iten = itenSelecionado.get();

        repositoryCurso.delete(iten);

        dtoClassCursoResp repostaDto = new dtoClassCursoResp();

        repostaDto.setCodigoDoCurso(iten.getCodigoDoCurso());
        repostaDto.setNomeDoCurso(iten.getNomeDoCurso());

        return ResponseEntity.ok(repostaDto);
    }
}
