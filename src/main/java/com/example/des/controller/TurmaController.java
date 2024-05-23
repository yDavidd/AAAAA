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

import com.example.des.entities.Turma;
import com.example.des.services.TurmaServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/turma") //Adicionar ("/turma")
public class TurmaController {
	
	private final TurmaServico turmaServico;

	@Autowired
	public TurmaController(TurmaServico turmaServico) {
		this.turmaServico = turmaServico;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turma> buscaTurmaControlId(@PathVariable Long id) {
		Turma turma = turmaServico.getTurmaById(id); //Mudar o nome da funcionalidade para .getTurmaById
		if (turma != null) {
			return ResponseEntity.ok(turma);
		} else 
			return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping
	public ResponseEntity<List<Turma>> buscaTodosTurmaControl() {
		List<Turma> Turma = turmaServico.getAllTurmas(); //Mudar o nome da funcionalidade para .getAllTurmas
		return ResponseEntity.ok(Turma);
	}

	@PostMapping
	public ResponseEntity<Turma> salvaTurmaControl(@RequestBody @Valid Turma turma) {
		Turma salvaTurma = turmaServico.salvarTurma(turma); //Mudar o nome da funcionalidade para .salvarTurma
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaTurma);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Turma> alterarTurmaControl(@PathVariable Long id, @RequestBody @Valid Turma turma) {
		Turma alterarTurma = turmaServico.updateTurma(id, turma); //Mudar o nome da funcionalidade para .updateTurma
		if (alterarTurma != null) {
			return ResponseEntity.ok(turma);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Turma> apagaTurmaControl(@PathVariable Long id) {
		boolean apagar = turmaServico.deleteTurma(id); //Mudar o nome da funcionalidade para .deleteTurma
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
