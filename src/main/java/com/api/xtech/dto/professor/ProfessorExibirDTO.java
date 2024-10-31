package com.api.xtech.dto.professor;

import com.api.xtech.model.professor.Professor;

public record ProfessorExibirDTO(
    Long id,
    String nome,
    String telefone,
    String email,
    String matricula,
    Boolean ativo
) {
    public ProfessorExibirDTO(Professor dados) {
        this(dados.getId(), dados.getNome(), dados.getTelefone(), dados.getEmail(), dados.getMatricula(), dados.getAtivo());
    }
}
