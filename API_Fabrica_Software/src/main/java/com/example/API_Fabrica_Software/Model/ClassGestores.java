package com.example.API_Fabrica_Software.Model;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "db_gestores")
public class ClassGestores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String codigoGestor;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String cursoResposavel;
    
    @Column(columnDefinition = "TEXT" ,nullable = false)
    private String descricao;

    @Column(nullable = false, unique = true, columnDefinition = "TEXT")
    private String linkImagenGestor;

    @ManyToMany
    @JoinTable(
        name="db_projetos_gestores",
        joinColumns = {
            @JoinColumn(name = "codigo_gestor", referencedColumnName = "codigoGestor")},
        inverseJoinColumns = {
            @JoinColumn(name = "codigo_projeto",referencedColumnName = "codigoProjeto")
        }
    )
    private List<ClassProjetos> projetos = new ArrayList<>();



    public ClassGestores(Long id, String codigoGestor, String name, String cursoResposavel, String descricao,
            String linkImagenGestor, List<ClassProjetos> projetos) {
        this.id = id;
        this.codigoGestor = codigoGestor;
        this.name = name;
        this.cursoResposavel = cursoResposavel;
        this.descricao = descricao;
        this.linkImagenGestor = linkImagenGestor;
        this.projetos = projetos;
    }
    public ClassGestores() {

    }
    @PrePersist
    public void GeradorDeCodigo(){
        String prefixo = "GEST";
        int numero =  (int) (Math.random() * 9000) + 1000;
        this.codigoGestor = prefixo + numero;
    }
}
