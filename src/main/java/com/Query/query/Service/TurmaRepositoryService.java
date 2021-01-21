package com.Query.query.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Query.query.Model.Turma;
import com.Query.query.Repository.TurmaRepository;

public class TurmaRepositoryService {
	
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
