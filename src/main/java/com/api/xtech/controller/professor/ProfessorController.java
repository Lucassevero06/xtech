package com.api.xtech.controller.professor;

import com.api.xtech.dto.professor.ProfessorAtualizarDTO;
import com.api.xtech.dto.professor.ProfessorCadastrarDTO;
import com.api.xtech.dto.professor.ProfessorExibirDTO;
import com.api.xtech.service.professor.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
@Validated
public class ProfessorController {

    @Autowired
    private ProfessorService service;

    @GetMapping
    public ResponseEntity<List<ProfessorExibirDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody @Valid ProfessorCadastrarDTO dados) {
        service.cadastrar(dados);
        return ResponseEntity.ok("Professor cadastrado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@RequestBody ProfessorAtualizarDTO dados, @PathVariable Long id) {
        service.atualizar(dados, id);
        return ResponseEntity.ok("Professor atualizado com sucesso!");
    }

    @DeleteMapping("/{id}/inativar")
    public ResponseEntity inativar(@PathVariable Long id) {
        service.inativar(id);
        return ResponseEntity.ok("Professor inativado com sucesso!");
    }

    @PutMapping("/{id}/ativar")
    public ResponseEntity ativar(@PathVariable Long id) {
        service.ativar(id);
        return ResponseEntity.ok("Professor ativado com sucesso!");
    }

}
