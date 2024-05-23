package com.example.des.repository;

//Tem um import List desnecessário

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.des.entities.Turma;

public interface TurmaRepository extends JpaRepository <Turma, Long> {

}
