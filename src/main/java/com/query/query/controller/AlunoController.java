package com.query.query.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.query.query.model.Aluno;
import com.query.query.service.AlunoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = AlunoController.PATH)
@AllArgsConstructor
public class AlunoController {

	
	private final AlunoService alunoService;

	public static final String PATH = "/aluno";

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> retornaAluno(@PathVariable(name = "id") Integer matricula) {
		
		Aluno aluno = alunoService.retornaAluno(matricula);
		
		
		return ResponseEntity.ok(aluno);
	}

	@GetMapping
	public ResponseEntity<List<Aluno>> retornaAluno() {
		List<Aluno> alunos = alunoService.retornaAlunos();
		
		return ResponseEntity.ok(alunos);

	}

}
