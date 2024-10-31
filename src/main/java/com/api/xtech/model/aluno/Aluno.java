package com.api.xtech.model.aluno;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "Aluno")
@Table(name = "alunos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    @NotBlank @Column(name = "nome_pai")
    private String nomePai;

    @NotBlank @Column(name = "telefone_pai")
    private String telefonePai;

    @NotBlank @Column(name = "nome_mae")
    private String nomeMae;

    @NotBlank @Column(name = "telefone_mae")
    private String telefoneMae;

    private String matricula;

    @NotBlank @Column(name = "data_matricula")
    private LocalDate dataMatricula;

}
