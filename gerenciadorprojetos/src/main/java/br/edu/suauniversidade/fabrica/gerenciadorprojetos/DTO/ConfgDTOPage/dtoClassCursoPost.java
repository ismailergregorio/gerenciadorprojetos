package br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage.ClassCursos;


public class dtoClassCursoPost {
    private String nomeDoCurso;

    public dtoClassCursoPost(String nomeDoCurso) {
        this.nomeDoCurso = nomeDoCurso;
    }

    public dtoClassCursoPost() {

    }

    public dtoClassCursoPost(ClassCursos curso) {
        this.nomeDoCurso = curso.getNomeDoCurso();
    }

    public String getNomeDoCurso() {
        return nomeDoCurso;
    }

    public void setNomeDoCurso(String nomeDoCurso) {
        this.nomeDoCurso = nomeDoCurso;
    }
}
