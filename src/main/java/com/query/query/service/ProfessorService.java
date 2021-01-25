package com.query.query.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.query.query.exception.ProfessorException;
import com.query.query.model.Professor;
import com.query.query.repository.ProfessorRepository;


@Service
public class ProfessorService {
	@Autowired
	private ProfessorRepository professorRepository;

	public Professor retornaProfessor(Integer idProfessor) {

		Professor professorRetorno = professorRepository.findByIdProfessor(idProfessor);
		if(professorRetorno==null) {
			
			throw new ProfessorException("Professor não encontrado");
		}
		return professorRetorno;
	}

	public List<Professor> retornaProfessor() {

		List<Professor> professorRetorno = professorRepository.findAll();

		return professorRetorno;
	}
}
