package com.query.query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.query.query.model.Aluno;
import com.query.query.service.AlunoService;

@RestController
@RequestMapping(path = AlunoController.PATH)
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	public static final String PATH = "/aluno";

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> retornaAluno(@PathVariable(name = "id") Integer matricula) {
		
		Aluno aluno = alunoService.retornaAluno(matricula);
		
		if(aluno== null) {
			
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(aluno);
	}

	@GetMapping
	public ResponseEntity<List<Aluno>> retornaAluno() {

		List<Aluno> alunos = alunoService.retornaAluno();
		
		
		
		
		return ResponseEntity.ok(alunos);

	}

}
