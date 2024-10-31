package com.api.xtech.model.professor;

import com.api.xtech.dto.professor.ProfessorAtualizarDTO;
import com.api.xtech.dto.professor.ProfessorCadastrarDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "Professor")
@Table(name = "professores")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    private String matricula;

    @Column(name = "data_matricula")
    private LocalDate dataMatricula;

    private Boolean ativo;

    public Professor(ProfessorCadastrarDTO dados) {
        if (dados == null) {
            return;
        }
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.matricula = dados.matricula();
        this.dataMatricula = LocalDate.now();
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid ProfessorAtualizarDTO dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.matricula() != null) {
            this.matricula = dados.matricula();
        }

    }

    public void inativar() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }
}
