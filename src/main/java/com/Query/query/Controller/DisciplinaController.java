package com.Query.query.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Query.query.Model.Disciplina;
import com.Query.query.Service.DisciplinaRepositoryService;

@CrossOrigin
@RestController
@RequestMapping(path = DisciplinaController.PATH)
public class DisciplinaController {
	@Autowired
	private DisciplinaRepositoryService disciplinaRepositoryService;

	public static final String PATH = "/disciplina";

	@GetMapping("/{id}")
	public ResponseEntity<Disciplina> retornaDisciplina(@PathVariable Integer id) {

		Disciplina disciplina = disciplinaRepositoryService.retornaDisciplina(id);

		return ResponseEntity.ok(disciplina);
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<Disciplina>> retornaDisciplina() {

		List<Disciplina>disciplinas = disciplinaRepositoryService.retornaDisciplina();

		return ResponseEntity.ok(disciplinas);
	}

}
