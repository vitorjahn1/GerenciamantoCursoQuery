package com.query.query.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.query.query.dto.DisciplinaDto;
import com.query.query.exception.DisciplinaException;
import com.query.query.model.Disciplina;
import com.query.query.repository.DisciplinaRepository;

import lombok.AllArgsConstructor;
@Service
@Transactional
@AllArgsConstructor
public class DisciplinaService {

	
	private final DisciplinaRepository disciplinaRepository;

	public DisciplinaDto retornaDisciplina(Integer idDisciplina) {

		Disciplina disciplina = disciplinaRepository.findByIdDisciplina(idDisciplina);
		if(disciplina==null) {
			
			throw new DisciplinaException("Disciplina não encontrada");
		}
		
		return criarDisciplinaDto(disciplina);
	}

	public List<DisciplinaDto> retornaDisciplinas() {
		List<DisciplinaDto> alunosDto = new ArrayList<DisciplinaDto>();	
		for(Disciplina disciplina: disciplinaRepository.findAll()) {
			if(disciplina == null) {
				continue;
			}
			alunosDto.add(criarDisciplinaDto(disciplina));
		}
		
		return alunosDto;
	}
	
	public DisciplinaDto criarDisciplinaDto (Disciplina disciplina) {
		
		DisciplinaDto disciplinaDto = new DisciplinaDto();
		disciplinaDto.setProfessores(disciplina.getProfessores());
		disciplinaDto.setDescricao(disciplina.getDescricao());
		disciplinaDto.setCargaHoraria(disciplina.getCargaHoraria());
		disciplinaDto.setSigla(disciplina.getSigla());
		disciplinaDto.setTurmas(disciplina.getTurmas());
		
		return disciplinaDto;
	}
	
}
