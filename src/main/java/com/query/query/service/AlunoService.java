package com.query.query.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.query.query.model.Aluno;
import com.query.query.repository.AlunoRepository;

public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public Aluno retornaAluno(Integer matricula) {

		Aluno alunoRetorno = alunoRepository.getOne(matricula);

		return alunoRetorno;
	}

	public List<Aluno> retornaAluno() {

		List<Aluno> alunoRetorno = alunoRepository.findAll();

		return alunoRetorno;
	}

}
