package com.Query.query.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Query.query.Model.Professor;
import com.Query.query.Service.ProfessorRepositoryService;

@RestController
@RequestMapping(path = ProfessorController.PATH)
public class ProfessorController {

	@Autowired
	private ProfessorRepositoryService professorRepositoryService;

	public static final String PATH = "/professor";

	@GetMapping("/{id}")
	public Professor retornaProfessor(@PathVariable(name = "id") Integer id) {
		Professor professor = professorRepositoryService.retornaProfessor(id);

		return professor;
	}

	@GetMapping
	public ResponseEntity<List<Professor>> retornaProfessor() {
		List<Professor> professores = professorRepositoryService.retornaProfessor();

		return ResponseEntity.ok(professores);

	}

}
