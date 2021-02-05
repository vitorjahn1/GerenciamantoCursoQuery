package com.query.query.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.query.query.dto.ProfessorDto;
import com.query.query.dtoresposta.ProfessorDtoResposta;
import com.query.query.exception.ProfessorException;
import com.query.query.model.Professor;
import com.query.query.repository.ProfessorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class ProfessorService {

	private final ProfessorRepository professorRepository;
	
	public ProfessorDtoResposta retornaProfessor(Integer idProfessor) {

		Professor professorRetorno = professorRepository.findByIdProfessor(idProfessor);

		if (professorRetorno == null)
			throw new ProfessorException("Professor não encontrado");

		return criarProfessoDtoResposta(professorRetorno);
	}

	public List<ProfessorDtoResposta> retornaProfessores() {

		List<ProfessorDtoResposta> professoresDtoResposta = new ArrayList<>();

		for (Professor professor : professorRepository.findAll()) {
			if (professor == null) {

				continue;
			}
			professoresDtoResposta.add(criarProfessoDtoResposta(professor));
		}

		return professoresDtoResposta;
	}

	public ProfessorDto criarProfessoDto(Professor professor) {

		ProfessorDto professorDto = new ProfessorDto();

		professorDto.setCpf(professor.getCpf());
		professorDto.setEmail(professor.getEmail());
		professorDto.setNome(professor.getNome());
		professorDto.setTitulacao(professor.getTitulacao());
		professorDto.setIdPessoa(professor.getIdPessoa());
		professorDto.setIdProfessor(professor.getIdProfessor());
		return professorDto;
	}
	
	public ProfessorDtoResposta criarProfessoDtoResposta(Professor professor) {

		ProfessorDtoResposta professorDtoResposta = new ProfessorDtoResposta();

		professorDtoResposta.setCpf(professor.getCpf());
		professorDtoResposta.setEmail(professor.getEmail());
		professorDtoResposta.setNome(professor.getNome());
		professorDtoResposta.setTitulacao(professor.getTitulacao());
		professorDtoResposta.setIdPessoa(professor.getIdPessoa());
		professorDtoResposta.setIdProfessor(professor.getIdProfessor());
		return professorDtoResposta;
	}
}
