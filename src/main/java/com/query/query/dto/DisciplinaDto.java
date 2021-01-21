package com.query.query.dto;

import java.util.HashSet;
import java.util.Set;

import com.query.query.model.Professor;
import com.query.query.model.Turma;

import lombok.Data;

@Data
public class DisciplinaDto {

	private Integer idDisciplina;
	
	private String descricao;
	
	private String cargaHoraria;
	
	private String sigla;
	
	private Turma turmas;

	private Set<Professor> professores = new HashSet<>();

}
