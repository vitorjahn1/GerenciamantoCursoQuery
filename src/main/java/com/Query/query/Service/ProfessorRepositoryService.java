package com.Query.query.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Query.query.Model.Professor;
import com.Query.query.Repository.ProfessorRepository;

public class ProfessorRepositoryService {
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
