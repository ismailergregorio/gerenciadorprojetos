package br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage.ClassCarrocel;

public class dtoConfgCarrocelPost {
    private String linkImagenCarrocel;
    private Boolean imagenAtivadaDesativada;

    public dtoConfgCarrocelPost() {

    }

    public dtoConfgCarrocelPost(String linkImagenCarrocel, Boolean imagenAtivadaDesativada) {
        this.linkImagenCarrocel = linkImagenCarrocel;
        this.imagenAtivadaDesativada = imagenAtivadaDesativada;
    }

    public dtoConfgCarrocelPost(ClassCarrocel carrocel) {
        this.linkImagenCarrocel =  carrocel.getLinkImagenCarrocel();
        this.imagenAtivadaDesativada = carrocel.getImagenAtivadaDesativada();
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
