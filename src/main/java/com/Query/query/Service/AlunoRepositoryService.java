package com.Query.query.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Query.query.Model.Aluno;
import com.Query.query.Repository.AlunoRepository;

public class AlunoRepositoryService {

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
