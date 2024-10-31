package com.api.xtech.dto.professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ProfessorCadastrarDTO(
        @NotBlank(message = "Nome obrigatório")
        String nome,

        @NotBlank(message = "CPF obrigatório")
        String cpf,

        @NotBlank(message = "Telefone obrigatório")
        String telefone,

        @NotBlank(message = "Email obrigatório") @Email(message = "O Email precisa ser um email válido")
        String email,

        @NotBlank
        String matricula,

        String dataMatricula
) {
}
