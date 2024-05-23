package com.example.des.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.des.entities.Aluno;
import com.example.des.services.AlunoServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno") //Adicionar ("/aluno")
public class AlunoController {
	
private final AlunoServico alunoServico; //Mudar o turmaServico para alunoServico
    
    @Autowired
    public AlunoController(AlunoServico alunoService) {
        this.alunoServico = alunoService;
    }
    //Query Method
    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorCidade(@PathVariable String cidade) {
      List<Aluno> alunos = alunoServico.buscarAlunosPorCidade(cidade);
      return ResponseEntity.ok(alunos);
    }
    
    //Query Method
    @GetMapping("/ra/{ra}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorRa(@PathVariable String ra) { //Adicionar o Query Method buscarAlunosPorRa
      List<Aluno> alunos = alunoServico.buscarAlunosPorRa(ra);
      return ResponseEntity.ok(alunos);
    }
   
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getProductById(@PathVariable Long id) {
        Aluno aluno = alunoServico.getAlunoById(id);
        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    public ResponseEntity<List<Aluno>> getAllAlunos() {
        List<Aluno> alunos = alunoServico.getAllAlunos();
        return ResponseEntity.ok(alunos);
    }

    @PostMapping("/")
    public ResponseEntity<Aluno> criarAluno(@RequestBody @Valid Aluno aluno) {
        Aluno criarAluno = alunoServico.salvarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarAluno);
    }
   

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody @Valid Aluno aluno) {
        Aluno updatedAluno = alunoServico.updateAluno(id, aluno);
        if (updatedAluno != null) {
            return ResponseEntity.ok(updatedAluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> deleteAluno(@PathVariable Long id) {
        boolean deleted = alunoServico.deleteAluno(id);
        if (deleted) {
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
