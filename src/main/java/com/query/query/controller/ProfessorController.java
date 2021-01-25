package com.query.query.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.query.query.model.Professor;
import com.query.query.service.ProfessorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = ProfessorController.PATH)
@AllArgsConstructor
public class ProfessorController {

	
	private final ProfessorService professorService;

	public static final String PATH = "/professor";

	@GetMapping("/{id}")
	public  ResponseEntity<Professor> retornaProfessor(@PathVariable(name = "id") Integer id) {
		Professor professor = professorService.retornaProfessor(id);

		return ResponseEntity.ok(professor);
	}

	@GetMapping
	public ResponseEntity<List<Professor>> retornaProfessor() {
		List<Professor> professores = professorService.retornaProfessores();

		return ResponseEntity.ok(professores);

	}

}
