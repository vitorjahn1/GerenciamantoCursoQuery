package com.query.query.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.query.query.exception.TurmaException;
import com.query.query.model.Turma;
import com.query.query.repository.TurmaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class TurmaService {
	
	
	private final TurmaRepository turmaRepository;

	public Turma retornaTurma(Integer idTurma) {

		Turma turmaRetorno = turmaRepository.findByIdTurma(idTurma);
		
		if(turmaRetorno == null) {
			
			throw new TurmaException("Turma não encontrada");
		}

		return turmaRetorno;
	}

	public List<Turma> retornaTurma() {
		
		return turmaRepository.findAll();
	}

}
