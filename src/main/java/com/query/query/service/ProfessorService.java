package com.query.query.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.query.query.dto.ProfessorDto;
import com.query.query.exception.ProfessorException;
import com.query.query.model.Professor;
import com.query.query.repository.ProfessorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class ProfessorService {

	private final ProfessorRepository professorRepository;

	public ProfessorDto retornaProfessor(Integer idProfessor) {

		Professor professorRetorno = professorRepository.findByIdProfessor(idProfessor);

		if (professorRetorno == null)
			throw new ProfessorException("Professor não encontrado");

		return criarProfessoDto(professorRetorno);
	}

	public List<ProfessorDto> retornaProfessores() {

		List<ProfessorDto> professoresDto = new ArrayList<>();

		for (Professor professor : professorRepository.findAll()) {
			if (professor == null) {

				continue;
			}
			professoresDto.add(criarProfessoDto(professor));
		}

		return professoresDto;
	}

	public ProfessorDto criarProfessoDto(Professor professor) {

		ProfessorDto professorDto = new ProfessorDto();

		professorDto.setCpf(professor.getCpf());
		professorDto.setEmail(professor.getEmail());
		professorDto.setNome(professor.getNome());
		professorDto.setTitulacao(professor.getTitulacao());

		return professorDto;
	}
}
