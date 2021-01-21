package com.query.query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.query.query.model.Disciplina;
import com.query.query.service.DisciplinaService;

@CrossOrigin
@RestController
@RequestMapping(path = DisciplinaController.PATH)
public class DisciplinaController {
	@Autowired
	private DisciplinaService disciplinaService;

	public static final String PATH = "/disciplina";

	@GetMapping("/{id}")
	public ResponseEntity<Disciplina> retornaDisciplina(@PathVariable Integer id) {

		Disciplina disciplina = disciplinaService.retornaDisciplina(id);

		return ResponseEntity.ok(disciplina);
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<Disciplina>> retornaDisciplina() {

		List<Disciplina>disciplinas = disciplinaService.retornaDisciplina();

		return ResponseEntity.ok(disciplinas);
	}

}
