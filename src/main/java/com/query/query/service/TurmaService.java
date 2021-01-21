package com.query.query.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.query.query.model.Turma;
import com.query.query.repository.TurmaRepository;

public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;

	public Turma retornaTurma(Integer idTurma) {

		Turma turmaRetorno = turmaRepository.getOne(idTurma);

		return turmaRetorno;
	}

	public List<Turma> retornaTurma() {

		List<Turma> alunoRetorno = turmaRepository.findAll();

		return alunoRetorno;
	}

}
