package com.example.des.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "aluno")
public class Aluno {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String nome;
    
    private String ra;
    
    private String email;
    
    private String telefone;
    
    private String cidade;
    
    private double renda;
    
    @ManyToOne
    @JoinColumn(name = "id_turma") //Ajustar de @Column para @JoinColumn
    private Turma turma; //Faltou identificar que Turma pertence a classe turma

}
