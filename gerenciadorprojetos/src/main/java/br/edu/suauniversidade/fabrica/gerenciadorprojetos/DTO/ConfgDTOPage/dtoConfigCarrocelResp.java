package br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO.ConfgDTOPage;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassConfigPage.ClassCarrocel;

public class dtoConfigCarrocelResp {

    private String codigoImagem;
    private String linkImagenCarrocel;
    private Boolean imagenAtivadaDesativada;

    public dtoConfigCarrocelResp() {

    }

    public dtoConfigCarrocelResp(String linkImagenCarrocel, Boolean imagenAtivadaDesativada) {
        this.linkImagenCarrocel = linkImagenCarrocel;
        this.imagenAtivadaDesativada = imagenAtivadaDesativada;
    }

    public dtoConfigCarrocelResp(ClassCarrocel carrocel) {
        this.codigoImagem = carrocel.getcodigoImagem();
        this.linkImagenCarrocel =  carrocel.getLinkImagenCarrocel();
        this.imagenAtivadaDesativada = carrocel.getImagenAtivadaDesativada();
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
