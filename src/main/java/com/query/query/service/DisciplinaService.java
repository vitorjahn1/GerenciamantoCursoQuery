package com.query.query.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.query.query.exception.DisciplinaException;
import com.query.query.model.Disciplina;
import com.query.query.repository.DisciplinaRepository;

import lombok.AllArgsConstructor;
@Service
@Transactional
@AllArgsConstructor
public class DisciplinaService {

	
	private final DisciplinaRepository disciplinaRepository;

	public Disciplina retornaDisciplina(Integer idDisciplina) {

		Disciplina disciplina = disciplinaRepository.findByIdDisciplina(idDisciplina);
		if(disciplina==null) {
			
			throw new DisciplinaException("Disciplina não encontrada");
		}
		
		return disciplina;
	}

	public List<Disciplina> retornaDisciplinas() {
			
		return disciplinaRepository.findAll();
	}
}
