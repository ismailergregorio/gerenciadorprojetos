package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "db_gestores")
public class ClassGestores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String codigoGestor;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String cursoResposavel;
    private String descricao;
    @Column(nullable = false, unique = true)
    private String linkImagenGestor;

    public ClassGestores(Long id, String codigoGestor, String name, String cursoResposavel, String descricao,
            String linkImagenGestor) {
        this.id = id;
        this.codigoGestor = codigoGestor;
        this.name = name;
        this.cursoResposavel = cursoResposavel;
        this.descricao = descricao;
        this.linkImagenGestor = linkImagenGestor;
    }

    public ClassGestores() {

    }
    @PrePersist
    public void GeradorDeCodigo(){
        String prefixo = "GEST";
        int numero =  (int) (Math.random() * 9000) + 1000;
        this.codigoGestor = prefixo + numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoGestor() {
        return codigoGestor;
    }

    public void setCodigoGestor(String codigoGestor) {
        this.codigoGestor = codigoGestor;
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
