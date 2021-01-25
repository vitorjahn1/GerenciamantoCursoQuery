package com.query.query.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.query.query.model.Disciplina;
import com.query.query.service.DisciplinaService;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping(path = DisciplinaController.PATH)
@AllArgsConstructor
public class DisciplinaController {
	
	private final DisciplinaService disciplinaService;

	public static final String PATH = "/disciplina";

	@GetMapping("/{id}")
	public ResponseEntity<Disciplina> retornaDisciplina(@PathVariable Integer id) {

		Disciplina disciplina = disciplinaService.retornaDisciplina(id);

		return ResponseEntity.ok(disciplina);
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<Disciplina>> retornaDisciplina() {

		List<Disciplina>disciplinas = disciplinaService.retornaDisciplinas();

		return ResponseEntity.ok(disciplinas);
	}

}
