package com.query.query.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.query.query.model.Professor;
import com.query.query.repository.ProfessorRepository;

public class ProfessorService {
	@Autowired
	private ProfessorRepository professorRepository;

	public Professor retornaProfessor(Integer idProfessor) {

		Professor turmaRetorno = professorRepository.getOne(idProfessor);

		return turmaRetorno;
	}

	public List<Professor> retornaProfessor() {

		List<Professor> professorRetorno = professorRepository.findAll();

		return professorRetorno;
	}
}
