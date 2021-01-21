package com.Query.query.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Query.query.Model.Disciplina;
import com.Query.query.Repository.DisciplinaRepository;

public class DisciplinaRepositoryService {

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
