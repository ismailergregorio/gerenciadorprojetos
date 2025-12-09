package br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
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

    public ClassCarrocel(Long id, String codigoImagem, String linkImagenCarrocel,
            Boolean imagenAtivadaDesativada) {
        this.id = id;
        this.codigoImagem = codigoImagem;
        this.linkImagenCarrocel = linkImagenCarrocel;
        this.imagenAtivadaDesativada = imagenAtivadaDesativada;
    }

    public ClassCarrocel() {

    }
    @PrePersist
    public void GeradorDeCodigoImg(){
        String prefixo = "IMG";
        int numero = (int) (Math.random() * 9000) + 1000;
        this.codigoImagem = prefixo + numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcodigoImagem() {
        return codigoImagem;
    }

    public void setcodigoImagem(String codigoImagem) {
        this.codigoImagem = codigoImagem;
    }


    public String getLinkImagenCarrocel() {
        return linkImagenCarrocel;
    }

    public void setLinkImagenCarrocel(String linkImagenCarrocel) {
        this.linkImagenCarrocel = linkImagenCarrocel;
    }

    public Boolean getImagenAtivadaDesativada() {
        return imagenAtivadaDesativada;
    }

    public void setImagenAtivadaDesativada(Boolean imagenAtivadaDesativada) {
        this.imagenAtivadaDesativada = imagenAtivadaDesativada;
    }
}
