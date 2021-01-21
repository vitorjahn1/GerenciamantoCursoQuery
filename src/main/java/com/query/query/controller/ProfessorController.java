package com.query.query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.query.query.model.Professor;
import com.query.query.service.ProfessorService;

@RestController
@RequestMapping(path = ProfessorController.PATH)
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	public static final String PATH = "/professor";

	@GetMapping("/{id}")
	public Professor retornaProfessor(@PathVariable(name = "id") Integer id) {
		Professor professor = professorService.retornaProfessor(id);

		return professor;
	}

	@GetMapping
	public ResponseEntity<List<Professor>> retornaProfessor() {
		List<Professor> professores = professorService.retornaProfessor();

		return ResponseEntity.ok(professores);

	}

}
