package br.edu.suauniversidade.fabrica.gerenciadorprojetos.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.edu.suauniversidade.fabrica.gerenciadorprojetos.Model.ClassProjetos;

//CLASSE DE CRIAÇÃO DE DTO DE PROJETOS PARA LIMITAR OS DADOS PARA O USUARIO 

public class dtoProjetos {
    @JsonProperty(access = Access.READ_ONLY)
    private String identicadorProjetos;
    private String nomeDoProjeto;
    private String descricaoDoProjeto;
    private String areaDeConhecimento;
    private LocalDate dataDeInicioDoProjeto;
    private LocalDate dataDoFimDoProjeto;
    private String alunosParticipantesDoProjeto;
    private String linkGit;
    private String linkImage;

    public dtoProjetos() {

    }

    public dtoProjetos(ClassProjetos classProjetos) {
        this.identicadorProjetos = classProjetos.getIdenticadorProjetos();
        this.nomeDoProjeto = classProjetos.getNomeDoProjeto();
        this.descricaoDoProjeto = classProjetos.getDescricaoDoProjeto();
        this.areaDeConhecimento = classProjetos.getAreaDeConhecimento();
        this.dataDeInicioDoProjeto = classProjetos.getDataDeInicioDoProjeto();
        this.dataDoFimDoProjeto = classProjetos.getDataDoFimDoProjeto();
        this.alunosParticipantesDoProjeto = classProjetos.getAlunosParticipantesDoProjeto();
        this.linkGit = classProjetos.getLinkGit();
        this.linkImage = classProjetos.getLinkImage();
    }

    public String getIdenticadorProjetos() {
        return identicadorProjetos;
    }

    public void setIdenticadorProjetos(String identicadorProjetos) {
        this.identicadorProjetos = identicadorProjetos;
    }

    public String getNomeDoProjeto() {
        return nomeDoProjeto;
    }

    public void setNomeDoProjeto(String nomeDoProjeto) {
        this.nomeDoProjeto = nomeDoProjeto;
    }

    public String getDescricaoDoProjeto() {
        return descricaoDoProjeto;
    }

    public void setDescricaoDoProjeto(String descricaoDoProjeto) {
        this.descricaoDoProjeto = descricaoDoProjeto;
    }

    public String getAreaDeConhecimento() {
        return areaDeConhecimento;
    }

    public void setAreaDeConhecimento(String areaDeConhecimento) {
        this.areaDeConhecimento = areaDeConhecimento;
    }

    public LocalDate getDataDeInicioDoProjeto() {
        return dataDeInicioDoProjeto;
    }

    public void setDataDeInicioDoProjeto(LocalDate dataDeInicioDoProjeto) {
        this.dataDeInicioDoProjeto = dataDeInicioDoProjeto;
    }

    public LocalDate getDataDoFimDoProjeto() {
        return dataDoFimDoProjeto;
    }

    public void setDataDoFimDoProjeto(LocalDate dataDoFimDoProjeto) {
        this.dataDoFimDoProjeto = dataDoFimDoProjeto;
    }

    public String getAlunosParticipantesDoProjeto() {
        return alunosParticipantesDoProjeto;
    }

    public void setAlunosParticipantesDoProjeto(String alunosParticipantesDoProjeto) {
        this.alunosParticipantesDoProjeto = alunosParticipantesDoProjeto;
    }

    public String getLinkGit() {
        return linkGit;
    }

    public void setLinkGit(String linkGit) {
        this.linkGit = linkGit;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }
}
