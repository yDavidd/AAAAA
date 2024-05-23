package com.example.des.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.des.entities.Turma;
import com.example.des.repository.TurmaRepository;

@Service
public class TurmaServico {
	
private final TurmaRepository turmaRepository; //Mudar de alunoRepostory para turmaRepository
    
    @Autowired
    public TurmaServico(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public List<Turma> getAllTurmas() {
        return turmaRepository.findAll();
    }

    public Turma getTurmaById(Long id) {
        Optional<Turma> turma = turmaRepository.findById(id);
        return turma.orElse(null);
    }

    public Turma salvarTurma(Turma turma) {
        return turmaRepository.save(turma); //Mudar o .salvar para .save
    }

    public Turma updateTurma(Long id, Turma updatedTurma) {
        Optional<Turma> existingTurma = turmaRepository.findById(id);
        if (existingTurma.isPresent()) { //Mudar o .isPresente para .isPresent
            updatedTurma.setId(id);
            return turmaRepository.save(updatedTurma);
        }
        return null;
    }

    public boolean deleteTurma(Long id) {
        Optional<Turma> existingTurma = turmaRepository.findById(id);
        if (existingTurma.isPresent()) { //Mudar o .isPresente para .isPresent
            turmaRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
