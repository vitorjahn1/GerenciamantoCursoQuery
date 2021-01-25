package com.query.query.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.query.query.exception.AlunoException;
import com.query.query.model.Aluno;
import com.query.query.repository.AlunoRepository;
@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public Aluno retornaAluno(Integer matricula) {

		Aluno alunoRetorno = alunoRepository.findByMatricula(matricula);
		if(alunoRetorno==null) {
			
		throw new AlunoException("Aluno não encontrado");
			
		}
		return alunoRetorno;
	}

	public List<Aluno> retornaAluno() {

		List<Aluno> alunoRetorno = alunoRepository.findAll();

		return alunoRetorno;
	}

}
