package com.query.query.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.query.query.model.Disciplina;
import com.query.query.repository.DisciplinaRepository;

public class DisciplinaService {

	@Autowired
	DisciplinaRepository disciplinaRepository;

	public Disciplina retornaDisciplina(Integer idDisciplina) {

		Disciplina disciplina = disciplinaRepository.getOne(idDisciplina);
		return disciplina;
	}

	public List<Disciplina> retornaDisciplina() {

		List<Disciplina> disciplina = disciplinaRepository.findAll();
		return disciplina;
	}
}
