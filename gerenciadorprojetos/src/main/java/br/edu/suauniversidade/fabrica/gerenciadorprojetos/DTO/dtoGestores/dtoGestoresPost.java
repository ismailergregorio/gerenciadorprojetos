package br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.dtoGestores;

import java.util.List;

public class dtoGestoresPost {
    private String name;
    private String descricao;
    private String cursoResposavel;
    private List<String> projetos;
    private String linkImagenGestor;

    public dtoGestoresPost() {
    }

    public dtoGestoresPost(String name, String descricao, String cursoResposavel, List<String> projetos,
            String linkImagenGestor) {
        this.name = name;
        this.descricao = descricao;
        this.cursoResposavel = cursoResposavel;
        this.projetos = projetos;
        this.linkImagenGestor = linkImagenGestor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCursoResposavel() {
        return cursoResposavel;
    }

    public void setCursoResposavel(String cursoResposavel) {
        this.cursoResposavel = cursoResposavel;
    }

    public List<String> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<String> projetos) {
        this.projetos = projetos;
    }

    public String getLinkImagenGestor() {
        return linkImagenGestor;
    }

    public void setLinkImagenGestor(String linkImagenGestor) {
        this.linkImagenGestor = linkImagenGestor;
    }

}
