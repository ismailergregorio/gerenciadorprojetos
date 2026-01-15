package com.example.API_Fabrica_Software.Model.ClassConfigPage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "db_carrocel")
public class ClassCarrocel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String codigoImagem;
    @Column(columnDefinition = "TEXT")
    private String linkImagenCarrocel;
    private Boolean imagenAtivadaDesativada;

    @PrePersist
    public void GeradorDeCodigoImg(){
        String prefixo = "IMG";
        int numero = (int) (Math.random() * 9000) + 1000;
        this.codigoImagem = prefixo + numero;
    }
}
