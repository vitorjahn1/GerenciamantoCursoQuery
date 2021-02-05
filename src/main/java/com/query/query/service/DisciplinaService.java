package com.query.query.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.query.query.dto.DisciplinaDto;
import com.query.query.dto.ProfessorDto;
import com.query.query.dtoresposta.DisciplinaDtoResposta;
import com.query.query.dtoresposta.ProfessorDtoResposta;
import com.query.query.exception.DisciplinaException;
import com.query.query.model.Disciplina;
import com.query.query.model.Professor;
import com.query.query.repository.DisciplinaRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class DisciplinaService {

	private final DisciplinaRepository disciplinaRepository;

	private final ProfessorService professorService;

	public DisciplinaDtoResposta retornaDisciplina(Integer idDisciplina) {

		Disciplina disciplina = disciplinaRepository.findByIdDisciplina(idDisciplina);

		if (disciplina == null)
			throw new DisciplinaException("Disciplina não encontrada");

		return criarDisciplinaDtoResposta(disciplina);
	}

	public List<DisciplinaDtoResposta> retornaDisciplinas() {
		List<DisciplinaDtoResposta> alunosDtoResposta = new ArrayList<>();
		for (Disciplina disciplina : disciplinaRepository.findAll()) {
			if (disciplina == null) {
				continue;
			}
			alunosDtoResposta.add(criarDisciplinaDtoResposta(disciplina));
		}

		return alunosDtoResposta;
	}

	public DisciplinaDto criarDisciplinaDto(Disciplina disciplina) {

		DisciplinaDto disciplinaDto = new DisciplinaDto();
		disciplinaDto.setDescricao(disciplina.getDescricao());
		disciplinaDto.setCargaHoraria(disciplina.getCargaHoraria());
		disciplinaDto.setSigla(disciplina.getSigla());
		disciplinaDto.setIdDisciplina(disciplina.getIdDisciplina());
		disciplinaDto.setProfessores(criaListaProfessorDto(disciplina.getProfessores()));
		return disciplinaDto;
	}

	public DisciplinaDtoResposta criarDisciplinaDtoResposta(Disciplina disciplina) {

		DisciplinaDtoResposta disciplinaDtoResposta = new DisciplinaDtoResposta();
		disciplinaDtoResposta.setDescricao(disciplina.getDescricao());
		disciplinaDtoResposta.setCargaHoraria(disciplina.getCargaHoraria());
		disciplinaDtoResposta.setSigla(disciplina.getSigla());
		disciplinaDtoResposta.setIdDisciplina(disciplina.getIdDisciplina());
		disciplinaDtoResposta.setProfessores(criaListaProfessorDtoResposta(disciplina.getProfessores()));
		return disciplinaDtoResposta;
	}

	private Set<ProfessorDtoResposta> criaListaProfessorDtoResposta(Set<Professor> professores) {

		Set<ProfessorDtoResposta> professoresDtoResposta = new HashSet<>();

		if (!professores.isEmpty()) {
			for (Professor professor : professores) {
				professoresDtoResposta.add(professorService.criarProfessoDtoResposta(professor));
			}
			return professoresDtoResposta;
		} else {
			return professoresDtoResposta;
		}

	}

	private Set<ProfessorDto> criaListaProfessorDto(Set<Professor> professores) {

		Set<ProfessorDto> professoresDto = new HashSet<>();

		if (!professores.isEmpty()) {
			for (Professor professor : professores) {
				professoresDto.add(professorService.criarProfessoDto(professor));
			}
			return professoresDto;
		} else {
			return professoresDto;
		}

	}
}
