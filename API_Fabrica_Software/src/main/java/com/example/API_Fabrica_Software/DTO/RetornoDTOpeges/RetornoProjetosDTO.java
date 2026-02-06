package com.example.API_Fabrica_Software.DTO.RetornoDTOpeges;

import java.time.LocalDate;
import java.util.List;

public record RetornoProjetosDTO(
        String codigoProjeto,
        String nomeDoProjeto,
        String descricaoDoProjeto,
        String areaDeConhecimento,
        List<String> alunosParticipantesDoProjeto,
        List<String> profesorOrientador,
        String linkGit,
        String linkImage) {

}
