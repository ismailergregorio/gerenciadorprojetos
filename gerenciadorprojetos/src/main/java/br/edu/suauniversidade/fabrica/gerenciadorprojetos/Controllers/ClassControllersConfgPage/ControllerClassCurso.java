package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Controllers.ClassControllersConfgPage;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage.dtoClassCursoPost;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage.dtoClassCursoResp;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage.ClassCursos;
import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Repository.RepositoryConfgSite.RepositoryCurso;

@RestController
@RequestMapping("/curso")
public class ControllerClassCurso {
    @Autowired
    RepositoryCurso repositoryCurso;

    @PostMapping("/curso")
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
    public List<dtoClassCursoResp> GetImagens() {
        List<ClassCursos> dados = repositoryCurso.findAll();
        return dados.stream().map(dtoClassCursoResp::new).toList();
    }

    @GetMapping("/curso/{codigoDoCurso}")
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
    public ResponseEntity<dtoClassCursoResp> DeletImagen(@PathVariable String codigoDoCurso) {
        Optional<ClassCursos> itenSelecionado = repositoryCurso.findByCodigoDoCurso(codigoDoCurso);

        if (itenSelecionado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ClassCursos iten = itenSelecionado.get();

        repositoryCurso.delete(iten);

        dtoClassCursoResp repostaDto = new dtoClassCursoResp();

        repostaDto.setCodigoDoCurso(iten.getCodigoDoCurso());
        repostaDto.setNomeDoCurso(iten.getNomeDoCurso());

        return ResponseEntity.ok(repostaDto);
    }
}
