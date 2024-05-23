package com.example.des.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.des.entities.Aluno;
import com.example.des.repository.AlunoRepository;

@Service
public class AlunoServico {
	
private final AlunoRepository alunoRepository; //Trocar os dois para alunorepository
    
    @Autowired
    public AlunoServico(AlunoRepository alunoRepository) { //Mudar para AlunoRepository
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno getAlunoById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElse(null);
    }
    //Query Method 
    public List<Aluno> buscarAlunosPorCidade(String cidade) {
        return alunoRepository.findByCidade(cidade); 
    }
    
  //Query Method 
    public List<Aluno> buscarAlunosPorRa(String ra) { //Adicionar o findByRa
        return alunoRepository.findByRa(ra); 
    }
   
    //APAGAR A MAIORIA DOS QUERY E QUERY METHODS
   
    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno); //Mudar .salvar para .save
    }

    public Aluno updateAluno(Long id, Aluno updatedAluno) {
        Optional<Aluno> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) { //Mudar .isPresente para .isPresent
            updatedAluno.setId(id);
            return alunoRepository.save(updatedAluno);
        }
        return null;
    }

    public boolean deleteAluno(Long id) {
        Optional<Aluno> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) { //Mudar .isPresente para .isPresent
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
