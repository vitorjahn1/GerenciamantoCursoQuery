package com.query.query.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.query.query.exception.AlunoException;
import com.query.query.model.Aluno;
import com.query.query.repository.AlunoRepository;

import lombok.AllArgsConstructor;
@Service
@Transactional
@AllArgsConstructor
public class AlunoService {

	
	private final AlunoRepository alunoRepository;

	public Aluno retornaAluno(Integer matricula) {

		Aluno alunoRetorno = alunoRepository.findByMatricula(matricula);
		if(alunoRetorno==null) {
			
		throw new AlunoException("Aluno não encontrado");
			
		}
		return alunoRetorno;
	}

	public List<Aluno> retornaAlunos() {


		return alunoRepository.findAll();
	}

}
