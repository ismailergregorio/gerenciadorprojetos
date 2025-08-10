package br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassGestores;

public class dtoGestoresPost {
    private String name;
    private String descricao;
    private String cursoResposavel;

    private String linkImagenGestor;

    public dtoGestoresPost() {
    }

    public dtoGestoresPost(ClassGestores gestor) {
        this.name = gestor.getName();
        this.cursoResposavel = gestor.getCursoResposavel();
        this.descricao = gestor.getDescricao();
        this.linkImagenGestor = gestor.getLinkImagenGestor();
    }

    public dtoGestoresPost(String name, String cursoResposavel, String descricao, String linkImagenGestor) {
        this.name = name;
        this.cursoResposavel = cursoResposavel;
        this.descricao = descricao;
        this.linkImagenGestor = linkImagenGestor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCursoResposavel() {
        return cursoResposavel;
    }

    public void setCursoResposavel(String cursoResposavel) {
        this.cursoResposavel = cursoResposavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLinkImagenGestor() {
        return linkImagenGestor;
    }

    public void setLinkImagenGestor(String linkImagenGestor) {
        this.linkImagenGestor = linkImagenGestor;
    }
}
