package com.query.query.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.query.query.model.Turma;
import com.query.query.service.TurmaService;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping(path = TurmaController.PATH)
@AllArgsConstructor
public class TurmaController {

	
	private final TurmaService turmaService;

	public static final String PATH = "/turma";

	@GetMapping("/{id}")
	public ResponseEntity<Turma> retornaTurma(@PathVariable Integer id) {

		Turma turma = turmaService.retornaTurma(id);

		return ResponseEntity.ok(turma);
	}
	
	
	
	@GetMapping
	public  ResponseEntity<List<Turma>> retornaTurma() {

		List<Turma> turmas = turmaService.retornaTurma();

		return ResponseEntity.ok(turmas);
	}

}
