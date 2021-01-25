package com.query.query.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.query.query.exception.TurmaException;
import com.query.query.model.Turma;
import com.query.query.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;

	public Turma retornaTurma(Integer idTurma) {

		Turma turmaRetorno = turmaRepository.findByIdTurma(idTurma);
		
		if(turmaRetorno == null) {
			
			throw new TurmaException("Turma não encontrada");
		}

		return turmaRetorno;
	}

	public List<Turma> retornaTurma() {

		List<Turma> alunoRetorno = turmaRepository.findAll();

		return alunoRetorno;
	}

}
