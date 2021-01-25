package com.query.query.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.query.query.exception.ProfessorException;
import com.query.query.model.Professor;
import com.query.query.repository.ProfessorRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
@Transactional
public class ProfessorService {
	
	private final ProfessorRepository professorRepository;

	public Professor retornaProfessor(Integer idProfessor) {

		Professor professorRetorno = professorRepository.findByIdProfessor(idProfessor);
		if(professorRetorno==null) {
			
			throw new ProfessorException("Professor não encontrado");
		}
		return professorRetorno;
	}

	public List<Professor> retornaProfessores() {

		return professorRepository.findAll();
	}
}
