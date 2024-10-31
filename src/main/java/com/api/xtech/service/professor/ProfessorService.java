package com.api.xtech.service.professor;

import com.api.xtech.dto.professor.ProfessorAtualizarDTO;
import com.api.xtech.dto.professor.ProfessorCadastrarDTO;
import com.api.xtech.dto.professor.ProfessorExibirDTO;
import com.api.xtech.model.professor.Professor;
import com.api.xtech.repository.professor.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public List<ProfessorExibirDTO> listar() {
        var professores = repository.findAll().stream().map(ProfessorExibirDTO::new).toList();
        return professores;
    }

    @Transactional
    public ResponseEntity<String> cadastrar(ProfessorCadastrarDTO dados) {
        repository.save(new Professor(dados));
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<String> atualizar(ProfessorAtualizarDTO dados, Long id) {
        var professor = repository.getReferenceById(id);
        professor.atualizarInformacoes(dados);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<String> inativar(Long id) {
        var professor = repository.getReferenceById(id);
        professor.inativar();
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<String> ativar(Long id) {
        var professor = repository.getReferenceById(id);
        professor.ativar();
        return ResponseEntity.ok().build();
    }
}
