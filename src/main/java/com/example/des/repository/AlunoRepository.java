package com.example.des.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.des.entities.Aluno;

public interface AlunoRepository extends JpaRepository <Aluno, Long> {
	//Mudar de ProdutoRepository para AlunoRepository
	//Query Methods
		List<Aluno>findByCidade(String cidade);
		List<Aluno>findByRa(String ra); //Ajustar essa funcionalidade adicionando List
		
}
