package com.Query.query.Dto;

import java.util.HashSet;
import java.util.Set;

import com.Query.query.Model.Professor;
import com.Query.query.Model.Turma;

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
